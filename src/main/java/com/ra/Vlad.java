package com.ra;


import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;
import com.hazelcast.core.IQueue;

import java.text.SimpleDateFormat;

public class Vlad {
    public static void main(String[] args) {

        ClientConfig clientConfig = new ClientConfig();
        HazelcastInstance client = HazelcastClient.newHazelcastClient(clientConfig);


        IMap<Integer, String> map = client.getMap("VladMap");
        map.put(1, "Vlad");
        map.put(2, "Sergey");
        map.put(3, "Kolya");

        System.out.println("Map size: " + map.size());
        String name = map.remove(2);
        System.out.println("Map size: " + map.size());

        IQueue<String> queue = client.getQueue("VladQueue");
        queue.add(name);
        System.out.println("Queue size: " + queue.size());
        name = queue.poll();
        System.out.println("Queue size: " + queue.size() + ", " + "name: " + name);

        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").
                format(map.getEntryView(1).getCreationTime()));



    }
}
