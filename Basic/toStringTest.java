import java.util.Objects;

public class toStringTest {

	public static void main(String[] args) {
		Cards c1 = new Cards();
		Cards c2 = new Cards();
		System.out.println(c1.toString());
		System.out.println(c2); // println에서는 toString() 생략가능
		// 오버라이딩 전 c1 = Card@17365
		System.out.println(c1.equals(c2));
		System.out.println(c1.hashCode());
		System.out.println(c2.hashCode());
	}
}

class Cards{
	String kind;
	int number;
	
	Cards(){
		this("SPADE", 1);
	}
	Cards(String kind, int number){
		this.kind = kind;
		this.number = number;
	}
	// toString 메서드 오버라이딩
	public String toString() {
		return "kind : " + kind + ", number : " + number;
	}
	
	// 중요!!!!! equals를 오버라이딩 해주면 hashCode도 같이 오버라이딩해줘야하고 equals결과가 true이면 hasCode() 결과도 서로 같아야한다.
	
	// equals 메서드 오버라이딩
	public boolean equals(Object obj) {
		if(obj instanceof Cards) {
			Cards c = (Cards)obj;
			return this.kind.equals(c.kind) && this.number==c.number;
		}else {
			return false;
		}
	}
	// equals를 오버라이딩하면 hashCode도 오버라이딩 해줘야한다.
	public int hashCode() {
		// Objects 클래스는 객체와 관련된 유용한 메서드를 제공하는 유틸 클래스이다.
		return Objects.hash(kind, number);
		// int hash(Object...value) 매개변수가 가변인자라서 호출시 지정하는 값의 개수가 정해져있지 않다.
		// 그래서 매개변수를 하나만 넣어도되고 100개를 넣어도 상관없다.
	}
}