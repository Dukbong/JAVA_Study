
public class equalsTest {

	public static void main(String[] args) {
		Person p1 = new Person(10);
		Person p2 = new Person(10);
		
		System.out.println(p1.equals(p2));
		System.out.println(p1.hashCode());
		System.out.println(p2.hashCode());
	}

}

class Person{
	long id;
	
	Person(long id){
		this.id = id;
	}
	// equals�޼��� �������̵�
	public boolean equals(Object obj) {
		if (obj instanceof Person) {
			Person p = (Person)obj; // obj�� ObjectŸ���̹Ƿ� id���� �����ϱ� ���ؼ��� PersonŸ������ ����ȯ�� �ʿ��ϴ�.
			return this.id == p.id; 
		}else {
			return false; // Ÿ����  Person�� �ƴϸ� ���� ���� �ʿ䰡 ����.
		}
	}
}