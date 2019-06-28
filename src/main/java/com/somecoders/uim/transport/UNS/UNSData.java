package com.somecoders.uim.transport.UNS;

import java.net.InetSocketAddress;

public final class UNSData {
    private final InetSocketAddress remoteAddress;
    private final int shortId;

    public UNSData() {
        this(null, -1);
    }

    public UNSData(InetSocketAddress remoteAddress, int shortId) {  //2
        this.remoteAddress = remoteAddress;
        this.shortId = shortId;
    }

    public InetSocketAddress remoteAddress() { //3
        return remoteAddress;
    }

    public int shortId() {  //5
        return this.shortId;
    }
}
