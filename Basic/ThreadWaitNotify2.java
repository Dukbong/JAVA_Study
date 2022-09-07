// ThreadWaitNotify의 예제는 synchronized만 한 상태의 코드이다.
// 여기서는 wait()과 notify를 사용해서 효율적으로 작성해보겠다.
import java.util.*;

public class ThreadWaitNotify2 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Table2 table = new Table2(); // 공통적으로 사용된다.
			
			new Thread(new Cook2(table),"COOK").start();
			new Thread(new Customer2(table, "donut"), "CUT1").start();
			new Thread(new Customer2(table, "buger"), "CUT2").start();
			
			
			delayT(4000);
			System.exit(0);
	}
	public static void delayT(long millis) {
		try {
			Thread.sleep(millis);
		}catch(InterruptedException e) {}
	}
}

class Customer2 implements Runnable{
	private Table2 table;
	private String food;
	
	Customer2(Table2 table, String food){
		this.table = table;
		this.food = food;
	}
	
	public void run() {
		while(true) {
			try {
				Thread.sleep(100);
			}catch(InterruptedException e) {}
			
			String name = Thread.currentThread().getName();
			table.remove(food);
			System.out.println(name + " ate a " + food);
		} // while
	} // run
} // class

class Cook2 implements Runnable{
	private Table2 table;
	
	Cook2(Table2 table){
		this.table = table;
	}
	
	public void run() {
		while(true) {
			int idx = (int)(Math.random()*table.dishNum());
			table.add(table.dishNames[idx]);
			try {
				Thread.sleep(10);
			}catch(InterruptedException e) {}
		} // while
	} // run
} // class

class Table2{
	String[] dishNames = {"donut", "donut", "burger"};
	final int MAX_FOOD = 6;
	private ArrayList<String> dishes = new ArrayList<String>();
	
	public synchronized void add(String dish) {
		while (dishes.size() >= MAX_FOOD) {
			String name = Thread.currentThread().getName();
			System.out.println(name + " is waiting.");
			try {
				wait(); // Cook스레드를 기다리게 한다.
				Thread.sleep(500);
			}catch(InterruptedException e) {}
		}
		dishes.add(dish);
		notify();
		System.out.println("Dishes : " + dishes.toString());
	}
	
	public void remove(String dishName) {
		synchronized(this) {
			String name = Thread.currentThread().getName();
			
			while (dishes.size() == 0) {
				System.out.println(name + " is waiting.");
				try {
					wait();
					Thread.sleep(500);
				}catch(InterruptedException e) {}
			}
			
			while(true) {
				for(int i = 0; i < dishes.size(); i++) {
					if(dishName.equals(dishes.get(i))) {
						dishes.remove(i);
						notify();
						return;
					}
				} // for
				try {
					System.out.println(name + "is waiting.");
					wait();
					Thread.sleep(500);
				}catch(InterruptedException e) {}
			} // while
		} // synchronized
	}
	public int dishNum() {
		return dishNames.length;
	}
}