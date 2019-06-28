package com.somecoders.uim.transport.UNS;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;
import io.netty.buffer.ByteBuf;

import io.netty.channel.socket.DatagramPacket;
import java.util.List;

public class Decoder extends MessageToMessageDecoder<DatagramPacket> {
    @Override
    protected void decode(ChannelHandlerContext ctx, DatagramPacket datagramPacket, List<Object> out) throws Exception {
//        byte[] data = datagramPacket.toString();
        System.out.println("decode");
//        System.out.println(data.toString());
        out.add(new UNSData());
    }
}