import javax.swing.JOptionPane;

import org.opentutorials.iot.DimmingLights;
import org.opentutorials.iot.Elevator;
import org.opentutorials.iot.Lighting;
import org.opentutorials.iot.Security;

public class Ok_JAVA_Input {
									 // args = parameter, 매개변수
	public static void main(String[] args) {
		// 변수 id에 입력갑 1개 받기
		// String id = JOptionPane.showInputDialog("Enter a ID");
		// ★ JOptionPane.showInputDialog("입력받을 수 있는 창 내용");
		// 동일한 것으로는 C언어의 scanf()와 같다. 
		
		// args[]를 이용해서 변수에 값 저장하기
		String id = args[0];
		String bright = args[1];
		// 사용방법
		// 1. Run 버튼 옆 화살표 아래를 누른다.
		// 2. run configurations 클릭했습니다.
		// 3. 사용하고 있는 파일 선택
		// 4. Arguments로 이동
		// 5. Arguments 클릭 후 필요한 값 입력하면 끝입니다.
		
		// 입력시 주의 사항
		// Arguments 작성 예시) "Busan 104" "15.6"
		//					 >> ["Busan 104", "15.6"]
		
		System.out.println("나와랏" + id);
		
		
		// JOptionpane을 사용하기 위해서는 import javax.swing.JOptionPane이 필요하다.
		// 입력받는 값의 타입은 String
		// String bright = JOptionPane.showInputDialog("Enter a Bright level");
		
		// Elevator call
		Elevator myElevator = new Elevator(id);
		myElevator.callForUp(1);
		
		// Security off
		Security mySecurity = new Security(id);
		mySecurity.off();
		
		// Light on
		Lighting hallLamp = new Lighting(id + " / Hall Lamp");
		hallLamp.on();
		
		Lighting floorLamp = new Lighting(id + "/ floorLamp");
		floorLamp.on();
		
		DimmingLights moodLamp = new DimmingLights(id + "/ moodLamp");
		moodLamp.setBright(Double.parseDouble(bright));
		// String ==> Double (형 변환)
		// Double.parseDouble("1.24");
		// 결과 : 1.24
		
		moodLamp.on();
	}
}