package JTree_;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import java.awt.*;

/*void setCellRenderer(TreeCellRenderer x)
          设置将用于绘制每个单元格的 TreeCellRenderer */

public class Demo_waiguan {
    JFrame jFrame = new JFrame("改变结点外观");

    JTree jTree;

    DefaultMutableTreeNode root = new DefaultMutableTreeNode("中国");
    DefaultMutableTreeNode jiangxi = new DefaultMutableTreeNode("江西");
    DefaultMutableTreeNode jian = new DefaultMutableTreeNode("吉安");
    DefaultMutableTreeNode ganzhou = new DefaultMutableTreeNode("赣州");
    DefaultMutableTreeNode anfu = new DefaultMutableTreeNode("安福");
    DefaultMutableTreeNode guangdong = new DefaultMutableTreeNode("广东");
    DefaultMutableTreeNode guangzhou = new DefaultMutableTreeNode("广州");
    DefaultMutableTreeNode shenzhen = new DefaultMutableTreeNode("深圳");

    private void init(){
        //通过add方法建立父子层级关系
        root.add(jiangxi);
        root.add(guangdong);

        jiangxi.add(jian);
        jiangxi.add(ganzhou);

        jian.add(anfu);

        guangdong.add(guangzhou);
        guangdong.add(shenzhen);

        jTree = new JTree(root);

        DefaultTreeCellRenderer renderer = new DefaultTreeCellRenderer();

        //设置非选定结点的背景颜色
        renderer.setBackgroundNonSelectionColor(new Color(220,220,220));

        //设置选中结点的背景色
        renderer.setBackgroundSelectionColor(new Color(140,140,140));

        //设置选中状态下结点的边框颜色
        renderer.setBorderSelectionColor(Color.BLACK);

        //设置处于折叠状态下非叶子结点的图标
        renderer.setClosedIcon(new ImageIcon("E:\\Projects_IDEA\\Swing_\\Img\\black.png"));

        //设置结点文本的字体
        renderer.setFont(new Font("StSong", Font.BOLD, 15));

        //设置叶子结点的图标
        renderer.setLeafIcon(new ImageIcon("E:\\Projects_IDEA\\Swing_\\Img\\selected.png"));

        //设置处于展开状态下非叶子结点的图标
        renderer.setOpenIcon(new ImageIcon("E:\\Projects_IDEA\\Swing_\\Img\\white.png"));

        //设置非选中状态下结点文本颜色
        renderer.setTextNonSelectionColor(Color.BLUE);

        //设置选中状态下结点文本的颜色
        renderer.setTextSelectionColor(Color.RED);


        //把结点绘制器设置给树对象
        jTree.setCellRenderer(renderer);


        Box hBox = Box.createHorizontalBox();
        hBox.add(new JScrollPane(jTree));

        jFrame.add(hBox);

        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setVisible(true);

    }
    public static void main(String[] args) {
        new Demo_waiguan().init();
    }
}
