package org.example.common;

/**
 * @ClassName: 静态常量类
 */
public class ConstUtil {
    // 游戏
    public static final int GAME_WIDTH = 1000;// 游戏窗口宽度
    public static final int GAME_HEIGHT = 800;// 游戏窗口高度
    public static final int GAME_TOP_HEIGHT = 30;// 游戏顶部面板高度
    public static final int GAME_LEFT_WIDTH = 60;// 游戏左侧面板宽度
    public static final int GAME_RIGHT_WIDTH = 300;// 游戏右侧面板宽度
    public static final int GAME_AREA_WIDTH = GAME_WIDTH - GAME_LEFT_WIDTH - GAME_RIGHT_WIDTH;
    public static final int GAME_AREA_HEIGHT = GAME_HEIGHT - GAME_TOP_HEIGHT;
    // 自定义
    public static final int CUSTOM_RIGHT_WIDTH = 600;// 自定义窗口宽度
    public static final int CUSTOM_RIGHT_HEIGHT = 500;// 自定义窗口高度
    // 关闭
    public static final int CLOSE_WIDTH = 350;// 关闭提示窗口宽度
    public static final int CLOSE_HEIGHT = 250;// 关闭提示窗口高度
    // 帮助
    public static final int HELP_WIDTH = 600;// 帮助窗口宽度
    public static final int HELP_HEIGHT = 500;// 帮助窗口高度
    // 游戏状态
    public static final int READY = 0; // 0就绪
    public static final int RUNNING = 1; // 1运行
    public static final int PAUSE = 2; // 2暂停
    public static final int OVER = 3; // 3停止
    public static final int WIN = 4; // 4通关

    public static final int HERO_X = 300;// 初始X
    public static final int HERO_Y = 650;// 初始Y
    public static final int LIFE = 3;// 初始化生命
    public static final int DOUBLE_FIRE = 50;// 双倍火力值

}
