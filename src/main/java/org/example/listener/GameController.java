package org.example.listener;

import org.example.common.ImageData;
import org.example.model.*;

import javax.swing.*;
import java.util.ArrayList;

/**
 * @ClassName: 游戏控制类
 * @description: 管理众多定时器，元素，元素集合
 */
public class GameController {
    public Background[] bgArrCol = new Background[2];// 背景数组
    public Background[] bgArrGray = new Background[2];// 背景数组
    public HeroPlane heroPlane;
    // 集合
    public ArrayList<Bullet> enemyBulletList;// 敌机子弹
    public ArrayList<Bullet> bulletList;// 子弹
    public ArrayList<FlyingObject> flyingList;//飞行物
    public ArrayList<Blast> enemyBlastList;// 敌机爆炸集合
    // 定时器
    private Timer bgMoveTimer;// 背景移动
    private Timer heroMoveTimer;//英雄机移动
    private Timer bulletMoveTimer;// 子弹移动
    private Timer flyingMoveTimer;// 飞行物移动
    private Timer flyingCreateTimer;// 飞行物移动
    private Timer enemyBlastTimer;// 敌机爆炸
    private Timer bossBlastTimer;// boss爆炸
    private Timer atomBombTimer;// 核弹爆炸
    private Timer bulletCollisionTimer;// 子弹对消
    private Timer bossFireTimer;// boss发射子弹
    private Timer enemyFireTimer;// 敌机发射子弹
    // 数据
    public int overLineCount;// 越过防线个数
    public int enemySum;// 敌机总个数
    public int enemyDieCount;// 敌机死亡数
    public int leftOverCount;// 敌机剩余个数
    public int enemy1NoCount;// 未出现初级机个数
    public int enemy2NoCount;// 未出现初级机个数
    public int bossNoCount;// 未出现boss个数

    public int level = 1;// 关卡等级
    public int skin = 0;// 0彩色,1灰色
    public int selectSpeed = 2;// 敌机速度
    public int state = 0;// 游戏状态

    // 构造方法
    public GameController() {
        // 背景
        Background bg0 = new Background(ImageData.gameBack001, 0, 0, 1);
        Background bg1 = new Background(ImageData.gameBack001, 0, -720, 1);
        Background bg2 = new Background(ImageData.gameBack01, 0, 0, 1);
        Background bg3 = new Background(ImageData.gameBack01, 0, -720, 1);
        bgArrCol[0] = bg0;
        bgArrCol[1] = bg1;
        bgArrGray[0] = bg2;
        bgArrGray[1] = bg3;
        bgMoveTimer = new Timer(20, new BackgroundListener(this));
        // 英雄机
        heroPlane = new HeroPlane(ImageData.heroPlane001, 300, 650, 5);
        heroMoveTimer = new Timer(1, new HeroPlaneListener(this));
        // 核弹爆炸
        atomBombTimer = new Timer(150, new AtomBombListener(this));
        // 敌机,boss
        enemyBlastList = new ArrayList<>();
        enemyBlastTimer = new Timer(50, new EnemyBlastListener(this));
        bossBlastTimer = new Timer(125, new BossBlastListener(this));
        // boss,敌机发射子弹
        bossFireTimer = new Timer(1500, new BossFireListener(this));//500
        enemyFireTimer = new Timer(2500, new EnemyFireListener(this));//1500
        // 子弹
        bulletList = new ArrayList<>();
        enemyBulletList = new ArrayList<>();
        bulletMoveTimer = new Timer(1, new BulletListener(this));//1
        bulletCollisionTimer = new Timer(10, new BulletCollisionListener(this));//10
        // 飞行物
        flyingList = new ArrayList<>();
        flyingCreateTimer = new Timer(1000, new FlyingCreateListener(this));
        flyingMoveTimer = new Timer(25, new FlyingMoveListener(this));
    }

    // 定时器开启
    public void timerStart() {
        bgMoveTimer.start();//背景
        heroMoveTimer.start();//英雄移动
        bulletMoveTimer.start();//子弹移动
        if ((enemy1NoCount + enemy2NoCount) == 0) {//如果都生成了，关闭
            flyingCreateTimer.stop();
        } else {
            flyingCreateTimer.start();//飞行物生成
        }
        flyingMoveTimer.start();//飞行物移动
        bossFireTimer.start();//Boss火力
        enemyFireTimer.start();//敌机火力
        bulletCollisionTimer.start();//子弹间的碰撞
        enemyBlastTimer.start();
        bossBlastTimer.start();
    }

    // 定时器停止
    public void timerStop() {
        bgMoveTimer.stop();//背景
        heroMoveTimer.stop();//英雄移动
        bulletMoveTimer.stop();//子弹移动
        flyingCreateTimer.stop();//飞行物生成
        flyingMoveTimer.stop();//飞行物移动
        bossFireTimer.stop();//boss发射子弹
        enemyFireTimer.stop();//敌机发射子弹
        bulletCollisionTimer.stop();//子弹间的碰撞
    }

    // 定时器重启
    public void timerRstart() {
        bgMoveTimer.restart();//背景
        heroMoveTimer.restart();//英雄移动
        bulletMoveTimer.restart();//子弹移动
        flyingCreateTimer.restart();//飞行物生成
        flyingMoveTimer.restart();//飞行物移动
        bossFireTimer.restart();
        enemyFireTimer.restart();
        bulletCollisionTimer.restart();//子弹间的碰撞
        enemyBlastTimer.start();
        enemyBulletList.clear();
        bulletList.clear();
        flyingList.clear();
        if (level == 1) {
            selectLevel(21, 20, 0);
        } else if (level == 2) {
            selectLevel(21, 10, 10);
        } else if (level == 3) {
            selectLevel(31, 10, 20);
        }
    }

    // 游戏开始
    public void gameStart() {
        switch (level) {
            case 1:
                selectLevel(21, 20, 0);
                break;
            case 2:
                selectLevel(21, 10, 10);
                break;
            case 3:
                selectLevel(31, 10, 20);
                break;
        }
    }

    // 游戏重新开始
    public void gameRestart() {
        enemyBulletList.clear();// 集合初始化
        bulletList.clear();
        flyingList.clear();
        bossNoCount = 1;
        heroPlane.setPosX(300);
        heroPlane.setPosY(650);
        heroPlane.setLife(3);
        heroPlane.setDoubleFire(0);
        heroPlane.setScore(0);// 分数清零
        heroPlane.setAtomBombNum(0);// 核弹清零
        if (level == 1) {// 根据当前关
            selectLevel(21, 20, 0);
            heroPlane.setAtomBombNum(1);
        } else if (level == 2) {
            selectLevel(21, 10, 10);
        } else if (level == 3) {
            selectLevel(31, 10, 20);
        }
        timerStop();
    }

    // 选择关卡
    public void selectLevel(int enemySum, int enemy1NoCount, int enemy2NoCount) {
        this.enemySum = enemySum;//这里可以优化一下
        this.enemy1NoCount = enemy1NoCount;
        this.enemy2NoCount = enemy2NoCount;
        bossNoCount = 1;
        overLineCount = 0;
        enemyDieCount = 0;
        leftOverCount = 0;
        heroPlane.setAtomEnemyCount(0);
    }

    // 按下H再去开启
    public Timer getAtomBombTimer() {
        return atomBombTimer;
    }

}
