
public class Interface {

	public static void main(String[] args) {
		// interface는 추상 매서드의 집합이다. ( 변수를 가질 수 없다  << 추상클래스와 인터페이스의 차이점 )
		// 구현된 것이 전혀 없는 설계도(모든 멤버가 public)
		// interface의 상수는 모두 public static final이기 때문에 생략이 가능하다.
		// interface내에 있는 매서드는 모두 public abstract이기 때문에 생략이 가능하다.
		
		// class와 interface의 차이점으로 interface를 쉽게 알아보기
		// interface 부모는 interface만 가능하다. ( Object가 최고 조상이 아니다!! )
		// interface는 다중 상속이 가능하다. ( 추상 매서드는 충돌해도 문제 없음 )
		// -- 다중 상속이 가능한 이유는 추상 매서드는 선언부만 있기 때문에 같은 추상 매서드가 여러 interface에 있어도 상관없다.
		
		// interface 구현
		// interface도 결국에는 미완성 설계도이기 때문에 완성을 해서 사용해야한다.
		// 구현 방법
		// class 클래스이름 implements 인터페이스 이름{
		//		인터페이스에 정의된 추상 매서드를 모두~ 구현(완성)해야 한다.
		//	}
		// 구현할 매서드 앞에는 꼭 public을 붙여줘야한다.
		
		// Q. 궁금했는데 상속과 구현이 동시에 되는가? A. 된다! 대신 상속 먼저 하고 구현을 해야한다. 
		
		// interface의 다형성
		TEST1 t = new interfaceTest2(); // 클래스의 다형성
		T2 t2 = new interfaceTest2(); // 인터페이스의 다형성
		T t3 = new interfaceTest2(); // 인터페이스의 다형성
		interfaceTest2 t4 = new interfaceTest2();
		interfaceTest3 t5 = new interfaceTest3();
		// interfaceTest2의 멤버는 5개이다.
		// T2 타입의 참조변수 t2는 move 매서드, attack 매서드만 사용이 가능하다.
		// T 타읩 참조변수 t3는 move 매서드만 사용이 가능하다.
		// TEST 타입 참조변수 t는 인스턴스 변수 x,y만 접근이 가능하다.
		interfaceTest2 aaaa = new interfaceTest2();
		aaaa.attack(t2);
		aaaa.attack(t4);
		aaaa.attack(t5);
	}
}

class TEST1 {
	int x, y;
}

interface T{
	void move(int x);
}

interface T2 extends T{
	// 매개변수 타입이 인터페이스일때 해당 인터페이스를 구현한 클래스의 인스턴스만 가능
	void attack(T2 x);
}

class interfaceTest implements T2{ // 구현
	public void move(int x) {
		System.out.println("움직여!");
	}
	public void attack(T2 x) {
		System.out.println("공격해!");
	}
}

class interfaceTest3 implements T2{
	public void move(int x) {}
	public void attack(T2 x) {}
}

class interfaceTest2 extends TEST1 implements T2{ // 상속과 구현
	public void move (int x) {
		System.out.println("move move!");
	}
	public void attack(T2 x) {
		System.out.println("attck!");
	}
	
	// T2 인터페이스를 구현한 클래스의 인스턴스를 반환
	T2 method() { // 인터페이스를 매소드의 리턴타입으로 지정할 수 있다.
		return new interfaceTest2();
		// return new interfaceTest3();도 가능하다.
		// 반환 타입인 T2인터페이스를 구현한 클래스이기 때문이다.
	}
}
