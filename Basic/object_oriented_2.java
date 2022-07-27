import java.util.*;

public class object_oriented_2 {

	public static void main(String[] args) {
		
		//========================================================
		
		// 상속 예제
		SmartTv stv = new SmartTv();
		stv.channel = 10; // 상속받은 멤버
		stv.channelUp(); // 상속받은 멤버
		System.out.println(stv.channel);
		stv.caption = true;
		stv.displayCaption("Hello JAVA");
		
		//========================================================
		
		// 상속과 포함 예제
		Circle2 c = new Circle2(); // 상속
		c.x = 1;
		c.y = 2;
		c.r = 3;
		System.out.println("c.x = " + c.x);
		System.out.println("c.y = " + c.y);
		System.out.println("c.z = " + c.r);
		
		Circle c2 = new Circle(); // 포함
		c2.p.x = 1;
		c2.p.y = 2;
		c2.r = 3;
		System.out.println("c2.p.x = " + c2.p.x);
		System.out.println("c2.p.y = " + c2.p.y);
		System.out.println("c2.r = " + c2.r);
		
		
		//========================================================
		
		Imsolo my = new Imsolo();
		System.out.println(my.toString());
		// 부모와 자식 클래스에는 toStirng이라는 메소드가 없지만
		// 최종적으로  solo 클래스에는 부모 클래스가 없어서 Object 클래스를 상속받게 된다.
		// Object 클래스에는 toString(),equals()등 11가지 메소드를 가지고 있기 때문에 사용할 수 있다.
		
		//========================================================
		
		// Override
		point3D pp = new point3D();
		pp.x = 3;
		pp.y = 5;
		pp.r = 7;
		System.out.println(pp.getAll()); // 오버라이딩으로 자신에게 맞는 메소드로 변경하였다.
		// 오버라이딩을 한다고 해서 원래 getAll()을 상속 받지만 오버라이딩으로 내용을 바꿀 수 있다.
		
		//========================================================
		
		// 원래 패키지 사용할때 방법
		java.util.Date today = new java.util.Date(); // Bad...
		
		// import문을 사용했을때 방법
		// import는 컴파일러에게 클래스가 속한 패키지를 알려준다.
		// (예: import java.util.*;)
		Date today2 = new Date(); //Good!!
		
		// import문의 선언 방법
		// 1. import 패키지명.클래스명;
		// 2. import 패키지명.*;
		
		// import문은 패키지문과 클래스 선언의 사이에 선언해야한다.
		// package com.codehobo.book; <- package
		
		// import java.text.*;
		// import java.util.*;
		
		// public class PackageTest{...}
		//========================================================
		
		// 접근 제어자 : public protected default private
		// 그          외 : static final abstract ...
		System.out.println(ModifierTest.WIDTH);
		// 클래스 변수이며, final 상수이고 접근제어자는 public이다.
		
		//========================================================
		
		// 하나의 대상에는 접근 제어자 1개만 사용이 가능하다.
		// private : 같은 클래스 (멤버에 사용가능)
		// default : 같은 패키지 (생략가능) (class에 사용 가능) (멤버에 사용가능)
		// protected : 같은 패키지, 다른 패키지 첫번째 자식 클래스 (멤버에 사용가능)
		// public : 접근 제한이 전혀 없다. (class에 사용 가능) (멤버에 사용가능)
		// 예시는 PackageTestprj > Myparent.java & MyparentTest2.java
		
		//========================================================
		
		// 캡슐화 : 접근 제어자를 사용해서 외부로 부터 데이터를 보호하기 위한 방법
		
		Time time = new Time();
		// time.hour; 접근 제어자 private 이므로 x
		// 직접 접근을 막고 있다.
		time.setHour(22);
		time.getHour();
		
		
		//========================================================
		
		// 다형성 : 조상 타입 참조 변수로 자손 타입 객체를 다루는 것!
		TT t = new TTT(); // 참조변수 t의 타입은 부모 클래스의 타입을 가지고 생성된 객체는 자식 클래스이다.
		// t.button = 1; button은 자식 클래스의 멤버이므로 사용이 불가능하다.
		t.power = true;
		t.power();
		System.out.println(t.power);
		
		// 주의 사항 자식과 부모 사이에만 가능하며 자식 타입 변수에 부모 타입 객체를 다루는 건 불가능하다.
		// 쉽게 생각해서 멤버수 가 적은 곳이 큰곳의 객체를 다룰 수 있다고 보면 된다.
		// 부모 타입의 참조변수가 자식 타입 객체를 다룰 때 사용 가능한 멤버는 부모의 멤버로만 가능하다.
		
		//========================================================
		
		// 참조변수의 형변환 : 사용할 수 있는 멤버의 갯수를 조절하는 것이다.
		// 부모 자식 관계에서만 참조변수는 서로 형변환이 가능하다.
		FireEngine f = new FireEngine(); // 멤버 5개
		car ca = (car)f;
		// car 타입과 FireEngine 타입은서로 타입이 맞지 않기 때문에 형변환을 해준다.
		// car 타입은 멤버가 4개 이므로 가지고 있는 4개만 사용이 가능하다.
		// FireEngine 타입의 참조변수 f에 FireEngine 인스턴스를 가르키는 주소 0X100이 저장되어있다.
		// car 타입의 참조변수 ca에 f의 주소 0X100을 똑같이 저장한다.
		// 두개의 참조변수가 한 인스턴스를 가르키고 있다.
		// 참조변수 f는 FireEngine 인스턴스의 모든 멤버를 사용가능하다.
		// 참조변수 ca는 FireEngine 인스턴스의 멤버 중 가지고 있는 4개만 사용이 가능하다.
		ca.color = "yellow";
		// ca.water() Error!!!! 이건 FireEngine의 메서드다!!
		
		FireEngine f2 = (FireEngine)ca;
		// 현재 ca의 타입은 car이고 주소 0X100이 저장되어있다
		// 형변환을 통해 양쪽 타입을 맞춰주고 f2에 주소 0X100을 저장한다.
		// 참조변수 f2의 타입은 FireEngine이기 때문에 멤버 5개 모두 사용 가능하다.
		f.water();
		f2.water();
		f.color = "red";
		
		// 참조변수 형변환에서 가장 중요한 것은 실체 인스턴스가 무언인지 입니다.
		// 위에 코드를 예시를 들자면 처음 멤버 5개 짜리 인스턴스 주소를 f에 저장
		// f의 주소를 ca에 저장 ( 사용 가능 멤버 4개 )
		// ca의 주소를 f2에 저장 ( 사용 가능 멤버 5개 )
		// 이렇게 가르키는 인스턴스의 멤버가 5개이면 그 이하로 형변환이 가능하지만 5개를 초과하는 건 불가능하다.
		
		//========================================================
		
			// 아래 코드는 실행 중 에러가 발생하는 코드이다.
			//    car cc = new car(); // 멤버 4개
			//    FireEngine fe = (FireEngine)cc;
			// 5개 멤버를 가진 FireEngine 타입의 참조변수 fe에 4개 멤버를 가진 인스턴스의 주소를 넣어주려고 했기 떄문에 오류가  발생한다.
			//    fe.water();
		
		//========================================================
			
			FireEngine fee = new FireEngine();
			// instanceof 연산자 : 참조변수 형변환 가능 여부 확인에 사용 (가능 : true)
			// 부모 클래스와 자기 자신에게 true를 반환한다.
			System.out.println(fee instanceof car); // true
			System.out.println(fee instanceof Object); // true
			System.out.println(fee instanceof FireEngine); // true
			car ccc = (car)fee; // ok
			Object obj = (Object) fee; // ok
			
		//========================================================
	}

}

