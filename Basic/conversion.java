
public class conversion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str = "3";
		
		System.out.println(str.charAt(0)- '0'); // Type: int Result: 3
		System.out.println('3' - '0' + 1); // Type: int Result: 4
		// char타입 숫자에 char타입 0을 빼면 숫자로 변환된다.
		System.out.println(Integer.parseInt(str) + 1); // Type: int Result: 4
		System.out.println("3" + 1); // Type: String Result: "31"; 
		System.out.println(3 + '0'); // '0'은 숫자로 48
		
		
		// ====================================================
		
		// 1. 문자와 숫자 간의 변환
		// 10  + '0' => '10' 로 변환이 된다.
		// '20' - '0' => 20  로 변환이 된다.
		
		// 2. 문자열로의 변환
		// 30 + "" => "30"  로 변환이 된다.
		// '40' + "" => "40"  로 변환이 된다.
		
		// 3. 문자열을 숫자로 변환
		// "99" => Integer.parseInt("99") ==> 99
		// "3.4" => Double.parseInt("3.4") ==> 3.4
		
		// 4. 문자열을 문자로 변환
		// "95" => "95".charAt(0) ==> '9'
		// "95" => "95".charAt(1) ==> '5'
		
		int s = 10;
		System.out.println(s + "");
		System.out.println((s+"").getClass());
	}

}
