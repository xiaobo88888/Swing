package liebiaokuang_;

import liebiaokuang_.Model_.MyComboBoxModel;
import liebiaokuang_.Model_.MyListModel;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.math.BigDecimal;
import java.util.List;

/*JList(ListModel dataModel)
          根据指定的非 null 模型构造一个显示元素的 JList。*/
public class Demo_Model {
    JFrame jFrame = new JFrame("测试ListModel和ComboBoxModel");

    JList<BigDecimal> jList = new JList<>(new MyListModel(new BigDecimal(1), new BigDecimal(21), new BigDecimal(2)));

    JComboBox<BigDecimal> jComboBox = new JComboBox<>(new MyComboBoxModel(new BigDecimal(0.1), new BigDecimal(1.2), new BigDecimal(0.1)));

    JLabel jLabel = new JLabel("您选择的是：");

    JTextField jtf = new JTextField(15);

    private void init(){
        //组装视图

        //组装顶部

        //设置JList
        jList.setVisibleRowCount(4);
        jList.setSelectionInterval(2, 4);

        jList.setFixedCellHeight(30);
        jList.setFixedCellWidth(90);

        jList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                List<BigDecimal> selectedValuesList = jList.getSelectedValuesList();

                jtf.setText("");

                for (BigDecimal item : selectedValuesList) {
                    jtf.setText(jtf.getText() + item.toString() + ",");
                }
            }
        });

        //设置JComboBox
        jComboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                Object selectedItem = jComboBox.getSelectedItem();
                jtf.setText(selectedItem.toString());
            }
        });

        Box hBox = Box.createHorizontalBox();
        hBox.add(new JScrollPane(jList));

        JPanel jPanel = new JPanel();
        jPanel.add(jComboBox);

        hBox.add(jPanel);

        jFrame.add(hBox);

        //组装底部
        JPanel bottonPanel = new JPanel();
        bottonPanel.add(jLabel);
        bottonPanel.add(jtf);

        jFrame.add(bottonPanel, BorderLayout.SOUTH);


        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setVisible(true);
    }
    public static void main(String[] args) {
        new Demo_Model().init();
    }
}
