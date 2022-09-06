
public class ThreadJoinYield {

	public static void main(String[] args) {
		// ���� 1
		ThreadEx13_2 th1 = new ThreadEx13_2();
		ThreadEx13_3 th2 = new ThreadEx13_3();
		th1.start();
		th2.start();
		startTime = System.currentTimeMillis(); // ���� �ð�
		// ���� �ð��� �˱����� �۾�
		
		try {
			th1.join();
			th2.join();
		}catch(InterruptedException e) {}
		
		System.out.println("�ҿ�ð� = " + (System.currentTimeMillis() - startTime));
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
			if(!suspended) { // suspended�� false�� ��� �Ҵ���� �ð��� �ƹ��͵� ���� ����ä �귯�������Ѵ�.
				System.out.println("������ �ҽ� �ڵ� ���� �� ...");
			}else {
				Thread.yield();
				// �ƹ��͵� ���ϴ� �ð� ���� ���̱� ���� yield�� ���� ���� �������� �ش� �������� �ð��� �纸�Ѵ�.
				// ������ OS �����ٷ����� �뺸�ϴ� �뵵�̱� ������ ��Ȯ�� �ð��� �纸���� �ʴ´�.
			}
		}
	}
}
/* join()
 *   - ������ �ð� ���� Ư�� �����尡 �۾��ϴ� ���� ��ٸ���.
 *     void join() >> �۾��� ��� �������� ��ٸ���.
 *     void join(long millis) >> �ð�(millis)��ū ��ٸ���.
 *     void join(long millis, int nanos) >> �ð�(millis + nanos)��ŭ ��ٸ���.
 *   - �ʼ��� ����ó���� ����� �Ѵ�.
 *     try{
 *         th1.join(); >> main�����尡 th1�� �۾��� ������ ���� ��ٸ���.
 *         th2.join(); >> main�����尡 th2�� �۾��� ������ ���� ��ٸ���.
 *     }catch(InterruptedException e){}
 *   - ����
 *     public void run(){
 *         while(true){
 *             try{
 *                 Thread.sleep(2000);
 *             }catch(InterruptedException e){
 *                 System.out.println("Awaken by interrupt().");
 *             }
 *             
 *             gc(); // ���ٽ� �÷��͸� �����Ѵ�.
 *             System.out.println("GC. Free Memory = " + freeMemory()
 *         }
 *     }
 *   - ���� 2 ������ �÷����� ��� �����غ���
 *     for(int i = 0; i < 20; i++){
 *         int requireMemory = (int)(Math.random()*10)+20;
 *         if(gc.freeMemory() < requiredMemory || gc.freeMemory() < gc.totalMemory() * 0.4){
 *             gc.interrupt(); // ���ڰ� �ִ� gc�� �����.
 *             try{
 *                 gc.join(100); // join�� ���ִ� ������ gc�� ����� �۾��� �ð��� �ֱ� �����̴�.
 *             }catch(Interrupted e){}
 *             
 *             gc.usedMemory = gc.usedMemory + requiredMemory;
 *             System.out.println("usedMemory = " + gc.usedMemory);
 *         }
 *     }
 *     
 * yield() - static �޼����̴�.
 *   - ���� �ð��� ���� �����忡�� �纸�ϰ� �ڽ��� ���� ��� �Ѵ�.
 *   - OS �����ٷ����� �뺸�ϴ� �ű� ������ �纸�� �Ҽ� �� �ְ� ���� �� �� �ִ�.
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
 *                     �۾�����
 *                     try{
 *                         Thread.sleep(3000);
 *                     }catch(InterruptedException e){}
 *                 }else{ // �̰� ���� ���¿��� suspended�� true�� �ȴٸ� �ϴ��� ���� �ð��� ����ϰ� �ȴ�.
 *                 // �̷� ��츦 busy-waiting�̶�� �ϸ� �̷��� yield�� ���� ���ʿ��� �ð��� �纸�� �� �ִ�.
 *                     Thread.yield();
 *                 }
 *             }
 *         }
 *     }
 *   
 */