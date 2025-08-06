package org.example.listener;

import org.example.view.GameUI;

import java.awt.*;
import java.awt.event.MouseEvent;

/**
 * @ClassName: 游戏顶部面板监听器类
 * @description: 关闭和最小化的样式和其事件的添加
 */
public class GameTopListener extends MyMouseAdapter {
    public Point mouseStartPoint = new Point();

    public GameTopListener() {
//        // 登录
//        addListener(GameUI.loginFrame.loginTopPanel, GameUI.loginFrame.loginTopPanel.label_closeIcon, GameUI.loginFrame.loginTopPanel.label_minIcon);
//        // 注册
//        addListener(GameUI.registerFrame.registerTopPanel, GameUI.registerFrame.registerTopPanel.label_closeIcon, GameUI.registerFrame.registerTopPanel.label_minIcon);
//        // 游戏
        addListener(GameUI.gameFrame.gameTopPanel, GameUI.gameFrame.gameTopPanel.label_closeIcon, GameUI.gameFrame.gameTopPanel.label_minIcon);
        // 自定义
        addListener(GameUI.customFrame.customTopPanel, GameUI.customFrame.customTopPanel.label_closeIcon, GameUI.customFrame.customTopPanel.label_minIcon);
        // 帮助
        addListener(GameUI.helpFrame.helpTopPanel, GameUI.helpFrame.helpTopPanel.label_closeIcon, GameUI.helpFrame.helpTopPanel.label_minIcon);
        addListener(GameUI.closeDialog.closeTopPanel, GameUI.closeDialog.closeTopPanel.label_closeIcon);
        // Win
        addListener(GameUI.winDialog.winTopPanel, GameUI.winDialog.winTopPanel.label_closeIcon);
    }

    // 单击
    @Override
    public void mouseClicked(MouseEvent e) {
        super.mouseClicked(e);
//        // 登录
//        myClicked(GameUI.loginFrame, GameUI.loginFrame.loginTopPanel.label_closeIcon, GameUI.loginFrame.loginTopPanel.label_closeIcon, GameUI.loginFrame.loginTopPanel.label_minIcon, e);
//        // 注册
//        myClicked(GameUI.registerFrame, GameUI.registerFrame.registerTopPanel.label_closeIcon, GameUI.registerFrame.registerTopPanel.label_closeCol, GameUI.registerFrame.registerTopPanel.label_minIcon, e);
//        // 游戏
        myClicked(GameUI.gameFrame, GameUI.gameFrame.gameTopPanel.label_closeIcon, GameUI.gameFrame.gameTopPanel.label_closeCol, GameUI.gameFrame.gameTopPanel.label_minIcon, e);
        // 自定义
        myClicked(GameUI.customFrame, GameUI.customFrame.customTopPanel.label_closeIcon, GameUI.customFrame.customTopPanel.label_closeCol, GameUI.customFrame.customTopPanel.label_minIcon, e);
        // 帮助
        myClicked(GameUI.helpFrame, GameUI.helpFrame.helpTopPanel.label_closeIcon, GameUI.helpFrame.helpTopPanel.label_closeCol, GameUI.helpFrame.helpTopPanel.label_minIcon, e);
//        // 关于
//        myClicked(GameUI.aboutFrame, GameUI.aboutFrame.aboutTopPanel.label_closeIcon, GameUI.aboutFrame.aboutTopPanel.label_closeCol, GameUI.aboutFrame.aboutTopPanel.label_minIcon, e);
//        // 微信
//        myClicked(GameUI.weChatFrame, GameUI.weChatFrame.weChatTopPanel.label_closeIcon, GameUI.weChatFrame.weChatTopPanel.label_closeCol, GameUI.weChatFrame.weChatTopPanel.label_minIcon, e);
//        // bilibili
//        myClicked(GameUI.blibiliFrame, GameUI.blibiliFrame.bilibiliTopPanel.label_closeIcon, GameUI.blibiliFrame.bilibiliTopPanel.label_closeCol, GameUI.blibiliFrame.bilibiliTopPanel.label_minIcon, e);
//        // 退出
        myClicked(GameUI.closeDialog, GameUI.closeDialog.closeTopPanel.label_closeIcon, e);
        // Win
        myClicked(GameUI.winDialog, GameUI.winDialog.winTopPanel.label_closeIcon, e);
    }

