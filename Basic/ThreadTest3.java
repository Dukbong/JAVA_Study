
public class ThreadTest3 implements Runnable {
	
	static boolean autoSave = false;

	public static void main(String[] args) {
		// ���� 1
		ThreadEx6_1 th1 = new ThreadEx6_1();
		Thread th2 = new Thread(new ThreadEx6_2());
		
		th2.setPriority(7);
		
		System.out.println("Priority of th1(-) = " + th1.getPriority());
		System.out.println("Priority of th2(|) = " + th2.getPriority());
		
		th1.start();
		th2.start();
		
		// ���� 2 (���� ������)
		// �Ϲ� ������ ==================================
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
		System.out.println("���α׷����� �����մϴ�.");
		// �Ϲ� ������ ==================================

	}
	// ���� ������ (����)==================================
	//  - �Ϲݽ����尡 ������ �ڵ� ����ȴ�.
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
	// ���� ������ (����)==================================
	
	public void autoSave() {
		System.out.println("�۾� ������ �ڵ� ���� �Ǿ����ϴ�.");
	}
}
class ThreadEx6_1 extends Thread{
	public void run() {
		for(int i = 0; i < 300; i++) {
			System.out.print("-");
			for (int x = 0; x < 1000000; x++); // �ð� ���� ������ �ۼ��� ��(�ƹ� �ǹ� ����)
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
* �������� �켱 ���� (��������̴�. �켱 ������ �����ߴٰ� �̷�ó�� ���� �ʴ´�.)
*   - �۾��� �߿䵵�� ���� �������� �켱������ �ٸ��� �Ͽ� Ư�� �����尡 �� ���� �۾��ð��� ���� �Ѵ�.
*   - �ڹٿ����� �켱������ 1~10���� ������ �� �� �ִ�.
*     - JVM���� ���ص� �켱�������� OS������ 32�ܰ���� �ִ�.
*     void setPriority(int newPriority) >> �������� �켱������ ������ ������ �����Ѵ�.
*     int getPriority() >> �������� �켱������ ��ȯ�Ѵ�.
*     
*     public static final int MAX_PRIORITY = 10; // �ִ� �켱���� (���� ������)
*     public static final int MIN_PRIORITY = 1; // �ּ� �켱����
*     public static final int NORM_PRIORITY = 5; // ���� �켱���� (�⺻��)
*   - ���� ��� ������1�� ������2�� �켱������ ���ٸ� �� ������� ���� �ð���ŭ ������ ���� ����ȴ�.
*     - ������1�� �켱������ ���ٸ� ������1�� �۾��ð��� �÷��� ������ ���� ����ǰ� �ȴ�.
*     
*   - ����� �켱������ ���� �����尡 ���� ����� Ȯ���� ���� ���� �����̴�.
*   
* ������ �׷�
*   - ���� ���õ� �����带 �׷����� ��� �ٷ�� ���Ѱ�
*   - ��� ������� �ݵ�� �ϳ��� ������ �׷쿡 ���ԵǾ�� �Ѵ�.
*   - ������ �׷��� �������� �ʾ��� ��� "main ������ �׷�"�� ���Ѵ�.
*   - �ڽ��� ������ ������(�θ� ������)�� �׷�� �켱������ ��ӹ޴´�.
*     Thread(ThreadGroup group, String name)
*     Thread(ThreadGroup group, Runnable target)
*     Thread(ThreadGroup group, Runnable target, String name)
*     Thread(ThreadGroup group, Runnable target, String name, long stackSize)
*     
*     ThreadGroup getThreadGroup() >> ������ �ڽ��� ���� �׷��� ��ȯ�Ѵ�. (Thread Ŭ������ �ִ� �޼���)
*     void uncaughtException(Thread t, Throwable e)
*     >> ó������ ���� ���ܿ� ���� ������ �׷��� �����尡 ����Ǿ�����, JVM�� ���� �� �޼��尡 �ڵ������� ȣ��ȴ�.
* 
* ���� ������(daemon Thread)
*   - �Ϲ� �������� �۾��� ���� �������� ������ ����
*   - �Ϲ� �����尡 ��� ����Ǹ� �ڵ������� ����ȴ�.
*   - ������ �÷���, �ڵ�����, ȭ�� �ڵ����� � ���ȴ�.
*   - ���� ������ ���ǹ��� �̿��ؼ� ���� �� ����ϴٰ� Ư�������� �����Ǹ� �۾��� �����ϰ� �ٽ� ����ϵ��� �ۼ��Ѵ�.
*     public void run(){
*         while(true){
*             try{
*                 Thread.sleep(3*1000); // 3�ʸ���
*             }catch(InterruptedException e){}
*         
*             if(autoSave){ // autoSave�� ���� true�̸� autoSave()�� ȣ���Ѵ�.
*                 autoSave();
*             }
*         }
*     }
*   - boolean isDaemon() >> �����尡 ���� ���������� Ȯ���Ѵ�. ���� �������̸� true�� ��ȯ
*   - void setDaemon(boolean on) >> �����带 ���� ������� �Ǵ� ����� ������� ����
*     >> �Ű����� on�� true�� �����ϸ� Daemon�����尡 �ȴ�.
*     >> �ݵ�� start()�� ȣ���ϱ� ���� ����Ǿ�� �Ѵ�.
*     >> �׷��� ���� ��� IllegalThreadStateException�� �߻��Ѵ�.
*     
* �������� ����
*   - NEW >> �����尡 �����ǰ�, ���� start()�� ȣ����� ���� ����
*   - RUNNABLE >> ���� �� �Ǵ� ���డ���� ���� 
*     - start()�ϸ� RUNNABLE ���°� �ȴ�.
*   - BLOCKED >> ����ȭ ���� ���ؼ� �Ͻ������� ����
*   - WAITING, TIMED_WAITING >> �������� �۾��� ��������� �ʾ����� ���� �������� ���� �Ͻ���������, TIMED_WAITING�� �Ͻ��� �� �ð��� ������ ��츦 �ǹ�
*   - TERMINATED >> �������� �۾��� ����� ���� 
*     - stop() �޼��带 ȣ��ų� �ڵ尡 ������ ���
*     
* �������� ��������
*   - �������� ������ ������ �� �ִ� �޼��尡 �����ȴ�.
*   - static void sleep(long millis)
*   - static void sleep(long millis, int narnos)
*     >> ������ �ð� (õ���� ����)���� �����带 �Ͻ�����(����) ��Ų��.
*     >> ������ �ð��� ������ ���� �ڵ������� �ٽ� ��������°� �ȴ�.
*   - void join()
*   - void join(long millis)
*   - void join(long millis, int nanos)
*     >> ������ �ð����� �����尡 ����ǵ��� �Ѵ�.
*     >> ������ �ð��� �����ų� �۾��� ����Ǹ� join()�� ȣ���� ������� �ٽ� ���ƿ� ������ ����Ѵ�.
*   - void interrupt()
*     >> sleep()�̳� join()�� ���� �Ͻ����� ������ �����带 ��� ���� ��� ���·� �����.
*     >> �ش� �����忡���� interruptedException�� �߻������ν� �Ͻ������� ����� ���ش�.
*   - void stop()
*     >> �����带 ��� �����Ų��.
*   - void susspend()
*     >> �����带 �Ͻ����� ��Ų��. resum()�� ȣ���ϸ� �ٽ� ������ ���°� �ȴ�.
*   - void resume()
*     >> suspend()�� ���� �Ͻ������� �ִ� ������ ������ ���°� �ȴ�.
*   - static void yield()
*     >> ���� �� �ڽſ��� ������ ����ð��� �ٸ� �����忡�� �纸�ϰ� �ڽ��� ��������°� �ȴ�.
*     
*   - static�� ���� sleep, yield�� �ڱ� �ڽſ��Ը� ȣ�� �����ϴ�.
*/