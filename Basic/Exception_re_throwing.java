
public class Exception_re_throwing {

	public static void main(String[] args) {
		try {
			method1(); // 3번 예외 발생이 전달
		}catch(Exception e) { // 예외 처리 4
			System.out.println("main 메서드에서 예외가 처리되었습니다.");
		}

	}
	static void method1() throws Exception{
		try {
			throw new Exception(); // 예외 발생 1
		}catch(Exception e) {  // 예외 처리 완료 2
			System.out.println("method1 메서드에서 예외가 처리되었습니다.");
			throw e; // 다시 예외 발생 3
		}
	}

}
