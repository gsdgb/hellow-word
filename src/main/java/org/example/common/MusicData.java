package org.example.common;


import org.example.listener.MusicPlay;

public class MusicData {
    public static MusicPlay musicStart = new MusicPlay("Music/start.wav");// 开始音效
    public static MusicPlay musicBee = new MusicPlay("Music/addLife.wav");// 加命音效
    public static MusicPlay musicFire = new MusicPlay("Music/fire.wav");// 发射子弹音效
    public static MusicPlay musicHitEnemy = new MusicPlay("Music/hitEnemy.wav");// 打到敌机音效
    public static MusicPlay musicEnemyBoom = new MusicPlay("Music/enemyBoom.wav");// 敌机死亡音效
    public static MusicPlay musicAllBoom = new MusicPlay("Music/allBoom.wav");// 核弹音效
    public static MusicPlay musicGameOver = new MusicPlay("Music/gameover.wav");// 结束音效
    public static MusicPlay musicHeroMove = new MusicPlay("Music/myMove.wav");// 英雄机移动音效
    public static MusicPlay musicRelife = new MusicPlay("Music/relife.wav");// 飞行物重生音效
    public static MusicPlay musicHeroBomm = new MusicPlay("music/myBoom.wav");// 英雄机爆炸音效
    public static MusicPlay musicBackground = new MusicPlay("Music/backMusic.wav");// 背景音效
}
