
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
	// equals메서드 오버라이딩
	public boolean equals(Object obj) {
		if (obj instanceof Person) {
			Person p = (Person)obj; // obj는 Object타입이므로 id값에 접근하기 위해서는 Person타입으로 형변환이 필요하다.
			return this.id == p.id; 
		}else {
			return false; // 타입이  Person이 아니면 값을 비교할 필요가 없다.
		}
	}
}