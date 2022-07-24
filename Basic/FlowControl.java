import java.util.*;

public class FlowControl {

	public static void main(String[] args) {
		
		// if문
		int score = 0; // 점수 저장
		char grade = ' '; // 학점 저장
		// 공백으로 초기화
		// 초기화 하지 않아도 실행 된다.
		
		System.out.printf("점수를 입력하세요. >");
		Scanner scanner = new Scanner(System.in);
		score = scanner.nextInt();
		
		if(score >= 90) {
			grade = 'A';
		}else if (score >= 80) {
			grade = 'B';
		}else if (score >= 70) {
			grade = 'C';
		}else {
			grade = 'D';
		}
		System.out.println("당신의 점수는 "+ score + "점 학점은 " + grade + "입니다.");
		
		//========================================================
		
		int score2 = 0;
		char grade2 = ' ', opt = ' ';
		System.out.printf("\n점수를 입력하세요. >>");
		Scanner scanner2 = new Scanner(System.in);
		score2 = scanner2.nextInt();
		
		if(score2 >= 90) {
			grade2 = 'A';
			if(score2 >= 98) {
				opt = '+';
			}else if(score2 < 94) {
				opt = '-';
			}
		}else if(score2 >= 80) {
			grade2 = 'B';
			if(score2 >= 88) {
				opt = '+';
			}else if(score2 < 84) {
				opt = '-';
			}
		}else {
			grade2 = 'C';
		}
		System.out.printf("당신의 점수는 %d점 학점은 %c%c 입니다.\n\n",score2,grade2,opt);
		
		// switch문
		// 결과로 정수 또는 문자열만 가능하다.
		Scanner scanner3 = new Scanner(System.in);
		System.out.print("현재 월을 입력하세요. >");
		int month = scanner3.nextInt();
		
		switch(month) {
		case 3:
		case 4:
		case 5:
			System.out.println("현재의 계절은 봄입니다.\n");
			break;
		case 6: case 7: case 8:
			System.out.println("현재의 계절은 여름입니다.\n");
			break;
		case 9: case 10: case 11:
			System.out.println("현재의 계절은 가을입니다.\n");
			break;
		default: // case 12: case 1: case 2:
			System.out.println("현재의 계절은 겨울입니다.\n");
		}
		
		// for문 ( 반복횟수를 알고 있을때 )
		// 기본 구조
		for (int i=1; i <= 3; i++) {
			System.out.println("I Can do it!");
		}
		System.out.print("\n");
		
		// 변수 2개 사용이 가능하다.
		// 하지만 변수들의 타입이 같아야 사용할 수 있다.
		for (int i = 1, j = 5; i <= 5; i++,j--) {
			System.out.println("i = " + i + " j = " + j);
		}
		System.out.print("\n");
		
		int sum = 0;
		for( int i = 1; i <= 5; i++) {
			sum = sum + i;
			System.out.printf("1부터 %2d까지의 합 >> %2d\n",i,sum);
		}
		System.out.print("\n");
		
		// 중첩 for문
		for (int i = 2; i <= 9; i++) {
			for (int j = 1; j <=9; j++) {
				System.out.printf("%d x %d = %d\n",i,j,i*j);
			}
		}
		System.out.print("\n");
		
		// 별찍기
		// 4각형 별찍기
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 10; j++) {
				System.out.printf("*");
			}
			System.out.print("\n");
		}
		System.out.println();
		
		// 왼쪽으로 붙은 삼각형
		for(int i = 0; i < 5; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.printf("*");
			}
			System.out.println();
		}
		System.out.println();
		
		// 피라미드 만들기
		// 1 3 5 7 9
		for(int i = 0; i < 5; i++) {
			for(int j = i; j < 4; j++) {
				System.out.printf(" ");
			}
			for(int k = 0; k < i*2+1; k++) {
				System.out.printf("*");
			}
			System.out.println();
		}
		System.out.println();
		
		// while문 ( 반복횟수를 모를때 )
		int sum2 = 0, ii = 0;
		
		while(sum2 <= 100) { // 조건이 참일때만 실행된다.
			System.out.printf("%d - %d\n", ii, sum2);
			ii++;
			sum2 = sum2 + ii;
			// sum2 += ++ii;
		}
		System.out.println();
		
		// 입력받은 수 각 자리수의 합 구하기
		int num = 0, sum3 = 0;
		System.out.print("숫자를 입력하세요. (예: 123456)");
		Scanner scanner4 = new Scanner(System.in);
		String tmp = scanner4.nextLine();
		num = Integer.parseInt(tmp);
		
		while (num!=0) {
			sum3 = sum3 + num%10;
			System.out.printf("sum = %3d num = %d\n", sum3, num);
			num = num/10;
		}
		System.out.println("각 자리수의 합 >> " + sum3);
		System.out.println();
		
		// break, continue
		int menu = 0, num2 = 0;
		Scanner scanner5 = new Scanner(System.in);
		
		while(true) {
			System.out.println("(1) square");
			System.out.println("(2) square root");
			System.out.println("(3) log");
			System.out.print("원하는 메뉴(1~3)을 선택하세요.(종료: 0)");
			
			String tmp2 = scanner5.nextLine();
			menu = Integer.parseInt(tmp2);
			
			if (menu == 0) {
				System.out.println("프로그램을 종료합니다.");
				System.out.println();
				break;
			}else if (!(1 <= menu && menu <= 3)) {
				System.out.println("메뉴를 잘못 선택하셨습니다. (종료: 0)");
				System.out.println();
				continue;
			}
			System.out.println("선택하신 메뉴는 " + menu + "번 입니다.");
			System.out.println();
		}
		
		// 두개 이상의 for문 한번에 탈출하는 방법
		// 반복문에 이름을 붙여준다.
		Loop1 : for(int i = 2; i < 9; i++) { // Loop1이라는 이름을 주었다.
					for(int j = 1; j < 9; j++) {
						if(j == 5) {
							break Loop1; // Loop1 반복문까지 break 된다.
							// break;
						}
						System.out.println(i + " * " + j + " = " + i*j);
					}
					System.out.println();
		}
		System.out.println();
		
		int menu2 = 0, num3 = 0;
		Scanner scanner6 = new Scanner(System.in);
		
		// 종합적으로 사용해서 계산 프로그램 만들기
		outer : while(true) {
			System.out.println("(1) square");
			System.out.println("(2) square root");
			System.out.println("(3) log");
			System.out.print("원하는 메뉴(1~3)을 선택하세요.(종료: 0)");
			
			String tmp3 = scanner6.nextLine();
			menu2 = Integer.parseInt(tmp3);
			
			if (menu2 == 0) {
				System.out.println("프로그램을 종료합니다.");
				System.out.println();
				break;
			}else if (!(1 <= menu2 && menu2 <= 3)) {
				System.out.println("메뉴를 잘못 선택하셨습니다. (종료: 0)");
				System.out.println();
				continue;
			}
			for (;;) {
				System.out.printf("계산할 값을 입력하세요. (선택지로 돌아가기: 0, 전체종료: 99)");
				tmp3 = scanner6.nextLine();
				num3 = Integer.parseInt(tmp3);
				if(num3 == 0) {
					break;
				}
				if(num3 == 99) {
					System.out.println("프로그램이 종료되었습니다.");
					break outer;
				}
				switch(menu2) {
				case 1:
					System.out.println("result = " + num3*num3);
					break;
				case 2:
					System.out.println("result = " + Math.sqrt(num3));
					break;
				case 3:
					System.out.println("result = " + Math.log(num3));
					break;
				}
			}
		}
		
	}
}
