public class dataType{
	public static void main (String[] args) {
		System.out.println(6); // Number
        System.out.println("6"); // String
        System.out.println("Hello World"); // string
        
        // 문자열과 숫자의 연산 차이
        System.out.println(6 + 6); // Number (12)
        System.out.println("6" + "6"); // string (66)
        System.out.println(6 * 6); // Number(36)
        // System.out.println("6" * "6"); 💥Error!!
        System.out.println("Hello" + " world"); // string (Hello world)
        
        // 문자
        System.out.println('H'); // char
        // ⭐ '' = char  "" = String
        
        // 길이를 확인해볼 수 있다.
        System.out.println("hello".length()); // number (5);
        
        // 타입을 확인하는 방법
        System.out.println("확인하고 싶은것".getClass()); // class java.lang.String
        System.out.println("확인하고 싶은것".getClass().getSimpleName()); // String
        
        //=========================================================================
        
        // 대표적인 타입 알아보기
        int a = 1; // 정수형 타입 [최대 2,147,483,647 까지만 나타낼수 있다.]
        // ⭐ 4 byte
        
        short b = 1; // int 보다 작은 정수형 타입 [최대 32,767 까지만 나타낸다.]
        // ⭐ 2 byte
        
        long c = 2147999999L; // int 범위를 넘어서는 정수형 타입
        // ⭐ 8 byte ⭐ 특이사항 숫자끝에 L을 붙인다.
        
        double d = 1.0; // 실수형 타입
        // ⭐ 8 byte
        
        boolean e = true; // true, false를 나타내는 논리형 타입
        // ⭐ 1 byte

	}
}