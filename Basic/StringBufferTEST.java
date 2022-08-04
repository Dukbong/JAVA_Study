public class StringBufferTEST {

	public static void main(String[] args) {
		
		StringBuffer sb1 = new StringBuffer("abc");
		StringBuffer sb2 = new StringBuffer("abc");
		System.out.println(sb1 == sb2); // 주소비교 false
		System.out.println(sb1.equals(sb2)); // 주소비교 false
		
		//  StringBuffer -> String으로 변환 후 equals()로 값 비교
		String s1 = sb1.toString();
		String s2 = sb2.toString();
		System.out.println(s1.equals(s2));
		
		StringBuffer t1 = new StringBuffer("a");
		StringBuffer t2 = t1.append("B");
		StringBuffer t3 = t2.append(10.0f);
		
		System.out.println(t1);
		System.out.println(t2);
		System.out.println(t3);
	}
}

// String처럼 문자형 배열(char[])을 내부적으로 가지고 있다.
// - public final class StringBuffer implements java.io.Serializable{
//       private char[] value;
//   }
// - String과 달리 내용을 변경할 수 있다.
// - StringBuffer sb = new StringBuffer("abc");
//     - char[] 타입으로 {'a','b','c'} 생성된고 이 주소를 참조변수 sb에 저장한다.
// - sb.append("123");
//     - char[] 타읩의 {'a','b','c','1','2','3'} 이렇게 내용이 변경된다.
// 배열의 길이 변경불가 공간이 부족하면 새로운 배열을 생성해야한다.
//  1. 새로운 배열을 생성한다 (기본적으로 이전 배열의 2배수로 한다.)
//  2. 이전 배열에 있는 내용을 복사하여 새로 만든 배열에 붙여넣는다.
//  3. 이전 배열의 주소를 가진 참조변수에 새로 만든 배열의 주소를 저장한다.
// StringBuffer는 저장할 문자열의 길이를 고려해서 적절한 크기로 생성해야한다.
// append()는 지정된 내용을 StringBuffer에 추가 후 StringBuffer의 참조를 반환
//     - delete() : 삭제
//     - insert() : 삽입
// StringBuffer는 equals()가 오버라이딩 되어있지 않다. (그러므로 주소비교)
//  - String은 오버라이딩이 되어 있어서 값을 비교한다.
class StringBufferLENGTH{
	char[] value;
	boolean shared;
	
	public StringBufferLENGTH(int length) {
		value = new char[length];
		shared = false;
	}
	public StringBufferLENGTH() {
		this(16); // StringBuffer의 크기를 지정하지 않으면 버퍼의 크기는 16이 된다.
	}
	public StringBufferLENGTH(String str) {
		this(str.length() + 16); // 지정한 문자열의 길이보다 16이 더 크게 생성한다.
	}
}