import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FormattingClassTest {

	public static void main(String[] args) {
		// DecimalFormat 예제 1
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
		
		// DecimalFormat 예제 2
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
		
		// SimpleDateFormat 예제 1
		Date today = new Date(); // 현재 시간과 날짜 
		SimpleDateFormat sdf1, sdf2, sdf3, sdf4;
		SimpleDateFormat sdf5, sdf6, sdf7, sdf8, sdf9;
		sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		sdf2 = new SimpleDateFormat("''yy년 MMM dd일 E요일");
		sdf3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		sdf4 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss a");
		
		sdf5 = new SimpleDateFormat("오늘은 올해의 D번재 날입니다.");
		sdf6 = new SimpleDateFormat("오늘은 이달의 d번째 날입니다.");
		sdf7 = new SimpleDateFormat("오늘은 올해의 w번째 주입니다.");
		sdf8 = new SimpleDateFormat("오늘은 이달의 W번째 주입니다.");
		sdf9 = new SimpleDateFormat("오늘은 이달의 F번쨰 E요일입니다.");
		
		System.out.println(sdf1.format(today));
		System.out.println(sdf2.format(today));
		System.out.println(sdf3.format(today));
		System.out.println(sdf4.format(today));
		System.out.println(sdf5.format(today));
		System.out.println(sdf6.format(today));
		System.out.println(sdf7.format(today));
		System.out.println(sdf8.format(today));
		System.out.println(sdf9.format(today));
		
		// SimpleDateFormat 예제 2
		DateFormat df3 = new SimpleDateFormat("yyyy년 MM월 dd일");
		DateFormat df4 = new SimpleDateFormat("yyyy/MM/dd");
		
		try {
			Date d = df3.parse("2019년 11월 23일");
			System.out.println(df4.format(d));
		}catch(Exception e) {}
		
		
	}

}

// 형식화 클래스
// - java.text패키지의 DecimalFormat(10 진수 숫자), SimpleDateFormat(날짜)
// - 숫자와 날짜를 원하는 형식으로 쉽게 출려 가능(숫자, 날짜 -> 형식 문자열)
// - 형식 문자열에서 숫자와 날짜를 뽑아내는 기능 (형식 문자열 -> 숫자, 날짜)
class DecimalFormatTest1{
	double number = 1234567.89;
	DecimalFormat df = new DecimalFormat("#.#E0"); // 지수 표현식
	String result = df.format(number);
	String get() {
		return result; // 1.2E6 >> 1.2 * 10^6
	}
}

// DecimalFormat
// - (10진수)숫자를 형식화할 때 사용 ( 숫자 => 형식 문자열)
// - 특정 형식의 문자열을 숫자로 변환할때도 사용 (형식 문자열 => 숫자)
//class DecimalFormatTest2{
//	DecimalFormat df = new DecimalFormat("#,###.##");
//	Number num = df.parse("1,234,567.89");
//	// Integer.parseInt(), Float.parsefloat() 은 콤마","가 포함된 문자열을 숫자로 변화하지 못한다.
//	void get() {
//		double d = num.doubleValue(); // 1234567.89
//	}
//}


// SimpleDateFormat
// - 날짜와 시간을 다양한 형식으로 출혁 할 수 있게 해준다.
class SimpleDateFormatTest1{
	Date today = new Date();
	SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd"); // 년-월-일 형식
	String result = sf.format(today); //2022-08-08
}
// G = 연대(BC,AD)         = 예: AD
// y = 년도                                       = 예: 2006
// M = 월(1~12 or 1월~12월) = 예: 10 또는 10월, OCT
// w = 년의 몇번째 주(1~53)     = 예: 50
// W = 월의 몇번째 주(1~5)      = 예: 4
// D = 년의 몇번째 일(1~366)    = 예: 100
// d = 월의 몇번째 일(1~31)     = 예: 15
// F = 월의 몇번쨰 요일(1~5)     = 예: 3
// E = 요일                                        = 예: 월

// - 특정 형식으로 되어 있는 문자열에서 날짜와 시간을 뽑아 낼수 도 있다.
//class SimpleDateFormatTest2{
//	DateFormat df1 = new SimpleDateFormat("yyyy년 MM월 dd일");
//	DateFormat df2 = new SimpleDateFormat("yyyy/MM/dd");
//	Date d = df1.parse("2019년 11월 23일"); // 문자열을 Date로 변환
//	String result = df2.format(d);
//}
// a = 오전/오후(AM/PM)
// H = 시간(0~23)
// h = 시간(1~12)
// k = 시간(1~24)
// K = 시간(0~11)
// m = 분(0~59분)
// s = 초(0~59초)
// S = 천분의 일초(0~999)
// z = Time zone(General time zone)
// Z = Time zone(RFC 822 time zone)
// ` = escape 문자(특수 문자를 표현하는 데 사용)

