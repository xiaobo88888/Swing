package JTable_;

import javax.swing.*;
import javax.swing.table.TableColumn;

public class Demo2 {
    JFrame jFrame = new JFrame("表格测试");


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


    private void init(){

        //组装视图

        JTable jTable = new JTable(data, titles);


        // TODO 设置选择模式
        jTable.getSelectionModel().setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);//无限制
//        jTable.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);//单选
//        jTable.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);//单范围

        // TODO 设置列宽
        //先得到列对象，再设置列宽

        TableColumn column_1 = jTable.getColumn(titles[0]);
        column_1.setMinWidth(50);

        TableColumn column_3 = jTable.getColumn(titles[2]);
        column_3.setMaxWidth(80);


        jFrame.add(new JScrollPane(jTable));

        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setVisible(true);
    }
    public static void main(String[] args) {
        new Demo2().init();
    }
}
