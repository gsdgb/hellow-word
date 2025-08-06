package org.example.listener;

import org.example.model.Background;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @ClassName: 背景移动任务类
 */
public class BackgroundListener implements ActionListener {
    public GameController controller;

    public BackgroundListener(GameController controller) {
        this.controller = controller;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //遍历背景数组，并移动
        if (controller.skin == 0) {
            for (Background bg : controller.bgArrCol) {// 彩色
                bg.move();

            }
        } else if (controller.skin == 1) {
            for (Background bg : controller.bgArrGray) {// 灰色
                bg.move();

            }
        }
    }

}
