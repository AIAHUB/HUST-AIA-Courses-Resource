import java.util.*;

public class ListIteratorDemo {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		
		//��list�����Ԫ�ء�
		for(int i=1; i<5; i++){
			list.add(new Integer(i));
		}
		System.out.println("The original list : "+list);
		
		ListIterator<Integer> listIter = list.listIterator(); //����list��iterator��
		listIter.add(new Integer(0));  //�����Ϊ0��Ԫ��ǰ���һ��Ԫ�ء�
		System.out.println("After add at beginning:"+list);

		if ( listIter.hasNext() ) {
			int i = listIter.nextIndex();  //i��ֵ��Ϊ1��
			listIter.next();  //�������Ϊ1��Ԫ�ء�
			listIter.set(new Integer(9));  //�޸�list�е����Ϊ1��Ԫ�ء�
			System.out.println("After set at "+i+":"+list);
		}
	
		if ( listIter.hasNext() ) {
			int i = listIter.nextIndex();  // i��ֵ��Ϊ2��
			listIter.next();
			listIter.remove();  //ɾ�����Ϊ2��Ԫ�ء�
			System.out.println("After remove at "+i+" : "+list);	
		}		
	}
}
