
public class LambdaTest {

	public static void main(String[] args) {
		// Object obj = (a, b) -> a > b ? a : b // 람다식, 익명 객체
		Object obj = new Object() {
			int max(int a, int b) {
				return a >  b ? a : b;
			}
		};
		
		// int value = obj.max(3,5); // Error! Object에는  max() 메서드가 없다.
	}
}
/* 
 * 람다식
 *   함수(메서드)를 간단한 식(expression)으로 표현하는 방법
 *     - 함수(메서드) : int max(int a, int b){return a > b ? a : b;}
 *     - 람다식 : (a,b) -> a > b ? a : b;
 *   
 *   익명 함수(이름 없는 함수)
 *     - 함수(메서드) : int max(int a, int b){return a > b ? a : b;}
 *     - 람다식 : (int a, int b) -> {return a > b ? a : b;}
 *       - 람다식으로 바꿀때 리턴타입과 메서드명을 지운 후 블록 앞에 ->를 붙여준다.
 *       
 * 함수와 메서드의 차이
 *   - 근복적으로 동일하지만 함수는 일반적 용어이고 메서드는 객체지향개념 용어이다.
 *   - 함수는 클래스에 독립적이며 메서드는 클래스에 종속적이다.
 *   
 * 람다식 작성하기
 *   - 규칙 1. 반환값이 있는 경우, 식이나 값만 적고 return문 생략 가능(끝에 ; 안붙인다.)
 *     - int max(int a, int b){return a > b ? a : b;}
 *     - (int a, int b) -> {return a > b ? a : b;}
 *     - (int a, int b) -> a > b ? a : b
 *   - 규치 2. 매개변수의 타입이 추론 가능하면 생략 가능 ( 대부분의 경우 생략 가능 )
 *     - (int a, int b) -> a > b ? a : b
 *     - (a, b) -> a > b ? a : b // 최종 람다식
 *     
 * 람다식 작성 시 주의 사항
 *   - 매개변수가 하나인 경우 괄호() 생략 가능 ( 타입이 없을 때 만 )
 *     - (a) -> a*a ======> a -> a*a >> OK
 *     - (int a) -> a*a ======> int a -> a*a >> Error!
 *   - 블록 안의 문장이 하나뿐 일때 괄호 {} 생략 가능 (끝에 ; 안 붙인다.)
 *     - (int i) -> {System.out.println(i);}
 *     - (int i) -> System.out.println(i)
 *   - 단, 하나뿐인 문장이 return문이면 괄호{} 생략 불가
 *     - (int a, int b) -> {return a > b ? a : b;} // OK
 *     - (int a, int b) -> return a > b ? a : b // Error!
 *     
 * 람다 작성 연습
 *    - int max(int a, int b){return a > b ? a : b;}
 *    - 람다식 : (a, b) -> a > b ? a : b
 *    - int printVar(String name, int i){return System.out.println(name + " = " + i);}
 *    - 람다식 : (name, i) -> System.out.println(name + " = " + i)
 *    - int square(int x){return x * x;}
 *    - 람다식 : x -> x*x
 *    - int roll(){return (int)(Math.random()*6);}
 *    - 람다식 : () -> (int)(Math.random()*6)
 *    
 * 람다식은 자바에서 익명 객체이다.
 *   - 자바에서는 메서드만 별도로 존재하지 못하기 때문이다.
 *   - 람다식은 익명함수가 아닌 익명 객체이다.
 *     - 아래 두 식은 같은 거다. ( 위에는 람다식 , 아래는 익명 객체 )
 *     - (a, b) -> a > b ? a : b // 
 *     - new Object(){
 *           int  max(int a, int b){
 *               return a > b ? a : b;
 *           }
 *       }
 */