import static java.lang.Integer.*;
import static java.lang.Math.random;
import static java.lang.Math.PI;
import static java.lang.System.out;
public class Staticimport {

	public static void main(String[] args) {
		// ���� �ڵ带 �ۼ��ϴ� ���
		System.out.println(Math.random());
		
		// �� �Ʒ� �� �� ������ �ڵ��̴�.
		
		// static import�� ����ؼ� �ڵ带 �ٿ���.
		out.println(random());
		
		// ==================================
		
		out.println("Math.PI = " + PI); // System�� ������ Math�� ������
		
		String a = "123";
		int b = parseInt(a); // Integer.parseInt���� parseInt�� �پ���.
		out.println("Integer.parseInt(a) = " + Integer.parseInt(a));
		out.println("parseInt(a) = " + b);

	}

}
