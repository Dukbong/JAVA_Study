
// �ϳ��� �ҽ����Ͽ��� �ϳ��� Ŭ������ �ۼ��ϴ°��� �ٶ����ϴ�.
public class object_oriented {
// Ŭ������ ���� �� ������ public�� ������ ���ϸ�� ���� �ϳ��� �����ؾ��Ѵ�.
	public static void main(String[] args) {
		Tv t1 = new Tv();
		t1.channel = 7;
		t1.channelDown();
		System.out.println(t1.channel); // 6
		
		Tv t2 = new Tv();
		System.out.println("t2�� channel���� " + t2.channel + "�Դϴ�.");
		
		t2 = t1; // �������� t2�� �ּҰ��� �������� t1�� �ּ� ������ �ٲ��ش�.
		// 11������ ���� ��ü�� ���̻� ����� �Ұ����Ͽ� GC(������ ó��)�� �����ش�.
		System.out.println("t2�� channel���� " + t2.channel + "�Դϴ�.");
		
		//��ü�� �迭ȭ
		Tv[] t3 = new Tv[3];
		t3[0] = new Tv();
		t3[1] = new Tv();
		t3[2] = new Tv();
		
		//============================================================
		
		System.out.println("static width = " +  Card.width);
		System.out.println("static height = " +  Card.height);
		
		Card c1 = new Card();
		c1.kind = "space";
		c1.number = 5;
		
		// Ŭ���� ���� �����ϱ�
		Card.width = 150; // c1.width�̶�� ���� �� ������ �ν��Ͻ� ��ȭ�� �򰥸��� ������ �������� �ʴ´�.
		Card.height = 550; // c1.width�̶�� ���� �� ������ �ν��Ͻ� ��ȭ�� �򰥸��� ������ �������� �ʴ´�.
		
		System.out.println("static width = " +  Card.width);
		System.out.println("static height = " +  Card.height);
		
		//============================================================
		
		myMath mm = new myMath();
		long result1 = mm.add(5L, 3L);
		System.out.println("add(5L,3L) = " + result1);
		long result2 = mm.subtract(5L, 3L);
		System.out.println("subtract(5L,3L) = " + result2);
		long result3 = mm.multiply(5L, 5L);
		System.out.println("multiply(5L,3L) = " + result3);
		double result4 = mm.divide(5L, 2L);
		System.out.println("divide(5L,2L) = " + result4);
		long result5 = mm.max(5L, 2L);
		System.out.println("max(5L, 2L) = " + result5);
		
		//============================================================

		myMath2 gugu = new myMath2();
		gugu.printGugudan(2);
		
		//============================================================
		
		Data d = new Data();
		d.x = 10;
		System.out.println("main() : x = " + d.x);
		
		change(d.x); 
		System.out.println("After change(d.x)");
		System.out.println("main() : x = " + d.x);
		
		//============================================================

		Data c = new Data();
		c.x = 10;
		System.out.println("c main() : x = " + c.x);
		
		change2(c);
		System.out.println("After change2(d)");
		System.out.println("c main() : x = " + c.x);
		
		//============================================================
		
		Data dd = new Data();
		dd.x = 10;
		
		Data d2 = copy(dd);
		System.out.println("d.x = " + dd.x);
		System.out.println("d2.x = " + d2.x);
		
		//============================================================
		
		myMath3 e = new myMath3();
		System.out.println("e.adds(3,3) => " + e.adds(3, 3));
		System.out.println("e.adds(3L,3L) => " + e.adds(3L, 3L));
		System.out.println("e.adds(3L,3) => " + e.adds(3L, 3));
		System.out.println("e.adds(3,3L) => " + e.adds(3, 3L));
		
		//============================================================

		Data_1 f1 = new Data_1();
		Data_2 f2 = new Data_2();
		f1.value = 1;
		f2.value = 2; // == Data_2 f2 = new Data_2(2);
		
		//============================================================

		Car2 car1 = new Car2();
		Car2 car2 = new Car2("red");
		Car2 car3 = new Car2("yellow", "auto", 99);
		System.out.printf("�ش� ������ ������ %s ���� %s ���� ������ %d\n",car1.color, car1.gearType, car1.door);
		System.out.printf("�ش� ������ ������ %s ���� %s ���� ������ %d\n",car2.color, car2.gearType, car2.door);
		System.out.printf("�ش� ������ ������ %s ���� %s ���� ������ %d\n",car3.color, car3.gearType, car3.door);
		
		//============================================================

		
		
		//============================================================

		
	}
	static void change(int x) { // �⺻�� �Ű����� (�������� d�� x���� �б⸸ �����ϴ�.)
		x = 10000;
		System.out.println("c change() x = " + x);
	}
	
	//============================================================
	
