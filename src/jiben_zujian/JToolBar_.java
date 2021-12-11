package jiben_zujian;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/*
    JToolBar 提供了一个用来显示常用的 Action 或控件的组件。
        JToolBar(String name, int orientation)
            创建一个具有指定 name 和 orientation 的新工具栏。
            name - 工具栏的名称
            orientation - 初始方向，它不是 HORIZONTAL 就是 VERTICAL

        void addSeparator()
            将默认大小的分隔符添加到工具栏的末尾。
        void addSeparator(Dimension size)
            将指定大小的分隔符添加到工具栏的末尾


     Dimension 类封装单个对象中组件的宽度和高度（精确到整数）。
        Dimension(int width, int height)
            构造一个 Dimension，并将其初始化为指定宽度和高度。


     JButton(Action a)
          创建一个按钮，其属性从所提供的 Action 中获取。


     JScrollPane(Component view)
          创建一个显示指定组件内容的 JScrollPane，只要组件的内容超过视图大小就会显示水平和垂直滚动条。

 */
public class JToolBar_ {
    private JFrame jFrame = new JFrame("JToolBar测试");

    private JTextArea jta = new JTextArea(8, 40);

    //创建工具条对象
    JToolBar jToolBar = new JToolBar("测试工具条", JToolBar.HORIZONTAL);

    //创建三个Action对象
    Action pre = new AbstractAction("上一曲", new ImageIcon("E:\\projects_IDEA\\Swing_\\Img\\black.png")) {
        @Override
        public void actionPerformed(ActionEvent e) {
            jta.append("上一曲\n");
        }
    };

    Action pause = new AbstractAction("暂停", new ImageIcon("E:\\projects_IDEA\\Swing_\\Img\\selected.png")) {
        @Override
        public void actionPerformed(ActionEvent e) {
            jta.append("暂停\n");
        }
    };

    Action next = new AbstractAction("下一曲", new ImageIcon("E:\\projects_IDEA\\Swing_\\Img\\white.png")) {
        @Override
        public void actionPerformed(ActionEvent e) {
            jta.append("下一曲\n");
        }
    };
    private void demo(){

        //组装视图

        //通过Action对象来创建Button——解决按钮没有名字的情况
        JButton preBtn = new JButton(pre);
        JButton pauseBtn = new JButton(pause);
        JButton nextBtn = new JButton(next);

        //先组装工具条
        jToolBar.add(preBtn);
        jToolBar.addSeparator();
        jToolBar.add(pauseBtn);
        jToolBar.addSeparator(new Dimension(20,10));
        jToolBar.add(nextBtn);

        //设置工具条拖动
        jToolBar.setFloatable(true);

        //JTextArea是不支持滚动条的
        //将一个组件设置到JScrollPane中，那么该组件就支持滚动条了
        JScrollPane jScrollPane = new JScrollPane(jta);

        jFrame.add(jToolBar,BorderLayout.NORTH);

//        jFrame.add(jta);
        jFrame.add(jScrollPane);

        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setVisible(true);
    }

    public static void main(String[] args) {
        new JToolBar_().demo();
    }
}
