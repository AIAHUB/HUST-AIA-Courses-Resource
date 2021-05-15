import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.event.TreeSelectionListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.tree.TreeSelectionModel;
import java.awt.*;
import java.awt.event.*;

public class TreeDemo extends JFrame {

    //����Ҫ��ʾ�����ݡ�
    String[][] data = {{"Books for Java Programmers",
        					"The Java Tutorial: Object-Oriented Programming for the Internet",
        					"The Java Tutorial Continued: The Rest of the JDK",
        					"The JFC Swing Tutorial: A Guide to Constructing GUIs",
        					"The Java Programming Language",
        					"The Java FAQ",
        					"The Java Class Libraries: An Annotated Reference",
        					"Concurrent Programming in Java: Design Principles and Patterns"},
        				{"Books for Java Implementers",
        					"The Java Virtual Machine Specification",
        					"The Java Language Specification"}
        			      };
   
    public TreeDemo() {
        super("TreeDemo");
            						       						         						 
        //�������ĸ��ڵ㡣
        DefaultMutableTreeNode top = new DefaultMutableTreeNode("The Java Series");
        
        //������������֦����ӵ����ڵ��ϡ�
        for( int i = 0; i<data.length; i++){
			top.add(createBranch(data[i]));
		}

        //��������һ��ֻ����ѡȡһ���ڵ㡣
        final JTree tree = new JTree(top);
        tree.getSelectionModel().setSelectionMode
                (TreeSelectionModel.SINGLE_TREE_SELECTION);

        //Ϊ��ע��������������û���ѡȡ�ڵ�ı仯��
        tree.addTreeSelectionListener(new TreeSelectionListener() {
            public void valueChanged(TreeSelectionEvent e) {
                DefaultMutableTreeNode node = (DefaultMutableTreeNode)
                                   tree.getLastSelectedPathComponent();
                if (node == null) return;
                Object nodeInfo = node.getUserObject();              
                System.out.println(nodeInfo.toString());
            }
               
         });

         //����������岢�����������С� 
        JScrollPane treeView = new JScrollPane(tree);

        //���������ӵ���ǰ�����С�
        getContentPane().add(treeView, BorderLayout.CENTER);
    }


    //������data[0]����Ϊ����һ��֦��
    DefaultMutableTreeNode createBranch(String[] data){
    	DefaultMutableTreeNode category = new DefaultMutableTreeNode(data[0]); 
        DefaultMutableTreeNode book = null;
        
        for( int i =1; i<data.length; i++){
        	book = new DefaultMutableTreeNode(data[i]); 
    		category.add(book);
    	}
    	
    	return category;
    }
    

    public static void main(String[] args) {
        JFrame frame = new TreeDemo();
 
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });  
 
   		frame.setSize(400,250);
        frame.setVisible(true);
    }
}
