public class StringBufferTEST {

	public static void main(String[] args) {
		
		StringBuffer sb1 = new StringBuffer("abc");
		StringBuffer sb2 = new StringBuffer("abc");
		System.out.println(sb1 == sb2); // �ּҺ� false
		System.out.println(sb1.equals(sb2)); // �ּҺ� false
		
		//  StringBuffer -> String���� ��ȯ �� equals()�� �� ��
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

// Stringó�� ������ �迭(char[])�� ���������� ������ �ִ�.
// - public final class StringBuffer implements java.io.Serializable{
//       private char[] value;
//   }
// - String�� �޸� ������ ������ �� �ִ�.
// - StringBuffer sb = new StringBuffer("abc");
//     - char[] Ÿ������ {'a','b','c'} �����Ȱ� �� �ּҸ� �������� sb�� �����Ѵ�.
// - sb.append("123");
//     - char[] Ÿ���� {'a','b','c','1','2','3'} �̷��� ������ ����ȴ�.
// �迭�� ���� ����Ұ� ������ �����ϸ� ���ο� �迭�� �����ؾ��Ѵ�.
//  1. ���ο� �迭�� �����Ѵ� (�⺻������ ���� �迭�� 2����� �Ѵ�.)
//  2. ���� �迭�� �ִ� ������ �����Ͽ� ���� ���� �迭�� �ٿ��ִ´�.
//  3. ���� �迭�� �ּҸ� ���� ���������� ���� ���� �迭�� �ּҸ� �����Ѵ�.
// StringBuffer�� ������ ���ڿ��� ���̸� ����ؼ� ������ ũ��� �����ؾ��Ѵ�.
// append()�� ������ ������ StringBuffer�� �߰� �� StringBuffer�� ������ ��ȯ
//     - delete() : ����
//     - insert() : ����
// StringBuffer�� equals()�� �������̵� �Ǿ����� �ʴ�. (�׷��Ƿ� �ּҺ�)
//  - String�� �������̵��� �Ǿ� �־ ���� ���Ѵ�.
class StringBufferLENGTH{
	char[] value;
	boolean shared;
	
	public StringBufferLENGTH(int length) {
		value = new char[length];
		shared = false;
	}
	public StringBufferLENGTH() {
		this(16); // StringBuffer�� ũ�⸦ �������� ������ ������ ũ��� 16�� �ȴ�.
	}
	public StringBufferLENGTH(String str) {
		this(str.length() + 16); // ������ ���ڿ��� ���̺��� 16�� �� ũ�� �����Ѵ�.
	}
}