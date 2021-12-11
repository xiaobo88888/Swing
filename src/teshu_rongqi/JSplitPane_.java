package teshu_rongqi;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;

/*Book 类提供文档的表示形式，该文档的页面可以使用不同的页面格式和页面 painter。
*
* JList(Object[] listData)
          构造一个 JList，使其显示指定数组中的元素。

* ListSelectionListener：列表选择值发生更改时收到通知的侦听器
*
* Object getSelectedValue()
          返回最小的选择单元索引的值；只选择了列表中单个项时，返回所选值。


JSplitPane(int newOrientation, Component newLeftComponent, Component newRightComponent)
          创建一个具有指定方向和不连续重绘的指定组件的新 JSplitPane。

*
* static int HORIZONTAL_SPLIT
          水平分割表示 Component 沿 x 轴分割

* static int VERTICAL_SPLIT
          垂直分割表示 Component 沿 y 轴分割。

*  void setOneTouchExpandable(boolean newValue)
          设置 oneTouchExpandable 属性的值，要使 JSplitPane 在分隔条上提供一个 UI 小部件来快速展开/折叠分隔条，
          * 此属性必须为 true。

* void setDividerSize(int newSize)
          设置分隔条的大小。

* void setContinuousLayout(boolean newContinuousLayout)
          设置 continuousLayout 属性的值，在用户干预期要使子组件连续地重新显示和布局子组件，此值必须为 true

* */
public class JSplitPane_ {
    JFrame jFrame = new JFrame("测试JSplitPane");

    //书的信息
    Book_[] books = {new Book_("java自学宝典", new ImageIcon("E:\\projects_IDEA\\Swing_\\Img\\table.png"), "国内关于java编程最全的书\n自学宝典"),
            new Book_("轻量级的javaee企业应用实战", new ImageIcon("E:\\projects_IDEA\\Swing_\\Img\\selected.png"), "SSM整合开发的经典图书，值得拥有")};


    //声明组件
    JList<Book_> bookJList = new JList<>(books);//这里穿的是一个数组，但是在窗口中显示的是<>中类的toString方法返回的值

    JLabel bookIcon = new JLabel();

    JTextArea bookDesc = new JTextArea();

    private void init(){
        //组装视图

        //设定组件大小
        bookJList.setPreferredSize(new Dimension(150, 400));
        bookIcon.setPreferredSize(new Dimension(220, 270));
        bookDesc.setPreferredSize(new Dimension(220, 130));

        //为JList选中项添加条目选中监听器
        bookJList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                //获取当前选中的条目
                Book_ book_ = bookJList.getSelectedValue();

                //在bookIcon中展示书籍中的图片
                bookIcon.setIcon(book_.getIcon());

                //在bookDesc中展示书籍中的描述信息
                bookDesc.setText(book_.getDesc());
            }
        });

        //组装左边区域
        JSplitPane left = new JSplitPane(JSplitPane.VERTICAL_SPLIT, bookIcon, new JScrollPane(bookDesc));
        //左边分割条支持一触即展
        left.setOneTouchExpandable(true);

        //组装整体
        JSplitPane hole = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, left, bookJList);
        //整体设置连续布局
        hole.setContinuousLayout(true);
        //给分割条设置大小
        hole.setDividerSize(10);

        jFrame.add(hole);

        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setVisible(true);
    }
    public static void main(String[] args) {
        new JSplitPane_().init();
    }
}
