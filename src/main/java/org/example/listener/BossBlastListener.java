package org.example.listener;

import org.example.model.Blast;
import org.example.model.FlyingObject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @ClassName: boss爆炸图片任务类
 */
public class BossBlastListener implements ActionListener {
    public GameController controller;

    public BossBlastListener(GameController controller) {
        this.controller = controller;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (FlyingObject fly : controller.flyingList) {
            if (fly instanceof Blast) {
                Blast bossBlast = (Blast) fly;
                if(controller.skin==0){
                    if (bossBlast.getType() == 1) {// 1为boss爆炸
                        bossBlast.bossBlastImage();
                    }
                }else if(controller.skin==1){
                    if (bossBlast.getType() == 1) {// 1为boss爆炸
                        bossBlast.bossBlastGrayImage();
                    }
                }

            }
        }
    }

}
