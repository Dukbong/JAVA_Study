import java.util.*;
import static java.util.Collections.*; // Collections를 생략할 수 있다.

public class CollectionsClass {

	public static void main(String[] args) {
		// 예제
		List list = new ArrayList();
		System.out.println(list);
		
		Collections.addAll(list, 1,2,3,4,5);
		System.out.println(list);
		
		// Collections 생략
		rotate(list, 2); // 오른쪽으로 2칸씩 이동
		System.out.println(list);
		
		Collections.swap(list, 0 , 2); // 인덱스 0과 인덱스 2의 자리를 바꾼다.
		System.out.println(list);
		
		shuffle(list);
		System.out.println(list);
		
		sort(list, reverseOrder()); // 역순정렬 reverse(list)와 동일
		System.out.println(list);
		
		sort(list);
		System.out.println(list);
		
		int idx = binarySearch(list, 3); // 3이 저장된 위치(index)를 반환
		System.out.println("index of 3 = " + idx);
		
		System.out.println("max = " + max(list));
		System.out.println("min = " + min(list));
		System.out.println("min = " + max(list, reverseOrder()));
		
		fill(list, 9); // list를 9로 가득 채운다.
		System.out.println(list);
		
		List newList = nCopies(list.size(), 2);
		// list와 같은 크기의 새로운 list를 생성하고 2로 채운다. 단, 결과는 변경 불가하다. 
		System.out.println("newList = " + newList);
		
		System.out.println(disjoint(list, newList)); // 두 객체의 공통요소가 없을때 true
		
		copy(list, newList);
		System.out.println("newList = " + newList);
		System.out.println("list = " + list);
		
		replaceAll(list, 2, 1);
		System.out.println("list = " + list);
		
		Enumeration e = enumeration(list);
		ArrayList list2 = list(e);
		
		System.out.println("list2 = " + list2);
	}

}

/*
Collections
 - 컬렉션을 위한 메서드(static)를 제공
   - 예 : Objects(객체), Arrays(배열), Collections(컬렉션) 등등
   
 - 컬렉션 채우기, 복사, 정렬, 검색 : fill(), copy(), sort(), binarySearch() 등
 
 - 컬렉션의 동기화 : synchronizedXXX()
   - static Collection synchronizedCollection(Collection c)
   - static List synchronizedList(List list)
   - static Set synchronizedSet(Set s)
   - static Map synchronizedMap(Map m)
   - static SortedSet synchronizedSortedSet(SortedSet s)
   - static SortedMap synchronizedSortedMap(SortedMap m)
   - 사용방법
     - List syncList = Collections.synchronizedList(new ArrayList(...));
       - syncList = 동기화된 리스트(Vector와 비슷하다.) , new ArrayList = 동기화되지 않은 리스트

 - 변경불가(readOnly) 컬렉션 만들기 : unmodifiableXXX() >> 수정 불가
   - static Collection unmodifiableCollection(Collection c)
   - static List unmodifiableList(List list)
   - static Set unmodifiableSet(Set s)
   - static Map unmodifiableMap(Map m)
   - static NavigableSet unmodifiableNavigableSet(NavigableSet s)
   - static SortedSet unmodifiableSortedSet(SortedSet s)
   - static NavigableMap unmodifiableNavigableMap(NavigableMap m)
   - static SortedMap unmodifiableSortedMap(SortedMap m)
   
 - 실글톤 컬렉션 만들기 : singletonXXX() >> 객체 1개만 저장하게 만든다.
   - static List singletonList(Object o)
   - static Set singleton(Object o) // singletonSet이 아니다!!
   - static Map singletonMap(Object key, Object value)
   
 - 한 종류의 객체만 저장하는 컬렉션 만들기 : checkedXXX() >> 제네릭스와 기능이 같다.
   JDK 1.5 이후로 제네릭스가 나왔기 떄문에 그 전버전에서는 checkedXXX()를 사용했다.
   - static Collection checkedCollection(Collection c, class type)
   - static List checkedList(List list, class type)
   - static Set checkedSet(Set s, class type)
   - static Map checkedMap(Map m, class keyType, class valueType)
   - static Queue checkedQueue(Queue queue, class type)
   - static NavigableSet checkedNavigableSet(NavigableSet s, class type)
   - static SortedSet checkedSortedSet(SortedSet s, class type)
   - static NaviagbleMap checkedNavigableMap(NavigableMap m, class keyType, class valueType)
   - static SortedMap checkedSortedMap(SortedMap m, class keyType, class vlaueType)
     - 사용방법
       - List list = new ArrayList();
       - List checkedList = checkedList(list, String.class); // String만 저장 가능
       - checkedList.add("abc"); // ok
       - checkedList.add(new Integer(3)); // Error
       
       
최종 컬렉션 클래스 정리 및 요약
 - ArrayList, Vector는 배열기반이다.
   - 이걸 기준으로 만든게 Stack (Last in first out) 구조
 - 비순차적 추가 및 삭제 효율성 나쁘다.
   - 이결 해결하려고 LinkedList를 만들었다.
     - 이걸 기준으로 만든게 Queue (First in First out) 구조
     
 - HashMap, Hashtable은 배열기반과 LinkedList를 장점을 합쳐서 만든것이다.
   - HashMap에서 key만 빼서 만든게 HashSet이다.
     - 순서가 없지만 순서를 만들고 싶을때는 LinkedHashSet를 편하다.
 
 - LinkedList를 기준으로 TreeSet을 만들었다.
   - 중위 순회하면 정렬이 된다.
*/

