import java.util.Arrays;
import java.util.Comparator;

public class ComparatorAndComparable {

	public static void main(String[] args) {
		// 예제1
		String[] strArr = {"cat","Dog","lion","tiger"};
		
		Arrays.sort(strArr); // String의 Comparable 구현의 의해 정렬된다.
		System.out.println("strArr = " + Arrays.toString(strArr));
		// 대문자와 소문자가 있다면 사전순으로 대문자가 더 우위에 있다.
		
		Arrays.sort(strArr/*정렬대상*/, String.CASE_INSENSITIVE_ORDER/*정렬기준*/); // 대소문자 구분하지 않고 정렬해라
		System.out.println("strArr = " + Arrays.toString(strArr));
		
		Arrays.sort(strArr, new Descending());
		System.out.println("strArr = " + Arrays.toString(strArr));
	}
}

// 예제1
class Descending implements Comparator{
	public int compare(Object o1, Object o2) {
		if (o1 instanceof Comparable && o2 instanceof Comparable) {
			Comparable c1 = (Comparable)o1;
			Comparable c2 = (Comparable)o2;
			return c1.compareTo(c2) * -1; // -1을 곱해서 기본정렬(오름차순)의 역으로 변경한다.
			                              // 또는 c2.compareTo(c1)으로 순서를 변경해도 된다.
		}
		return -1;
	}
	
}
/*
객체 정렬에 필요한 메서드(정렬기준 제공)를 정의한 인터페이스
  - Comparable : (default)기본 정렬기준을 구현하는데 사용
    // sort()로 정렬 할때 정렬기준을 생략할 수 있다.
  
    public interface Comparable{
        int compareTo(Object o); // 주어진 객체(o)를 자신과 비교한다. 
    }
    
  - Comparator : 기본 정렬기준 외에 다른 기준으로 정렬하고자 할때 사용
  
    public interface Comparator{
        int compare(Object o1, Object o2); // o1,o2 두 객체를 비교한다.
        // 결과가 0이면 같다, 양수면 o1이 크다, 음수면 o2가 크다
        boolean equals(Object obj); // equals를 오버라이딩하라는 뜻이다.
    }

  - compare()와 compareTo()는 두 객체의 비교결과를 반환하도록 작성한다.
    
    public final class Integer extends Number implements Comparable{
        ...
        public int compareTo(Object o){
            return compareTo((Integer)o);
        }
        public int compareTo(Integer anotherInteger){
            int v1 = this.value;
            int v2 = anotherInteger.value;
            >> 같으면 0, 오른쪽이 크면 -1, 왼쪽이 크면 1 반환
            return (v1 < v2 ? -1 : (v1 == v2 ? 0 : 1);  
            >> return v1-v2; // 내림 차순의 경우 반대로 뺼셈하면 된다. ( 위에 삼항연산자를 사용하는게 효율성에서 좋다 )           
        }
        ...
    }
    
  - sort 메서드 ( 정렬 방법은 불변이다. 기준이 달라지는 것이다. )    
    static void sort(int[] intArr){
        for(int i = 0; i < intArr.length-1; i++){
            for(int j = 0; j < intArr.length-1-i; j++){
                int tmp = 0;
                if(intArr[j] > intArr[j+1]){ >> 두개 비교
                    >> 자리 바꿈
                    tmp = intArr[j];
                    intArr[j] = intArr[j+1];
                    intArr[j+1] = tmp;
                }
            }
        }
    }
 */