
public class conversion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str = "3";
		
		System.out.println(str.charAt(0)- '0'); // Type: int Result: 3
		System.out.println('3' - '0' + 1); // Type: int Result: 4
		// charŸ�� ���ڿ� charŸ�� 0�� ���� ���ڷ� ��ȯ�ȴ�.
		System.out.println(Integer.parseInt(str) + 1); // Type: int Result: 4
		System.out.println("3" + 1); // Type: String Result: "31"; 
		System.out.println(3 + '0'); // '0'�� ���ڷ� 48
		
		
		// ====================================================
		
		// 1. ���ڿ� ���� ���� ��ȯ
		// 10  + '0' => '10' �� ��ȯ�� �ȴ�.
		// '2' - '0' => 2  �� ��ȯ�� �ȴ�.
		// 		>> �̰� �Ǵ� ������ �����ڵ�� ��ȯ�Ǳ� �����̴�.
		//		>> '2' = �����ڵ�� int 50 | '0' = �����ڵ�� int 48
		//		>> 50-48 = int 2
		
		// 2. ���ڿ����� ��ȯ
		// 30 + "" => "30"  �� ��ȯ�� �ȴ�.
		// '40' + "" => "40"  �� ��ȯ�� �ȴ�.
		
		// 3. ���ڿ��� ���ڷ� ��ȯ
		// "99" => Integer.parseInt("99") ==> 99
		// "3.4" => Double.parseInt("3.4") ==> 3.4
		
		// 4. ���ڿ��� ���ڷ� ��ȯ
		// "95" => "95".charAt(0) ==> '9'
		// "95" => "95".charAt(1) ==> '5'
		
		int s = 10;
		System.out.println(s + "");
		System.out.println((s+"").getClass());
	}

}
