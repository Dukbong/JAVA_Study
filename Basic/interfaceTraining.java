
public class interfaceTraining {

	public static void main(String[] args) {
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