//================================================================

class Tv2{ // 멤버 7개
	// 클래스 영역
	String color; // 인스턴스 변수 
	boolean power; // 인스턴스 변수
	int channel; // 인스턴스 변수
	static int cv; // 클래스 변수 (static 변수) / 공통속성
	
	// 메서드 영역
	void power() { power = !power; }
	void channelUp() { ++channel; }
	void channelDown() { --channel; }
	
	// 기본 생성자
	Tv2(){}
	Tv2(String color, boolean power, int channel){
		this.color = color;
		this.power = power;
		this.channel = channel;
	}
	// 상속 시 생성자와 초기화블록은 상속되지 않는다.
	// 이 문제를 해결하기 위해 생성자 super()를 사용한다.
}

// extends 부모 클래스 (상속 방법)
class SmartTv extends Tv2{ // 자식 멤버 2개 + 부모 멤버 7개 = 9개
	boolean caption;
	void displayCaption(String text) {
		if (caption) {
			System.out.println(text);
		}
	}
}

// 상속 시 자식 클래스의 변화는 부모에게 아무 영향이 없지만 부모 클래스의 변화는 자식 클래스에게 큰 영향을 끼친다.

//================================================================

class Point{
	int x;
	int y;
}

// 상속보다 포함을 많이 사용한다.
class Circle{
	Point p = new Point(); // 포함 관계 만들기
	/*
	 Q. 만약 참조변수 p의 초기화를 바로 해주지 않았다면??
	 Point p;
	 
	 Circle(){ // 생성자로 초기화 해줘야 한다.
	 	p = new point();
	 }
	 Q. p를 초기화 해주지 않으면 어떻게 되나요?
	 A. p는 참조변수이기 때문에 null로 자동 초기화 됩니다.
	 */
	int r;
}

