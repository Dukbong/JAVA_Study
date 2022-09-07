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
/* wait()�� notify()
 *   - synchronized�� ��ȿ�����̱� ������ ����ȭ�� ȿ���� ���̱� ���� ���������.
 *   - wait()�� ��ٸ���, notify()�� �뺸, �˷��ֱ�
 *   - ObjectŬ������ ���ǵǾ� ������, ����ȭ ��� �������� ����� �� �ִ�.
 *     - wait() = ��ü�� lock�� Ǯ�� �����带 �ش� ��ü�� waiting pool�� �ִ´�.
 *     - notify() = waiting pool���� ������� ������ ���� �������� �ϳ��� �����.
 *     - notifyAll() = waiting pool���� ������� ��� �����带 �����. (notify���� ȿ�����̴�.)
 *     
 *       class Account{
 *           int balance = 1000;
 *           
 *           public synchronized void withdraw(int money){
 *               while(balance < money){
 *                   try{
 *                       wait(); // ��� - ���� Ǯ�� ��ٸ���.
 *                       // ������ ������ ���� ��ȹ���Ѵ�.
 *                   }catch(InterruptedException e){}
 *               }
 *               balance = balance - money;
 *           }
 *           public synchronized void deposit(int money){
 *               balance = balance + money;
 *               notify(); // ���� - ������� ������ �� �ϳ����� �˸�
 *           }
 *       } 
 */