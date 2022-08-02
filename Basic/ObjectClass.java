
public class ObjectClass {

	public static void main(String[] args) {
		Value v1 = new Value(10); 
		Value v2 = new Value(10); 
		
		// ���⼭�� ���� equals�� ����Ͽ� �ּҰ��� ���Ͽ���.
		System.out.println(v1.equals(v2)); // false
		
		Value2 V1 = new Value2(10);
		Value2 V2 = new Value2(10);
		// ���⼭�� equals�� �������̵��� ���� ������ �Ͽ� �ν��Ͻ� ���� ���� ���Ͽ���.
		System.out.println(V1.equals(V2)); // true
	}
}
// ��� Ŭ������ �ְ� ���� ���� 11������ �޼��常�� ������ �ִ�.
// 1. protected Object clone() : ��ü �ڽ��� ���纻�� ��ȯ�Ѵ�.
//    - �������̵��� ���� ���������ڸ� public���� �ٲ�����Ѵ�.
// 2. public boolean equals(Object obj) : ��ü �ڽŰ� ��ü obj�� ���� ��ü���� �˷��ش�
//    - ���������� ����� �ּҸ� ���ϴ� ���̴�.
//    - �������̵��� ���� �ּҰ� �ƴ� ���(��ü�� �ν��Ͻ� ����) �񱳵� �� �� �ִ�. 
//    - equals�޼��带 �������̵��ϸ� hashCode�޼��嵵 �������̵� ������Ѵ�.
//    - equals()�� ����� true�̸� �� ��ü�� �ؽ��ڵ�� ���ƾ� �ϱ� �����̴� (�߿�!!)
//
//      public boolean equals(Object obj){
//          return (this == obj);
//      }
//
// 3. protected void finalize() : ��ü �Ҹ� �� ������ �÷��Ϳ� ���� �ڵ� ȣ��ȴ�. �̶� ����Ǿ�� �ϴ� �ڵ尡 ���� �� �������̵� �Ѵ�.
//    (���� ������� �ʴ´�.. �����ڿ� �ݴ��̴�.)
// 4. public Class getClass() : ��ü �ڽ��� Ŭ���� ����(���赵 ����)�� ��� �ִ� Class �ν��Ͻ��� ��ȯ�Ѵ�.
//    class�� �ձ��ڰ� �빮���̸� Ŭ���� ������ ��� ���� Ŭ�����̴�.
//    getClass�� ���� ��� ������ ��ü ���� �� ��ü ������ ���� �˼� �ִ�.
//    - �ҽ������� ������ �ϸ� *.class ������ �����ȴ�.
//    - *.class ������ �����ϸ� �ش� ���ϸ��� ��ü�� �����ǰ� �̰� ���赵��.

// 5. public int hashCode() : ��ü �ڽ��� �ؽ��ڵ带 ��ȯ�Ѵ�.
//    - ��ü�� �ؽ��ڵ�(������)�� ��ȯ�ϴ� �޼���
//    - ObjectŬ������ hashCode()�� ��ü�� �ּҸ� int�� ��ȯ�ؼ� ��ȯ
//    - equals�޼��带 �������̵��ϸ� hashCode�޼��嵵 �������̵� ������Ѵ�.
//    - equals()�� ����� true�̸� �� ��ü�� �ؽ��ڵ�� ���ƾ� �ϱ� �����̴� (�߿�!!)
//    - ������ ��ü���� hashCode�� �ٸ����� �ּҰ� �ƴ� �ν��Ͻ� ������ �������̵����Ѵ�.
//    - ���࿡ ���� �ٸ� hashCode���� ������ �ʹٸ� identityHashCode(Object obj)�� ����ؾ��Ѵ�.
//     
// 6. public String toString() : ��ü �ڽ��� ������ ���ڿ��� ��ȯ�Ѵ�.
//    - ��ü�� ���ڿ�(string)�� ��ȯ�ϱ� ���� �޼���
//    - ��ü�� toString�޼��带 ����ؼ� ����ϸ� "Ŭ�����̸� + @ + �ּҰ��� int������ ��ȯ�� ��"�� ���´�.
// 7. public void notify() : ��ü �ڽ��� ����Ϸ��� ��ٸ��� �����带 �ϳ��� �����.
// 8. public void notifyAll() : ��ü �ڽ��� ����Ϸ��� ��ٸ��� ��� �����带 �����.
// 9. public void wait()
// 10. public void wait(long timeout)
// 11. public void wait(long timeout, int nanos)
// 9~11�� �޼���� �ٸ� �����尡 notify()�� notifyAll()�� ȣ���� ������ ���� �����带 ������ �Ǵ� ������ �ð�(timeout, nanos)���� ��ٸ��� �Ѵ�.
// (timeout�� õ���� 1��, nanos�� 10^9���� 1��)

class Value{
	int value;
	
	Value(int x){
		value = x;
	}
}

class Value2{
	int value;
	
	Value2(int x){
		value = x;
	}
	
	public boolean equals(Object obj) {
		// Object instanceof �ڽ� Ÿ���� ������ true�̴�.
		if(!(obj instanceof Value2)) { // ����ȯ�� �ϱ� ������ instanceof�� �� Ȯ���ؾ��Ѵ�.
			return false;
		}
		Value2 v = (Value2)obj; // ����ȯ
		return this.value == v.value;
	}
}