import java.util.Objects;

public class toStringTest {

	public static void main(String[] args) {
		Cards c1 = new Cards();
		Cards c2 = new Cards();
		System.out.println(c1.toString());
		System.out.println(c2); // println������ toString() ��������
		// �������̵� �� c1 = Card@17365
		System.out.println(c1.equals(c2));
		System.out.println(c1.hashCode());
		System.out.println(c2.hashCode());
	}
}

class Cards{
	String kind;
	int number;
	
	Cards(){
		this("SPADE", 1);
	}
	Cards(String kind, int number){
		this.kind = kind;
		this.number = number;
	}
	// toString �޼��� �������̵�
	public String toString() {
		return "kind : " + kind + ", number : " + number;
	}
	
	// �߿�!!!!! equals�� �������̵� ���ָ� hashCode�� ���� �������̵�������ϰ� equals����� true�̸� hasCode() ����� ���� ���ƾ��Ѵ�.
	
	// equals �޼��� �������̵�
	public boolean equals(Object obj) {
		if(obj instanceof Cards) {
			Cards c = (Cards)obj;
			return this.kind.equals(c.kind) && this.number==c.number;
		}else {
			return false;
		}
	}
	// equals�� �������̵��ϸ� hashCode�� �������̵� ������Ѵ�.
	public int hashCode() {
		// Objects Ŭ������ ��ü�� ���õ� ������ �޼��带 �����ϴ� ��ƿ Ŭ�����̴�.
		return Objects.hash(kind, number);
		// int hash(Object...value) �Ű������� �������ڶ� ȣ��� �����ϴ� ���� ������ ���������� �ʴ�.
		// �׷��� �Ű������� �ϳ��� �־�ǰ� 100���� �־ �������.
	}
}