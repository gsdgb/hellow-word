package org.example.chatUI;
import org.example.loginUI.GameLogin;

import javax.swing.*;
import java.awt.*;
import java.io.DataOutputStream;
import java.net.Socket;

public class CenteredChatLogin extends JFrame {
    private Socket socket;
    public CenteredChatLogin() {
        initUI();
        this.setVisible(true);
    }
    private void initUI() {
        setTitle("局域网聊天登录");
        setSize(400, 300);
        setLocationRelativeTo(null);// 设置窗体居中显示
        setDefaultCloseOperation(EXIT_ON_CLOSE);// 设置关闭按钮关闭整个应用程序
        setResizable(false);// 设置窗体不可拉伸

        // 主面板使用GridBagLayout实现整体居中
        JPanel mainPanel = new JPanel(new GridBagLayout());//
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // 创建内容容器
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.setOpaque(false);

        // 标题
        JLabel titleLabel = new JLabel("用户登录");
        titleLabel.setFont(new Font("微软雅黑", Font.BOLD, 18));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 30, 0));

        // 输入区域面板（整体居中）
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(2, 1, 0, 15));
        inputPanel.setOpaque(false);

        // 用户名行
        JPanel userRow = createInputRow("昵称：");
        JTextField userField = new JTextField(15);
        userField.setPreferredSize(new Dimension(0, 28));
        ((JPanel)userRow.getComponent(1)).add(userField);

        // 密码行

        // 添加输入行
        inputPanel.add(userRow);

        // 按钮面板
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 25, 15));
        buttonPanel.setOpaque(false);// 设置按钮面板背景色为透明

        JButton loginBtn = createSimpleButton("登录", new Color(60, 140, 220));
        JButton cancelBtn = createSimpleButton("退出", new Color(140, 140, 140));

        buttonPanel.add(loginBtn);
        buttonPanel.add(cancelBtn);

        // 组装组件
        contentPanel.add(titleLabel);
        contentPanel.add(inputPanel);
        contentPanel.add(Box.createVerticalStrut(20));
        contentPanel.add(buttonPanel);

        // 将内容面板居中显示
        mainPanel.add(contentPanel, new GridBagConstraints());
        add(mainPanel);

        loginBtn.addActionListener(e -> {
            String username = userField.getText();// 获取用户输入的用户名
            if (username.isEmpty()) {
                JOptionPane.showMessageDialog(this, "请输入昵称", "错误", JOptionPane.ERROR_MESSAGE);
            } else {
                // 登录逻辑
                System.out.println("用户名：" + username);
                // 登录成功后，关闭登录窗口，打开聊天窗口
                //立即发送登录消息给服务端程序
                //1.请求一个socket管道，建立与服务端的连接
                try {
                    login(username);
                    //进入聊天界面
                    new CenteredChatFram(username, socket);
                    this.dispose();
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        //点击退出按钮返回至Game Login界面
        cancelBtn.addActionListener(e -> {
            new GameLogin();
            this.dispose();
        });
    }
    public void login (String name) throws Exception {
        socket = new Socket(Constant.SERVER_IP,Constant.SERVER_PORT);
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        dos.writeInt(1);
        dos.writeUTF(name);
        dos.flush();
    }

    // 创建输入行（标签+输入框）
    private JPanel createInputRow(String labelText) {
        JPanel rowPanel = new JPanel(new BorderLayout(10, 0));
        rowPanel.setOpaque(false);// 设置行面板背景色为透明

        JLabel label = new JLabel(labelText);
        label.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        label.setPreferredSize(new Dimension(70, 25));

        JPanel inputContainer = new JPanel(new FlowLayout(FlowLayout.LEFT));
        inputContainer.setOpaque(false);

        rowPanel.add(label, BorderLayout.WEST);
        rowPanel.add(inputContainer, BorderLayout.CENTER);

        return rowPanel;
    }

    // 创建简洁按钮
    private JButton createSimpleButton(String text, Color bgColor) {
        JButton button = new JButton(text);
        button.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        button.setPreferredSize(new Dimension(90, 28));
        button.setBackground(bgColor);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15));
        return button;
    }

}