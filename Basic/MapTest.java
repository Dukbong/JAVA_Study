import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class MapTest {

	public static void main(String[] args) {
		// 예제 1
		 HashMap map = new HashMap();
		 map.put("myid", "1234");
		 map.put("asdf", "1111");
		 map.put("asdf", "1234");
		 
		 Scanner s = new Scanner(System.in);
		 
		 while(true) {
			 System.out.println("id와 비밀번호를 입력하세요.");
			 System.out.print("id : ");
			 String id = s.nextLine().trim();
			 
			 System.out.println("pw : ");
			 String pw = s.nextLine().trim();
			 System.out.println();
			 
			 if(!map.containsKey(id)) {
				 System.out.println("입력하신 id는 존재하지 않스니다. 다시 입력하세요.");
				 continue;
			 }
			 
			 if(!(map.get(id).equals(pw))) {
				 System.out.println("비밀번호가 일치하지 않습니다. 다시 입력해주새요.");
			 }else {
				 System.out.println("id와 pw가 일치합니다.");
				 break;
			 }
		 }
		 
		 // 예제2
		 HashMap map2 = new HashMap();
		 map2.put("jang", 90);
		 map2.put("jang", new Integer(100));
		 map2.put("choi", new Integer(100));
		 map2.put("hong", new Integer(80));
		 map2.put("wuri", new Integer(90));
		 
		 Set set = map2.entrySet();
		 Iterator it = set.iterator();
		 
		 while(it.hasNext()) {
			 Map.Entry e = (Map.Entry)it.next();
			 System.out.println("이름 : " + e.getKey() + "점수 : " + e.getValue());
		 }
		 
		 set = map2.keySet();
		 System.out.println("참가자 명단 : " + set);
		 
		 Collection values = map.values();
		 it = values.iterator();
		 
		 int total = 0;
		 
		 while (it.hasNext()) {
			 Integer i = (Integer)it.next();
			 total = total + i.intValue();
		 }
		 
		 System.out.println("총점수 : " + total);
		 System.out.println("평균 : " + (float)total/set.size());
		 System.out.println("최고점수 : " + Collections.max(values) );
		 System.out.println("최저점수 : " + Collections.min(values));
		 
		 // 예제 3
		 String [] data = {"A","K","A","W","D","A","K","K","K","Z","D"};
		 HashMap map3 = new HashMap();
		 for (int i = 0; i < data.length; i++) {
			 if(map.containsKey(data[i])) {
				 int value = (int)map.get(data[i]);
				 map.put(data[i], value+1);
			 }else {
				 map.put(data[i],  1);
			 }
			 Iterator it2 = map.entrySet().iterator();
			 
			 while(it2.hasNext()) {
				 Map.Entry entry = (Map.Entry)it2.next();
				 int value2 = (int)entry.getValue();
				 System.out.println(entry.getKey() + ":" + printBar('#',value2) + " " + value2);
			 }
		 }
	}

}

/*
Map은 순서 x 중복(키 x 값 o)
 - HashMap과 Hashtable은 Map인터페이스를 구현, 데이터를 키와 값의 쌍으로 저장
   - HashMap은 동기화 x, Hashtable은 동기화 o ( Hashtable은 구버전이고 HashMap은 신버전이다.)

HashMap
 - 순서를 유지하려면 LinkedHashMap 클래스를 사용하면 된다.
TreeMap ( TreeSet과 유사하다. )
 - 범위 검색과 정렬에 유리한 컬렉션 클래스
 - HashMap보다 데이터 추가, 삭제 효율성이 떨어진다.
 
 
HashMap
 - 해싱(hashing)기법으로 데이터를 저장(put), 데이터가 많아도 검색이 빠르다.
   - 해싱이란? 해시 함수를 이용해서 해시테이블에 데이터를 저장하고 읽어오는 것이다.
     - 해시테이블은 배열(접근성)과 링크드 리스트(변경 유리)가 조합된 상태이다.
       - 해시테이블에 저장된 데이터를 가져오는 과정
         1) 키로 해시함수를 호출해서 해시코드를 얻는다.
         2) 해시코드에 대응하는 링크드리스트를 배열에서 찾는다.
         3) 링크드리스트에서 키와 일치하는 데이터를 찾는다.
           - 해시함수는 같은 키에 대해 항상 같은 hashcode를 반환해야한다.
           - 서로다른 키일지라도 같은 값의 hashcode가 반환될 수 도 있다.
   HashMap map = new HashMap(); >> 생성자
   map.put("Myid", "1234");
   map.put("asdf", "1111");
   map.put("asdf", "1234"); // key가 중복이 되면 같은 ksy에서 무조건 마지막값으로 저장된다.
   >> 최종 저장 결과
      key  value
      Myid 1234
      asdf 1234

HashMap의 주요 메서드
 - HashMap() : 기본 생성자
 - HashMap(int initialCapacity) : 생성자 (초기용량)
 - HashMap(int initialCapacity, float loadFactor)
 - HashMap(Map m)
 
 - Object put(Object key, Object value) : 추가
 - Object putAll(Map m) : 추가
 - Object remove(Object key) : 삭제
 - Object replace(Object key, Object value) : 변경
 - boolean replace(Object key, Object oldValue, Object newValue) : 변경
 
 >> 읽기
 - Set entrySet() : 키와 값 쌍으로 가져오기
 - Set keySet() : 키만 가져오기
 - Collection values() : 값만 가져오기
 
  - Object get(Object key) : 지정된 키(key)에 해당하는 value를 반환한다. 
  - Object getOrDefault(Object key, Object defaultValue) : 지정된 key가 없을때 고정된 값(defaultValue)을 반환한다.
  - boolean containsKey(Object key) : 키가 현재 HashMap에 존재하는지
  - boolean containsValue(Object value) : 값이 현재 HashMap에 존재하는지

*/