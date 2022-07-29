
public class InnerClass {
	
	class InstanceInner{
		int iv = 100;
		// static int cv = 100; >> Error 인스턴스 클래스에서는 static 멤버를 선언 할 수 없다.
		final static int CONST = 100; // final static은 상수이기 떄문에 만들 수 있다.
	}
	static class  Staticinner{
		int iv = 200;
		static int cv = 200; // static 클래스에서는 static 멤버를 정의할 수 있다.
	}
	void myMethod() {
		final int Lv = 0;
		class Localinner{
			int iv = 300;
			int iiv = Lv;
			// static int cv = 10; >> Error 지역 클래스에서는 static 멤버를 선언할 수 없다.
			final static int CONST =300; // final static은 상수이기 떄문에 만들 수 있다.
		}
	}

	public static void main(String[] args) {
		// 클래스 안의 클래스
		// 내부 클래스에서 외부 클래스의 멤버들을 객체생성 없이 접근가능
		// 코드의 복잡성을 줄일 수 있다. (캡슐화)
		
		// 내부 클래스의 종류는 변수와 똑같이 인스턴스  내부클래스, static 내부클래스, 지역 내부클래스 로 나뉜다.
		// >> 추가 사항 익명 클래스도 있다.(클래스의 선언과 객체의 생성을 동시에 하는 이름없는 클래스 1회용)
		// 유효 범위 또한 변수와 같다.
		
		// 내부 클래스의 접근 제어자는 4개 모두 된다! (변수 같은 클래스다...)
		// <복습> 외부 클래스는 접근제어자 2개 가능 (default, public)
		
		// 내부 클래스는 외부 클래스의 private 멤버도 접근가능하다.
		// 지역 내부클래스를 감싸고 있는 매서드의 상수만 사용이 가능하다.
		
		// ==============예제===============
		// 일반적인 클래스
		BBB b = new BBB();
		b.method();

		// 내부 클래스
		AAA2 a = new AAA2();
		a.b.method();
		// ==============예제===============
		System.out.println(Staticinner.cv);
		System.out.println(InstanceInner.CONST);
	}

}

class AAA{
	int i=100;
	BBB b = new BBB();
}
class BBB{
	void method() {
		AAA a = new AAA();
		System.out.println(a.i);
	}
}

// ============위 아래 코드는 같은 코드이다.=================

class AAA2{ // AAA2는 BBB2의 외부 클래스
	int i = 100;
	BBB b = new BBB();
	class BBB2{ // BBB2는 AAA2의 내부 클래스
		void method() {
			System.out.println(i);
		}
	}
}

// ===============================================
