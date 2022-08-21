import java.util.ArrayList;

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
		list3.add(new Audio()); // ok
		
		Tvv t = (Tvv)list3.get(0);
		
		ArrayList<Tvv> list4 = new ArrayList<Tvv>();
		// TvŸ���� ��ü�� ���ü� �ִ�.
		list4.add(new Tvv()); // ok
		// list4.add(new Audio()); // Error! Tv�� ����ȴ�.
		Tvv t2 = list4.get(0);
		
		// ���� 4
		ArrayList<Product> productList = new ArrayList<Product>();
		ArrayList<Tvv> TvvList = new ArrayList<Tvv>();
		// ArrayList<Product> tvList = new ArrayList<Tv>(); // Error
		// List<Tv> TvList = new List<Tv>(); // ok ������
		
		productList.add(new Tvv()); // public boolean add(Product e) // Product�� ���� �ڽ� ��ü�� ok
		productList.add(new Audio());
		
		TvvList.add(new Tvv()); // public boolean add(Tvv e)
		TvvList.add(new Tvv());
		
		printAll(productList);
		//printAll(TvvList); // Error!
		// ArrayList<Product> list = new ArrayList<Tvv>(); // Ÿ�Ժ��� ����ġ ����
	}
	
	public static void printAll(ArrayList<Product> list) {
		for (Product p : list) {
			System.out.println(p);
		}
		// �� �� ���� �ڵ��̴�.
//		for (int i = 0; i < list.size(); i++) {
//			System.out.println(list.get(i));
//		}
	}

}
class Product{}
class Tvv extends Product{}
class Audio extends Product{}

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
     
*/