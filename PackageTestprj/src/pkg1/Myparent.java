package pkg1;

class MyparentTest {

	public static void main(String[] args) {
		Myparent p = new Myparent();
		// System.out.println(p.prv); 접근 제어자가 private
		System.out.println(p.dft);
		System.out.println(p.prt);
		System.out.println(p.pub);

	}

}

public class Myparent {
	private   int prv; // 같은 클래스
			  int dft; // 같은 패키지
	protected int prt; // 같은 패키지, 다른 패키지 첫번째 자식
	public 	  int pub; // 제한이 없다.
	
	public void printMembers() {
		System.out.println(prv);
		System.out.println(dft);
		System.out.println(prt);
		System.out.println(pub);
	}
}
