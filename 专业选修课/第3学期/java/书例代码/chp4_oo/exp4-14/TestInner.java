class Outer{ 
	private int size;

	/** �����ڲ���Inner */
	class Inner{ 
	    void doStuff(){ 
			size++;  
			System.out.println("The size value of the Outer class: "+size); 
		}
	}
}

public class TestInner{
	public static void main(String[] a){ 
		Outer out=new Outer();
		Outer.Inner in=out.new Inner(); //�����������ڲ���Ķ���
	
		in.doStuff();  //�����ڲ���ķ���
	}
}
