import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class GenericsTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList list = new ArrayList();
		list.add(10);
		list.add(20);
		list.add("30");
		System.out.println(list);
		
		// Integer i = (Integer)list.get(2); // 컴파일 에러 x But 실행시 형변환 에러 발생
		// 인덱스 2는 String이다.
		
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		list2.add(10); // list2.add(new Integer(10));
		list2.add(20);
		// list2.add("30"); // 에러 (Integer만 저장 할 수 있다.)
		// 실행 시 에러가 발생하는거보다 컴파일 시 에러 발생하는게 좋다.
		// 지네릭스를 사용하면 타입 체크가 강화된다.
		list2.add(30);
		System.out.println(list2);
		
		Integer i2 = list2.get(2); // (Integer) 생략이 가능하다.
		// 이미 Integer만 들어가 있는걸 알기 때문이다.
		// JDK 1.5 이후에는 <>를 꼭 써줘야한다.
		
		
		// 예제 3
		ArrayList list3 = new ArrayList();
		list3.add(new Tvv()); // ok
		list3.add(new Audioo()); // ok
		
		Tvv t = (Tvv)list3.get(0);
		
		ArrayList<Tvv> list4 = new ArrayList<Tvv>();
		// Tv타입의 객체만 들어올수 있다.
		list4.add(new Tvv()); // ok
		// list4.add(new Audio()); // Error! Tv만 저장된다.
		Tvv t2 = list4.get(0);
		
		// 예제 4
		ArrayList<Producttt> productList = new ArrayList<Producttt>();
		ArrayList<Tvv> TvvList = new ArrayList<Tvv>();
		// ArrayList<Product> tvList = new ArrayList<Tv>(); // Error
		// List<Tv> TvList = new List<Tv>(); // ok 다형성
		
		productList.add(new Tvv()); // public boolean add(Product e) // Product와 그의 자식 객체는 ok
		productList.add(new Audioo());
		
		TvvList.add(new Tvv()); // public boolean add(Tvv e)
		TvvList.add(new Tvv());
		
		printAll(productList);
		//printAll(TvvList); // Error!
		// ArrayList<Product> list = new ArrayList<Tvv>(); // 타입변수 불일치 에러
		
		// 예제 5
		ArrayList<Student> list5 = new ArrayList<Student>();
		list5.add(new Student("JAVA", 1, 1));
		list5.add(new Student("JS", 1, 2));
		list5.add(new Student("PYTHON", 2, 1));
		
		Iterator<Student> it = list5.iterator();
		
		while(it.hasNext()) {
			// Student s = (Student)it.next(); >> 지네릭스 사용하지 않으면 형변환 필요
			Student s = it.next();
			System.out.println(s.name);
			// System.out.println(it.next().name); 위에 두줄을 한줄로 변경
		}
		
		// 예제 6
		HashMap<String, Student2> map = new HashMap<String, Student2>();
		// HashMap<String, Student2> map = new HashMap<>(); 
		// 어짜피 new 생성자에도 똑같이 적어줘야하기 떄문에 생략이 가능하다. JDK 1.7 이후
		
		map.put("jang", new Student2("java",1,1,80,50,70));
		
		Student2 s = map.get("java");
		// Student2 s = (Student2)map.get("java"); // 생성시 지네릭 타입을 지정해주지 않았을 경우 
	}
	
	public static void printAll(ArrayList<Producttt> list) {
		for (Producttt p : list) {
			System.out.println(p);
		}
		// 위 와 같은 코드이다.
//		for (int i = 0; i < list.size(); i++) {
//			System.out.println(list.get(i));
//		}
	}

}
class Producttt{}
class Tvv extends Producttt{}
class Audioo extends Producttt{}

class Student{
	String name = "";
	int ban;
	int no;
	
	Student(String name, int ban, int no){
		this.name = name;
		this.ban = ban;
		this.no = no;
	}
}

class Student2{
	String name = "";
	int ban;
	int no;
	int kor;
	int eng;
	int math;
	
