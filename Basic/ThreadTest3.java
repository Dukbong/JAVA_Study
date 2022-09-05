
public class ThreadTest3 implements Runnable {
	
	static boolean autoSave = false;

	public static void main(String[] args) {
		// 예제 1
		ThreadEx6_1 th1 = new ThreadEx6_1();
		Thread th2 = new Thread(new ThreadEx6_2());
		
		th2.setPriority(7);
		
		System.out.println("Priority of th1(-) = " + th1.getPriority());
		System.out.println("Priority of th2(|) = " + th2.getPriority());
		
		th1.start();
		th2.start();
		
		// 예제 2 (데몬 스레드)
		// 일반 스레드 ==================================
		Thread th3 = new Thread(new ThreadTest3());
		th3.setDaemon(true);
		th3.start();
		
		for(int i = 1; i <= 10; i++) {
			try {
				Thread.sleep(1000);
			}catch(InterruptedException e) {}
			System.out.println(i);
			
			if(i == 5)autoSave = true;
		}
		System.out.println("프로그래밍을 종료합니다.");
		// 일반 스레드 ==================================

	}
	// 데몬 스레드 (보조)==================================
	//  - 일반스레드가 없으면 자동 종료된다.
	public void run() {
		while(true) {
			try {
				Thread.sleep(3*1000);
			}catch(InterruptedException e) {}
			
			if(autoSave) {
				autoSave();
			}
		}
	}
	// 데몬 스레드 (보조)==================================
	
	public void autoSave() {
		System.out.println("작업 파일이 자동 저장 되었습니다.");
	}
}
class ThreadEx6_1 extends Thread{
	public void run() {
		for(int i = 0; i < 300; i++) {
			System.out.print("-");
			for (int x = 0; x < 1000000; x++); // 시간 지연 용으로 작성한 것(아무 의미 없음)
		}
	}
}

