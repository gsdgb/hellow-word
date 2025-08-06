package org.example.common;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * @ClassName: 图片资源类
 * @description: 用于加载图片，方便调用
 */
public class ImageData {
    // 彩色 00X结尾
    public static BufferedImage gameBack001;// 游戏背景
    public static BufferedImage gameStart001;//开始背景
    public static BufferedImage gamePause001;//暂停背景
    public static BufferedImage gameOver001;//结束背景
    public static BufferedImage heroPlane001;// 飞机1
    public static BufferedImage heroPlane002;// 飞机2
    public static BufferedImage heroPlane003;// 飞机3
    public static BufferedImage heroPlane004;// 飞机4
    public static BufferedImage enemyPlane001;// 敌机1
    public static BufferedImage enemyPlane002;// 敌机2
    public static BufferedImage boss001;//Boss1
    public static BufferedImage boss002;//Boss2
    public static BufferedImage boss003;//Boss3
    public static BufferedImage bullet001;// 子弹1
    public static BufferedImage bullet002;// 子弹2
    public static BufferedImage bullet003;// 子弹3
    public static BufferedImage bossBullet001;// boss子弹1
    public static BufferedImage bossBullet002;// boss子弹2
    public static BufferedImage bossBullet003;// boss子弹3
    public static BufferedImage bee001;// 蜜蜂
    public static BufferedImage doubleFire001;// 双倍火力
    public static BufferedImage atomBomb001;// 核弹
    public static BufferedImage blast001;// 爆炸1
    public static BufferedImage blast002;// 爆炸2
    public static BufferedImage blast003;// 爆炸3
    public static BufferedImage blast004;// 爆炸4
    public static BufferedImage blast005;// 爆炸5
    public static BufferedImage blast006;// 爆炸6
    public static BufferedImage bossBlast001;// BOSS爆炸1
    public static BufferedImage bossBlast002;// BOSS爆炸2
    public static BufferedImage bossBlast003;// BOSS爆炸3
    public static BufferedImage bossBlast004;// BOSS爆炸4
    public static BufferedImage bigBlast001;// 大爆炸1
    public static BufferedImage bigBlast002;// 大爆炸2
    public static BufferedImage bigBlast003;// 大爆炸3
    public static BufferedImage bigBlast004;// 大爆炸4
    public static BufferedImage bigBlast005;// 大爆炸5
    //灰色 0X结尾
    public static BufferedImage heroPlane01;//飞机5
    public static BufferedImage heroPlane02;//飞机6
    public static BufferedImage heroPlane03;//飞机7
    public static BufferedImage heroPlane04;//飞机8
    public static BufferedImage enemyPlane01;//敌机3
    public static BufferedImage enemyPlane02;//敌机4
    public static BufferedImage boss01;// Boss1
    public static BufferedImage boss02;// Boss2
    public static BufferedImage doubleFire01;// 双倍火力
    public static BufferedImage atomBomb01;// 核弹
    public static BufferedImage gameBack01;// 背景
    public static BufferedImage blast04;// 爆炸4
    public static BufferedImage blast05;// 爆炸5
    public static BufferedImage bossBlast01;// BOSS爆炸1
    public static BufferedImage bossBlast02;// BOSS爆炸2
    public static BufferedImage bossBlast03;// BOSS爆炸3
    public static BufferedImage bossBlast04;// BOSS爆炸4

