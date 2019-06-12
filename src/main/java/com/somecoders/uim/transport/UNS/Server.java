package com.somecoders.uim.transport.UNS;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioDatagramChannel;

import java.net.InetAddress;

public class Server {
    private Integer port;
    private Bootstrap bootstrap;
    private Channel udpChannel;

    public Server(Integer port) {
        this.port = port;
    }

    public void start()  {
        try {
            this.bootstrap = new Bootstrap();
            final NioEventLoopGroup group = new NioEventLoopGroup();
            this.bootstrap.group(group).channel(NioDatagramChannel.class)
                .option(ChannelOption.SO_BROADCAST, true)
                .handler(new ChannelInitializer<NioDatagramChannel>() {
                    @Override
                    public void initChannel(final NioDatagramChannel ch) throws Exception {
                        ChannelPipeline p = ch.pipeline();
                        p.addLast(new Decoder());
                        p.addLast(new ServerHandler());
                        System.out.print("bind ok");
                    }
                });

            this.udpChannel = this.bootstrap.bind(this.port).sync().channel();
            System.out.print("Server start");
            this.udpChannel.closeFuture().await();
        } catch (InterruptedException e) {

        } finally {
            System.out.print("Server Finally");
        }
    }

    public static void main(String[] args) throws Exception {
        new Server(33251).start();
    }
}