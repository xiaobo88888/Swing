package JTable_;

import javax.swing.*;

public class Demo {
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

        jFrame.add(new JScrollPane(jTable));



        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setVisible(true);
    }
    public static void main(String[] args) {
        new Demo().init();
    }
}
