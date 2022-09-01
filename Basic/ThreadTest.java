
public class ThreadTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreadEx1_1 t1 = new ThreadEx1_1();
		
		Runnable r = new ThreadEx1_2();
		Thread t2 = new Thread(r);
		// Thread t2 = new Thread(new ThreadEx1_2()); 
		
		// start()�� ������ �ƴ� �غ�Ϸ�
		t1.start();
		t2.start();
		// OS�����ٷ��� ���� ����ȴ�. (����� ���� ������� �𸥴ٴ� ���̴�.)
		// ���ึ�� ����� �ٸ���.
	}

}
class ThreadEx1_1 extends Thread{ // ������� ������  ����
	public void run() {
		for(int i = 0; i < 100; i++) {
			// System.out.println(getName()); // �θ��� Thread�� getName()�� ȣ��
			System.out.print(0);
		}
	}
}

class ThreadEx1_2 implements Runnable{ // �������̽� �����ؼ� ������ ����
	public void run() {
		for(int i = 0; i < 100; i++) {
			// Thread.currentThread() - ���� �������� Thread�� ��ȯ�Ѵ�.
			// System.out.println(Thread.currentThread().getName());
			System.out.print(1);
		}
	}
}
/* ���μ����� ������ (Process & Thread)
 * ���μ�����? ���� ���� ���α׷�, �ڿ�(resources)�� ������� ����
 *   - �ڿ��� �޸�, cpu ... ���� �̷����̴�.
 * �������? ���μ��� ������ ���� �۾��� �����ϴ� ���� ���Ѵ�.
 *   - ��� ���μ����� �ּ��� �ϳ��� �����带 ������ �ִ�.
 *   
 * ���μ��� : ������ = ���� : �ϲ�  >> ���ظ� ���� ���� 
 * 
 * �̱� ������ ���μ���  = �ڿ� + ������
 * ��Ƽ ������ ���μ���  = �ڿ� + ������1 + ������2 ... ������N >> ���� ���α׷��� ��Ƽ ������� ���������.
 * 
 * �ϳ��� ���ο� ���μ����� �����ϴ� �ͺ��� �ϳ��� ���ο� �����带 �����ϴ� ���� �� ���� ����� ���.
 *   - �̱� ������ 2�� vs ��Ƽ������ 1�� (������ 2��) >> ��Ƽ������ WIN!
 *   
 * ��Ƽ �������� �����
 *   - ����
 *     - 1. �ý��� �ڿ��� ���� ȿ�������� ����� �� �ִ�.
 *     - 2. ����ڿ� ���� ���伺�� ���ȴ�.
 *     - 3. �۾��� �и��Ǿ� �ڵ尡 ����������.
 *   - ����
 *     - 1. ����ȭ�� �����ؾ��Ѵ�.
 *     - 2. ��������(dead-lock)�� �߻����� �ʵ��� �����ؾ��Ѵ�.
 *       - 1���� 2���� �ڿ��� �� �����尡 �����ϴٰ� �߻��� �� �ִ� �����̴�.
 *     - 3. �� �����尡 ȿ�������� ���� ����� �� �ְ� �ؾ� �Ѵ�.
 *     - ��� : ���α׷��� �� �� ����ؾ� �ϴ� ���׵��� ����...
 *     
 * �������� ������ ����
 *   - ��Ӱ� ���� �ΰ��� ����� �ִµ� ��Ӻ��ٴ� ������ �� ����ϰ� ���� �� �ִ�.
 * 1. Thread Ŭ������ ���
 *   class MyThread extends Thread{
 *       public void run(){ >> ThreadŬ������ run() �������̵�
 *           �۾�����
 *       }
 *   }
 *   ����Ҷ�
 *   MyThread t1 = new MyThread(); // ������ ����
 *   t1.start(); // ������ ����
 * 
 * 2. Runnable �������̽� ���� (WIN!)
 *   class MyThread implements Runnable{
 *       public void (){ >> Runnable �������̽��� �߻� �޼��� run() ����
 *           �۾� ����
 *       }
 *   }
 *   ����ҋ�
 *   Runnable r = new MyThread();
 *   Thread t2 = new Thread(r); // Thread(Runnable r)
 *   // Thread t2 = new Thread(new MyThread());
 *   t2.start(); // ������ ����
 *   
 * �������� ���� - start()
 *   - �����带 ������ �Ŀ� start()�� ȣ���ؾ� �����尡 �۾��� �����Ѵ�.
 *     ThreadEx1_1 t1 = new ThreadEx1_1();
 *     ThreadEx1_1 t2 = new ThreadEx1_1();
 *     
 *     t1.start();
 *     t2.start();
 *     >> start()�� ������ �ƴ� ������ �غ� �Ϸ��.
 *     >> t1, t2 ����� ���� ������� OS�����ٷ��� ��������� �����Ѵ�.
 *     >> t1�� ���� �غ� ��ٰ� ���� ���ȴٴ� ������ ����.
 *     
 * start()�� run()
 *   - run()�� ���������� ȣ���� start()�� �ϰ� �ִ�. �� �׷��� �˾ƺ���
 *   
 *   1. CallStack : start() �޼��尡 ���ο� CallStack�� �����Ѵ�.
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
 *   3. CallStack : start()�� ���ο� CallStack ����� ���� 
 *     - ���� ���������� �۾�����
 *   
 *      |       |       |       |    
 *      |       |       |       |
 *      |       |       |       |
 *      +-------+       +-------+  
 *      | main  |       | run   |
 *      +-------+       +-------+   
 */