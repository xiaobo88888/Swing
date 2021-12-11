package jiben_zujian.JOptionPane_;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/*public static int showConfirmDialog(Component parentComponent,
        Object message,
        String title,
        int optionType)
        throws HeadlessException调出一个由 optionType 参数确定其中选项数的对话框。

        参数：
        parentComponent - 确定在其中显示对话框的 Frame；如果为 null 或者 parentComponent 不具有 Frame，则使用默认的 Frame
        message - 要显示的 Object
        title - 对话框的标题字符串
        optionType - 指定可用于对话框的选项的 int：YES_NO_OPTION、YES_NO_CANCEL_OPTION 或 OK_CANCEL_OPTION
        返回：
        指示用户所选选项的 int*/

public class ConfirmDialog {
    JFrame jFrame = new JFrame("测试确认对话框");

    JTextArea jta = new JTextArea(6, 30);

    //定义按钮
    JButton btn = new JButton(new AbstractAction("弹出确认对话框") {
        @Override
        public void actionPerformed(ActionEvent e) {
            //弹出确认对话框
            String text = jta.getText();
            jta.append("\n");

            //这里的参数 int optionType 是指确认对话框的类型：DEFAULT_OPTION, YES_OPTION,YES_NO_OPTION,YES_NO_CANCEL_OPTION,OK_CANCEL_OPTION
            int result = JOptionPane.showConfirmDialog(jFrame, text, "确认对话框", JOptionPane.YES_NO_CANCEL_OPTION);

            //注意这里YES_OPTION和OK_OPTION的int值是一样的，因为“是”和“确定”都是一个意思
            //是选项和确定选项不会同时出现
            if(result == JOptionPane.YES_OPTION){
                jta.append("用户点击了 是 按钮\n");
            }
            if(result == JOptionPane.NO_OPTION){
                jta.append("用户点击了 否 按钮\n");
            }
            if(result == JOptionPane.OK_OPTION){
                jta.append("用户点击了 确认 按钮\n");
            }if(result == JOptionPane.CANCEL_OPTION){
                jta.append("用户点击了 取消 按钮\n");
            }


        }
    });
    private void init(){
        //组装视图
//        jFrame.add(jta);
        //JTextArea是不支持滚动条的，所以可以将JTextArea放置到JScrollPane中，这样就支持滚动条了
        JScrollPane jScrollPane = new JScrollPane(jta);
        jFrame.add(jScrollPane);
        jFrame.add(btn, BorderLayout.SOUTH);

        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setVisible(true);
    }
    public static void main(String[] args) {
        new ConfirmDialog().init();
    }
}
