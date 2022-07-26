import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class HashSetTest {

	public static void main(String[] args) {
		// 예제 1
		Object[] objArr = {"1", new Integer(1), "2","2","3","3","4","4","4"};
		Set set = new HashSet();
		
		for (int i = 0; i < objArr.length; i++) {
			set.add(objArr[i]); // HashSet에 ObjArr의 요소를 저장한다.
		}
		System.out.println(set);
		
		//HashSet에 저장된 요소들을 출력한다. (Iterator 이용);
		Iterator it = set.iterator();
		
		while(it.hasNext()) { // hasNext() : 읽어올 요소가 있는지 확인
			System.out.println(it.next()); // 요소 하나 꺼내오기
		}
		
		// 예제2
		Set set2 = new HashSet();
		
		for (int j = 0; set2.size() < 6; j++) {
			int num = (int)(Math.random() * 45) + 1;
			set2.add(new Integer(num));
			//set2.add(num) == 결과값이 같다.
		}
		
		List list = new LinkedList(set2); // LinkedList(Collection c)
		// Set의 모든 요소를 List에 저장한다.
		Collections.sort(list); // Collections.sort(List list)
		// 값들이 저장된 list를 정렬한다. (List만 가능하다)
		System.out.println(list);
		// list를 출력한다.
		
		// 예제2
		HashSet set3 = new HashSet();
		
		set3.add("abc");
		set3.add("abc"); // 중복이라 저장 안됨
		
		// equals()와 hashCode()를 오버라이딩해야 아래와 같이 객체의 중복을 잡아서 정상적인 HashSet이 작동한다.
		// 이거 쉽게 하는 방법 >> Source > Generate hashCode()and equals() 클릭
		// but!! 그대로 사용하면 안된다. 내가 바꿔줘야한다.
		set3.add(new HashPerson("David",10));
		set3.add(new HashPerson("David",10));
		
		System.out.println(set3);
		
		// 예제3
		HashSet setA = new HashSet();
		HashSet setB = new HashSet();
		HashSet setHab = new HashSet();
		HashSet setKyo = new HashSet();
		HashSet setCha = new HashSet();
		
		setA.add("1"); setA.add("2"); setA.add("3");
		setA.add("4"); setA.add("5");
		System.out.println("A = " + setA);
		
		setB.add("4"); setB.add("2"); setA.add("3");
		setB.add("7"); setB.add("8");
		System.out.println("B = " + setB);
		
		// 교집합
		Iterator it2 = setB.iterator();
		while(it.hasNext()) {
			Object tmp = it2.next();
			if(setA.contains(tmp)) {
				setKyo.add(tmp);
			}
		}
		
		setA.retainAll(setB); // 교집합 간소화
		setA.addAll(setB); // 합집합
		setA.removeAll(setB);
		System.out.println(setA);
		
		// 차집합
		it2 = setA.iterator();
		while(it2.hasNext()) {
			Object tmp2 = it2.next();
			if(!setB.contains(tmp2)) {
				setCha.add(tmp2);
			}
		}
		
		// 힙집합
		it2 = setA.iterator();
		while(it2.hasNext()) {
			setHab.add(it2.next());
		}
		it2 = setB.iterator();
		while(it2.hasNext()) {
			setHab.add(it2.next());
		}
		
		System.out.println("A 교집합  B = " + setKyo);
		System.out.println("A 합집합 B = " + setHab);
		
	}

}

