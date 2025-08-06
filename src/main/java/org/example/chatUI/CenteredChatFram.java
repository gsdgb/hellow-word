package org.example.chatUI;

import javax.swing.*;
import java.awt.*;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class CenteredChatFram extends JFrame {
    private JTextArea chatArea;
    private JTextArea chatSend;
//    private JTextField inputField;
    public JList<String> userList = new JList<>();
    private Socket socket;
    public CenteredChatFram() {
        initUI();
        this.setVisible(true);
    }
    public CenteredChatFram(String name, Socket socket){
        this();
        this.socket = socket;
        this.setTitle(name + "的聊天室");
        //立即把客户端的Socket管道交给一个独立线程专门负责读取客户端
        // socket从服务端收到的在线人数更新数据以及群聊信息
        new ClientThread(socket ,this).start();
    }
    private void initUI() {
//        setTitle("局域网群聊");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // 主布局
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // 左侧用户列表*******重点
        JPanel userPanel = new JPanel(new BorderLayout());
        userPanel.setPreferredSize(new Dimension(150, 0));
        userList.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        userPanel.add(new JScrollPane(userList), BorderLayout.CENTER);
        userPanel.setBorder(BorderFactory.createTitledBorder("在线用户"));//
        userPanel.setBackground(new Color(240, 240, 240));
        mainPanel.add(userPanel, BorderLayout.WEST);
        // 中间聊天区域
        JPanel chatPanel = new JPanel(new BorderLayout());

        chatArea = new JTextArea();
        chatArea.setEditable(false);
        chatArea.setLineWrap(true);
        chatArea.setFont(new Font("微软雅黑", Font.PLAIN, 14));

        JScrollPane chatScroll = new JScrollPane(chatArea);
        chatScroll.setBorder(BorderFactory.createTitledBorder("聊天记录"));
        chatScroll.setPreferredSize(new Dimension(600, 500));

        chatPanel.add(chatScroll, BorderLayout.CENTER);

        // 底部输入区域
        JPanel inputPanel = new JPanel(new BorderLayout(10, 10));

        chatSend = new JTextArea();
        chatSend.setLineWrap(true);
        chatSend.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        chatSend.setPreferredSize(new Dimension(0, 35));

        JButton sendBtn = new JButton("发送");
        sendBtn.setPreferredSize(new Dimension(90, 35));
        sendBtn.setBackground(new Color(60, 140, 220));
        sendBtn.setForeground(Color.WHITE);
        sendBtn.setFocusPainted(false);

        JButton returnBtn = new JButton("返回");
//        sendBtn.setPreferredSize(new Dimension(90, 35));
        sendBtn.setBackground(new Color(60, 140, 220));
        sendBtn.setForeground(Color.WHITE);
        sendBtn.setFocusPainted(false);

        //给发送按钮绑定点击事件
        sendBtn.addActionListener(e -> {
            String message = chatSend.getText();
            chatSend.setText("");//清空输入框
            if (!message.isEmpty()) {
                SendMessageToServer(message);
            }else
                JOptionPane.showMessageDialog(this, "请输入要发送的消息！");
        });
        //给返回按钮绑定点击事件
        returnBtn.addActionListener(e -> {
            //销毁当前Socket管道
            try {
                socket.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            this.dispose();
        });
        inputPanel.add(chatSend, BorderLayout.CENTER);
//        inputPanel.add(inputField, BorderLayout.CENTER);
        inputPanel.add(sendBtn, BorderLayout.EAST);

        inputPanel.add(returnBtn, BorderLayout.WEST);

        // 组装主界面
        mainPanel.add(userPanel, BorderLayout.WEST);
        mainPanel.add(chatPanel, BorderLayout.CENTER);
        mainPanel.add(inputPanel, BorderLayout.SOUTH);

        add(mainPanel);
    }

    private void SendMessageToServer(String message) {
        //
        try {
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            dos.writeInt(2);
            dos.writeUTF(message);
            dos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void updateOnlineUserList(String[] names) {
        userList.setListData(names);
    }

    public void setMessage(String message) {
        //更新群聊消息到界面展现
        chatArea.append(message);
    }
}