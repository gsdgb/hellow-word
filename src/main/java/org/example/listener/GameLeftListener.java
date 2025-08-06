package org.example.listener;

import org.example.common.ConstUtil;
import org.example.view.GameUI;

import java.awt.event.MouseEvent;

/**
 * @ClassName: 游戏左侧面板监听器类
 * @description: 游戏左侧面板按钮的样式和效果
 */
public class GameLeftListener extends MyMouseAdapter {
    public GameLeftListener() {
        addListener();
    }

    public void addListener() {
        // 开始
        GameUI.gameFrame.gameLeftPanel.label_startIcon.addMouseListener(this);
        GameUI.gameFrame.gameLeftPanel.label_startCol.addMouseListener(this);
        // 暂停
        GameUI.gameFrame.gameLeftPanel.label_pauseIcon.addMouseListener(this);
        GameUI.gameFrame.gameLeftPanel.label_pauseCol.addMouseListener(this);
        // 继续
        GameUI.gameFrame.gameLeftPanel.label_continueIcon.addMouseListener(this);
        GameUI.gameFrame.gameLeftPanel.label_continueCol.addMouseListener(this);
        // 重写
        GameUI.gameFrame.gameLeftPanel.label_restartIcon.addMouseListener(this);
        GameUI.gameFrame.gameLeftPanel.label_restartCol.addMouseListener(this);
        // 设置
        GameUI.gameFrame.gameLeftPanel.label_settingIcon.addMouseListener(this);
        GameUI.gameFrame.gameLeftPanel.label_settringCol.addMouseListener(this);
        // 帮助
        GameUI.gameFrame.gameLeftPanel.label_helpIcon.addMouseListener(this);
        GameUI.gameFrame.gameLeftPanel.label_helpCol.addMouseListener(this);
//        // 关于
//        GameUI.gameFrame.gameLeftPanel.label_aboutIcon.addMouseListener(this);
//        GameUI.gameFrame.gameLeftPanel.label_aboutCol.addMouseListener(this);
//        // 微信
//        GameUI.gameFrame.gameLeftPanel.label_weChatIcon.addMouseListener(this);
//        GameUI.gameFrame.gameLeftPanel.label_weChatCol.addMouseListener(this);
//        // bilibili
//        GameUI.gameFrame.gameLeftPanel.label_bilibiliIcon.addMouseListener(this);
//        GameUI.gameFrame.gameLeftPanel.label_bilibiliCol.addMouseListener(this);
        // 关闭
        GameUI.gameFrame.gameLeftPanel.label_exitIcon.addMouseListener(this);
        GameUI.gameFrame.gameLeftPanel.label_exitCol.addMouseListener(this);
    }

    //单击
    @Override
    public void mouseClicked(MouseEvent e) {
        super.mouseClicked(e);
        // 开始(就绪或者结束状态可用)
        if (GameUI.gameFrame.controller.state == ConstUtil.READY || GameUI.gameFrame.controller.state == ConstUtil.OVER) {
            if (e.getSource() == GameUI.gameFrame.gameLeftPanel.label_startIcon || e.getSource() == GameUI.gameFrame.gameLeftPanel.label_startCol) {
                GameUI.gameFrame.gameCenterPanel.controller.state = ConstUtil.RUNNING;
                GameUI.gameFrame.repaint();
            }
        }
        // 暂停(运行状态可用)
        if (GameUI.gameFrame.controller.state == ConstUtil.RUNNING) {
            if (e.getSource() == GameUI.gameFrame.gameLeftPanel.label_pauseIcon || e.getSource() == GameUI.gameFrame.gameLeftPanel.label_pauseCol) {
                GameUI.gameFrame.gameCenterPanel.controller.state = ConstUtil.PAUSE;
                GameUI.gameFrame.repaint();
            }
        }
        // 继续(暂停状态可以)
        if (GameUI.gameFrame.controller.state == ConstUtil.PAUSE) {
            if (e.getSource() == GameUI.gameFrame.gameLeftPanel.label_continueIcon || e.getSource() == GameUI.gameFrame.gameLeftPanel.label_continueCol) {
                GameUI.gameFrame.gameCenterPanel.controller.state = ConstUtil.RUNNING;
                GameUI.gameFrame.repaint();
            }
        }
        // 重新
        if (e.getSource() == GameUI.gameFrame.gameLeftPanel.label_restartIcon || e.getSource() == GameUI.gameFrame.gameLeftPanel.label_restartCol) {
            GameUI.gameFrame.gameCenterPanel.controller.gameRestart();
            GameUI.gameFrame.gameCenterPanel.controller.state = ConstUtil.READY;
            GameUI.gameFrame.repaint();
        }
        // 自定义(就绪或结束状态可用)
        if (GameUI.gameFrame.controller.state == ConstUtil.READY || GameUI.gameFrame.controller.state == ConstUtil.OVER) {
            myClicked(GameUI.gameFrame.gameLeftPanel.label_settingIcon, GameUI.gameFrame.gameLeftPanel.label_settringCol, GameUI.customFrame, e);
        }
        // 帮助
        myClicked(GameUI.gameFrame.gameLeftPanel.label_helpIcon, GameUI.gameFrame.gameLeftPanel.label_helpCol, GameUI.helpFrame, e);
//        // 关于
//        myClicked(GameUI.gameFrame.gameLeftPanel.label_aboutIcon, GameUI.gameFrame.gameLeftPanel.label_aboutCol, GameUI.aboutFrame, e);
//        // 微信
//        myClicked(GameUI.gameFrame.gameLeftPanel.label_weChatIcon, GameUI.gameFrame.gameLeftPanel.label_weChatCol, GameUI.weChatFrame, e);
//        // bilibili
//        myClicked(GameUI.gameFrame.gameLeftPanel.label_bilibiliIcon, GameUI.gameFrame.gameLeftPanel.label_bilibiliCol, GameUI.blibiliFrame, e);
//        // 退出
        myClicked(GameUI.gameFrame.gameLeftPanel.label_exitIcon, GameUI.gameFrame.gameLeftPanel.label_exitCol, GameUI.closeDialog, e);
    }

