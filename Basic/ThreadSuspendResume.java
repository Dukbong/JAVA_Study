
public class ThreadSuspendResume {

	public static void main(String[] args) {
		// 예제 1
		RunImplEx10 r = new RunImplEx10();
		Thread th1 = new Thread(r, "*");
		Thread th2 = new Thread(r, "**");
		Thread th3 = new Thread(r, "***");
		th1.start();
		th2.start();
		th3.start();
		
		try {
			Thread.sleep(2000);
			th1.suspend();
			Thread.sleep(2000);
			th2.suspend();
			Thread.sleep(3000);
			th1.resume();
			Thread.sleep(3000);
			th1.stop();
			th2.stop();
			Thread.sleep(2000);
			th3.stop();
		}catch(InterruptedException e) {}
		// 예제 1번의 deprecated 메서드  직접 구현해서 사용하기
		MyThread th4 = new MyThread("^");
		MyThread th5 = new MyThread("^^");
		MyThread th6 = new MyThread("^^^");
		th4.start();
		th5.start();
		th6.start();
		
		try {
			Thread.sleep(2000);
			th4.suspend();
			Thread.sleep(2000);
			th5.suspend();
			Thread.sleep(3000);
			th4.resume();
			Thread.sleep(3000);
			th4.stop();
			th5.stop();
			Thread.sleep(2000);
			th6.stop();
		}catch(InterruptedException e) {}
		
	}
}
class RunImplEx10 implements Runnable{
	public void run() {
		while(true) {
			System.out.println(Thread.currentThread().getName());
			try {
				Thread.sleep(1000);
			}catch(InterruptedException e) {}
		}
	}
}

class MyThread implements Runnable{
	volatile boolean suspended = false;
	volatile boolean stopped = false;
	// volatile은 쉽게 바뀌는 변수를 의미한다.
	
	// RAM에 저장되어 있는 변수 값을 cpu에서 빠른 작업을 위해 복사본을 가지고 있다.
	// 하지만 그 변수 값이 바뀔때 cpu가 원본이랑 같은 걸 가지고 있지 않을 수 있다.
	// volatile을 사용하면 cpu가 복사본이 아닌 원본만 읽어오도록 한다.
	
	Thread th;
	
	MyThread(String name){
		th = new Thread(this, name); // Thread(Runnable r, String name)
	}
	
	void start() {th.start();}
	void stop() {stopped = true;}
	void suspend() {suspended = true;}
	void resume() {suspended = false;}
	
	public void run() {
		while(!stopped) {
			if(!suspended) {
				System.out.println(Thread.currentThread().getName());
				try {
					Thread.sleep(1000);
				}catch(InterruptedException e) {}
			}
		}
	}
}
/* 스레드의 실행을 일시정지(suspend()), 재개(resume()), 완전정지(stop())에 대해 알아보기
 *   void suspend() >> 스레드를 일시정지 시킨다.
 *   void resume() >> suspend()에 의해 일시정지 된 스레드를 실행 대기 상태로 만든다.
 *   void stop() >> 스레드를 즉시 종료시킨다.
 *     - 위 세개 메서드는 deprecated 사용을 권장하지 않는 상태이다.
 *       - 이유는 dead-lock(교착상태)가 발생하기 때문이다.
 *       
 * 하지만 간단하게 직접 만들면 된다.
 *   class ThreadTest implements Runnable{
 *       boolean suspended = false;
 *       boolean stopped = false;
 *       
 *       public void run(){
 *           while(!stopped){
 *               if(!suspended){
 *                   스레드가 수행할 코드 작성
 *               }
 *           }
 *       }
 *       
 *       public void suspend(){suspended = true;}
 *       public void resume(){suspended = false;}
 *       public void stop(){stopped = true;}
 *   }
 */