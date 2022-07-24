
public class java_standard {

	public static void main(String[] args) {
		// Ÿ���� ũ�� ��
		// byte < short, char < int < long < float < double
		
		// ūŸ�Կ� ����Ÿ���� ������ �ڵ� ����ȯ�� ������ �ݴ��� ��� �������� ����ȯ ��������Ѵ�.
		long a = 100;
		double b = a;
		System.out.println(b); // Type: double Result: 100.0
		
		// ���� �ٸ� Ÿ�Ե��� ���꿡���� ū Ÿ������ �ٲ� ���ȴ�.
		// int + float = float + float => ����� float
		int c = 10;
		double d = 10.0;
		System.out.println(c+d); // Type: double Result: 20.0
		
		// �� int���� ����Ÿ���� ���� int�� ��ȯ�ȴ�.
		byte e = 10;
		short f = 10;
		System.out.println(e+f); // Type: int Result: 20
		
		// Math.round() ����ؼ� �ݿø� �����
		// round()�� �Ǽ��� �Ҽ� ù°�ڸ����� �ݿø��� ������ ��ȯ�Ѵ�.
		long result = Math.round(4.52); // 5
		
		// �Ҽ� ������ �ڸ����� �ݿø� �Ͻÿ�
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
		
		// 3.141������ ��Ÿ������?
		System.out.println(pi2 * 1000); // 3141.592
		System.out.println((int)(pi2 * 1000)); // 3141
		System.out.println((int)(pi2 * 1000) / 1000); // 3
		// int / int >> int (�Ҽ��� ����)
		System.out.println((int)(pi2 * 1000) / 1000.0); // 3.141
		
		//==========================================================
		
		// ���ڿ��� ��
		// ���ڿ� �񱳿����� == ���ٴ� equals()�� ����ϴ°� ����.
		// ���� ��ҹ��ڰ� ������ٸ� equalsIgnoreCase()�� ����ϸ� �ȴ�.
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
