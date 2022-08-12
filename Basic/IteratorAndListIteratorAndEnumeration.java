import java.util.ArrayList;
import java.util.Iterator;

public class IteratorAndListIteratorAndEnumeration {

	public static void main(String[] args) {
		// 예제 1 (Iterator 생성 연습)
		ArrayList list = new ArrayList();
		// Collection c = new HashSet();
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		list.add("5");
		
		Iterator it = list.iterator(); // 1회용
		
		while(it.hasNext()) {
			Object obj = it.next();
			System.out.println(obj);
		}
		
		// 다시 한번 호출하고 싶다 Iterator도 다시 생성해줘야한다.
		
		it = list.iterator(); // 객체 생성 ( 1회용)
		
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}

}

/*
Iterator, ListIterator, Enumeration(Iterator의 구버전)
 - 컬렉션에 저장된 데이터를 접근(읽어오기)하는데 사용되는 인터페이스
 - ListIterator는 Iterator의 접근성을 향상 시킨 것 (단뱡향 -> 양방향)
 
 - Iterator 메서드 (중요)
   - (중요) boolean hasNext() : 읽어 올 요소가 남아있는지 확인 (있으면 true, 없으면 false)
     - Enumeration에서는 boolean hasMoreElements()
   - (중요) Object next() : 다음 요소를 읽어온다. hasNext()로 확인 후 next()를 사용하는게 안전하다.
     - Enumeration에서는 Object nextElement()
   - void remove() : next()로 읽어 온 요소를 삭제한다. next() 호출 후 remove()를 호출해야한다.
     - 선택적 기능
   - void forEachRemaining(Consumer<?super E> action) : 컬렉션에 남아 있는 요소들에 대해 지정된 작업(action)을 수행한다. 람다식을 사용하는 디폴트 메서드(JDK1.8)
 - Iterator의 특징
   - 컬렉션에 저장된 요소들을 읽어오는 방법을 표준화한 것
     - 컬렉션에는 List, Set, Map 각각 다양한 구조를 가지고 있기 때문에 표준화가 필요
     - 컬렉션에 iterator()를 호출해서 Iterator를 구현한 객체를 얻어서 사용한다.
       List list = new ArrayList();
       Iterator it = list.iterator(); // Iterator 인스턴스 생성
       
       while(it.hasNext()){ // boolean hasNext() 읽어올 요소가 없다면 false
           System.out.println(int.next()); // Object next() 다음 요소 읽기
       }
       

Map은 Iterator()기 없다.
 - keySet(), entrySet(), values()를 사용해야한다.
   - Set,Set,Collection 이기 떄문에 Iterator를 사용할 수 있다. 
     Map map = new HashMap();
     
     Iterator it = map.entrySet().iterator();
 





*/