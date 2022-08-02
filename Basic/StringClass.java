
public class StringClass {

	public static void main(String[] args) {
		StringTEST2 t = new StringTEST2();
		t.StringSum();
		System.out.println(t.a);
		
		StringCompare sc = new StringCompare();
		// == �����ڴ� �ּҸ� ���Ѵ�.
		System.out.println(sc.str1 == sc.str2); // true 
		System.out.println(sc.str3 == sc.str4); // false
		// equals�� �ּҸ� ���Ѵ�.
		// ������ StringŬ������ ��� ��ü������ equals�� �������Ͽ��� ������ �ּҰ��� �ƴ� ���� ������ �ٲ��.
		System.out.println(sc.str1.equals(sc.str2)); // true
		System.out.println(sc.str3.equals(sc.str4)); // true
		
		// ���ڿ� ���ͷ��� ���α׷� ���� �� �ڵ����� �����Ǹ� constant pool(��� �����)�� ����ȴ�.
		// ���� ������ ���ڿ� ���ͷ��� �� �ϳ��� ���������.
		String s1 = "AAA";
		String s2 = "AAA";
		String s3 = "BBB";
		System.out.println(s1 == s2);
	}

}
// String Ŭ���� : ���ڿ��� �ٷ�� ���� Ŭ����
// String Ŭ���� = ������(char[]) + �޼���(���ڿ� ����)
// STring Ŭ������ ������ ������ �� ���� �Һ�(immutable) Ŭ�����̴�.

class StringTEST2{
	String a = "a";
	String b = "b";
	void StringSum() {
		a = a + b;
	}
	// String Ŭ������ �Һ��ε� ��� ���������� �˾ƺ���
	// 1. �������� a���� ���ڿ� ���ͷ�"a"�� �ּҰ� ����. (��: �ּ� 0X100)
	// 2. �������� b���� ���ڿ� ���ͷ�"b"�� �ּҰ� ����. (��: �ּ� 0X200)
	// 3. �������� a�� ���� �������� b�� ���� ��ġ�� "ab"�� �ǰ� �� ���� ���ο� �ּ� (��: �ּ�0X300)�� ���´�.
	// 4. �ٽ� �������� a�� �ּ� 0X300�� �����Ѵ�.
	
	// ������ : ���ڿ��� ���� ������ ������ ��������.
	// �ذ��� : ���ڿ��� �����̳� ������ ��ٸ� ������ ���� ������ StringBuffer�� ����ϴ°� ����.
}

class StringCompare{
	String str1 = "abc"; // ���ڿ� ���ͷ� "abc"�� �ּҰ� str1�� ����ȴ�. (�� : �ּ� 0X100)
	String str2 = "abc"; // ���ڿ� ���ͷ� "abc"�� �ּҰ� str2�� ����ȴ�. (�� : �ּ� 0X100)
	// str1�� str2�� ���� �ּҸ� ���´�.
	
	String str3 = new String("abc"); // ���ο� String�ν��Ͻ��� ���� �� �ּҸ� str3�� ���� (�� : �ּ� 0X200)
	String str4 = new String("abc"); // ���ο� String�ν��Ͻ��� ���� �� �ּҸ� str4�� ���� (�� : �ּ� 0X300)
	// str3�� str4�� ���� �ٸ� �ּҸ� ���´�.	
}

// �� ���ڿ� ("")
// ������ ���� ���ڿ� ũ�Ⱑ 0�� char�� �迭�� �����ϴ� ���ڿ�
//     - String str = ""; str�� �� ���ڿ��� �ʱ�ȭ
// Java������ ũ�Ⱑ 0�� �迭�� �����ϴ� ���� ��� Ÿ���̳� ����
//     - char[] chArr = new char[0]; // ���̰� 0�� char�迭
//     - int[] iArr = {}; // ���̰� 0�� int�迭
// ����(char)�� ���ڿ�(string)�� �ʱ�ȭ
//     - String s = ""; // �� ���ڿ��� �ʱ�ȭ
//     - char c = ' '; // �������� �ʱ�ȭ