/*
HashSet ( 순서 x 중복 x ) <- List와 반대
 - Set인터페이스를 구현한 대표적인 컬렉션 클래스
 - 순서를 유지하고 싶을때는 LinkedHashSet클래스를 사용하면 된다.
 
TreeSet
 - 범위 검색과 정렬에 유리한 컬렉션 클래스 (예: 10~20)
 - HashSet보다 데이터 추가 및 삭제에 더 많은 시간이 소요된다.
 
HashSet 주요 메소드
 - HashSet() : 생성자
 - HashSet(Collection c) : 생성자
 - HashSet(int initialCapacity) : 초기 용량 ( 용량이 모자르면 컬렉스 클래스는 기본적으로 초기용량의 x2만큼 늘린다. ) 
 - HashSet(int initialCapacity, float loadFactor) : 용량 x2하는 시점(loadFactor)을 지정해준다. (예: 0.8 = 80% 찼을때 용량을 x2해준다.)
 - boolean add(Object o) : 추가
 - boolean addAll(Collection c) : 추가 - 합칩합
 - boolean remove(Object o) : 삭제
 - boolean removeAll(Collection c) : 삭제 - 교집합
 - boolean retainAll(Collection c) : 조건부 삭제 (Collection c를 제외한 나머지를 다 삭제한다.) - 차집합 구할때 사용한다. 
 - void clear() : 모두 삭제
 - boolean contains(Object o) : Set이 o를 포함하고 있는지 (포함 : true)
 - boolean containsAll(Collection c) : Set에 Collection c(여러객체)가 포함되어 있는지 (포함 : true)
 - Iterator iterator()
 - boolean isEmpty() : 비어있는지
 - int size() : 저장된 객체의 개수
 - Object[] toArray() : Set에 저장된 객체를 배열로 반환
 - Object[] toArray(Object[] a) : Set에 저장된 객체를 배열로 반환
 
HashSet은 객체를 저장하기전에 기존에 같은 객체가 있는지 확인한다.
같은 객체가 없으면 Set에 저장하고, 있으면 Set에 저장하지 않는다.
  - 이런 조건이 있기 때문에 boolean add(Object o)는 저장할 객체의 equals()와 hashCode()를 호출한다.
    - equals()와 hashCode()가 오버라이딩되어 있어야한다. (hashCode는 필수는 아니지만 정석이다.)
*/
class HashPerson{
	String name;
	int age;
	
	HashPerson(String name, int age){
		this.name = name;
		this.age = age;
	}
	public String toString() {
		return name + ":" + age;
	}
	// 여기 까지만 작성하면 HashSet에서 add를 하게 되면 에러가 발생한다.
	// equals, hashCode가 오버라이딩 되어있지 않기 때문에 equals가 주소값을 비교하게 되고 이는 원하는 기능이 아니기 때문이다.
	// 여기서 equals를 통해 중복인지 아닌지 확인하는 용도이기 때문에 값을 비교해줘야한다.
	//public boolean equals(Object o) {
		//if(!(o instanceof HashPerson)) {
			//return false;
		//}
		//HashPerson tmp = (HashPerson)o;
		//return name.equals(tmp.name) && age == tmp.age; // equals를 오버라이딩 해서 값을 비교하게 만들어 줘야 한다.
	//}
	@Override
	public int hashCode() {
		// 원본
		//final int prime = 31;
		//int result = 1;
		//result = prime * result + age;
		//result = prime * result + ((name == null) ? 0 : name.hashCode());
		//return result;
		return Objects.hash(name, age);
	}
	@Override
	public boolean equals(Object obj) {
		// 원본
		//if (this == obj)
			//return true;
		//if (obj == null)
			//return false;
		//if (getClass() != obj.getClass())
			//return false;
		//HashPerson other = (HashPerson) obj;
		//if (age != other.age)
			//return false;
		//if (name == null) {
			//if (other.name != null)
				//return false;
		//} else if (!name.equals(other.name))
			//return false;
		//return true;
		if(!(obj instanceof HashPerson)) {
			return false;
		}
		HashPerson tmp = (HashPerson)obj;
		return this.name.equals(tmp.name) && this.age == tmp.age; 
	}
	
	//public int hashCode() {
		//return (name+age).hashCode(); // String + int = String >> String 메서드인 hashCode() 사용
		// return Objects.hash(name, age); >> 요즘 방법
	//}
}






