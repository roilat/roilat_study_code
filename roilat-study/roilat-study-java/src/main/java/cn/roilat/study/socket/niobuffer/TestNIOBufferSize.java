package cn.roilat.study.socket.niobuffer;

import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class TestNIOBufferSize {

	public static void main(String[] args) {

	}
	
	public static void start() {
		try {
			while (true) {
				Selector selector = null;
				selector.select();
				Iterator<SelectionKey> it = selector.selectedKeys().iterator();
				while (it.hasNext()) {
					SelectionKey key = it.next();
					it.remove();

					if (key.isAcceptable()) {

						ServerSocketChannel server2 = (ServerSocketChannel) key.channel();
						SocketChannel channel = server2.accept();
						channel.configureBlocking(false);
						channel.register(selector, SelectionKey.OP_READ);

						System.out.println("客户端连接：" + ":" + channel.socket().getInetAddress().getHostName() + ":"
								+ channel.socket().getPort());

					} else if (key.isReadable()) {

						SocketChannel channel = (SocketChannel) key.channel();

						ByteBuffer buffer = ByteBuffer.allocate(1024);
						channel.read(buffer);
						buffer.flip();
						//String msg = decoder.decode(buffer).toString();
					}
				}
			}
		} catch (Exception e) {

		}
	}

}
