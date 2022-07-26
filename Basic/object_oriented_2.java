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



//================================================================