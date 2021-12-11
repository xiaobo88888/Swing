package jiben_zujian;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/*static boolean write(RenderedImage im, String formatName, File output)
        使用支持给定格式的任意 ImageWriter 将一个图像写入 File。

void setJMenuBar(JMenuBar menubar)
          设置此窗体的菜单栏。

void setPreferredSize(Dimension preferredSize)
          设置此组件的首选大小。
*/
public class JFileChooser_ {
    //创建窗口对象
    JFrame jFrame = new JFrame("文件对话框测试");

    //创建菜单条
    JMenuBar jMenuBar = new JMenuBar();

    //创建菜单
    JMenu jMenu = new JMenu("文件");

    //创建打开菜单项
    JMenuItem open = new JMenuItem(new AbstractAction("打开") {
        @Override
        public void actionPerformed(ActionEvent e) {
            //显示一个文件选择器
            JFileChooser jFileChooser = new JFileChooser(".");
            jFileChooser.showOpenDialog(jFrame);

            //获取用户选择的文件
            File file = jFileChooser.getSelectedFile();

            //进行显示
            try {
                image = ImageIO.read(file);
                drawCanvas.repaint();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    });

    //创建另存为菜单项
    JMenuItem save = new JMenuItem(new AbstractAction("另存为") {
        @Override
        public void actionPerformed(ActionEvent e) {
            //显示一个文件选择器
            JFileChooser jFileChooser = new JFileChooser(".");
            jFileChooser.showSaveDialog(jFrame);

            //获取用户选择的保存文件路径
            File file = jFileChooser.getSelectedFile();

            try {
                ImageIO.write(image, "jpeg", file);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    });

    //声明一个图片
    BufferedImage image;

    //创建画布类
    //这里就不需要像AWT一样，继承Canvas类了，因为swing提供的组件都采用了图像缓冲技术，用户有更好的体验
    private class MyCanvas extends JPanel{
        @Override
        public void paint(Graphics g) {
            //把图片绘制到组件上
            g.drawImage(image, 0, 0, null);
        }
    }

    //创建画布对象
    MyCanvas drawCanvas = new MyCanvas();

    public void init(){
        //组装视图
        jMenu.add(open);
        jMenu.add(save);

        jMenuBar.add(jMenu);

        jFrame.setJMenuBar(jMenuBar);

        drawCanvas.setPreferredSize(new Dimension(700, 700));
        jFrame.add(drawCanvas);


        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setVisible(true);
    }
    public static void main(String[] args) {
        new JFileChooser_().init();
    }
}
