import java.util.ArrayList;
// 12~14 ���� 10�к��� ���

public class GenericsTest2 {

	public static void main(String[] args) {
		// ���� 1
		FruitBox<Fruit> fruitBox = new FruitBox<Fruit>();
		FruitBox<Apple> appleBox = new FruitBox<Apple>();
		FruitBox<Grape> grapeBox = new FruitBox<Grape>();
		// FruitBox<Toy> toyBox = new FruitBox<Toy>(); Fruit�� �ڽ� Ÿ�Ը� ���׸��� ��밡���ϴ�.
		Box<Toy> toyBox = new Box<Toy>();
		
		fruitBox.add(new Fruit());
		fruitBox.add(new Apple());
		fruitBox.add(new Grape());
		appleBox.add(new Apple());
		// appleBox.add(new Grape()); Error! Grape�� Apple�� �ڽ��� �ƴϴ�.
		grapeBox.add(new Grape());
		
		// ���� 2
		// FruitBox2<? extends Fruit2> appleBox2 = new FruitBox2<Apple2>(); OK
		// appleBox2 = new FruitBox2<Fruit2>(); OK
		// appleBox2 = new FruitBox2<Grape2>(); OK
		// appleBox2 = new FruitBox2<Apple2>(); OK
		FruitBox2<Fruit2> fruitBox2 = new FruitBox2<Fruit2>();
		FruitBox2<Apple2> appleBox2 = new FruitBox2<Apple2>();
		
		fruitBox2.add(new Apple2());
		fruitBox2.add(new Grape2());
		appleBox2.add(new Apple2());
		appleBox2.add(new Apple2());
		
		System.out.println(Juicer.makeJuice(fruitBox2));
		System.out.println(Juicer.makeJuice(appleBox2));
	}
}
interface Eatable{}

class Fruit implements Eatable{
	public String toString() {
		return "Fruit";
	}
}

class Apple extends Fruit{
	public String toString() {
		return "Apple";
	}
}
class Grape extends Fruit{
	public String toString() {
		return "Grape";
	}
}
class Toy{
	public String toString() {
		return "Toy";
	}
}

class Box<T>{
	ArrayList<T> list = new ArrayList<T>();
	void add(T item) {
		list.add(item);
	}
	T get(int i) {
		return list.get(i);
	}
	int size() {
		return list.size();
	}
	public String toString() {
		return list.toString();
	}
}
// ���׸����� �������̽��� Ÿ���̶� ���� ����Ϸ��� &�� ����Ѵ�. 
class FruitBox<T extends Fruit & Eatable> extends Box<T>{}

// ===========================����2=================================
class Fruit2{public String toString() {return "Fruit";}}
class Apple2 extends Fruit2{public String toString() {return "Apple";}}
class Grape2 extends Fruit2{public String toString() {return "Grape";}}

class Juice{
	String name;
	
	Juice(String name){
		this.name = name + "Juice";
	}
	public String toString() {return name;}
}

class Juicer{
	static Juice makeJuice(FruitBox2<? extends Fruit2> box) {
		String tmp = "";
		for(Fruit2 f : box.getList()) {
			tmp = tmp +f + " ";
		}
		return new Juice(tmp);
	}
}

class Box2<T>{
	ArrayList<T> list = new ArrayList<T>();
	void add(T item) {list.add(item);}
	T get(int i) {return list.get(i);}
	ArrayList<T> getList(){return list;}
	int size() {return list.size();}
	public String toString() {return list.toString();}
}

