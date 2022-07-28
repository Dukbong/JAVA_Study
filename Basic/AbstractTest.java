
public class AbstractTest {

	public static void main(String[] args) {
		// 추상 클래스 작성
		// 여러 클래스에 공통적으로 사용될 수 있는 추상클래스를 바로 작성하거나
		// 기존 클래스의 공통 부분을 뽑아서 추상클래스를 만든다.
		
		//========================================================
		Unit[] group = {new Marine(), new Tank(), new Dropship()};
		
		// 위와 아래는 같은 결과를 낸다.
		
		Unit[] group2 = new Unit[3];
		group2[0] = new Marine();
		group2[1] = new Tank();
		group2[2] = new Dropship();
		//========================================================
		
		for (int i = 0; i < group.length; i++) {
			group[i].move(100, 200);
		}
		
		
		// Object 타입의 참조변수로 했을때는 어떻게 될까?
		Object[] group3 = {new Marine(), new Tank(), new Dropship()};
		
		// Object타입에는 move, stop 이런 매서드가 없다!!!!!!!
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