
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
		double result4 = mm.divide(5L, 2L); // double�� �� ũ�� ������ �ڵ� ����ȯ�ȴ�.
		System.out.println("divide(5L,2L) = " + result4);
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
	void method() {
		int aa = 0; // ��������
	}
}

class Card{
	String kind; // �ν��Ͻ� ����
	int number; // �ν��Ͻ� ����
	static int width = 100; // Ŭ���� ����
	static int height = 250; // Ŭ���� ����
}

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
}