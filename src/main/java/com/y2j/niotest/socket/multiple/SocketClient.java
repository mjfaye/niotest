package com.y2j.niotest.socket.multiple;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class SocketClient {
    public static void main(String[] args) {
        try {
            for (int i = 1; i <= 1000000000; i++) {
                sendMessage("发送第" + i + "个消息。。。");
                //sendMessage("发送第" + i + "个消息。。。");
                //sendMessage("同时发送第1个消息");

                //Thread.sleep(2000);
                //sendMessage("同时发送第2个消息");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void sendMessage(String message)
    {
        try {
            // 要连接的服务端IP地址和端口
            String host = "127.0.0.1";
            int port = 65358;
            // 与服务端建立连接
            Socket socket = new Socket(host, port);
            // 建立连接后获得输出流
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write(message.getBytes("UTF-8"));
            outputStream.close();
            //socket.close();
           // socket.shutdownOutput();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
