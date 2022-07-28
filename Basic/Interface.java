
public class Interface {

	public static void main(String[] args) {
		// interface�� �߻� �ż����� �����̴�. ( ������ ���� �� ����  << �߻�Ŭ������ �������̽��� ������ )
		// ������ ���� ���� ���� ���赵(��� ����� public)
		// interface�� ����� ��� public static final�̱� ������ ������ �����ϴ�.
		// interface���� �ִ� �ż���� ��� public abstract�̱� ������ ������ �����ϴ�.
		
		// class�� interface�� ���������� interface�� ���� �˾ƺ���
		// interface �θ�� interface�� �����ϴ�. ( Object�� �ְ� ������ �ƴϴ�!! )
		// interface�� ���� ����� �����ϴ�. ( �߻� �ż���� �浹�ص� ���� ���� )
		// -- ���� ����� ������ ������ �߻� �ż���� ����θ� �ֱ� ������ ���� �߻� �ż��尡 ���� interface�� �־ �������.
		
		// interface ����
		// interface�� �ᱹ���� �̿ϼ� ���赵�̱� ������ �ϼ��� �ؼ� ����ؾ��Ѵ�.
		// ���� ���
		// class Ŭ�����̸� implements �������̽� �̸�{
		//		�������̽��� ���ǵ� �߻� �ż��带 ���~ ����(�ϼ�)�ؾ� �Ѵ�.
		//	}
		// ������ �ż��� �տ��� �� public�� �ٿ�����Ѵ�.
		
		// Q. �ñ��ߴµ� ��Ӱ� ������ ���ÿ� �Ǵ°�? A. �ȴ�! ��� ��� ���� �ϰ� ������ �ؾ��Ѵ�. 
		
		// interface�� ������
		TEST1 t = new interfaceTest2(); // Ŭ������ ������
		T2 t2 = new interfaceTest2(); // �������̽��� ������
		T t3 = new interfaceTest2(); // �������̽��� ������
		interfaceTest2 t4 = new interfaceTest2();
		interfaceTest3 t5 = new interfaceTest3();
		// interfaceTest2�� ����� 5���̴�.
		// T2 Ÿ���� �������� t2�� move �ż���, attack �ż��常 ����� �����ϴ�.
		// T Ÿ�� �������� t3�� move �ż��常 ����� �����ϴ�.
		// TEST Ÿ�� �������� t�� �ν��Ͻ� ���� x,y�� ������ �����ϴ�.
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
	// �Ű����� Ÿ���� �������̽��϶� �ش� �������̽��� ������ Ŭ������ �ν��Ͻ��� ����
	void attack(T2 x);
}

class interfaceTest implements T2{ // ����
	public void move(int x) {
		System.out.println("������!");
	}
	public void attack(T2 x) {
		System.out.println("������!");
	}
}

class interfaceTest3 implements T2{
	public void move(int x) {}
	public void attack(T2 x) {}
}

class interfaceTest2 extends TEST1 implements T2{ // ��Ӱ� ����
	public void move (int x) {
		System.out.println("move move!");
	}
	public void attack(T2 x) {
		System.out.println("attck!");
	}
	
	// T2 �������̽��� ������ Ŭ������ �ν��Ͻ��� ��ȯ
	T2 method() { // �������̽��� �żҵ��� ����Ÿ������ ������ �� �ִ�.
		return new interfaceTest2();
		// return new interfaceTest3();�� �����ϴ�.
		// ��ȯ Ÿ���� T2�������̽��� ������ Ŭ�����̱� �����̴�.
	}
}
