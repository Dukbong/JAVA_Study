package pkg2;

import pkg1.Myparent;

public class MyparentTest2 {

	public static void main(String[] args) {
		Myparent p = new Myparent();
		// System.out.println(p.prv); 접근제한자 private(같은 클래스) 이므로 x
		// System.out.println(p.dft); 접근제한자 default(같은 패키지) 이므로 x
		// System.out.println(p.prt); 접근제한자 protected(같은 패키지, 다른패키지 자식 클래스) 이므로 x
		System.out.println(p.pub);
	}

}

class Mychild extends Myparent{
	public void printMembers() {
		// System.out.println(prv); 접근 제어자 private(같은 클래스) 이므로 x
		// System.out.println(dft); 접근 제어자 default(같은 패키지) 이므로 x
		System.out.println(prt);
		System.out.println(pub);
	}

}
