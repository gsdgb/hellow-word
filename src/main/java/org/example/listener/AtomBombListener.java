package org.example.listener;

import org.example.model.Blast;
import org.example.model.FlyingObject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @ClassName: 核弹图片任务类
 */
public class AtomBombListener implements ActionListener {
    public GameController controller;

    public AtomBombListener(GameController controller) {
        this.controller = controller;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (FlyingObject fly : controller.flyingList) {
            if (fly instanceof Blast) {
                Blast atomBlast = (Blast) fly;
                if (atomBlast.getType() == 2) {// 2为核弹类型
                    atomBlast.atomBlastImage();
                }
            }
        }
    }

}
