
public class enumTest {

	public static void main(String[] args) {
		// 아래 세가지는 모두 같은 결과를 반환하지만 다른 방법들도 있다는걸 알려주기 위해 작성됬다.
		Direction d1 = Direction.EAST;
		Direction d2 = Direction.valueOf("WEST");
		Direction d3 = Enum.valueOf(Direction.class, "EAST");
		// =====================================================
		System.out.println("d1 = " + d1);
		System.out.println("d2 = " + d2);
		System.out.println("d3 = " + d3);
		
		System.out.println("d1 == d2 ?" + (d1 == d2));
		System.out.println("d1 == d3 ?" + (d1 == d3));
		System.out.println("d1.equals(d3) ?" + d1.equals(d3));
		// System.out.println("d1 > d2 ?" + (d1 > d2)); // Error! 객체끼리는 비교 연산 불가
		System.out.println("d1.compareTo(d3) ?" + (d1.compareTo(d3)));
		System.out.println("d1.compareTo(d2) ?" + (d1.compareTo(d2)));
		
		switch(d1){
		case EAST:
			System.out.println("The direction is EAST"); break;
		case SOUTH:
			System.out.println("The direction is SOUTH"); break;
		case WEST:
			System.out.println("The direction is WEST"); break;
		case NORTH:
			System.out.println("The direction is NORTH"); break;
			default:
				System.out.println("Invalid direction"); break;
		}
		
		Direction[] dArr = Direction.values();
		for (Direction d : dArr) { // for(Direction d : Direction.values())
			System.out.printf("%s = %d\n", d.name(), d.ordinal());
		}

	}

}
enum Direction {EAST, SOUTH, WEST, NORTH}

/*
열거형 (enum)
 - 관련된 상수들을 같이 묶어 놓은 것, java는 타입에 안전한 열거형을 제공
   class Card{
       - > 무늬
       static final int CLOVER = 0;
       static final int HEART = 1;
       static final int DIAMOND = 2;
       static final int SPADE = 3;
       
       - > 숫자
       static final int TWO = 0;
       static final int THREE = 1;
       static final int FOUR = 2;
       
       final int kind;
       final int num;
   }
    열거형으로 변환
    class Card{
        enum Kind { CLOVER, HEART, DIAMOND, SPADE } -> 열거형 kind를 정의
                       0      1       2       3
        enum Value { TWO, THREE, FOUR} -> 열거형 value를 정의
                      0     1      2
        자동으로 값이 부여된다.
        
        final Kind kind; // 타입이 int가 아닌 Kind임을 유의하자
        final Value value;
    }
    
    - 원래 형태에서 if(Card.CLOVER == Card.TWO)를 하면 true가 나오는게 맞지만 의미가 맞지 않는다.
      - 왜냐하면 무늬와 숫자를 비교하는건데 true가 나오는건 이상하다.
    - 열거형에서는 if(Card.Kind.CLOVER == Card.Value.TWO)를 하면 컴파일 에러가 발생한다.
      - 왜냐하면 두 개의 타입이 다르기 때문에 비교가 불가능하다.
      
 - 열거형을 정의하는 방법
   - enum 열거형이름 {상수명1, 상수명2, ...}
     - 자동으로 0 부터 값이 정해진다.
     
 - 열거형 타입의 변수를 선언하고 사용하는 방법
   enum Direction{EAST, SOUTH, WEST, NORTH}
   class Unit{
       int x, y;
       Direction dir;
       
       void init(){
           dir = Direction.EAST;
       }
   }
  - 열거형 상수의 비교에 ==와 compareTo() 사용가능
    if(dir == Direction.EAST){
        x++;
    }else if(dif > Direction.WEST){ // Error! 열거형 상수에 비교연산자 사용불가
        //...
    }else if(dif.compareTo(Direction.WEST) > 0){ // 두 같으면 같으면 0 왼쪽이 크면 양수 오른쪽이 크면 음수
        //...
    }

  - 열거형의 조상 = java.lang.Enum
    - 모든 열거형은 Enum의 자손이며, 아래의 메서드를 상속받는다.
      - class<E> getDeclaringClass() : 열거형의 class객체를 반환한다.
      - String name() : 열거형 상수의 이름을 문자열로 반환
      - int ordinal() : 열거형 상수가 정의된 순서를 반환(0부터 시작) !!주의 절대로 값을 반환하지 않는다.
      - T valueOf(class<T> enumType, String name) : 지정된 열거형에서 name과 일치하는 열거형 상수를 반환
      
      - values(), valueOf()는 컴파일러가 자동으로 추가해준다.
          - static E[] values()
          - static E valueOf(String name) => Direction d = Direction.valueOf("WEST"); == Direction.WEST
             Direction[] dArr = Direction.values();
             for(Direction d : dArr){
                 System.out.printf("%s = %d\n",d.name(), d.ordinal());
             }
 */