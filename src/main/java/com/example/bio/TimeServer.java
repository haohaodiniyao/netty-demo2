package com.example.bio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TimeServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        try{
            serverSocket = new ServerSocket(8080);
            System.out.println("服务端启动，端口：8080");
            Socket socket = null;
            while (true){
                socket = serverSocket.accept();
                new Thread(new TimeServerHandler(socket)).start();
            }
        }catch (Exception e){

        }finally {
            serverSocket.close();
            serverSocket = null;
        }
    }
}
