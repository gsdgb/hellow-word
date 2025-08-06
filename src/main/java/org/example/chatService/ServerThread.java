package org.example.chatService;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;

public class ServerThread extends Thread{
    private Socket socket;
    public ServerThread(Socket socket){
        this.socket = socket;
    }
    @Override
    public void run() {
        try {
            DataInputStream dis = new DataInputStream(socket.getInputStream()); 
            while (true) {
                int type = dis.readInt();//1 表示登录,2 表示群聊,3 表示私聊
                switch (type) {
                    case 1 -> {
                        // 获取登录名
                        String username = dis.readUTF();
                        // 将用户名和socket对象存入map中
                        Server.onlineUserSocket.put(socket, username);
                        //更新在线人数列表
                        updateClientUserList();
                    }
                    case 2 -> {//群聊
                        String message = dis.readUTF();
                        sendMsgToAll(message);
                    }
                    case 3 -> {
                    }
                }
            }
        } catch (Exception e){
            System.out.println("客户端下线了");
            Server.onlineUserSocket.remove(socket);
            updateClientUserList();//更新在线人数列表
        }
    }
    private void sendMsgToAll(String message) {
        //拼消息
        StringBuilder sb = new StringBuilder();
        String name = Server.onlineUserSocket.get(socket);//获取当前用户名

        //获取当前时间
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss EEE");
        String nowTime = now.format(formatter);

        String msg = sb.append(name).append(" ").append("说: (").append(nowTime).append(")").append("\r\n")
                .append(message).append("\r\n").toString();

        for (Socket socket : Server.onlineUserSocket.keySet()) {
            try {
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
                dos.writeInt(2);// 区分消息
                dos.writeUTF(msg);
                dos.flush();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // 更新在线人数列表
    private void updateClientUserList() {

        Collection<String> onLineUser = Server.onlineUserSocket.values();
        for (Socket socket : Server.onlineUserSocket.keySet()) {
            try {
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
                dos.writeInt(1);// 区分消息
                dos.writeInt(onLineUser.size());// 在线人数
                for (String user :onLineUser) {
                    dos.writeUTF(user);
                }
                dos.flush();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
