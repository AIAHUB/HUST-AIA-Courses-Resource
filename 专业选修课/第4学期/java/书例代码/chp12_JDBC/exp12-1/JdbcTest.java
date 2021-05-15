import java.sql.*;

public class JdbcTest {
    public static void main(String args[]) {

        String url= "jdbc:mysql://localhost/test";
        Connection con;
        String sql;
        Statement stmt;
		String num,name,sex;
		int age,math,eng,spec;
		
        try {
   
   			Class.forName("com.mysql.jdbc.Driver");
        } catch(java.lang.ClassNotFoundException e) {
            System.err.print("ClassNotFoundException: ");
            System.err.println(e.getMessage());
        }

        try {	      
            con = DriverManager.getConnection(url, "root", "java");  //
            stmt = con.createStatement();
            
            //��student���в���һ�м�¼��
        	sql = "INSERT INTO STUDENT " +
                            "VALUES('200108','��С��','��',20,71,62,76)";
        	stmt.executeUpdate(sql);
            
        	//����student���е����м�¼����ȡ���������
        	sql = " SELECT * FROM STUDENT";
        	ResultSet rs = stmt.executeQuery(sql);
        	System.out.println("ѧ��        ����        �Ա�   ����"+	
        								"   �ߵ���ѧ  Ӣ��  רҵ��");
        	while(rs.next()){
        		num = rs.getString(1);
        		name = rs.getString(2);
        		sex = rs.getString(3);
        		age = rs.getInt(4);
        		math = rs.getInt(5);
        		eng = rs.getInt("Ӣ��");
        		spec = rs.getInt("רҵ��");
        		System.out.println(num+"    "+name+"	"+sex+"	"+age+"	"+math
        								+"	"+eng+"	"+spec);
        	}	
        
         	//�����ߵ���ѧ�ɼ�80�����ϵ�ѧ����Ϣ��
         	rs = stmt.executeQuery("SELECT ѧ��,����,�ߵ���ѧ,Ӣ��,רҵ�� "+
        							"FROM STUDENT  "+
        							"WHERE �ߵ���ѧ>=80" );
			System.out.println();			
        	System.out.println("The students whose math mark is beyond 80 are:");
        	while(rs.next()){
        		num = rs.getString(1);
        		name = rs.getString(2);
        		math = rs.getInt(3);
        		eng = rs.getInt("Ӣ��");
        		spec = rs.getInt("רҵ��");
        		System.out.println("ѧ��="+num+"	"+"����="+name+"	"+"�ߵ���ѧ="+
        							math+"    "+"Ӣ��="+eng+"	"+"רҵ��="+spec);
        	}
        
        	//�ر����ӡ�
        	stmt.close();
        	con.close();
     	} catch(SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        }          
    }
}
