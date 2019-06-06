package cn.roilat.framework.core.netty.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.FullHttpRequest;

public class WhiteIPFilterHandler extends BaseHandler<FullHttpRequest> {
	@Override
	public void readData(ChannelHandlerContext ctx, FullHttpRequest msg) {
		ctx.fireChannelRead(msg);
	}
}
