package liebiaokuang_;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;
import java.util.Vector;

/*
JRadioButton：实现一个单选按钮，此按钮项可被选择或取消选择，并可为用户显示其状态。
            与 ButtonGroup 对象配合使用可创建一组按钮，一次只能选择其中的一个按钮。
 */
public class Demo {
    JFrame jFrame = new JFrame("列表框测试");

    String[] books = {"java自学宝典", "轻量级javaEE企业应用实战", "Android基础教程", "jQuery实战教程", "SpringBoot企业级开发"};

    //定义布局选择按钮所在面板
    JPanel layoutPanel = new JPanel();
    ButtonGroup layoutButtonGroup = new ButtonGroup();

    //定义模式选择按钮所在面板
    JPanel selectPanel = new JPanel();
    ButtonGroup selectButtonGroup = new ButtonGroup();

    JTextArea jta = new JTextArea(4, 40);

    //用字符串数组来创建JList对象
    JList<String> bookList;
    JComboBox<String> bookSelecter;

    private void init(){
        //组装视图

        //组装JList相关内容
        bookList = new JList<String>(books);

        addBtn("纵向滚动", JList.VERTICAL);
        addBtn("纵向换行", JList.VERTICAL_WRAP);
        addBtn("横向换行", JList.HORIZONTAL_WRAP);

        addBtn2("无限制", ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        addBtn2("单选", ListSelectionModel.SINGLE_SELECTION);
        addBtn2("单范围", ListSelectionModel.SINGLE_INTERVAL_SELECTION);


        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setVisible(true);

        //对JList做设置
        bookList.setVisibleRowCount(3);
        bookList.setSelectionInterval(2, 4);

        //为JList设置条目选中事件
        bookList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                //获取选中的条目
                List<String> selectedValuesList = bookList.getSelectedValuesList();//因为这是一个集合，所以单选和多选都能用
                //将选中的条目添加到文本域上面
                jta.setText("");//清空文本域
                for (String str : selectedValuesList) {
                    jta.append(str + "\n");
                }
            }
        });

        //用一个纵向的Box将JList组装起来
        Box JlistBox = Box.createVerticalBox();
        JlistBox.add(new JScrollPane(bookList));//为列表框增加滚动条
        JlistBox.add(layoutPanel);
        JlistBox.add(selectPanel);

        //组装JComboBox
        Vector<String> vector = new Vector<>();
        List<String> list = List.of("java自学宝典", "轻量级javaEE企业应用实战", "Android基础教程", "jQuery实战教程", "SpringBoot企业级开发");
        vector.addAll(list);

        bookSelecter = new JComboBox<>(vector);

        //对JComboBox做设置
        bookSelecter.setEditable(true);
        bookSelecter.setMaximumRowCount(4);

        //为JComboBox做条目选中事件
        bookSelecter.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                //获取选中条目
                Object selectedItem = bookSelecter.getSelectedItem();
                //将选中的条目添加到文本域
                jta.setText("");
                jta.append(selectedItem.toString());
            }
        });

        //组装顶部区域
        Box topBox = Box.createHorizontalBox();
        topBox.add(JlistBox);
        //将下拉选择框放到一个容器里面，因为如果直接放入Box中，左右高度会对齐
        JPanel bookSelecterPanel = new JPanel();
        bookSelecterPanel.add(bookSelecter);

        topBox.add(bookSelecterPanel);

        //组装底部区域
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new BorderLayout());

        jPanel.add(new JLabel("您最喜欢的图书："), BorderLayout.NORTH);
        jPanel.add(jta);

        //组装整体
        Box box = Box.createVerticalBox();

        box.add(topBox);
        box.add(jPanel);


        jFrame.add(box);
    }

    //分装方法，往layoutPanel中添加按钮
    private void addBtn(String name, int layoutType){//这里按钮布局用int类型存粹是因为JList中的布局也是int类型的
        //设置标题边框
        layoutPanel.setBorder(new TitledBorder(new EtchedBorder(), "确定选项布局"));

        //创建单选按钮
        JRadioButton button = new JRadioButton(name);

        layoutPanel.add(button);

        //第一个按钮默认选中
        if(layoutButtonGroup.getButtonCount() == 0){
            button.setSelected(true);
        }

        layoutButtonGroup.add(button);

        //为按钮添加监听器
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bookList.setLayoutOrientation(layoutType);
            }
        });
    }

    //分装方法，往selectPanel中添加按钮
    private void addBtn2(String name, int selectionModel){//这里模式选择用int类型存粹是因为JList中的模式也是int类型的
        //设置标题边框
        selectPanel.setBorder(new TitledBorder(new EtchedBorder(), "确定选择模式"));

        //创建单选按钮
        JRadioButton button = new JRadioButton(name);

        selectPanel.add(button);

        //第一个按钮默认选中
        if(selectButtonGroup.getButtonCount() == 0){
            button.setSelected(true);
        }

        selectButtonGroup.add(button);

        //为按钮添加监听器
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bookList.setSelectionMode(selectionModel);
            }
        });
    }
    public static void main(String[] args) {
        new Demo().init();
    }
}
