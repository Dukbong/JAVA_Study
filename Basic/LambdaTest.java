
public class LambdaTest {

	public static void main(String[] args) {
		// Object obj = (a, b) -> a > b ? a : b // ���ٽ�, �͸� ��ü
		Object obj = new Object() {
			int max(int a, int b) {
				return a >  b ? a : b;
			}
		};
		
		// int value = obj.max(3,5); // Error! Object����  max() �޼��尡 ����.
	}
}
/* 
 * ���ٽ�
 *   �Լ�(�޼���)�� ������ ��(expression)���� ǥ���ϴ� ���
 *     - �Լ�(�޼���) : int max(int a, int b){return a > b ? a : b;}
 *     - ���ٽ� : (a,b) -> a > b ? a : b;
 *   
 *   �͸� �Լ�(�̸� ���� �Լ�)
 *     - �Լ�(�޼���) : int max(int a, int b){return a > b ? a : b;}
 *     - ���ٽ� : (int a, int b) -> {return a > b ? a : b;}
 *       - ���ٽ����� �ٲܶ� ����Ÿ�԰� �޼������ ���� �� ��� �տ� ->�� �ٿ��ش�.
 *       
 * �Լ��� �޼����� ����
 *   - �ٺ������� ���������� �Լ��� �Ϲ��� ����̰� �޼���� ��ü���ⰳ�� ����̴�.
 *   - �Լ��� Ŭ������ �������̸� �޼���� Ŭ������ �������̴�.
 *   
 * ���ٽ� �ۼ��ϱ�
 *   - ��Ģ 1. ��ȯ���� �ִ� ���, ���̳� ���� ���� return�� ���� ����(���� ; �Ⱥ��δ�.)
 *     - int max(int a, int b){return a > b ? a : b;}
 *     - (int a, int b) -> {return a > b ? a : b;}
 *     - (int a, int b) -> a > b ? a : b
 *   - ��ġ 2. �Ű������� Ÿ���� �߷� �����ϸ� ���� ���� ( ��κ��� ��� ���� ���� )
 *     - (int a, int b) -> a > b ? a : b
 *     - (a, b) -> a > b ? a : b // ���� ���ٽ�
 *     
 * ���ٽ� �ۼ� �� ���� ����
 *   - �Ű������� �ϳ��� ��� ��ȣ() ���� ���� ( Ÿ���� ���� �� �� )
 *     - (a) -> a*a ======> a -> a*a >> OK
 *     - (int a) -> a*a ======> int a -> a*a >> Error!
 *   - ��� ���� ������ �ϳ��� �϶� ��ȣ {} ���� ���� (���� ; �� ���δ�.)
 *     - (int i) -> {System.out.println(i);}
 *     - (int i) -> System.out.println(i)
 *   - ��, �ϳ����� ������ return���̸� ��ȣ{} ���� �Ұ�
 *     - (int a, int b) -> {return a > b ? a : b;} // OK
 *     - (int a, int b) -> return a > b ? a : b // Error!
 *     
 * ���� �ۼ� ����
 *    - int max(int a, int b){return a > b ? a : b;}
 *    - ���ٽ� : (a, b) -> a > b ? a : b
 *    - int printVar(String name, int i){return System.out.println(name + " = " + i);}
 *    - ���ٽ� : (name, i) -> System.out.println(name + " = " + i)
 *    - int square(int x){return x * x;}
 *    - ���ٽ� : x -> x*x
 *    - int roll(){return (int)(Math.random()*6);}
 *    - ���ٽ� : () -> (int)(Math.random()*6)
 *    
 * ���ٽ��� �ڹٿ��� �͸� ��ü�̴�.
 *   - �ڹٿ����� �޼��常 ������ �������� ���ϱ� �����̴�.
 *   - ���ٽ��� �͸��Լ��� �ƴ� �͸� ��ü�̴�.
 *     - �Ʒ� �� ���� ���� �Ŵ�. ( ������ ���ٽ� , �Ʒ��� �͸� ��ü )
 *     - (a, b) -> a > b ? a : b // 
 *     - new Object(){
 *           int  max(int a, int b){
 *               return a > b ? a : b;
 *           }
 *       }
 */