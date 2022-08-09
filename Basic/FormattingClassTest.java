import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FormattingClassTest {

	public static void main(String[] args) {
		// DecimalFormat ���� 1
		double number = 1234567.89;
		String[] pattern = {
				"0",
				"#",
				"0.0",
				"#.#",
				"0000000000.0000",
				"##########.####",
				"#.#-",
				"-#.#",
				"#,###.##",
				"#,####.##",
				"#E0",
				"0E0",
				"##E0",
				"00E0",
				"####E0",
				"#.#E0",
				"0.0E0",
				"0.0000000000E0",
				"00.000000000E0",
				"000.00000000E0",
				"#.##########E0",
				"##.#########E0",
				"#,###.##+;#,###.##-",
				"#.#%",
				"#.#\u2030",
				"\u00A4 #,###",
				"'#'#,###",
				"''#,###",
		};
		for (int i = 0; i < pattern.length; i++) {
			DecimalFormat df = new DecimalFormat(pattern[i]);
			System.out.printf("%19s : %s\n",pattern[i], df.format(number));
		}
		
		// DecimalFormat ���� 2
		DecimalFormat df1 = new DecimalFormat("#,###.##");
		DecimalFormat df2 = new DecimalFormat("#.###E0");
		
		try {
			java.lang.Number num = df1.parse("1,234,567.89");
			System.out.print("1,234,567.89" + " ->");
			double d = num.doubleValue(); // d = 1234567.89
			System.out.print(d + " -> ");
			System.out.println(df2.format(num));
		}catch(Exception e) {}
		
		System.out.println("===================================");
		
		// SimpleDateFormat ���� 1
		Date today = new Date(); // ���� �ð��� ��¥ 
		SimpleDateFormat sdf1, sdf2, sdf3, sdf4;
		SimpleDateFormat sdf5, sdf6, sdf7, sdf8, sdf9;
		sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		sdf2 = new SimpleDateFormat("''yy�� MMM dd�� E����");
		sdf3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		sdf4 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss a");
		
		sdf5 = new SimpleDateFormat("������ ������ D���� ���Դϴ�.");
		sdf6 = new SimpleDateFormat("������ �̴��� d��° ���Դϴ�.");
		sdf7 = new SimpleDateFormat("������ ������ w��° ���Դϴ�.");
		sdf8 = new SimpleDateFormat("������ �̴��� W��° ���Դϴ�.");
		sdf9 = new SimpleDateFormat("������ �̴��� F���� E�����Դϴ�.");
		
		System.out.println(sdf1.format(today));
		System.out.println(sdf2.format(today));
		System.out.println(sdf3.format(today));
		System.out.println(sdf4.format(today));
		System.out.println(sdf5.format(today));
		System.out.println(sdf6.format(today));
		System.out.println(sdf7.format(today));
		System.out.println(sdf8.format(today));
		System.out.println(sdf9.format(today));
		
		// SimpleDateFormat ���� 2
		DateFormat df3 = new SimpleDateFormat("yyyy�� MM�� dd��");
		DateFormat df4 = new SimpleDateFormat("yyyy/MM/dd");
		
		try {
			Date d = df3.parse("2019�� 11�� 23��");
			System.out.println(df4.format(d));
		}catch(Exception e) {}
		
		
	}

}

// ����ȭ Ŭ����
// - java.text��Ű���� DecimalFormat(10 ���� ����), SimpleDateFormat(��¥)
// - ���ڿ� ��¥�� ���ϴ� �������� ���� ��� ����(����, ��¥ -> ���� ���ڿ�)
// - ���� ���ڿ����� ���ڿ� ��¥�� �̾Ƴ��� ��� (���� ���ڿ� -> ����, ��¥)
class DecimalFormatTest1{
	double number = 1234567.89;
	DecimalFormat df = new DecimalFormat("#.#E0"); // ���� ǥ����
	String result = df.format(number);
	String get() {
		return result; // 1.2E6 >> 1.2 * 10^6
	}
}

// DecimalFormat
// - (10����)���ڸ� ����ȭ�� �� ��� ( ���� => ���� ���ڿ�)
// - Ư�� ������ ���ڿ��� ���ڷ� ��ȯ�Ҷ��� ��� (���� ���ڿ� => ����)
//class DecimalFormatTest2{
//	DecimalFormat df = new DecimalFormat("#,###.##");
//	Number num = df.parse("1,234,567.89");
//	// Integer.parseInt(), Float.parsefloat() �� �޸�","�� ���Ե� ���ڿ��� ���ڷ� ��ȭ���� ���Ѵ�.
//	void get() {
//		double d = num.doubleValue(); // 1234567.89
//	}
//}


// SimpleDateFormat
// - ��¥�� �ð��� �پ��� �������� ���� �� �� �ְ� ���ش�.
class SimpleDateFormatTest1{
	Date today = new Date();
	SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd"); // ��-��-�� ����
	String result = sf.format(today); //2022-08-08
}
// G = ����(BC,AD)         = ��: AD
// y = �⵵                                       = ��: 2006
// M = ��(1~12 or 1��~12��) = ��: 10 �Ǵ� 10��, OCT
// w = ���� ���° ��(1~53)     = ��: 50
// W = ���� ���° ��(1~5)      = ��: 4
// D = ���� ���° ��(1~366)    = ��: 100
// d = ���� ���° ��(1~31)     = ��: 15
// F = ���� ����� ����(1~5)     = ��: 3
// E = ����                                        = ��: ��

// - Ư�� �������� �Ǿ� �ִ� ���ڿ����� ��¥�� �ð��� �̾� ���� �� �ִ�.
//class SimpleDateFormatTest2{
//	DateFormat df1 = new SimpleDateFormat("yyyy�� MM�� dd��");
//	DateFormat df2 = new SimpleDateFormat("yyyy/MM/dd");
//	Date d = df1.parse("2019�� 11�� 23��"); // ���ڿ��� Date�� ��ȯ
//	String result = df2.format(d);
//}
// a = ����/����(AM/PM)
// H = �ð�(0~23)
// h = �ð�(1~12)
// k = �ð�(1~24)
// K = �ð�(0~11)
// m = ��(0~59��)
// s = ��(0~59��)
// S = õ���� ����(0~999)
// z = Time zone(General time zone)
// Z = Time zone(RFC 822 time zone)
// ` = escape ����(Ư�� ���ڸ� ǥ���ϴ� �� ���)

