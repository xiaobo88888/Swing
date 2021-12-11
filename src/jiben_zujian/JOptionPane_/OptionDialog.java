package jiben_zujian.JOptionPane_;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/*public static int showOptionDialog(Component parentComponent,
        Object message,
        String title,
        int optionType,
        int messageType,
        Icon icon,
        Object[] options,
        Object initialValue)
        throws HeadlessException调出一个带有指定图标的对话框，其中的初始选择由 initialValue 参数确定，选项数由 optionType 参数确定。
        如果 optionType 为 YES_NO_OPTION 或者 YES_NO_CANCEL_OPTION，并且 options 参数为 null，则由外观提供选项。

        messageType 参数主要用于提供来自外观的默认图标。


        参数：
        parentComponent - 确定在其中显示对话框的 Frame；如果为 null 或者 parentComponent 不具有 Frame，则使用默认的 Frame
        message - 要显示的 Object
        title - 对话框的标题字符串
        optionType - 指定可用于对话框的选项的整数：DEFAULT_OPTION、YES_NO_OPTION、YES_NO_CANCEL_OPTION 或 OK_CANCEL_OPTION
        messageType - 指定消息种类的整数，主要用于确定来自可插入外观的图标：ERROR_MESSAGE、INFORMATION_MESSAGE、WARNING_MESSAGE、QUESTION_MESSAGE 或 PLAIN_MESSAGE
        icon - 在对话框中显示的图标
        options - 指示用户可能选择的对象组成的数组；如果对象是组件，则可以正确呈现；非 String 对象使用其 toString 方法呈现；如果此参数为 null，则由外观确定选项
        initialValue - 表示对话框的默认选择的对象；只有在使用 options 时才有意义；可以为 null
        返回：
        指示用户所选选项的整数；如果用户关闭了对话框，则返回 CLOSED_OPTION*/
public class OptionDialog {
    JFrame jFrame = new JFrame("测试选项对话框");

    JTextArea jta = new JTextArea(6, 30);

    //定义按钮
    JButton btn = new JButton(new AbstractAction("弹出选项对话框") {
        @Override
        public void actionPerformed(ActionEvent e) {
            //弹出选项对话框
            int result = JOptionPane.showOptionDialog(jFrame, "请选择您的身份", "选项对话框", JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE, null, new String[]{"学生", "老师", "管理者"}, "中号");

            switch(result){
                case 0 :
                    jta.append("用户选择了学生\n");
                    break;
                case 1 :
                    jta.append("用户选择了老师\n");
                    break;
                case 2 :
                    jta.append("用户选择了管理者\n");
                    break;
            }

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
        new OptionDialog().init();
    }
}
