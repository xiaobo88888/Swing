package jiben_zujian.JOptionPane_;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/*String getText()
        返回此 TextComponent 中包含的文本。


  public static void showMessageDialog(Component parentComponent,
                                     Object message,
                                     String title,
                                     int messageType)
                              throws HeadlessException调出对话框，它显示使用由 messageType 参数确定的默认图标的 message。

参数：
parentComponent - 确定在其中显示对话框的 Frame；如果为 null 或者 parentComponent 不具有 Frame，则使用默认的 Frame
message - 要显示的 Object
title - 对话框的标题字符串
messageType - 要显示的消息类型：ERROR_MESSAGE、INFORMATION_MESSAGE、WARNING_MESSAGE、QUESTION_MESSAGE 或 PLAIN_MESSAGE


public static void showMessageDialog(Component parentComponent,
                                     Object message,
                                     String title,
                                     int messageType,
                                     Icon icon)
                              throws HeadlessException调出一个显示信息的对话框，为其指定了所有参数。

参数：
parentComponent - 确定在其中显示对话框的 Frame；如果为 null 或者 parentComponent 不具有 Frame，则使用默认的 Frame
message - 要显示的 Object
title - 对话框的标题字符串
messageType - 要显示的消息类型：ERROR_MESSAGE、INFORMATION_MESSAGE、WARNING_MESSAGE、QUESTION_MESSAGE 或 PLAIN_MESSAGE
icon - 要在对话框中显示的图标，该图标可以帮助用户识别要显示的消息种类*/
public class MessageDialog {
    JFrame jFrame = new JFrame("测试消息对话框");

    JTextArea jta = new JTextArea(6, 30);

    //声明按钮
    JButton btn = new JButton(new AbstractAction("弹出消息对话框") {
        @Override
        public void actionPerformed(ActionEvent e) {
            //弹出消息对话框并且讲文本域的内容显示出来
            String text = jta.getText();

            //参数 int messageType  是指定消息对话框的类型：错误消息，警告消息，问题消息
//            JOptionPane.showMessageDialog(jFrame, text, "消息对话框", JOptionPane.ERROR_MESSAGE);
//            JOptionPane.showMessageDialog(jFrame, text, "消息对话框", JOptionPane.INFORMATION_MESSAGE);
//            JOptionPane.showMessageDialog(jFrame, text, "消息对话框", JOptionPane.WARNING_MESSAGE);
//            JOptionPane.showMessageDialog(jFrame, text, "消息对话框", JOptionPane.PLAIN_MESSAGE);
//            JOptionPane.showMessageDialog(jFrame, text, "消息对话框", JOptionPane.QUESTION_MESSAGE);

            //自己定义图标
            JOptionPane.showMessageDialog(jFrame, text, "消息对话框", JOptionPane.ERROR_MESSAGE, new ImageIcon("E:\\Projects_IDEA\\Swing_\\Img\\black.png"));
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
        new MessageDialog().init();
    }
}
