package org.example.listener;

import org.example.model.Bullet;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @ClassName: 子弹移动任务类
 */
public class BulletListener implements ActionListener {
    public GameController controller;

    public BulletListener(GameController controller) {
        this.controller = controller;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // 遍历英雄机子弹，并移动，出界删除
        for (int i = 0; i < controller.bulletList.size(); i++) {
            Bullet hBullet = controller.bulletList.get(i);
            hBullet.move();
            if (hBullet.outOfBound()) {
                controller.bulletList.remove(hBullet);
            }
        }
        // 遍历敌机子弹，并移动，出界删除
        for (int i = 0; i < controller.enemyBulletList.size(); i++) {
            Bullet eBullet = controller.enemyBulletList.get(i);
            eBullet.enemyBulletMove();
            if (eBullet.outOfBound()) {
                controller.enemyBulletList.remove(eBullet);
            }
        }
    }

}
