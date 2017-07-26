package com.gs.swingadvance;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.TableColumnModelEvent;
import javax.swing.event.TableColumnModelListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class JTableTest extends JFrame {

	private static final long serialVersionUID = 6587144633611051053L;

	public JTableTest() {
		setSize(600, 400);
		setLocationRelativeTo(null);
		//��һ�ַ���
		JTable table = new JTable(3, 3);
		for (int i = 0, rows = table.getRowCount(); i < rows; i++) {
			for (int j = 0, columns = table.getColumnCount(); j < columns; j++) {
				table.setValueAt("row-" + (i + 1) + "-coloumn-" + (j + 1), i, j); // �У����������Ǵ�0��ʼ
			}
		}
		add(table);
		
		
		JTableData td = new JTableData();
		JTable table1 = new JTable(td.getData(), td.getColumnNames()); // �� һ�������������������ݣ��ڶ���������������
		add(table1);
		
		JScrollPane scrollPane = new JScrollPane(); // �������
		DefaultTableModel tableModel = new DefaultTableModel(); // Ĭ�ϵ�TableModelÿ����Ԫ���ǿ��Ա༭�ģ������Ԫ���޸��ˣ���ᴥ��javax.swing.event.TableModelListener�е�tableChanged�¼�
		DefaultTableColumnModel tableColumnModel = new DefaultTableColumnModel(); // ָ��ÿһ����
		tableColumnModel.addColumn(new TableColumn(0, 20));
		tableColumnModel.addColumn(new TableColumn(1, 120));
		tableColumnModel.addColumnModelListener(new TableColumnModelListener() {
			
			@Override
			public void columnSelectionChanged(ListSelectionEvent e) {
				System.out.println("column  selection changed...");
				
			}
			
			@Override
			public void columnRemoved(TableColumnModelEvent e) {
				System.out.println("column removed...");
			}
			
			@Override
			public void columnMoved(TableColumnModelEvent e) {
				System.out.println("column moved...");
			}
			
			@Override
			public void columnMarginChanged(ChangeEvent e) {
				System.out.println("column  margin changed...");
			}
			
			@Override
			public void columnAdded(TableColumnModelEvent e) {
				System.out.println("column  added...");
			}
		});
		// TableModel����������У��������
//		tableModel.addColumn("aaa");
//		tableModel.addColumn("bbb");
//		tableModel.addColumn("ccc");
//		tableModel.addRow(new String[]{"row-1-column-1", "row-1-column-2", "row-1-column-3"});
//		tableModel.addRow(new String[]{"row-2-column-1", "row-2-column-2", "row-2-column-3"});
//		tableModel.addRow(new String[]{"row-3-column-1", "row-3-column-2", "row-3-column-3"});
		tableModel.addColumn("aaa", new String[]{"row-1-column-1", "row-2-column-1", "row-3-column-1"});
		tableModel.addColumn("bbb", new String[]{"row-1-column-2", "row-2-column-2", "row-3-column-2"});
		tableModel.addColumn("ccc", new String[]{"row-1-column-3", "row-2-column-3", "row-3-column-3"});
		tableModel.addTableModelListener(new TableModelListener() {
			
			@Override
			public void tableChanged(TableModelEvent e) {
				System.out.println("table changed...");
			}
		});
		JTable table2 = new JTable(tableModel);
		// ��������� ����Ϊfalse����������ѡ�е����
		// ���ǰ��Ϊfalse, ����Ϊtrue��������ѡ ��
		// ���������Ϊtrue,��ֻ��ѡ�б�������Ǹ���Ԫ��
		// ���ǰ��ΪTrue������ΪFalse��������  
		table2.setColumnSelectionAllowed(true); // �������Ϊfalse������ѡ�У����Ϊture����������һ����Ԫ�񣬸õ�Ԫ��ѡ��
		table2.setRowSelectionAllowed(false); // �������Ϊfalse����Ԫ�񲻱�ѡ�У����Ϊture����������һ����Ԫ������е����е�Ԫ�񶼻ᱻѡ��
		scrollPane.getViewport().add(table2); // JScrollPane�Ȼ�ȡJViewPort���ٰ�JTable����JViewPort��
		add(scrollPane);
		
//		MyTableModel myTableModel = new MyTableModel();
//		myTableModel.setColumnNames(new String[]{"ONE", "TWO", "THREE"});
//		myTableModel.setData(new String[][]{{"one", "two", "three"}, {"four", "five", "six"}, {"seven", "eight", "nine"}});
//		
//		JTable table3 = new JTable(myTableModel);
//		add(table3);
		
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new JTableTest();
	}

}
