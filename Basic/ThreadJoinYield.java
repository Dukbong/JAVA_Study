
public class ThreadJoinYield {

	public static void main(String[] args) {
		// 예제 1
		ThreadEx13_2 th1 = new ThreadEx13_2();
		ThreadEx13_3 th2 = new ThreadEx13_3();
		th1.start();
		th2.start();
		startTime = System.currentTimeMillis(); // 현재 시간
		// 시작 시간을 알기위한 작업
		
		try {
			th1.join();
			th2.join();
		}catch(InterruptedException e) {}
		
		System.out.println("소요시간 = " + (System.currentTimeMillis() - startTime));
	}
	static long startTime = 0;
}
class ThreadEx13_2 extends Thread{
	public void run() {
		for(int i = 0; i < 300; i++) {
			System.out.print("-");
		}
	}
}
class ThreadEx13_3 extends Thread{
	public void run() {
		for(int i = 0; i < 300; i++) {
			System.out.print("|");
		}
	}
}

class ThreadEx13_4 implements Runnable{
	boolean suspended = false;
	boolean stopped = false;
	Thread th;
	ThreadEx13_4(String name){
		th = new Thread(this, name);
	}
	void start() {
		th.start();
	}
	void suspend() {
		suspended = true;
		th.interrupt();
	}
	void resume() {
		suspended = false;
	}
	void stop() {
		stopped = true;
		th.interrupt();
	}
	public void run() {
		while (!stopped) {
			if(!suspended) { // suspended가 false일 경우 할당받은 시간을 아무것도 하지 않은채 흘러보내야한다.
				System.out.println("스레드 소스 코드 수행 중 ...");
			}else {
				Thread.yield();
				// 아무것도 않하는 시간 낭비를 줄이기 위해 yield를 통해 다음 순서에게 해당 스레드의 시간을 양보한다.
				// 하지만 OS 스케줄러에게 통보하는 용도이기 때문에 정확히 시간을 양보하지 않는다.
			}
		}
	}
}
/* join()
 *   - 지정된 시간 동안 특정 스레드가 작업하는 것을 기다린다.
 *     void join() >> 작업이 모두 끝날까지 기다린다.
 *     void join(long millis) >> 시간(millis)만큰 기다린다.
 *     void join(long millis, int nanos) >> 시간(millis + nanos)만큼 기다린다.
 *   - 필수로 예외처리를 해줘야 한다.
 *     try{
 *         th1.join(); >> main스레드가 th1의 작업이 끝날때 까지 기다린다.
 *         th2.join(); >> main스레드가 th2의 작업이 끝날때 까지 기다린다.
 *     }catch(InterruptedException e){}
 *   - 예시
 *     public void run(){
 *         while(true){
 *             try{
 *                 Thread.sleep(2000);
 *             }catch(InterruptedException e){
 *                 System.out.println("Awaken by interrupt().");
 *             }
 *             
 *             gc(); // 가바시 컬렉터를 수행한다.
 *             System.out.println("GC. Free Memory = " + freeMemory()
 *         }
 *     }
 *   - 예시 2 가비지 컬렉터의 기능 구현해보기
 *     for(int i = 0; i < 20; i++){
 *         int requireMemory = (int)(Math.random()*10)+20;
 *         if(gc.freeMemory() < requiredMemory || gc.freeMemory() < gc.totalMemory() * 0.4){
 *             gc.interrupt(); // 잠자고 있는 gc를 깨운다.
 *             try{
 *                 gc.join(100); // join을 해주느 이유는 gc를 깨우고 작업할 시간을 주기 위함이다.
 *             }catch(Interrupted e){}
 *             
 *             gc.usedMemory = gc.usedMemory + requiredMemory;
 *             System.out.println("usedMemory = " + gc.usedMemory);
 *         }
 *     }
 *     
 * yield() - static 메서드이다.
 *   - 남은 시간을 다음 스레드에게 양보하고 자신은 실행 대기 한다.
 *   - OS 스케줄러에게 통보하는 거기 때문에 양보를 할수 도 있고 안할 수 도 있다.
 *     class Test implements Runnable{
 *         boolean suspended = false;
 *         boolean stopped = false;
 *         
 *         Thread th;
 *         
 *         Test(String name){
 *             th = new Thread(this, name); // Thread(Runnable r, name)
 *         }
 *         
 *         public void start(){th.start();}
 *         public void resume(){suspended = false;}
 *         public void suspend(){
 *             suspended = true;
 *             th.interrupt();
 *         }
 *         public void stop(){
 *             stopped = true;
 *             th.interrupt();
 *         }
 *         
 *         public void run(){
 *             while(!stopped){
 *                 if(!suspended){
 *                     작업수행
 *                     try{
 *                         Thread.sleep(3000);
 *                     }catch(InterruptedException e){}
 *                 }else{ // 이게 없는 상태에서 suspended가 true가 된다면 하는일 없이 시간을 사용하게 된다.
 *                 // 이런 경우를 busy-waiting이라고 하며 이럴때 yield로 다음 차례에게 시간을 양보할 수 있다.
 *                     Thread.yield();
 *                 }
 *             }
 *         }
 *     }
 *   
 */