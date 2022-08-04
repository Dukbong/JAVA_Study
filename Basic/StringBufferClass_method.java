
public class StringBufferClass_method {

	public static void main(String[] args) {
		// ����
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
// StringBuffer() : 16���ڸ� ���� �� �ִ� ���۸� ���� StringBuffer �ν��Ͻ��� �����Ѵ�.
class StringBuffer1{
	StringBuffer sb = new StringBuffer(); // ��� : sb = ""
}

// StringBuffer(int length) : ������ ������ ���ڸ� ���� �� �ִ� ���۸� ���� StringBuffer �ν��Ͻ��� �����Ѵ�.
class StringBuffer2{
	StringBuffer sb = new StringBuffer(10); // ��� : sb = ""(�迭 ���� 10)
}

// StringBuffer(String str) : ������ ���ڿ� ��(str)�� ���� StringBuffer �ν��Ͻ��� �����Ѵ�.
class StringBuffer3{
	StringBuffer sb = new StringBuffer("Hi"); // ��� : sb = "Hi"
}

// StringBuffer append(...) : �Ű������� �Էµ� ���� ���ڿ��� ��ȯ�Ͽ� StringBuffer �ν��Ͻ��� �����ϰ� �ִ� ���ڿ��� �ڿ� ��������.
// ...�� �� �� �ִ� Ÿ�� : boolean, char, char[], double, float, int, long, Object, String
// (�߿�) StringBuffer C = A.append(B) > A�� ����Ű�� ��ü�� B�� �߰��ϰ� �� �ּҸ� �������� C�� �����Ѵ�. 
class StringBuffer4{
	StringBuffer sb1 = new StringBuffer("abc");
	void appendTest() {
		StringBuffer sb2 = sb1.append(true);
		sb1.append('d').append(10.0f); // f�� �迭�� ���� �ʴ´�.
		StringBuffer sb3 = sb1.append("ABC").append(123);
		System.out.println(sb1); // abctrue10.0ABC123
		System.out.println(sb2); // abctrue10.0ABC123
		System.out.println(sb3); // abctrue10.0ABC123
	}
}

// int capacity() : StringBuffer �ν��Ͻ��� ����ũ��(�� �迭�� ����)�� �˷��ش�.
// int length() : StringBuffer�� ��� ���ڿ��� ���̸� �˷��ش�.
class StringBuffer5{
	StringBuffer sb = new StringBuffer(100);
	void appendTest() {
		sb.append("abcd");
	}
    int bufferSize = sb.capacity(); // bufferSize = 100
    int stringSize = sb.length(); // stringSize = 4
}

// char charAt(int index) : ������ ��ġ(index)�� �ִ� ���ڸ� ��ȯ�Ѵ�.
class StringBuffer6{
	StringBuffer sb = new StringBuffer("abc");
	char c = sb.charAt(2); // ��� : c = "c"
}

// StringBuffer delete(int start, int end) : ������ġ(start)���� ����ġ(end) ���̿� �ִ� ���ڸ� �����Ѵ�.
// ��, ����ġ(end)�� ���ڴ� ���ܵȴ�.
// start <= x < end
class StringBuffer7{
	StringBuffer sb1 = new StringBuffer("0123546");
	StringBuffer sb2 = sb1.delete(3, 6);
	void get() {
		System.out.println(sb1); // 0126
		System.out.println(sb2); // 0126
	}
}

// StringBuffer deleteCharAt(int index) : ������ ��ġ(index)�� ���ڸ� �����Ѵ�.
class StringBuffer8{
	StringBuffer sb = new StringBuffer("0123456");
	void deleteCharAtTest() {
		sb.deleteCharAt(3);
		System.out.println(sb); // 012456
	}
}

// StringBuffer insert(int pos, ...) : �ι�° �Ű������� ���� ���� ���ڿ��� ��ȯ�Ͽ� ������ ��ġ(pos)�� �߰��Ѵ�.
//...�� �� �� �ִ� Ÿ�� : boolean, char, char[], double, float, int, long, Object, String
class StringBuffer9{
	StringBuffer sb = new StringBuffer("0123456");
	void insertTest() {
		sb.insert(4, "."); // 0123.456
	}
}

// StringBuffer replace(int start, int end, String str) : ������ ����(start~end)�� ���ڵ��� �־��� ���ڿ��� �ٲ۴�.
// ��, end ��ġ�� �ִ� ���ڴ� �������� �ʴ´�.
// start <= x < end
class StringBuffer10{
	StringBuffer sb = new StringBuffer("0123456");
	void replaceTest() {
		sb.replace(3, 6, "AB"); // 012AB6
	}
}

// StringBuffer reverse() : StringBuffer�ν��Ͻ��� ����Ǿ� �ִ� ���ڿ��� ������ �Ųٷ� �����Ѵ�.
class StringBuffer11{
	StringBuffer sb = new StringBuffer("0123456");
	void reverseTest() {
		sb.reverse(); // 6543210
	}
}

// void setCharAt(int index, char ch) : ������ ��ġ�� ���ڸ� �־��� ����(ch)�� �ٲ۴�.
class StringBuffer12{
	StringBuffer sb = new StringBuffer("0123456");
	void setCharAtTest() {
		sb.setCharAt(5, 'o'); // 01234o6
	}
}

// void setLength(int newLength) : ������ ���̷� ���ڿ��� ���̸� �����մϴ�.
// ��, ���̸� �ø��� ��� ������ �� ������ �ι��� '\u0000'�� ä���.
class StringBuffer13{
	StringBuffer sb1 = new StringBuffer("0123456");
	StringBuffer sb2 = new StringBuffer("0123456");
	String str = "";
	void setLengthTest() {
		sb1.setLength(5); // 012345
		sb2.setLength(10); // 0123456nullnullnull
		str = sb2.toString().trim(); // 0123456
		// trim()�� �յڷ� ������� �����ش�.
	}
}

// String toString() : StringBuffer�ν��Ͻ��� ���ڿ��� String���� ��ȯ
class StringBuffer14{
	StringBuffer sb = new StringBuffer("0123456");
	String str = sb.toString();
}

// String substring(int start) : ������ ��ġ (start)���� ���ڿ� ������ ��ȯ
// String substring(int satrt, int end) : ������ ��ġ(start)���� ����ġ(end)�� ���� ���ڿ��� ��ȯ�Ѵ�.
// start <= x < end
class StringBuffer15{
	StringBuffer sb = new StringBuffer("0123456");
	String str1 = sb.substring(3); // 3456
	String str2 = sb.substring(3,5); // 34
}