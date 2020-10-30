package com.example.bio;

import org.springframework.context.annotation.Primary;

import java.io.*;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeServerHandler implements Runnable {
    private Socket socket;

    public TimeServerHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        BufferedReader bufferedReader = null;
        PrintWriter printWriter = null;
        try{
            InputStream inputStream = this.socket.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            bufferedReader = new BufferedReader(inputStreamReader);
            String body = null;
            while(true){
                body = bufferedReader.readLine();
                if(body == null){
                    break;
                }
                System.out.println("服务端收到："+body);
                String currentDateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
                printWriter = new PrintWriter(this.socket.getOutputStream(),true);
                printWriter.println(currentDateTime);
            }
        }catch (Exception e){
            if(bufferedReader != null){
                try {
                    bufferedReader.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
            if(printWriter == null){
                printWriter.close();
                printWriter = null;
            }
            if(this.socket == null){
                try {
                    this.socket.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                this.socket = null;
            }
        }
    }
}
