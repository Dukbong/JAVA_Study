
public class join_StringJoiner {

	public static void main(String[] args) {
		// ����
		int iVal = 100;
		String strVal = String.valueOf(iVal); // int�� String���� ��ȯ
		// String strVal = iVal + "";
		
		double dVal = 200.0;
		String strVal2 = dVal + "";
		// String strVal2 = String.valueOf(dVal);
		
		// ���ڿ��� ���ڷ� �ٲٴ� ���
		double sum = Integer.parseInt("+" + strVal) + Double.parseDouble(strVal2);
		double sum2 = Integer.valueOf(strVal) + Double.valueOf(strVal2);
		
		System.out.println(String.join("", strVal,"+",strVal2,"=")+sum); // ������ ����.
		System.out.println(strVal + "+" + strVal2 + "=" + sum2); // ������ ���ڴ�.
	}
}

// join()�� static�޼����̸� �������ڿ� ���̿� �����ڸ� �־ �����Ѵ�.
class JoinTest{
	String animals = "dog,cat,bear";
	String[] arr = animals.split(","); // ���ڿ��� ","�� �����ڷ� ������ �迭�� ����
	String str = String.join("-", arr); // �迭�� ���ڿ��� "-"�� �����ؼ� ����
	
	void getResult() {
		System.out.println(str); // dog-cat-bear
	}
}

// ���ڸ� ���ڿ��� �ٲٴ� ���
class Number_String{
	int i = 100;
	String str1 = i+""; // 100�� "100"���� ��ȯ (��)
	String str2 = String.valueOf(i); // 100�� "100"���� ��ȯ (����)
}

// ���ڿ��� ���ڷ� �ٲٴ� ���
class String_Number{
	int i1 = Integer.parseInt("100"); // "100"�� 100���� ��ȯ
	int i2 = Integer.valueOf("100"); // "100"�� 100���� ��ȯ ( ���� ���� ��� )
	// parseInt, parseLong, pareDouble �̷��� �̸��� �ٸ��� valueOf�� ���Ͻ��״�.
	Integer i3 = Integer.valueOf("100"); //"100"�� 100���� ��ȯ
}