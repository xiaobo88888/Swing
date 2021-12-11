package liebiaokuang_;

import javax.swing.*;
import java.awt.*;

public class Demo_ListCellRenderer {
    private JFrame jFrame = new JFrame("测试ListCellRenderer");

    private String[] friends = {
            "black",
            "selected",
            "white"
    };

    //定义一个JList对象
    JList friendList = new JList(friends);

    private void init(){
        //组装视图
        //给JList设置ListCellRenderer对象，指定列表项绘制的组件
        friendList.setCellRenderer(new MyRenderer());


        jFrame.add(friendList);


        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setVisible(true);
    }

    private class MyRenderer extends JPanel implements ListCellRenderer{//继承了JPanel，所以重写方法处就能返回this，而这个this就是一个Component
        private String name;
        private ImageIcon icon;

        //列表项的背景色
        private Color backColor;
        //列表项的前景色
        private Color foreColor;

        @Override
        public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            //重置成员变量值

            this.name = value.toString();

            this.icon = new ImageIcon("E:\\Projects_IDEA\\Swing_\\Img\\" + name + ".png");

            this.backColor = isSelected ? list.getSelectionBackground() : list.getBackground();

            this.foreColor = isSelected ? list.getSelectionForeground() : list.getForeground();

            return this;
        }

        //设置列表项大小
        @Override
        public Dimension getPreferredSize() {
            return new Dimension(44, 74);
        }

        //绘制列表项内容
        @Override
        public void paint(Graphics g) {
            int imageWidth = icon.getImage().getWidth(null);
            int imageHeight = icon.getImage().getHeight(null);

            //填充背景矩形
            g.setColor(backColor);
            g.fillRect(0, 0, getWidth(), getHeight());

            //绘制头像
            g.drawImage(icon.getImage(), getWidth() / 2 - imageWidth / 2, 10, null);

            //绘制昵称
            g.setColor(foreColor);
            g.setFont(new Font("StSong", Font.BOLD, 18));
            g.drawString(this.name, getWidth() / 2 - this.name.length() * 20 / 2, 10 + imageHeight + 10);
        }
    }
    public static void main(String[] args) {
        new Demo_ListCellRenderer().init();
    }
}