    // 移入
    @Override
    public void mouseEntered(MouseEvent e) {
        super.mouseEntered(e);
//        // 登录
//        myEntered(GameUI.loginFrame.loginTopPanel, GameUI.loginFrame.loginTopPanel.label_closeIcon, GameUI.loginFrame.loginTopPanel.label_closeCol, GameUI.loginFrame.loginTopPanel.label_minIcon, GameUI.loginFrame.loginTopPanel.label_minCol, GameUI.loginFrame.loginTopPanel.enter, e);
//        GameUI.loginFrame.repaint();
//        // 注册
//        myEntered(GameUI.registerFrame.registerTopPanel, GameUI.registerFrame.registerTopPanel.label_closeIcon, GameUI.registerFrame.registerTopPanel.label_closeCol, GameUI.registerFrame.registerTopPanel.label_minIcon, GameUI.registerFrame.registerTopPanel.label_minCol, GameUI.registerFrame.registerTopPanel.enter, e);
//        GameUI.registerFrame.repaint();
//        // 游戏
        myEntered(GameUI.gameFrame.gameTopPanel, GameUI.gameFrame.gameTopPanel.label_closeIcon, GameUI.gameFrame.gameTopPanel.label_closeCol, GameUI.gameFrame.gameTopPanel.label_minIcon, GameUI.gameFrame.gameTopPanel.label_minCol, GameUI.gameFrame.gameTopPanel.enter, e);
        GameUI.gameFrame.repaint();
        // 自定义
        myEntered(GameUI.customFrame.customTopPanel, GameUI.customFrame.customTopPanel.label_closeIcon, GameUI.customFrame.customTopPanel.label_closeCol, GameUI.customFrame.customTopPanel.label_minIcon, GameUI.customFrame.customTopPanel.label_minCol, GameUI.customFrame.customTopPanel.enter, e);
        GameUI.customFrame.repaint();
        // 帮助
        myEntered(GameUI.helpFrame.helpTopPanel, GameUI.helpFrame.helpTopPanel.label_closeIcon, GameUI.helpFrame.helpTopPanel.label_closeCol, GameUI.helpFrame.helpTopPanel.label_minIcon, GameUI.helpFrame.helpTopPanel.label_minCol, GameUI.helpFrame.helpTopPanel.enter, e);
        GameUI.helpFrame.repaint();
//        // 关于
//        myEntered(GameUI.aboutFrame.aboutTopPanel, GameUI.aboutFrame.aboutTopPanel.label_closeIcon, GameUI.aboutFrame.aboutTopPanel.label_closeCol, GameUI.aboutFrame.aboutTopPanel.label_minIcon, GameUI.aboutFrame.aboutTopPanel.label_minCol, GameUI.aboutFrame.aboutTopPanel.enter, e);
//        GameUI.aboutFrame.repaint();
//        // 微信
//        myEntered(GameUI.weChatFrame.weChatTopPanel, GameUI.weChatFrame.weChatTopPanel.label_closeIcon, GameUI.weChatFrame.weChatTopPanel.label_closeCol, GameUI.weChatFrame.weChatTopPanel.label_minIcon, GameUI.weChatFrame.weChatTopPanel.label_minCol, GameUI.weChatFrame.weChatTopPanel.enter, e);
//        GameUI.weChatFrame.repaint();
//        // bilibili
//        myEntered(GameUI.blibiliFrame.bilibiliTopPanel, GameUI.blibiliFrame.bilibiliTopPanel.label_closeIcon, GameUI.blibiliFrame.bilibiliTopPanel.label_closeCol, GameUI.blibiliFrame.bilibiliTopPanel.label_minIcon, GameUI.blibiliFrame.bilibiliTopPanel.label_minCol, GameUI.blibiliFrame.bilibiliTopPanel.enter, e);
//        GameUI.blibiliFrame.repaint();
        // 退出
        myEntered(GameUI.closeDialog.closeTopPanel, GameUI.closeDialog.closeTopPanel.label_closeIcon, GameUI.closeDialog.closeTopPanel.label_closeCol, GameUI.closeDialog.closeTopPanel.label_minIcon, GameUI.closeDialog.closeTopPanel.label_minCol, GameUI.closeDialog.closeTopPanel.enter, e);
        GameUI.closeDialog.repaint();
        // Win
        myEntered(GameUI.winDialog.winTopPanel, GameUI.winDialog.winTopPanel.label_closeIcon, GameUI.winDialog.winTopPanel.label_closeCol, GameUI.winDialog.winTopPanel.label_minIcon, GameUI.winDialog.winTopPanel.label_minCol, GameUI.winDialog.winTopPanel.enter, e);
        GameUI.winDialog.repaint();
    }

