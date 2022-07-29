
public class InnerClass {
	
	class InstanceInner{
		int iv = 100;
		// static int cv = 100; >> Error �ν��Ͻ� Ŭ���������� static ����� ���� �� �� ����.
		final static int CONST = 100; // final static�� ����̱� ������ ���� �� �ִ�.
	}
	static class  Staticinner{
		int iv = 200;
		static int cv = 200; // static Ŭ���������� static ����� ������ �� �ִ�.
	}
	void myMethod() {
		final int Lv = 0;
		class Localinner{
			int iv = 300;
			int iiv = Lv;
			// static int cv = 10; >> Error ���� Ŭ���������� static ����� ������ �� ����.
			final static int CONST =300; // final static�� ����̱� ������ ���� �� �ִ�.
		}
	}

	public static void main(String[] args) {
		// Ŭ���� ���� Ŭ����
		// ���� Ŭ�������� �ܺ� Ŭ������ ������� ��ü���� ���� ���ٰ���
		// �ڵ��� ���⼺�� ���� �� �ִ�. (ĸ��ȭ)
		
		// ���� Ŭ������ ������ ������ �Ȱ��� �ν��Ͻ�  ����Ŭ����, static ����Ŭ����, ���� ����Ŭ���� �� ������.
		// >> �߰� ���� �͸� Ŭ������ �ִ�.(Ŭ������ ����� ��ü�� ������ ���ÿ� �ϴ� �̸����� Ŭ���� 1ȸ��)
		// ��ȿ ���� ���� ������ ����.
		
		// ���� Ŭ������ ���� �����ڴ� 4�� ��� �ȴ�! (���� ���� Ŭ������...)
		// <����> �ܺ� Ŭ������ ���������� 2�� ���� (default, public)
		
		// ���� Ŭ������ �ܺ� Ŭ������ private ����� ���ٰ����ϴ�.
		// ���� ����Ŭ������ ���ΰ� �ִ� �ż����� ����� ����� �����ϴ�.
		
		// ==============����===============
		// �Ϲ����� Ŭ����
		BBB b = new BBB();
		b.method();

		// ���� Ŭ����
		AAA2 a = new AAA2();
		a.b.method();
		// ==============����===============
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

// ============�� �Ʒ� �ڵ�� ���� �ڵ��̴�.=================

class AAA2{ // AAA2�� BBB2�� �ܺ� Ŭ����
	int i = 100;
	BBB b = new BBB();
	class BBB2{ // BBB2�� AAA2�� ���� Ŭ����
		void method() {
			System.out.println(i);
		}
	}
}

// ===============================================
