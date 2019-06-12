package com.somecoders.uim.transport.UNS;

import java.util.ArrayList;
import java.net.*;
import java.io.IOException;

public class Broadcaster {
    private UserIpStrack userIpStrack;

    static public void broadcast(int shortId, ArrayList<InetAddress> ips) {
        try {
            for (int i = 0; i < ips.size(); i++) {
                DatagramSocket socket = new DatagramSocket();
                byte[] buffer = ("short id :" + shortId).getBytes();
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length, ips.get(i), 33251);
                System.out.print("send start");
                System.out.print(ips.get(i));
                socket.send(packet);
                System.out.print(buffer.toString());
            }
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {

        } catch (IOException e) {

        }
    }

    public static void main(String[] args) throws Exception {
        ArrayList<InetAddress> ips = new ArrayList<InetAddress>();
        ips.add(InetAddress.getLocalHost());
        Broadcaster.broadcast(666, ips);
    }
}
