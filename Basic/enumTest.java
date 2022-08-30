
public class enumTest {

	public static void main(String[] args) {
		// �Ʒ� �������� ��� ���� ����� ��ȯ������ �ٸ� ����鵵 �ִٴ°� �˷��ֱ� ���� �ۼ����.
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
		// System.out.println("d1 > d2 ?" + (d1 > d2)); // Error! ��ü������ �� ���� �Ұ�
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
������ (enum)
 - ���õ� ������� ���� ���� ���� ��, java�� Ÿ�Կ� ������ �������� ����
   class Card{
       - > ����
       static final int CLOVER = 0;
       static final int HEART = 1;
       static final int DIAMOND = 2;
       static final int SPADE = 3;
       
       - > ����
       static final int TWO = 0;
       static final int THREE = 1;
       static final int FOUR = 2;
       
       final int kind;
       final int num;
   }
    ���������� ��ȯ
    class Card{
        enum Kind { CLOVER, HEART, DIAMOND, SPADE } -> ������ kind�� ����
                       0      1       2       3
        enum Value { TWO, THREE, FOUR} -> ������ value�� ����
                      0     1      2
        �ڵ����� ���� �ο��ȴ�.
        
        final Kind kind; // Ÿ���� int�� �ƴ� Kind���� ��������
        final Value value;
    }
    
    - ���� ���¿��� if(Card.CLOVER == Card.TWO)�� �ϸ� true�� �����°� ������ �ǹ̰� ���� �ʴ´�.
      - �ֳ��ϸ� ���̿� ���ڸ� ���ϴ°ǵ� true�� �����°� �̻��ϴ�.
    - ������������ if(Card.Kind.CLOVER == Card.Value.TWO)�� �ϸ� ������ ������ �߻��Ѵ�.
      - �ֳ��ϸ� �� ���� Ÿ���� �ٸ��� ������ �񱳰� �Ұ����ϴ�.
      
 - �������� �����ϴ� ���
   - enum �������̸� {�����1, �����2, ...}
     - �ڵ����� 0 ���� ���� ��������.
     
 - ������ Ÿ���� ������ �����ϰ� ����ϴ� ���
   enum Direction{EAST, SOUTH, WEST, NORTH}
   class Unit{
       int x, y;
       Direction dir;
       
       void init(){
           dir = Direction.EAST;
       }
   }
  - ������ ����� �񱳿� ==�� compareTo() ��밡��
    if(dir == Direction.EAST){
        x++;
    }else if(dif > Direction.WEST){ // Error! ������ ����� �񱳿����� ���Ұ�
        //...
    }else if(dif.compareTo(Direction.WEST) > 0){ // �� ������ ������ 0 ������ ũ�� ��� �������� ũ�� ����
        //...
    }

  - �������� ���� = java.lang.Enum
    - ��� �������� Enum�� �ڼ��̸�, �Ʒ��� �޼��带 ��ӹ޴´�.
      - class<E> getDeclaringClass() : �������� class��ü�� ��ȯ�Ѵ�.
      - String name() : ������ ����� �̸��� ���ڿ��� ��ȯ
      - int ordinal() : ������ ����� ���ǵ� ������ ��ȯ(0���� ����) !!���� ����� ���� ��ȯ���� �ʴ´�.
      - T valueOf(class<T> enumType, String name) : ������ ���������� name�� ��ġ�ϴ� ������ ����� ��ȯ
      
      - values(), valueOf()�� �����Ϸ��� �ڵ����� �߰����ش�.
          - static E[] values()
          - static E valueOf(String name) => Direction d = Direction.valueOf("WEST"); == Direction.WEST
             Direction[] dArr = Direction.values();
             for(Direction d : dArr){
                 System.out.printf("%s = %d\n",d.name(), d.ordinal());
             }
 */