import java.util.ArrayList;
import java.util.Collections;

public class CollectionsFramework {

	public static void main(String[] args) {
		// ���� 1
		ArrayList list1 = new ArrayList(10);
		// �⺻ ����(�뷮, capacity)�� 10�� ArrayList�� ����
		list1.add(new Integer(5));
		list1.add(new Integer(4));
		list1.add(new Integer(2));
		list1.add(new Integer(0));
		list1.add(new Integer(1));
		list1.add(new Integer(3));
		list1.add(7); // autoboxing�� ���� �⺻���� ���������� �ڵ���ȯ�ȴ�.
		// ������ �� new Integer(7)�� �ٲ��ش�.
		
		// �����ڿ��� ArrayList(Collection c)�� ����� ���̴�.
		ArrayList list2 = new ArrayList(list1.subList(1, 4));
		print(list1, list2);
		
		// list1�� list2�� �������� �����Ѵ�.
		// Collection�� �������̽� Collections�� ��ƿ Ŭ����
		Collections.sort(list1);
		Collections.sort(list2);
		print(list1, list2);
		
		// list1�� list2�� ��� ��Ҹ� �����ϰ� �ִ��� ����� �޼����̴�.
		System.out.println("list1.containsAll(list2) = " + list1.containsAll(list2));
		System.out.println();
		
		list2.add("B");
		list2.add("C");
		list2.add(3, "A"); // ��ġ �����Ͽ� �߰� (�δ��� �Ǵ� �۾��̴�.)
		print(list1, list2);
		
		list2.set(3, "AA"); // ��ġ �����Ͽ� ��ü ����
		print(list1, list2);
		
		list1.add(0, "1");
		// indexOf()�� ������ ��ü�� ��ġ(�ε���)�� �˷��ش�.
		System.out.println("index = " + list1.indexOf("1"));
		list1.remove("1"); // 0���� "1" �����ȴ�.
//		list1.remove(1); // �ε��� 1�� ��ü ����
		list1.remove(new Integer(3)); // ��ü ���� 3�ΰ� ���� (������ ���� �߿�)
		print(list1, list2);
		
		// list1���� list2�� ��ġ�� �κи� ����� ������ �����Ѵ�.
		System.out.println("list1.retainAll(list2) = " + list1.retainAll(list2));
		print(list1, list2);
		
		// lsit2���� list1�� ���Ե� ��ü���� �����Ѵ�.
		for(int i = list2.size()-1; i >= 0; i--) {
			if(list1.contains(list2.get(i))) {
				list2.remove(i);
			}
		}
		print(list1, list2);
	}
	static void print(ArrayList a, ArrayList b) {
		System.out.println("list1 = " + a);
		System.out.println("list2 = " + b);
		System.out.println();
	}
}
/*
�÷���(collection)
 - ���� ��ü�� ��� ���� ���� �ǹ�
�����ӿ�(framework)
 - ǥ��ȭ, ����ȭ�� ü������ ���α׷��� ���
 
�÷��� �����ӿ�
 - �÷���(�ټ� ��ü)�� �ٷ�� ���� ǥ��ȭ�� ���α׷��� ���
 - �÷���(�ټ� ��ü)�� ���� ���ϰ� �ٷ� �� �ִ� �پ��� Ŭ����(�÷��� Ŭ����) ����
   - ����, ����, �˻�, ���� ���
 - java.util ��Ű���� ���ԵǾ��ִ�. (JDK 1.2���� ����)
�÷��� Ŭ����
 - �ټ��� �����͸� ������ �� �ִ� Ŭ���� (��: Vector, ArrayList, HashSet)
 
�÷��� �����ӿ��� �ٽ� �������̽� ( �߿� )
 - List ( ���� o, �ߺ� o )
 	- ������ �ִ� �������� ����, ������ �ߺ��� ����Ѵ�. ( ��: ����� ��� )
 	  - ���� Ŭ���� : ArrayList(�ٽ�), LinkedList(�ٽ�), Stack, Vector ��
 - Set [����] ( ���� x, �ߺ� x )
   - ������ �������� �ʴ� �������� ����, �������� �ߺ��� ������� �ʴ´�. ( ��: ���� ���� ����, �Ҽ��� ���� )
     - ���� Ŭ���� : HashSet(�ٽ�), TreeSet(�ٽ�) ��
List�� Set�� �θ� �������̽��� Collection �������̽��̴�.

 - Map ( ���� x �ߺ� key x value o )
   - Ű(key)�� ��(value)�� ������ �̷���� �������� ����
   - ������ �������� ������, Ű�� �ߺ��� ������� �ʰ�, ���� �ߺ��� ����Ѵ�. ( ��: �����ȣ, ������ȣ(��ȭ��ȣ))
     - ���� Ŭ���� : HashMap(�ٽ�), TreeMap(�ٽ�), Hashtable, Properties ��
     
Collection �������̽��� �޼���
 [�߰�]===================================================
 - boolean add(Object o)
 - boolean addAll(Collection c)
   - ������ ��ü(o)�Ǵ� Collection(c)�� ��ü���� Collection�� �߰��Ѵ�.
 ========================================================
 
 [��ü ����]================================================
 - void clear()
   - Collection�� ��� ��ü�� �����Ѵ�.
 ========================================================
 
 [�˻�]===================================================
 - boolean contains(Object o)
 - boolean containsAll(Collection c)
   - ������ ��ü(o)�Ǵ� Collection(c)�� ��ü���� Collection�� ���ԵǾ� �ִ��� Ȯ���Ѵ�.
 ========================================================

 - boolean equals(Object o)
   - ������ Collection���� ���Ѵ�.
 - int hashCode()
   - Collection�� hash code�� ��ȯ�Ѵ�.
 - boolean isEmpty()
   - Collection�� ����ִ��� Ȯ���Ѵ�.
 - Iterator iterator()
   - Collection�� iterator�� �� ��ȯ�Ѵ�.
   
 [����]===================================================
 - boolean remove(Object o)
   - ������ ��ü(o)�� �����Ѵ�.
 - boolean removeAll(Collection c)
   - ������ Collection�� ���Ե� ��ü���� �����Ѵ�.
 ========================================================

 - boolean retainAll(Collection c)
   - ������ Collection(c)�� ���Ե� ��ü���� ����� �ٸ� ��ü���� Collection���� �����Ѵ�.
   - �� �۾����� ���� Collection�� ��ȭ�� ������ true ������ false�� ��ȯ�Ѵ�.
 - int size()
   - Collection�� ����� ��ü�� ������ ��ȯ�Ѵ�.
 - Object[]toArray()
   - Collection�� ����� ��ü�� ��ü�迭(Object[])�� ��ȯ�Ѵ�.
 - Object[]toArray(Object[] a)
   - ������ �迭�� Collection�� ��ü�� �����ؼ� ��ȯ�Ѵ�.
   
List �������̽��� �޼��� - ���� o �ߺ� o
 [�߰�]
 - void add(int index, Object element)
 - boolean addAll(int index, Collection c)
   - ������ ��ġ(index)�� ��ü(element) �Ǵ� �÷��ǿ� ���Ե� ��ü���� �߰��Ѵ�.
 [get �б�]
 - Object get(int index)
   - ������ ��ġ(index)�� �ִ� ��ü�� ��ȯ�Ѵ�.
 [�˻�]
 - int indexOf(Object o)
   - ������ ��ü�� ��ġ�� ��ȯ�Ѵ�. (List�� ù��° ��Һ��� ���������� ã�´�.)
 - int lastIndexOf(Object o)
   - ������ ��ü�� ��ġ�� ��ȯ�Ѵ�. (List�� ������ ��Һ��� ���������� ã�´�.)
   
 - ListIterator listIterator()
 - ListIterator listIterator(int index)
   - List�� ��ü�� ������ �� �ִ� ListIterator�� ��ȯ�Ѵ�.
 [����]
 - Object remove(int index)
   - ������ ��ġ�� �ִ� ��ü�� �����ϰ� ������ ��ü�� ��ȯ�Ѵ�.
 [set ����]
 - Object set(int index, Object element)
   - ������ ��ġ(index)�� ��ü(element)�� �����Ѵ�.
 [sort ����]
 - void sort(Comparator c)
   - ������ ����(Comparator)�� List�� �����Ѵ�.
 - List subList(int fromIndex, int toIndex)
   - ������ ����(fromIndex���� toIndex)�� �ִ� ��ü�� ��ȯ�Ѵ�.
   
Set �������̽��� �޼��� - ���� x �ߺ� x
 - ��κ��� Collection �޼���� ����.
 - ���հ� ���õ� �޼���( Collection�� ��ȭ�� �ִٸ� true, �ƴϸ� false )
   - boolean addAll(Collection c)
     - ������ Collection(c)�� ��ü���� Collection�� �߰��Ѵ�. (������)
   - boolean containsAll(Collection c)
     - ������ Collection�� ��ü���� Collection�� ���ԵǾ� �ִ��� Ȯ���Ѵ�. (�κ�����)
   - boolean removeAll(Collection c)
     - ������ Collection�� ���Ե� ��ü���� �����Ѵ�. (������)
   - boolean retainAll(Collection c)
     - ������  Collection�� ���Ե� ��ü���� ����� �������� Collection���� �����Ѵ�. (������)
     
Map �������̽��� �޼��� - ���� x �ߺ�(Ű x �� o)
 - void clear()
   - Map�� ��� ��ü�� �����Ѵ�.
 [�˻�1]
 - boolean containsKey(Object key)
   - ������ key��ü�� ��ġ�ϴ� Map�� key��ü�� �ִ��� Ȯ���Ѵ�.
 - boolean containsValue(Object value)
   - ������ value��ü�� ��ġ�ϴ� Map�� value��ü�� �ִ��� Ȯ���Ѵ�.
 [key�� value ��� �б�]
 - Set entrySet()
   - Map�� ����Ǿ� �ִ� key-value���� Map.entryŸ���� ��ü�� ������ Set���� ��ȯ�Ѵ�.
   
 - boolean equals(Object o)
   - ������ Map���� ���Ѵ�.
   
 [�˻�2]
 - Object get(Object key)
   - ������ key��ü�� �����ϴ� value��ü�� ã�Ƽ� ��ȯ�Ѵ�.
   
 - int hashCode()
   - �ؽ��ڵ带 ��ȯ�Ѵ�.
 - boolean isEmpty()
   - Map�� ����ִ��� Ȯ���Ѵ�.
   
 [key�� �б�]
 - Set keySet()
   - Map�� ����� ��� key��ü�� ��ȯ�Ѵ�.
   
 [�߰�]
 - Object put(Object key, Object value)
   - Map�� value��ü�� key��ü�� ����(mapping)�Ͽ� �����Ѵ�.
 - void putAll(Map t)
   - ������ Map�� ��� key-value���� �߰��Ѵ�.
 [����]
 - Object remove(Object key)
   - ������ key��ü�� ��ġ�ϴ� key-value��ü�� �����Ѵ�.
   
 - int size()
   - Map�� ����� key-value���� ������ ��ȯ�Ѵ�.
   
 [value�� �б�]
 - Collection values()
   - Map�� ����� ��� value��ü�� ��ȯ�Ѵ�.
   
==========================================================
List �������̽��� ���� Ŭ���� ArrayList - ���� o �ߺ� o
 - ArrayList�� ������ Vector�� ������ ������ ���������� ��������� ����
 - ArrayList ��ü�� ����ȭ x, Vector ��ü�� ����ȭ o
 - �������� ����������� �迭�� ����Ѵ�. (�迭 ���)

ArrayList�� �޼���
 - ArrayList ������
   - ArrayList() : �⺻ ������
   - ArrayList(Collection c)
   - ArrayList(int initialCapacity) : �迭�� ���� ���� (�˳���)
 - ArrayList �߰�
   - boolean add(Object o)
   - void add(int index, Object element)
   - boolean addAll(Collection c)
   - boolean addAll(int index, Collection c)
 - ArrayList ����
   - boolean remove(Object o)
   - Object remove(int index)
     [0,1,2,3,4,null,null]���� data.remove(2); [�ε��� 2�� ����]
     - �������� 
       1. ������ ������ ���� �����͸� �� ĭ�� ������ �����ؼ� ������ �����͸� �����.
          - System.arraycopy(data, 3, data,2,2)
            - data[3]���� data[2]�� 2���� �����͸� �����ض��� �ǹ��̴�.
          - ����Ʈ�� ������ ���� �����ҋ��� �� ������ �ʿ����.
       2. �����Ͱ� ��� ��ĭ�� �̵������� ������ �����ʹ� null�� �����Ѵ�.
          - data[size-1] = null;
       3. �����Ͱ� �����Ǿ� �������� ������ �پ����Ƿ� size�� ���� ���ҽ�Ų��.
          - size--;
   - boolean removeAll(Collection c)
   - void clear()
 - ArrayList �˻�
   - int indexOf(Object o) : ������ > ��ã���� -1
   - int lastindexOf(Object o) : ������ > ��ã���� -1
   - boolean contains(Object o) : ���� ����
   - Object get(int index) : �б�
   - Object set(int index, Object element) : ����
 - �� ��
   - List subList(int fromIndex, int toIndex) : ����Ʈ���� fromIndex���� toIndex���� �̾Ƽ� ���ο� ����Ʈ�� �����.
   - Object[] toArray() : ��ü �迭 ��ȯ
   - Object[] toArray(Object[] a) :
   - boolean isEmpty() : ����ִ���
   - void trimToSize() : ����� ����
   - int size() : ����� ��ü�� ����
   
====================================================================
List �������̽��� ���� Ŭ���� LinkedList - ���� o �ߺ� o
 - �迭�� �����
   - ���� : ������ �����ϰ� �����͸� �д� �� �ɸ��½ð�(���ٽð�)�� ª��.
     - �迭�� �������̴�. ������ 4byte arr[0] = 100 arr[1] = 104
       - �ε��� N�� ������ �ּ� = �迭�� �ּ� + N * ������Ÿ���� ũ��
   - ����1 : ũ�⸦ ������ �� ����. (���� ��)
     - ũ�⸦ �����ؾ� �ϴ� ��� ���ο� �迭�� ������ �� �����͸� �����ϰ� ���������� ���ο� �迭�� �ּҸ� �־�����Ѵ�.
     - ũ�� ������ ���ϱ� ���� ū �迭�� �����ϸ� �޸𸮰� ����ȴ�.
   - ����2 : �� ��������(�迭 �߰����� �������°�) ������ �߰�, ������ �ð��� ���� �ɸ���.
     - �� �������� ������ �߰� �� �����ϱ� ���� �ٸ� �����͸� �Űܾ� �Ѵ�.
     - �׷��� �������� ������ �߰�(���� �߰�) �� ����(������ ����)�� ������.
     
 - LinkedList�� �迭�� ������ �����ϱ� ���� ���Դ�.
   - �迭�� �޸� LinkedList�� �ҿ��������� �����ϴ� �����͸� ������ ���̴�.
   - ���� : �����Ϳ� ���ټ��� ���ڴ�.	
     - �̸� �����ϱ� ���� doubly linked list�� �������. (���� ���� ����Ʈ, ���ټ� ���)
   - ������ ����
     - �� �ѹ��� �������游���� ����
        class Node{
            Node next; // ���� ���
            Object ocj; // ������
        }
   - ������ �߰�
     - �ѹ��� Node��ü ������ �ι��� �������游���� ����


 - doubly linked list
   class Node{
       Node next; // �������
       Node previous; // ���� ���
       Object obj;
   }

- doubly circular linked list : ���� ���� ���� ��Ʈ

ArrayList vs LinkedList
������ �߰����� ArrayList WIN
������ �����ϱ� ArryList WIN
�� ���������� �����͸� �߰� ����մϴ�
������� ������ �߰� �� ���� LinkedList WIN
���ٽð� ArrayList WIN 





*/