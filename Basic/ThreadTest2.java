
public class ThreadTest2 { // 12:54�� ���� �����ϱ�

	public static void main(String[] args) {
		// ���� 1 ( main �޼��尡 ����ǵ� ��Ƽ�����忡���� ������� �ʴ´�. )
		ThreadEx11_1 th1 = new ThreadEx11_1();
		Runnable r = new ThreadEx11_2();
		Thread th2 = new Thread(r);
		
		th1.start();
		th2.start();
		startTime = System.currentTimeMillis();
		
		try {
			th1.join(); // ���� �����尡 th1�� �۾��� ������ ���� ��ٸ���.
			th2.join(); // ���� �����尡 th1�� �۾��� ������ ���� ��ٸ���.
		}catch(InterruptedException e) {}
		
		System.out.println("�ҿ�ð� = " + (System.currentTimeMillis() - startTime));
		// ==============================================
		
		// ���� 2 (�̱� ������� ���������� ����Ǹ� �������� ����ȴ�.) >> ��Ƽ ������ ���� ���� �ð��� �ҿ�ȴ�.
		long startTime2 = System.currentTimeMillis();
		
		for (int i = 0; i < 300; i++) {
			System.out.printf("%s", new String("-"));
		}
		System.out.println("�ҿ�ð�1 = " + (System.currentTimeMillis() - startTime2));
		for (int i = 0; i < 300; i++) {
			System.out.printf("%s", new String("|"));
		}
		System.out.println("�ҿ�ð�2 = " + (System.currentTimeMillis() - startTime2));
		// ==============================================
		
		// ���� 3 (���� 2�� ��Ƽ������ �ٲٱ�)
		ThreadEx13_1 th3 = new ThreadEx13_1();
		th3.start();
		startTime3 = System.currentTimeMillis();
		
		for (int i = 0; i < 300; i++) {
			System.out.printf("%s", new String("UU"));
		}
		System.out.println("�ҿ�ð�3 = " + System.currentTimeMillis());
	}
	static long startTime = 0;
	static long startTime3 = 0;
}
class ThreadEx11_1 extends Thread{
	public void run() {
		for (int i = 0; i < 300; i++) {
			System.out.print(new String("-"));
		}
	}
}

class ThreadEx11_2 implements Runnable{
	public void run() {
		for(int i = 0; i < 300; i++) {
			System.out.print(new String("|"));
		}
	}
}

class ThreadEx13_1 extends Thread{
	public void run() {
		for (int i = 0; i < 300; i++) {
			System.out.printf("%s", new String("^"));
		}
		System.out.println("�ҿ�ð�3 = " + (System.currentTimeMillis()));
	}
}
/*
 * main �������
 *   - main�޼����� �ڵ带 �����ϴ� �������̴�.
 *   - �������� �����δ� "����� ������(main ������)"�� "���� ������(���� ������)"�� �ִ�.
 *   
 *   ���� ���� ����� �����尡 �ϳ��� ������ ���α׷��� ����ȴ�.
 *     - ��Ƽ �������� ���� ����� �����尡 ����ǵ� �ٸ� �����尡 �ֱ� ������ ���α׷��� ������� �ʴ´�.
 */