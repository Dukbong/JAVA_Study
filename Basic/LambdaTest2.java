
public class LambdaTest2 {

	public static void main(String[] args) {
		MyFunction f = new MyFunction() {
			public int max(int a, int b) { // �������̵� ��Ģ ���� ������ ���� ���ٲ۴�.
				return a > b ? a : b;
			}
		};
		// ���� 4���� ���ٽ��� �̿��� ���ٷ� ���� �� �ִ�.
		MyFunction f2 = (a, b) -> a > b ? a : b;
		
		int value = f.max(3, 5);
		System.out.println("value = " + value);
		int value2 = f2.max(3, 6);
		System.out.println("value2 = " + value2);

	}
}

@FunctionalInterface
// �Լ��� �������̽���� �����Ϸ����� �˷��ش�.
// ���� �Լ��� �������̽��� �߻� �޼��尡 2���� ������ �����Ϸ��� ������ �߻���Ų��.
interface MyFunction{
	public abstract int max(int a, int b);
}
/* �Լ��� �������̽�
 *  �� �ϳ��� �߻� �޼��常 ����� �������̽�
 *    - interface Myfunction{
 *          public abstract int max(int a, int b);
 *      }
 *    
 *    - Myfunction f = new Myfunction(){
 *          public int max(int a, int b){return a > b ? a : b;}
 *      };
 *    - int value = f.max(3, 5); // OK Myfuntion���� max()�� �ִ�.
 *    
 *  �Լ��� �������̽� Ÿ���� ���������� ���ٽ��� ������ �� �ִ�. 
 *    - �� �Լ��� �������̽��� �޼���� ���ٽ��� �Ű����� ������ ��ȯŸ���� ��ġ�ؾ��Ѵ�.
 *       - Myfunction f = (a,b) -> a > b ? a : b;
 *       - int value = f.max(3,5); // �����δ� ���ٽ��� ȣ��ȴ�. 
 */