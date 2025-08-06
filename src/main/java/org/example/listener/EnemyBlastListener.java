package org.example.listener;

import org.example.model.Blast;
import org.example.model.FlyingObject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @ClassName: 敌机爆炸效果类
 */
public class EnemyBlastListener implements ActionListener {
    public GameController controller;

    public EnemyBlastListener(GameController controller) {
        this.controller = controller;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (FlyingObject fly : controller.flyingList) {
            if (fly instanceof Blast) {
                Blast enemyBlast = (Blast) fly;
                if (controller.skin == 0) {
                    if (enemyBlast.getType() == 0) {// 0为敌机爆炸
                        enemyBlast.enemyBlastImage();
                    }
                } else if (controller.skin == 1) {
                    if (enemyBlast.getType() == 0) {// 0为敌机爆炸
                        enemyBlast.enemyBlastGrayImage();
                    }
                }

            }
        }
    }

}



