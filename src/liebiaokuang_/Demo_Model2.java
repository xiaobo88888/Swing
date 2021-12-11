package liebiaokuang_;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*String trim()
          返回字符串的副本，忽略前导空白和尾部空白 */

public class Demo_Model2 {
    JFrame jFrame = new JFrame("测试DefaultListModel和DefaultComboBoxModel");

    JTextField jtf = new JTextField(15);

    JButton addBook = new JButton("添加指定图书");

    JButton removeBook = new JButton("删除指定图书");

    JList<String> jList;

    DefaultListModel<String> model = new DefaultListModel<>();

    private void init(){
        //组装视图

        //组装顶部
        model.addElement("java自学宝典");
        model.addElement("lalalalala");
        model.addElement("aaaaaa");
        model.addElement("bbbbbbbb");

        jList = new JList<>(model);

        //设置JList
        jList.setVisibleRowCount(3);

        jList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);//设置单选

        jFrame.add(new JScrollPane(jList));

        //组装底部

        //为按钮添加监听
        addBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = jtf.getText();

                if(!text.trim().equals("")){
                    model.addElement(text);
                }
            }
        });

        removeBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = jList.getSelectedIndex();

                if(index >= 0) {//确保选了条目
                    model.remove(index);
                }
            }
        });
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setVisible(true);

        JPanel bottonPanel = new JPanel();
        bottonPanel.add(jtf);
        bottonPanel.add(addBook);
        bottonPanel.add(removeBook);

        jFrame.add(bottonPanel, BorderLayout.SOUTH);

        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setVisible(true);
    }
    public static void main(String[] args) {
        new Demo_Model2().init();
    }
}
