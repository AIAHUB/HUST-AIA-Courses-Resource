class Outer{ 
	private int size=5;

	/** ����makeInner()������һ�ڲ������ */
	public Object makeInner(final int finalLocalVar){ 
		int LocalVar=6;

		class Inner{ 

			public String toString(){ 
				return ("#<Inner size="+size+
			     
				" finalLocalVar="+finalLocalVar+">");
			}
		}
		return new Inner(); //����makeInner()����һ�ڲ������
	}


	public static void main(String[] args){
		Outer outer=new Outer ();
		Object obj=outer.makeInner(40);
		System.out.println("The object is "+obj.toString());
	}	
}
