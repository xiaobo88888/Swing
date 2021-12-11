package jiben_zujian.JOptionPane_;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/*static int INFORMATION_MESSAGE
        用于信息消息。

  public static String showInputDialog(Component parentComponent,
                                     Object message,
                                     String title,
                                     int messageType)
                              throws HeadlessException显示请求用户输入内容的对话框，
                              它以 parentComponent 为父级，该对话框的标题为 title，消息类型为 messageType。

参数：
parentComponent - 对话框的父 Component
message - 要显示的 Object
title - 要在对话框的标题栏中显示的 String
messageType - 要显示的消息类型：ERROR_MESSAGE、INFORMATION_MESSAGE、WARNING_MESSAGE、QUESTION_MESSAGE 或 PLAIN_MESSAGE*/
public class InputDialog {
    JFrame jFrame = new JFrame("测试输入对话框");

    JTextArea jta = new JTextArea(6, 30);

    //定义按钮
    JButton btn = new JButton(new AbstractAction("弹出输入对话框") {
        @Override
        public void actionPerformed(ActionEvent e) {
            //弹出输入对话框
            String result = JOptionPane.showInputDialog(jFrame, "请输入您的学生号：", "输入对话框", JOptionPane.INFORMATION_MESSAGE);

            jta.append(result + "\n");
        }
    });

    private void init(){
        //组装视图
        jFrame.add(jta);
        jFrame.add(btn, BorderLayout.SOUTH);

        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setVisible(true);
    }
    public static void main(String[] args) {
        new InputDialog().init();
    }
}