    // 移出
    @Override
    public void mouseExited(MouseEvent e) {
        super.mouseExited(e);
        // 登录
//        myExited(GameUI.loginFrame.loginTopPanel.label_closeIcon, GameUI.loginFrame.loginTopPanel.label_closeCol, GameUI.loginFrame.loginTopPanel.label_minIcon, GameUI.loginFrame.loginTopPanel.label_minCol, GameUI.loginFrame.loginTopPanel.enter, e);
//        GameUI.loginFrame.repaint();
//        // 注册
//        myExited(GameUI.registerFrame.registerTopPanel.label_closeIcon, GameUI.registerFrame.registerTopPanel.label_closeCol, GameUI.registerFrame.registerTopPanel.label_minIcon, GameUI.registerFrame.registerTopPanel.label_minCol, GameUI.registerFrame.registerTopPanel.enter, e);
//        GameUI.registerFrame.repaint();
//        // 游戏
        myExited(GameUI.gameFrame.gameTopPanel.label_closeIcon, GameUI.gameFrame.gameTopPanel.label_closeCol, GameUI.gameFrame.gameTopPanel.label_minIcon, GameUI.gameFrame.gameTopPanel.label_minCol, GameUI.gameFrame.gameTopPanel.enter, e);
        GameUI.gameFrame.repaint();
        // 自定义
        myExited(GameUI.customFrame.customTopPanel.label_closeIcon, GameUI.customFrame.customTopPanel.label_closeCol, GameUI.customFrame.customTopPanel.label_minIcon, GameUI.customFrame.customTopPanel.label_minCol, GameUI.customFrame.customTopPanel.enter, e);
        GameUI.customFrame.repaint();
        // 帮助
        myExited(GameUI.helpFrame.helpTopPanel.label_closeIcon, GameUI.helpFrame.helpTopPanel.label_closeCol, GameUI.helpFrame.helpTopPanel.label_minIcon, GameUI.helpFrame.helpTopPanel.label_minCol, GameUI.helpFrame.helpTopPanel.enter, e);
        GameUI.helpFrame.repaint();
//        // 关于
//        myExited(GameUI.aboutFrame.aboutTopPanel.label_closeIcon, GameUI.aboutFrame.aboutTopPanel.label_closeCol, GameUI.aboutFrame.aboutTopPanel.label_minIcon, GameUI.aboutFrame.aboutTopPanel.label_minCol, GameUI.aboutFrame.aboutTopPanel.enter, e);
//        GameUI.aboutFrame.repaint();
//        // 微信
//        myExited(GameUI.weChatFrame.weChatTopPanel.label_closeIcon, GameUI.weChatFrame.weChatTopPanel.label_closeCol, GameUI.weChatFrame.weChatTopPanel.label_minIcon, GameUI.weChatFrame.weChatTopPanel.label_minCol, GameUI.weChatFrame.weChatTopPanel.enter, e);
//        GameUI.weChatFrame.repaint();
//        // bilibili
//        myExited(GameUI.blibiliFrame.bilibiliTopPanel.label_closeIcon, GameUI.blibiliFrame.bilibiliTopPanel.label_closeCol, GameUI.blibiliFrame.bilibiliTopPanel.label_minIcon, GameUI.blibiliFrame.bilibiliTopPanel.label_minCol, GameUI.blibiliFrame.bilibiliTopPanel.enter, e);
//        GameUI.blibiliFrame.repaint();
        // 退出
        myExited(GameUI.closeDialog.closeTopPanel.label_closeIcon, GameUI.closeDialog.closeTopPanel.label_closeCol, GameUI.closeDialog.closeTopPanel.label_minIcon, GameUI.closeDialog.closeTopPanel.label_minCol, GameUI.closeDialog.closeTopPanel.enter, e);
        GameUI.closeDialog.repaint();
        // Win
        myExited(GameUI.winDialog.winTopPanel.label_closeIcon, GameUI.winDialog.winTopPanel.label_closeCol, GameUI.winDialog.winTopPanel.label_minIcon, GameUI.winDialog.winTopPanel.label_minCol, GameUI.winDialog.winTopPanel.enter, e);
        GameUI.winDialog.repaint();
    }

