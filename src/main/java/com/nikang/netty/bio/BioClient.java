package com.nikang.netty.bio;

import java.io.OutputStream;
import java.net.Socket;
import java.util.UUID;

public class BioClient {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 8080);
            OutputStream ops = socket.getOutputStream();
            String name = UUID.randomUUID().toString();
            System.out.println("client send data:"+name);
            ops.write(name.getBytes());
            ops.close();
            socket.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
