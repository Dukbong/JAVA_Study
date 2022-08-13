import java.util.Arrays;
import java.util.Comparator;

public class ComparatorAndComparable {

	public static void main(String[] args) {
		// ����1
		String[] strArr = {"cat","Dog","lion","tiger"};
		
		Arrays.sort(strArr); // String�� Comparable ������ ���� ���ĵȴ�.
		System.out.println("strArr = " + Arrays.toString(strArr));
		// �빮�ڿ� �ҹ��ڰ� �ִٸ� ���������� �빮�ڰ� �� ������ �ִ�.
		
		Arrays.sort(strArr/*���Ĵ��*/, String.CASE_INSENSITIVE_ORDER/*���ı���*/); // ��ҹ��� �������� �ʰ� �����ض�
		System.out.println("strArr = " + Arrays.toString(strArr));
		
		Arrays.sort(strArr, new Descending());
		System.out.println("strArr = " + Arrays.toString(strArr));
	}
}

// ����1
class Descending implements Comparator{
	public int compare(Object o1, Object o2) {
		if (o1 instanceof Comparable && o2 instanceof Comparable) {
			Comparable c1 = (Comparable)o1;
			Comparable c2 = (Comparable)o2;
			return c1.compareTo(c2) * -1; // -1�� ���ؼ� �⺻����(��������)�� ������ �����Ѵ�.
			                              // �Ǵ� c2.compareTo(c1)���� ������ �����ص� �ȴ�.
		}
		return -1;
	}
	
}
/*
��ü ���Ŀ� �ʿ��� �޼���(���ı��� ����)�� ������ �������̽�
  - Comparable : (default)�⺻ ���ı����� �����ϴµ� ���
    // sort()�� ���� �Ҷ� ���ı����� ������ �� �ִ�.
  
    public interface Comparable{
        int compareTo(Object o); // �־��� ��ü(o)�� �ڽŰ� ���Ѵ�. 
    }
    
  - Comparator : �⺻ ���ı��� �ܿ� �ٸ� �������� �����ϰ��� �Ҷ� ���
  
    public interface Comparator{
        int compare(Object o1, Object o2); // o1,o2 �� ��ü�� ���Ѵ�.
        // ����� 0�̸� ����, ����� o1�� ũ��, ������ o2�� ũ��
        boolean equals(Object obj); // equals�� �������̵��϶�� ���̴�.
    }

  - compare()�� compareTo()�� �� ��ü�� �񱳰���� ��ȯ�ϵ��� �ۼ��Ѵ�.
    
    public final class Integer extends Number implements Comparable{
        ...
        public int compareTo(Object o){
            return compareTo((Integer)o);
        }
        public int compareTo(Integer anotherInteger){
            int v1 = this.value;
            int v2 = anotherInteger.value;
            >> ������ 0, �������� ũ�� -1, ������ ũ�� 1 ��ȯ
            return (v1 < v2 ? -1 : (v1 == v2 ? 0 : 1);  
            >> return v1-v2; // ���� ������ ��� �ݴ�� �E���ϸ� �ȴ�. ( ���� ���׿����ڸ� ����ϴ°� ȿ�������� ���� )           
        }
        ...
    }
    
  - sort �޼��� ( ���� ����� �Һ��̴�. ������ �޶����� ���̴�. )    
    static void sort(int[] intArr){
        for(int i = 0; i < intArr.length-1; i++){
            for(int j = 0; j < intArr.length-1-i; j++){
                int tmp = 0;
                if(intArr[j] > intArr[j+1]){ >> �ΰ� ��
                    >> �ڸ� �ٲ�
                    tmp = intArr[j];
                    intArr[j] = intArr[j+1];
                    intArr[j+1] = tmp;
                }
            }
        }
    }
 */