package com.somecoders.uim.transport.UNS;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioDatagramChannel;

import java.net.InetAddress;
import java.net.InetSocketAddress;

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
            InetSocketAddress address = new InetSocketAddress(this.port);
            final NioEventLoopGroup group = new NioEventLoopGroup();
            this.bootstrap.group(group).channel(NioDatagramChannel.class)
                .option(ChannelOption.SO_BROADCAST, true)
                .handler(new ChannelInitializer<NioDatagramChannel>() {
                    @Override
                    public void initChannel(final NioDatagramChannel ch) {
                        ChannelPipeline p = ch.pipeline();
//                        p.addLast(new Encoder());
                        p.addLast(new Decoder());
                        p.addLast(new ServerHandler());
                    }
                }).localAddress(address);

            this.udpChannel = this.bootstrap.bind().syncUninterruptibly().channel();
            System.out.print("Server start");
            System.out.print(address);
            this.udpChannel.closeFuture().await();
            System.out.print("Server Finally");
        } catch (InterruptedException e) {

        } finally {
            System.out.print("Server Finally");
        }
    }

    public static void main(String[] args) throws Exception {
        new Server(33221).start();
    }
}