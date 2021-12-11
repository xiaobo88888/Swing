package jindutiao_;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JProgressBar_ {
    JFrame jFrame = new JFrame("测试进度条");

    //创建复选框
    JCheckBox indeterminate = new JCheckBox("不确定进度");
    JCheckBox noBorder = new JCheckBox("无边框");

    //创建进图条
    JProgressBar jProgressBar = new JProgressBar(JProgressBar.HORIZONTAL,0, 100);

    private void init(){
        //组装视图

        //处理复选框的点击
        indeterminate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //获取当前复选框是否被选中
                boolean selected = indeterminate.isSelected();

                //对进度条进行设置
                jProgressBar.setIndeterminate(selected);//设置是否是不确定进度条
                jProgressBar.setStringPainted(!selected);//设置是否显示进度条

            }
        });

        noBorder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //获取当前复选框是否被选中
                boolean selected = indeterminate.isSelected();

                //对进度条进行设置
                jProgressBar.setBorderPainted(!selected);
            }
        });

        //设置Box来组装复选框，采用纵向排列
        Box box = Box.createVerticalBox();
        box.add(indeterminate);
        box.add(noBorder);

        //设置进度条的属性（为点击复选框之前）
        jProgressBar.setStringPainted(true);
        jProgressBar.setBorderPainted(true);
        jProgressBar.setIndeterminate(false);

        //将整个窗口的布局管理器设置为FlowLayout，这样就可以进行水平布局
        jFrame.setLayout(new FlowLayout());
        jFrame.add(box);
        jFrame.add(jProgressBar);


        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setVisible(true);

        //通过for循环模拟进度
        for (int i = 0; i <= 100; i++) {
            jProgressBar.setValue(i);

            //每增加进度条休眠0.5秒
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        new JProgressBar_().init();
    }
}
