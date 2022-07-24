import java.util.*;

public class FlowControl {

	public static void main(String[] args) {
		
		// if��
		int score = 0; // ���� ����
		char grade = ' '; // ���� ����
		// �������� �ʱ�ȭ
		// �ʱ�ȭ ���� �ʾƵ� ���� �ȴ�.
		
		System.out.printf("������ �Է��ϼ���. >");
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
		System.out.println("����� ������ "+ score + "�� ������ " + grade + "�Դϴ�.");
		
		//========================================================
		
		int score2 = 0;
		char grade2 = ' ', opt = ' ';
		System.out.printf("\n������ �Է��ϼ���. >>");
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
		System.out.printf("����� ������ %d�� ������ %c%c �Դϴ�.\n\n",score2,grade2,opt);
		
		// switch��
		// ����� ���� �Ǵ� ���ڿ��� �����ϴ�.
		Scanner scanner3 = new Scanner(System.in);
		System.out.print("���� ���� �Է��ϼ���. >");
		int month = scanner3.nextInt();
		
		switch(month) {
		case 3:
		case 4:
		case 5:
			System.out.println("������ ������ ���Դϴ�.\n");
			break;
		case 6: case 7: case 8:
			System.out.println("������ ������ �����Դϴ�.\n");
			break;
		case 9: case 10: case 11:
			System.out.println("������ ������ �����Դϴ�.\n");
			break;
		default: // case 12: case 1: case 2:
			System.out.println("������ ������ �ܿ��Դϴ�.\n");
		}
		
		// for�� ( �ݺ�Ƚ���� �˰� ������ )
		// �⺻ ����
		for (int i=1; i <= 3; i++) {
			System.out.println("I Can do it!");
		}
		System.out.print("\n");
		
		// ���� 2�� ����� �����ϴ�.
		// ������ �������� Ÿ���� ���ƾ� ����� �� �ִ�.
		for (int i = 1, j = 5; i <= 5; i++,j--) {
			System.out.println("i = " + i + " j = " + j);
		}
		System.out.print("\n");
		
		int sum = 0;
		for( int i = 1; i <= 5; i++) {
			sum = sum + i;
			System.out.printf("1���� %2d������ �� >> %2d\n",i,sum);
		}
		System.out.print("\n");
		
		// ��ø for��
		for (int i = 2; i <= 9; i++) {
			for (int j = 1; j <=9; j++) {
				System.out.printf("%d x %d = %d\n",i,j,i*j);
			}
		}
		System.out.print("\n");
		
		// �����
		// 4���� �����
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 10; j++) {
				System.out.printf("*");
			}
			System.out.print("\n");
		}
		System.out.println();
		
		// �������� ���� �ﰢ��
		for(int i = 0; i < 5; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.printf("*");
			}
			System.out.println();
		}
		System.out.println();
		
		// �Ƕ�̵� �����
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
		
		// while�� ( �ݺ�Ƚ���� �𸦶� )
		int sum2 = 0, ii = 0;
		
		while(sum2 <= 100) { // ������ ���϶��� ����ȴ�.
			System.out.printf("%d - %d\n", ii, sum2);
			ii++;
			sum2 = sum2 + ii;
			// sum2 += ++ii;
		}
		System.out.println();
		
		// �Է¹��� �� �� �ڸ����� �� ���ϱ�
		int num = 0, sum3 = 0;
		System.out.print("���ڸ� �Է��ϼ���. (��: 123456)");
		Scanner scanner4 = new Scanner(System.in);
		String tmp = scanner4.nextLine();
		num = Integer.parseInt(tmp);
		
		while (num!=0) {
			sum3 = sum3 + num%10;
			System.out.printf("sum = %3d num = %d\n", sum3, num);
			num = num/10;
		}
		System.out.println("�� �ڸ����� �� >> " + sum3);
		System.out.println();
		
		// break, continue
		int menu = 0, num2 = 0;
		Scanner scanner5 = new Scanner(System.in);
		
		while(true) {
			System.out.println("(1) square");
			System.out.println("(2) square root");
			System.out.println("(3) log");
			System.out.print("���ϴ� �޴�(1~3)�� �����ϼ���.(����: 0)");
			
			String tmp2 = scanner5.nextLine();
			menu = Integer.parseInt(tmp2);
			
			if (menu == 0) {
				System.out.println("���α׷��� �����մϴ�.");
				System.out.println();
				break;
			}else if (!(1 <= menu && menu <= 3)) {
				System.out.println("�޴��� �߸� �����ϼ̽��ϴ�. (����: 0)");
				System.out.println();
				continue;
			}
			System.out.println("�����Ͻ� �޴��� " + menu + "�� �Դϴ�.");
			System.out.println();
		}
		
		// �ΰ� �̻��� for�� �ѹ��� Ż���ϴ� ���
		// �ݺ����� �̸��� �ٿ��ش�.
		Loop1 : for(int i = 2; i < 9; i++) { // Loop1�̶�� �̸��� �־���.
					for(int j = 1; j < 9; j++) {
						if(j == 5) {
							break Loop1; // Loop1 �ݺ������� break �ȴ�.
							// break;
						}
						System.out.println(i + " * " + j + " = " + i*j);
					}
					System.out.println();
		}
		System.out.println();
		
		int menu2 = 0, num3 = 0;
		Scanner scanner6 = new Scanner(System.in);
		
		// ���������� ����ؼ� ��� ���α׷� �����
		outer : while(true) {
			System.out.println("(1) square");
			System.out.println("(2) square root");
			System.out.println("(3) log");
			System.out.print("���ϴ� �޴�(1~3)�� �����ϼ���.(����: 0)");
			
			String tmp3 = scanner6.nextLine();
			menu2 = Integer.parseInt(tmp3);
			
			if (menu2 == 0) {
				System.out.println("���α׷��� �����մϴ�.");
				System.out.println();
				break;
			}else if (!(1 <= menu2 && menu2 <= 3)) {
				System.out.println("�޴��� �߸� �����ϼ̽��ϴ�. (����: 0)");
				System.out.println();
				continue;
			}
			for (;;) {
				System.out.printf("����� ���� �Է��ϼ���. (�������� ���ư���: 0, ��ü����: 99)");
				tmp3 = scanner6.nextLine();
				num3 = Integer.parseInt(tmp3);
				if(num3 == 0) {
					break;
				}
				if(num3 == 99) {
					System.out.println("���α׷��� ����Ǿ����ϴ�.");
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
