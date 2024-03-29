package com.ra;

import com.hazelcast.config.Config;
import com.hazelcast.core.Client;
import com.hazelcast.core.ClientListener;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

public class MyMain2 {
    public static void main(String[] args) {

        Config config = new Config();

        HazelcastInstance server = Hazelcast.newHazelcastInstance(config);
        server.getClientService().addClientListener(new ClientListener() {
            public void clientConnected(Client client) {
                System.out.println(client.getClientType() + ", " + client.getUuid() + " is connected!!!");
            }

            public void clientDisconnected(Client client) {
                System.out.println(client.getClientType() + ", " + client.getUuid() + " is disconnected!!!");
            }
        });

    }
}
