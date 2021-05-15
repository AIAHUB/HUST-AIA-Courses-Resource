import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.awt.event.*;

public class TableDemo extends JFrame {
    private boolean DEBUG = true;

    public TableDemo() {
        super("TableDemo");

        MyTableModel myModel = new MyTableModel();
        JTable table = new JTable(myModel);
        table.setPreferredScrollableViewportSize(new Dimension(500, 70));

        //��񳣳����ڹ�������С� 
        JScrollPane scrollPane = new JScrollPane(table);

        //�����������ڴ����С�
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

	
	/*�Զ���������ģ�͡����еķ�������AbstractTableModel�еķ�����
	  �������ڲ��ࡣ*/
    class MyTableModel extends AbstractTableModel {
        
        //�������������
        final String[] columnNames = {"����", "ѧ��", "רҵ", "�Ա�", "����", "���"};
        
        //�������е�5�����ݡ�
        final Object[][] data = {
            {"��ɽ", "200101", "��",
             "�����", new Integer(20), new Boolean(false)},
            {"������", "200103", "��",
             "�����", new Integer(29), new Boolean(true)},
            {"����", "200204","Ů",
             "���ӹ���", new Integer(21), new Boolean(false)},
            {"����", "200208","Ů",
             "�Զ�����", new Integer(25), new Boolean(true)},
            {"�Ű���", "200301","��",
             "��е����", new Integer(31), new Boolean(false)}
        };

        public int getColumnCount() {
            return columnNames.length;
        }
        
        public int getRowCount() {
            return data.length;
        }

        public String getColumnName(int col) {
            return columnNames[col];
        }

        public Object getValueAt(int row, int col) {
            return data[row][col];
        }

        //��ȡ�е��������ͣ�JTableʹ�ø÷���ȷ�����ݵ���ʾ��ʽ��
        public Class getColumnClass(int c) {
            return getValueAt(0, c).getClass();
        }

        //�������ǲ��ɱ༭�ģ�����Ҫʵ�ָ÷�����
        public boolean isCellEditable(int row, int col) {
			//���ǰ���в��ɱ༭��
            if (col < 2) { 
                return false;
            } else {
                return true;
            }
        }

        //�ı�����Ԫ��ֵ��
        public void setValueAt(Object value, int row, int col) {
        	
        	//��ӡ����޸����ݵ�λ�á�
        	if (DEBUG) {  
                System.out.println("Setting value at " + row + "," + col
                                   + " to " + value
                                   + " (an instance of " 
                                   + value.getClass() + ")");
            }

            if (data[0][col] instanceof Integer                        
                    && !(value instanceof Integer)) {                  
                   try {
                    data[row][col] = new Integer(value.toString());
                    fireTableCellUpdated(row, col);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(TableDemo.this,
                        "The \"" + getColumnName(col)
                        + "\" column accepts only integer values.");
                }
            } else {
                data[row][col] = value;
                fireTableCellUpdated(row, col);
            }

          //��ӡ����޸ĺ����е����ݡ�
          if (DEBUG) {  
                System.out.println("New value of data:");
                int numRows = getRowCount();
                int numCols = getColumnCount();

                for (int i=0; i < numRows; i++) {
                	System.out.print("    row " + i + ":");
                	for (int j=0; j < numCols; j++) {
                    	System.out.print("  " + data[i][j]);
                	}
                	System.out.println();
            	}
            	System.out.println("--------------------------");
           }
      }
   }

 
    public static void main(String[] args) {
        TableDemo frame = new TableDemo();
        frame.pack();
        frame.setVisible(true);
    }
}
