
public class StringBuilderANDMathClass {

	public static void main(String[] args) {
		// 예제 (Round 비교 하기)
		
		double sum1 = 0;
		double sum2 = 0;
		double sum3 = 0;
		
		for (double d = 0.0; d <= 2; d=d+0.1) {
			double d1 = Math.round(d);
			double d2 = Math.rint(d);
			
			System.out.printf("%4.1f %4.1f %4.1f\n", d, d1, d2);
		}
		
		System.out.println("==================================");
		
		for (double d = 1.5; d <= 10.5; d++) {
			double d1 = Math.round(d);
			double d2 = Math.rint(d);
			
			System.out.printf("%4.1f %4.1f %4.1f\n", d, d1, d2);
			
			sum1 = sum1 + d;
			sum2 = sum2 + d1;
			sum3 = sum3 + d2;
		}
		System.out.println("-------------");
		System.out.printf("%4.1f %4.1f %4.1f\n", sum1, sum2, sum3);
	}
}
// StringBuilder와 StringBuffer는 거의 똑같지만 한가지 차이점이 있다.
//  - StringBuffer는 동기화(데이터 보호)되어 있고 멀티 쓰레드에 안전하다.
//     - 쓰레드는 싱글쓰레드(한번에 1개의 작업)와 멀티쓰레드(한번에 n개의 작업)가 있다.
//     - 멀티쓰레드의 단점은 쓰레드끼리 데이터를 공유하는데 이때 데이터가 꼬일 수 있는데 이를 방지하기 위해서는 동기화로 작업해야한다.
//     - 지금까지 작성해온 프로그램은 전부 싱글 쓰레드로 작성되었다.
//  - StringBuilder는 동기화되어 있지 않다.
//  - 멀티쓰레드 프로그램이 아닌 경우 동기화는 불필요한 성능저하를 가져온다.
//     - 싱글쓰레드에서는 StringBuilder를 사용하는게 성능면에서 좋다.
class StringBuilderTest1{
	// StringBuffer로 만들기
	StringBuffer sb1 = new StringBuffer();
	void Append1() {
		sb1.append("abc");
	}
	// StringBuilder로 바꾸기
	StringBuilder sb2 = new StringBuilder();
	void Append2() {
		sb2.append("abc");
	}
}

// Math Class
//  - 수학관련 static 메서드의 집합
//     - round()를 이용해서 소수점 아래 세번째 자리에서 반올림하시오
class MathRound {
	double i = 90.7552;
	void Round() {
		i = i * 100;
		i = Math.round(i);
		int i2 = (int)Math.round(i);
		System.out.println(i); // 9076.0
		System.out.println(i2);  // 9076
		i = i / 100;
		i2 = i2 / 100;
		System.out.println(i); // 90.76
		System.out.println(i2); // 90
	}
}

// Math클래스의 메서드
// static Type abs(Type Value) : 주어진 값(Value)의 절대값을 반환한다.
//     - Type : double, float, int, long
class MathClassMethod1{
	int i = Math.abs(-10); // 10
	double d = Math.abs(-10.0); // 10
}

// static double ceil(double Value) : 주어진 값(Value)을 (무조건)올림하여 반환한다.
class MathClassMethod2{
	double d1 = Math.ceil(10.1); // 11
	double d2 = Math.ceil(-10.1); // -10
	double d3 = Math.ceil(10.0000015); // 11
}

// static Type max(Type a, Type b) : 주어진 두값(a,b)를 비교해서 큰 값을 반환한다.
// static Type min(Type a, Type b) : 주어진 두값(a,b)를 비교해서 작은 값을 반환한다.
//- Type : double, float, int, long
class MathClassMethod3{
	double d = Math.max(9.5, 9.500001); // 9.500001
	int i = Math.max(0, -1); // 0
	double d2 = Math.min(9.5, 9.50001); // 9.5
	int i2 = Math.min(0, -1); // -1
}

// static double random() : 0.0 <= x < 1.0 안에 있는 실수값을 반환한다.
class MathClassMethod4{
	double b = Math.random(); // 0.0 <= b <1.0
	int i = (int)(Math.random()*10)+1; // 1 <= i < 11
}

// static double rint(double a) : 주어진 값과 가장 가까운 정수값을 double형으로 반환한다.
//     - 단, 두 정수의 가운데 있는 값(1.5,2.5,3.5...)은 짝수를 반환한다.
class MathClassMethod5{
	double d1 = Math.rint(1.2); // 1.0
	double d2 = Math.rint(2.6); // 3.0
	double d3 = Math.rint(3.5); // 4.0
	double d4 = Math.rint(4.6); // 5.0
	double d5 = Math.rint(-4.5); // -4.0
}

// static long round(Type a) : 소수점 첫번째자리에서 반올림한 정수값(long)을 반환한다.
class MathClassMethod6{
	long i1 = Math.round(1.2); // 1
	long i2 = Math.round(2.6); // 3
	long i3 = Math.round(3.5); // 4
	long i4 = Math.round(4.5); // 5
	double d1 = 90.7552;
	double d2 = Math.round(d1*100)/100.0; // 90.76
}