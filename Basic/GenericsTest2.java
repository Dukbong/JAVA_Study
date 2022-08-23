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
		FruitBox<Fruit> fruitBox2 = new FruitBox<Fruit>();
		FruitBox<Apple> appleOk = new FruitBox<Apple>();
		
		fruitBox2.add(new Apple());
		fruitBox2.add(new Grape());
		fruitBox2.add(new Apple());
		fruitBox2.add(new Apple());
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

class Juice{
	String name;
	
	Juice(String name){
		this.name = name + "Juice";
	}
	public String toString() {return name;}
}

class Juicer{
	static Juice makeJuice(FruitBox<? extends Fruit> box) {
		String tmp = "";
		for(Fruit f : box.getList()) {
			tmp = tmp +f + " ";
		}
		return new Juice(tmp);
	}
}
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
*/