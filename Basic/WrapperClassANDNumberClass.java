import java.util.ArrayList;

public class WrapperClassANDNumberClass {

	public static void main(String[] args) {
		// 레퍼 클래스 예제
		Integer i1 = new Integer(100);
		Integer i2 = new Integer(100);
		
		System.out.println("i1 = i2 ?" + (i1 == i2)); // 주소값 비교 : false
		System.out.println("i1.equals(i2) ?" + i1.equals(i2)); // 값 비교 : true
		// String과 마찬가지로 Integer도 내부적으로 값을 비교하게끔 오버라이딩 되어있다.
		System.out.println("i1.comparTo(i2) = " + i1.compareTo(i2)); // 정렬에 사용된다.
		// i1 == i2  >> 0
		// i1 > i2 >> 1
		// i1 < i2 >> -1
		System.out.println("i1.toString() = " + i1.toString()); // "100"
		System.out.println("MAX_VALUE = " + Integer.MAX_VALUE); // Integer의 최대 숫자
		System.out.println("MIN_VALUE = " + Integer.MIN_VALUE); // Integer의 최소 숫자
		System.out.println("SIZE = " + Integer.SIZE + "bits"); // 32
		System.out.println("BYTES = " + Integer.BYTES  + "bytes"); // 4
		System.out.println("TYPE = " + Integer.TYPE); // int
		
		System.out.println("===================");
		NstringtoNumber n = new NstringtoNumber();
		System.out.println(n.i);
		System.out.println(n.i1);
		System.out.println(n.i2);
		System.out.println(n.i3);
		System.out.println(n.i4);
	}
}
// 래퍼클래스란 ? 8개의 기본형을 객체로 다뤄야할때 사용하는 클래스
//     - 기본형 값을 감싸는 클래스
// public final class Integer(래퍼클래스) extends Number implement Comparable{
//     private int value;(기본형 값)
// }

// 기본형          ->   래퍼클래스         ->   생성자                                                   -> 활용예시
// boolean ->   Boolean   ->   Boolean(boolean value)   -> Boolean b1 = new Boolean(true);
//                             Boolean(String s)        -> Boolean b2 = new Boolean("true");
// char    ->   Character ->   Character(char value)    -> Character c = new Character('a');
// byte    ->   Byte      ->   Byte(byte value)         -> Byte b1 = new Byte(10);
//                             Byte(String s)           -> Byte b2 = new Byte("10");
// short   ->   Short     ->   Short(short value)       -> Short s1 = new Short(10);
//                             Short(String s)          -> Short s2 = new Short("10");
// int     ->   Integer   ->   Integer(int value)       -> Integer i1 = new Integer(100);
//                             Integer(String s)        -> Integer i2 = new Integer("100");
// long    ->   Long      ->   Long(long value)         -> Long l1 = new Long(100);
//                             Long(String s)           -> Long l2 = new Long("100");
// float   ->   Float     ->   Float(float value)       -> Float f1 = new Float(1.0f);
//                             Float(double value)      -> Float f2 = new Float(1.0);
//                             Float(String s)          -> Float f3 = new Float("1.0f");
// double  ->   Double    ->   Double(double value)     -> Double d1 = new Double(1.0);
//                             Double(String s)         -> Double d2 = new DOuble("1.0");

// Number 클래스
//  - 모든 숫자 래퍼 클래스의 조상
// 클래스 계층도
// Object   Boolean
//          Character
//          Number     Byte
//                     Short
//                     Integer
//                     Long (10^19) 만약 10^19를 넘어서는 정수를 쓰려면 Biginteger를 사용
//                     Float
//                     Double (10^308 / 정밀도 15자리) 만약 10^308을 넘어서는 실수 혹은 15자리 이상의 정밀도를 사용하려면 BigDecimal을 사용
//                     Biginteger (아주 큰 정수)
//                     BIgDecimal (아주 큰 실수)
//  - Integer을 int로 변형시키는 방법
//     - Integer a = new Integer(10);
//       a.intValue(); // Integer에서 int으로 변경됨

