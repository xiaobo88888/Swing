package JTree_;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeCellRenderer;
import java.awt.*;

public class Demo_waiguan3 {
    JFrame jFrame = new JFrame("定制树的结点");

    JTree jTree;

    //定义初始结点
    DefaultMutableTreeNode myFriend = new DefaultMutableTreeNode("六角形");
    DefaultMutableTreeNode meiqiu = new DefaultMutableTreeNode("三角形");
    DefaultMutableTreeNode gaohui = new DefaultMutableTreeNode("菱形");
    DefaultMutableTreeNode zisheng = new DefaultMutableTreeNode("五角星");
    DefaultMutableTreeNode wenchang = new DefaultMutableTreeNode("五边形");


    private void init(){
        myFriend.add(meiqiu);
        myFriend.add(gaohui);
        myFriend.add(zisheng);
        myFriend.add(wenchang);

        jTree = new JTree(myFriend);

        // TODO 设置结点绘制器
        jTree.setCellRenderer(new MyRenderer());


        jFrame.add(new JScrollPane(jTree));
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setVisible(true);
    }

    //自定义类，实现TreeCellRenderer接口
    private class MyRenderer extends JPanel implements TreeCellRenderer{//可以自定义继承一个JPanel

        private ImageIcon icon;
        private String name;
        private Color backColor;
        private Color foreColor;


        @Override
        public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected, boolean expanded, boolean leaf, int row, boolean hasFocus) {

            //给成员变量设置值
            this.icon = new ImageIcon("E:\\Projects_IDEA\\Swing_\\Img\\"+value.toString()+".png");
            this.name = value.toString();
            backColor = hasFocus ? new Color(144, 200, 225): Color.WHITE;
            foreColor = hasFocus ? new Color(225,225, 3) : Color.BLACK;


            return this;
        }


        //通过重写getPreferredSize方法，指定当前组件大小

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(80, 80);
        }

        //重写paint方法，绘制结点

        @Override
        public void paint(Graphics g) {
            //绘制组件内容

            int iconWidth = this.icon.getIconWidth();
            int iconHeight = this.icon.getIconHeight();

            //填充背景
            g.setColor(backColor);
            g.fillRect(0,0,this.getWidth(), this.getHeight());

            //绘制头像
            g.drawImage(this.icon.getImage(), this.getWidth() / 2 - iconWidth / 2, this.getHeight() / 2 - iconHeight / 2, null);

            //绘制昵称
            g.setColor(foreColor);

            g.setFont(new Font("StSong", Font.BOLD,18));

            g.drawString(this.name, this.getWidth() / 2 - this.name.length() * 20 / 2, iconHeight + 30);
        }
    }
    public static void main(String[] args) {
        new Demo_waiguan3().init();
    }
}