    static {
        try {
            // 彩色
            gameBack001 = ImageIO.read(new File("images/background/bg.jpg"));
            gameStart001 = ImageIO.read(new File("images/background/mao.png"));
            gamePause001 = ImageIO.read(new File("images/background/pause001.png"));
            gameOver001 = ImageIO.read(new File("images/background/gameOver001.png"));
            heroPlane001 = ImageIO.read(new File("images/plane/hero001.png"));
            heroPlane002 = ImageIO.read(new File("images/plane/hero002.png"));
            heroPlane003 = ImageIO.read(new File("images/plane/hero003.png"));
            heroPlane004 = ImageIO.read(new File("images/plane/hero004.png"));
            enemyPlane001 = ImageIO.read(new File("images/plane/enemy001.png"));
            enemyPlane002 = ImageIO.read(new File("images/plane/enemy002.png"));
            boss001 = ImageIO.read(new File("images/plane/boss001.png"));
            boss002 = ImageIO.read(new File("images/plane/boss002.png"));
            boss003 = ImageIO.read(new File("images/plane/boss003.png"));
            bullet001 = ImageIO.read(new File("images/plane/bullet001.png"));
            bullet002 = ImageIO.read(new File("images/plane/bullet002.png"));
            bullet003 = ImageIO.read(new File("images/plane/bullet003.png"));
            bossBullet001 = ImageIO.read(new File("images/plane/bossBullet001.png"));
            bossBullet002 = ImageIO.read(new File("images/plane/bossBullet002.png"));
            bossBullet003 = ImageIO.read(new File("images/plane/bossBullet003.png"));
            bee001 = ImageIO.read(new File("images/award/bee001.png"));
            doubleFire001 = ImageIO.read(new File("images/award/doubleFire001.png"));
            atomBomb001 = ImageIO.read(new File("images/award/atomBomb001.png"));
            blast001 = ImageIO.read(new File("images/blast/blast001.png"));
            blast002 = ImageIO.read(new File("images/blast/blast002.png"));
            blast003 = ImageIO.read(new File("images/blast/blast003.png"));
            blast004 = ImageIO.read(new File("images/blast/blast004.png"));
            blast005 = ImageIO.read(new File("images/blast/blast005.png"));
            blast006 = ImageIO.read(new File("images/blast/blast006.png"));
            bossBlast001 = ImageIO.read(new File("images/blast/bossBlast001.png"));
            bossBlast002 = ImageIO.read(new File("images/blast/bossBlast002.png"));
            bossBlast003 = ImageIO.read(new File("images/blast/bossBlast003.png"));
            bossBlast004 = ImageIO.read(new File("images/blast/bossBlast004.png"));
            bigBlast001 = ImageIO.read(new File("images/blast/bigBlast001.png"));
            bigBlast002 = ImageIO.read(new File("images/blast/bigBlast002.png"));
            bigBlast003 = ImageIO.read(new File("images/blast/bigBlast003.png"));
            bigBlast004 = ImageIO.read(new File("images/blast/bigBlast004.png"));
            bigBlast005 = ImageIO.read(new File("images/blast/bigBlast005.png"));
            //灰色
            heroPlane01 = ImageIO.read(new File("images/plane/hero005.png"));
            heroPlane02 = ImageIO.read(new File("images/plane/hero006.png"));
            heroPlane03 = ImageIO.read(new File("images/plane/hero007.png"));
            heroPlane04 = ImageIO.read(new File("images/plane/hero008.png"));
            enemyPlane01 = ImageIO.read(new File("images/plane/enemy003.png"));
            enemyPlane02 = ImageIO.read(new File("images/plane/enemy004.png"));
            boss01 = ImageIO.read(new File("images/plane/boss01.png"));
            boss02 = ImageIO.read(new File("images/plane/boss02.png"));
            doubleFire01 = ImageIO.read(new File("images/award/doubleFire01.png"));
            atomBomb01 = ImageIO.read(new File("images/award/atomBomb01.png"));
            gameBack01 = ImageIO.read(new File("images/background/gameBack01.png"));
            blast04 = ImageIO.read(new File("images/blast/blast04.png"));
            blast05 = ImageIO.read(new File("images/blast/blast05.png"));
            bossBlast01 = ImageIO.read(new File("images/blast/bossBlast01.png"));
            bossBlast02 = ImageIO.read(new File("images/blast/bossBlast02.png"));
            bossBlast03 = ImageIO.read(new File("images/blast/bossBlast03.png"));
            bossBlast04 = ImageIO.read(new File("images/blast/bossBlast04.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
