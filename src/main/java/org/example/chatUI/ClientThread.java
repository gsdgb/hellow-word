package org.example.chatUI;

import java.io.DataInputStream;
import java.net.Socket;

public class ClientThread extends Thread{
    private Socket socket;
    private DataInputStream dis;
    private CenteredChatFram win;
    public ClientThread(Socket socket , CenteredChatFram win){
        this.socket = socket;
        this.win = win;
    }
    @Override
    public void run() {
        try {
            //接受消息类型，1，在线人数更新数据，2，群聊消息，3表示私聊消息
            dis = new DataInputStream(socket.getInputStream());
            while (true) {
                int type = dis.readInt();
                switch (type) {
                    case 1 -> {
                        updateClientUserList();
                    }
                    case 2 -> {//群聊
                        getMsgToWin();
                    }
                    case 3 -> {
                    }
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private void getMsgToWin() throws Exception {
        //获取群聊消息
        String message = dis.readUTF();
        win.setMessage(message);
    }

    private void updateClientUserList() throws Exception{
        //1.更新在线人数列表
        int count = dis.readInt();
        //2,循环控制读取多少用户信息
        String[] names = new String[count];
        for (int i = 0; i < count; i++) {
            String name = dis.readUTF();
            names[i] = name;
        }
        //3.更新到窗口左侧
        win.updateOnlineUserList(names);
    }
}
