
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
		System.out.printf("해당 차량의 색상은 %s 기어는 %s 문의 개수는 %d\n",car1.color, car1.gearType, car1.door);
		System.out.printf("해당 차량의 색상은 %s 기어는 %s 문의 개수는 %d\n",car2.color, car2.gearType, car2.door);
		System.out.printf("해당 차량의 색상은 %s 기어는 %s 문의 개수는 %d\n",car3.color, car3.gearType, car3.door);
		
		//============================================================

		
		
		//============================================================

		
	}
	static void change(int x) { // 기본형 매개변수 (참조변수 d의 x값을 읽기만 가능하다.)
		x = 10000;
		System.out.println("c change() x = " + x);
	}
	
	//============================================================
	
	static void change2(Data c) { // 참조형 매개변수 (참조변수 c의 주소값 사용이 가능하다.)
		c.x = 10000;
		System.out.println("c change2() x = " + c.x);
	}
	
	//============================================================
	
	static Data copy(Data d) { // 반환타입이 참조형일 경우는 객체의 주소를 반환한다.
		Data tmp = new Data();
		tmp.x = d.x;
		return tmp; // 위에서 작업한 객체의 주소를 반환한다.
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
}

//============================================================

class Card{
	String kind; // 인스턴스 변수
	int number; // 인스턴스 변수
	static int width = 100; // 클래스 변수
	static int height = 250; // 클래스 변수
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

class Data_1{ // 생성자가 없으면 컴파일 과정에서 Data_1(){} 생성자를 추가해준다.
	int value;
}

class Data_2{ 
	int value;
	
	Data_2(){} // 기본생성자
	Data_2(int x){ // 매개 변수가 있는 생성자
		value = x;
	}
}

//============================================================

class Car2{
	String color;
	String gearType;
	int door;
	
	// this 생성자는 무조건 첫 줄에서만 사용 가능하다.
	Car2(){ // 기본 생성자
		this("white", "auto", 4); // 디폴드 값
		// this 생성자는 매개변수 있는 생성자를 호출한다.
		// 매개변수 없는 생성자는 인스턴스 변수를 디폴드값으로 만들어 줄 수 있다.
	}
	Car2(String color){ // 기본생성자
		this(color, "auto", 4); 
		// this 생성자는 매개변수 있는 생성자를 가르킨다.
	}
	// 매개변수 있는 생성자
	Car2(String color, String gearType, int door){
		this.color = color;
		this.gearType = gearType;
		this.door = door;
	}
}

//============================================================

class InitTest{
	static int cv = 1; // 명시적 초기화 (간다)
	int iv = 1; // 명시적 초기화 (간단)
	
	static { // static 초기화 블록 (복잡)
		cv = 2;
	}
	
	// 생성자
	InitTest(){ // 인스턴스 초기화 블록 (복잡) 
		iv = 2;
	}
}
/*
  초기화 순서
 1. static 변수 cv = 0으로 자동 초기화
 2. static 변수 cv = 1로 명시적 초기화
 3. static 변수 cv = 2로 static 초기화 블록사용
 4. 인스턴스     변수 iv = 0으로 자동 초기화
 5. 인스턴스     변수 iv = 1로 명시적 초기화
 6. 인스턴스     변수 iv = 2로 인스턴스 초기화 블록사용(생성자)
 
 static 변수의 처음 로딩될 때 단 한번만 초기화된다.
 인스턴스 변수의 경우 인스턴스가 생성될 때 마다 초기화된다.
*/

//============================================================



//============================================================



//============================================================
