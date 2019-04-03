package cn.roilat.study.socket.iobuffer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.Charset;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.filter.executor.ExecutorFilter;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.SocketAcceptor;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;

public class TestSocketIOBufferServer {
    private static SocketAcceptor acceptor;

    public static void startSalaryServer() throws IOException {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        acceptor = new NioSocketAcceptor(Runtime.getRuntime().availableProcessors() + 1);
        acceptor.getFilterChain().addLast("executor", new ExecutorFilter(executor));

        TextLineCodecFactory listenerLine = new TextLineCodecFactory(Charset.forName("GBK"));
        acceptor.getFilterChain().addLast("codec", new ProtocolCodecFilter(listenerLine));
        acceptor.getFilterChain().addLast("logger", new LoggingFilter());

        acceptor.setHandler(new IoHandlerAdapter() {

            @Override
            public void messageReceived(IoSession session, Object message) throws Exception {
                System.out.println("message=" + message);
                super.messageReceived(session, message);
            }
        });
        acceptor.getSessionConfig().setReadBufferSize(10);
        acceptor.getSessionConfig().setMaxReadBufferSize(64);
        acceptor.getSessionConfig().setReceiveBufferSize(10);
        acceptor.getSessionConfig().setSendBufferSize(64);
        acceptor.getSessionConfig().setIdleTime(IdleStatus.BOTH_IDLE, 10);
        acceptor.bind(new InetSocketAddress("127.0.0.1", 6776));
        // System.out.println("快贷移动端端口" + ConstantsApplication.FC_PORT + "启用......");
    }

    public static void main(String[] args) throws IOException {
        startSalaryServer();
    }

}