    //移入
    @Override
    public void mouseEntered(MouseEvent e) {
        super.mouseEntered(e);
        // 开始(就绪或者结束状态有颜色)
        if (GameUI.gameFrame.controller.state == ConstUtil.READY || GameUI.gameFrame.controller.state == ConstUtil.OVER) {
            myEntered(GameUI.gameFrame.gameLeftPanel.label_startIcon, GameUI.gameFrame.gameLeftPanel.label_startCol, e);
        }
        // 暂停(运行状态有颜色)
        if (GameUI.gameFrame.controller.state == ConstUtil.RUNNING) {
            myEntered(GameUI.gameFrame.gameLeftPanel.label_pauseIcon, GameUI.gameFrame.gameLeftPanel.label_pauseCol, e);
        }
        // 继续(暂停状态有颜色)
        if (GameUI.gameFrame.controller.state == ConstUtil.PAUSE) {
            myEntered(GameUI.gameFrame.gameLeftPanel.label_continueIcon, GameUI.gameFrame.gameLeftPanel.label_continueCol, e);
        }
        // 重新(任何状态可用)
        myEntered(GameUI.gameFrame.gameLeftPanel.label_restartIcon, GameUI.gameFrame.gameLeftPanel.label_restartCol, e);
        // 自定义(就绪或结束状态可用)
        if (GameUI.gameFrame.controller.state == ConstUtil.READY || GameUI.gameFrame.controller.state == ConstUtil.OVER) {
            myEntered(GameUI.gameFrame.gameLeftPanel.label_settingIcon, GameUI.gameFrame.gameLeftPanel.label_settringCol, e);
        }
        // 帮助
        myEntered(GameUI.gameFrame.gameLeftPanel.label_helpIcon, GameUI.gameFrame.gameLeftPanel.label_helpCol, e);
//        // 关于
//        myEntered(GameUI.gameFrame.gameLeftPanel.label_aboutIcon, GameUI.gameFrame.gameLeftPanel.label_aboutCol, e);
//        // 微信
//        myEntered(GameUI.gameFrame.gameLeftPanel.label_weChatIcon, GameUI.gameFrame.gameLeftPanel.label_weChatCol, e);
//        // bilibili
//        myEntered(GameUI.gameFrame.gameLeftPanel.label_bilibiliIcon, GameUI.gameFrame.gameLeftPanel.label_bilibiliCol, e);
//        // 退出
        myEntered(GameUI.gameFrame.gameLeftPanel.label_exitIcon, GameUI.gameFrame.gameLeftPanel.label_exitCol, e);
        GameUI.gameFrame.repaint();
    }

    //移出
    @Override
    public void mouseExited(MouseEvent e) {
        super.mouseExited(e);
        // 开始
        myExited(GameUI.gameFrame.gameLeftPanel.label_startIcon, GameUI.gameFrame.gameLeftPanel.label_startCol, e);
        // 暂停
        myExited(GameUI.gameFrame.gameLeftPanel.label_pauseIcon, GameUI.gameFrame.gameLeftPanel.label_pauseCol, e);
        // 继续
        myExited(GameUI.gameFrame.gameLeftPanel.label_continueIcon, GameUI.gameFrame.gameLeftPanel.label_continueCol, e);
        // 重新
        myExited(GameUI.gameFrame.gameLeftPanel.label_restartIcon, GameUI.gameFrame.gameLeftPanel.label_restartCol, e);
        // 自定义
        myExited(GameUI.gameFrame.gameLeftPanel.label_settingIcon, GameUI.gameFrame.gameLeftPanel.label_settringCol, e);
        // 帮助
        myExited(GameUI.gameFrame.gameLeftPanel.label_helpIcon, GameUI.gameFrame.gameLeftPanel.label_helpCol, e);
//        // 关于
//        myExited(GameUI.gameFrame.gameLeftPanel.label_aboutIcon, GameUI.gameFrame.gameLeftPanel.label_aboutCol, e);
//        // 微信
//        myExited(GameUI.gameFrame.gameLeftPanel.label_weChatIcon, GameUI.gameFrame.gameLeftPanel.label_weChatCol, e);
//        // bilibili
//        myExited(GameUI.gameFrame.gameLeftPanel.label_bilibiliIcon, GameUI.gameFrame.gameLeftPanel.label_bilibiliCol, e);
//        // 退出
        myExited(GameUI.gameFrame.gameLeftPanel.label_exitIcon, GameUI.gameFrame.gameLeftPanel.label_exitCol, e);
        GameUI.gameFrame.repaint();
    }
}
