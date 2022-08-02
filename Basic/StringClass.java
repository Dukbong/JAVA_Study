
public class StringClass {

	public static void main(String[] args) {
		StringTEST2 t = new StringTEST2();
		t.StringSum();
		System.out.println(t.a);
		
		StringCompare sc = new StringCompare();
		// == 연산자는 주소를 비교한다.
		System.out.println(sc.str1 == sc.str2); // true 
		System.out.println(sc.str3 == sc.str4); // false
		// equals는 주소를 비교한다.
		// 하지만 String클래스의 경우 자체적으로 equals를 재정의하였기 때문에 주소값이 아닌 내부 값으로 바뀐다.
		System.out.println(sc.str1.equals(sc.str2)); // true
		System.out.println(sc.str3.equals(sc.str4)); // true
		
		// 문자열 리터럴은 프로그램 실행 시 자동으로 생성되며 constant pool(상수 저장소)에 저장된다.
		// 같은 내용의 문자열 리터럴은 단 하나만 만들어진다.
		String s1 = "AAA";
		String s2 = "AAA";
		String s3 = "BBB";
		System.out.println(s1 == s2);
	}

}
// String 클래스 : 문자열을 다루기 위한 클래스
// String 클래스 = 데이터(char[]) + 메서드(문자열 관련)
// STring 클래스는 내용을 변경할 수 없는 불변(immutable) 클래스이다.

class StringTEST2{
	String a = "a";
	String b = "b";
	void StringSum() {
		a = a + b;
	}
	// String 클래스는 불변인데 어떻게 합쳐지는지 알아보자
	// 1. 참조변수 a에는 문자열 리터럴"a"의 주소가 담긴다. (예: 주소 0X100)
	// 2. 참조변수 b에는 문자열 리터럴"b"의 주소가 담긴다. (예: 주소 0X200)
	// 3. 참조변수 a의 값과 참조변수 b의 값을 합치면 "ab"가 되고 이 값은 새로운 주소 (예: 주소0X300)을 갖는다.
	// 4. 다시 참조변수 a에 주소 0X300을 저장한다.
	
	// 문제점 : 문자열의 덧셈 연산은 성능이 떨어진다.
	// 해결방법 : 문자열의 결합이나 변경이 잦다면 내용을 변경 가능한 StringBuffer를 사용하는게 좋다.
}

class StringCompare{
	String str1 = "abc"; // 문자열 리터럴 "abc"의 주소가 str1에 저장된다. (예 : 주소 0X100)
	String str2 = "abc"; // 문자열 리터럴 "abc"의 주소가 str2에 저장된다. (예 : 주소 0X100)
	// str1과 str2가 같은 주소를 갖는다.
	
	String str3 = new String("abc"); // 새로운 String인스턴스를 생성 후 주소를 str3에 저장 (예 : 주소 0X200)
	String str4 = new String("abc"); // 새로운 String인스턴스를 생성 후 주소를 str4에 저장 (예 : 주소 0X300)
	// str3랑 str4는 각자 다른 주소를 갖는다.	
}

// 빈 문자열 ("")
// 내용이 없는 문자열 크기가 0인 char형 배열을 저장하는 문자열
//     - String str = ""; str을 빈 문자열로 초기화
// Java에서는 크기가 0인 배열을 생성하는 것은 어느 타입이나 가능
//     - char[] chArr = new char[0]; // 길이가 0인 char배열
//     - int[] iArr = {}; // 길이가 0인 int배열
// 문자(char)와 문자열(string)의 초기화
//     - String s = ""; // 빈 문자열로 초기화
//     - char c = ' '; // 공백으로 초기화