class Circle2 extends Point{ // 상속
	int r;
}

//================================================================

// Java에서는 단일상속 원칙이므로 만약 2개의 클래스의 멤버를 가져오고 싶다면 하나는 상속 하나는 포함으로 가져온다.
// 부모 클래스가 없는 클래스는 자동적으로 Object 클래스를 상속받게 된다.
// Object 클래스의 메소드에는 대표적으로 toString(), equals(), hashCOde()... 있다.

class solo{
	int x;
	int y;
}

class Imsolo extends solo{
	int r;
}

//================================================================

class Point2 {
	int x;
	int y;
	
	String getAll() {
		return "x = " + x + ", y =" + y;
	}
}

class point3D extends Point2{
	int r;
	
	String getAll() {
		return "x = " + x + ", y =" + y + ", r =" + r;
	}
}
// 오버라이딩의 조건에는 총 3개가 있다.
// 1. 메소드의 선언부가 조상 클래스의 메소드와 일치해야한다.
//    - 선언부란? 타입, 메스드명, 매개변수를 말한다.
// 2. 접근 제어자를 조상 클래스의 메소드보다 좁은 범위로 변경할 수 없다.
//	  - public <- protected <- default <- private (public이 가장 넓음)
// 3. 예의는 조상 클래스의 메소드보다 많이 선언할 수 없다.

//================================================================

// Quiz Time!!!
// 오버로딩과 오버라이딩을 구별하시오.
class Parent{
	void parentMethod() {} // 메소드 정의
}

class Child extends Parent{
	void parentMethod() {System.out.println("Good");} // 오버라이딩
	void parentMethod(int i) {} // 오버로딩
	
	void childMethod() {} // 메소드 정의
	void childMethod(int i) {} // 오버로딩
	// void childMethod() {} // 중복정의 Error!!
}

//================================================================

class Parent2 {
	int x = 10;
}

class Child2 extends Parent2{
	int x = 20;
	
	void method() {
		System.out.println("x = " + x); // 가까운 x을 찾는다.
		System.out.println("this.x = " + this.x); // 자기 자신의 x
		System.out.println("super.x = " + super.x); // 부모의 x
		// 참조변수 super는 조상의 멤버를 자신의 멤버와 구별할 때 사용한다.
		// 참조변수 super는 인스턴스 메소드에서만 존재한다.
	}
}

class Child3 extends Parent2{
	void method() {
		System.out.println("x = " + x); // 가까운 x을 찾는다.
		System.out.println("this.x = " + this.x); // 자기 자신의 x
		System.out.println("super.x = " + super.x); // 부모의 x
	}
}
// Child3의 경우 자기 자신이 변수를 가지고 있지 않는다.
// 이럴때는 부모의 인스턴스 변수를 this와 super 모두로 가져올 수 있게 된다.

//================================================================