class ThreadEx6_2 implements Runnable{
	public void run() {
		for(int i = 0; i < 300; i++) {
			System.out.print("|");
			for(int x = 0; x < 1000000; x++);
		}
	}
}
/*
* 스레드의 우선 순위 (희망사항이다. 우선 순위를 지정했다고 이론처럼 되진 않는다.)
*   - 작업의 중요도에 따라 스레드의 우선순위를 다르게 하여 특정 스레드가 더 많은 작업시간을 갖게 한다.
*   - 자바에서는 우선순위를 1~10까지 지정해 줄 수 있다.
*     - JVM에서 정해둔 우선순위지만 OS에서는 32단계까지 있다.
*     void setPriority(int newPriority) >> 스레드의 우선순위를 지정한 값으로 변경한다.
*     int getPriority() >> 스레드의 우선순위를 반환한다.
*     
*     public static final int MAX_PRIORITY = 10; // 최대 우선순위 (제일 좋은거)
*     public static final int MIN_PRIORITY = 1; // 최소 우선순위
*     public static final int NORM_PRIORITY = 5; // 보통 우선순위 (기본값)
*   - 예를 들어 스레드1과 스레드2의 우선순위가 같다면 두 스레드는 같은 시간만큼 번갈아 가며 실행된다.
*     - 스레드1이 우선순위가 높다면 스레드1의 작업시간을 늘려서 번갈아 가며 실행되게 된다.
*     
*   - 결론은 우선순위가 높은 스레드가 빨리 종료될 확률이 좀더 높은 정도이다.
*   
* 스레드 그룹
*   - 서로 관련된 스레드를 그룹으로 묶어서 다루기 위한것
*   - 모든 스레드는 반드시 하나의 스레드 그룹에 포함되어야 한다.
*   - 스레드 그룹을 지정하지 않았을 경우 "main 스레드 그룹"에 속한다.
*   - 자신을 생성한 스레드(부모 스레드)의 그룹과 우선순위를 상속받는다.
*     Thread(ThreadGroup group, String name)
*     Thread(ThreadGroup group, Runnable target)
*     Thread(ThreadGroup group, Runnable target, String name)
*     Thread(ThreadGroup group, Runnable target, String name, long stackSize)
*     
*     ThreadGroup getThreadGroup() >> 스레드 자신이 속한 그룹을 반환한다. (Thread 클래스에 있는 메서드)
*     void uncaughtException(Thread t, Throwable e)
*     >> 처리되지 않은 예외에 의해 스레드 그룹의 스레드가 종료되었을때, JVM에 의해 이 메서드가 자동적으로 호출된다.
* 
* 데몬 스레드(daemon Thread)
*   - 일반 스레드의 작업을 돕는 보조적인 역할을 수행
*   - 일반 스레드가 모두 종료되면 자동적으로 종료된다.
*   - 가비지 컬렉터, 자동저장, 화면 자동갱신 등에 사용된다.
*   - 무한 루프와 조건문을 이용해서 실행 후 대기하다가 특정조건이 만족되면 작업을 수행하고 다시 대기하도록 작성한다.
*     public void run(){
*         while(true){
*             try{
*                 Thread.sleep(3*1000); // 3초마다
*             }catch(InterruptedException e){}
*         
*             if(autoSave){ // autoSave의 값이 true이며 autoSave()를 호출한다.
*                 autoSave();
*             }
*         }
*     }
*   - boolean isDaemon() >> 스레드가 데몬 스레드인지 확인한다. 데몬 스레드이면 true를 반환
*   - void setDaemon(boolean on) >> 스레드를 데몬 스레드로 또는 사용자 스레드로 변경
*     >> 매개변수 on을 true로 지정하면 Daemon스레드가 된다.
*     >> 반드시 start()를 호출하기 전에 실행되어야 한다.
*     >> 그렇지 않을 경우 IllegalThreadStateException이 발생한다.
*     
* 스레드의 상태
*   - NEW >> 스레드가 생성되고, 아직 start()가 호출되지 않은 상태
*   - RUNNABLE >> 실행 중 또는 실행가능한 상태 
*     - start()하면 RUNNABLE 상태가 된다.
*   - BLOCKED >> 동기화 블럭에 의해서 일시정지된 상태
*   - WAITING, TIMED_WAITING >> 스레드의 작업이 종료되지는 않았지만 실행 가능하지 않은 일시정지상태, TIMED_WAITING은 일시정 지 시간이 지정된 경우를 의미
*   - TERMINATED >> 스레드의 작업이 종료된 상태 
*     - stop() 메서드를 호출거나 코드가 끝나는 경우
*     
* 스레드의 실행제어
*   - 스레드의 실행을 제어할 수 있는 메서드가 제공된다.
*   - static void sleep(long millis)
*   - static void sleep(long millis, int narnos)
*     >> 지정된 시간 (천분의 일초)동안 스레드를 일시정지(잠들게) 시킨다.
*     >> 지정된 시간이 지나고 나면 자동적으로 다시 실행대기상태가 된다.
*   - void join()
*   - void join(long millis)
*   - void join(long millis, int nanos)
*     >> 지정된 시간동안 스레드가 실행되도록 한다.
*     >> 지정된 시간이 지나거나 작업이 종료되면 join()을 호출한 스레드로 다시 돌아와 실행을 계속한다.
*   - void interrupt()
*     >> sleep()이나 join()에 의해 일시정지 상태인 스레드를 깨운서 실행 대기 상태로 만든다.
*     >> 해당 스레드에서는 interruptedException이 발생함으로써 일시정지를 벗어나게 해준다.
*   - void stop()
*     >> 스레드를 즉시 종료시킨다.
*   - void susspend()
*     >> 스레드를 일시정지 시킨다. resum()을 호출하면 다시 실행대기 상태가 된다.
*   - void resume()
*     >> suspend()에 의해 일시정지에 있는 스레드 실행대기 상태가 된다.
*   - static void yield()
*     >> 실행 중 자신에게 조어진 실행시간을 다른 스레드에게 양보하고 자신은 실행대기상태가 된다.
*     
*   - static이 붙은 sleep, yield는 자기 자신에게만 호출 가능하다.
*/