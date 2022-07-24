import java.util.Arrays;
import java.util.Scanner;

public class ArrayStudy {

	public static void main(String[] args) {
		// �迭 ����� ����
		int[] arr1; // Ÿ��[] �����̸� (��������)  >> �迭 ����
		arr1 = new int[5]; // �����̸� = new Ÿ��[����] >> �迭 ����
		// arr1���� �迭�� ù��° �ε��� 0�� �ּҰ� �� �ִ�.
		
		int[] arr2 = new int[5]; // ����� ������ ���ÿ�
		arr2[3] = 100;
		
		System.out.println("arr2[0]" + arr2[0]);
		System.out.println("arr2[1]" + arr2[1]);
		System.out.println("arr2[2]" + arr2[2]);
		System.out.println("arr2[3]" + arr2[3]); // 100
		System.out.println("arr2[4]" + arr2[4]);
		
		int value = arr2[3];
		System.out.println("value = " + value);
		
		// �迭�� ����
		int[] arr3 = new int[100]; // ���̰� 100�� intŸ�� �迭
		int tmp = arr3.length; // 100;
		// �迭�� �ѹ� �����ϸ� �����ϴ� ���� �� ���̸� �ٲ� �� ����.
		// ��?? �迭�� �����Ҷ� ũ�Ⱑ �´� �������� �޸� ������ ã�Ƽ� ����� ������ �ø� �� ����. 
		// �����ϴٸ�?? ū �迭�� �ٽ� ���� �� ���� �迭�� �ִ� ������ �����Ѵ�.
		
		int[] arr4 = new int[5];
		System.out.println("arr4.length= "+ arr4.length);
		
		for(int i = 0; i < arr4.length; i++) {
			System.out.println("arr4[" + i + "]= " + arr4[i]);
		}
		
		// �迭 �ʱ�ȭ
		// �迭�� �� ��ҿ� ó������ ���� �����ϴ� ��
		// �迭�� �ڵ� �ʱ�ȭ�� �ȴ�. ��: int Ÿ�� �迭�� ��� 0���� �ʱ�ȭ�ȴ�.
		
		int[] arr5 = new int[3]; // ���� �� ����
		arr5[0]=10; // �ʱ�ȭ
		arr5[1]=20; // �ʱ�ȭ
		arr5[2]=30; // �ʱ�ȭ
		
		int[] arr6 = new int[6]; // ���� �� ����
		for(int i =0; i < arr6.length; i++) { // �ݺ����� ���� �ʱ�ȭ
			arr6[i] = i*10+10;
		}
		
		int[] arr7 = new int[] {1,2,3}; // ���� �� ����, �ʱ�ȭ
		int[] arr8 = {1,2,3,4,5}; // ���� �� ����, �ʱ�ȭ  >> �̰� ���� �ȴ�.
		
		// �迭�� ���
		int[] arr9 = {1,2,3,4,5,6};
		
		System.out.println(arr9); // ����� : [I@134861
		// int Ÿ�� �迭�� ���������� ����� �ȵȴ�.
		System.out.println(Arrays.toString(arr9)); // ����� : [1,2,3,4,5,6]
		
		for(int i = 0; i < arr9.length; i++) {
			System.out.println(arr9[i]); // �迭�� ��Ҹ� ������� �ϳ��� ����Ѵ�.
		}
	
		char[] charr = {'a','b','c'};
		System.out.println(charr); // ����� : abc
		
		System.out.println("================================");
		
		// �ǽ�
		int[]iArr = {1,2,3,4,5,6};
		for(int i = 0; i < iArr.length; i++) {
			System.out.println(iArr[i]); // ��� �ϳ��� ���
		}
		System.out.println(Arrays.toString(iArr)); // ���ڿ��� ��� : "[1,2,3,4,5,6]"
		
		int[]iArr1 = new int[10];
		int[]iArr2 = new int[10];
		int[]iArr3 = {100,95,80,70,60};
		char[]chArr = {'a','b','c','d'};
		
		for(int i = 0; i < iArr1.length; i++) {
			iArr1[i] = i + 1; // 1~10���� ������� �迭�� �־��ش�.
		}
		
		for (int i = 0; i < iArr2.length; i++) {
			iArr2[i] = (int)(Math.random()*10)+1; // 1~10���� �����ϰ� �迭�� �־��ش�.
		}
		
		for (int i = 0; i < iArr1.length; i++) {
			System.out.print(iArr1[i]+ ",");
		}
		System.out.println();
		
		System.out.println(Arrays.toString(iArr2));
		System.out.println(Arrays.toString(iArr3));
		System.out.println(Arrays.toString(chArr));
		System.out.println(iArr3);
		System.out.println(chArr);
		
		System.out.println("================================");
		
		int sum = 0;
		double average = 0;
		
		int[] score = {100,88,100,100,90};
		
		for (int i = 0; i < score.length; i++) {
			sum = sum + score[i];
		}
		average = (double)sum / score.length;
		System.out.println("���� : " + sum);
		System.out.println("��� : " + average);
		
		System.out.println("================================");
		
		// �迭 ���� (shuffle)
		int[] numArr = {0,1,2,3,4,5,6,7,8,9};
		System.out.println(Arrays.toString(numArr));
		
		for(int i = 0; i < 100; i++) {
			int n = (int)(Math.random()*10);
			int tmp2 = numArr[0];
			numArr[0] = numArr[n];
			numArr[n] = tmp2;
		}
		System.out.println(Arrays.toString(numArr));
		
		// �ζ� ��ȣ ��÷��
		int[] ball = new int[45];
		
		for (int i = 0; i < ball.length; i++) {
			ball[i] = i + 1;
		}
		int tmp3 = 0;
		int j = 0;
		
		for (int i = 0; i < 6; i ++) {
			j = (int)(Math.random()*45);
			tmp3 = ball[i];
			ball[i] = ball[j];
			ball[j] = tmp3;
			System.out.println("ball["+i+"] = "+ ball[i]);
		}
		
		// String �迭 �� ����� ����
		String[] name = new String[3]; // ���� �� ����
		// null�� �ڵ� �ʱ�ȭ �ȴ�.
		String[] name2 = {"kim","jang","choi"};
		
		String[] strArr = {"����", "����", "��"};
		System.out.println(Arrays.toString(strArr));
		
		for(int i = 0; i < 10; i++) {
			int t = (int)(Math.random()*3);
			System.out.println(strArr[t]);
		}
		
		System.out.println("================================");
		
		// Ŀ�ǵ� ������ ���� �Է� �ޱ�
		// ��ܿ� �ִ� Run Ŭ�� �� Run configurations Ŭ�� �� Arguments�� �Է�
		System.out.println("�Ű������� ���� : " + args.length);
		for(int i = 0; i < args.length; i++) {
			System.out.println("args[" + i + "] = \"" + args[i] + "\"");
		}
		
		// cmdâ���� �Ϸ��� �ش� class ������ �ִ� ���� �� �� java ���ϸ� abc 123 "hello world" �ϸ� �� �� �ִ�.
		
		System.out.println("================================");
		
		// 2���� �迭
		int[][] score2 = new int[4][3]; // 4�� 3���� 2���� �迭 ���� �� ����
		// 0 0 0
		// 0 0 0
		// 0 0 0
		// 0 0 0
		
		int[][] score3 = { {10,20,30},{20,20,20} }; // 2�� 3�� 2���� �迭 ���� �� ���� �׸��� �ʱ�ȭ
		
		// 2���� �迭 ����
		int[][] score4 = {
				{100,100,100},
				{20,20,20},
				{30,30,30},
				{40,40,40},
		};
		int ssum = 0;
		
		for (int i = 0; i < score4.length; i++) {
			for (int k = 0; k <score4[i].length; k++) {
				System.out.printf("socre4[%d][%d] = %d\n",i,k,score4[i][k]);
				
				ssum = ssum + score4[i][k];
			}
		}
		System.out.println("sum = " + ssum);
		
		// 2���� �迭 ����2
		int[][] score5 = {
				{100,100,100},
				{20,20,20},
				{30,30,30},
				{40,40,40},
				{50,50,50}
		};
		int korTotal = 0, engTotal = 0, mathTotal = 0;
		System.out.println("��ȣ   ����   ����   ����   ����   ���");
		System.out.println("=======================");
		for(int i = 0; i < score.length; i++) {
			int summ = 0;
			double avg = 0;
			
			korTotal = korTotal + score5[i][0];
			engTotal = engTotal + score5[i][1];
			mathTotal = mathTotal + score5[i][2];
			System.out.printf("%3d", i+1);
			
			for (int k = 0; k < score5[i].length; k++) {
				summ = summ + score5[i][k];
				System.out.printf("%5d", score5[i][k]);
			}
			avg = (double) sum / score5[i].length;
			System.out.printf("%5d %5.1f\n", summ, avg);
		}
		System.out.println("=======================");
		System.out.printf("���� : %3d %4d %4d\n", korTotal, engTotal, mathTotal);
		
		System.out.println("================================");
		
		String[][]words = {
				{"chair", "����"},
				{"computer", "��ǻ��"},
				{"integer", "����"}
		};
		Scanner scanner9 = new Scanner(System.in);
		for (int i = 0; i < words.length; i++) {
			System.out.printf("Q%d. %s�� ����?", i+1, words[i][0]);
			
			String tmpp = scanner9.nextLine();
			if (tmpp.equals(words[i][1])) {
				System.out.println("�����Դϴ�.\n\n");
			}else {
				System.out.printf("Ʋ�Ƚ��ϴ�. ������ %s �Դϴ�.\n", words[i][1]);
			}
			
		}
	}

}
