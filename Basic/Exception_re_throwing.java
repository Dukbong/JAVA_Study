
public class Exception_re_throwing {

	public static void main(String[] args) {
		try {
			method1(); // 3�� ���� �߻��� ����
		}catch(Exception e) { // ���� ó�� 4
			System.out.println("main �޼��忡�� ���ܰ� ó���Ǿ����ϴ�.");
		}

	}
	static void method1() throws Exception{
		try {
			throw new Exception(); // ���� �߻� 1
		}catch(Exception e) {  // ���� ó�� �Ϸ� 2
			System.out.println("method1 �޼��忡�� ���ܰ� ó���Ǿ����ϴ�.");
			throw e; // �ٽ� ���� �߻� 3
		}
	}

}
