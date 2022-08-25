public class GenericsTest3 {

	public static void main(String[] args) {
		// ���� 1
		BoxT b = null;
		BoxT<String> bstr = null;
		
		b = (BoxT)bstr; // Box<String> -> Box ���� But ���
		bstr = (BoxT<String>)b; // Box -> Box<String> ���� But ���
		// ����Ÿ�԰� ���׸� Ÿ���� ���� ������� ���� �����ϸ� ����Ÿ�� ������� ����
		
		// ���� 2
		FruitBoxT<? extends FRuit> box1 = /*(FruitBox<? extends FRuit>) ��������*/new FruitBoxT<FRuit>();
		FruitBoxT<? extends APple> box2 = new FruitBoxT<APple>();
		// FruitBoxT<APple> -> FruitBox<? extends Fruit> ����
		
		FruitBoxT<APple> ABox = (FruitBoxT<APple>)box2; // OK ��� �߻�4
		//FruitBox<? extends Fruit> -> FruitBox<APple> ����
	}
}
class FRuit{}
class APple extends FRuit{}
class BoxT<T>{}
class FruitBoxT<T extends FRuit> extends BoxT<T>{}


/*
���׸� Ÿ���� ����ȯ
  - ���׸� Ÿ�԰� ���� Ÿ�� ���� ����ȯ�� �ٶ������� �ʴ�. (��� �߻�)
    - JDK 1.5 ���� ���� Ÿ���� ����ϴ°� �ϴ� �ٶ��� ���� �ʴ�.
    Box<Object> objBox = null;
          ���׸� Ÿ�� ��������
    Box box = (Box)objBox; // OK but ���׸� Ÿ�� ->����Ÿ�� ��� �߻�
         ����Ÿ�� ��������            ���׸� Ÿ�� ��������
    Box
    objBox = (Box<Object>)box;  // OK but ����Ÿ�� ->���׸�Ÿ�� ��� �߻�
          ���׸�Ÿ�� ��������                                   ����Ÿ�� ��������
    Box<Object>
    
    objBox = (Box<Object>)strBox; // Error Box<String> -> Box<Object>
    strBox = (Box<String>)objBox; // Error Box<Object> -> Box<String>

  - ���ϵ� ī�尡 ���� ���׸� Ÿ�����δ� ����ȯ ����
    Box<Object> objBox = (Box<Object>)new Box<String>(); //Error! ����ȯ �Ұ�
    Box<? extends Object> wBox = (Box<? extends Object>)new Box<String>(); // OK
    Box<? extends Object> wBox = new Box<String>(); // OK ������� ����.
    
    static Juice makeJuice(Fruit<? extends Fruit> box){...}
    FruitBox<? extends Fruit> box = new FruitBox<Fruit>(); // OK
    FruitBOx<? extends Fruit> box = new FruitBox<Apple>(); // OK
    
���׸� Ÿ���� ����
  - �����Ϸ��� ���׸� Ÿ���� ���� �ϰ� �ʿ��� ���� ����ȯ�� �ִ´�.
    class Test<T extends Fruit>{
        void add(){...}
    }
    //============���׸� Ÿ���� ����==============
    class Test{
        void(Fruit t){
        ...
  - ���׸� Ÿ�� ���� �Ŀ� Ÿ���� ����ġ�ϸ� ����ȯ�� �߰�
  - ���ϵ�ī�尡 ���Ե� ���, ������ Ÿ������ ����ȯ �߰�
*/
