
public class StringBufferClass_method {

	public static void main(String[] args) {
		// 예제
		StringBuffer sb1 = new StringBuffer("01");
		StringBuffer sb2 = sb1.append(23);
		sb1.append('4').append(56);
		
		StringBuffer sb3 = sb1.append(78);
		sb3.append(9.0);
		
		System.out.println("sb1 = " + sb1); // 0123456789.0
		System.out.println("sb2 = " + sb2); // 0123456789.0
		System.out.println("sb3 = " + sb3); // 0123456789.0
		
		System.out.println("sb1 = " + sb1.deleteCharAt(10)); // 01234567890
		System.out.println("sb1 = " + sb1.delete(3, 6)); //01267890
		System.out.println("sb1 = " + sb1.insert(3, "abc")); // 012abc67890
		System.out.println("sb1 = " + sb1.replace(6, sb1.length(),"END")); //012abcEND
		System.out.println("capacity = " + sb1.capacity()); // 18
		System.out.println("length = " + sb1.length()); // 9
		

	}

}
// StringBuffer() : 16문자를 담을 수 있는 버퍼를 가진 StringBuffer 인스턴스를 생성한다.
class StringBuffer1{
	StringBuffer sb = new StringBuffer(); // 결과 : sb = ""
}

// StringBuffer(int length) : 지정된 개수의 문자를 담을 수 있는 버퍼를 가진 StringBuffer 인스턴스를 생성한다.
class StringBuffer2{
	StringBuffer sb = new StringBuffer(10); // 결과 : sb = ""(배열 길이 10)
}

// StringBuffer(String str) : 지정된 문자열 값(str)을 갖는 StringBuffer 인스턴스를 생성한다.
class StringBuffer3{
	StringBuffer sb = new StringBuffer("Hi"); // 결과 : sb = "Hi"
}

// StringBuffer append(...) : 매개변수로 입력된 값을 문자열로 변환하여 StringBuffer 인스턴스가 저장하고 있는 문자열의 뒤에 덧붙힌다.
// ...에 들어갈 수 있는 타입 : boolean, char, char[], double, float, int, long, Object, String
// (중요) StringBuffer C = A.append(B) > A가 가르키는 객체에 B를 추가하고 그 주소를 참조변수 C에 대입한다. 
class StringBuffer4{
	StringBuffer sb1 = new StringBuffer("abc");
	void appendTest() {
		StringBuffer sb2 = sb1.append(true);
		sb1.append('d').append(10.0f); // f는 배열에 들어가지 않는다.
		StringBuffer sb3 = sb1.append("ABC").append(123);
		System.out.println(sb1); // abctrue10.0ABC123
		System.out.println(sb2); // abctrue10.0ABC123
		System.out.println(sb3); // abctrue10.0ABC123
	}
}

// int capacity() : StringBuffer 인스턴스의 버퍼크기(총 배열의 길이)를 알려준다.
// int length() : StringBuffer에 담긴 문자열의 길이를 알려준다.
class StringBuffer5{
	StringBuffer sb = new StringBuffer(100);
	void appendTest() {
		sb.append("abcd");
	}
    int bufferSize = sb.capacity(); // bufferSize = 100
    int stringSize = sb.length(); // stringSize = 4
}

// char charAt(int index) : 지정된 위치(index)에 있는 문자를 반환한다.
class StringBuffer6{
	StringBuffer sb = new StringBuffer("abc");
	char c = sb.charAt(2); // 결과 : c = "c"
}

// StringBuffer delete(int start, int end) : 시작위치(start)부터 끝위치(end) 사이에 있는 문자를 제거한다.
// 단, 끝위치(end)의 문자는 제외된다.
// start <= x < end
class StringBuffer7{
	StringBuffer sb1 = new StringBuffer("0123546");
	StringBuffer sb2 = sb1.delete(3, 6);
	void get() {
		System.out.println(sb1); // 0126
		System.out.println(sb2); // 0126
	}
}

// StringBuffer deleteCharAt(int index) : 지정된 위치(index)의 문자를 제거한다.
class StringBuffer8{
	StringBuffer sb = new StringBuffer("0123456");
	void deleteCharAtTest() {
		sb.deleteCharAt(3);
		System.out.println(sb); // 012456
	}
}

// StringBuffer insert(int pos, ...) : 두번째 매개변수로 받은 값을 문자열로 변환하여 지정된 위치(pos)에 추가한다.
//...에 들어갈 수 있는 타입 : boolean, char, char[], double, float, int, long, Object, String
class StringBuffer9{
	StringBuffer sb = new StringBuffer("0123456");
	void insertTest() {
		sb.insert(4, "."); // 0123.456
	}
}

// StringBuffer replace(int start, int end, String str) : 지정된 범위(start~end)의 문자들을 주어진 문자열로 바꾼다.
// 단, end 위치에 있는 문자는 포함하지 않는다.
// start <= x < end
class StringBuffer10{
	StringBuffer sb = new StringBuffer("0123456");
	void replaceTest() {
		sb.replace(3, 6, "AB"); // 012AB6
	}
}

// StringBuffer reverse() : StringBuffer인스턴스에 저장되어 있는 문자열의 순서를 거꾸로 나열한다.
class StringBuffer11{
	StringBuffer sb = new StringBuffer("0123456");
	void reverseTest() {
		sb.reverse(); // 6543210
	}
}

// void setCharAt(int index, char ch) : 지정된 위치의 문자를 주어진 문자(ch)로 바꾼다.
class StringBuffer12{
	StringBuffer sb = new StringBuffer("0123456");
	void setCharAtTest() {
		sb.setCharAt(5, 'o'); // 01234o6
	}
}

// void setLength(int newLength) : 지정된 길이로 문자열의 길이를 변경합니다.
// 단, 길이를 늘리는 경우 나머지 빈 공간을 널문자 '\u0000'로 채운다.
class StringBuffer13{
	StringBuffer sb1 = new StringBuffer("0123456");
	StringBuffer sb2 = new StringBuffer("0123456");
	String str = "";
	void setLengthTest() {
		sb1.setLength(5); // 012345
		sb2.setLength(10); // 0123456nullnullnull
		str = sb2.toString().trim(); // 0123456
		// trim()은 앞뒤로 빈공간을 없애준다.
	}
}

// String toString() : StringBuffer인스턴스의 문자열을 String으로 반환
class StringBuffer14{
	StringBuffer sb = new StringBuffer("0123456");
	String str = sb.toString();
}

// String substring(int start) : 지정된 위치 (start)부터 문자열 끝까지 반환
// String substring(int satrt, int end) : 지정된 위치(start)부터 끝위치(end)전 까지 문자열로 반환한다.
// start <= x < end
class StringBuffer15{
	StringBuffer sb = new StringBuffer("0123456");
	String str1 = sb.substring(3); // 3456
	String str2 = sb.substring(3,5); // 34
}