import javax.swing.JOptionPane;

public class ThreadSleepInterrupt {

	public static void main(String[] args) {
		// ���� 1
		ThreadEx8_1 th1 = new ThreadEx8_1();
		Thread th2 = new Thread(new ThreadEx8_2());
		
		th1.start();
		th2.start();
		
		//============================================================
		try {
			th1.sleep(2000);
			// == Thread.sleep(2000); 
			// �� �ڵ带 �����ϴ� ���� th1�̶�� ��� main �������̱� ������ main �����尡 �ܴ�.
		}catch(InterruptedException e) {}
		// delay(2000); �̶� ���� �ڵ��ε� delayó�� ������ �޼��带 ����°� �� ����ϴ�.
		//============================================================
		
		System.out.print("<<main ����>>");
		
		// ���� 2
		ThreadEx9_1 th3 = new ThreadEx9_1();
		th3.start();
		System.out.println("���� isInterrupted() = " + th3.isInterrupted());
		String input = JOptionPane.showInputDialog("�ƹ� ���̳� �Է��ϼ���.");
		System.out.println("�Է��Ͻ� ���� " + input + "�Դϴ�.");
		th3.interrupt(); // interrupt()�� ȣ���ϸ� interrupted�� true�� �ȴ�.
		System.out.println("���� isInterrupted() = " + th3.isInterrupted());
		System.out.println("interrupted = " + Thread.interrupted());
		// ���� ������� main�̱� ������ main �����尡 interrupt �Ǿ����� �˷��� �� false�� �ʱ�ȭ �Ѵ�.
		// interrupted�� static �޼����̱� ������ Thread�� ������Ѵ�.
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
		System.out.print("<<th1����>>");
	}
}

class ThreadEx8_2 implements Runnable{
	public void run() {
		for(int i = 0; i < 300; i++) {
			System.out.print("|");
		}
		System.out.print("<<th2����>>");
	}
}

class ThreadEx9_1 extends Thread{
	public void run() {
		int i = 10;
		
		while(i!=0 && !isInterrupted()) {
			System.out.println(i--);
			for(long x = 0; x < 2500000000L; x++); // �ð� ����
		}
		System.out.println("ī��Ʈ�� ����Ǿ����ϴ�.");
	}
}
/* �������� ���� ����
 * 
 * sleep()
 *   - ���� �����带 ������ �ð����� ���߰� �Ѵ�.
 *   - static�޼��� �̹Ƿ� �ڱ� �ڽ����׸� �����Ѵ�. (�ٸ� ������� �����ص� �ڱ��ڽ��� �ܴ�.)
 *     static void sleep(long millis)
 *   - ���� ó���� �ؾ��Ѵ�. (InterruptedException�� �߻��ϸ� sleep���� �������´�.)
 *     try{
 *         Thread.sleep(3000); >> ������ ����� ���ܸ� �������� ������ ����ó�� �ʼ�!
 *     } catch(InterruptedException e){} >> Exception�� �ڽ��̱� ������ �ʼ��� ����ó���� ������Ѵ�.
 *     
 *     sleep�� ����Ǵ� ���
 *     1. time up (�ð��� ��������)
 *     2. interrupted (������ ��������)
 *     
 *     ���� sleep()�� ����Ҷ� �Ź� ����ó���ϴ°� ���������� �޼��带 ���� ������ָ� �ȴ�.
 *     void delay(long millis){
 *         try{
 *             Thread.sleep(millis);
 *         }catch(InterruptedException e){}
 *     }
 *     
 *     delay(3000); == ù��° �ۼ��� �Ͱ� ���� �Ŵ�.
 *     
 * interrupt()
 *   - ������(Waiting == �۾� �ߴ�(���� sleep, join)�� �����带 ������ ����(Runnable)�� �����.
 *     void interrupt() >> �������� interrupt���¸� false���� true�� �ٲ��ش�.
 *     boolean isInterrupted() >> �������� interrupted���¸� ��ȯ�Ѵ�.
 *     static boolean interrupted() >> ���� �������� interrupted���¸� �˷��ְ� false�� �ʱ�ȭ �Ѵ�. 
 */
