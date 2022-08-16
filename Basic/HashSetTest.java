import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class HashSetTest {

	public static void main(String[] args) {
		// ���� 1
		Object[] objArr = {"1", new Integer(1), "2","2","3","3","4","4","4"};
		Set set = new HashSet();
		
		for (int i = 0; i < objArr.length; i++) {
			set.add(objArr[i]); // HashSet�� ObjArr�� ��Ҹ� �����Ѵ�.
		}
		System.out.println(set);
		
		//HashSet�� ����� ��ҵ��� ����Ѵ�. (Iterator �̿�);
		Iterator it = set.iterator();
		
		while(it.hasNext()) { // hasNext() : �о�� ��Ұ� �ִ��� Ȯ��
			System.out.println(it.next()); // ��� �ϳ� ��������
		}
		
		// ����2
		Set set2 = new HashSet();
		
		for (int j = 0; set2.size() < 6; j++) {
			int num = (int)(Math.random() * 45) + 1;
			set2.add(new Integer(num));
			//set2.add(num) == ������� ����.
		}
		
		List list = new LinkedList(set2); // LinkedList(Collection c)
		// Set�� ��� ��Ҹ� List�� �����Ѵ�.
		Collections.sort(list); // Collections.sort(List list)
		// ������ ����� list�� �����Ѵ�. (List�� �����ϴ�)
		System.out.println(list);
		// list�� ����Ѵ�.
		

	}

}

/*
HashSet ( ���� x �ߺ� x ) <- List�� �ݴ�
 - Set�������̽��� ������ ��ǥ���� �÷��� Ŭ����
 - ������ �����ϰ� �������� LinkedHashSetŬ������ ����ϸ� �ȴ�.
 
TreeSet
 - ���� �˻��� ���Ŀ� ������ �÷��� Ŭ���� (��: 10~20)
 - HashSet���� ������ �߰� �� ������ �� ���� �ð��� �ҿ�ȴ�.
 
HashSet �ֿ� �޼ҵ�
 - HashSet() : ������
 - HashSet(Collection c) : ������
 - HashSet(int initialCapacity) : �ʱ� �뷮 ( �뷮�� ���ڸ��� �÷��� Ŭ������ �⺻������ �ʱ�뷮�� x2��ŭ �ø���. ) 
 - HashSet(int initialCapacity, float loadFactor) : �뷮 x2�ϴ� ����(loadFactor)�� �������ش�. (��: 0.8 = 80% á���� �뷮�� x2���ش�.)
 - boolean add(Object o) : �߰�
 - boolean addAll(Collection c) : �߰� - ��Ĩ��
 - boolean remove(Object o) : ����
 - boolean removeAll(Collection c) : ���� - ������
 - boolean retainAll(Collection c) : ���Ǻ� ���� (Collection c�� ������ �������� �� �����Ѵ�.) - ������ ���Ҷ� ����Ѵ�. 
 - void clear() : ��� ����
 - boolean contains(Object o) : Set�� o�� �����ϰ� �ִ��� (���� : true)
 - boolean containsAll(Collection c) : Set�� Collection c(������ü)�� ���ԵǾ� �ִ��� (���� : true)
 - Iterator iterator()
 - boolean isEmpty() : ����ִ���
 - int size() : ����� ��ü�� ����
 - Object[] toArray() : Set�� ����� ��ü�� �迭�� ��ȯ
 - Object[] toArray(Object[] a) : Set�� ����� ��ü�� �迭�� ��ȯ
 
HashSet�� ��ü�� �����ϱ����� ������ ���� ��ü�� �ִ��� Ȯ���Ѵ�.
���� ��ü�� ������ Set�� �����ϰ�, ������ Set�� �������� �ʴ´�.
  - �̷� ������ �ֱ� ������ boolean add(Object o)�� ������ ��ü�� equals()�� hashCode()�� ȣ���Ѵ�.
    - equals()�� hashCode()�� �������̵��Ǿ� �־��Ѵ�.
*/