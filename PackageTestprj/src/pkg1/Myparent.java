package pkg1;

class MyparentTest {

	public static void main(String[] args) {
		Myparent p = new Myparent();
		// System.out.println(p.prv); ���� �����ڰ� private
		System.out.println(p.dft);
		System.out.println(p.prt);
		System.out.println(p.pub);

	}

}

public class Myparent {
	private   int prv; // ���� Ŭ����
			  int dft; // ���� ��Ű��
	protected int prt; // ���� ��Ű��, �ٸ� ��Ű�� ù��° �ڽ�
	public 	  int pub; // ������ ����.
	
	public void printMembers() {
		System.out.println(prv);
		System.out.println(dft);
		System.out.println(prt);
		System.out.println(pub);
	}
}
