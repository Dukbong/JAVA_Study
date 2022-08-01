
public class ExceptionTest {

	public static void main(String[] args) {
		// System.out.println(args[0]); �Ű������� ���� ������ ��Ÿ�� ���� �߻�
		// system.out.println(args[0]); //������ ���� (���� ����)
		
		// �����Ϸ��� �ϴ��� ( �⺻ ���� �� )
		// 1. ����üũ
		// 2. ����
		// 3. ����ȭ
		// 4. ������ �ڵ� �߰�
		
		// ��Ÿ�� ���� : ���� �� �� �߻��ϴ� ���� (���� �߻� �� ���α׷� ����)
		// ������ ���� : ������ �� �� �߻��ϴ� ���� (��ġ�� ������ ���� �Ұ�)
		// ���� ���� : �ۼ� �ǵ��� �ٸ��� ����
		
		// java�� ��Ÿ�� ����
		// 1. ����(error)     : ���α׷� �ڵ忡 ���ؼ� ������ �� ���� �ɰ��� ���� (��¿�� ����)
		// 2. ����(exception) : ���α׷� �ڵ忡 ���ؼ� ������ �� �ִ� �ټ� �̾��� ���� (ó������)
		
		// ����ó���� ���� �� ����
		// ���� : ������ �߻��� ����� �ڵ带 �ۼ��ϴ°�
		// ���� : ���α׷��� ������ ���Ḧ ���� �������� ������¸� �����ϴ� ��
		
		// ���� ������
		// Exception (��� ���� ó�� ����) - ���� ������ �ְ� ����
		// 		- IOException (����� ����)
		// 		- ClassNotFoundException (Ŭ������ �������� �ʴ´�.) - *.class
		// 		- ...
		// 		- RuntimeException
		// 				- ArithmeticException (��� ��� ����) - 5/0
		// 				- ClassCastException (����ȯ ����)
		// 				- NullPointerException (�� ����Ʈ) = String str = null; str.length;
		// 				- ...
		// 				- ArrayIndexOutOfBoundsException (�迭 ���� ���)
		
		// ���ܴ� �ΰ��� �ٽ� ���� �� �ִ�.
		// 1. Exception + Exception �ڽ� Ŭ������                  : ������� �Ǽ��� ���� ������ ���ο� ���� �߻��ϴ� ����
		// 2. RuntimeException + RuntimeException �ڽ� Ŭ������ : ���α׷����� �Ǽ��� �߻��ϴ� ����
		
		// ���� ó���ϱ�
		// try{���� �۵��� ����Ǵ� �ڵ�}catch{���� ��Ȳ�� ����ϴ� �ڵ�}catch{}...
		// catch{}�� ������ ����� �� �ִ�.
		// try��� ���� ���ܰ� �߻����� ������ catch{}�� ������� �ʰ� try-catch���� ���� ������ ��� ����ȴ�.
		// 1. try��� ���� �� ���ܰ� �߻��ϸ� �߻��� ���ܿ� ��ġ�ϴ� catch����� �ִ� �� Ȯ��
		// 2. ��ġ�ϴ� catch����� ã���� catch����� �����ϰ� ��ü try-catch���� ���������� �� ���� ������ ��� �����Ѵ�.
		// 2-1. ���� ��ġ�ϴ� catch����� ���ٸ� ���ܰ� ó������ ���ؼ� ���α׷��� ����ȴ�.
		System.out.println(1);
		try {
			System.out.println(2);
			System.out.println(3);
		}catch(Exception e){
			System.out.println(4);
		}
		System.out.println(5);
		// ��� : 1 2 3 5
		
		System.out.println(1);
		try {
			System.out.println(0/0);
			System.out.println(2);
		}catch(ArithmeticException e) {
			System.out.println(3);
		}
		System.out.println(4);
		// ��� : 1 3 4
		
		System.out.println("=================================");
		
		System.out.println(1);
		System.out.println(2);
		try {
			System.out.println(3);
			System.out.println(0/0); // ArithmeticException �߻�
			System.out.println(4);
		}catch(ArithmeticException ae) {
			if(ae instanceof ArithmeticException) {
				System.out.println("true");
			}
			System.out.println("ArithmeticException");
		}catch(Exception e) { // �� �ڵ忡���� ArithmeticException�� ������ ��� ���ܰ� ó���ȴ�.
			// Exception�� ���� ������ catch��Ͽ� ������� �Ѵ�.
			System.out.println("Exception");
		}
		System.out.println(6);
		// ��� : 1 2 3 true ArithmeticException
		
		System.out.println("=================================");
		
		System.out.println(1);
		System.out.println(2);
		try {
			System.out.println(3);
			System.out.println(args[0]); // ArrayIndexOutOfBoundsException �߻�
			System.out.println(4);
		}catch(ArithmeticException ae) {
			if(ae instanceof ArithmeticException) {
				System.out.println("true");
			}
			System.out.println("ArithmeticException");
		}
		 catch(ArrayIndexOutOfBoundsException e){
		 	System.out.println("indexOutBoundsException");
		 } 
		System.out.println(6);
		// ��� 1 2 3 ���� ����
		// indexOutBoundsException�� �´� ���� ó���� ���� ������ ���� ����ȴ�.
		
		System.out.println("=================================");
		
		// printStackTrace() : ���� �߻� ����� ȣ�� ���ÿ� �־��� �޼����� ������ ���� �޽����� ȭ�鿡 ����Ѵ�.
		// ����������.printStackTrace()
		// getMessage() : �߻��� ���� Ŭ������ �ν��Ͻ��� ����� �޽����� ���� �� �ִ�.
		// ����������.getMessage()
		
		// �ڵ� ���� �� ���ܰ� �߻��ϸ� ���� ��ü�� �����Ǹ� ���� ��ü���� ���ܿ� ���� ������ ����ִ�.
		
		System.out.println(1);
		System.out.println(2);
		try {
			System.out.println(3);
			System.out.println(0/0); // ArithmeticException Ÿ���� ��ü�� �����ȴ�. (���� �ּ� : 0X100)
			System.out.println(4);
		}catch(ArithmeticException ae) { // �������� ae�� ������ ������ ��ü�� �ּҸ� �����Ѵ�.
			ae.printStackTrace();
			System.out.println("���� �޽��� : " + ae.getMessage());
		}
		System.out.println(5);
		
		System.out.println("=================================");
		
		System.out.println("��Ƽ catch ���");
		// ��Ƽ catch ���
		// ������ ���� catch ���� �ϳ��� ��ģ �� (JDK 1.7����)
		// catch(ExceptionA | ExceptionB e){...}
		// 1. ���� Ŭ������ �θ� �ڽ� ������ �ȵȴ�.
		// ������ �θ� ��� �ǹ̰� �����ϱ� �����̴�.
		// 2. � ��ü�� ������ �𸣱� ������ catch��Ͽ��� ����� ����� ��� �����ϴ�. 
		// ���� ����ϰ� �ʹٸ� instanceof�� ����ȯ�� ���Ѽ� ����� �� �ִ�.
		// �ٵ� ����ȯ ���Ѽ� ����Ҳ��� ��Ƽ catch�� ����� �ʿ䰡 ����. �׳� ���� ���°� ����.
		
		System.out.println("=================================");
		
		// ���� �߻� ��Ű��
		// 1. ���� Ŭ������ �ν��Ͻ��� �����.
		// Exception e = new Exception("���Ƿ� �߻����״�");
		// 2. Ű���� throw�� �̿��ؼ� ���ܸ� �߻���Ų��.
		// throw e;
		
		try {
			Exception e = new Exception("���Ƿ� ���� �߻�"); // ���� ��ü ����
			throw e; // ���ܸ� �߻�
			// throw new Exception("��޷� ���� �߻�"); >> ���� ������ ���ٷ� �ٿ� ���� �ִ�.
		}catch (Exception e) {
			System.out.println("���� �޽��� : " + e.getMessage());
			e.printStackTrace();
		}
		System.out.println("���α׷��� ���� ����Ǿ����ϴ�.");
		
		System.out.println("=================================");
		
		// checked ���� : �����Ϸ��� ���� ó�� ���θ� üũ( ���� ó�� �ʼ� )
		//    - Exception + Exception �ڽ� Ŭ������
		// unchecked ���� : �����Ϸ��� ���� ó�� ���θ� äũ ���� ( ���� ó�� ���� )
		//    - RuntimeException + RuntimeException �ڽ� Ŭ������ 
		
		// checked ���� ����
		// throw new Exception(); // ������ ����
		// ������ ����ó���� �ʼ� �ε� try-catch�� ���� �����̴�.
		
		// unchecked ���� ����
		// throw new RuntimeException();
		// ���� ó���� �����̹Ƿ� try-catch ���̵� ������ ����
		// ������ ������ �����ϸ� ��Ÿ�ӿ����� ������ ����ȴ�.
		
		// ���� �߰� ����
		// 1. ������ ����
		// 2. ��Ÿ�� ����   > Error : �ɰ�
		// 			  > Exception : �� �ɰ�  > Exception�� �ڽ�  : checked ���� (���� ó�� �ʼ�)
		//                               > RuntimeException�� �ڽ� : unchecked ����(���� ó�� ����)
		// 3. ���� ����
		
		System.out.println("=================================");
		
		// ���ܸ� ó���ϴ� ����� try-catch��, ���� �����ϱ�(���� ���ѱ��)�� �ֽ��ϴ�.
		// ���� ������ �޼��尡 ȣ�� �� �߻������� ���ܸ� ȣ���ϴ� �ʿ� �˸��� ��
		
		// �޼��� ���� �����ϱ�
		// void method() throws Exception1,Exception2 ...{
		//     �޼��� ����
		// }
		// void method() throws Exception{ �޼��� ���� }
		
		// ���� �����Ҷ� checked ���ܸ� ���°� �����̴�.

		// ������ methodExceptionTest �ҽ����Ͽ� �ִ�.
		
		System.out.println("=================================");
		
		// finally ��
		// ���� �߻����ο� ������� ����Ǿ�� �ϴ� �ڵ带 �ִ´�.
		// finally ���� try-catch���� �� �������� ��ġ�ؾ��Ѵ�.
		// try{���ܰ� �߻��� ���ɼ��� �ִ� ����}catch(Exception e){���� ó���� ���� ������}finally{���� ���� ���x �׻� ����}
		
//		try {
//			startInstall();
//			copyFiles();
//			deleteTempFiles(); // �ߺ�
//		} catch(Exception e) {
//			e.printStackTrace();
//			deleteTempFiles(); // �ߺ�
//		}
		
		// finally ������� �ߺ��� ���� ���ش�.
		
//		try {
//			startInstall();
//			copyFiles();
//		} catch(Exception e) {
//			e.printStackTrace();
//		} finally {
//			deleteTempFiles();
//		}
		
		System.out.println("=================================");
		
		// ����� ���� ���� �����
		// ���� ���� Ŭ������ ������ �� �ִ�.
		// �θ�� Exception�� RuntimeException �� �ϳ��� ����
		
		class MyException extends Exception{
			MyException(String msg){
				super(msg); // �θ��� �����ڸ� ȣ��
			}
		}
		
		class MyException2 extends Exception{
			private final int ERR_CODE;
			
			MyException2(String msg, int errcode){
				super(msg);
				ERR_CODE = errcode;
			}
			
			MyException2(String msg){
				this(msg,100);
			}
			public int getErrCode() {
				return ERR_CODE;
			}
		}
		
		System.out.println("=================================");
		
		// ���� �Ǵ����� (re-throwing)
		// ���ܸ� ó���� �Ŀ� �ٽ� ���ܸ� �߻���Ű�� ��
		
		// ������ Exception-re-throwing
		
		System.out.println("=================================");
		
		// ����� ����
		// �� ���ܰ� �ٸ� ���ܸ� �߻���ų �� �ִ�.
		// ���� A�� ���� B�� �߻���Ű�� A�� B�� ���� �����̴�.
		// ����ϴ����� 1. ���� ���ܸ� �ϳ��� ��� �ٷ�� ���ؼ�
		// ����ϴ����� 2. checked ���ܸ� unchecked ���ܷ� �����Ϸ� �Ҷ�
		
		// ����B initCause(���� A) : ������ ���ܸ� ���� ���ܷ� ���
		// ���� getCause() : ���� ���ܸ� ��ȯ
		
//		void install() throws InstallException{
//			try {
//				startInstall(); // SpaceException �߻� (������� ����)
//				copyFile();
//			}catch(SpaceException e) {
//				InstallException ie = new InstallException("��ġ �� ���� �߻�"); // ���� ����
//				ie.initCause(e); // InstallException�� ���� ���ܸ� SpacException���� ���� (���� ����)
//				throw ie; // InstallException�� �߻���Ų��.
//			}
//		}
		
//		static void startInstall() throws SpaceException, MemoryException{
//			if (!enoughSpace()) {
//				throw new SpaceException("��ġ�� ������ �����մϴ�.");
//			}
//			if (!enoughMemory()) {
//				throw new MemoryException("�޸𸮰� �����մϴ�.");
//			}
//		}
//		
//		static void startInstall() throws SpaceException{
//			if (!enoughSpace()) {
//				throw new SpaceException("��ġ�� ������ �����մϴ�.");
//			}
//			if (!enoughMemory()) {
//				// MemoryException�� RuntimeException�� ���� ���ܷ� �����ߴ�.
//				// �ٸ��� ���� ���� �����ϴ� ��
//				RuntimeException re = new RuntimeException("���� ���� �����");
//				re.initCause(new MemoryException("�޸𸮰� �����մϴ�."));
//				throw new RuntimeException(new MemoryException("�޸𸮰� �����մϴ�."));
//			}
//		}
	}

}

