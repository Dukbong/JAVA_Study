
public class interfaceTraining {

	public static void main(String[] args) {
		// 인터페이스의 장점
		// - 두 대상(객체)간의 "연결,대화,소통"을 돕는 중간 역할을 한다.
		// - 선언과 구현을 분리시킬 수 있다.
		// - 개발 시간을 단축할 수 있다.
		// - 변경에 유리한 유연한 설계가 가능하다.
		// - 표준화가 가능하다.
		// - 서로 관계없는 클래스들을 관계를 맺어줄 수 있다.
		
		// JDK1.8부터 인터페이스에 디폴트 매서드, static 매서드를 추가할 수 있게 되었다.
		// default method = 완성된 매서드이다.
		// 충돌하면 직접 오버라이딩 하면 된다. (해결책)
		
		Fighter f = new Fighter();
		// getFighter() 매서드으 리턴 타입과 맞춰준다.
		Fightable ff = f.getFighter();
		
		f.move(100, 200);
		f.attack(f);
		
		f.attack(new Fighter());
		
		Fighter f2 = new Fighter();
		f2.attack(f2);
		f2.stop();
		
		Fightable f3 = new Fighter();
		f3.attack(f3);
		f3.move(50, 70);
		
		Unit2 u = new Fighter();
		u.move(10, 20);
		u.stop();
		
		// A클래스와 B클래스는 직접적인 관계의 클래스 ( 인터페이스 X) - 강력한 결합
		// A클래스 - B클래스 (직접 연결)
		A a = new A();
		a.method(new B()); // A가 B를 사용 (의존)
		a.method(new C());
		
		// A클래스와 B클래스는 간접적인 관계의 클래스 ( 인터페이스 O ) - 느슨한 결합
		// A클래스 - interface - B클래스 (간접 연결)
		A2 a2 = new A2();
		I i = new B2();
		a2.methodAll(i);
		I i2 = new C2();
		a2.methodAll(i2);

	}
}
abstract class Unit2{
	int x,y;
	abstract void move(int x, int y);
	void stop() {
		System.out.println("stop!");
	}
}

// interface에 있는 추상 매서드는 기본적으로 public abstract이기 때문에 생략할 수 있다.
interface Fightable{
	void move (int x, int y);
	void attack (Fightable f);
}

class Fighter extends Unit2 implements Fightable{
	// public을 붙여주는 이유는 오버라이딩을 할때 부모보다 접근제어자가 좁아지면 안되기 때문이다.
	public void move(int x, int y) {
		System.out.printf("[%d %d]로 이동\n",x,y);
	}
	public void attack(Fightable f) {
		System.out.println(f + "를 공격");
	}
	// interface가 리턴타입으로 들어오면 해당 interface를 구현한 클래스만 가능하다.
	Fightable getFighter(){
		Fighter f = new Fighter();
		return f;
	}
}

// 직접적인 관계의 클래스 ( 인터페이스 X) - 강력한 결합
class A{ // 변경 및 추가될때 마다 A클래스를 수정해줘야한다.
	public void method(B b) {
		b.method();
	}
	public void method(C c) {
		c.method();
	}
}
class B{
	public void method() {
		System.out.println("B클래스의 매서드");
	}
}
class C {
	public void method() {
		System.out.println("C클래스의 매서드");
	}
}

// 간접적인 관계의 클래스 ( 인터페이스 O ) - 느슨한 결합
class A2{
	public void methodAll(I i) { // interface I를 구현한 클래스만 올수 있다.
		i.methodAll();
	}
}

interface I{ 
	void methodAll(); // 껍데기
}

class B2 implements I{
	public void methodAll() {
		System.out.println("B2클래스의 매서드"); // 알맹이
	}
}

class C2 implements I{
	public void methodAll() {
		System.out.println("C2클래스의 매서드"); // 알맹이
	}
}