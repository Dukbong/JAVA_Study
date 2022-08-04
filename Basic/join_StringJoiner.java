
public class join_StringJoiner {

	public static void main(String[] args) {
		// 예제
		int iVal = 100;
		String strVal = String.valueOf(iVal); // int를 String으로 변환
		// String strVal = iVal + "";
		
		double dVal = 200.0;
		String strVal2 = dVal + "";
		// String strVal2 = String.valueOf(dVal);
		
		// 문자열을 숫자로 바꾸는 방법
		double sum = Integer.parseInt("+" + strVal) + Double.parseDouble(strVal2);
		double sum2 = Integer.valueOf(strVal) + Double.valueOf(strVal2);
		
		System.out.println(String.join("", strVal,"+",strVal2,"=")+sum); // 성능이 좋다.
		System.out.println(strVal + "+" + strVal2 + "=" + sum2); // 성능이 나쁘다.
	}
}

// join()은 static메서드이며 여러문자열 사이에 구분자를 넣어서 결합한다.
class JoinTest{
	String animals = "dog,cat,bear";
	String[] arr = animals.split(","); // 문자열을 ","를 구분자로 나눠서 배열에 저장
	String str = String.join("-", arr); // 배열의 문자열을 "-"로 구분해서 결합
	
	void getResult() {
		System.out.println(str); // dog-cat-bear
	}
}

// 숫자를 문자열로 바꾸는 방법
class Number_String{
	int i = 100;
	String str1 = i+""; // 100을 "100"으로 변환 (편리)
	String str2 = String.valueOf(i); // 100을 "100"으로 변환 (빠름)
}

// 문자열을 숫자로 바꾸는 방법
class String_Number{
	int i1 = Integer.parseInt("100"); // "100"을 100으로 변환
	int i2 = Integer.valueOf("100"); // "100"을 100으로 변환 ( 가장 좋은 방법 )
	// parseInt, parseLong, pareDouble 이렇게 이름이 다른걸 valueOf로 통일시켰다.
	Integer i3 = Integer.valueOf("100"); //"100"을 100으로 변환
}