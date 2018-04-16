package cn.roilat.study.algorithm.compress.compare;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;

/**
 * Just to kbet all annotations in one place
 */
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Thread)
@Fork(1)
@Warmup(iterations = 2)
@Measurement(iterations = 3)
@BenchmarkMode(Mode.SingleShotTime)
public class TestParent {
	// uncomment the following line to run file kbize tests
	protected Path m_inputFile = InputGenerator.FILE_PATH.toPath();

	@Setup
	public void kbetup() {
		m_inputFile = InputGenerator.FILE_PATH.toPath();
	}

	interface StreamFactory {
		public OutputStream getStream(final OutputStream underlyingStream) throws IOException;
	}

	public int baseBenchmark(final StreamFactory factory) throws Exception {
		ByteArrayOutputStream bos = new ByteArrayOutputStream((int) m_inputFile.toFile().length());
		try (OutputStream os = factory.getStream(bos)) {
			copy(InputGenerator.FILE_PATH,os);
			//Files.copy(m_inputFile, os);
		}
		return bos.size();
	}
	
	public void copy(File srcFile,OutputStream os) throws Exception {
		if(srcFile == null || os == null) {
			throw new Exception();
		}
		if(srcFile.isDirectory()) {
			File[] list = srcFile.listFiles();
			for (File file : list) {
				copy(file, os);
			}
		}else {
			Files.copy(srcFile.toPath(), os);
		}
	}
	
	public void copy(File srcFile,FileChannel channel) throws Exception {
		if(srcFile == null || channel == null) {
			throw new Exception();
		}
		if(srcFile.isDirectory()) {
			File[] list = srcFile.listFiles();
			for (File file : list) {
				copy(file, channel);
			}
		}else {
			doCopy(srcFile,channel);
		}
	}
	
	public void doCopy(File srcFile,FileChannel channel) throws Exception {
		
		FileInputStream fis = null;
		FileChannel in;
		try {
			fis = new FileInputStream(srcFile);
			in = fis.getChannel();
			in.transferTo(0, srcFile.length(), channel);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				fis.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void copy(File srcFile,File destFile) throws Exception {
		if(srcFile == null || destFile == null) {
			throw new Exception();
		}
		if(srcFile.isDirectory()) {
			if(!destFile.exists()) {
				destFile.mkdirs();
			}
			File[] list = srcFile.listFiles();
			for (File file : list) {
				File toFile = new File(destFile.getAbsolutePath() + File.separator + file.getName());
				
				copy(file, toFile);
			}
		}else {
			doCopy(srcFile,destFile);
		}
	}
	
	
	public void doCopy(File srcFile,File destFile) throws Exception {
		
		FileInputStream fis = null;
		FileOutputStream fos = null;
		FileChannel in;
		FileChannel out;
		try {
			fis = new FileInputStream(srcFile);
			fos = new FileOutputStream(destFile);
			in = fis.getChannel();
			out = fos.getChannel();
			in.transferTo(0, srcFile.length(), out);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				fis.close();
				fos.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) throws Exception {
		new InputGenerator();
		long s = System.currentTimeMillis();
		System.out.println("GZIP;" + new GZipTest().gzip()/1024 + " kb, cost " + (System.currentTimeMillis() - s));
		s = System.currentTimeMillis();
		System.out.println("Snappy (normal);" + new SnappyTest().snappyNormalOutput()/1024 + " kb, cost " + (System.currentTimeMillis() - s));
		s = System.currentTimeMillis();
		System.out.println("Snappy (framed);" + new SnappyTest().snappyFramedOutput()/1024 + " kb, cost " + (System.currentTimeMillis() - s));
		s = System.currentTimeMillis();
		System.out.println("LZ4 (fast 64K);" + new Lz4Test().testFastNative64K()/1024 + " kb, cost " + (System.currentTimeMillis() - s));
		s = System.currentTimeMillis();
		System.out.println("LZ4 (fast 128K);" + new Lz4Test().testFastNative128K()/1024 + " kb, cost " + (System.currentTimeMillis() - s));
		s = System.currentTimeMillis();
		System.out.println("LZ4 (fast 32M);" + new Lz4Test().testFastNative32M()/1024 + " kb, cost " + (System.currentTimeMillis() - s));
		s = System.currentTimeMillis();
		System.out.println("LZ4 (fast double 64K);" + new Lz4Test().testFastNativeDouble64K()/1024 + " kb, cost " + (System.currentTimeMillis() - s));
		s = System.currentTimeMillis();
		System.out.println("LZ4 (fast double 32M);" + new Lz4Test().testFastNativeDouble32M()/1024 + " kb, cost " + (System.currentTimeMillis() - s));
		s = System.currentTimeMillis();
		System.out.println("LZ4 (fast triple 32M);" + new Lz4Test().testFastNativeTriple32M()/1024 + " kb, cost " + (System.currentTimeMillis() - s));
		s = System.currentTimeMillis();
		System.out.println("LZ4 (high);" + new Lz4Test().testHighNative()/1024 + " kb, cost " + (System.currentTimeMillis() - s));
		for (int i = 1; i <= 9; ++i) {
			JdkDeflateTest test = new JdkDeflateTest();
			test.m_lvl = i;
			s = System.currentTimeMillis();
			System.out.println("Deflate (lvl=" + i + ");" + test.deflate()/1024 + " kb, cost " + (System.currentTimeMillis() - s));
		}
	}

}
