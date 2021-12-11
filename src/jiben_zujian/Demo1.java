package jiben_zujian;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
    JList:显示对象列表并且允许用户选择一个或多个项的组件
        JList(Vector<?> listData)
            构造一个 JList，使其显示指定 Vector 中的元素

        JList(Object[] listData)
            构造一个 JList，使其显示指定数组中的元素。


    JComboBox:将按钮或可编辑字段与下拉列表组合的组件
        JComboBox(Vector<?> items)
            创建包含指定 Vector 中的元素的 JComboBox

         void addItem(Object anObject)
            为项列表添加项。


    JRadioButton:实现一个单选按钮，此按钮项可被选择或取消选择，并可为用户显示其状态。
        public JRadioButton(String text,boolean selected)
            创建一个具有指定文本和选择状态的单选按钮。
            text - 单选按钮上显示的字符串
            selected - 如果为 true，按钮被初始化为选择；否则，按钮被初始化为未选择


    ButtonGroup:此类用于为一组按钮创建一个多斥（multiple-exclusion）作用域


    JCheckBox:复选框的实现，复选框是一个可以被选定和取消选定的项，它将其状态显示给用户。
        JCheckBox(String text, boolean selected)
            创建一个带文本的复选框，并指定其最初是否处于选定状态。


    JRadioButtonMenuItem:一个单选按钮菜单项的实现。
        JRadioButtonMenuItem(String text)
            创建一个带文本的 JRadioButtonMenuItem。

        JRadioButtonMenuItem(String text, boolean selected)
            创建一个具有指定文本和选择状态的单选按钮菜单项。


    JMenu:菜单的该实现是一个包含 JMenuItem 的弹出窗口，
        void addSeparator()
            将新分隔符追加到菜单的末尾。


    UIManager 管理当前外观、可用外观集合、
        static void setLookAndFeel(String className)
          使用当前线程的上下文类加载器加载给定类名称所指定的 LookAndFeel，
          并将它传递给 setLookAndFeel(LookAndFeel)。


    JFrame:
         Component getGlassPane()
            返回此窗体的 glassPane 对象。

         void setDefaultCloseOperation(int operation)
            设置用户在此窗体上发起 "close" 时默认执行的操作。
            EXIT_ON_CLOSE（在 JFrame 中定义）：
                使用 System exit 方法退出应用程序。仅在应用程序中使用。


    SwingUtilities:Swing 实用方法的集合。
        static void updateComponentTreeUI(Component c)
            简单的外观更改：将树结构中的每个节点转到 updateUI()
            -- 也就是说，通过当前外观初始化其 UI 属性。


    JComponent:
        void setComponentPopupMenu(JPopupMenu popup)
            设置此 JComponent 的 JPopupMenu


     JButton:"push" 按钮的实现。
        JButton(String text, Icon icon)
            创建一个带初始文本和图标的按钮


     ImageIcon:一个 Icon 接口的实现，它根据 Image 绘制 Icon。
        ImageIcon(String filename)
            根据指定的文件创建一个 ImageIcon


     JMenuItem:菜单中的项的实现。
        JMenuItem(String text, Icon icon)
            创建带有指定文本和图标的 JMenuItem。
 */
 public class Demo1 {
    //创建窗口
    JFrame jFrame = new JFrame("测试Swing基本组件");

    //创建菜单条
    JMenuBar jMenuBar = new JMenuBar();

    //创建菜单和菜单项
    JMenu file = new JMenu("文件");
    JMenu edit = new JMenu("编辑");

    JMenuItem huanhang = new JMenuItem("自动换行");
    JMenuItem fuzhi = new JMenuItem("复制", new ImageIcon("E:\\projects_IDEA\\AWT\\Img\\black.png"));
    JMenuItem zhantie = new JMenuItem("粘贴", new ImageIcon("E:\\projects_IDEA\\AWT\\Img\\white.png"));
    JMenu geshi = new JMenu("格式");

    JMenuItem zhushi = new JMenuItem("注释");
    JMenuItem zhushi_quxiao = new JMenuItem("取消注释");

    //创建文本域
    JTextArea jta = new JTextArea(20, 60);

    //创建List列表
    //创建字符数组，存放JList展示的内容
    String[] colors = {"红色", "蓝色", "绿色"};
    JList<String> colorList = new JList<String>(colors);

    //创建下拉选择框
    JComboBox<String> colorSelect = new JComboBox<String>();

    //创建单选选择组
    ButtonGroup bg = new ButtonGroup();

    //创建单选框
    JRadioButton male = new JRadioButton("男",true);//默认被选中的
    JRadioButton female = new JRadioButton("女", false);

    //创建复选框
    JCheckBox jcb = new JCheckBox("是否已婚", true);

    //创建文本框
    JTextField jtf = new JTextField(40);
    JButton jb = new JButton("确定", new ImageIcon("E:\\projects_IDEA\\AWT\\Img\\selected.png"));

    //创建弹出式菜单
    JPopupMenu jpm = new JPopupMenu();

    //创建选择组
    ButtonGroup popButton = new ButtonGroup();

    //创建菜单项
    JRadioButtonMenuItem metal = new JRadioButtonMenuItem("Metal 风格");
    JRadioButtonMenuItem nimbus = new JRadioButtonMenuItem("Nimbus 风格");
    JRadioButtonMenuItem windows = new JRadioButtonMenuItem("Windows 风格", true);//默认被选中
    JRadioButtonMenuItem windowsClassic = new JRadioButtonMenuItem("Windows 经典风格");
    JRadioButtonMenuItem motif = new JRadioButtonMenuItem("Motif 风格");

    //组装视图
    private void demo(){
        //组装底部
        JPanel bottomPanel = new JPanel();
        bottomPanel.add(jtf);
        bottomPanel.add(jb);
        jFrame.add(bottomPanel, BorderLayout.SOUTH);

        //组装选择框

        //给下拉选择框提供内容
        colorSelect.addItem("绿色");
        colorSelect.addItem("蓝色");
        colorSelect.addItem("红色");

        JPanel selectPanel = new JPanel();
        selectPanel.add(colorSelect);

        //要先将男女选择框放入选择组中
        bg.add(male);
        bg.add(female);
        selectPanel.add(male);
        selectPanel.add(female);

        selectPanel.add(jcb);

        //组装文本域和选择组件
        Box popLeft = Box.createVerticalBox();
        popLeft.add(jta);
        popLeft.add(selectPanel);

        //组装左上的内容和右上的列表
        Box pop = Box.createHorizontalBox();
        pop.add(popLeft);
        pop.add(colorList);

        jFrame.add(pop);

        //组装顶部菜单
        geshi.add(zhushi);
        geshi.add(zhushi_quxiao);

        edit.add(huanhang);
        edit.addSeparator();//增加横杠线
        edit.add(fuzhi);
        edit.add(zhantie);
        edit.addSeparator();//增加横杠线
        edit.add(geshi);

        jMenuBar.add(file);
        jMenuBar.add(edit);

        jFrame.setJMenuBar(jMenuBar);

        //组装弹出菜单

        //将菜单项都放到选择组内限制只能选择一个
        popButton.add(metal);
        popButton.add(nimbus);
        popButton.add(windows);
        popButton.add(windowsClassic);
        popButton.add(motif);

        //时间监听
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String command = e.getActionCommand();
                try {
                    changeFlavor(command);
                } catch (ClassNotFoundException classNotFoundException) {
                    classNotFoundException.printStackTrace();
                } catch (UnsupportedLookAndFeelException unsupportedLookAndFeelException) {
                    unsupportedLookAndFeelException.printStackTrace();
                } catch (InstantiationException instantiationException) {
                    instantiationException.printStackTrace();
                } catch (IllegalAccessException illegalAccessException) {
                    illegalAccessException.printStackTrace();
                }
            }
        };

        //菜单项注册监听
        metal.addActionListener(listener);
        nimbus.addActionListener(listener);
        windows.addActionListener(listener);
        windowsClassic.addActionListener(listener);
        motif.addActionListener(listener);

        jpm.add(metal);
        jpm.add(nimbus);
        jpm.add(windows);
        jpm.add(windowsClassic);
        jpm.add(motif);

        //不需要再给jta注册右击监听了
        jta.setComponentPopupMenu(jpm);

        //给JFrame窗口设置关闭
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //设置最佳大小且可见
        jFrame.pack();
        jFrame.setVisible(true);
    }

    private void changeFlavor(String command) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
        switch (command){
            case "Metal 风格":
                UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
                break;
            case "Nimbus 风格":
                UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
                break;
            case "Windows 风格":
                UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
                break;
            case "Windows 经典风格":
                UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
                break;
            case "Motif 风格":
                UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
                break;
        }

        //刷新外观
        SwingUtilities.updateComponentTreeUI(jFrame.getContentPane());//刷新窗口
        SwingUtilities.updateComponentTreeUI(jMenuBar);//刷新菜单
        SwingUtilities.updateComponentTreeUI(jpm);//刷新弹出框
    }
    public static void main(String[] args) {
        new Demo1().demo();
    }
}
