import java.util.*;

public class ThreadWaitNotify {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Table table = new Table();
		
		new Thread(new Cook(table), "COOK").start();
		new Thread(new Customer(table, "donut"), "CUT1").start();
		new Thread(new Customer(table, "buger"), "CUT2").start();
		
		try {
			Thread.sleep(5000);
		}catch(InterruptedException e) {}
		
		System.exit(0);
	}
	
}
class Customer implements Runnable{
	private Table table;
	private String food;
	
	Customer(Table table, String food){
		this.table = table;
		this.food = food;
	}
	
	public void run() {
		while(true) {
			try {
				Thread.sleep(10);
			}catch(InterruptedException e) {}
			String name = Thread.currentThread().getName();
			
			if(eatFood()) {
				System.out.println(name + " ate a" + food);
			}else {
				System.out.println(name + " failed to eat.");
			}
		}
	}
	
	boolean eatFood() {return table.remove(food);}
}

class Cook implements Runnable{
	private Table table;
	
	Cook(Table table){
		this.table = table;
	}
	public void run() {
		while(true) {
			int idx = (int)(Math.random() * table.dishNum());
			table.add(table.dishNames[idx]);
			try {
				Thread.sleep(100);
			}catch(InterruptedException e) {}
		}
	}
}
class Table{
	String[] dishNames = {"donut", "donut", "burger"};
	final int MAX_FOOD = 6;
	private ArrayList<String> dishes = new ArrayList<String>();
	public synchronized void add(String dish) {
		if(dishes.size() >= MAX_FOOD) {
			return;
		}
		dishes.add(dish);
		System.out.println("Dishes : " + dishes.toString());
	}
	
	public boolean remove(String dishName) {
		synchronized(this) {
			while(dishes.size() == 0) {
				String name = Thread.currentThread().getName();
				System.out.println(name + "is waiting.");
				try {
					Thread.sleep(500);
				}catch(InterruptedException e) {}
			}
			
			for(int i = 0; i < dishes.size(); i++) {
				if(dishName.equals(dishes.get(i))) {
					dishes.remove(i);
					return true;
				}
			}
			
		}
		return false;
	}
	public int dishNum() {
		return dishNames.length;
	}
}
/* wait()과 notify()
 *   - synchronized는 비효율적이기 때문에 동기화의 효율을 높이기 위해 만들어졌다.
 *   - wait()은 기다리기, notify()는 통보, 알려주기
 *   - Object클래스에 정의되어 있으며, 동기화 블록 내에서만 사용할 수 있다.
 *     - wait() = 객체의 lock을 풀고 스레드를 해당 객체의 waiting pool에 넣는다.
 *     - notify() = waiting pool에서 대기중인 스레드 중의 랜덤으로 하나를 깨운다.
 *     - notifyAll() = waiting pool에서 대기중인 모든 스레드를 깨운다. (notify보다 효율적이다.)
 *     
 *       class Account{
 *           int balance = 1000;
 *           
 *           public synchronized void withdraw(int money){
 *               while(balance < money){
 *                   try{
 *                       wait(); // 대기 - 락을 풀고 기다린다.
 *                       // 통지를 받으면 락을 재획득한다.
 *                   }catch(InterruptedException e){}
 *               }
 *               balance = balance - money;
 *           }
 *           public synchronized void deposit(int money){
 *               balance = balance + money;
 *               notify(); // 통지 - 대기중인 스레드 중 하나에게 알림
 *           }
 *       } 
 */