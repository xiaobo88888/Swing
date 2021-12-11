package JTable_;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class Demo4 {
    JFrame jFrame = new JFrame("TableModel演示");


    //创建一维数组，存储标题
    Object[] titles = {"姓名", "性别", "年龄"};

    //创建二维数组，存储数据
    Object[][] data = {
            {"刘博", "男", 19},
            {"煤球", "女", 20},
            {"高辉", "男", 20},
            {"文昌", "男", 20},
            {"子昇", "男", 20}
    };

    private Vector titlesV = new Vector();//存储标题
    private Vector<Vector> dataV = new Vector<>();//存储数据


    //创建按钮
    JButton addRow = new JButton("添加一行");
    JButton addColumn = new JButton("添加一列");
    JButton deleteRow = new JButton("删除一行");


    JPanel jPanel = new JPanel();

    private void init(){
        //组装视图

        for (int i = 0; i < titles.length; i++) {
            titlesV.add(titles[i]);
        }

        for (int i = 0; i < data.length; i++) {
            Vector t = new Vector();
            for (int j = 0; j < data[i].length; j++) {
                t.add(data[i][j]);
            }
            dataV.add(t);
        }


//        JTable jTable = new JTable(dataV, titlesV);//通过集合创建

        //通过DefaultTableModel创建JTable
        DefaultTableModel model = new DefaultTableModel(dataV, titlesV);

        JTable jTable = new JTable(model);


        addRow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.addRow(new Object[]{"杨杰", "男", 20});
            }
        });

        addColumn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.addColumn("职业");
            }
        });

        deleteRow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = jTable.getSelectedRow();
                model.removeRow(selectedRow);

            }
        });


        jPanel.add(addRow);
        jPanel.add(addColumn);
        jPanel.add(deleteRow);

        jFrame.add(new JScrollPane(jTable));
        jFrame.add(jPanel, BorderLayout.SOUTH);


        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setVisible(true);
    }

    public static void main(String[] args) {
        new Demo4().init();
    }
}
