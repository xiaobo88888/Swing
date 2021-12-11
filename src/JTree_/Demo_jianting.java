package JTree_;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellEditor;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;

/*TreePath getNewLeadSelectionPath()
          返回当前前导路径。 */

public class Demo_jianting {
    JFrame jFrame = new JFrame("监听树的选择事件");

    JTree jTree;

    DefaultMutableTreeNode root = new DefaultMutableTreeNode("中国");
    DefaultMutableTreeNode jiangxi = new DefaultMutableTreeNode("江西");
    DefaultMutableTreeNode jian = new DefaultMutableTreeNode("吉安");
    DefaultMutableTreeNode ganzhou = new DefaultMutableTreeNode("赣州");
    DefaultMutableTreeNode anfu = new DefaultMutableTreeNode("安福");
    DefaultMutableTreeNode guangdong = new DefaultMutableTreeNode("广东");
    DefaultMutableTreeNode guangzhou = new DefaultMutableTreeNode("广州");
    DefaultMutableTreeNode shenzhen = new DefaultMutableTreeNode("深圳");

    JTextArea jta = new JTextArea(5, 20);

    private void init(){

        //通过add方法建立父子层级关系
        root.add(jiangxi);
        root.add(guangdong);

        jiangxi.add(jian);
        jiangxi.add(ganzhou);

        jian.add(anfu);

        guangdong.add(guangzhou);
        guangdong.add(shenzhen);

        jTree = new JTree(root);

        //TODO 设置选择模式
        TreeSelectionModel selectionModel = jTree.getSelectionModel();
        selectionModel.setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);//单选

        //TODO 设置监听器
        jTree.addTreeSelectionListener(new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent e) {
                //把当前选中的结点的路径显示到文本域中
                TreePath selectionPath = e.getNewLeadSelectionPath();

                jta.append(selectionPath.toString() + "\n");
            }
        });


        Box hBox = Box.createHorizontalBox();
        hBox.add(new JScrollPane(jTree));
        hBox.add(new JScrollPane(jta));

        jFrame.add(hBox);

        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setVisible(true);
    }
    public static void main(String[] args) {
        new Demo_jianting().init();
    }
}
