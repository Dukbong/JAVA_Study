import java.util.Arrays;
import java.util.Scanner;

public class ArrayStudy {

	public static void main(String[] args) {
		// 배열 선언과 생성
		int[] arr1; // 타입[] 변수이름 (참조변수)  >> 배열 선언
		arr1 = new int[5]; // 변수이름 = new 타입[길이] >> 배열 생성
		// arr1에는 배열의 첫번째 인덱스 0의 주소가 들어가 있다.
		
		int[] arr2 = new int[5]; // 선언과 생성을 동시에
		arr2[3] = 100;
		
		System.out.println("arr2[0]" + arr2[0]);
		System.out.println("arr2[1]" + arr2[1]);
		System.out.println("arr2[2]" + arr2[2]);
		System.out.println("arr2[3]" + arr2[3]); // 100
		System.out.println("arr2[4]" + arr2[4]);
		
		int value = arr2[3];
		System.out.println("value = " + value);
		
		// 배열의 길이
		int[] arr3 = new int[100]; // 길이가 100인 int타입 배열
		int tmp = arr3.length; // 100;
		// 배열은 한번 생성하면 실행하는 동안 그 길이를 바꿀 수 없다.
		// 왜?? 배열을 생성할때 크기가 맞는 연속적인 메모리 공간을 찾아서 만들기 때문에 늘릴 수 없다. 
		// 부족하다면?? 큰 배열을 다시 생성 후 기존 배열에 있는 값들을 복사한다.
		
		int[] arr4 = new int[5];
		System.out.println("arr4.length= "+ arr4.length);
		
		for(int i = 0; i < arr4.length; i++) {
			System.out.println("arr4[" + i + "]= " + arr4[i]);
		}
		
		// 배열 초기화
		// 배열의 각 요소에 처음으로 값을 지정하는 것
		// 배열은 자동 초기화가 된다. 예: int 타입 배열의 경우 0으로 초기화된다.
		
		int[] arr5 = new int[3]; // 선언 및 생성
		arr5[0]=10; // 초기화
		arr5[1]=20; // 초기화
		arr5[2]=30; // 초기화
		
		int[] arr6 = new int[6]; // 선언 및 생성
		for(int i =0; i < arr6.length; i++) { // 반복문을 통해 초기화
			arr6[i] = i*10+10;
		}
		
		int[] arr7 = new int[] {1,2,3}; // 선언 및 생성, 초기화
		int[] arr8 = {1,2,3,4,5}; // 선언 및 생성, 초기화  >> 이거 쓰면 된다.
		
		// 배열의 출력
		int[] arr9 = {1,2,3,4,5,6};
		
		System.out.println(arr9); // 결과값 : [I@134861
		// int 타입 배열은 변수명으로 출력이 안된다.
		System.out.println(Arrays.toString(arr9)); // 결과값 : [1,2,3,4,5,6]
		
		for(int i = 0; i < arr9.length; i++) {
			System.out.println(arr9[i]); // 배열의 요소를 순서대로 하나씩 출력한다.
		}
	
		char[] charr = {'a','b','c'};
		System.out.println(charr); // 결과값 : abc
		
		System.out.println("================================");
		
		// 실습
		int[]iArr = {1,2,3,4,5,6};
		for(int i = 0; i < iArr.length; i++) {
			System.out.println(iArr[i]); // 요소 하나씩 출력
		}
		System.out.println(Arrays.toString(iArr)); // 문자열로 출력 : "[1,2,3,4,5,6]"
		
		int[]iArr1 = new int[10];
		int[]iArr2 = new int[10];
		int[]iArr3 = {100,95,80,70,60};
		char[]chArr = {'a','b','c','d'};
		
		for(int i = 0; i < iArr1.length; i++) {
			iArr1[i] = i + 1; // 1~10까지 순서대로 배열에 넣어준다.
		}
		
		for (int i = 0; i < iArr2.length; i++) {
			iArr2[i] = (int)(Math.random()*10)+1; // 1~10까지 랜덤하게 배열에 넣어준다.
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
		System.out.println("총점 : " + sum);
		System.out.println("평균 : " + average);
		
		System.out.println("================================");
		
		// 배열 섞기 (shuffle)
		int[] numArr = {0,1,2,3,4,5,6,7,8,9};
		System.out.println(Arrays.toString(numArr));
		
		for(int i = 0; i < 100; i++) {
			int n = (int)(Math.random()*10);
			int tmp2 = numArr[0];
			numArr[0] = numArr[n];
			numArr[n] = tmp2;
		}
		System.out.println(Arrays.toString(numArr));
		
		// 로또 번호 추첨기
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
		
		// String 배열 의 선언과 생성
		String[] name = new String[3]; // 선언 및 생성
		// null로 자동 초기화 된다.
		String[] name2 = {"kim","jang","choi"};
		
		String[] strArr = {"가위", "바위", "보"};
		System.out.println(Arrays.toString(strArr));
		
		for(int i = 0; i < 10; i++) {
			int t = (int)(Math.random()*3);
			System.out.println(strArr[t]);
		}
		
		System.out.println("================================");
		
		// 커맨드 라인을 통해 입력 받기
		// 상단에 있는 Run 클릭 후 Run configurations 클릭 후 Arguments에 입력
		System.out.println("매개변수의 개수 : " + args.length);
		for(int i = 0; i < args.length; i++) {
			System.out.println("args[" + i + "] = \"" + args[i] + "\"");
		}
		
		// cmd창으로 하려면 해당 class 파일이 있는 곳에 간 후 java 파일명 abc 123 "hello world" 하면 알 수 있다.
		
		System.out.println("================================");
		
		// 2차원 배열
		int[][] score2 = new int[4][3]; // 4행 3열의 2차원 배열 선언 및 생성
		// 0 0 0
		// 0 0 0
		// 0 0 0
		// 0 0 0
		
		int[][] score3 = { {10,20,30},{20,20,20} }; // 2행 3열 2차원 배열 선언 및 생성 그리고 초기화
		
		// 2차원 배열 예제
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
		
		// 2차원 배열 예제2
		int[][] score5 = {
				{100,100,100},
				{20,20,20},
				{30,30,30},
				{40,40,40},
				{50,50,50}
		};
		int korTotal = 0, engTotal = 0, mathTotal = 0;
		System.out.println("번호   국어   영어   수학   총점   평균");
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
		System.out.printf("총점 : %3d %4d %4d\n", korTotal, engTotal, mathTotal);
		
		System.out.println("================================");
		
		String[][]words = {
				{"chair", "의자"},
				{"computer", "컴퓨터"},
				{"integer", "정수"}
		};
		Scanner scanner9 = new Scanner(System.in);
		for (int i = 0; i < words.length; i++) {
			System.out.printf("Q%d. %s의 뜻은?", i+1, words[i][0]);
			
			String tmpp = scanner9.nextLine();
			if (tmpp.equals(words[i][1])) {
				System.out.println("정답입니다.\n\n");
			}else {
				System.out.printf("틀렸습니다. 정답은 %s 입니다.\n", words[i][1]);
			}
			
		}
	}

}
