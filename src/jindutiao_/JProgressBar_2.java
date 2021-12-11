package jindutiao_;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*ChangeListener:
    定义一个侦听 ChangeEvent 的对象。

    void addChangeListener(ChangeListener l)
          将指定的 ChangeListener 添加到进度条。
 */
public class JProgressBar_2 {
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

        //开启子线程，模拟耗时操作
        SimulaterActivity simulaterActivity = new SimulaterActivity(jProgressBar.getMaximum());
        new Thread(simulaterActivity).start();

        //设置定时任务，定时读取子线程的进度条
        Timer timer = new Timer(200, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //读取线程任务对象的完成量，并设置给进度条
                int current = simulaterActivity.getCurrent();
                jProgressBar.setValue(current);
            }
        });
        timer.start();

        //给进度条添加变化监听
        jProgressBar.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int value = jProgressBar.getValue();
                if(value == simulaterActivity.getAmount()){//如果进度条到达最大值了，则停止定时任务
                    timer.stop();
                }
            }
        });
    }

    private class SimulaterActivity implements Runnable{
        //任务总量
        private int amount;

        //当前完成任务量
        private volatile int current;

        public SimulaterActivity(int amount) {
            this.amount = amount;
        }

        public int getAmount() {
            return amount;
        }

        public void setAmount(int amount) {
            this.amount = amount;
        }

        public int getCurrent() {
            return current;
        }

        public void setCurrent(int current) {
            this.current = current;
        }

        @Override
        public void run() {//模拟
            while(current <= amount){
                //先让执行的主线程休眠
                try {
                    Thread.currentThread().sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                //然后进度条进度增加
                current++;
            }
        }
    }
    public static void main(String[] args) {
        new JProgressBar_2().init();
    }
}
