package com.codetheroad.eds.data;

/**
 * Created by Jon on 6/23/2015.
 */
public abstract class ServerConnection {
    public ServerConnection connect() {
        return new MockServerConnection();
    }

    public abstract Vehicle getVehicle() throws Exception;
}
