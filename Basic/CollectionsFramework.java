import java.util.ArrayList;
import java.util.Collections;

public class CollectionsFramework {

	public static void main(String[] args) {
		// 예제 1
		ArrayList list1 = new ArrayList(10);
		// 기본 길이(용량, capacity)가 10인 ArrayList를 생성
		list1.add(new Integer(5));
		list1.add(new Integer(4));
		list1.add(new Integer(2));
		list1.add(new Integer(0));
		list1.add(new Integer(1));
		list1.add(new Integer(3));
		list1.add(7); // autoboxing에 의해 기본형이 참조형으로 자동변환된다.
		// 컴파일 시 new Integer(7)로 바꿔준다.
		
		// 생성자에서 ArrayList(Collection c)를 사용한 것이다.
		ArrayList list2 = new ArrayList(list1.subList(1, 4));
		print(list1, list2);
		
		// list1과 list2를 오름차순 정렬한다.
		// Collection은 인터페이스 Collections는 유틸 클래스
		Collections.sort(list1);
		Collections.sort(list2);
		print(list1, list2);
		
		// list1가 list2의 모든 요소를 포함하고 있는지 물어보는 메서드이다.
		System.out.println("list1.containsAll(list2) = " + list1.containsAll(list2));
		System.out.println();
		
		list2.add("B");
		list2.add("C");
		list2.add(3, "A"); // 위치 지정하여 추가 (부담이 되는 작업이다.)
		print(list1, list2);
		
		list2.set(3, "AA"); // 위치 지정하여 객체 변경
		print(list1, list2);
		
		list1.add(0, "1");
		// indexOf()는 지정된 객체의 위치(인덱스)를 알려준다.
		System.out.println("index = " + list1.indexOf("1"));
		list1.remove("1"); // 0번쨰 "1" 삭제된다.
//		list1.remove(1); // 인덱스 1인 객체 삭제
		list1.remove(new Integer(3)); // 객체 값이 3인걸 삭제 (삭제할 때는 중요)
		print(list1, list2);
		
		// list1에서 list2와 겹치는 부분만 남기고 나머지 삭제한다.
		System.out.println("list1.retainAll(list2) = " + list1.retainAll(list2));
		print(list1, list2);
		
		// lsit2에서 list1에 포함된 객체들을 삭제한다.
		for(int i = list2.size()-1; i >= 0; i--) {
			if(list1.contains(list2.get(i))) {
				list2.remove(i);
			}
		}
		print(list1, list2);
	}
	static void print(ArrayList a, ArrayList b) {
		System.out.println("list1 = " + a);
		System.out.println("list2 = " + b);
		System.out.println();
	}
}
/*
컬렉션(collection)
 - 여러 객체를 모아 놓은 것을 의미
프레임웍(framework)
 - 표준화, 정형화된 체계적인 프로그래밍 방식
 
컬렉션 프래임웍
 - 컬렉션(다수 객체)을 다루기 위한 표준화된 프로그래밍 방식
 - 컬렉션(다수 객체)을 쉽고 편리하게 다룰 수 있는 다양한 클래스(컬렉션 클래스) 제공
   - 저장, 삭제, 검색, 정렬 등등
 - java.util 패키지에 포함되어있다. (JDK 1.2부터 제공)
컬렉션 클래스
 - 다수의 데이터를 저장할 수 있는 클래스 (예: Vector, ArrayList, HashSet)
 
컬렉션 프레임웍의 핵심 인터페이스 ( 중요 )
 - List ( 순서 o, 중복 o )
 	- 순서가 있는 데이터의 집합, 데이터 중복을 허용한다. ( 예: 대기자 명단 )
 	  - 구현 클래스 : ArrayList(핵심), LinkedList(핵심), Stack, Vector 등
 - Set [집합] ( 순서 x, 중복 x )
   - 순서를 유지하지 않는 데이터의 집합, 데이터의 중복을 허용하지 않는다. ( 예: 양의 정수 집합, 소수의 집합 )
     - 구현 클래스 : HashSet(핵심), TreeSet(핵심) 등
List와 Set의 부모 인터페이스는 Collection 인터페이스이다.

 - Map ( 순서 x 중복 key x value o )
   - 키(key)와 값(value)의 쌍으로 이루어진 데이터의 집합
   - 순서는 유지되지 않으며, 키는 중복을 허용하지 않고, 값은 중복을 허용한다. ( 예: 우편번호, 지역번호(전화번호))
     - 구현 클래스 : HashMap(핵심), TreeMap(핵심), Hashtable, Properties 등
     
Collection 인터페이스의 메서드
 [추가]===================================================
 - boolean add(Object o)
 - boolean addAll(Collection c)
   - 지정된 객체(o)또는 Collection(c)의 객체들을 Collection에 추가한다.
 ========================================================
 
 [전체 삭제]================================================
 - void clear()
   - Collection의 모든 객체를 삭제한다.
 ========================================================
 
 [검색]===================================================
 - boolean contains(Object o)
 - boolean containsAll(Collection c)
   - 지정된 객체(o)또는 Collection(c)의 객체들이 Collection에 포함되어 있는지 확인한다.
 ========================================================

 - boolean equals(Object o)
   - 동일한 Collection인지 비교한다.
 - int hashCode()
   - Collection의 hash code를 반환한다.
 - boolean isEmpty()
   - Collection이 비어있는지 확인한다.
 - Iterator iterator()
   - Collection의 iterator를 얻어서 반환한다.
   
 [삭제]===================================================
 - boolean remove(Object o)
   - 지정된 객체(o)를 삭제한다.
 - boolean removeAll(Collection c)
   - 지정된 Collection에 포함된 객체들을 삭제한다.
 ========================================================

 - boolean retainAll(Collection c)
   - 지정된 Collection(c)에 포함된 객체만을 남기고 다른 객체들은 Collection에서 삭제한다.
   - 이 작업으로 인해 Collection에 변화가 있으면 true 없으면 false를 반환한다.
 - int size()
   - Collection에 저장된 객체의 개수를 반환한다.
 - Object[]toArray()
   - Collection에 저장된 객체를 객체배열(Object[])로 반환한다.
 - Object[]toArray(Object[] a)
   - 지정된 배열에 Collection의 객체를 저장해서 반환한다.
   
List 인터페이스의 메서드 - 순서 o 중복 o
 [추가]
 - void add(int index, Object element)
 - boolean addAll(int index, Collection c)
   - 지정된 위치(index)에 객체(element) 또는 컬렉션에 포함된 객체들을 추가한다.
 [get 읽기]
 - Object get(int index)
   - 지정된 위치(index)에 있는 객체를 반환한다.
 [검색]
 - int indexOf(Object o)
   - 지정된 객체의 위치를 반환한다. (List의 첫번째 요소부터 순반향으로 찾는다.)
 - int lastIndexOf(Object o)
   - 지정된 객체의 위치를 반환한다. (List의 마지막 요소부터 역방향으로 찾는다.)
   
 - ListIterator listIterator()
 - ListIterator listIterator(int index)
   - List의 객체에 접근할 수 있는 ListIterator를 반환한다.
 [삭제]
 - Object remove(int index)
   - 지정된 위치에 있는 객체를 삭제하고 삭제된 객체를 반환한다.
 [set 변경]
 - Object set(int index, Object element)
   - 지정된 위치(index)에 객체(element)를 저장한다.
 [sort 정렬]
 - void sort(Comparator c)
   - 지정된 비교자(Comparator)로 List를 정렬한다.
 - List subList(int fromIndex, int toIndex)
   - 지정된 범위(fromIndex부터 toIndex)에 있는 객체를 반환한다.
   
Set 인터페이스의 메서드 - 순서 x 중복 x
 - 대부분이 Collection 메서드와 같다.
 - 집합과 관련된 메서드( Collection에 변화가 있다면 true, 아니면 false )
   - boolean addAll(Collection c)
     - 지정된 Collection(c)의 객체들을 Collection에 추가한다. (합집합)
   - boolean containsAll(Collection c)
     - 지정된 Collection의 객체들이 Collection에 포함되어 있는지 확인한다. (부분집합)
   - boolean removeAll(Collection c)
     - 지정된 Collection에 포함된 객체들을 삭제한다. (차집합)
   - boolean retainAll(Collection c)
     - 지정된  Collection에 포함된 객체만을 남기고 나머지는 Collection에서 삭제한다. (교집합)
     
Map 인터페이스의 메서드 - 순서 x 중복(키 x 값 o)
 - void clear()
   - Map의 모든 객체를 삭제한다.
 [검색1]
 - boolean containsKey(Object key)
   - 지정된 key객체와 일치하는 Map의 key객체가 있는지 확인한다.
 - boolean containsValue(Object value)
   - 지정된 value객체와 일치하는 Map의 value객체가 있는지 확인한다.
 [key와 value 모두 읽기]
 - Set entrySet()
   - Map에 저장되어 있는 key-value쌍을 Map.entry타입의 객체로 저장한 Set으로 반환한다.
   
 - boolean equals(Object o)
   - 동일한 Map인지 비교한다.
   
 [검색2]
 - Object get(Object key)
   - 지정된 key객체에 대응하는 value객체를 찾아서 반환한다.
   
 - int hashCode()
   - 해시코드를 반환한다.
 - boolean isEmpty()
   - Map이 비어있는지 확인한다.
   
 [key만 읽기]
 - Set keySet()
   - Map에 저장된 모든 key객체를 반환한다.
   
 [추가]
 - Object put(Object key, Object value)
   - Map에 value객체를 key객체에 연결(mapping)하여 저장한다.
 - void putAll(Map t)
   - 지정된 Map의 모든 key-value쌍을 추가한다.
 [삭제]
 - Object remove(Object key)
   - 지정한 key객체와 일치하는 key-value객체를 삭제한다.
   
 - int size()
   - Map에 저장된 key-value쌍의 개수를 반환한다.
   
 [value만 읽기]
 - Collection values()
   - Map에 저장된 모든 value객체를 반환한다.
   
==========================================================
List 인터페이스의 구현 클래스 ArrayList - 순서 o 중복 o
 - ArrayList는 기존의 Vector를 개선한 것으로 구현원리와 기능적으로 동일
 - ArrayList 자체적 동기화 x, Vector 자체적 동기화 o
 - 데이터의 저장공간으로 배열을 사용한다. (배열 기반)

ArrayList의 메서드
 - ArrayList 생성자
   - ArrayList() : 기본 생성자
   - ArrayList(Collection c)
   - ArrayList(int initialCapacity) : 배열의 길이 지정 (넉넉히)
 - ArrayList 추가
   - boolean add(Object o)
   - void add(int index, Object element)
   - boolean addAll(Collection c)
   - boolean addAll(int index, Collection c)
 - ArrayList 삭제
   - boolean remove(Object o)
   - Object remove(int index)
     [0,1,2,3,4,null,null]에서 data.remove(2); [인덱스 2번 삭제]
     - 삭제과정 
       1. 삭제할 데이터 다음 데이터를 한 칸씩 앞으로 복사해서 삭제할 데이터를 덮어쓴다.
          - System.arraycopy(data, 3, data,2,2)
            - data[3]에서 data[2]로 2개의 데이터를 복사해라라는 의미이다.
          - 리스트의 마지막 값을 삭제할떄는 이 과정은 필요없다.
       2. 데이터가 모두 한칸씩 이동했으면 마지막 데이터는 null로 변경한다.
          - data[size-1] = null;
       3. 데이터가 삭제되어 데이터의 개수가 줄었으므로 size의 값을 감소시킨다.
          - size--;
   - boolean removeAll(Collection c)
   - void clear()
 - ArrayList 검색
   - int indexOf(Object o) : 순방향 > 못찾으면 -1
   - int lastindexOf(Object o) : 역방향 > 못찾으면 -1
   - boolean contains(Object o) : 존재 여부
   - Object get(int index) : 읽기
   - Object set(int index, Object element) : 변경
 - 그 외
   - List subList(int fromIndex, int toIndex) : 리스트에서 fromIndex부터 toIndex까지 뽑아서 새로운 리스트를 만든다.
   - Object[] toArray() : 객체 배열 반환
   - Object[] toArray(Object[] a) :
   - boolean isEmpty() : 비어있는지
   - void trimToSize() : 빈공간 제거
   - int size() : 저장된 객체의 개수
   
====================================================================
List 인터페이스의 구현 클래스 LinkedList - 순서 o 중복 o
 - 배열의 장단점
   - 장점 : 구조가 간단하고 데이터를 읽는 데 걸리는시간(접근시간)이 짧다.
     - 배열은 연속적이다. 공간당 4byte arr[0] = 100 arr[1] = 104
       - 인덱스 N인 데이터 주소 = 배열의 주소 + N * 데이터타입의 크기
   - 단점1 : 크기를 변경할 수 없다. (실행 중)
     - 크기를 변경해야 하는 경우 새로운 배열을 생성한 후 데이터를 복사하고 참조변수에 새로운 배열의 주소를 넣어줘야한다.
     - 크기 변경을 피하기 위해 큰 배열을 생성하면 메모리가 낭비된다.
   - 단점2 : 비 순차적인(배열 중간에서 행해지는것) 데이터 추가, 삭제에 시간이 많이 걸린다.
     - 비 순차적인 데이터 추가 및 삭제하기 위해 다른 데이터를 옮겨야 한다.
     - 그러나 순차적인 데이터 추가(끝에 추가) 및 삭제(끝부터 삭제)는 빠르다.
     
 - LinkedList는 배열의 단점을 보완하기 위해 나왔다.
   - 배열과 달리 LinkedList는 불연속적으로 존재하는 데이터를 연결한 것이다.
   - 단점 : 데이터에 접근성이 나쁘다.	
     - 이를 보완하기 위해 doubly linked list를 만들었다. (이중 연결 리스트, 접근성 향상)
   - 데이터 삭제
     - 단 한번의 참조변경만으로 가능
        class Node{
            Node next; // 다음 노드
            Object ocj; // 데이터
        }
   - 데이터 추가
     - 한번의 Node객체 생성과 두번의 참조변경만으로 가능


 - doubly linked list
   class Node{
       Node next; // 다음요소
       Node previous; // 이전 요소
       Object obj;
   }

- doubly circular linked list : 이중 원형 연굘 라스트

ArrayList vs LinkedList
순차적 추가히기 ArrayList WIN
순차적 삭제하기 ArryList WIN
비 순차적으로 데이터를 추가 취소합니다
비순차적 데이터 추가 및 삭제 LinkedList WIN
접근시간 ArrayList WIN 





*/