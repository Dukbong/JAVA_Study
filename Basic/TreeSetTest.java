import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetTest {

	public static void main(String[] args) {
		// 예제 1
		Set set = new TreeSet();
		// 정렬이 필요없다. TreeSet 내부에서 정렬을 한다.
		
		for(int i = 0; set.size() < 6; i++) {
			int num = (int)(Math.random()*45) + 1;
			set.add(num); // set.add(new Integer(num));
		}
		
		System.out.println(set);
		
		
		// 저장할 객체와 정렬 기준을 따로 따로 만들었을때
		Set set3 = new TreeSet(new TestComp());
		
//		for (int k = 0; set3.size() < 6; k++) {
//			int num = (int)(Math.random()*45) + 1;
			 set3.add(new TestTreeSet());
			 set3.add(new TestTreeSet());
			 set3.add(new TestTreeSet());
			// Error를 해결하기 위해 정렬기준을 만들었고 생성자에 넣어줬다.
//		}
		System.out.println(set3);
		
		// 저장할 객체에게 정렬 기준까지 부여했을때
		Set set4 = new TreeSet();
		
		set4.add(new AllInComp());
		set4.add(new AllInComp());
		set4.add(new AllInComp());
		
		System.out.println(set4);
		
		// 위 코드를 HashSet으로 만들면?
		
		Set set2 = new HashSet();
		
		for(int j = 0; set2.size() < 6; j++) {
			int num = (int)(Math.random()*45) + 1;
			set2.add(num); // == set2.add(new Integer(num));
		}
		
		List list = new LinkedList(set2); // HashSet은 정렬이 필요하다.
		// Set은 순서가 없기 때문에 순서가 있는 list로 형 변환 후 정렬을 진행해야한다.
		Collections.sort(list);
		System.out.println(list);
		
		//예제 2
		TreeSet set5  = new TreeSet();
		
		String from = "b";
		String to = "d";
		
		set5.add("abc");  set5.add("alien"); set5.add("bat");
		set5.add("car"); set5.add("Car"); set5.add("disc");
		set5.add("dance"); set5.add("dZZZZ"); set5.add("dzzzz");
		set5.add("elephant"); set5.add("elevator");
		set5.add("fan"); set5.add("flower");
		
		System.out.println(set5);
		System.out.println("range search : from " + from + " to " + "to");
		System.out.println("result1 = " + set5.subSet(from, to));
		System.out.println("result2 = " + set5.subSet(from, to + "zzz"));
		
		// 예제3
		TreeSet set6 = new TreeSet();
		int[] score = {80,95,50,35,45,65,10,100};
		
		for (int i = 0; i < score.length; i++) {
			set6.add(new Integer(score[i]));
		}
		System.out.println("50보다 작은 값 =" + set6.headSet(new Integer(50)));
		System.out.println("50보다 큰값 =" + set6.tailSet(50));
		System.out.println("40과 80사이의 큰값  = " + set6.subSet(40, 80));
		

	}

}

class TestTreeSet{} // 비교 기준 없음
class TestComp implements Comparator{

	@Override
	public int compare(Object arg0, Object arg1) {
		// TODO Auto-generated method stub
		return 1; // 0은 객체를 같은거로 인지 1, -1은 다른 객체로 인지
	}
	
}

class AllInComp implements Comparable{

	@Override
	public int compareTo(Object arg0) {
		// TODO Auto-generated method stub
		return -1;
	}
	
}


/*
TreeSet
 - 이진 탐색 트리(binary search tree)로 구현, 범위 탐색과 정렬에 유리하다.
 - 이진 트리는 모든 노드가 최대 2개(0~2개)의 하위 노드를 갖는다. 
   - root -> A -> C (A의 자식) 
          |    |
          |    |
          |    -> D (A의 자식)
          |
          -> B -> E (B의 자식)
    
 - TreeSet 기본 형태
    class TreeNode{
        TreeNode left; // 외쪽 자식노드
        Object element; // 저장할 객체
        TreeNode right; // 오른쪽 자식노드
    }
 - 이진 탐색 트리 ( 이진 트리의 종류 중 1개이며 TreeSet은 이진 탐색 트리이다.)
   - 부모보다 작은 값은 왼쪽, 큰 값은 오른쪽에 저장한다.
   - 데이터가 많아 질수록 추가, 삭제에 효율성이 떨어진다. (비교 횟수가 증가)
     - 1) 비교 ( 5 < 7 )
       7--9
       |
       2) 비교 ( 5 > 4 )
       3) 5를 오른쪽에 저장 
       4--5
       |
       1
   - 데이터 저장과정 boolean add(Object o)
     - equals()와 hashCode()를 자동으로 호출해서 값을 비교한다.
     - Set은 중복을 허용하지 않기 때문이다.

TreeSet의 주요 생성자 및 메서드
 - TreeSet만 가지고 있는 메서드들만 적어본다.
 - add, remove, size, isEmpty 등 계속 반복적으로 나오는건 생략하였다.
 -
 - TreeSet() : 기본 생성자
 - TreeSet(Collection c) : 주어진 Collection(c)를 저장한 TressSet 생성
 - TreeSet(Comparator comp) : 주어진 정렬 기준(comp)으로 정렬하는 TreeSet 생성
 - Object first() : 정렬된 순서에서 첫번째 객체를 반환한다.
 - Object last() : 정렬된 순서에서 마지막 객체를 반환한다.
 - Object ceiling(Object o) : 지정된 객체 (o)와 같은 객체를 반환
   - 없으면 큰 값을 가진 객체 중 가장 가까운 값의 객체를 반환 그것조차 없으면 null 반환
 - Object floor(Object o) : 지정된 객체(o)와 같은 객체를 반환
   - 없으면 작은 값을 가진 객체 중 가장 가까운 값의 객체를 반환 그것조차 없으면 null 반환
 - Object higher(Object o) : 지정된 객체(o)보다 큰값을 가진 객체 중 제일 가까운 값의 객체를 반환
   - 없으면 null 반환
 - Object lower(Object o) : 지정된 객체(o)보다 작은 값을 가진 객체 중 제일 가까운 값의 객체를 반환
   - 없으면 null 반환
 - SortedSet subSet(Object fromElement, Object toElement)
   - 범위 검색(formElement <= x < toElement)의 결과를 반환한다.
 - SortedSet headSet(Object toElement) : 지정된 객체(o)보다 작은 값의 모든 객체를 반환한다.
 - SortedSet tailSet(Object fromElement) : 지정된 객체(o)보다 큰 값의 모든 객체를 반환한다.
   
   
   
알아 두면 유용한  트리 순회 
 - 이진 트리의 모든 노드를 한번씩 읽는것을 트리 순회라고 한다.
   - 전위 순회, 후위 순회, 레벨순회, 중위 순회가 있습니다.
     - 중위 순회를 하면 자동으로 오름차순 정렬이 가능하다.
   
   
 */