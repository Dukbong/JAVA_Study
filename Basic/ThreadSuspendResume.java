
public class ThreadSuspendResume {

	public static void main(String[] args) {
		// ���� 1
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
		// ���� 1���� deprecated �޼���  ���� �����ؼ� ����ϱ�
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
	// volatile�� ���� �ٲ�� ������ �ǹ��Ѵ�.
	
	// RAM�� ����Ǿ� �ִ� ���� ���� cpu���� ���� �۾��� ���� ���纻�� ������ �ִ�.
	// ������ �� ���� ���� �ٲ� cpu�� �����̶� ���� �� ������ ���� ���� �� �ִ�.
	// volatile�� ����ϸ� cpu�� ���纻�� �ƴ� ������ �о������ �Ѵ�.
	
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
/* �������� ������ �Ͻ�����(suspend()), �簳(resume()), ��������(stop())�� ���� �˾ƺ���
 *   void suspend() >> �����带 �Ͻ����� ��Ų��.
 *   void resume() >> suspend()�� ���� �Ͻ����� �� �����带 ���� ��� ���·� �����.
 *   void stop() >> �����带 ��� �����Ų��.
 *     - �� ���� �޼���� deprecated ����� �������� �ʴ� �����̴�.
 *       - ������ dead-lock(��������)�� �߻��ϱ� �����̴�.
 *       
 * ������ �����ϰ� ���� ����� �ȴ�.
 *   class ThreadTest implements Runnable{
 *       boolean suspended = false;
 *       boolean stopped = false;
 *       
 *       public void run(){
 *           while(!stopped){
 *               if(!suspended){
 *                   �����尡 ������ �ڵ� �ۼ�
 *               }
 *           }
 *       }
 *       
 *       public void suspend(){suspended = true;}
 *       public void resume(){suspended = false;}
 *       public void stop(){stopped = true;}
 *   }
 */