
public class println_VS_printf {

	public static void main(String[] args) {
		
		System.out.println(10/3); // 3
		// ���� ���� ���� / �����̱� ������ ������� ������ ���´�.
		System.out.println(10.0/3); // 3.3333...
		System.out.println(10/3.0); // 3.3333...
		System.out.println(10.0/3.0); // 3.3333...
		// �̷��� �����̳� ���� ��� �Ǽ��� �ٲ��ָ� ��� ���� �Ǽ��� ���´�.
		
		// println�� ���� : �Ǽ��� �ڸ��� ������ �Ұ����ϴ�.
		
		System.out.printf("%.2f\n",10.0/3); //3.3326
		
		//====================================================
		
		System.out.println(0X1A); // 26
		
		// println�� ����  : ������ 10�ؼ��θ� ��� �ȴ�.
		
		System.out.printf("%X\n", 15); // (16����) f
		System.out.printf("%d\n", 15); // (10����)15
		System.out.printf("%o\n", 15); // (8����) 17
		System.out.printf("%s\n", Integer.toBinaryString(15)); // (2����) 1111
		
		// ���� 8����, 16���� ����� ���λ縦 ���̰� ��������?
		System.out.printf("%#o\n", 15); // 017 (8����)
		System.out.printf("%#X\n", 15); // 0Xf (16����);
		
		//====================================================
		
		/*
		  printf()�� ������
		  - %b >> boolean
		  - %d >> int(10����)
		  - %o >> 8����
		  - %x, %X >> 16����
		  - %f >> �ε� �Ҽ���
		  - %e, %E >> ���� ǥ��
		  - %c >> ���� ���
		  - %s >> ���ڿ� ���
		 */ 
		
		// printf�� ���� : �ٹٲ��� ���� �ʱ� ������ ������ \n�� ���־���Ѵ�.
		
		System.out.printf("[%5d] \n", 10); // [   10] ������ ����
		System.out.printf("[%-5d] \n", 10); // [10   ] ���� ����
		System.out.printf("[%05d] \n", 10); // [00010] ����� 0���� ä����
		System.out.printf("[%5d] \n", 123456789); // [123456789]
		
		System.out.printf("[%s] \n", "www.naver.com"); // [www.naver.com];	
		System.out.printf("[%20s] \n", "www.naver.com"); // [       www.naver.com];	
		System.out.printf("[%-20s] \n", "www.naver.com"); // [www.naver.com       ];
		System.out.printf("[%.4s] \n", "www.naver.com"); // [www.]
		

	}

}
