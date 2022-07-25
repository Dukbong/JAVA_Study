
// 하나의 소스파일에는 하나의 클래스만 작성하는것이 바람직하다.
public class object_oriented {
// 클래스는 많을 수 있지만 public은 무조건 파일명과 같은 하나만 존재해야한다.
	public static void main(String[] args) {
		Tv t1 = new Tv();
		t1.channel = 7;
		t1.channelDown();
		System.out.println(t1.channel); // 6
		
		Tv t2 = new Tv();
		System.out.println("t2의 channel값은 " + t2.channel + "입니다.");
		
		t2 = t1; // 참조변수 t2의 주소값을 참조변수 t1의 주소 값으로 바꿔준다.
		// 11번에서 만든 객체는 더이상 사용이 불가능하여 GC(쓰레기 처리)가 지워준다.
		System.out.println("t2의 channel값은 " + t2.channel + "입니다.");
		
		//객체의 배열화
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
		
		// 클래스 변수 변경하기
		Card.width = 150; // c1.width이라고도 적을 수 있지만 인스턴스 변화와 헷갈리기 때문에 권장하지 않는다.
		Card.height = 550; // c1.width이라고도 적을 수 있지만 인스턴스 변화와 헷갈리기 때문에 권장하지 않는다.
		
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
		double result4 = mm.divide(5L, 2L); // double이 더 크기 때문에 자동 형변환된다.
		System.out.println("divide(5L,2L) = " + result4);
	}
}

class Tv{ 
	// 클래스 영역
	String color; // 인스턴스 변수 
	boolean power; // 인스턴스 변수
	int channel; // 인스턴스 변수
	static int cv; // 클래스 변수 (static 변수) / 공통속성
	
	// 메서드 영역
	void power() { power = !power; }
	void channelUp() { ++channel; }
	void channelDown() { --channel; }
	void method() {
		int aa = 0; // 지역변수
	}
}

class Card{
	String kind; // 인스턴스 변수
	int number; // 인스턴스 변수
	static int width = 100; // 클래스 변수
	static int height = 250; // 클래스 변수
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