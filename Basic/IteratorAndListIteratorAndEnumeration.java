import java.util.ArrayList;
import java.util.Iterator;

public class IteratorAndListIteratorAndEnumeration {

	public static void main(String[] args) {
		// ���� 1 (Iterator ���� ����)
		ArrayList list = new ArrayList();
		// Collection c = new HashSet();
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		list.add("5");
		
		Iterator it = list.iterator(); // 1ȸ��
		
		while(it.hasNext()) {
			Object obj = it.next();
			System.out.println(obj);
		}
		
		// �ٽ� �ѹ� ȣ���ϰ� �ʹ� Iterator�� �ٽ� ����������Ѵ�.
		
		it = list.iterator(); // ��ü ���� ( 1ȸ��)
		
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}

}

/*
Iterator, ListIterator, Enumeration(Iterator�� ������)
 - �÷��ǿ� ����� �����͸� ����(�о����)�ϴµ� ���Ǵ� �������̽�
 - ListIterator�� Iterator�� ���ټ��� ��� ��Ų �� (�ܓ��� -> �����)
 
 - Iterator �޼��� (�߿�)
   - (�߿�) boolean hasNext() : �о� �� ��Ұ� �����ִ��� Ȯ�� (������ true, ������ false)
     - Enumeration������ boolean hasMoreElements()
   - (�߿�) Object next() : ���� ��Ҹ� �о�´�. hasNext()�� Ȯ�� �� next()�� ����ϴ°� �����ϴ�.
     - Enumeration������ Object nextElement()
   - void remove() : next()�� �о� �� ��Ҹ� �����Ѵ�. next() ȣ�� �� remove()�� ȣ���ؾ��Ѵ�.
     - ������ ���
   - void forEachRemaining(Consumer<?super E> action) : �÷��ǿ� ���� �ִ� ��ҵ鿡 ���� ������ �۾�(action)�� �����Ѵ�. ���ٽ��� ����ϴ� ����Ʈ �޼���(JDK1.8)
 - Iterator�� Ư¡
   - �÷��ǿ� ����� ��ҵ��� �о���� ����� ǥ��ȭ�� ��
     - �÷��ǿ��� List, Set, Map ���� �پ��� ������ ������ �ֱ� ������ ǥ��ȭ�� �ʿ�
     - �÷��ǿ� iterator()�� ȣ���ؼ� Iterator�� ������ ��ü�� �� ����Ѵ�.
       List list = new ArrayList();
       Iterator it = list.iterator(); // Iterator �ν��Ͻ� ����
       
       while(it.hasNext()){ // boolean hasNext() �о�� ��Ұ� ���ٸ� false
           System.out.println(int.next()); // Object next() ���� ��� �б�
       }
       

Map�� Iterator()�� ����.
 - keySet(), entrySet(), values()�� ����ؾ��Ѵ�.
   - Set,Set,Collection �̱� ������ Iterator�� ����� �� �ִ�. 
     Map map = new HashMap();
     
     Iterator it = map.entrySet().iterator();
 





*/