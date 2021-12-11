package jiben_zujian;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/*
 public void setDefaultCloseOperation(int operation)设置用户在此窗体上发起 "close" 时默认执行的操作。
 必须指定以下选项之一：

    DO_NOTHING_ON_CLOSE（在 WindowConstants 中定义）：不执行任何操作；要求程序在已注册的 WindowListener 对象的 windowClosing 方法中处理该操作。
    HIDE_ON_CLOSE（在 WindowConstants 中定义）：调用任意已注册的 WindowListener 对象后自动隐藏该窗体。
    DISPOSE_ON_CLOSE（在 WindowConstants 中定义）：调用任意已注册 WindowListener 的对象后自动隐藏并释放该窗体。
    EXIT_ON_CLOSE（在 JFrame 中定义）：使用 System exit 方法退出应用程序。仅在应用程序中使用。
    默认情况下，该值被设置为 HIDE_ON_CLOSE。更改此属性的值将导致激发属性更改事件，其属性名称为 "defaultCloseOperation"。


 static Color showDialog(Component component, String title, Color initialColor)
          显示有模式的颜色选取器，在隐藏对话框之前一直阻塞。
  void setBackground(Color bg)
          设置此组件的背景色。
*/
public class JColorChooser_ {
    JFrame jFrame = new JFrame("测试颜色选择器");

    JTextArea jta = new JTextArea("我爱中华", 6, 30);

    //声明按钮
    JButton btn = new JButton(new AbstractAction("改变文本框背景颜色") {
        @Override
        public void actionPerformed(ActionEvent e) {
            //弹出颜色选择框
            Color result = JColorChooser.showDialog(jFrame, "颜色选择器", Color.WHITE);

            //设置文本框背景颜色
            jta.setBackground(result);
        }
    });

    public void init(){
        //组装视图
        jFrame.add(jta);
        jFrame.add(btn,BorderLayout.SOUTH);

        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setVisible(true);
    }
    public static void main(String[] args) {
        new JColorChooser_().init();
    }
}
