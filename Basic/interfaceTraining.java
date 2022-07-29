
public class interfaceTraining {

	public static void main(String[] args) {
		// �������̽��� ����
		// - �� ���(��ü)���� "����,��ȭ,����"�� ���� �߰� ������ �Ѵ�.
		// - ����� ������ �и���ų �� �ִ�.
		// - ���� �ð��� ������ �� �ִ�.
		// - ���濡 ������ ������ ���谡 �����ϴ�.
		// - ǥ��ȭ�� �����ϴ�.
		// - ���� ������� Ŭ�������� ���踦 �ξ��� �� �ִ�.
		
		// JDK1.8���� �������̽��� ����Ʈ �ż���, static �ż��带 �߰��� �� �ְ� �Ǿ���.
		// default method = �ϼ��� �ż����̴�.
		// �浹�ϸ� ���� �������̵� �ϸ� �ȴ�. (�ذ�å)
		
		Fighter f = new Fighter();
		// getFighter() �ż����� ���� Ÿ�԰� �����ش�.
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
		
		// AŬ������ BŬ������ �������� ������ Ŭ���� ( �������̽� X) - ������ ����
		// AŬ���� - BŬ���� (���� ����)
		A a = new A();
		a.method(new B()); // A�� B�� ��� (����)
		a.method(new C());
		
		// AŬ������ BŬ������ �������� ������ Ŭ���� ( �������̽� O ) - ������ ����
		// AŬ���� - interface - BŬ���� (���� ����)
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

// interface�� �ִ� �߻� �ż���� �⺻������ public abstract�̱� ������ ������ �� �ִ�.
interface Fightable{
	void move (int x, int y);
	void attack (Fightable f);
}

class Fighter extends Unit2 implements Fightable{
	// public�� �ٿ��ִ� ������ �������̵��� �Ҷ� �θ𺸴� ���������ڰ� �������� �ȵǱ� �����̴�.
	public void move(int x, int y) {
		System.out.printf("[%d %d]�� �̵�\n",x,y);
	}
	public void attack(Fightable f) {
		System.out.println(f + "�� ����");
	}
	// interface�� ����Ÿ������ ������ �ش� interface�� ������ Ŭ������ �����ϴ�.
	Fightable getFighter(){
		Fighter f = new Fighter();
		return f;
	}
}

// �������� ������ Ŭ���� ( �������̽� X) - ������ ����
class A{ // ���� �� �߰��ɶ� ���� AŬ������ ����������Ѵ�.
	public void method(B b) {
		b.method();
	}
	public void method(C c) {
		c.method();
	}
}
class B{
	public void method() {
		System.out.println("BŬ������ �ż���");
	}
}
class C {
	public void method() {
		System.out.println("CŬ������ �ż���");
	}
}

// �������� ������ Ŭ���� ( �������̽� O ) - ������ ����
class A2{
	public void methodAll(I i) { // interface I�� ������ Ŭ������ �ü� �ִ�.
		i.methodAll();
	}
}

interface I{ 
	void methodAll(); // ������
}

class B2 implements I{
	public void methodAll() {
		System.out.println("B2Ŭ������ �ż���"); // �˸���
	}
}

class C2 implements I{
	public void methodAll() {
		System.out.println("C2Ŭ������ �ż���"); // �˸���
	}
}