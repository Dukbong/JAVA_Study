
public class AbstractTest {

	public static void main(String[] args) {
		// �߻� Ŭ���� �ۼ�
		// ���� Ŭ������ ���������� ���� �� �ִ� �߻�Ŭ������ �ٷ� �ۼ��ϰų�
		// ���� Ŭ������ ���� �κ��� �̾Ƽ� �߻�Ŭ������ �����.
		
		//========================================================
		Unit[] group = {new Marine(), new Tank(), new Dropship()};
		
		// ���� �Ʒ��� ���� ����� ����.
		
		Unit[] group2 = new Unit[3];
		group2[0] = new Marine();
		group2[1] = new Tank();
		group2[2] = new Dropship();
		//========================================================
		
		for (int i = 0; i < group.length; i++) {
			group[i].move(100, 200);
		}
		
		
		// Object Ÿ���� ���������� �������� ��� �ɱ�?
		Object[] group3 = {new Marine(), new Tank(), new Dropship()};
		
		// ObjectŸ�Կ��� move, stop �̷� �ż��尡 ����!!!!!!!
//		for (int i = 0; i < group3.length; i++) {  Error code
//			group3[i].move(100, 200);
//		}
		

	}

}

abstract class Unit{
	int x,y;
	abstract void move(int x, int y);
	void stop() {
		
	}
}

class Marine extends Unit{
	void move(int x, int y) {
		System.out.printf("Marine [x = %d, y = %d\n",x,y);
	}
	void stimPack() {
		
	}
}

class Tank extends Unit{
	void move(int x, int y) {
		System.out.printf("Tank [x = %d, y = %d]\n",x,y);
	}
	void changeMode() {
		
	}
}

class Dropship extends Unit{
	void move (int x, int y) {
		System.out.printf("Dropship [x = %d, y = %d]\n",x,y);
	}
}