// 정말 중요하다!!!!! 생성자의 첫줄에는 반드시 생성자 (this() or super())를 호출해야 한다.
class point4 {
	int x;
	int y;
	
	point4(){
		this(0,0);
	}
	point4(int x, int y){
		// super(); 컴파일 과정에서 첫줄에 삽입해준다.
		this.x = x;
		this.y = y;
	}
}

class point5 {
	int x;
	int y;
	
	point5(){}
	point5(int x, int y){
		// super(); == Object();
		// 생성자로 호출했기 때문에 정상적인 코드이다.
		this.x = x;
		this.y = y;
	}
	
	String getAll() {
		return "x : " + x + ", y = " + y;
	}
}

class mypoint3D extends point5{
	int z;
	
	mypoint3D(int x, int y, int z){
		// super() == point5()
		// point5 클래스에는 메소드명이 point5이고 매개변수가 없는 메소드는 존재하지 않기 때문에 Error 발생
		// 이 Error를 막으려면  point5 클래스 내부에 기본 생성자를 만드는 방법이 있다.
		// 또 다른 방법은 mypoint3D의 매개변수 있는 생성자에서 상속받은 변수들을 super()로 묶어주면 된다.
		
//		this.x = x; 
//		this.y = y;
		super(x,y); // == point5(x,y)
		this.z = z;
	}
	
	String getAll() {
		return "x : " + x + ", y = " + y + ", z = " + z;
	}
}
//================================================================

class ModifierTest{
	public static final int WIDTH = 200; // 제어자 총 3개
	// public : 접근제어자 
	// static : 클래스 변수
	// final : 변수랑 쓰면 상수로 만든다.
}

class staticTest{
	static int width;   // 클래스 변수 (static 변수)
	static int height;   // 클래스 변수 (static 변수)
	
	static {   // 클래스 초기화 블록
		width = 300;
		height = 400;
	}// static변수의 복잡한 초기화
	static int max (int a, int b) { // 클래스 메서드(static 메서드)
		return a > b? a : b;
	}
}

final class FinalTest{ // 부모 클래스가 될 수 없다. (즉, 상속해 줄 수 없다.)
	final int Max_size = 10; // 값을 변경 할 수 없다 (상수)
	
	final int getMaxSize() { // 오버라이딩 할 수 없는 메서드 (변경 불가)
		final int lv = Max_size; // 값을 변경할 수 없는 지역변수 (상수)
		return lv;
	}
}

abstract class AbstractTest{ // (추상 클래스)클래스 내부에 추상 메서드가 선언 되어 있음을 의미한다.
	abstract void move(); // (추상 메서드)선언부만 작성하고 구현부 장성하지 않은 추상 메서드임을 의미한다.
}
// abstract가 있으면 미완성 된 클래스이기 때문에 인스턴스 생성이 불가능하다.
// AbstractTest a = new AbstractTest(); ERROR!!!!!!
// 추상 클래스를 상속받아서 완전한 클래스로 만든 후 사용

//================================================================

class Time {
	private int hour;
	
	public void setHour(int hour) {
		if (check(hour)) {
			return;
		}
		this.hour = hour;
	}
	private boolean check(int hour) {
		return hour < 0 || hour > 23;
	}
	// check 매서드는 코드 수정 시 테스트 범위를 줄이기 위해 private으로 접근 제어자를 주었다.
	// 또한 굳이 check 매서드를 외부에서 사용할 일이 없기 때문에 private으로 접근 제어자를 주었다.
	public int getHour() {
		System.out.println("hour = " + hour);
		return hour;
	}
}
// 클래스의 변수 값을 변경하기 위해서는 매서드를 통해 간접적으로만 접근이 가능하다.

//================================================================

class TT{
	boolean power;
	
	void power() {
		power = !power;
	}
}

class TTT extends TT{
	int button;
	
	void resetbtn() {
		button = 0;
	}
}

//================================================================

class car{
	String color;
	int door;
	
	void drive() {
		System.out.println("drive, Brrrr~");
	}
	void stop() {
		System.out.println("STOP");
	}
}

class FireEngine extends car{
	void water() {
		System.out.println("Water!!!");
	}
}

//================================================================
//================================================================
//================================================================
//================================================================
