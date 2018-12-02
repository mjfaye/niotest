package com.y2j.niotest.socket.MultipleThread;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SocketClient {

    public static void main(String[] args) {

        //如果使用多线程，那就需要线程池，防止并发过高时创建过多线程耗尽资源
        ExecutorService threadPool = Executors.newFixedThreadPool(100);
        try {
            for (int i = 1; i <= 10; i++) {
                Runnable runnable = new Runnable() {
                    int i;
                    @Override
                    public void run() {
                        try {
                            sendMessage("发送第" + i + "个消息。。。");
                            Thread.sleep(Long.valueOf(i + "000"));
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                };
                threadPool.submit(runnable);
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
            int port = 55533;
            // 与服务端建立连接
            Socket socket = new Socket(host, port);
            // 建立连接后获得输出流
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write(message.getBytes("UTF-8"));
            outputStream.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
