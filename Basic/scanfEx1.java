import java.util.*; // 1. import문 추가

public class scanfEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.printf("숫자를 입력하세요 : ");
		// 2. Scanner클래스의 객체 생성
		Scanner scanner = new Scanner(System.in); // 화면에서 입력받기
		
//		// 하나씩 입력받는 방법
//		int num = scanner.nextInt();
//		int num2 = scanner.nextInt();
//		System.out.println(num);
//		System.out.println(num2);
		
//		// 라인 단위로 입력받는 방법
//		String input = scanner.nextLine();
//		int num3 = Integer.parseInt(input);
//		System.out.println(num3);
		
		// 응용
		String input2 = scanner.nextLine(); // 한줄씩 입력 받는다.
		String[] result = input2.split(" "); // 띄어쓰기로 잘라서 result배열에 넣는다.
		for (String a: result) { // 배열 요소 하나씩 꺼내서 출력한다.
			System.out.println(a);
		}
		
	}

}
