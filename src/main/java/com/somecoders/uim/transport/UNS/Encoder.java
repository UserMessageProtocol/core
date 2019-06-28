package com.somecoders.uim.transport.UNS;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.socket.DatagramPacket;
import io.netty.handler.codec.MessageToMessageEncoder;

import java.net.InetSocketAddress;
import java.util.List;

public class Encoder extends MessageToMessageEncoder<UNSData> {

    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, UNSData data, List<Object> out) {
        InetSocketAddress remoteAddress = data.remoteAddress();
        byte[] dataBytes = ("short id :" + data.shortId()).getBytes();
        ByteBuf buffer = channelHandlerContext.alloc().buffer(dataBytes.length);
        buffer.writeBytes(dataBytes);
        System.out.println("encode");
        System.out.println(new DatagramPacket(buffer, remoteAddress));
        out.add(new DatagramPacket(buffer, remoteAddress));
    }
}
