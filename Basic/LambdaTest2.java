
public class LambdaTest2 {

	public static void main(String[] args) {
		MyFunction f = new MyFunction() {
			public int max(int a, int b) { // 오버라이딩 규칙 접근 제어자 좁게 못바꾼다.
				return a > b ? a : b;
			}
		};
		// 위에 4줄을 람다식을 이용해 한줄로 만들 수 있다.
		MyFunction f2 = (a, b) -> a > b ? a : b;
		
		int value = f.max(3, 5);
		System.out.println("value = " + value);
		int value2 = f2.max(3, 6);
		System.out.println("value2 = " + value2);

	}
}

@FunctionalInterface
// 함수형 인터페이스라고 컴파일러에게 알려준다.
// 만약 함수형 인터페이스에 추상 메서드가 2개를 넣으면 컴파일러가 오류를 발생시킨다.
interface MyFunction{
	public abstract int max(int a, int b);
}
/* 함수형 인터페이스
 *  단 하나의 추상 메서드만 선언된 인터페이스
 *    - interface Myfunction{
 *          public abstract int max(int a, int b);
 *      }
 *    
 *    - Myfunction f = new Myfunction(){
 *          public int max(int a, int b){return a > b ? a : b;}
 *      };
 *    - int value = f.max(3, 5); // OK Myfuntion에는 max()가 있다.
 *    
 *  함수형 인터페이스 타입의 참조변수로 람다식을 참조할 수 있다. 
 *    - 단 함수형 인터페이스의 메서드와 람다식의 매개변수 개수와 반환타입이 일치해야한다.
 *       - Myfunction f = (a,b) -> a > b ? a : b;
 *       - int value = f.max(3,5); // 실제로는 람다식이 호출된다. 
 */