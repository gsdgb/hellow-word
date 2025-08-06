package org.example.listener;

import org.example.common.ConstUtil;
import org.example.common.MusicData;
import org.example.model.Blast;
import org.example.model.Bullet;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @ClassName: 子弹碰撞任务类
 * @description: 监听敌机子弹和我方子弹，我方飞机的碰撞
 */
public class BulletCollisionListener implements ActionListener {
    public GameController controller;

    public BulletCollisionListener(GameController controller) {
        this.controller = controller;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // 敌机子弹，英雄子弹碰撞
        for (int i = 0; i < controller.bulletList.size(); i++) {
            Bullet hBullet = controller.bulletList.get(i);
            for (int j = 0; j < controller.enemyBulletList.size(); j++) {
                Bullet eBullet = controller.enemyBulletList.get(j);
                if (hBullet.isHit(eBullet, hBullet)) {
                    controller.bulletList.remove(hBullet);
                    controller.enemyBulletList.remove(eBullet);
                }
            }
        }
        // 敌机子弹，英雄机碰撞
        for (int j = 0; j < controller.enemyBulletList.size(); j++) {
            Bullet eBullet = controller.enemyBulletList.get(j);
            if (eBullet.isHit(eBullet, controller.heroPlane)) {
                controller.enemyBulletList.remove(eBullet);
                controller.heroPlane.setLife(controller.heroPlane.getLife() - 1);
                if (controller.heroPlane.getLife() > 0) {
                    MusicData.musicRelife.play(1);
                    controller.heroPlane.setPosX(ConstUtil.HERO_X);
                    controller.heroPlane.setPosY(ConstUtil.HERO_Y);
                } else {// 0血结束
                    MusicData.musicHeroBomm.play(1);
                    Blast heroBlast = new Blast(controller.heroPlane.getPosX(), controller.heroPlane.getPosY(), controller.heroPlane.getWidth(), controller.heroPlane.getHeight(), 0);
                    controller.flyingList.add(heroBlast);
                    controller.state = ConstUtil.OVER;
                    MusicData.musicGameOver.play(1);
                }
            }
        }
    }

}
