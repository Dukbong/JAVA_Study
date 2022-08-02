
public class ObjectClass {

	public static void main(String[] args) {
		Value v1 = new Value(10); 
		Value v2 = new Value(10); 
		
		// 여기서는 원래 equals를 사용하여 주소값을 비교하였다.
		System.out.println(v1.equals(v2)); // false
		
		Value2 V1 = new Value2(10);
		Value2 V2 = new Value2(10);
		// 여기서는 equals를 오버라이딩을 통해 재정의 하여 인스턴스 변수 값을 비교하였다.
		System.out.println(V1.equals(V2)); // true
	}
}
// 모든 클래스의 최고 조상 오직 11개만의 메서드만을 가지고 있다.
// 1. protected Object clone() : 객체 자신의 복사본을 반환한다.
//    - 오버라이딩을 통해 접근제어자를 public으로 바꿔줘야한다.
// 2. public boolean equals(Object obj) : 객체 자신과 객체 obj가 같은 객체인지 알려준다
//    - 참조변수에 저장된 주소를 비교하는 것이다.
//    - 오버라이딩을 통해 주소가 아닌 멤버(대체로 인스턴스 변수) 비교도 할 수 있다. 
//    - equals메서드를 오버라이딩하면 hashCode메서드도 오버라이딩 해줘야한다.
//    - equals()의 결과가 true이면 두 객체의 해시코드는 같아야 하기 때문이다 (중요!!)
//
//      public boolean equals(Object obj){
//          return (this == obj);
//      }
//
// 3. protected void finalize() : 객체 소멸 시 가비지 컬렉터에 의해 자동 호출된다. 이때 수행되어야 하는 코드가 있을 때 오버라이딩 한다.
//    (거의 사용하지 않는다.. 생성자와 반대이다.)
// 4. public Class getClass() : 객체 자신의 클래스 정보(설계도 정보)를 담고 있는 Class 인스턴스를 반환한다.
//    class명 앞글자가 대문자이면 클래스 정보를 담기 위한 클래스이다.
//    getClass를 통해 얻는 것으로 객체 생성 및 객체 정보에 대해 알수 있다.
//    - 소스파일을 컴파일 하면 *.class 파일이 생성된다.
//    - *.class 파일을 실행하면 해당 파일명의 객체가 생성되고 이게 설계도다.

// 5. public int hashCode() : 객체 자신의 해시코드를 반환한다.
//    - 객체의 해시코드(정수값)를 반환하는 메서드
//    - Object클래스의 hashCode()는 객체의 주소를 int로 변환해서 반환
//    - equals메서드를 오버라이딩하면 hashCode메서드도 오버라이딩 해줘야한다.
//    - equals()의 결과가 true이면 두 객체의 해시코드는 같아야 하기 때문이다 (중요!!)
//    - 원래는 객체마다 hashCode가 다르지만 주소가 아닌 인스턴스 변수로 오버라이딩을한다.
//    - 만약에 각자 다른 hashCode값을 가지고 싶다면 identityHashCode(Object obj)를 사용해야한다.
//     
// 6. public String toString() : 객체 자신의 정보를 문자열로 반환한다.
//    - 객체를 문자열(string)로 변환하기 위한 메서드
//    - 객체를 toString메서드를 사용해서 출력하면 "클래스이름 + @ + 주소값을 int형으로 변환한 값"이 나온다.
// 7. public void notify() : 객체 자신을 사용하려고 기다리는 쓰레드를 하나만 깨운다.
// 8. public void notifyAll() : 객체 자신을 사용하려고 기다리는 모든 쓰레드를 깨운다.
// 9. public void wait()
// 10. public void wait(long timeout)
// 11. public void wait(long timeout, int nanos)
// 9~11번 메서드는 다른 쓰레드가 notify()나 notifyAll()을 호출할 때까지 현재 쓰레드를 무한히 또는 지정된 시간(timeout, nanos)동안 기다리게 한다.
// (timeout은 천분의 1초, nanos는 10^9분의 1초)

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
		// Object instanceof 자식 타입은 무조건 true이다.
		if(!(obj instanceof Value2)) { // 형변환을 하기 전에는 instanceof로 꼭 확인해야한다.
			return false;
		}
		Value2 v = (Value2)obj; // 형변환
		return this.value == v.value;
	}
}