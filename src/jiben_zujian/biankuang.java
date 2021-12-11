package jiben_zujian;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

/*
    GridLayout(int rows, int cols)
        创建具有指定行数和列数的网格布局。


    JLable:用于短文本字符串或图像或二者的显示区。标签不对输入事件作出反应。
        JLabel(String text)
             创建具有指定文本的 JLabel 实例。


    JPanel 是一般轻量级容器。
         void setBorder(Border border)
            设置此组件的边框。


    BevelBorder:该类实现简单的双线斜面边框。
        static int LOWERED
            凹入斜面类型。
        static int RAISED
            凸出斜面类型。


    LineBorder:实现单色、任意厚度线边框的类。
        LineBorder(Color color, int thickness)
            创建具有指定颜色和厚度的线边框。


    EmptyBorder:该类提供了一个占用空间但不执行绘制的空透明边框。
        EmptyBorder(int top, int left, int bottom, int right)
            创建具有指定 insets 的空边框


    EtchedBorder:该类实现简单的浮雕化边框，它既可以是阴刻浮雕化边框，也可以是阳刻浮雕化边框。
        EtchedBorder(int etchType, Color highlight, Color shadow)
            创建具有指定蚀刻类型、高亮显示和阴影颜色的浮雕化边框

        static int LOWERED
            阴刻浮雕化类型。
        static int RAISED
            阳刻浮雕化类型。

    TitleBorder:该类实现在指定位置以指定对齐方式显示字符串标题的任意边框。
        TitledBorder(Border border, String title)
            创建具有指定边框和标题的 TitledBorder 实例

        TitledBorder(Border border, String title, int titleJustification, int titlePosition, Font titleFont, Color titleColor)
            用指定的边框、标题、标题对齐方式、标题位置、标题字体和标题颜色创建 TitledBorder 实例。

        static int BOTTOM
            将标题置于边框底端线的中部。

        static int LEFT
            将标题文本置于边框线的左边


    MatteBorder:该类提供类似衬边的边框，衬边图案既可以是纯色也可以是平铺的图标。
        MatteBorder(int top, int left, int bottom, int right, Color matteColor)
            创建具有指定 insets 和颜色的衬边边框


    CompoundBorder:一个复合 Border 类，通过将内部 Border 对象嵌套到外部 Border 对象的 insets 中实现将两个 Border 对象合并为一个单个边框。
        CompoundBorder(Border outsideBorder, Border insideBorder)
            按照指定的内部边框和外部边框创建组合边框。


    Font 类表示字体，可以使用它以可见方式呈现文本。
        Font(String name, int style, int size)
            根据指定名称、样式和磅值大小，创建一个新 Font。


    BorderFactory:提供标准 Border 对象的工厂类。
        static Border createBevelBorder(int type, Color highlightOuter, Color highlightInner, Color shadowOuter, Color shadowInner)
            创建一个指定类型的斜面边框，使用内部和外部高亮显示区域及阴影区域的指定颜色。

        static Border createLineBorder(Color color, int thickness)
            创建一个具有指定颜色和宽度的线边框

        static Border createEmptyBorder(int top, int left, int bottom, int right)
            创建一个占用空间但没有绘制的空边框，指定了顶线、底线、左边框线和右边框线的宽度。

        static Border createEtchedBorder(Color highlight, Color shadow)
            使用指定的高亮显示颜色和阴影颜色创建一个具有“浮雕化”外观效果的边框。
 */
public class biankuang {
    JFrame jf = new JFrame("测试边框");

    //组装视图
    private void demo(){
        //将JFrame的布局修改为GridLayout
        jf.setLayout(new GridLayout(2,4));

        //往网格中填入不同的JPanel组件，并设置边框和内容

        //创建BevelBorder并添加进JFrame中
        Border bevelBorder = BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.RED, Color.GREEN, Color.BLUE, Color.GRAY);
        jf.add(getJPanel(bevelBorder, "BevelBorder"));

        //创建LineBorder并添加进JFrame中
        Border lineBorder = BorderFactory.createLineBorder(Color.ORANGE, 10);
        jf.add(getJPanel(lineBorder, "LineBorder"));

        //创建EmptyBorder并添加到JFrame中
        Border emptyBorder = BorderFactory.createEmptyBorder(10, 20, 30, 10);
        jf.add(getJPanel(emptyBorder, "EmptyBorder"));

        //创建EtchedBorder并添加到JFrame中
        Border etchedBorder = BorderFactory.createEtchedBorder(EtchedBorder.RAISED, Color.RED, Color.GREEN);
        jf.add(getJPanel(etchedBorder, "EtchedBorder"));

        //创建TitleBorder添加到JFrame中
        TitledBorder titledBorder = new TitledBorder(new LineBorder(Color.ORANGE, 10), "测试标题", TitledBorder.LEFT, TitledBorder.BOTTOM, new  Font("StSong", Font.BOLD, 18), Color.BLUE);
        jf.add(getJPanel(titledBorder, "TitleBorder"));

        //创建MatteBorder并添加到JFrame中
        MatteBorder matteBorder = new MatteBorder(10, 20, 30, 10, Color.GREEN);
        jf.add(getJPanel(matteBorder, "MatteBorder"));

        //创建CompoundBorder并添加到JFrame中
        CompoundBorder compoundBorder = new CompoundBorder(new LineBorder(Color.RED, 10),titledBorder);
        jf.add(getJPanel(compoundBorder, "CompoundBorder"));

        //设置窗口最佳大小，并对窗口可见，并设置窗口关闭
        jf.pack();
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    //创建JPanel的方法
    private JPanel getJPanel(Border border, String content){
        JPanel jPanel = new JPanel();
        //设置标签
        jPanel.add(new JLabel(content));
        //设置边框
        jPanel.setBorder(border);

        return jPanel;
    }

    public static void main(String[] args) {
        new biankuang().demo();
    }
}
