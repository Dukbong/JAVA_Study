import static java.lang.Integer.*;
import static java.lang.Math.random;
import static java.lang.Math.PI;
import static java.lang.System.out;
public class Staticimport {

	public static void main(String[] args) {
		// 원래 코드를 작성하는 방법
		System.out.println(Math.random());
		
		// 위 아래 둘 다 동일하 코드이다.
		
		// static import문 사용해서 코드를 줄였다.
		out.println(random());
		
		// ==================================
		
		out.println("Math.PI = " + PI); // System이 빠지고 Math가 빠졌다
		
		String a = "123";
		int b = parseInt(a); // Integer.parseInt에서 parseInt로 줄었다.
		out.println("Integer.parseInt(a) = " + Integer.parseInt(a));
		out.println("parseInt(a) = " + b);

	}

}
