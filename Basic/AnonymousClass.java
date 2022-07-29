import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AnonymousClass {

	public static void main(String[] args) {
		// �͸� Ŭ���� : �̸���  ���� ��ȸ�� Ŭ����, ���ǿ� ������ ���ÿ�
		
		// =================�͸� �Լ� ��� ��===================
		Button b = new Button("Start");
		b.addActionListener(new EventHandler());
		// =================�͸� �Լ� ��� ��===================
		
		// �͸� �Լ� ���===========================================
		Button b2 = new Button("START");
		b2.addActionListener(new ActionListener() { // 1ȸ���̴�.
			public void actionPerformed(ActionEvent e) {
				System.out.println("ActionEvent occurred!!");
			}
		});
		// �͸� �Լ� ���===========================================
	}

}

class EventHandler implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		System.out.println("ActionEvent occurred!");
	}
}