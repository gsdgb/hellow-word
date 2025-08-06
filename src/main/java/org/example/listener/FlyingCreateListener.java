package org.example.listener;

import org.example.common.ImageData;
import org.example.model.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

/**
 * @ClassName: 飞行物生成任务类
 */
public class FlyingCreateListener implements ActionListener {
    public GameController controller;
    public Random random;
    public EnemyPlane enemyPlane;
    public Bee bee;
    public DoubleFire doubleFire;
    public AtomBomb atomBomb;
    public int randomCreate;//随机创建概率
    public EnemyBoss enemyBoss;
    public EnemyBoss enemyBoss2;
    public EnemyBoss enemyBoss3;
    public EnemyPlane enemyPlane2;

    // 构造方法
    public FlyingCreateListener(GameController controller) {
        this.controller = controller;
        random = new Random();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (controller.skin == 0) {// 彩色
            enemyPlane = new EnemyPlane(ImageData.enemyPlane001, controller.selectSpeed, 10, 1);
            enemyPlane2 = new EnemyPlane(ImageData.enemyPlane002, controller.selectSpeed, 20, 2);
            bee = new Bee(ImageData.bee001, 2);
            doubleFire = new DoubleFire(ImageData.doubleFire001, 2);
            atomBomb = new AtomBomb(ImageData.atomBomb001, 2);
            enemyBoss = new EnemyBoss(ImageData.boss001, controller.selectSpeed - 1, 100, 20);
            enemyBoss2 = new EnemyBoss(ImageData.boss002, controller.selectSpeed - 1, 200, 30);
            enemyBoss3 = new EnemyBoss(ImageData.boss003, controller.selectSpeed - 1, 300, 50);
        } else if (controller.skin == 1) {// 灰色
            enemyPlane = new EnemyPlane(ImageData.enemyPlane01, controller.selectSpeed, 10, 1);
            enemyPlane2 = new EnemyPlane(ImageData.enemyPlane02, controller.selectSpeed, 20, 2);
            bee = new Bee(ImageData.bee001, 2);
            doubleFire = new DoubleFire(ImageData.doubleFire01, 2);
            atomBomb = new AtomBomb(ImageData.atomBomb01, 2);
            enemyBoss = new EnemyBoss(ImageData.boss01, controller.selectSpeed - 1, 100, 20);
            enemyBoss2 = new EnemyBoss(ImageData.boss02, controller.selectSpeed - 1, 200, 30);
            enemyBoss3 = new EnemyBoss(ImageData.boss02, controller.selectSpeed - 1, 300, 50);
        }
        randomCreate = random.nextInt(100) + 1;//1-100
        if (controller.level == 1) {
            createEnemyType1();
            createAward();
        } else if (controller.level == 2 || controller.level == 3) {
            createEnemyType2();
            createAward();
        }
    }

//    // 创建奖励物
//    public void createAward() {
//        if (randomCreate > 90) {
//            if (randomCreate <= 93 && controller.enemy1NoCount > 0) {//%3蜜蜂
//                controller.flyingList.add(bee);
//            } else if (randomCreate <= 97 && controller.enemy1NoCount > 0) {//%4双倍火力
//                controller.flyingList.add(doubleFire);
//            } else if (randomCreate <= 100 && controller.enemy1NoCount > 0) {//%3核弹
//                controller.flyingList.add(atomBomb);
//            }
//        }
//    }
    // 创建奖励物
    public void createAward() {
        if (randomCreate > 30) {
            if (randomCreate <= 40 && controller.enemy1NoCount > 0) {//%10蜜蜂
                controller.flyingList.add(bee);
            } else if (randomCreate <= 80 && controller.enemy1NoCount > 0) {//%40双倍火力
                controller.flyingList.add(doubleFire);
            } else if (randomCreate <= 100 && controller.enemy1NoCount > 0) {//%10核弹
                controller.flyingList.add(atomBomb);
            }
        }
    }
    // 创建敌机1(只有初级机)
    public void createEnemyType1() {
        if (randomCreate <= 90) {// %90初级机
            controller.flyingList.add(enemyPlane);
            --controller.enemy1NoCount;
            if (controller.enemy1NoCount == 0) {// 都生成，生成BOSS
                controller.flyingList.add(enemyBoss);
                --controller.bossNoCount;
            }
        }
    }

    // 创建敌机2(初级机,和高级机)
    public void createEnemyType2() {
        if (randomCreate <= 90) {// %90敌机
            if (controller.enemy1NoCount > 0 && randomCreate <= 45) {// %45初级机
                controller.flyingList.add(enemyPlane);
                --controller.enemy1NoCount;
            } else if (controller.enemy2NoCount == 0 && controller.enemy1NoCount > 0) {
                // 如果高级机生成完，初级机没生成完，则生成初级
                controller.flyingList.add(enemyPlane);
                --controller.enemy1NoCount;
            }
            if (controller.enemy2NoCount > 0 && randomCreate > 45) {// %45高级机
                controller.flyingList.add(enemyPlane2);
                --controller.enemy2NoCount;
            } else if (controller.enemy1NoCount == 0 && controller.enemy2NoCount > 0) {
                // 如果初级机生成完，高级机没生成完，则生成初级
                controller.flyingList.add(enemyPlane2);
                --controller.enemy2NoCount;
            }// 都生成完，则生成BOSS
            if (controller.enemy1NoCount + controller.enemy2NoCount == 0) {
                if (controller.level == 2) {
                    controller.flyingList.add(enemyBoss2);
                } else if (controller.level == 3) {
                    controller.flyingList.add(enemyBoss3);
                }
                --controller.bossNoCount;
            }
        }
    }

}
