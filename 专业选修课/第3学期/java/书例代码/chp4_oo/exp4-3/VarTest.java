public class VarTest{ 
	
	private int x=1;
	private int y=1;
	private int z=1;
	
	void changeVar(int a,int b,int c){ 
		x=a;
		int y = b;  //yʹͬ�����Ա��������
		int z = 9; //zʹͬ�����Ա��������
		System.out.println("In  changVar :   "+"x = "+x+" y ="+y+" z ="+z);
		this.z=c;  //�����Ա����z��ֵ
			
	}
	
	String getXYZ(){
		return "x = "+x+" y ="+y+" z ="+z;
	}
 	
 	
  	public static void main( String args[] ){ 
		VarTest v=new VarTest();
		System.out.println("Before changVar : "+v.getXYZ());  
	    
	    v.changeVar(10,10,10);
	    System.out.println("After changeVar: "+v.getXYZ());
	
    }
}
