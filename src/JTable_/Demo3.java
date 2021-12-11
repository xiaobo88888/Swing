package JTable_;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class Demo3 {
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


        MyTableModel myTableModel = new MyTableModel();
//        JTable jTable = new JTable(dataV, titlesV);//通过集合创建
        JTable jTable = new JTable(myTableModel);

        jFrame.add(new JScrollPane(jTable));

        //创建按钮
        JButton jbt = new JButton("获取选中行的信息");
        jbt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedColumn = jTable.getSelectedColumn();
                int selectedRow = jTable.getSelectedRow();
                System.out.println("当前选中行" + selectedRow);
                System.out.println("当前选中列" + selectedColumn);

                Object valueAt = myTableModel.getValueAt(selectedRow, selectedColumn);
                System.out.println("当前单元格的内容是" + valueAt);
            }
        });

        jFrame.add(jbt, BorderLayout.SOUTH);


        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setVisible(true);
    }

    private class MyTableModel extends AbstractTableModel{

        @Override
        public int getRowCount() {
            return dataV.size();
        }

        @Override
        public int getColumnCount() {
            return titlesV.size();
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            return dataV.get(rowIndex).get(columnIndex);
        }

        @Override
        public String getColumnName(int column) {
            return (String) titlesV.get(column);
        }

        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return true;
        }
    }
    public static void main(String[] args) {
        new Demo3().init();
    }
}
