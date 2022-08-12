import java.util.Arrays;

public class ArraysTest {

	public static void main(String[] args) {
		// ����
		int[] arr = {0,1,2,3};
		int[][] arr2D = {{11,12,13},{21,22,23}};
		
		System.out.println("arr = " + Arrays.toString(arr));
		System.out.println("arr2D = " + Arrays.deepToString(arr2D));
		System.out.println("������ �迭�� �׳� toString()�� ����ϸ� = " + Arrays.toString(arr2D));
		
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
		
		Arrays.setAll(arr7, i -> (int)(Math.random()*6)+1); // ���ٽ�
		// 1~6 ���� (����)
		System.out.println("arr7 = " + Arrays.toString(arr7));
		
		for(int i : arr7) { // int i = 0; i < arr7.length; i++
			// arr7 �迭�� �ִ� ��Ҹ� �ϳ��� ������ i�� �����Ѵ�.
			char[] graph = new char[i];
			Arrays.fill(graph, '*'); // ���� �迭�� ���� *�� �ְ�
			System.out.println(new String(graph) + i); // ���� �迭�� ���ڿ��� ��ȯ�ϰ� +i �ϰ� ���
			// String => char[]�� �ٲٴ� ����� toCharArray()
			// char[] => String���� �ٲٴ� ����� new String(char[])
		}
		
		String[][] str2D1 = new String[][]{{"aaa","bbb"},{"AAA","BBB"}};
		String[][] str2D2 = new String[][]{{"aaa","bbb"},{"AAA","BBB"}};
		
		System.out.println(Arrays.deepEquals(str2D1, str2D2)); // true
		System.out.println(Arrays.equals(str2D1, str2D2)); // false
		
		char[] chArr = {'A','D','C','B','E'};
		
		System.out.println("chArr = " + Arrays.toString(chArr));
		System.out.println("index of B = " + Arrays.binarySearch(chArr, 'B')); // ��Ȯ�� �� ������ ���� ( ���� ���̶� )
		System.out.println("=After sorting=");
		Arrays.sort(chArr);
		System.out.println("chArr = " + Arrays.toString(chArr));
		System.out.println("index of B = " + Arrays.binarySearch(chArr, 'B')); // 1

	}

}

/*
Arrays�� �迭�� �ٷ�� ���� �޼���(static)�� �����Ѵ�.
1. �迭�� ��� >> static String toString(Type Value)
   - Type : boolean[],byte[],char[],short[],int[],long[],float[],double[],Object[]
2. �迭�� ���� >> copyOf(), copyOfRange()
   - ���ο� �迭�� ���� ��ȯ�Ѵ�.
   - int arr = {0,1,2,3,4};
   - int[] arr2 = Arrays.copyOf(arr, arr.length); >> arr2 = [0,1,2,3,4]
   - int[] arr3 = Arrays.copyOf(arr, 3) >> arr3 = [0,1,2]
   - int[] arr4 = Arrays.copyOf(arr, 7) >> arr4 = [01,2,3,4,0,0]
   - int[] arr5 = Arrays.copyOfRange(arr,2,4) >> arr5 = [2,3]
   - int[] arr6 = Arrays.copyOfRange(arr,0,7) >> arr6 = [0,1,2,3,4,0,0]
3. �迭 ä��� >> fill(), setAll()
   - int[] arr = new int[5];
   - Arrays.fill(arr,9) >> arr = [9,9,9,9,9]
   - Arrays.setAill(arr, (i) -> (int)(Math.random()*5)+1); // arr = [1,5,2,1,1]
     - (i)->(int)(Math.random()*5)+1 >> ���ٽ� ǥ��
4. ���İ� �˻� >> sort(), binarySearch()
   - int[] arr = {3,2,0,1,4}
   - int idx = Arrays.binarySearch(arr, 2); >> idx = -5 <- �߸��� ����� �����µ� ������ ���ĵ��� �ʾұ� �����̴�.
     - binarySearch()�޼���� ���ĵ� �迭�ּ��� ����� �����ϴ�.
   - Arrays.sort(arr); >> �迭 arr�� ������������ �����Ѵ�.
   - System.out.println(Arrays.toString(arr)); >> [0,1,2,3,4]
   - int idx = Arrays.binarySearch(arr, 2); >> idx = 2 <- �ùٸ� ���
     - binarySearch(arr, 2) >> �迭 arr���� ���� 2�� ��ġ�� ��ȯ�Ѵ�.
   
�˾ƺ��� ���� �Ǵ� ���� Ž���� ���� Ž��(binary)
 - ����Ž�� : �տ��� ���� ������� ã�� ��� ( ������ �ȵ� �ִ� ��� ����Ѵ�. )
 - ����Ž�� : ���ĵ� �ִ� ���¿��� �ݾ� ������ ���ϸ� ã�´�.
 
5. ������ �迭�� ��� >> deepToString()
   - int[] arr = {0,1,2,3,4};
   - int[][] arr2D = {{11,12},{21,22}};
   - System.out.println(Arrays.toString(arr)); >> [0,1,2,3,4]
   - System.out.println(Arrays.deepToString(arr2D); >> [[11,12],[21,22]]
6. ������ �迭�� �� >> deepEquals()
   - String[][] str2D1 = new String[][]{{"aaa","bbb"},{"AAA","BBB}};
   - String[][] str2D2 = new String[][]{{"aaa","bbb"},{"AAA","BBB"}};
   - System.out.println(Arrays.equals(str2D1, str2D2)); >> false
     - Arrays.equals(�迭1, �迭2)�� 1���� �迭�� �񱳿��� ����ؾ� ����� �� ���� ���´�.
   - System.out.println(Arrays.deepEquals(str2D1, str2D2); >> true
7. �迭�� List�� ��ȯ - asList(Object...a)
   - asList(�Ű�����) : �Ű������� ���� �Ű������̱� ������ ��� �־ �������
     - �迭�� �־ �ǰ� ��Ҹ� �־�ȴ�.
   - List list = Arrays.asList(new Integer[]{1,2,3,4,5}); >> list = [1,2,3,4,5]
   - List list = Arrays.asList(1,2,3,4,5); >> list = [1,2,3,4,5]
   - list.add(6); >> UnsupportedOperationException ���� �߻�
     - List�� �б� �����̱� ������ add �� �� ����.
   - List list = new ArrayList(Arrays.asList(1,2,3,4,5)); >> ListŸ���� �������� list�� ���ο� ArrayList�� �����.
     - ArrayList�� add�� �߰��� �� �ִ�.
8. ���ٿ� ��Ʈ�� ���� >> parallelXXX(), spliterator(), stream() - ���� ����
   - 14�忡�� ����.
*/