	static void change2(Data c) { // ������ �Ű����� (�������� c�� �ּҰ� ����� �����ϴ�.)
		c.x = 10000;
		System.out.println("c change2() x = " + c.x);
	}
	
	//============================================================
	
	static Data copy(Data d) { // ��ȯŸ���� �������� ���� ��ü�� �ּҸ� ��ȯ�Ѵ�.
		Data tmp = new Data();
		tmp.x = d.x;
		return tmp; // ������ �۾��� ��ü�� �ּҸ� ��ȯ�Ѵ�.
	}
}

class Tv{ 
	// Ŭ���� ����
	String color; // �ν��Ͻ� ���� 
	boolean power; // �ν��Ͻ� ����
	int channel; // �ν��Ͻ� ����
	static int cv; // Ŭ���� ���� (static ����) / ����Ӽ�
	
	// �޼��� ����
	void power() { power = !power; }
	void channelUp() { ++channel; }
	void channelDown() { --channel; }
}

//============================================================

class Card{
	String kind; // �ν��Ͻ� ����
	int number; // �ν��Ͻ� ����
	static int width = 100; // Ŭ���� ����
	static int height = 250; // Ŭ���� ����
}

//============================================================

class myMath{
	long add(long a, long b) {
		long result = a + b;
		return result;
	}
	long subtract(long a, long b) {
		return a - b;
	}
	long multiply(long a, long b) {
		return a * b;
	}
	double divide(double a, double b) {
		return a / b;
	}
	long max(long a, long b) {
		return a > b? a:b;
	}
}

//============================================================

class myMath2{
	void printGugudan(int dan) {
		if( !(2<= dan && dan <= 9)) {
			return;
		}
		for(int i = 1; i <= 9; i++) {
			System.out.printf("%d x %d = %d\n", dan, i, dan*i);
		}
	}
}

//============================================================

class Data {
	int x;
}

//============================================================

class myMath3{
	int adds(int x, int y) {
		System.out.printf("\nint adds(int x, int y) = ");
		return x+ y;
	}
	long adds(long x, long y) {
		System.out.printf("\nlong adds(long x, long y) = ");
		return x+ y;
	}
	long adds(int x, long y) {
		System.out.printf("\nlong adds(int x, long y) = ");
		return x+ y;
	}
	long adds(long x, int y) {
		System.out.printf("\nlong adds(long x, int y) = ");
		return x+ y;
	}
}

//============================================================

class Data_1{ // �����ڰ� ������ ������ �������� Data_1(){} �����ڸ� �߰����ش�.
	int value;
}

class Data_2{ 
	int value;
	
	Data_2(){} // �⺻������
	Data_2(int x){ // �Ű� ������ �ִ� ������
		value = x;
	}
}

//============================================================

class Car2{
	String color;
	String gearType;
	int door;
	
	// this �����ڴ� ������ ù �ٿ����� ��� �����ϴ�.
	Car2(){ // �⺻ ������
		this("white", "auto", 4); // ������ ��
		// this �����ڴ� �Ű����� �ִ� �����ڸ� ȣ���Ѵ�.
		// �Ű����� ���� �����ڴ� �ν��Ͻ� ������ �����尪���� ����� �� �� �ִ�.
	}
	Car2(String color){ // �⺻������
		this(color, "auto", 4); 
		// this �����ڴ� �Ű����� �ִ� �����ڸ� ����Ų��.
	}
	// �Ű����� �ִ� ������
	Car2(String color, String gearType, int door){
		this.color = color;
		this.gearType = gearType;
		this.door = door;
	}
}

//============================================================

class InitTest{
	static int cv = 1; // ����� �ʱ�ȭ (����)
	int iv = 1; // ����� �ʱ�ȭ (����)
	
	static { // static �ʱ�ȭ ��� (����)
		cv = 2;
	}
	
	// ������
	InitTest(){ // �ν��Ͻ� �ʱ�ȭ ��� (����) 
		iv = 2;
	}
}
/*
  �ʱ�ȭ ����
 1. static ���� cv = 0���� �ڵ� �ʱ�ȭ
 2. static ���� cv = 1�� ����� �ʱ�ȭ
 3. static ���� cv = 2�� static �ʱ�ȭ ��ϻ��
 4. �ν��Ͻ�     ���� iv = 0���� �ڵ� �ʱ�ȭ
 5. �ν��Ͻ�     ���� iv = 1�� ����� �ʱ�ȭ
 6. �ν��Ͻ�     ���� iv = 2�� �ν��Ͻ� �ʱ�ȭ ��ϻ��(������)
 
 static ������ ó�� �ε��� �� �� �ѹ��� �ʱ�ȭ�ȴ�.
 �ν��Ͻ� ������ ��� �ν��Ͻ��� ������ �� ���� �ʱ�ȭ�ȴ�.
*/

//============================================================



//============================================================



//============================================================
