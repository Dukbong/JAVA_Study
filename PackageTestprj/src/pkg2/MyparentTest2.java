package pkg2;

import pkg1.Myparent;

public class MyparentTest2 {

	public static void main(String[] args) {
		Myparent p = new Myparent();
		// System.out.println(p.prv); ���������� private(���� Ŭ����) �̹Ƿ� x
		// System.out.println(p.dft); ���������� default(���� ��Ű��) �̹Ƿ� x
		// System.out.println(p.prt); ���������� protected(���� ��Ű��, �ٸ���Ű�� �ڽ� Ŭ����) �̹Ƿ� x
		System.out.println(p.pub);
	}

}

class Mychild extends Myparent{
	public void printMembers() {
		// System.out.println(prv); ���� ������ private(���� Ŭ����) �̹Ƿ� x
		// System.out.println(dft); ���� ������ default(���� ��Ű��) �̹Ƿ� x
		System.out.println(prt);
		System.out.println(pub);
	}

}
