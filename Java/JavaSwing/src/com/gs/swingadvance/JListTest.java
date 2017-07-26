package com.gs.swingadvance;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.WindowConstants;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * serializable ���л�
 * 
 * �κ�һ���������ʾ����Ҫ���л�����˵���������߸���ĸ��ࣨ������Ҳ�У�ʵ����java.io.Serializable�ӿ�
 * 
 * java.io.Serializable�ӿ���JDK�ṩ�����л��ӿڣ�����һ����ʶ�ӿڣ��ڲ�û���κη���
 * 
 * ���ʵ���˸ýӿڵ��࣬��̳���ʵ���˸ýӿڵ�������࣬��Ӧ��������л��汾�ţ����������л��汾�ţ��򾯸�����
 *
 */
public class JListTest extends JFrame {

	// Add generated serial version ID
	private static final long serialVersionUID = 230582839290408371L;

	public JListTest() {
		setSize(400, 400);
		setLocationRelativeTo(null);

		/**
		 * Ϊʲô�о��棿
		 * JList������һ�����������������ŵ����ݱ�����ͬһ�����ͣ���������ʱ��û��ָ�����������Դ洢�������͵����ݣ������־���
		 * ������Ϣ���£�����Ժ󿴵����͵ľ��棬��˵����Ӧ����������ʱ��͸�������ź����������ͣ��� JList is a raw type.
		 * References to generic type JList<E> should be parameterized
		 * ��������ʱ��͸��߸�������ŵ��������ͣ� ����ĺ������ <��������>
		 * 
		 * ���ͣ�����ֻ�������������ͣ��������û����������ͣ����������ڱ���׶�������
		 */
		String[] items = new String[] { "item1", "item2", "item3", "item4" };
		JList<String> list = new JList<String>(items);
		// list.setSelectedIndex(1); // ����ָ���������ѡ��
		list.setSelectedIndices(new int[] { 1, 2 }); // ���ö���ѡ��
		list.setBorder(BorderFactory.createLineBorder(Color.RED, 1)); // ���ñ߿�ʹ��javax.swing.BorderFactory�߿򹤳��ഴ��ָ�����͵ı߿�

		list.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) { // ���¼������������������
				@SuppressWarnings({ "unchecked" }) // Javaע�⣨ע�ͣ���
													// ����������������������һЩ������Ϣ
													// @Override ˵��������д��
													// @SuppressWarnings("unchecked")��ʾѹ�Ƽ�龯�棬 unused��ʾѹ��δʹ�þ���
				JList<String> list = (JList<String>) e.getSource();
				// int idx = list.getSelectedIndex(); // �����ѡ�������
				int[] idxs = list.getSelectedIndices();
				@SuppressWarnings({ "unused", "deprecation" })
				String[] values = (String[]) list.getSelectedValues(); // ��ȡ���б�ѡ���ֵ
				for (int i : idxs) {
					System.out.println(items[i]);
				}
			}
		});

		add(list);

		DefaultListModel<String> model = new DefaultListModel<String>();
		model.addListDataListener(new ListDataListener() {

			@Override
			public void intervalRemoved(ListDataEvent e) { // ��ListModel���Ƴ�ĳһ��ʱ����
				System.out.println("removed");
			}

			@Override
			public void intervalAdded(ListDataEvent e) { // ��ListModel���������ʱ���� 
				System.out.println("added");
			}

			@Override
			public void contentsChanged(ListDataEvent e) { // �޸�ListModel�е�ĳһ��ʱ����
				System.out.println("contents changed....");
			}
		});
		model.add(0, "item1");
		model.add(1, "item2");
		model.add(2, "item3");
		@SuppressWarnings({ "rawtypes", "unchecked" })
		JList list1 = new JList(model);
		// model.removeAllElements(); // �Ƴ�������
		// model.remove(1); // �Ƴ�ָ��������
		model.removeElementAt(2);
		model.set(0, "new item1"); // �޸�ָ����

		add(list1);

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		new JListTest();
	}

}
