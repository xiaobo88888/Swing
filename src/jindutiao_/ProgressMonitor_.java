package jindutiao_;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProgressMonitor_ {
    //创建进度对话框
    ProgressMonitor monitor = new ProgressMonitor(null,"等待任务完成", "已完成", 0, 100);

    Timer timer;
    private void init(){
        //创建线程任务，模拟线程
        SimulaterActivity simulaterActivity = new SimulaterActivity(100);
        new Thread(simulaterActivity).start();

        //设置定时任务
        timer = new Timer(200, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //读取当前任务量，修改进度
                int current = simulaterActivity.getCurrent();
                monitor.setProgress(current);

                //判断用户是否点击了取消按钮，如果点击了，就停止定时任务，关闭对话框，退出程序
                if(monitor.isCanceled()){
                    timer.stop();
                    monitor.close();
                    System.exit(0);
                }
            }
        });

        timer.start();
    }

    public static void main(String[] args) {
        new ProgressMonitor_().init();
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
}
