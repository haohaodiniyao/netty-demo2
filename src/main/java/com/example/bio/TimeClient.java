package com.example.bio;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class TimeClient {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("127.0.0.1",8080);
        PrintWriter printWriter = new PrintWriter(socket.getOutputStream(),true);
        printWriter.println("current datetime");
        System.out.println("发送服务端，成功");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String body = bufferedReader.readLine();
        System.out.println("收到服务端响应："+body);
        printWriter.close();
        bufferedReader.close();
        socket.close();
    }
}
