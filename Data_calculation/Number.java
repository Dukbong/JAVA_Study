public class Number {
	public static void main(String[] args) {
    	// Operator
        System.out.println(1 + 1); // 2
        System.out.println(2 - 1); // 1
        System.out.println(2 * 2); // 4
        System.out.println(4 / 3); // 1 몫만 나온다.
        System.out.println(4 % 3); // 1 나머지만 나온다.
        
        // Math
        System.out.println(Math.abs(-9)); // 9 Type : number
        // 절대값
        System.out.println(Math.sqrt(4)); // 2.0 Type : double
        // 제곱근
        System.out.println(Math.pow(5,2)); // 25
        // 제곱
        System.out.println(Math.floor(Math.PI)); // 3.0 Type : double
        // 소수점 버림
        System.out.println(Math.ceil(Math.PI)); // 4.0 Type : double
        // 소수점이 있다면 올림
        System.out.println(Math.PI); // 3.1415926535...
        
        // Math.random
        System.out.println(Math.random()*10);
        // 10미만의 실수들을 하나씩 불러옵니다.
        System.out.println((int)Math.random()*10); // 0 ~ 9 정수
        // (int)를 통해 형변환 시켜줬다.
        System.out.println(((int)Math.random()*6)+5); // 5 ~ 10 정수
        // 원하는 구간 만큼 랜덤한 숫자를 뽑을수 있다.
	}
}
