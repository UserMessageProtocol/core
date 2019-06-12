package com.somecoders.uim.transport.UNS;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;
import io.netty.buffer.ByteBuf;

import java.net.DatagramPacket;
import java.util.List;

public class Decoder extends MessageToMessageDecoder<DatagramPacket> {
    @Override
    protected void decode(ChannelHandlerContext ctx, DatagramPacket datagramPacket, List<Object> out) throws Exception {
        byte[] data = datagramPacket.getData();
        System.out.println("decode");
        System.out.println(data.toString());
        out.add(new UNSData());
    }
}