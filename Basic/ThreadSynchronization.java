public class ThreadSynchronization {

	public static void main(String[] args) {
		// ����ȭ ���� �ʾ��� ���
		Runnable r = new RunnableEx12_3();
		new Thread(r).start();
		
		
		// ����ȭ �Ѱ�
		Runnable r2 = new RunnableEx12_4();
		new Thread(r2).start();
	}

}
class Account{
	private int balance = 1000; // private���� �ؾ� ����ȭ�� �ǹ̰� �ִ�.
	
	public int getBalance() {
		return balance;
	}
	public void withdraw(int money) {
		if(balance >= money) {
			try {
				Thread.sleep(1000);
			}catch(InterruptedException e) {}
			balance = balance - money;
		}
	}
}
class RunnableEx12_3 implements Runnable{
	Account acc = new Account();
	public void run() {
		while(acc.getBalance() > 0) {
			int money = (int)(Math.random() * 3 + 1) * 100;
			// 100 200 300�� ���� �� ���� ������ �����ؼ� ���
			acc.withdraw(money);
			System.out.println("����ȭ x balance " + acc.getBalance());
		}
	}
}

 class Account2{
	 private int balance = 1000;

	 public int getBalance() {
		 return balance;
	 }
	 public synchronized void withdraw(int money) {
		 if(balance >= money) {
			 try {
				 Thread.sleep(1000);
			 }catch(InterruptedException e) {}
			 balance = balance - money;
		 }
	 }
 }
 class RunnableEx12_4 implements Runnable{
		Account2 acc = new Account2();
		public void run() {
			while(acc.getBalance() > 0) {
				int money = (int)(Math.random() * 3 + 1) * 100;
				// 100 200 300�� ���� �� ���� ������ �����ؼ� ���
				acc.withdraw(money);
				System.out.println("����ȭ O balance " + acc.getBalance());
			}
		}
	}



/* �������� ����ȭ(synchronization)
 *   - ��Ƽ ������ ���μ��������� �ٸ� �������� �۾��� ������ �� �� �ִ�.
 *   - �������� �۾��� �ٸ� �����忡�� �������� �ʰ� �Ϸ��� ����ȭ�� �ʿ��ϴ�.
 *   - ���� : �� �����尡 �������� �۾��� �ٸ� �����尡 �������� ���ϰ� ���°�
 *   - ����ȭ �Ϸ��� �������� �ʾƾ� �ϴ� ������� "�Ӱ� ����"���� �����ؾ��Ѵ�.
 *   - �Ӱ迵���� ��(lock)�� ���� �� �ϳ��� �����常 ���� ����(��ü 1���� �� 1���� ������ �ִ�.)
 *   
 * synchronized�� �̿��� ����ȭ
 *   - synchronized�� �Ӱ迵��(lock�� �ɸ��� ����)�� �����ϴ� 2���� ���
 *   - �Ӱ迵���� ������ ���� ������ ������ ����.
 *     1. �޼��� ��ü�� �Ӱ迵������ ����
 *        public synchronized void Test(){} << �Ӱ迵��
 *        
 *        ����)
 *        public synchronized void withdraw(int money){
 *            if(balance >= money){
 *                try{
 *                    Thread.sleep(2000);
 *                }catch(InterruptedException e){}
 *                
 *                balance = balance - money;
 *            }
 *        }
 *        // �޼��� ��ü�� �Ӱ迵���̴�.
 *        
 *     2. Ư���� ������ �Ӱ迵������ ����
 *        synchronized(��ü�� ��������){} << �Ӱ迵��
 *        
 *        ����)
 *        public void withdraw(int money){
 *            synchronized(this){ // 40~47 line���� �Ӱ迵��
 *                if(balance >= money){
 *                    try{
 *                        Thread.sleep(2000);
 *                    }catch(InterruptedException e){}
 *                    balance = balance - money;
 *                }
 *            }
 *        }
 */