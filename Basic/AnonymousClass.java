import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AnonymousClass {

	public static void main(String[] args) {
		// 익명 클래스 : 이름이  없는 일회용 클래스, 정의와 생성을 동시에
		
		// =================익명 함수 사용 전===================
		Button b = new Button("Start");
		b.addActionListener(new EventHandler());
		// =================익명 함수 사용 전===================
		
		// 익명 함수 사용===========================================
		Button b2 = new Button("START");
		b2.addActionListener(new ActionListener() { // 1회용이다.
			public void actionPerformed(ActionEvent e) {
				System.out.println("ActionEvent occurred!!");
			}
		});
		// 익명 함수 사용===========================================
	}

}

class EventHandler implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		System.out.println("ActionEvent occurred!");
	}
}