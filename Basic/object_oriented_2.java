import java.util.*;

public class object_oriented_2 {

	public static void main(String[] args) {
		
		//========================================================
		
		// ��� ����
		SmartTv stv = new SmartTv();
		stv.channel = 10; // ��ӹ��� ���
		stv.channelUp(); // ��ӹ��� ���
		System.out.println(stv.channel);
		stv.caption = true;
		stv.displayCaption("Hello JAVA");
		
		//========================================================
		
		// ��Ӱ� ���� ����
		Circle2 c = new Circle2(); // ���
		c.x = 1;
		c.y = 2;
		c.r = 3;
		System.out.println("c.x = " + c.x);
		System.out.println("c.y = " + c.y);
		System.out.println("c.z = " + c.r);
		
		Circle c2 = new Circle(); // ����
		c2.p.x = 1;
		c2.p.y = 2;
		c2.r = 3;
		System.out.println("c2.p.x = " + c2.p.x);
		System.out.println("c2.p.y = " + c2.p.y);
		System.out.println("c2.r = " + c2.r);
		
		
		//========================================================
		
		Imsolo my = new Imsolo();
		System.out.println(my.toString());
		// �θ�� �ڽ� Ŭ�������� toStirng�̶�� �޼ҵ尡 ������
		// ����������  solo Ŭ�������� �θ� Ŭ������ ��� Object Ŭ������ ��ӹް� �ȴ�.
		// Object Ŭ�������� toString(),equals()�� 11���� �޼ҵ带 ������ �ֱ� ������ ����� �� �ִ�.
		
		//========================================================
		
		// Override
		point3D pp = new point3D();
		pp.x = 3;
		pp.y = 5;
		pp.r = 7;
		System.out.println(pp.getAll()); // �������̵����� �ڽſ��� �´� �޼ҵ�� �����Ͽ���.
		// �������̵��� �Ѵٰ� �ؼ� ���� getAll()�� ��� ������ �������̵����� ������ �ٲ� �� �ִ�.
		
		//========================================================
		
		// ���� ��Ű�� ����Ҷ� ���
		java.util.Date today = new java.util.Date(); // Bad...
		
		// import���� ��������� ���
		// import�� �����Ϸ����� Ŭ������ ���� ��Ű���� �˷��ش�.
		// (��: import java.util.*;)
		Date today2 = new Date(); //Good!!
		
		// import���� ���� ���
		// 1. import ��Ű����.Ŭ������;
		// 2. import ��Ű����.*;
		
		// import���� ��Ű������ Ŭ���� ������ ���̿� �����ؾ��Ѵ�.
		// package com.codehobo.book; <- package
		
		// import java.text.*;
		// import java.util.*;
		
		// public class PackageTest{...}
		//========================================================
		
		// ���� ������ : public protected default private
		// ��          �� : static final abstract ...
		System.out.println(ModifierTest.WIDTH);
		 // Ŭ���� �����̸�, final ����̰� ���������ڴ� public�̴�.
		
		//========================================================
		
		
		
		//========================================================
	}

}

//================================================================

class Tv2{ // ��� 7��
	// Ŭ���� ����
	String color; // �ν��Ͻ� ���� 
	boolean power; // �ν��Ͻ� ����
	int channel; // �ν��Ͻ� ����
	static int cv; // Ŭ���� ���� (static ����) / ����Ӽ�
	
	// �޼��� ����
	void power() { power = !power; }
	void channelUp() { ++channel; }
	void channelDown() { --channel; }
	
	// �⺻ ������
	Tv2(){}
	Tv2(String color, boolean power, int channel){
		this.color = color;
		this.power = power;
		this.channel = channel;
	}
	// ��� �� �����ڿ� �ʱ�ȭ����� ��ӵ��� �ʴ´�.
	// �� ������ �ذ��ϱ� ���� ������ super()�� ����Ѵ�.
}

// extends �θ� Ŭ���� (��� ���)
class SmartTv extends Tv2{ // �ڽ� ��� 2�� + �θ� ��� 7�� = 9��
	boolean caption;
	void displayCaption(String text) {
		if (caption) {
			System.out.println(text);
		}
	}
}

// ��� �� �ڽ� Ŭ������ ��ȭ�� �θ𿡰� �ƹ� ������ ������ �θ� Ŭ������ ��ȭ�� �ڽ� Ŭ�������� ū ������ ��ģ��.

//================================================================

class Point{
	int x;
	int y;
}

// ��Ӻ��� ������ ���� ����Ѵ�.
class Circle{
	Point p = new Point(); // ���� ���� �����
	/*
	 Q. ���� �������� p�� �ʱ�ȭ�� �ٷ� ������ �ʾҴٸ�??
	 Point p;
	 
	 Circle(){ // �����ڷ� �ʱ�ȭ ����� �Ѵ�.
	 	p = new point();
	 }
	 Q. p�� �ʱ�ȭ ������ ������ ��� �ǳ���?
	 A. p�� ���������̱� ������ null�� �ڵ� �ʱ�ȭ �˴ϴ�.
	 */
	int r;
}

class Circle2 extends Point{ // ���
	int r;
}

//================================================================

