package JTree_;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;

public class Demo2 {
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

        //JTree的外观设置
        /*jTree.putClientProperty("JTree.lineStyle", "none");//设置结点之间没有连接线
        jTree.putClientProperty("JTree.lineStyle", "Horizontal");//设置结点只有水平连接线*/

        // 将JTree对象放入窗口展示
        jFrame.add(jTree);


        //DefaultMutableTreeNode部分成员方法展示
        DefaultMutableTreeNode nextNode = guangdong.getNextSibling();//返回此结点的下一个兄弟结点
        System.out.println(nextNode);

        TreeNode nodeParent = guangdong.getParent();//返回此结点的父节点，如果没有父结点，则返回null
        System.out.println(nodeParent);

        System.out.println(jian.isLeaf());//判断该结点是否是叶子结点

        System.out.println(root.isRoot());//判断该结点是否是根结点

        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setVisible(true);
    }
    public static void main(String[] args) {
        new Demo2().init();
    }
}
