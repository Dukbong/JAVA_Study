
public class interfaceTraining {

	public static void main(String[] args) {
		Fighter f = new Fighter();
		// getFighter() 매서드으 리턴 타입과 맞춰준다.
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

// interface에 있는 추상 매서드는 기본적으로 public abstract이기 때문에 생략할 수 있다.
interface Fightable{
	void move (int x, int y);
	void attack (Fightable f);
}

class Fighter extends Unit2 implements Fightable{
	// public을 붙여주는 이유는 오버라이딩을 할때 부모보다 접근제어자가 좁아지면 안되기 때문이다.
	public void move(int x, int y) {
		System.out.printf("[%d %d]로 이동\n",x,y);
	}
	public void attack(Fightable f) {
		System.out.println(f + "를 공격");
	}
	// interface가 리턴타입으로 들어오면 해당 interface를 구현한 클래스만 가능하다.
	Fightable getFighter(){
		Fighter f = new Fighter();
		return f;
	}
}