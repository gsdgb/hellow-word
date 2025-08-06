package org.example.chatService;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class Server {
    public static final Map<Socket,String> onlineUserSocket = new HashMap<>();
    public static void main(String[] args) {
        System.out.println("服务端启动----");
        //1.注册端口
        try {
            ServerSocket serverSocket = new ServerSocket(Constant.port);
            while (true) {
                System.out.println("等待客户端连接...");
                Socket socket = serverSocket.accept();
                // 创建线程
                new ServerThread(socket).start();
                System.out.println("客户端连接成功");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
