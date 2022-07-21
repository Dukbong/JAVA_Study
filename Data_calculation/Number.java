public class Number {
	public static void main(String[] args) {
    	// Operator
        System.out.println(1 + 1); // 2
        System.out.println(2 - 1); // 1
        System.out.println(2 * 2); // 4
        System.out.println(4 / 3); // 1 �� ���´�.
        System.out.println(4 % 3); // 1 �������� ���´�.
        
        // Math
        System.out.println(Math.abs(-9)); // 9 Type : number
        // ���밪
        System.out.println(Math.sqrt(4)); // 2.0 Type : double
        // ������
        System.out.println(Math.pow(5,2)); // 25
        // ����
        System.out.println(Math.floor(Math.PI)); // 3.0 Type : double
        // �Ҽ��� ����
        System.out.println(Math.ceil(Math.PI)); // 4.0 Type : double
        // �Ҽ����� �ִٸ� �ø�
        System.out.println(Math.PI); // 3.1415926535...
        
        // Math.random
        System.out.println(Math.random()*10);
        // 10�̸��� �Ǽ����� �ϳ��� �ҷ��ɴϴ�.
        System.out.println((int)Math.random()*10); // 0 ~ 9 ����
        // (int)�� ���� ����ȯ �������.
        System.out.println(((int)Math.random()*6)+5); // 5 ~ 10 ����
        // ���ϴ� ���� ��ŭ ������ ���ڸ� ������ �ִ�.
	}
}