	Student2(String name, int ban, int no, int kor, int eng, int math){
		this.name = name;
		this.ban = ban;
		this.no = no;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
}
/*
지네릭스 (Generics)란?
  - 컴파일시 타입을 체크해 주는 기능  (JDK 1.5 이후 만들어짐)
    ArrayList<Tv> tvList = new ArrayList<Tv>();
    // Tv 객체만 저장 할 수 있는 ArrayList를 생성
    tvList.add(new Tv()); // ok
    tvList.add(new Audio()); // 컴파일 에러 (Tv 외에 다른타입은 저장 불가>
  - 객체의 타입 안정성을 높이고, 형변환의 번거로움을 줄인다. ( 코드가 간결해 진다. )
  
타입변수
  - 클래스를 작성할때, Object타입 대신 타입변수(E)를 선언해서 사용한다.
    public class ArrayList extends AbstractList{
        private transient Object[] elementData;
        public boolean add(Object o){.. 내용생략}
        public Object get(int index) {.. 내용생략}
        ...
    }
     위에 있는 코드를 타입변수를 사용하면
     public class ArrayList<E> extends AbstractList<E>{
         private transient E[] elementData;
         public boolean add(E o) {.. 내용 생략}
         public E get(int index) {.. 내용생략}
         ...
     }
  - 객체 생성시는 타입변수(E) 대신 실제 타입(Tv)를 지정 (대입) 해야한다.
    ArrayList<Tv> tvList = new ArrayList<Tv>();
    .... 위에 타입변수 공부한 클래스를  <Tv> 지네릭스를 통해 만든다면
    public class ArrayList extends AbstractList{
        private transient Tv[] elementDate;
        public boolean add(Tv o) {... 내용 생략}
        public Tv get(int index) {... 내용 생략}
        ...
    }
    
제네릭스 용어
 - Box<T> : 지네릭클래스 "T의 BOX" 또는 "T BOX"라고 읽는다.
   - 타입변수 T 선언
 - T : 타입변수 또는 타입 매개변수(T는 타입문자)
 - BOX : 원시타입 (raw type) -> 일반클래스 (원래 타입)
 - class Box<T>{} : 지네릭 클래스 선언
 - Box<String> b = new Box<String>();
   - <String> : 대입된 타입(매개변수화된 타입)
   
지네릭 타입과 다형성
  - 참조변수와 생성자의 대입된 타입은 일치해야한다.
      class Product{}
      class Tv extends Product{}
      class Audio extends Product{}
    - ArrayList<Tv>      list = new ArrayList<Tv>();
    - ArrayList<Product> list = new	 ArrayList<Tv>(); // 에러 불일치
      - 타입변수는 부모 자식 클래스여도 일치해야한다.
  - 지네릭 클래스간의 다형성은 성립한다. ( 여전히 타입은 일치해야한다. )
    - List<Tv> list = new ArrayList<Tv>(); // ok 다형성 ArrayList가 List를 구현했다.
    - List<Tv> list = new LinkedList<Tv>(); // ok 다형성 LinkedList가 List를 구현
  - 매개변수의 다형성도 성립
    - ArrayList<Product> list = new ArrayList<Product>();
    - list.add(new Product());
    - list.add(new Tv()); // ok
    - list.add(new Audio()); // ok
    
Iterator<E>
  - 클래스를 작성할때 Object타입 대신 T같은 타입변수 사용
    public interface Iterator<E>{
        boolean hasNext();
        E next();
        void remove();
    }
     
HashMap <K,V>
  - 여러개의 타입 변수가 필요한 경우, 콤마(",")를 구분자로 선언한다.
    HashMap<String, Student> map = new HashMap<String, Student>(); 생성
    map.put("Java", new Student("Java",1,1,100,100,100); // 데이터저장
    
    public class HashMap<K,V> extends AbstractMap<K,V>{
        public V get(Object key){내용 생략}
        public V put(K key, V value){ 내용 생략 }
        public V remove(Object key) { 내용 생략 }
    }
*/