// ===================================================

// 문자열을 숫자로 변환하기
class StringtoNumber {
	//문자열 -> 기본형
	byte b = Byte.parseByte("100");
	byte b2 = Byte.valueOf("100");
	short s = Short.parseShort("100");
	short s2 = Short.valueOf("100");
	int i = Integer.parseInt("100");
	int i2 = Integer.valueOf("100");
	long l = Long.parseLong("100");
	long l2 = Long.valueOf("100");
	float f = Float.parseFloat("100");
	float f2 = Float.valueOf("100");
	double d = Double.parseDouble("100");
	double d2 = Double.valueOf("100");
	
	//문자열 -> 레퍼 클래스
	Byte b3 = Byte.valueOf("100");
	Byte b4 = new Byte("100"); // 이렇게 생성자로 만들어도 된다.
	String str = b4.toString(); // 래퍼 클래스 값을 다시 문자열로 바꾸기
	Short s3 = Short.valueOf("100");
	Integer s4 = Integer.valueOf("100");
	Long l4 = Long.valueOf("100");
	Float f4 = Float.valueOf("100");
	Double d4 = Double.valueOf("100");
}

// n진법의 문자열을 숫자로 변환하는 방법
class NstringtoNumber{
	int i = Integer.parseInt("100");
	int i1 = Integer.parseInt("100",2); // 100(2) -> 4
	int i2 = Integer.parseInt("100",8); // 100(8) -> 64
	int i3 = Integer.parseInt("100",16); // 100(16) -> 256
	int i4 = Integer.parseInt("FF",16); // FF(16) -> 255
	// int i5 = Integer.parseInt("FF"); >> NumberFormatException 발생
	// 디폴드값이 10이기 떄문에 10진수중에 FF는 없다.
}

//===================================================

// 오토박스이 & 언박싱
// 기본형의 값을 객체로 자동변환하는것을 오토박싱, 그 반대가 언박싱
// 이 기능 덕분에 래퍼클래스와 기본형을 구분하지 않고 사용할 수 있게 되었다.
// int => Integer : 오토박싱 (자동으로 변환된다)
// int <= Integer : 언박싱 (자동으로 변환된다)
class boxing{
	int i = 5;
	Integer iObj = new Integer(7);
	
	int sum = i + iObj/*.intValue() 컴파일 하면 자동으로 생성된다.*/;
	// 언박싱이며, Integer에서 int(기본형)으로 변환
}

class Ex{
	ArrayList<Integer> list = new ArrayList<Integer>();
	void ADD() {
		list.add(new Integer(100)); // list에는 객체만 추가가능
		list.add(200); // JDK1.5부터 가능
		// 컴파일 하면 컴파일이 자동으로 new Integer(200)으로 변경해준다.
		
		Integer i1 = list.get(0); // list에 저장된 첫번째 객체를 꺼낸다.
		int i2 = list.get(0).intValue(); // intValue()로 Integer을 int로 변환
		int i3 = list.get(0); // 위에 2과정에 컴파일 시 자동으로 추가해준다.
	}
}

class Ex_2{
	int i = 10;
	// 기본형을 참조형으로 형변환
	Integer intg = (Integer)i; // Integer intg = Integer.valueOf(i);
	Object obj = (Object)i; // Object obj = (Object)Integer.valueOf(i);
	
	Long lng = 100L; // Long lng = new Long(100L);
	
	int i2 = intg + 10; // 참조형과 기본형의 연산 가능
	long l = intg + lng; // 참조형 간의 연산
			
	Integer intg2 = new Integer(20);
	int i3 = (int)intg2; // 참조형을 기본형으로 형변환도 가능
}
// 컴파일 전                                                            컴파일 후
// Integer intg = (Integer)i; -> Integer intg = Integer.valuOf(i);
// Object obj = (Object)i;    -> Object obj = (Object)Integer.valueOf(i);
// Long lng = 100L;           -> Long lng = new Long(100L);

