
public class java_standard {

	public static void main(String[] args) {
		// 타입의 크기 비교
		// byte < short, char < int < long < float < double
		
		// 큰타입에 작은타입을 넣으면 자동 형변환이 되지만 반대의 경우 수동으로 형변환 시켜줘야한다.
		long a = 100;
		double b = a;
		System.out.println(b); // Type: double Result: 100.0
		
		// 각각 다른 타입들의 연산에서는 큰 타입으로 바뀌어서 계산된다.
		// int + float = float + float => 결과는 float
		int c = 10;
		double d = 10.0;
		System.out.println(c+d); // Type: double Result: 20.0
		
		// ※ int보다 작은타입의 경우는 int로 변환된다.
		byte e = 10;
		short f = 10;
		System.out.println(e+f); // Type: int Result: 20
		
		// Math.round() 사용해서 반올림 만들기
		// round()는 실수를 소수 첫째자리에서 반올림한 정수를 반환한다.
		long result = Math.round(4.52); // 5
		
		// 소수 세번쨰 자리에서 반올림 하시오
		double pi = 3.141592;
		double Spi = Math.round(pi * 1000) / 1000.0; 
		System.out.println(Spi); // 3.142
		// Math.round( 3.141592 * 1000 ) >> Math.round( 3141.592 ) >> 3142
		// long 3142 / double 1000.0 >> double 3.142
		
		long Spi2 = Math.round(pi * 1000) / 1000;
		System.out.println(Spi2); // 3
		
		System.out.println(pi);
		System.out.println(pi * 1000);
		System.out.println(Math.round(pi * 1000));
		System.out.println(Math.round(pi * 1000) / 1000); // 3
		System.out.println(Math.round(pi * 1000) / 1000.0); // 3.142
		System.out.println((double)Math.round(pi * 1000) / 1000); // 3.142
		System.out.printf("%.3f", pi); // 3.142
		
		//==========================================================
		
		double pi2 = 3.141592;
		
		// 3.141까지만 나타내려면?
		System.out.println(pi2 * 1000); // 3141.592
		System.out.println((int)(pi2 * 1000)); // 3141
		System.out.println((int)(pi2 * 1000) / 1000); // 3
		// int / int >> int (소수점 버림)
		System.out.println((int)(pi2 * 1000) / 1000.0); // 3.141
		
		//==========================================================
		
		// 문자열의 비교
		// 문자열 비교에서는 == 보다는 equals()을 사용하는게 좋다.
		// 만약 대소문자가 상관없다면 equalsIgnoreCase()을 사용하면 된다.
		String aa = "abc";
		String bb = "abc";
		System.out.println(aa == bb); // true
		System.out.println(aa.equals(bb)); // true
		
		String cc = new String("abc");
		String dd = new String("abc");
		System.out.println(cc == dd); // false
		System.out.println(cc.equals(dd)); // true
	}

}
