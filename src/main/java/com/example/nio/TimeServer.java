package com.example.nio;

public class TimeServer {
    public static void main(String[] args){
        int port = 8080;
        if(args != null && args.length > 0 ){
            try {
                port = Integer.valueOf(args[0]);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        MultiplexerTimeServer multiplexerTimeServer = new MultiplexerTimeServer(port);
        new Thread(multiplexerTimeServer,"NIO-MultiplexerTimeServer-001").start();
    }
}
