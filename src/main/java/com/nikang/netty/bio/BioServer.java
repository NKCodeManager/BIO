package com.nikang.netty.bio;

import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class BioServer {

    ServerSocket serverSocket;

    public BioServer(int port) {
        try{
            serverSocket = new ServerSocket();
            serverSocket.bind(new InetSocketAddress(port));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void listen() throws Exception{
        while(true){
            Socket socket = serverSocket.accept();
            InputStream inputStream = socket.getInputStream();
            byte [] bytes = new byte[1024];
            int len = inputStream.read(bytes);
            if(len>0){
                String msg = new String(bytes,0,len);
                System.out.println("接受消息："+msg);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new BioServer(8080).listen();
    }
}
