package com.somecoders.uim.transport.UNS;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;



public class ServerHandler extends  SimpleChannelInboundHandler<UNSData> {
    @Override
    public void channelRead0(ChannelHandlerContext channelHandlerContext, UNSData data) throws Exception {
        System.out.println("read");
    }
}