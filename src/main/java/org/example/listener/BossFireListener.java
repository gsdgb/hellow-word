package org.example.listener;

import org.example.common.ImageData;
import org.example.model.Bullet;
import org.example.model.EnemyBoss;
import org.example.model.FlyingObject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @ClassName: boss发射子弹任务类
 */
public class BossFireListener implements ActionListener {
    public GameController controller;

    public BossFireListener(GameController controller) {
        this.controller = controller;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        createBossBullet();
    }

    public void createBossBullet() {
        // 三关boss攻击方式不同
        for (FlyingObject fly : controller.flyingList) {
            if (fly instanceof EnemyBoss) {
                EnemyBoss enemyBoss = (EnemyBoss) fly;
                if (controller.level == 1) {
                    Bullet bullet0 = new Bullet(ImageData.bossBullet001, enemyBoss.getPosX() + 15, enemyBoss.getPosY() + enemyBoss.getHeight(), 3);
                    Bullet bullet1 = new Bullet(ImageData.bossBullet001, enemyBoss.getPosX() + 90, enemyBoss.getPosY() + enemyBoss.getHeight(), 3);
                    controller.enemyBulletList.add(bullet0);
                    controller.enemyBulletList.add(bullet1);
                } else if (controller.level == 2) {
                    Bullet bullet0 = new Bullet(ImageData.bossBullet002, enemyBoss.getPosX() + 20, enemyBoss.getPosY() + enemyBoss.getHeight(), 2);
                    Bullet bullet1 = new Bullet(ImageData.bossBullet002, enemyBoss.getPosX() + 230, enemyBoss.getPosY() + enemyBoss.getHeight(), 2);
                    controller.enemyBulletList.add(bullet0);
                    controller.enemyBulletList.add(bullet1);
                } else if (controller.level == 3) {
                    Bullet bullet0 = new Bullet(ImageData.bossBullet001, enemyBoss.getPosX() + 70, enemyBoss.getPosY() + enemyBoss.getHeight(), 3);
                    Bullet bullet1 = new Bullet(ImageData.bossBullet003, enemyBoss.getPosX() + 30, enemyBoss.getPosY() + enemyBoss.getHeight() - 40, 3);
                    Bullet bullet4 = new Bullet(ImageData.bossBullet002, enemyBoss.getPosX() + 127, enemyBoss.getPosY() + enemyBoss.getHeight() - 40, 3);
                    Bullet bullet2 = new Bullet(ImageData.bossBullet003, enemyBoss.getPosX() + 255, enemyBoss.getPosY() + enemyBoss.getHeight() - 40, 3);
                    Bullet bullet3 = new Bullet(ImageData.bossBullet001, enemyBoss.getPosX() + 216, enemyBoss.getPosY() + enemyBoss.getHeight(), 3);
                    controller.enemyBulletList.add(bullet0);
                    controller.enemyBulletList.add(bullet1);
                    controller.enemyBulletList.add(bullet2);
                    controller.enemyBulletList.add(bullet3);
                    controller.enemyBulletList.add(bullet4);
                }
            }
        }
    }

}
