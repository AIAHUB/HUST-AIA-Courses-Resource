import java.util.*; 

public class ListTest {

    public static void main(String[] args) {

        // ע�⣺�б���ֻ���Integer ���͵Ķ���
        List listofInteger = new LinkedList();
        listofInteger.add(new Integer(2000));
        listofInteger.add("8");             
        
        Integer x = (Integer) listofInteger.get(0);   
        System.out.println(x);
        x = (Integer) listofInteger.get(1);   
        System.out.println(x);
    }
}