    // 按压
    @Override
    public void mousePressed(MouseEvent e) {
        super.mousePressed(e);
        // 登录
//        myPressed(GameUI.loginFrame.loginTopPanel, GameUI.loginFrame.mouseStartPoint, e);
//        // 注册
//        myPressed(GameUI.registerFrame.registerTopPanel, GameUI.loginFrame.mouseStartPoint, e);
//        // 游戏
        myPressed(GameUI.gameFrame.gameTopPanel, GameUI.gameFrame.mouseStartPoint, e);
        // 自定义
        myPressed(GameUI.customFrame.customTopPanel, GameUI.customFrame.mouseStartPoint, e);
        // 帮助
        myPressed(GameUI.helpFrame.helpTopPanel, GameUI.helpFrame.mouseStartPoint, e);
        // 关于
//        myPressed(GameUI.aboutFrame.aboutTopPanel, GameUI.aboutFrame.mouseStartPoint, e);
//        // 微信
//        myPressed(GameUI.weChatFrame.weChatTopPanel, GameUI.weChatFrame.mouseStartPoint, e);
//        // bilibili
//        myPressed(GameUI.blibiliFrame.bilibiliTopPanel, GameUI.blibiliFrame.mouseStartPoint, e);
//        // 退出
        myPressed(GameUI.closeDialog.closeTopPanel, GameUI.closeDialog.mouseStartPoint, e);
        // Win
        myPressed(GameUI.winDialog.winTopPanel, GameUI.winDialog.mouseStartPoint, e);
    }

    // 拖拽
    @Override
    public void mouseDragged(MouseEvent e) {
        super.mouseDragged(e);
        // 登录
//        myDragged(GameUI.loginFrame, GameUI.loginFrame.loginTopPanel, GameUI.loginFrame.mouseStartPoint, e);
//        // 注册
//        myDragged(GameUI.registerFrame, GameUI.registerFrame.registerTopPanel, GameUI.registerFrame.mouseStartPoint, e);
//        // 游戏
        myDragged(GameUI.gameFrame, GameUI.gameFrame.gameTopPanel, GameUI.gameFrame.mouseStartPoint, e);
        // 游自定义
        myDragged(GameUI.customFrame, GameUI.customFrame.customTopPanel, GameUI.customFrame.mouseStartPoint, e);
        // 帮助
        myDragged(GameUI.helpFrame, GameUI.helpFrame.helpTopPanel, GameUI.helpFrame.mouseStartPoint, e);
        // 关于
//        myDragged(GameUI.aboutFrame, GameUI.aboutFrame.aboutTopPanel, GameUI.aboutFrame.mouseStartPoint, e);
//        // 微信
//        myDragged(GameUI.weChatFrame, GameUI.weChatFrame.weChatTopPanel, GameUI.weChatFrame.mouseStartPoint, e);
//        // bilibili
//        myDragged(GameUI.blibiliFrame, GameUI.blibiliFrame.bilibiliTopPanel, GameUI.blibiliFrame.mouseStartPoint, e);
//        // 退出
        myDragged(GameUI.closeDialog, GameUI.closeDialog.closeTopPanel, GameUI.closeDialog.mouseStartPoint, e);
        // Win
        myDragged(GameUI.winDialog, GameUI.winDialog.winTopPanel, GameUI.winDialog.mouseStartPoint, e);
    }
}
