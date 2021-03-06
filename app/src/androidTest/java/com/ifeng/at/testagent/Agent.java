package com.ifeng.at.testagent;

import android.os.Bundle;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.ifeng.at.testagent.reflect.ReflectionHandler;
import com.ifeng.at.testagent.rpc.RpcClient;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;

/**
 * Owner lixintong
 */
@RunWith(AndroidJUnit4.class)
public class Agent {
    public static final String ARG_HOST = "host";
    public static final String ARG_PORT = "port";
    public static final String ARG_DEVICE_ID = "id";
    private String host;
    private int port;
    private String id;

    @Before
    public void setUp() {
        Bundle arguments = InstrumentationRegistry.getArguments();
        host = arguments.getString(ARG_HOST);
        port = Integer.parseInt(arguments.getString(ARG_PORT));
        id = arguments.getString(ARG_DEVICE_ID);
    }

    @Test
    public void start() throws IOException {
        //start RPC Client
        RpcClient rpcClient = new RpcClient();
        rpcClient.addHandler(1, new RPCRequestHandler());
        rpcClient.addHandler(2, new ReflectionHandler());
        rpcClient.startAndBlock(host, port, id);
    }

}
