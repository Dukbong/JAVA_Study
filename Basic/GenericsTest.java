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
		
		// Integer i = (Integer)list.get(2); // ������ ���� x But ����� ����ȯ ���� �߻�
		// �ε��� 2�� String�̴�.
		
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		list2.add(10); // list2.add(new Integer(10));
		list2.add(20);
		// list2.add("30"); // ���� (Integer�� ���� �� �� �ִ�.)
		// ���� �� ������ �߻��ϴ°ź��� ������ �� ���� �߻��ϴ°� ����.
		// ���׸����� ����ϸ� Ÿ�� üũ�� ��ȭ�ȴ�.
		list2.add(30);
		System.out.println(list2);
		
		Integer i2 = list2.get(2); // (Integer) ������ �����ϴ�.
		// �̹� Integer�� �� �ִ°� �˱� �����̴�.
		// JDK 1.5 ���Ŀ��� <>�� �� ������Ѵ�.
		
		
		// ���� 3
		ArrayList list3 = new ArrayList();
		list3.add(new Tvv()); // ok
		list3.add(new Audioo()); // ok
		
		Tvv t = (Tvv)list3.get(0);
		
		ArrayList<Tvv> list4 = new ArrayList<Tvv>();
		// TvŸ���� ��ü�� ���ü� �ִ�.
		list4.add(new Tvv()); // ok
		// list4.add(new Audio()); // Error! Tv�� ����ȴ�.
		Tvv t2 = list4.get(0);
		
		// ���� 4
		ArrayList<Producttt> productList = new ArrayList<Producttt>();
		ArrayList<Tvv> TvvList = new ArrayList<Tvv>();
		// ArrayList<Product> tvList = new ArrayList<Tv>(); // Error
		// List<Tv> TvList = new List<Tv>(); // ok ������
		
		productList.add(new Tvv()); // public boolean add(Product e) // Product�� ���� �ڽ� ��ü�� ok
		productList.add(new Audioo());
		
		TvvList.add(new Tvv()); // public boolean add(Tvv e)
		TvvList.add(new Tvv());
		
		printAll(productList);
		//printAll(TvvList); // Error!
		// ArrayList<Product> list = new ArrayList<Tvv>(); // Ÿ�Ժ��� ����ġ ����
		
		// ���� 5
		ArrayList<Student> list5 = new ArrayList<Student>();
		list5.add(new Student("JAVA", 1, 1));
		list5.add(new Student("JS", 1, 2));
		list5.add(new Student("PYTHON", 2, 1));
		
		Iterator<Student> it = list5.iterator();
		
		while(it.hasNext()) {
			// Student s = (Student)it.next(); >> ���׸��� ������� ������ ����ȯ �ʿ�
			Student s = it.next();
			System.out.println(s.name);
			// System.out.println(it.next().name); ���� ������ ���ٷ� ����
		}
		
		// ���� 6
		HashMap<String, Student2> map = new HashMap<String, Student2>();
		// HashMap<String, Student2> map = new HashMap<>(); 
		// ��¥�� new �����ڿ��� �Ȱ��� ��������ϱ� ������ ������ �����ϴ�. JDK 1.7 ����
		
		map.put("jang", new Student2("java",1,1,80,50,70));
		
		Student2 s = map.get("java");
		// Student2 s = (Student2)map.get("java"); // ������ ���׸� Ÿ���� ���������� �ʾ��� ��� 
	}
	
	public static void printAll(ArrayList<Producttt> list) {
		for (Producttt p : list) {
			System.out.println(p);
		}
		// �� �� ���� �ڵ��̴�.
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
���׸��� (Generics)��?
  - �����Ͻ� Ÿ���� üũ�� �ִ� ���  (JDK 1.5 ���� �������)
    ArrayList<Tv> tvList = new ArrayList<Tv>();
    // Tv ��ü�� ���� �� �� �ִ� ArrayList�� ����
    tvList.add(new Tv()); // ok
    tvList.add(new Audio()); // ������ ���� (Tv �ܿ� �ٸ�Ÿ���� ���� �Ұ�>
  - ��ü�� Ÿ�� �������� ���̰�, ����ȯ�� ���ŷο��� ���δ�. ( �ڵ尡 ������ ����. )
  
Ÿ�Ժ���
  - Ŭ������ �ۼ��Ҷ�, ObjectŸ�� ��� Ÿ�Ժ���(E)�� �����ؼ� ����Ѵ�.
    public class ArrayList extends AbstractList{
        private transient Object[] elementData;
        public boolean add(Object o){.. �������}
        public Object get(int index) {.. �������}
        ...
    }
     ���� �ִ� �ڵ带 Ÿ�Ժ����� ����ϸ�
     public class ArrayList<E> extends AbstractList<E>{
         private transient E[] elementData;
         public boolean add(E o) {.. ���� ����}
         public E get(int index) {.. �������}
         ...
     }
  - ��ü �����ô� Ÿ�Ժ���(E) ��� ���� Ÿ��(Tv)�� ���� (����) �ؾ��Ѵ�.
    ArrayList<Tv> tvList = new ArrayList<Tv>();
    .... ���� Ÿ�Ժ��� ������ Ŭ������  <Tv> ���׸����� ���� ����ٸ�
    public class ArrayList extends AbstractList{
        private transient Tv[] elementDate;
        public boolean add(Tv o) {... ���� ����}
        public Tv get(int index) {... ���� ����}
        ...
    }
    
���׸��� ���
 - Box<T> : ���׸�Ŭ���� "T�� BOX" �Ǵ� "T BOX"��� �д´�.
   - Ÿ�Ժ��� T ����
 - T : Ÿ�Ժ��� �Ǵ� Ÿ�� �Ű�����(T�� Ÿ�Թ���)
 - BOX : ����Ÿ�� (raw type) -> �Ϲ�Ŭ���� (���� Ÿ��)
 - class Box<T>{} : ���׸� Ŭ���� ����
 - Box<String> b = new Box<String>();
   - <String> : ���Ե� Ÿ��(�Ű�����ȭ�� Ÿ��)
   
���׸� Ÿ�԰� ������
  - ���������� �������� ���Ե� Ÿ���� ��ġ�ؾ��Ѵ�.
      class Product{}
      class Tv extends Product{}
      class Audio extends Product{}
    - ArrayList<Tv>      list = new ArrayList<Tv>();
    - ArrayList<Product> list = new	 ArrayList<Tv>(); // ���� ����ġ
      - Ÿ�Ժ����� �θ� �ڽ� Ŭ�������� ��ġ�ؾ��Ѵ�.
  - ���׸� Ŭ�������� �������� �����Ѵ�. ( ������ Ÿ���� ��ġ�ؾ��Ѵ�. )
    - List<Tv> list = new ArrayList<Tv>(); // ok ������ ArrayList�� List�� �����ߴ�.
    - List<Tv> list = new LinkedList<Tv>(); // ok ������ LinkedList�� List�� ����
  - �Ű������� �������� ����
    - ArrayList<Product> list = new ArrayList<Product>();
    - list.add(new Product());
    - list.add(new Tv()); // ok
    - list.add(new Audio()); // ok
    
Iterator<E>
  - Ŭ������ �ۼ��Ҷ� ObjectŸ�� ��� T���� Ÿ�Ժ��� ���
    public interface Iterator<E>{
        boolean hasNext();
        E next();
        void remove();
    }
     
HashMap <K,V>
  - �������� Ÿ�� ������ �ʿ��� ���, �޸�(",")�� �����ڷ� �����Ѵ�.
    HashMap<String, Student> map = new HashMap<String, Student>(); ����
    map.put("Java", new Student("Java",1,1,100,100,100); // ����������
    
    public class HashMap<K,V> extends AbstractMap<K,V>{
        public V get(Object key){���� ����}
        public V put(K key, V value){ ���� ���� }
        public V remove(Object key) { ���� ���� }
    }
*/