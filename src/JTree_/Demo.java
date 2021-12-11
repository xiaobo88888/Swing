package JTree_;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;

public class Demo {
    JFrame jFrame = new JFrame("测试JTree 1");

    private void init(){
        // 创建DefaultMutableTreeNode对象代表结点
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("中国");
        DefaultMutableTreeNode jiangxi = new DefaultMutableTreeNode("江西");
        DefaultMutableTreeNode jian = new DefaultMutableTreeNode("吉安");
        DefaultMutableTreeNode ganzhou = new DefaultMutableTreeNode("赣州");
        DefaultMutableTreeNode anfu = new DefaultMutableTreeNode("安福");
        DefaultMutableTreeNode guangdong = new DefaultMutableTreeNode("广东");
        DefaultMutableTreeNode guangzhou = new DefaultMutableTreeNode("广州");
        DefaultMutableTreeNode shenzhen = new DefaultMutableTreeNode("深圳");


        // 组装结点之间的关系
        root.add(jiangxi);
        root.add(guangdong);

        jiangxi.add(jian);
        jiangxi.add(ganzhou);

        jian.add(anfu);

        guangdong.add(guangzhou);
        guangdong.add(shenzhen);


        // 创建JTree对象
        JTree jTree = new JTree(root);

        // 将JTree对象放入窗口展示
        jFrame.add(jTree);


        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setVisible(true);
    }
    public static void main(String[] args) {
        new Demo().init();
    }
}
