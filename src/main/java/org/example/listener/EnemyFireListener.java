package org.example.listener;

import org.example.common.ImageData;
import org.example.model.Bullet;
import org.example.model.EnemyPlane;
import org.example.model.FlyingObject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

/**
 * @ClassName: 敌机发射子弹任务类
 */
public class EnemyFireListener implements ActionListener {
    public GameController controller;
    public Random random;

    public EnemyFireListener(GameController controller) {
        this.controller = controller;
        random = new Random();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        createEnemyBullet();
    }

    public void createEnemyBullet() {
        int r = random.nextInt(100) + 1;
        for (FlyingObject fly : controller.flyingList) {
            if (fly instanceof EnemyPlane) {
                EnemyPlane enemyPlane = (EnemyPlane) fly;
                if (r < 50) {// %70概率发射子弹
                    Bullet bullet = new Bullet(ImageData.bullet001, enemyPlane.getPosX() + enemyPlane.getWidth() / 2 - 2, enemyPlane.getPosY() + enemyPlane.getHeight(), controller.selectSpeed + 1);
                    controller.enemyBulletList.add(bullet);
                }
            }
        }
    }

}
