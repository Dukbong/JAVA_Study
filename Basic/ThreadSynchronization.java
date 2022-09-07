public class ThreadSynchronization {

	public static void main(String[] args) {
		// 동기화 하지 않았을 경우
		Runnable r = new RunnableEx12_3();
		new Thread(r).start();
		
		
		// 동기화 한것
		Runnable r2 = new RunnableEx12_4();
		new Thread(r2).start();
	}

}
class Account{
	private int balance = 1000; // private으로 해야 동기화가 의미가 있다.
	
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
			// 100 200 300원 중의 한 값을 임으로 선택해서 출금
			acc.withdraw(money);
			System.out.println("동기화 x balance " + acc.getBalance());
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
				// 100 200 300원 중의 한 값을 임으로 선택해서 출금
				acc.withdraw(money);
				System.out.println("동기화 O balance " + acc.getBalance());
			}
		}
	}



/* 쓰레드의 동기화(synchronization)
 *   - 멀티 쓰레드 프로세스에서는 다른 쓰레드의 작업에 영향을 줄 수 있다.
 *   - 진행중인 작업이 다른 스레드에게 간섭받지 않게 하려면 동기화가 필요하다.
 *   - 정리 : 한 스레드가 진행중인 작업을 다른 스레드가 간섭하지 못하게 막는것
 *   - 동기화 하려면 간섭받지 않아야 하는 문장들을 "임계 영역"으로 설정해야한다.
 *   - 임계영역은 락(lock)을 얻은 단 하나의 스레드만 출입 가능(객체 1개당 락 1개를 가지고 있다.)
 *   
 * synchronized를 이용한 동기화
 *   - synchronized로 임계영역(lock이 걸리는 영역)을 설정하는 2가지 방법
 *   - 임계영역은 갯수는 적고 범위는 작은게 좋다.
 *     1. 메서드 전체를 임계영역으로 지정
 *        public synchronized void Test(){} << 임계영역
 *        
 *        예시)
 *        public synchronized void withdraw(int money){
 *            if(balance >= money){
 *                try{
 *                    Thread.sleep(2000);
 *                }catch(InterruptedException e){}
 *                
 *                balance = balance - money;
 *            }
 *        }
 *        // 메서드 전체가 임계영역이다.
 *        
 *     2. 특정한 영역을 임계영역으로 지정
 *        synchronized(객체의 참조변수){} << 임계영역
 *        
 *        예시)
 *        public void withdraw(int money){
 *            synchronized(this){ // 40~47 line까지 임계영역
 *                if(balance >= money){
 *                    try{
 *                        Thread.sleep(2000);
 *                    }catch(InterruptedException e){}
 *                    balance = balance - money;
 *                }
 *            }
 *        }
 */