public class StringType {
	public static void main(String[] args){
    	System.out.println("Hello World"); // type : string
        System.out.println('H'); // type : char
        System.out.println("H"); // type : string
        
        // 연산으로 만들기
        System.out.println("Hello" + " World"); // Hello World
        
        // 줄바꿈으로 만들기
        System.out.println("Hello \n World"); // \n에서 줄바꿈이 된다.
        /*
       	결과
        Hello
        World
        */
        
        // 문자열에 " "을 사용해서 만들기
        // System.out.println("Hello "World"") 💥 Error!!
        System.out.println("Hello \"World\""); // Hello "World"
        System.out.println("Hello 'world'"); // Hello 'world'
        
        // replace("변경하고 싶은 문자열", "새로운 문자열") 사용해보기
        System.out.println("Hello naver".replace("naver","Tistory"));
        // Hello Tistory
        
    }
}