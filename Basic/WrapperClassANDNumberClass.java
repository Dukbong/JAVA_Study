import java.util.ArrayList;

public class WrapperClassANDNumberClass {

	public static void main(String[] args) {
		// ���� Ŭ���� ����
		Integer i1 = new Integer(100);
		Integer i2 = new Integer(100);
		
		System.out.println("i1 = i2 ?" + (i1 == i2)); // �ּҰ� �� : false
		System.out.println("i1.equals(i2) ?" + i1.equals(i2)); // �� �� : true
		// String�� ���������� Integer�� ���������� ���� ���ϰԲ� �������̵� �Ǿ��ִ�.
		System.out.println("i1.comparTo(i2) = " + i1.compareTo(i2)); // ���Ŀ� ���ȴ�.
		// i1 == i2  >> 0
		// i1 > i2 >> 1
		// i1 < i2 >> -1
		System.out.println("i1.toString() = " + i1.toString()); // "100"
		System.out.println("MAX_VALUE = " + Integer.MAX_VALUE); // Integer�� �ִ� ����
		System.out.println("MIN_VALUE = " + Integer.MIN_VALUE); // Integer�� �ּ� ����
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
// ����Ŭ������ ? 8���� �⺻���� ��ü�� �ٷ���Ҷ� ����ϴ� Ŭ����
//     - �⺻�� ���� ���δ� Ŭ����
// public final class Integer(����Ŭ����) extends Number implement Comparable{
//     private int value;(�⺻�� ��)
// }

// �⺻��          ->   ����Ŭ����         ->   ������                                                   -> Ȱ�뿹��
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

// Number Ŭ����
//  - ��� ���� ���� Ŭ������ ����
// Ŭ���� ������
// Object   Boolean
//          Character
//          Number     Byte
//                     Short
//                     Integer
//                     Long (10^19) ���� 10^19�� �Ѿ�� ������ ������ Biginteger�� ���
//                     Float
//                     Double (10^308 / ���е� 15�ڸ�) ���� 10^308�� �Ѿ�� �Ǽ� Ȥ�� 15�ڸ� �̻��� ���е��� ����Ϸ��� BigDecimal�� ���
//                     Biginteger (���� ū ����)
//                     BIgDecimal (���� ū �Ǽ�)
//  - Integer�� int�� ������Ű�� ���
//     - Integer a = new Integer(10);
//       a.intValue(); // Integer���� int���� �����

// ===================================================

// ���ڿ��� ���ڷ� ��ȯ�ϱ�
class StringtoNumber {
	//���ڿ� -> �⺻��
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
	
	//���ڿ� -> ���� Ŭ����
	Byte b3 = Byte.valueOf("100");
	Byte b4 = new Byte("100"); // �̷��� �����ڷ� ���� �ȴ�.
	String str = b4.toString(); // ���� Ŭ���� ���� �ٽ� ���ڿ��� �ٲٱ�
	Short s3 = Short.valueOf("100");
	Integer s4 = Integer.valueOf("100");
	Long l4 = Long.valueOf("100");
	Float f4 = Float.valueOf("100");
	Double d4 = Double.valueOf("100");
}

// n������ ���ڿ��� ���ڷ� ��ȯ�ϴ� ���
class NstringtoNumber{
	int i = Integer.parseInt("100");
	int i1 = Integer.parseInt("100",2); // 100(2) -> 4
	int i2 = Integer.parseInt("100",8); // 100(8) -> 64
	int i3 = Integer.parseInt("100",16); // 100(16) -> 256
	int i4 = Integer.parseInt("FF",16); // FF(16) -> 255
	// int i5 = Integer.parseInt("FF"); >> NumberFormatException �߻�
	// �����尪�� 10�̱� ������ 10�����߿� FF�� ����.
}

//===================================================

// ����ڽ��� & ��ڽ�
// �⺻���� ���� ��ü�� �ڵ���ȯ�ϴ°��� ����ڽ�, �� �ݴ밡 ��ڽ�
// �� ��� ���п� ����Ŭ������ �⺻���� �������� �ʰ� ����� �� �ְ� �Ǿ���.
// int => Integer : ����ڽ� (�ڵ����� ��ȯ�ȴ�)
// int <= Integer : ��ڽ� (�ڵ����� ��ȯ�ȴ�)
class boxing{
	int i = 5;
	Integer iObj = new Integer(7);
	
	int sum = i + iObj/*.intValue() ������ �ϸ� �ڵ����� �����ȴ�.*/;
	// ��ڽ��̸�, Integer���� int(�⺻��)���� ��ȯ
}

class Ex{
	ArrayList<Integer> list = new ArrayList<Integer>();
	void ADD() {
		list.add(new Integer(100)); // list���� ��ü�� �߰�����
		list.add(200); // JDK1.5���� ����
		// ������ �ϸ� �������� �ڵ����� new Integer(200)���� �������ش�.
		
		Integer i1 = list.get(0); // list�� ����� ù��° ��ü�� ������.
		int i2 = list.get(0).intValue(); // intValue()�� Integer�� int�� ��ȯ
		int i3 = list.get(0); // ���� 2������ ������ �� �ڵ����� �߰����ش�.
	}
}

class Ex_2{
	int i = 10;
	// �⺻���� ���������� ����ȯ
	Integer intg = (Integer)i; // Integer intg = Integer.valueOf(i);
	Object obj = (Object)i; // Object obj = (Object)Integer.valueOf(i);
	
	Long lng = 100L; // Long lng = new Long(100L);
	
	int i2 = intg + 10; // �������� �⺻���� ���� ����
	long l = intg + lng; // ������ ���� ����
			
	Integer intg2 = new Integer(20);
	int i3 = (int)intg2; // �������� �⺻������ ����ȯ�� ����
}
// ������ ��                                                            ������ ��
// Integer intg = (Integer)i; -> Integer intg = Integer.valuOf(i);
// Object obj = (Object)i;    -> Object obj = (Object)Integer.valueOf(i);
// Long lng = 100L;           -> Long lng = new Long(100L);

