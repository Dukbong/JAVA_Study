import javax.swing.JOptionPane;

public class ThreadTest2 { // 12:54초 부터 진행하기

	public static void main(String[] args) {
		// 예제 1 ( main 메서드가 종료되도 멀티쓰레드에서는 종료되지 않는다. )
		ThreadEx11_1 th1 = new ThreadEx11_1();
		Runnable r = new ThreadEx11_2();
		Thread th2 = new Thread(r);
		
		th1.start();
		th2.start();
		startTime = System.currentTimeMillis();
		
		try {
			th1.join(); // 메인 쓰레드가 th1의 작업이 끝날때 까지 기다린다.
			th2.join(); // 메인 쓰레드가 th1의 작업이 끝날때 까지 기다린다.
		}catch(InterruptedException e) {}
		
		System.out.println("소요시간 = " + (System.currentTimeMillis() - startTime));
		// ==============================================
		
		// 예제 2 (싱글 쓰레드는 순차적으로 실행되면 마지막에 종료된다.) >> 멀티 쓰레드 보다 많은 시간이 소요된다.
		long startTime2 = System.currentTimeMillis();
		
		for (int i = 0; i < 300; i++) {
			System.out.printf("%s", new String("-"));
		}
		System.out.println("소요시간1 = " + (System.currentTimeMillis() - startTime2));
		for (int i = 0; i < 300; i++) {
			System.out.printf("%s", new String("|"));
		}
		System.out.println("소요시간2 = " + (System.currentTimeMillis() - startTime2));
		// ==============================================
		
		// 예제 3 (예제 2번 멀티쓰레드 바꾸기)
		ThreadEx13_1 th3 = new ThreadEx13_1();
		th3.start();
		startTime3 = System.currentTimeMillis();
		
		for (int i = 0; i < 300; i++) {
			System.out.printf("%s", new String("U"));
		}
		System.out.println("소요시간3 = " + System.currentTimeMillis());
		// ===============================================
		System.out.printf("\n\n\n\n");
		// 예제 4 (쓰레드 I/O 블락킹)
		
		// 싱글 쓰레드로 만들기!
		String input = JOptionPane.showInputDialog("아무값이나 입력하세요.");
		// 입력 받기 전까지는 프로그램이 중단된다. (이런걸 I/O 블락킹 이라고 한다.)
		// 다른 작업을 할 수 없다.
		System.out.println("입력하신 값은 " + input + "입니다.");
		// 입력 받은 후에야 아래있는 코드들이 순차적으로 실행된다.
		for (int i = 10; i > 0; i--) {
			System.out.println(i);
			try {
				Thread.sleep(1000); // 1초 지연한다.
			}catch(Exception e) {}
		}
		
		// 멀티 쓰레드로 만들기!
		ThreadEx5_1 th4 = new ThreadEx5_1();
		th4.start();
		// 위에 작업과 상관없이 아래 작업이 수행된다.
		String input2 = JOptionPane.showInputDialog("아무값이나 입력하세요.");
		System.out.println("입력하신 값은 " + input2 + "입니다.");
	}
	static long startTime = 0;
	static long startTime3 = 0;
}
class ThreadEx11_1 extends Thread{
	public void run() {
		for (int i = 0; i < 300; i++) {
			System.out.print(new String("-"));
		}
	}
}

class ThreadEx11_2 implements Runnable{
	public void run() {
		for(int i = 0; i < 300; i++) {
			System.out.print(new String("|"));
		}
	}
}

class ThreadEx13_1 extends Thread{
	public void run() {
		for (int i = 0; i < 300; i++) {
			System.out.printf("%s", new String("^"));
		}
		System.out.println("소요시간3 = " + (System.currentTimeMillis()));
	}
}

class ThreadEx5_1 extends Thread{
	public void run() {
		for (int i = 10; i > 0; i--) {
			System.out.println(i);
			try {
				sleep(1000);
			}catch(Exception e) {}
		}
	}
}
/*
 * main 쓰레드란
 *   - main메서드의 코드를 수행하는 쓰레드이다.
 *   - 쓰레드의 종류로는 "사용자 쓰레드(main 쓰레드)"와 "데몬 쓰레드(보조 쓰레드)"가 있다.
 *   
 *   실행 중인 사용자 쓰레드가 하나도 없을때 프로그램은 종료된다.
 *     - 멀티 쓰레드일 경우는 사용자 쓰레드가 종료되도 다른 쓰레드가 있기 때문에 프로그램이 종료되지 않는다.
 *     
 *
 * 멀티쓰레드에서 A에서 B로 넘어갈때 context switching이라고 한다.
 *   - 이때 시간이 소요된다.
 * 그렇기 때문에 멀티 쓰레드보다 싱글 쓰레드의 최종 소요시간이 덜 걸린다.
 *   - 시간이 더 걸리는 멀티쓰레드를 왜 사용할까?
 *     - 여러가지 작업을 번갈아 가며 할 수 있다는 장점이 있기 때문이다.
 *       - 예를 들어 파일 다운로드 받으면서 채팅하기
 * 
 * 쓰레드의 I/O 블락킹 (blocking)
 *   - I/O는 입출력을 의미한다.
 *   - 블락킹은 막는것을 말한다.
 *   - 최종적으로 입출력시 작업 중단
 */