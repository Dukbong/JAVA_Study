import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetTest {

	public static void main(String[] args) {
		// ���� 1
		Set set = new TreeSet();
		// ������ �ʿ����. TreeSet ���ο��� ������ �Ѵ�.
		
		for(int i = 0; set.size() < 6; i++) {
			int num = (int)(Math.random()*45) + 1;
			set.add(num); // set.add(new Integer(num));
		}
		
		System.out.println(set);
		
		
		// ������ ��ü�� ���� ������ ���� ���� ���������
		Set set3 = new TreeSet(new TestComp());
		
//		for (int k = 0; set3.size() < 6; k++) {
//			int num = (int)(Math.random()*45) + 1;
			 set3.add(new TestTreeSet());
			 set3.add(new TestTreeSet());
			 set3.add(new TestTreeSet());
			// Error�� �ذ��ϱ� ���� ���ı����� ������� �����ڿ� �־����.
//		}
		System.out.println(set3);
		
		// ������ ��ü���� ���� ���ر��� �ο�������
		Set set4 = new TreeSet();
		
		set4.add(new AllInComp());
		set4.add(new AllInComp());
		set4.add(new AllInComp());
		
		System.out.println(set4);
		
		// �� �ڵ带 HashSet���� �����?
		
		Set set2 = new HashSet();
		
		for(int j = 0; set2.size() < 6; j++) {
			int num = (int)(Math.random()*45) + 1;
			set2.add(num); // == set2.add(new Integer(num));
		}
		
		List list = new LinkedList(set2); // HashSet�� ������ �ʿ��ϴ�.
		// Set�� ������ ���� ������ ������ �ִ� list�� �� ��ȯ �� ������ �����ؾ��Ѵ�.
		Collections.sort(list);
		System.out.println(list);
		
		//���� 2
		TreeSet set5  = new TreeSet();
		
		String from = "b";
		String to = "d";
		
		set5.add("abc");  set5.add("alien"); set5.add("bat");
		set5.add("car"); set5.add("Car"); set5.add("disc");
		set5.add("dance"); set5.add("dZZZZ"); set5.add("dzzzz");
		set5.add("elephant"); set5.add("elevator");
		set5.add("fan"); set5.add("flower");
		
		System.out.println(set5);
		System.out.println("range search : from " + from + " to " + "to");
		System.out.println("result1 = " + set5.subSet(from, to));
		System.out.println("result2 = " + set5.subSet(from, to + "zzz"));
		
		// ����3
		TreeSet set6 = new TreeSet();
		int[] score = {80,95,50,35,45,65,10,100};
		
		for (int i = 0; i < score.length; i++) {
			set6.add(new Integer(score[i]));
		}
		System.out.println("50���� ���� �� =" + set6.headSet(new Integer(50)));
		System.out.println("50���� ū�� =" + set6.tailSet(50));
		System.out.println("40�� 80������ ū��  = " + set6.subSet(40, 80));
		

	}

}

class TestTreeSet{} // �� ���� ����
class TestComp implements Comparator{

	@Override
	public int compare(Object arg0, Object arg1) {
		// TODO Auto-generated method stub
		return 1; // 0�� ��ü�� �����ŷ� ���� 1, -1�� �ٸ� ��ü�� ����
	}
	
}

class AllInComp implements Comparable{

	@Override
	public int compareTo(Object arg0) {
		// TODO Auto-generated method stub
		return -1;
	}
	
}


/*
TreeSet
 - ���� Ž�� Ʈ��(binary search tree)�� ����, ���� Ž���� ���Ŀ� �����ϴ�.
 - ���� Ʈ���� ��� ��尡 �ִ� 2��(0~2��)�� ���� ��带 ���´�. 
   - root -> A -> C (A�� �ڽ�) 
          |    |
          |    |
          |    -> D (A�� �ڽ�)
          |
          -> B -> E (B�� �ڽ�)
    
 - TreeSet �⺻ ����
    class TreeNode{
        TreeNode left; // ���� �ڽĳ��
        Object element; // ������ ��ü
        TreeNode right; // ������ �ڽĳ��
    }
 - ���� Ž�� Ʈ�� ( ���� Ʈ���� ���� �� 1���̸� TreeSet�� ���� Ž�� Ʈ���̴�.)
   - �θ𺸴� ���� ���� ����, ū ���� �����ʿ� �����Ѵ�.
   - �����Ͱ� ���� ������ �߰�, ������ ȿ������ ��������. (�� Ƚ���� ����)
     - 1) �� ( 5 < 7 )
       7--9
       |
       2) �� ( 5 > 4 )
       3) 5�� �����ʿ� ���� 
       4--5
       |
       1
   - ������ ������� boolean add(Object o)
     - equals()�� hashCode()�� �ڵ����� ȣ���ؼ� ���� ���Ѵ�.
     - Set�� �ߺ��� ������� �ʱ� �����̴�.

TreeSet�� �ֿ� ������ �� �޼���
 - TreeSet�� ������ �ִ� �޼���鸸 �����.
 - add, remove, size, isEmpty �� ��� �ݺ������� �����°� �����Ͽ���.
 -
 - TreeSet() : �⺻ ������
 - TreeSet(Collection c) : �־��� Collection(c)�� ������ TressSet ����
 - TreeSet(Comparator comp) : �־��� ���� ����(comp)���� �����ϴ� TreeSet ����
 - Object first() : ���ĵ� �������� ù��° ��ü�� ��ȯ�Ѵ�.
 - Object last() : ���ĵ� �������� ������ ��ü�� ��ȯ�Ѵ�.
 - Object ceiling(Object o) : ������ ��ü (o)�� ���� ��ü�� ��ȯ
   - ������ ū ���� ���� ��ü �� ���� ����� ���� ��ü�� ��ȯ �װ����� ������ null ��ȯ
 - Object floor(Object o) : ������ ��ü(o)�� ���� ��ü�� ��ȯ
   - ������ ���� ���� ���� ��ü �� ���� ����� ���� ��ü�� ��ȯ �װ����� ������ null ��ȯ
 - Object higher(Object o) : ������ ��ü(o)���� ū���� ���� ��ü �� ���� ����� ���� ��ü�� ��ȯ
   - ������ null ��ȯ
 - Object lower(Object o) : ������ ��ü(o)���� ���� ���� ���� ��ü �� ���� ����� ���� ��ü�� ��ȯ
   - ������ null ��ȯ
 - SortedSet subSet(Object fromElement, Object toElement)
   - ���� �˻�(formElement <= x < toElement)�� ����� ��ȯ�Ѵ�.
 - SortedSet headSet(Object toElement) : ������ ��ü(o)���� ���� ���� ��� ��ü�� ��ȯ�Ѵ�.
 - SortedSet tailSet(Object fromElement) : ������ ��ü(o)���� ū ���� ��� ��ü�� ��ȯ�Ѵ�.
   
   
   
�˾� �θ� ������  Ʈ�� ��ȸ 
 - ���� Ʈ���� ��� ��带 �ѹ��� �д°��� Ʈ�� ��ȸ��� �Ѵ�.
   - ���� ��ȸ, ���� ��ȸ, ������ȸ, ���� ��ȸ�� �ֽ��ϴ�.
     - ���� ��ȸ�� �ϸ� �ڵ����� �������� ������ �����ϴ�.
   
   
 */