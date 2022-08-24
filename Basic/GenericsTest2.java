import java.util.ArrayList;
// 12~14 강의 10분부터 듣기

public class GenericsTest2 {

	public static void main(String[] args) {
		// 예제 1
		FruitBox<Fruit> fruitBox = new FruitBox<Fruit>();
		FruitBox<Apple> appleBox = new FruitBox<Apple>();
		FruitBox<Grape> grapeBox = new FruitBox<Grape>();
		// FruitBox<Toy> toyBox = new FruitBox<Toy>(); Fruit의 자식 타입만 지네릭세 사용가능하다.
		Box<Toy> toyBox = new Box<Toy>();
		
		fruitBox.add(new Fruit());
		fruitBox.add(new Apple());
		fruitBox.add(new Grape());
		appleBox.add(new Apple());
		// appleBox.add(new Grape()); Error! Grape는 Apple의 자식이 아니다.
		grapeBox.add(new Grape());
		
		// 예제 2
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
// 지네릭에서 인터페이스랑 타입이랑 같이 사용하려면 &을 써야한다. 
class FruitBox<T extends Fruit & Eatable> extends Box<T>{}

// ===========================예제2=================================
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
제한된 지네릭 클래스
  - extends로 대입할 수 있는 타입을 제한한다.
    class FruitBox<T extends Fruit>{} // Fruit의 자기 자신 포함 자식 타입으로 지정 가능
     - 만약 Apple이 Fruit의 자식 클래스라면
       FruitBox<Apple> appleBox = new FruitBox<Apple>(); // OK
       FruitBox<Toy> toyBox = new FruitBox<Toy>(); // Error!
         - Toy는 Fruit의 자식 타입이 아니기 때문이다.
  - 인터페이스인 경우에도 extends를 사용한다.
    interface EatAble{}
    class FruitBox<T extends EatAble>{}

지네릭의 제약
  - 타입 변수에 대입은 인스턴스 별로 다르게 가능
    Box<Apple> appleBox = new Box<Apple>(); // OK Apple 객체만 저장 가능
  - 제약사항 1. static 멤버에 타입 변수 사용 불가 
    class Box<T>{
        static T item; // Error!
        static int compare(T t1, T t2){} // Error!
    }
  - 제약사항2. 배열을 생성할 때 타입 변수 사용 불가, 타입 변수로 배열 선언은 가능
    class Box<T>{
        T[] itemArr; // OK T타입의 배열을 위한 참조변수
        T[] toArray(){
            T[] tmpArr = new T[itemArr.length]; // Error! Generic 배열 생성 불가
              - 간단하게 new 바로 다음에 타입변수가 오는건 안된다.
                - new 연산자 다음에는 확정된 타입만 올수 있다.
        }
    }

와일드 카드 <?>
  - 하나의 참조 변수로 대입된 타입이 다른 객체를 참조가능하다.
    ArrayList<? extends Product> list = new ArrayList<Tv>(); OK
    ArrayList<? extends Product> list = new ArrayList<Audio>(); // OK
    ArrayList<Product> list = new ArrayList<Tv>(); // Error! 대입된 타입 불일치
  - 사용하는 방법
    1. <? extends T> 와일드 카드의 상한 제한, T와 그의 자식 타입들만 가능
    2. <? super T> 와일드 카드의 하한 제한, T와 그의 부모 타입들만 가능
    3. <?> 제한없음, 모든 타입이 가능 == <? extends Object>와 동일하다.  
    
메서드의 매개변수에 와일드 카드를 사용할 수 있다.
    static Juice makeJuice(FruitBox<? extends Fruit> box){
        String tmp = "";
        for(Fruit f : box.getList()){
        tmp = tmp + f + " ";
        return new Juice(tmp);
    }
    
지네릭 메서드
  - 지네릭 타입이 선언된 메서드(타입 변수는 메서드 내에서만 유효하다.)
    static <T> void sort(List<T> list, Comparator<? super T> c)
  - 클래스의 타입 매개변수<T>와 메서드의 타입 매개변수 <T>는 별개다.
    class FruitBox<T>{
        static <T> void sort (List<T> list, Comparator<? super T> c){
            ....
        }
    }
  - 메서드를 호출할 때 마다 타입을 대입해야 한다.( 대부분 생략 가능 )
    static <T extends Fruit> Juice makeJuice(FruitBox<T> box){
        String tmp = "";
        for ( Fruit f : box.getList()){
            tmp = tmp + f + " ";
        }
        return new Juice(tmp);
    }
    
    System.out.println(Juicer.<Fruit>makeJuice(fruitBox));
    System.out.println(Juicer.<Apple>makeJuice(appleBox));
    
  - 메서드를 호출할 때 타입을 생략하지 않을 때는 클래스 이름 생략 불가
    System.out.println(<Fruit>makeJuice(fruitBox)); // Error! 클래스 이름 생략  불가
    System.out.println(this.<Fruit>makeJuice(fruitBox)); // OK
    System.out.println(Juicer.makeJuice(fruitBox)); // OK
*/