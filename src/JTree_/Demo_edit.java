package JTree_;

import javax.swing.*;
import javax.swing.tree.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*int getIndex(TreeNode aChild)
          返回此节点的子节点数组中指定子节点的索引

  void insertNodeInto(MutableTreeNode newChild, MutableTreeNode parent, int index)
          对它进行调用，以便在父节点的子节点中的 index 位置插入 newChild。

  TreeNode[] getPathToRoot(TreeNode aNode)
          向上构建节点的父节点一直到根节点（包括根节点），其中原始节点是返回数组中的最后一个元素。
  void scrollPathToVisible(TreePath path)
          确保路径中所有的路径组件均展开（最后一个路径组件除外）并滚动，以便显示该路径标识的节点。

  void removeNodeFromParent(MutableTreeNode node)
          通知它从其父节点中移除节点

  void startEditingAtPath(TreePath path)
          选择指定路径标识的节点，并开始编辑


  */

public class Demo_edit {
    JFrame jFrame = new JFrame("可编辑结点的树");

    //定义初始结点
    DefaultMutableTreeNode root = new DefaultMutableTreeNode("中国");
    DefaultMutableTreeNode jiangxi = new DefaultMutableTreeNode("江西");
    DefaultMutableTreeNode jian = new DefaultMutableTreeNode("吉安");
    DefaultMutableTreeNode ganzhou = new DefaultMutableTreeNode("赣州");
    DefaultMutableTreeNode anfu = new DefaultMutableTreeNode("安福");
    DefaultMutableTreeNode guangdong = new DefaultMutableTreeNode("广东");
    DefaultMutableTreeNode guangzhou = new DefaultMutableTreeNode("广州");
    DefaultMutableTreeNode shenzhen = new DefaultMutableTreeNode("深圳");

    //定义按钮
    JButton addSiblingBtn = new JButton("添加兄弟结点");
    JButton addChileBtn = new JButton("添加子结点");
    JButton deleteBtn = new JButton("删除结点");
    JButton editBtn = new JButton("编辑当前结点");

    private void init(){
        //组装视图

        //通过add方法建立父子层级关系
        root.add(jiangxi);
        root.add(guangdong);

        jiangxi.add(jian);
        jiangxi.add(ganzhou);

        jian.add(anfu);

        guangdong.add(guangzhou);
        guangdong.add(shenzhen);


        JTree jTree = new JTree(root);

        //完成树的结点的编辑代码
        jTree.setEditable(true);//设置为可编辑的

        DefaultTreeModel model = (DefaultTreeModel) jTree.getModel();

        //监听添加兄弟
        addSiblingBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //获取当前选中结点
                DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) jTree.getLastSelectedPathComponent();
                if(selectedNode == null){
                    return;
                }

                //获取当前选中结点的父结点
                DefaultMutableTreeNode parentNode = (DefaultMutableTreeNode) selectedNode.getParent();
                if(parentNode == null){
                    return;
                }

                //创建新结点
                DefaultMutableTreeNode newNode = new DefaultMutableTreeNode("新兄弟结点");

                //通过父结点添加结点
                int index = parentNode.getIndex(selectedNode);
                model.insertNodeInto(newNode, parentNode, index);

                //显示新结点
                TreeNode[] pathToRoot = model.getPathToRoot(newNode);
                TreePath treePath = new TreePath(pathToRoot);
                jTree.scrollPathToVisible(treePath);

                //重绘树
                jTree.updateUI();
            }
        });

        //监听添加子结点
        addChileBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //获取当前选中的结点
                DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) jTree.getLastSelectedPathComponent();
                if(selectedNode == null){
                    return;
                }
                //创建新结点
                DefaultMutableTreeNode newNode = new DefaultMutableTreeNode("新子结点");

                //将新结点添加到当前选中的结点处
                selectedNode.add(newNode);

                //显示新结点
                TreeNode[] pathToRoot = model.getPathToRoot(newNode);
                TreePath treePath = new TreePath(pathToRoot);
                jTree.scrollPathToVisible(treePath);

                //重绘树
                jTree.updateUI();
            }
        });

        //监听删除结点
        deleteBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //获取当前选中结点
                DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) jTree.getLastSelectedPathComponent();

                //通过父结点删除
                if(selectedNode != null && selectedNode.getParent() != null){
                    model.removeNodeFromParent(selectedNode);
                }

            }
        });

        //监听编辑结点
        editBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //获取当前选中的路径
                TreePath selectionPath = jTree.getSelectionPath();

                //如果路径不为空，则将该路径上的最后一个结点编辑
                if(selectionPath != null){
                    jTree.startEditingAtPath(selectionPath);
                }


            }
        });


        jFrame.add(new JScrollPane(jTree));

        JPanel jPanel = new JPanel();
        jPanel.add(addSiblingBtn);
        jPanel.add(addChileBtn);
        jPanel.add(deleteBtn);
        jPanel.add(editBtn);

        jFrame.add(jPanel, BorderLayout.SOUTH);

        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setVisible(true);
    }

    public static void main(String[] args) {
        new Demo_edit().init();
    }
}
