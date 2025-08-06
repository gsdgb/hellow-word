package org.example.listener;

import org.example.common.ConstUtil;
import org.example.common.MusicData;
import org.example.model.*;
import org.example.view.GameUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @ClassName: 飞行物移动任务类
 * @description: 管理飞行物的移动，且监听飞行物移动中是否碰撞
 */
public class FlyingMoveListener implements ActionListener {
    public GameController controller;

    // 构造方法
    public FlyingMoveListener(GameController controller) {
        this.controller = controller;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // 剩余敌机数
        controller.leftOverCount = controller.enemySum - controller.enemyDieCount - controller.overLineCount - controller.heroPlane.getAtomEnemyCount();
        if (controller.leftOverCount == 0) {
            // 超过防线小于等于5和血量大于0
            if (controller.overLineCount <= 5 && controller.heroPlane.getLife() > 0) {
                // 移动设置为false，解决通关后飞机固定往一个方向移动问题
                controller.heroPlane.setUp(false);
                controller.heroPlane.setDwon(false);
                controller.heroPlane.setRight(false);
                controller.heroPlane.setLeft(false);
                if (controller.level <= 2) {
                    GameUI.winDialog.setVisible(true);
                } else if (controller.level == 3) {
                    controller.state = ConstUtil.WIN;
                }
            }
        }
        //遍历飞行物，飞行物移动
        for (int i = 0; i < controller.flyingList.size(); i++) {
            FlyingObject flying = controller.flyingList.get(i);
            flying.move();
            if (flying instanceof Bee) {
                Bee bee = (Bee) flying;
                //蜜蜂，英雄机碰撞
                if (bee.isHit(bee, controller.heroPlane)) {
                    MusicData.musicBee.play(1);
                    controller.flyingList.remove(bee);
                    controller.heroPlane.setLife(controller.heroPlane.getLife() + 1);
                }
            } else if (flying instanceof DoubleFire) {
                DoubleFire doubleFire = (DoubleFire) flying;
                //双倍火力，英雄机碰撞
                if (doubleFire.isHit(doubleFire, controller.heroPlane)) {
                    MusicData.musicBee.play(1);
                    controller.flyingList.remove(doubleFire);

                    controller.heroPlane.setDoubleFire(controller.heroPlane.getDoubleFire() + 50);
                }
            } else if (flying instanceof AtomBomb) {
                //核弹，英雄机碰撞
                AtomBomb atomBomb = (AtomBomb) flying;
                if (atomBomb.isHit(atomBomb, controller.heroPlane)) {
                    MusicData.musicBee.play(1);
                    // 核弹上限2个
                    if (controller.heroPlane.getAtomBombNum() < 2) {
                        controller.heroPlane.setAtomBombNum(controller.heroPlane.getAtomBombNum() + 1);
                    }
                    controller.flyingList.remove(atomBomb);
                }
            } else if (flying instanceof EnemyPlane) {
                EnemyPlane enemyPlane = (EnemyPlane) flying;
                for (int j = 0; j < controller.bulletList.size(); j++) {
                    Bullet hBullet = controller.bulletList.get(j);
                    //英雄机子弹,敌机碰撞
                    if (enemyPlane.isHit(enemyPlane, hBullet)) {
                        MusicData.musicHitEnemy.play(1);
                        controller.heroPlane.setScore(controller.heroPlane.getScore() + enemyPlane.getScore());
                        controller.bulletList.remove(hBullet);
                        enemyPlane.setLife(enemyPlane.getLife() - 1);
                        if (enemyPlane.getLife() == 0) {
                            MusicData.musicEnemyBoom.play(1);
                            Blast enemyBlast = new Blast(enemyPlane.getPosX(), enemyPlane.getPosY(), enemyPlane.getWidth(), enemyPlane.getHeight(), 0);
                            controller.flyingList.add(enemyBlast);
                            controller.enemyDieCount += 1;
                            controller.flyingList.remove(enemyPlane);
                        }
                    }
                }
                if (enemyPlane.outOfBound()) {
                    controller.overLineCount += 1;
                    if (controller.overLineCount > 10) {//大于越过防线飞机数大于10游戏结束
                        MusicData.musicGameOver.play(1);
                        controller.state = ConstUtil.OVER;
                    }
                }
                //英雄机和敌机碰撞
                if (enemyPlane.isHit(enemyPlane, controller.heroPlane)) {
                    controller.enemyDieCount += 1;
                    controller.heroPlane.setLife(controller.heroPlane.getLife() - 1);
                    if (controller.heroPlane.getLife() > 0) {
                        MusicData.musicRelife.play(1);
                        controller.heroPlane.setPosX(ConstUtil.HERO_X);
                        controller.heroPlane.setPosY(ConstUtil.HERO_Y);
                    }
                    MusicData.musicEnemyBoom.play(1);
                    Blast enemyBlast = new Blast(enemyPlane.getPosX(), enemyPlane.getPosY(), enemyPlane.getWidth(), enemyPlane.getHeight(), 0);
                    controller.flyingList.add(enemyBlast);
                    controller.flyingList.remove(enemyPlane);
                    if (controller.heroPlane.getLife() == 0) {
                        Blast heroBlast = new Blast(controller.heroPlane.getPosX(), controller.heroPlane.getPosY(), controller.heroPlane.getWidth(), controller.heroPlane.getHeight(), 0);
                        controller.flyingList.add(heroBlast);
                    }
                }
            } else if (flying instanceof EnemyBoss) {
                EnemyBoss enemyBoss = (EnemyBoss) flying;
                for (int j = 0; j < controller.bulletList.size(); j++) {
                    Bullet hBullet = controller.bulletList.get(j);
                    //英雄机子弹,Boss碰撞
                    if (enemyBoss.isHit(enemyBoss, hBullet)) {
                        MusicData.musicHitEnemy.play(1);
                        controller.bulletList.remove(hBullet);
                        enemyBoss.setLife(enemyBoss.getLife() - 1);
                        if (enemyBoss.getLife() == 0) {
                            MusicData.musicHeroBomm.play(1);
                            Blast bossBlast = new Blast(enemyBoss.getPosX(), enemyBoss.getPosY(), enemyBoss.getWidth(), enemyBoss.getHeight(), 1);
                            controller.flyingList.add(bossBlast);

                            controller.flyingList.remove(enemyBoss);
                            controller.enemyDieCount += 1;
                        }
                    }
                    //英雄机，Boss碰撞
                    if (enemyBoss.isHit(enemyBoss, controller.heroPlane)) {
                        controller.heroPlane.setLife(controller.heroPlane.getLife() - 1);
                    }
                }
            }
            //飞行物出界
            if (flying.outOfBound()) {
                controller.flyingList.remove(flying);
            }
            //血量为0游戏结束
            if (controller.heroPlane.getLife() <= 0) {
                MusicData.musicGameOver.play(1);
                controller.state = ConstUtil.OVER;
            }
        }
    }

}
