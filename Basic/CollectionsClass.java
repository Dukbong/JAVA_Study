import java.util.*;
import static java.util.Collections.*; // Collections�� ������ �� �ִ�.

public class CollectionsClass {

	public static void main(String[] args) {
		// ����
		List list = new ArrayList();
		System.out.println(list);
		
		Collections.addAll(list, 1,2,3,4,5);
		System.out.println(list);
		
		// Collections ����
		rotate(list, 2); // ���������� 2ĭ�� �̵�
		System.out.println(list);
		
		Collections.swap(list, 0 , 2); // �ε��� 0�� �ε��� 2�� �ڸ��� �ٲ۴�.
		System.out.println(list);
		
		shuffle(list);
		System.out.println(list);
		
		sort(list, reverseOrder()); // �������� reverse(list)�� ����
		System.out.println(list);
		
		sort(list);
		System.out.println(list);
		
		int idx = binarySearch(list, 3); // 3�� ����� ��ġ(index)�� ��ȯ
		System.out.println("index of 3 = " + idx);
		
		System.out.println("max = " + max(list));
		System.out.println("min = " + min(list));
		System.out.println("min = " + max(list, reverseOrder()));
		
		fill(list, 9); // list�� 9�� ���� ä���.
		System.out.println(list);
		
		List newList = nCopies(list.size(), 2);
		// list�� ���� ũ���� ���ο� list�� �����ϰ� 2�� ä���. ��, ����� ���� �Ұ��ϴ�. 
		System.out.println("newList = " + newList);
		
		System.out.println(disjoint(list, newList)); // �� ��ü�� �����Ұ� ������ true
		
		copy(list, newList);
		System.out.println("newList = " + newList);
		System.out.println("list = " + list);
		
		replaceAll(list, 2, 1);
		System.out.println("list = " + list);
		
		Enumeration e = enumeration(list);
		ArrayList list2 = list(e);
		
		System.out.println("list2 = " + list2);
	}

}

/*
Collections
 - �÷����� ���� �޼���(static)�� ����
   - �� : Objects(��ü), Arrays(�迭), Collections(�÷���) ���
   
 - �÷��� ä���, ����, ����, �˻� : fill(), copy(), sort(), binarySearch() ��
 
 - �÷����� ����ȭ : synchronizedXXX()
   - static Collection synchronizedCollection(Collection c)
   - static List synchronizedList(List list)
   - static Set synchronizedSet(Set s)
   - static Map synchronizedMap(Map m)
   - static SortedSet synchronizedSortedSet(SortedSet s)
   - static SortedMap synchronizedSortedMap(SortedMap m)
   - �����
     - List syncList = Collections.synchronizedList(new ArrayList(...));
       - syncList = ����ȭ�� ����Ʈ(Vector�� ����ϴ�.) , new ArrayList = ����ȭ���� ���� ����Ʈ

 - ����Ұ�(readOnly) �÷��� ����� : unmodifiableXXX() >> ���� �Ұ�
   - static Collection unmodifiableCollection(Collection c)
   - static List unmodifiableList(List list)
   - static Set unmodifiableSet(Set s)
   - static Map unmodifiableMap(Map m)
   - static NavigableSet unmodifiableNavigableSet(NavigableSet s)
   - static SortedSet unmodifiableSortedSet(SortedSet s)
   - static NavigableMap unmodifiableNavigableMap(NavigableMap m)
   - static SortedMap unmodifiableSortedMap(SortedMap m)
   
 - �Ǳ��� �÷��� ����� : singletonXXX() >> ��ü 1���� �����ϰ� �����.
   - static List singletonList(Object o)
   - static Set singleton(Object o) // singletonSet�� �ƴϴ�!!
   - static Map singletonMap(Object key, Object value)
   
 - �� ������ ��ü�� �����ϴ� �÷��� ����� : checkedXXX() >> ���׸����� ����� ����.
   JDK 1.5 ���ķ� ���׸����� ���Ա� ������ �� ������������ checkedXXX()�� ����ߴ�.
   - static Collection checkedCollection(Collection c, class type)
   - static List checkedList(List list, class type)
   - static Set checkedSet(Set s, class type)
   - static Map checkedMap(Map m, class keyType, class valueType)
   - static Queue checkedQueue(Queue queue, class type)
   - static NavigableSet checkedNavigableSet(NavigableSet s, class type)
   - static SortedSet checkedSortedSet(SortedSet s, class type)
   - static NaviagbleMap checkedNavigableMap(NavigableMap m, class keyType, class valueType)
   - static SortedMap checkedSortedMap(SortedMap m, class keyType, class vlaueType)
     - �����
       - List list = new ArrayList();
       - List checkedList = checkedList(list, String.class); // String�� ���� ����
       - checkedList.add("abc"); // ok
       - checkedList.add(new Integer(3)); // Error
       
       
���� �÷��� Ŭ���� ���� �� ���
 - ArrayList, Vector�� �迭����̴�.
   - �̰� �������� ����� Stack (Last in first out) ����
 - ������� �߰� �� ���� ȿ���� ���ڴ�.
   - �̰� �ذ��Ϸ��� LinkedList�� �������.
     - �̰� �������� ����� Queue (First in First out) ����
     
 - HashMap, Hashtable�� �迭��ݰ� LinkedList�� ������ ���ļ� ������̴�.
   - HashMap���� key�� ���� ����� HashSet�̴�.
     - ������ ������ ������ ����� �������� LinkedHashSet�� ���ϴ�.
 
 - LinkedList�� �������� TreeSet�� �������.
   - ���� ��ȸ�ϸ� ������ �ȴ�.
*/

