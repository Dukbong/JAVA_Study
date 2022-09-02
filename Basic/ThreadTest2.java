
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
			System.out.printf("%s", new String("UU"));
		}
		System.out.println("소요시간3 = " + System.currentTimeMillis());
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
/*
 * main 쓰레드란
 *   - main메서드의 코드를 수행하는 쓰레드이다.
 *   - 쓰레드의 종류로는 "사용자 쓰레드(main 쓰레드)"와 "데몬 쓰레드(보조 쓰레드)"가 있다.
 *   
 *   실행 중인 사용자 쓰레드가 하나도 없을때 프로그램은 종료된다.
 *     - 멀티 쓰레드일 경우는 사용자 쓰레드가 종료되도 다른 쓰레드가 있기 때문에 프로그램이 종료되지 않는다.
 */