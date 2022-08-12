import java.util.Arrays;

public class ArraysTest {

	public static void main(String[] args) {
		// 예제
		int[] arr = {0,1,2,3};
		int[][] arr2D = {{11,12,13},{21,22,23}};
		
		System.out.println("arr = " + Arrays.toString(arr));
		System.out.println("arr2D = " + Arrays.deepToString(arr2D));
		System.out.println("다차원 배열을 그냥 toString()을 사용하면 = " + Arrays.toString(arr2D));
		
		int[] arr2 = Arrays.copyOf(arr, arr.length); // {0,1,2,3}
		int[] arr3 = Arrays.copyOf(arr, 3); // {0,1,2}
		int[] arr4 = Arrays.copyOf(arr, 7); // {0,1,2,3,0,0,0}
		int[] arr5 = Arrays.copyOfRange(arr, 2, 4); // {2,3}
		int[] arr6 = Arrays.copyOfRange(arr, 0, 7); // {0,1,2,3,0,0,0}
		
		System.out.println("arr2 = " + Arrays.toString(arr2));
		System.out.println("arr3 = " + Arrays.toString(arr3));
		System.out.println("arr4 = " + Arrays.toString(arr4));
		System.out.println("arr5 = " + Arrays.toString(arr5));
		System.out.println("arr6 = " + Arrays.toString(arr6));
		
		int[] arr7 = new int[5];
		Arrays.fill(arr7, 9); // {9,9,9,9,9}
		System.out.println("arr7 = " + Arrays.toString(arr7));
		
		Arrays.setAll(arr7, i -> (int)(Math.random()*6)+1); // 람다식
		// 1~6 난수 (정수)
		System.out.println("arr7 = " + Arrays.toString(arr7));
		
		for(int i : arr7) { // int i = 0; i < arr7.length; i++
			// arr7 배열에 있는 요소를 하나씩 꺼내서 i에 저장한다.
			char[] graph = new char[i];
			Arrays.fill(graph, '*'); // 문자 배열에 가득 *을 넣고
			System.out.println(new String(graph) + i); // 문자 배열을 문자열로 변환하고 +i 하고 출력
			// String => char[]로 바꾸는 방법은 toCharArray()
			// char[] => String으로 바꾸는 방법은 new String(char[])
		}
		
		String[][] str2D1 = new String[][]{{"aaa","bbb"},{"AAA","BBB"}};
		String[][] str2D2 = new String[][]{{"aaa","bbb"},{"AAA","BBB"}};
		
		System.out.println(Arrays.deepEquals(str2D1, str2D2)); // true
		System.out.println(Arrays.equals(str2D1, str2D2)); // false
		
		char[] chArr = {'A','D','C','B','E'};
		
		System.out.println("chArr = " + Arrays.toString(chArr));
		System.out.println("index of B = " + Arrays.binarySearch(chArr, 'B')); // 정확한 값 나오지 않음 ( 정렬 전이라서 )
		System.out.println("=After sorting=");
		Arrays.sort(chArr);
		System.out.println("chArr = " + Arrays.toString(chArr));
		System.out.println("index of B = " + Arrays.binarySearch(chArr, 'B')); // 1

	}

}

/*
Arrays는 배열을 다루기 편리한 메서드(static)를 제공한다.
1. 배열의 출력 >> static String toString(Type Value)
   - Type : boolean[],byte[],char[],short[],int[],long[],float[],double[],Object[]
2. 배열의 복사 >> copyOf(), copyOfRange()
   - 새로운 배열을 만들어서 반환한다.
   - int arr = {0,1,2,3,4};
   - int[] arr2 = Arrays.copyOf(arr, arr.length); >> arr2 = [0,1,2,3,4]
   - int[] arr3 = Arrays.copyOf(arr, 3) >> arr3 = [0,1,2]
   - int[] arr4 = Arrays.copyOf(arr, 7) >> arr4 = [01,2,3,4,0,0]
   - int[] arr5 = Arrays.copyOfRange(arr,2,4) >> arr5 = [2,3]
   - int[] arr6 = Arrays.copyOfRange(arr,0,7) >> arr6 = [0,1,2,3,4,0,0]
3. 배열 채우기 >> fill(), setAll()
   - int[] arr = new int[5];
   - Arrays.fill(arr,9) >> arr = [9,9,9,9,9]
   - Arrays.setAill(arr, (i) -> (int)(Math.random()*5)+1); // arr = [1,5,2,1,1]
     - (i)->(int)(Math.random()*5)+1 >> 람다식 표현
4. 정렬과 검색 >> sort(), binarySearch()
   - int[] arr = {3,2,0,1,4}
   - int idx = Arrays.binarySearch(arr, 2); >> idx = -5 <- 잘못된 결과가 나오는데 이유는 정렬되지 않았기 때문이다.
     - binarySearch()메서드는 정렬된 배열애서만 사용이 가능하다.
   - Arrays.sort(arr); >> 배열 arr을 오름차순으로 정렬한다.
   - System.out.println(Arrays.toString(arr)); >> [0,1,2,3,4]
   - int idx = Arrays.binarySearch(arr, 2); >> idx = 2 <- 올바른 결과
     - binarySearch(arr, 2) >> 배열 arr에서 값이 2인 위치를 반환한다.
   
알아보면 도움 되는 순차 탐색과 이진 탐색(binary)
 - 순차탐색 : 앞에서 부터 순서대로 찾는 방법 ( 정렬이 안되 있는 경우 사용한다. )
 - 이진탐색 : 정렬되 있는 상태에서 반씩 나눠서 비교하며 찾는다.
 
5. 다차원 배열의 출력 >> deepToString()
   - int[] arr = {0,1,2,3,4};
   - int[][] arr2D = {{11,12},{21,22}};
   - System.out.println(Arrays.toString(arr)); >> [0,1,2,3,4]
   - System.out.println(Arrays.deepToString(arr2D); >> [[11,12],[21,22]]
6. 다차원 배열의 비교 >> deepEquals()
   - String[][] str2D1 = new String[][]{{"aaa","bbb"},{"AAA","BBB}};
   - String[][] str2D2 = new String[][]{{"aaa","bbb"},{"AAA","BBB"}};
   - System.out.println(Arrays.equals(str2D1, str2D2)); >> false
     - Arrays.equals(배열1, 배열2)는 1차원 배열의 비교에서 사용해야 제대로 된 값이 나온다.
   - System.out.println(Arrays.deepEquals(str2D1, str2D2); >> true
7. 배열을 List로 변환 - asList(Object...a)
   - asList(매개변수) : 매개변수는 가변 매개변수이기 때문에 몇개를 넣어도 상관없다
     - 배열을 넣어도 되고 요소를 넣어도된다.
   - List list = Arrays.asList(new Integer[]{1,2,3,4,5}); >> list = [1,2,3,4,5]
   - List list = Arrays.asList(1,2,3,4,5); >> list = [1,2,3,4,5]
   - list.add(6); >> UnsupportedOperationException 예외 발생
     - List는 읽기 전용이기 때문에 add 할 수 없다.
   - List list = new ArrayList(Arrays.asList(1,2,3,4,5)); >> List타입의 참조변수 list에 새로운 ArrayList를 만든다.
     - ArrayList는 add로 추가할 수 있다.
8. 람다와 스트림 관련 >> parallelXXX(), spliterator(), stream() - 설명 생략
   - 14장에서 배운다.
*/