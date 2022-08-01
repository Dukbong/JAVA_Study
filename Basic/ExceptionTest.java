
public class ExceptionTest {

	public static void main(String[] args) {
		// System.out.println(args[0]); 매개변수가 없기 때문에 런타임 에러 발생
		// system.out.println(args[0]); //컴파일 에러 (구문 오류)
		
		// 컴파일러가 하는일 ( 기본 적인 거 )
		// 1. 구문체크
		// 2. 번역
		// 3. 최적화
		// 4. 생략된 코드 추가
		
		// 런타임 에러 : 실행 할 때 발생하는 에러 (에러 발생 시 프로그램 종료)
		// 컴파일 에러 : 컴파일 할 때 발생하는 에러 (고치기 전까지 실행 불가)
		// 논리적 에러 : 작성 의도와 다른게 동작
		
		// java의 런타임 에러
		// 1. 에러(error)     : 프로그램 코드에 의해서 수습될 수 없는 심각한 오류 (어쩔수 없다)
		// 2. 예외(exception) : 프로그램 코드에 의해서 수습될 수 있는 다소 미약한 오류 (처리하자)
		
		// 예외처리의 정의 및 목적
		// 정의 : 예외의 발생에 대비한 코드를 작성하는것
		// 목적 : 프로그램의 비정상 종료를 막고 정상적인 실행상태를 유지하는 것
		
		// 예외 계층도
		// Exception (모든 예외 처리 가능) - 모은 예외의 최고 조상
		// 		- IOException (입출력 예외)
		// 		- ClassNotFoundException (클래스가 존재하지 않는다.) - *.class
		// 		- ...
		// 		- RuntimeException
		// 				- ArithmeticException (산술 계산 예외) - 5/0
		// 				- ClassCastException (형변환 예외)
		// 				- NullPointerException (널 포인트) = String str = null; str.length;
		// 				- ...
		// 				- ArrayIndexOutOfBoundsException (배열 범위 벗어남)
		
		// 예외는 두개로 다시 나눌 수 있다.
		// 1. Exception + Exception 자식 클래스들                  : 사용자의 실수와 같은 외적인 요인에 인해 발생하는 예외
		// 2. RuntimeException + RuntimeException 자식 클래스들 : 프로그래머의 실수로 발생하는 예외
		
		// 예외 처리하기
		// try{정상 작동시 실행되는 코드}catch{예외 상황에 대비하는 코드}catch{}...
		// catch{}는 여러개 사용할 수 있다.
		// try블록 에서 예외가 발생하지 않으면 catch{}는 실행되지 않고 try-catch문을 빠져 나가서 계속 수행된다.
		// 1. try블록 실행 중 예외가 발생하면 발생한 예외와 일치하는 catch블록이 있는 지 확인
		// 2. 일치하는 catch블록을 찾으면 catch블록을 수행하고 전체 try-catch문을 빠져나가서 그 다음 문장을 계속 수행한다.
		// 2-1. 만약 일치하는 catch블록이 없다면 예외가 처리되지 못해서 프로그램이 종료된다.
		System.out.println(1);
		try {
			System.out.println(2);
			System.out.println(3);
		}catch(Exception e){
			System.out.println(4);
		}
		System.out.println(5);
		// 결과 : 1 2 3 5
		
		System.out.println(1);
		try {
			System.out.println(0/0);
			System.out.println(2);
		}catch(ArithmeticException e) {
			System.out.println(3);
		}
		System.out.println(4);
		// 결과 : 1 3 4
		
		System.out.println("=================================");
		
		System.out.println(1);
		System.out.println(2);
		try {
			System.out.println(3);
			System.out.println(0/0); // ArithmeticException 발생
			System.out.println(4);
		}catch(ArithmeticException ae) {
			if(ae instanceof ArithmeticException) {
				System.out.println("true");
			}
			System.out.println("ArithmeticException");
		}catch(Exception e) { // 이 코드에서는 ArithmeticException을 제외한 모든 예외가 처리된다.
			// Exception은 가장 마지막 catch블록에 적어줘야 한다.
			System.out.println("Exception");
		}
		System.out.println(6);
		// 결과 : 1 2 3 true ArithmeticException
		
		System.out.println("=================================");
		
		System.out.println(1);
		System.out.println(2);
		try {
			System.out.println(3);
			System.out.println(args[0]); // ArrayIndexOutOfBoundsException 발생
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
		// 결과 1 2 3 강제 종료
		// indexOutBoundsException에 맞는 예외 처리가 없기 때문에 강제 종료된다.
		
		System.out.println("=================================");
		
		// printStackTrace() : 예외 발생 당시의 호출 스택에 있었던 메서드의 정보와 예외 메시지를 화면에 출력한다.
		// 참조변수명.printStackTrace()
		// getMessage() : 발생한 예외 클래스의 인스턴스에 저장된 메시지를 얻을 수 있다.
		// 참조변수명.getMessage()
		
		// 코드 실행 중 예외가 발생하면 예외 객체가 생성되며 예외 객체에는 예외에 대한 정보가 들어있다.
		
		System.out.println(1);
		System.out.println(2);
		try {
			System.out.println(3);
			System.out.println(0/0); // ArithmeticException 타입의 객체가 생성된다. (예시 주소 : 0X100)
			System.out.println(4);
		}catch(ArithmeticException ae) { // 참조변수 ae에 위에서 생성된 객체의 주소를 저장한다.
			ae.printStackTrace();
			System.out.println("예외 메시지 : " + ae.getMessage());
		}
		System.out.println(5);
		
		System.out.println("=================================");
		
		System.out.println("멀티 catch 블록");
		// 멀티 catch 블록
		// 내용이 같은 catch 블럭을 하나로 합친 것 (JDK 1.7부터)
		// catch(ExceptionA | ExceptionB e){...}
		// 1. 예외 클래스가 부모 자식 관계라면 안된다.
		// 이유는 부모만 적어도 의미가 동일하기 때문이다.
		// 2. 어떤 객체가 들어올지 모르기 때문에 catch블록에는 공통된 멤버만 사용 가능하다. 
		// 굳이 사용하고 싶다면 instanceof로 형변환을 시켜서 사용할 수 있다.
		// 근데 형변환 시켜서 사용할꺼면 멀티 catch를 사용할 필요가 없다. 그냥 따로 쓰는게 낫다.
		
		System.out.println("=================================");
		
		// 예외 발생 시키기
		// 1. 예외 클래스의 인스턴스를 만든다.
		// Exception e = new Exception("고의로 발생시켰다");
		// 2. 키워드 throw를 이용해서 예외를 발생시킨다.
		// throw e;
		
		try {
			Exception e = new Exception("고의로 예외 발생"); // 예외 객체 생성
			throw e; // 예외를 발생
			// throw new Exception("고믜로 예외 발생"); >> 위에 두줄을 한줄로 줄여 쓸수 있다.
		}catch (Exception e) {
			System.out.println("에러 메시지 : " + e.getMessage());
			e.printStackTrace();
		}
		System.out.println("프로그램이 정상 종료되었습니다.");
		
		System.out.println("=================================");
		
		// checked 예외 : 컴파일러가 예외 처리 여부를 체크( 예외 처리 필수 )
		//    - Exception + Exception 자식 클래스들
		// unchecked 예외 : 컴파일러가 예외 처리 여부를 채크 암함 ( 예외 처리 선택 )
		//    - RuntimeException + RuntimeException 자식 클래스들 
		
		// checked 예외 예제
		// throw new Exception(); // 컴파일 에러
		// 이유는 예외처리가 필수 인데 try-catch가 없기 때문이다.
		
		// unchecked 예외 예제
		// throw new RuntimeException();
		// 예외 처리가 선택이므로 try-catch 없이도 컴파일 성공
		// 하지만 실제로 실행하면 런타임에러로 비정상 종료된다.
		
		// 오류 중간 점검
		// 1. 컴파일 에러
		// 2. 런타임 에러   > Error : 심각
		// 			  > Exception : 덜 심각  > Exception과 자식  : checked 예외 (예외 처리 필수)
		//                               > RuntimeException과 자식 : unchecked 예외(예외 처리 선택)
		// 3. 논리적 에러
		
		System.out.println("=================================");
		
		// 예외를 처리하는 방법은 try-catch문, 예외 선언하기(예외 떠넘기기)가 있습니다.
		// 예외 선언은 메서드가 호출 시 발생가능한 예외를 호출하는 쪽에 알리는 것
		
		// 메서드 예외 선언하기
		// void method() throws Exception1,Exception2 ...{
		//     메서드 내용
		// }
		// void method() throws Exception{ 메서드 내용 }
		
		// 예외 선언할때 checked 예외만 적는게 정석이다.

		// 예제는 methodExceptionTest 소스파일에 있다.
		
		System.out.println("=================================");
		
		// finally 블럭
		// 예외 발생여부와 상관없이 수행되어야 하는 코드를 넣는다.
		// finally 블럭은 try-catch문의 맨 마지막에 위치해야한다.
		// try{예외가 발생할 가능성이 있는 문장}catch(Exception e){예외 처리를 위한 ㅋ문장}finally{예외 여부 상관x 항상 수행}
		
//		try {
//			startInstall();
//			copyFiles();
//			deleteTempFiles(); // 중복
//		} catch(Exception e) {
//			e.printStackTrace();
//			deleteTempFiles(); // 중복
//		}
		
		// finally 블록으로 중복을 제거 해준다.
		
//		try {
//			startInstall();
//			copyFiles();
//		} catch(Exception e) {
//			e.printStackTrace();
//		} finally {
//			deleteTempFiles();
//		}
		
		System.out.println("=================================");
		
		// 사용자 정의 예외 만들기
		// 직접 예외 클래스를 정의할 수 있다.
		// 부모는 Exception과 RuntimeException 중 하나를 선택
		
		class MyException extends Exception{
			MyException(String msg){
				super(msg); // 부모의 생성자를 호출
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
		
		// 예외 되던지기 (re-throwing)
		// 예외를 처리한 후에 다시 예외를 발생시키는 것
		
		// 예제는 Exception-re-throwing
		
		System.out.println("=================================");
		
		// 연결된 예외
		// 한 예외가 다른 예외를 발생시킬 수 있다.
		// 예외 A가 예외 B를 발생시키면 A는 B의 원인 예외이다.
		// 사용하는이유 1. 여러 예외를 하나로 묶어서 다루기 위해서
		// 사용하는이유 2. checked 예외를 unchecked 예외로 변경하려 할때
		
		// 예외B initCause(예외 A) : 지정한 예외를 워인 예외로 등록
		// 예외 getCause() : 원인 예외를 반환
		
//		void install() throws InstallException{
//			try {
//				startInstall(); // SpaceException 발생 (저장공간 부족)
//				copyFile();
//			}catch(SpaceException e) {
//				InstallException ie = new InstallException("설치 중 예외 발생"); // 예외 생성
//				ie.initCause(e); // InstallException의 원인 예외를 SpacException으로 지정 (예외 연결)
//				throw ie; // InstallException을 발생시킨다.
//			}
//		}
		
//		static void startInstall() throws SpaceException, MemoryException{
//			if (!enoughSpace()) {
//				throw new SpaceException("설치할 공간이 부족합니다.");
//			}
//			if (!enoughMemory()) {
//				throw new MemoryException("메모리가 부족합니다.");
//			}
//		}
//		
//		static void startInstall() throws SpaceException{
//			if (!enoughSpace()) {
//				throw new SpaceException("설치할 공간이 부족합니다.");
//			}
//			if (!enoughMemory()) {
//				// MemoryException을 RuntimeException의 원인 예외로 지정했다.
//				// 다르게 원인 예외 지정하는 법
//				RuntimeException re = new RuntimeException("원인 예외 만들기");
//				re.initCause(new MemoryException("메모리가 부족합니다."));
//				throw new RuntimeException(new MemoryException("메모리가 부족합니다."));
//			}
//		}
	}

}

