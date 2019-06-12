package com.somecoders.uim.transport.UNS;

import java.net.InetSocketAddress;

public final class UNSData {
    public static final byte SEPARATOR = (byte) ':';

    private final InetSocketAddress source;
    private final int shortId;

    public UNSData() {
        this(null, -1);
    }

    public UNSData(InetSocketAddress source, int shortId) {  //2
        this.source = source;
        this.shortId = shortId;
    }

    public InetSocketAddress getSource() { //3
        return source;
    }

    public int shortId() {  //5
        return this.shortId;
    }
}
