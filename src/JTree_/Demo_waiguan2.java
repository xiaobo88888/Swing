package JTree_;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import java.awt.*;

public class Demo_waiguan2 {
    JFrame jFrame = new JFrame("根据结点类型定义图标");

    JTree jTree;

    //初始化五个图标
    ImageIcon rootIcon = new ImageIcon("E:\\Projects_IDEA\\Swing_\\Img\\六角形.png");
    ImageIcon databaseIcon = new ImageIcon("E:\\Projects_IDEA\\Swing_\\Img\\五角星.png");
    ImageIcon tableIcon = new ImageIcon("E:\\Projects_IDEA\\Swing_\\Img\\五边形.png");
    ImageIcon columnIcon = new ImageIcon("E:\\Projects_IDEA\\Swing_\\Img\\菱形.png");
    ImageIcon indexIcon = new ImageIcon("E:\\Projects_IDEA\\Swing_\\Img\\三角形.png");


    //定义一个类，封装结点数据
    class NodeData{
        private ImageIcon icon;
        private String name;

        public NodeData(ImageIcon icon, String name) {
            this.icon = icon;
            this.name = name;
        }



    }



    //定义初始结点
    DefaultMutableTreeNode root = new DefaultMutableTreeNode(new NodeData(rootIcon, "数据库导航"));
    DefaultMutableTreeNode salaryDb = new DefaultMutableTreeNode(new NodeData(databaseIcon, "公司工资数据库"));
    DefaultMutableTreeNode customerDb = new DefaultMutableTreeNode(new NodeData(databaseIcon, "公司客户数据库"));
    DefaultMutableTreeNode employee = new DefaultMutableTreeNode(new NodeData(tableIcon, "员工表"));
    DefaultMutableTreeNode attend = new DefaultMutableTreeNode(new NodeData(tableIcon, "考勤表"));
    DefaultMutableTreeNode concat = new DefaultMutableTreeNode(new NodeData(tableIcon, "通讯表"));
    DefaultMutableTreeNode id = new DefaultMutableTreeNode(new NodeData(indexIcon, "员工id"));
    DefaultMutableTreeNode name = new DefaultMutableTreeNode(new NodeData(columnIcon, "姓名"));
    DefaultMutableTreeNode gender = new DefaultMutableTreeNode(new NodeData(columnIcon, "性别"));

    private void init(){
        //建立层级关系
        root.add(salaryDb);
        root.add(customerDb);

        salaryDb.add(employee);
        salaryDb.add(attend);

        customerDb.add(concat);

        concat.add(id);
        concat.add(name);
        concat.add(gender);

        //创建树
        JTree jTree = new JTree(root);

        //TODO 通过扩展DefaultTreeCellRenderer修改外观
        jTree.setCellRenderer(new MyRenderer());


        jFrame.add(new JScrollPane(jTree));
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setVisible(true);
    }

    //自定义类，继承DefaultTreeCellRenderer
    private class MyRenderer extends DefaultTreeCellRenderer{
        //因为DefaultTreeCellRenderer继承自JLabel，所以可以return this，this就是一个组件

        //重写方法


        @Override
        public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf, int row, boolean hasFocus) {
            //当前这个类简介继承了JLabel这个组件类，展示一张图片和文字
            //Object value这个参数，代表的就是结点


            //获取当前结点
            DefaultMutableTreeNode node = (DefaultMutableTreeNode) value;

            //获取当前结点的图标和文字
            //因为在DefaultMutableTreeNode这个类中，参数value最终传递给的是userObject，所以可以通过getUserObject来获取
            //这里的value，就是我们创建结点时传递的参数，现在的参数是一个NodeData类

            NodeData nodeData = (NodeData) node.getUserObject();

            //通过setText和setIcon方法完成设置
            this.setText(nodeData.name);
            this.setIcon(nodeData.icon);

            return this;
        }
    }
    public static void main(String[] args) {
        new Demo_waiguan2().init();
    }
}
