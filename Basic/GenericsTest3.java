public class GenericsTest3 {

	public static void main(String[] args) {
		// 예제 1
		BoxT b = null;
		BoxT<String> bstr = null;
		
		b = (BoxT)bstr; // Box<String> -> Box 가능 But 경고
		bstr = (BoxT<String>)b; // Box -> Box<String> 가능 But 경고
		// 원시타입과 지네릭 타입을 같이 사용하지 말고 웬만하면 원시타입 사용하지 말것
		
		// 예제 2
		FruitBoxT<? extends FRuit> box1 = /*(FruitBox<? extends FRuit>) 생략가능*/new FruitBoxT<FRuit>();
		FruitBoxT<? extends APple> box2 = new FruitBoxT<APple>();
		// FruitBoxT<APple> -> FruitBox<? extends Fruit> 가능
		
		FruitBoxT<APple> ABox = (FruitBoxT<APple>)box2; // OK 경고 발생4
		//FruitBox<? extends Fruit> -> FruitBox<APple> 가능
	}
}
class FRuit{}
class APple extends FRuit{}
class BoxT<T>{}
class FruitBoxT<T extends FRuit> extends BoxT<T>{}


/*
지네릭 타입의 형변환
  - 지네릭 타입과 원시 타입 간의 형변환은 바람직하지 않다. (경고 발생)
    - JDK 1.5 이후 원시 타입을 사용하는게 일단 바람직 하지 않다.
    Box<Object> objBox = null;
          지네릭 타입 참조변수
    Box box = (Box)objBox; // OK but 지네릭 타입 ->원시타입 경고 발생
         원시타입 참조변수            지네릭 타입 참조변수
    Box
    objBox = (Box<Object>)box;  // OK but 원시타입 ->지네릭타입 경고 발생
          지네릭타입 참조변수                                   원시타입 참조변수
    Box<Object>
    
    objBox = (Box<Object>)strBox; // Error Box<String> -> Box<Object>
    strBox = (Box<String>)objBox; // Error Box<Object> -> Box<String>

  - 와일드 카드가 사용된 지네릭 타입으로는 형변환 가능
    Box<Object> objBox = (Box<Object>)new Box<String>(); //Error! 형변환 불가
    Box<? extends Object> wBox = (Box<? extends Object>)new Box<String>(); // OK
    Box<? extends Object> wBox = new Box<String>(); // OK 위문장과 같다.
    
    static Juice makeJuice(Fruit<? extends Fruit> box){...}
    FruitBox<? extends Fruit> box = new FruitBox<Fruit>(); // OK
    FruitBOx<? extends Fruit> box = new FruitBox<Apple>(); // OK
    
지네릭 타입의 제거
  - 컴파일러는 지네릭 타입을 제거 하고 필요한 곳에 형변환을 넣는다.
    class Test<T extends Fruit>{
        void add(){...}
    }
    //============지네릭 타입의 제거==============
    class Test{
        void(Fruit t){
        ...
  - 지네릭 타입 제거 후에 타입이 불일치하면 형변환을 추가
  - 와일드카드가 포함된 경우, 저절한 타입으로 형변환 추가
*/
