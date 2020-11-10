package com.example.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.util.CharsetUtil;

public class MyInboundHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("ChannelInboundHandler 处于就绪状态，可以被读写------线程"+Thread.currentThread().toString());
        super.channelActive(ctx);
    }

    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        System.out.println("ChannelInboundHandler 被注册到 EventLoop------线程"+Thread.currentThread().toString());
        super.channelRegistered(ctx);
    }

    @Override
    public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
        System.out.println("ChannelInboundHandler 从 EventLoop 中取消注册------线程"+Thread.currentThread().toString());
        super.channelUnregistered(ctx);
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("ChannelInboundHandler 处于非就绪状态Channel 可以从远端读取到数据------线程"+Thread.currentThread().toString());
        super.channelInactive(ctx);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        FullHttpRequest fullHttpRequest = (FullHttpRequest) msg;
        String content = String.format("Receive http request,uri:%s,method:%s,content:%s%n",fullHttpRequest.getUri(),fullHttpRequest.getMethod(),fullHttpRequest.content().toString(CharsetUtil.UTF_8));

        System.out.println("ChannelInboundHandler 可以从远端读取到数据-----content="+content);
        super.channelRead(ctx, msg);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        System.out.println("ChannelInboundHandler 读取数据完成------线程"+Thread.currentThread().toString());
        super.channelReadComplete(ctx);
    }

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        System.out.println("ChannelInboundHandler 用户事件触发时------线程"+Thread.currentThread().toString());
        super.userEventTriggered(ctx, evt);
    }

    @Override
    public void channelWritabilityChanged(ChannelHandlerContext ctx) throws Exception {
        System.out.println("ChannelInboundHandler 的写状态发生变化------线程"+Thread.currentThread().toString());
        super.channelWritabilityChanged(ctx);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println("ChannelInboundHandler ------线程"+Thread.currentThread().toString());
        super.exceptionCaught(ctx, cause);
    }
}
