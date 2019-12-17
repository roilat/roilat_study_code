package cn.roilat.framework.core.netty;

import org.springframework.stereotype.Service;

import cn.roilat.framework.core.netty.handler.H5TokenHandler;
import cn.roilat.framework.core.netty.handler.NettyServerHandler;
import cn.roilat.framework.core.netty.handler.WhiteIPFilterHandler;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpResponseEncoder;

@Service
public class NettyHandlersInitalizer extends ChannelInitializer<SocketChannel> {



    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();

        // server端发送的是httpResponse，所以要使用HttpResponseEncoder进行编码
        pipeline.addLast(new HttpResponseEncoder());
        // server端接收到的是httpRequest，所以要使用HttpRequestDecoder进行解码
        pipeline.addLast(new HttpRequestDecoder());
        pipeline.addLast("aggregator", new HttpObjectAggregator(1024 * 1024 * 64));// 将
        pipeline.addLast(new WhiteIPFilterHandler());
        // 解码到的多个http消息合成一个FullHttpRequest/FullHttpRespone
        pipeline.addLast(new H5TokenHandler());
        //pipeline.addLast(new DownloadHandler());
        pipeline.addLast(new NettyServerHandler());
    }

}
