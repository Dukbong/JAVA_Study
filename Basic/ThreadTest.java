
public class ThreadTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreadEx1_1 t1 = new ThreadEx1_1();
		
		Runnable r = new ThreadEx1_2();
		Thread t2 = new Thread(r);
		// Thread t2 = new Thread(new ThreadEx1_2()); 
		
		// start()는 시작이 아닌 준비완료
		t1.start();
		t2.start();
		// OS스케줄러에 의해 실행된다. (어느게 먼저 실행될지 모른다는 말이다.)
		// 실행마다 결과가 다르다.
	}

}
class ThreadEx1_1 extends Thread{ // 상속으로 쓰레드  구현
	public void run() {
		for(int i = 0; i < 100; i++) {
			// System.out.println(getName()); // 부모인 Thread의 getName()을 호출
			System.out.print(0);
		}
	}
}

class ThreadEx1_2 implements Runnable{ // 인터페이스 구현해서 쓰레드 구현
	public void run() {
		for(int i = 0; i < 100; i++) {
			// Thread.currentThread() - 현재 실행중인 Thread를 반환한다.
			// System.out.println(Thread.currentThread().getName());
			System.out.print(1);
		}
	}
}
/* 프로세스와 쓰레드 (Process & Thread)
 * 프로세스란? 실행 중인 프로그램, 자원(resources)과 쓰레드로 구성
 *   - 자원은 메모리, cpu ... 등등등 이런것이다.
 * 쓰레드란? 프로세스 내에서 실제 작업을 수행하는 것을 말한다.
 *   - 모든 프로세스는 최소한 하나의 쓰레드를 가지고 있다.
 *   
 * 프로세스 : 쓰레드 = 공장 : 일꾼  >> 이해를 돕기 위해 
 * 
 * 싱글 쓰레드 프로세스  = 자원 + 쓰레드
 * 멀티 쓰레드 프로세스  = 자원 + 쓰레드1 + 쓰레드2 ... 쓰레드N >> 실제 프로그램은 멀티 쓰레드로 만들어진다.
 * 
 * 하나의 새로운 프로세스를 생성하는 것보다 하나의 새로운 쓰레드를 생성하는 것이 더 적은 비용이 든다.
 *   - 싱글 쓰레드 2개 vs 멀티쓰레드 1개 (쓰레드 2개) >> 멀티쓰레드 WIN!
 *   
 * 멀티 쓰레드의 장단점
 *   - 장점
 *     - 1. 시스템 자원을 보다 효율적으로 사용할 수 있다.
 *     - 2. 사용자에 대한 응답성이 향상된다.
 *     - 3. 작업이 분리되어 코드가 간결해진다.
 *   - 단점
 *     - 1. 동기화에 주의해야한다.
 *     - 2. 교착상태(dead-lock)가 발생하지 않도록 주의해야한다.
 *       - 1번과 2번은 자원을 각 쓰레드가 공유하다가 발생할 수 있는 문제이다.
 *     - 3. 각 쓰레드가 효율적으로 고르게 실행될 수 있게 해야 한다.
 *     - 결론 : 프로그래밍 할 때 고려해야 하는 사항들이 많다...
 *     
 * 쓰레드의 구현과 실행
 *   - 상속과 구현 두가지 방법이 있는데 상속보다는 구현이 더 깔끔하게 만들 수 있다.
 * 1. Thread 클래스를 상속
 *   class MyThread extends Thread{
 *       public void run(){ >> Thread클래스의 run() 오버라이딩
 *           작업내용
 *       }
 *   }
 *   사용할때
 *   MyThread t1 = new MyThread(); // 쓰레드 생성
 *   t1.start(); // 쓰레드 실행
 * 
 * 2. Runnable 인터페이스 구현 (WIN!)
 *   class MyThread implements Runnable{
 *       public void (){ >> Runnable 인터페이스의 추상 메서드 run() 구현
 *           작업 내용
 *       }
 *   }
 *   사용할떄
 *   Runnable r = new MyThread();
 *   Thread t2 = new Thread(r); // Thread(Runnable r)
 *   // Thread t2 = new Thread(new MyThread());
 *   t2.start(); // 쓰레드 실행
 *   
 * 쓰레드의 실행 - start()
 *   - 쓰레드를 생성한 후에 start()를 호출해야 쓰레드가 작업을 시작한다.
 *     ThreadEx1_1 t1 = new ThreadEx1_1();
 *     ThreadEx1_1 t2 = new ThreadEx1_1();
 *     
 *     t1.start();
 *     t2.start();
 *     >> start()는 시작이 아닌 시작할 준비 완료다.
 *     >> t1, t2 어느게 언제 실행될지 OS스케줄러가 실행순서가 결정한다.
 *     >> t1이 먼저 준비 됬다고 먼저 사용된다는 보장은 없다.
 *     
 * start()와 run()
 *   - run()을 구현하지만 호출은 start()를 하고 있다. 왜 그런지 알아보자
 *   
 *   1. CallStack : start() 메서드가 새로운 CallStack을 생성한다.
 *      
 *      |       |
 *      +-------+
 *      | start |
 *      +-------+
 *      | main  |
 *      +-------+
 *      
 *   2. CallStack
 *   
 *      |       |       |       |    
 *      +-------+       |       |
 *      | start |       |       |
 *      +-------+       |       |  
 *      | main  |       |       |
 *      +-------+       +-------+
 *   
 *   3. CallStack : start()는 새로운 CallStack 만들고 종료 
 *     - 서로 독립적으로 작업수행
 *   
 *      |       |       |       |    
 *      |       |       |       |
 *      |       |       |       |
 *      +-------+       +-------+  
 *      | main  |       | run   |
 *      +-------+       +-------+   
 */