// Java������ ���ϻ�� ��Ģ�̹Ƿ� ���� 2���� Ŭ������ ����� �������� �ʹٸ� �ϳ��� ��� �ϳ��� �������� �����´�.
// �θ� Ŭ������ ���� Ŭ������ �ڵ������� Object Ŭ������ ��ӹް� �ȴ�.
// Object Ŭ������ �޼ҵ忡�� ��ǥ������ toString(), equals(), hashCOde()... �ִ�.

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
// �������̵��� ���ǿ��� �� 3���� �ִ�.
// 1. �޼ҵ��� ����ΰ� ���� Ŭ������ �޼ҵ�� ��ġ�ؾ��Ѵ�.
//    - ����ζ�? Ÿ��, �޽����, �Ű������� ���Ѵ�.
// 2. ���� �����ڸ� ���� Ŭ������ �޼ҵ庸�� ���� ������ ������ �� ����.
//	  - public <- protected <- default <- private (public�� ���� ����)
// 3. ���Ǵ� ���� Ŭ������ �޼ҵ庸�� ���� ������ �� ����.

//================================================================

// Quiz Time!!!
// �����ε��� �������̵��� �����Ͻÿ�.
class Parent{
	void parentMethod() {} // �޼ҵ� ����
}

class Child extends Parent{
	void parentMethod() {System.out.println("Good");} // �������̵�
	void parentMethod(int i) {} // �����ε�
	
	void childMethod() {} // �޼ҵ� ����
	void childMethod(int i) {} // �����ε�
	// void childMethod() {} // �ߺ����� Error!!
}

//================================================================

class Parent2 {
	int x = 10;
}

class Child2 extends Parent2{
	int x = 20;
	
	void method() {
		System.out.println("x = " + x); // ����� x�� ã�´�.
		System.out.println("this.x = " + this.x); // �ڱ� �ڽ��� x
		System.out.println("super.x = " + super.x); // �θ��� x
		// �������� super�� ������ ����� �ڽ��� ����� ������ �� ����Ѵ�.
		// �������� super�� �ν��Ͻ� �޼ҵ忡���� �����Ѵ�.
	}
}

class Child3 extends Parent2{
	void method() {
		System.out.println("x = " + x); // ����� x�� ã�´�.
		System.out.println("this.x = " + this.x); // �ڱ� �ڽ��� x
		System.out.println("super.x = " + super.x); // �θ��� x
	}
}
// Child3�� ��� �ڱ� �ڽ��� ������ ������ ���� �ʴ´�.
// �̷����� �θ��� �ν��Ͻ� ������ this�� super ��η� ������ �� �ְ� �ȴ�.

//================================================================

// ���� �߿��ϴ�!!!!! �������� ù�ٿ��� �ݵ�� ������ (this() or super())�� ȣ���ؾ� �Ѵ�.
class point4 {
	int x;
	int y;
	
	point4(){
		this(0,0);
	}
	point4(int x, int y){
		// super(); ������ �������� ù�ٿ� �������ش�.
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
		// �����ڷ� ȣ���߱� ������ �������� �ڵ��̴�.
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
		// point5 Ŭ�������� �޼ҵ���� point5�̰� �Ű������� ���� �޼ҵ�� �������� �ʱ� ������ Error �߻�
		// �� Error�� ��������  point5 Ŭ���� ���ο� �⺻ �����ڸ� ����� ����� �ִ�.
		// �� �ٸ� ����� mypoint3D�� �Ű����� �ִ� �����ڿ��� ��ӹ��� �������� super()�� �����ָ� �ȴ�.
		
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
	public static final int WIDTH = 200; // ������ �� 3��
	// public : ���������� 
	// static : Ŭ���� ����
	// final : ������ ���� ����� �����.
}

class staticTest{
	static int width;   // Ŭ���� ���� (static ����)
	static int height;   // Ŭ���� ���� (static ����)
	
	static {   // Ŭ���� �ʱ�ȭ ���
		width = 300;
		height = 400;
	}// static������ ������ �ʱ�ȭ
	static int max (int a, int b) { // Ŭ���� �޼���(static �޼���)
		return a > b? a : b;
	}
}

final class FinalTest{ // �θ� Ŭ������ �� �� ����. (��, ����� �� �� ����.)
	final int Max_size = 10; // ���� ���� �� �� ���� (���)
	
	final int getMaxSize() { // �������̵� �� �� ���� �޼��� (���� �Ұ�)
		final int lv = Max_size; // ���� ������ �� ���� �������� (���)
		return lv;
	}
}

abstract class AbstractTest{ // (�߻� Ŭ����)Ŭ���� ���ο� �߻� �޼��尡 ���� �Ǿ� ������ �ǹ��Ѵ�.
	abstract void move(); // (�߻� �޼���)����θ� �ۼ��ϰ� ������ �强���� ���� �߻� �޼������� �ǹ��Ѵ�.
}
// abstract�� ������ �̿ϼ� �� Ŭ�����̱� ������ �ν��Ͻ� ������ �Ұ����ϴ�.
// AbstractTest a = new AbstractTest(); ERROR!!!!!!
// �߻� Ŭ������ ��ӹ޾Ƽ� ������ Ŭ������ ���� �� ���

//================================================================



//================================================================