class FruitBox2<T extends Fruit2> extends Box2<T>{}
/*
���ѵ� ���׸� Ŭ����
  - extends�� ������ �� �ִ� Ÿ���� �����Ѵ�.
    class FruitBox<T extends Fruit>{} // Fruit�� �ڱ� �ڽ� ���� �ڽ� Ÿ������ ���� ����
     - ���� Apple�� Fruit�� �ڽ� Ŭ�������
       FruitBox<Apple> appleBox = new FruitBox<Apple>(); // OK
       FruitBox<Toy> toyBox = new FruitBox<Toy>(); // Error!
         - Toy�� Fruit�� �ڽ� Ÿ���� �ƴϱ� �����̴�.
  - �������̽��� ��쿡�� extends�� ����Ѵ�.
    interface EatAble{}
    class FruitBox<T extends EatAble>{}

���׸��� ����
  - Ÿ�� ������ ������ �ν��Ͻ� ���� �ٸ��� ����
    Box<Apple> appleBox = new Box<Apple>(); // OK Apple ��ü�� ���� ����
  - ������� 1. static ����� Ÿ�� ���� ��� �Ұ� 
    class Box<T>{
        static T item; // Error!
        static int compare(T t1, T t2){} // Error!
    }
  - �������2. �迭�� ������ �� Ÿ�� ���� ��� �Ұ�, Ÿ�� ������ �迭 ������ ����
    class Box<T>{
        T[] itemArr; // OK TŸ���� �迭�� ���� ��������
        T[] toArray(){
            T[] tmpArr = new T[itemArr.length]; // Error! Generic �迭 ���� �Ұ�
              - �����ϰ� new �ٷ� ������ Ÿ�Ժ����� ���°� �ȵȴ�.
                - new ������ �������� Ȯ���� Ÿ�Ը� �ü� �ִ�.
        }
    }

���ϵ� ī�� <?>
  - �ϳ��� ���� ������ ���Ե� Ÿ���� �ٸ� ��ü�� ���������ϴ�.
    ArrayList<? extends Product> list = new ArrayList<Tv>(); OK
    ArrayList<? extends Product> list = new ArrayList<Audio>(); // OK
    ArrayList<Product> list = new ArrayList<Tv>(); // Error! ���Ե� Ÿ�� ����ġ
  - ����ϴ� ���
    1. <? extends T> ���ϵ� ī���� ���� ����, T�� ���� �ڽ� Ÿ�Ե鸸 ����
    2. <? super T> ���ϵ� ī���� ���� ����, T�� ���� �θ� Ÿ�Ե鸸 ����
    3. <?> ���Ѿ���, ��� Ÿ���� ���� == <? extends Object>�� �����ϴ�.  
    
�޼����� �Ű������� ���ϵ� ī�带 ����� �� �ִ�.
    static Juice makeJuice(FruitBox<? extends Fruit> box){
        String tmp = "";
        for(Fruit f : box.getList()){
        tmp = tmp + f + " ";
        return new Juice(tmp);
    }
    
���׸� �޼���
  - ���׸� Ÿ���� ����� �޼���(Ÿ�� ������ �޼��� �������� ��ȿ�ϴ�.)
    static <T> void sort(List<T> list, Comparator<? super T> c)
  - Ŭ������ Ÿ�� �Ű�����<T>�� �޼����� Ÿ�� �Ű����� <T>�� ������.
    class FruitBox<T>{
        static <T> void sort (List<T> list, Comparator<? super T> c){
            ....
        }
    }
  - �޼��带 ȣ���� �� ���� Ÿ���� �����ؾ� �Ѵ�.( ��κ� ���� ���� )
    static <T extends Fruit> Juice makeJuice(FruitBox<T> box){
        String tmp = "";
        for ( Fruit f : box.getList()){
            tmp = tmp + f + " ";
        }
        return new Juice(tmp);
    }
    
    System.out.println(Juicer.<Fruit>makeJuice(fruitBox));
    System.out.println(Juicer.<Apple>makeJuice(appleBox));
    
  - �޼��带 ȣ���� �� Ÿ���� �������� ���� ���� Ŭ���� �̸� ���� �Ұ�
    System.out.println(<Fruit>makeJuice(fruitBox)); // Error! Ŭ���� �̸� ����  �Ұ�
    System.out.println(this.<Fruit>makeJuice(fruitBox)); // OK
    System.out.println(Juicer.makeJuice(fruitBox)); // OK
*/