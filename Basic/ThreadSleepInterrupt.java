import javax.swing.JOptionPane;

public class ThreadSleepInterrupt {

	public static void main(String[] args) {
		// 예제 1
		ThreadEx8_1 th1 = new ThreadEx8_1();
		Thread th2 = new Thread(new ThreadEx8_2());
		
		th1.start();
		th2.start();
		
		//============================================================
		try {
			th1.sleep(2000);
			// == Thread.sleep(2000); 
			// 이 코드를 수행하는 것은 th1이라고 적어도 main 스레드이기 때문에 main 스레드가 잔다.
		}catch(InterruptedException e) {}
		// delay(2000); 이랑 같은 코드인데 delay처럼 별도의 메서드를 만드는게 더 깔끔하다.
		//============================================================
		
		System.out.print("<<main 종료>>");
		
		// 예제 2
		ThreadEx9_1 th3 = new ThreadEx9_1();
		th3.start();
		System.out.println("시작 isInterrupted() = " + th3.isInterrupted());
		String input = JOptionPane.showInputDialog("아무 값이나 입력하세요.");
		System.out.println("입력하신 값은 " + input + "입니다.");
		th3.interrupt(); // interrupt()를 호출하면 interrupted는 true가 된다.
		System.out.println("종료 isInterrupted() = " + th3.isInterrupted());
		System.out.println("interrupted = " + Thread.interrupted());
		// 현재 스레드는 main이기 때문에 main 스레드가 interrupt 되었는지 알려준 후 false로 초기화 한다.
		// interrupted는 static 메서드이기 때문에 Thread로 해줘야한다.
	}
	static void delay(long millis) {
		try {
			Thread.sleep(millis);
		}catch(InterruptedException e) {}
	}
}

class ThreadEx8_1 extends Thread{
	public void run() {
		for(int i = 0; i < 300; i++) {
			System.out.print("-");
		}
		System.out.print("<<th1종료>>");
	}
}

class ThreadEx8_2 implements Runnable{
	public void run() {
		for(int i = 0; i < 300; i++) {
			System.out.print("|");
		}
		System.out.print("<<th2종료>>");
	}
}

class ThreadEx9_1 extends Thread{
	public void run() {
		int i = 10;
		
		while(i!=0 && !isInterrupted()) {
			System.out.println(i--);
			for(long x = 0; x < 2500000000L; x++); // 시간 지연
		}
		System.out.println("카운트가 종료되었습니다.");
	}
}
/* 스레드의 실행 제어
 * 
 * sleep()
 *   - 현재 스레드를 지정된 시간동안 멈추게 한다.
 *   - static메서드 이므로 자기 자신한테만 동작한다. (다른 스레드는 지정해도 자기자신이 잔다.)
 *     static void sleep(long millis)
 *   - 예외 처리를 해야한다. (InterruptedException이 발생하면 sleep에서 빠져나온다.)
 *     try{
 *         Thread.sleep(3000); >> 누군가 깨우면 예외를 던져지기 때문에 예외처리 필수!
 *     } catch(InterruptedException e){} >> Exception의 자식이기 때문에 필수로 예외처리를 해줘야한다.
 *     
 *     sleep이 종료되는 경우
 *     1. time up (시간이 끝났을때)
 *     2. interrupted (누군가 깨웠을때)
 *     
 *     만약 sleep()을 사용할때 매번 예외처리하는게 귀찮을때는 메서드를 따로 만들어주면 된다.
 *     void delay(long millis){
 *         try{
 *             Thread.sleep(millis);
 *         }catch(InterruptedException e){}
 *     }
 *     
 *     delay(3000); == 첫번째 작성된 것과 같은 거다.
 *     
 * interrupt()
 *   - 대기상태(Waiting == 작업 중단(예로 sleep, join)인 스레드를 실행대기 상태(Runnable)로 만든다.
 *     void interrupt() >> 스레드의 interrupt상태를 false에서 true로 바꿔준다.
 *     boolean isInterrupted() >> 스레드의 interrupted상태를 반환한다.
 *     static boolean interrupted() >> 현재 스레드의 interrupted상태를 알려주고 false로 초기화 한다. 
 */
