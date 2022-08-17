import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
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
		
		// ����2
		HashSet set3 = new HashSet();
		
		set3.add("abc");
		set3.add("abc"); // �ߺ��̶� ���� �ȵ�
		
		// equals()�� hashCode()�� �������̵��ؾ� �Ʒ��� ���� ��ü�� �ߺ��� ��Ƽ� �������� HashSet�� �۵��Ѵ�.
		// �̰� ���� �ϴ� ��� >> Source > Generate hashCode()and equals() Ŭ��
		// but!! �״�� ����ϸ� �ȵȴ�. ���� �ٲ�����Ѵ�.
		set3.add(new HashPerson("David",10));
		set3.add(new HashPerson("David",10));
		
		System.out.println(set3);
		
		// ����3
		HashSet setA = new HashSet();
		HashSet setB = new HashSet();
		HashSet setHab = new HashSet();
		HashSet setKyo = new HashSet();
		HashSet setCha = new HashSet();
		
		setA.add("1"); setA.add("2"); setA.add("3");
		setA.add("4"); setA.add("5");
		System.out.println("A = " + setA);
		
		setB.add("4"); setB.add("2"); setA.add("3");
		setB.add("7"); setB.add("8");
		System.out.println("B = " + setB);
		
		// ������
		Iterator it2 = setB.iterator();
		while(it.hasNext()) {
			Object tmp = it2.next();
			if(setA.contains(tmp)) {
				setKyo.add(tmp);
			}
		}
		
		setA.retainAll(setB); // ������ ����ȭ
		setA.addAll(setB); // ������
		setA.removeAll(setB);
		System.out.println(setA);
		
		// ������
		it2 = setA.iterator();
		while(it2.hasNext()) {
			Object tmp2 = it2.next();
			if(!setB.contains(tmp2)) {
				setCha.add(tmp2);
			}
		}
		
		// ������
		it2 = setA.iterator();
		while(it2.hasNext()) {
			setHab.add(it2.next());
		}
		it2 = setB.iterator();
		while(it2.hasNext()) {
			setHab.add(it2.next());
		}
		
		System.out.println("A ������  B = " + setKyo);
		System.out.println("A ������ B = " + setHab);
		
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
    - equals()�� hashCode()�� �������̵��Ǿ� �־���Ѵ�. (hashCode�� �ʼ��� �ƴ����� �����̴�.)
*/
class HashPerson{
	String name;
	int age;
	
	HashPerson(String name, int age){
		this.name = name;
		this.age = age;
	}
	public String toString() {
		return name + ":" + age;
	}
	// ���� ������ �ۼ��ϸ� HashSet���� add�� �ϰ� �Ǹ� ������ �߻��Ѵ�.
	// equals, hashCode�� �������̵� �Ǿ����� �ʱ� ������ equals�� �ּҰ��� ���ϰ� �ǰ� �̴� ���ϴ� ����� �ƴϱ� �����̴�.
	// ���⼭ equals�� ���� �ߺ����� �ƴ��� Ȯ���ϴ� �뵵�̱� ������ ���� ��������Ѵ�.
	//public boolean equals(Object o) {
		//if(!(o instanceof HashPerson)) {
			//return false;
		//}
		//HashPerson tmp = (HashPerson)o;
		//return name.equals(tmp.name) && age == tmp.age; // equals�� �������̵� �ؼ� ���� ���ϰ� ����� ��� �Ѵ�.
	//}
	@Override
	public int hashCode() {
		// ����
		//final int prime = 31;
		//int result = 1;
		//result = prime * result + age;
		//result = prime * result + ((name == null) ? 0 : name.hashCode());
		//return result;
		return Objects.hash(name, age);
	}
	@Override
	public boolean equals(Object obj) {
		// ����
		//if (this == obj)
			//return true;
		//if (obj == null)
			//return false;
		//if (getClass() != obj.getClass())
			//return false;
		//HashPerson other = (HashPerson) obj;
		//if (age != other.age)
			//return false;
		//if (name == null) {
			//if (other.name != null)
				//return false;
		//} else if (!name.equals(other.name))
			//return false;
		//return true;
		if(!(obj instanceof HashPerson)) {
			return false;
		}
		HashPerson tmp = (HashPerson)obj;
		return this.name.equals(tmp.name) && this.age == tmp.age; 
	}
	
	//public int hashCode() {
		//return (name+age).hashCode(); // String + int = String >> String �޼����� hashCode() ���
		// return Objects.hash(name, age); >> ���� ���
	//}
}






