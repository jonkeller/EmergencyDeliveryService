package com.codetheroad.eds.data;

import android.content.res.AssetManager;

/**
 * Created by Jon on 6/23/2015.
 */
public abstract class ServerConnection {
    public static ServerConnection connect(AssetManager am) {
        return new MockServerConnection(am);
    }

    public abstract Vehicle getVehicle() throws Exception;
}
