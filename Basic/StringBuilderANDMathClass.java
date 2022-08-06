
public class StringBuilderANDMathClass {

	public static void main(String[] args) {
		// ���� (Round �� �ϱ�)
		
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
// StringBuilder�� StringBuffer�� ���� �Ȱ����� �Ѱ��� �������� �ִ�.
//  - StringBuffer�� ����ȭ(������ ��ȣ)�Ǿ� �ְ� ��Ƽ �����忡 �����ϴ�.
//     - ������� �̱۾�����(�ѹ��� 1���� �۾�)�� ��Ƽ������(�ѹ��� n���� �۾�)�� �ִ�.
//     - ��Ƽ�������� ������ �����峢�� �����͸� �����ϴµ� �̶� �����Ͱ� ���� �� �ִµ� �̸� �����ϱ� ���ؼ��� ����ȭ�� �۾��ؾ��Ѵ�.
//     - ���ݱ��� �ۼ��ؿ� ���α׷��� ���� �̱� ������� �ۼ��Ǿ���.
//  - StringBuilder�� ����ȭ�Ǿ� ���� �ʴ�.
//  - ��Ƽ������ ���α׷��� �ƴ� ��� ����ȭ�� ���ʿ��� �������ϸ� �����´�.
//     - �̱۾����忡���� StringBuilder�� ����ϴ°� ���ɸ鿡�� ����.
class StringBuilderTest1{
	// StringBuffer�� �����
	StringBuffer sb1 = new StringBuffer();
	void Append1() {
		sb1.append("abc");
	}
	// StringBuilder�� �ٲٱ�
	StringBuilder sb2 = new StringBuilder();
	void Append2() {
		sb2.append("abc");
	}
}

// Math Class
//  - ���а��� static �޼����� ����
//     - round()�� �̿��ؼ� �Ҽ��� �Ʒ� ����° �ڸ����� �ݿø��Ͻÿ�
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

// MathŬ������ �޼���
// static Type abs(Type Value) : �־��� ��(Value)�� ���밪�� ��ȯ�Ѵ�.
//     - Type : double, float, int, long
class MathClassMethod1{
	int i = Math.abs(-10); // 10
	double d = Math.abs(-10.0); // 10
}

// static double ceil(double Value) : �־��� ��(Value)�� (������)�ø��Ͽ� ��ȯ�Ѵ�.
class MathClassMethod2{
	double d1 = Math.ceil(10.1); // 11
	double d2 = Math.ceil(-10.1); // -10
	double d3 = Math.ceil(10.0000015); // 11
}

// static Type max(Type a, Type b) : �־��� �ΰ�(a,b)�� ���ؼ� ū ���� ��ȯ�Ѵ�.
// static Type min(Type a, Type b) : �־��� �ΰ�(a,b)�� ���ؼ� ���� ���� ��ȯ�Ѵ�.
//- Type : double, float, int, long
class MathClassMethod3{
	double d = Math.max(9.5, 9.500001); // 9.500001
	int i = Math.max(0, -1); // 0
	double d2 = Math.min(9.5, 9.50001); // 9.5
	int i2 = Math.min(0, -1); // -1
}

// static double random() : 0.0 <= x < 1.0 �ȿ� �ִ� �Ǽ����� ��ȯ�Ѵ�.
class MathClassMethod4{
	double b = Math.random(); // 0.0 <= b <1.0
	int i = (int)(Math.random()*10)+1; // 1 <= i < 11
}

// static double rint(double a) : �־��� ���� ���� ����� �������� double������ ��ȯ�Ѵ�.
//     - ��, �� ������ ��� �ִ� ��(1.5,2.5,3.5...)�� ¦���� ��ȯ�Ѵ�.
class MathClassMethod5{
	double d1 = Math.rint(1.2); // 1.0
	double d2 = Math.rint(2.6); // 3.0
	double d3 = Math.rint(3.5); // 4.0
	double d4 = Math.rint(4.6); // 5.0
	double d5 = Math.rint(-4.5); // -4.0
}

// static long round(Type a) : �Ҽ��� ù��°�ڸ����� �ݿø��� ������(long)�� ��ȯ�Ѵ�.
class MathClassMethod6{
	long i1 = Math.round(1.2); // 1
	long i2 = Math.round(2.6); // 3
	long i3 = Math.round(3.5); // 4
	long i4 = Math.round(4.5); // 5
	double d1 = 90.7552;
	double d2 = Math.round(d1*100)/100.0; // 90.76
}