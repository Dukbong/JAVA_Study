
public class println_VS_printf {

	public static void main(String[] args) {
		
		System.out.println(10/3); // 3
		// 위에 식은 정수 / 정수이기 때문에 결과값도 정수로 나온다.
		System.out.println(10.0/3); // 3.3333...
		System.out.println(10/3.0); // 3.3333...
		System.out.println(10.0/3.0); // 3.3333...
		// 이렇게 한쪽이나 양쪽 모두 실수로 바꿔주면 결과 값도 실수로 나온다.
		
		// println의 단점 : 실수의 자리수 조절이 불가능하다.
		
		System.out.printf("%.2f\n",10.0/3); //3.3326
		
		//====================================================
		
		System.out.println(0X1A); // 26
		
		// println의 단점  : 무조건 10준수로만 출력 된다.
		
		System.out.printf("%X\n", 15); // (16진수) f
		System.out.printf("%d\n", 15); // (10진수)15
		System.out.printf("%o\n", 15); // (8진수) 17
		System.out.printf("%s\n", Integer.toBinaryString(15)); // (2진수) 1111
		
		// 만약 8진수, 16진수 결과에 접두사를 붙이고 싶을때는?
		System.out.printf("%#o\n", 15); // 017 (8진수)
		System.out.printf("%#X\n", 15); // 0Xf (16진수);
		
		//====================================================
		
		/*
		  printf()의 지시자
		  - %b >> boolean
		  - %d >> int(10진수)
		  - %o >> 8진수
		  - %x, %X >> 16진수
		  - %f >> 부동 소수점
		  - %e, %E >> 지수 표현
		  - %c >> 문자 출력
		  - %s >> 문자열 출력
		 */ 
		
		// printf의 담점 : 줄바꿈이 되지 않기 때문에 별도로 \n을 해주어야한다.
		
		System.out.printf("[%5d] \n", 10); // [   10] 오른쪽 정렬
		System.out.printf("[%-5d] \n", 10); // [10   ] 왼쪽 정렬
		System.out.printf("[%05d] \n", 10); // [00010] 빈공간 0으로 채워라
		System.out.printf("[%5d] \n", 123456789); // [123456789]
		
		System.out.printf("[%s] \n", "www.naver.com"); // [www.naver.com];	
		System.out.printf("[%20s] \n", "www.naver.com"); // [       www.naver.com];	
		System.out.printf("[%-20s] \n", "www.naver.com"); // [www.naver.com       ];
		System.out.printf("[%.4s] \n", "www.naver.com"); // [www.]
		

	}

}
