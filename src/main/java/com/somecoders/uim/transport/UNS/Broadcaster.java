package com.somecoders.uim.transport.UNS;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioDatagramChannel;

import java.net.InetSocketAddress;
import java.util.ArrayList;

public class Broadcaster {
    static public void broadcast(int shortId, ArrayList<InetSocketAddress> ips) {
        try {
            final NioEventLoopGroup group = new NioEventLoopGroup();
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(group)
                .channel(NioDatagramChannel.class)
                .option(ChannelOption.SO_BROADCAST, true)
                .handler(new Encoder());
            Channel ch = bootstrap.bind(0).syncUninterruptibly().channel();
            for (int i = 0; i < ips.size(); i++) {
                ch.writeAndFlush(new UNSData(ips.get(i), shortId));
            }
            group.shutdownGracefully();
        } finally {
            System.out.println("broadcast ok");
        }
    }

    public static void main(String[] args) throws Exception {
        ArrayList<InetSocketAddress> ips = new ArrayList<InetSocketAddress>();
//        ips.add(new InetSocketAddress(33251));
        ips.add(new InetSocketAddress(33221));
        Broadcaster.broadcast(666, ips);
    }
}
