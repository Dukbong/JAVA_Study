import java.util.*; // 1. import�� �߰�

public class scanfEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.printf("���ڸ� �Է��ϼ��� : ");
		// 2. ScannerŬ������ ��ü ����
		Scanner scanner = new Scanner(System.in); // ȭ�鿡�� �Է¹ޱ�
		
//		// �ϳ��� �Է¹޴� ���
//		int num = scanner.nextInt();
//		int num2 = scanner.nextInt();
//		System.out.println(num);
//		System.out.println(num2);
		
//		// ���� ������ �Է¹޴� ���
//		String input = scanner.nextLine();
//		int num3 = Integer.parseInt(input);
//		System.out.println(num3);
		
		// ����
		String input2 = scanner.nextLine(); // ���پ� �Է� �޴´�.
		String[] result = input2.split(" "); // ����� �߶� result�迭�� �ִ´�.
		for (String a: result) { // �迭 ��� �ϳ��� ������ ����Ѵ�.
			System.out.println(a);
		}
		
	}

}
