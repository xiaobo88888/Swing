package teshu_rongqi;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class JTabbedPane_ {
    JFrame jFrame = new JFrame("测试JTabledPane");

    JTabbedPane jTabbledPane = new JTabbedPane(SwingConstants.LEFT, JTabbedPane.SCROLL_TAB_LAYOUT);

    private void init(){
        //组装视图

        //添加标签
        jTabbledPane.addTab("用户管理", new ImageIcon("E:\\projects_IDEA\\Swing_\\Img\\black.png"),
                new JList<String>(new String[]{"用户一", "用户二", "用户三"}));
        jTabbledPane.addTab("商品管理",
                new JList<String>(new String[]{"商品一", "商品二", "商品三"}));
        jTabbledPane.addTab("订单管理", new ImageIcon("E:\\projects_IDEA\\Swing_\\Img\\white.png"),
                new JList<String>(new String[]{"订单一", "订单二", "订单三"}), "这里显示的是订单");


        //设置标签
        jTabbledPane.setEnabledAt(0, false);//第一个标签禁用
        jTabbledPane.setSelectedIndex(1);//第二个标签被默认选中


        //监听标签被点击后的事件
        jTabbledPane.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                //获取被选中的标签的索引
                int selectedIndex = jTabbledPane.getSelectedIndex();

                //弹出一个对话框
                JOptionPane.showMessageDialog(jFrame, "当前选中的是第" + (selectedIndex + 1) + "的标签");
            }
        });


        jFrame.add(jTabbledPane);

        //设置窗口的位置和大小
        jFrame.setBounds(400, 400, 400, 400);

        //设置窗口大小固定
        jFrame.setResizable(false);

        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
    }
    public static void main(String[] args) {
        new JTabbedPane_().init();
    }
}
