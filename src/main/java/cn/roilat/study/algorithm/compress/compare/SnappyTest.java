package cn.roilat.study.algorithm.compress.compare;

import org.openjdk.jmh.annotations.Benchmark;
import org.xerial.snappy.SnappyFramedOutputStream;
import org.xerial.snappy.SnappyOutputStream;

import java.io.IOException;
import java.io.OutputStream;

/**
 * Snappy library tests
 */
public class SnappyTest extends TestParent {

    @Benchmark
    public int snappyNormalOutput() throws Exception
    {
        return baseBenchmark(new StreamFactory() {
            @Override
            public OutputStream getStream(OutputStream underlyingStream) {
                return new SnappyOutputStream( underlyingStream, 65536 );
            }
        });
    }

    @Benchmark
    public int snappyFramedOutput() throws Exception
    {
        return baseBenchmark(new StreamFactory() {
            @Override
            public OutputStream getStream(OutputStream underlyingStream) throws IOException {
                return new SnappyFramedOutputStream( underlyingStream );
            }
        });
    }
}
