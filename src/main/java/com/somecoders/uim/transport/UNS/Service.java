package com.somecoders.uim.transport.UNS;


public class Service {
    private Server server;
    private Broadcaster broadcaster;

    public Service() {
        this.server = new Server(11234);
        this.broadcaster = new Broadcaster();
    }

    public void startServer()  {
        try {
            this.server.start();
        } finally {

        }
    }

//    public void lookForUserActiveIp(Integer shortId) {
//        this.udpChannel.writeAndFlush(new UNSData());
//    }
//
//    public void refreshUserActiveIp(Integer shortId) {
//        this.broadcaster.refreshUserActiveIp();
//    }

    public static void main(String[] args) throws Exception {
        new Service().startServer();
    }
}
