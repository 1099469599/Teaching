package com.gs.swingadvance;

import java.util.Hashtable;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTree;
import javax.swing.WindowConstants;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;

public class JTreeTest extends JFrame {

	private static final long serialVersionUID = -8600039913754696342L;

	public JTreeTest() {
		setSize(400, 400);
		setLocationRelativeTo(null);

		String[] items = new String[] { "item1", "item2", "item3" };
		JTree tree = new JTree(items);
		add(tree);

		// ���ַ�ʽ����������
		DefaultMutableTreeNode treeNode = new DefaultMutableTreeNode(); // �������ڵ�
		treeNode.setUserObject("One"); // �������ڵ����ʾ���� �����ڵ㣩
		DefaultMutableTreeNode treeNodeItem1 = new DefaultMutableTreeNode("item1"); // �ӽڵ�
		DefaultMutableTreeNode treeNodeItem2 = new DefaultMutableTreeNode("item2");
		treeNode.add(treeNodeItem1); // �ڸ��ڵ����������ӽڵ�
		treeNode.add(treeNodeItem2);
		JTree tree2 = new JTree(treeNode); // ������ʱָ�������õĸ��ڵ�
		add(tree2);

		String[] items1 = new String[] { "a-item1", "a-item2", "a-item3" };
		Hashtable<String, String[]> t = new Hashtable<String, String[]>();
		t.put("One", items);
		t.put("Two", items1);
		JTree tree1 = new JTree(t);
		// tree1.setSelectionRow(1); // ָ�������������
		tree1.addTreeSelectionListener(new TreeSelectionListener() {

			@Override
			public void valueChanged(TreeSelectionEvent e) {
				JTree tree = (JTree) e.getSource();
				TreePath path = tree.getSelectionPath(); // �Ȼ�ȡ��javax.swing.tree.TreePath�����ɸö�����Ի�ȡ����ѡ�е����е�ĳ��
				System.out.println(path.getLastPathComponent()); // path.getLastPathComponent()��ȡ�����һ�α�ѡ�е�������
				JOptionPane.showMessageDialog(JTreeTest.this, "��ѡ����" + path.getLastPathComponent(), "��ѡ��", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		add(tree1);

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		new JTreeTest();
	}

}
