import javax.swing.JOptionPane;

import org.opentutorials.iot.DimmingLights;
import org.opentutorials.iot.Elevator;
import org.opentutorials.iot.Lighting;
import org.opentutorials.iot.Security;

public class Ok_JAVA_Input {
									 // args = parameter, �Ű�����
	public static void main(String[] args) {
		// ���� id�� �Է°� 1�� �ޱ�
		// String id = JOptionPane.showInputDialog("Enter a ID");
		// �� JOptionPane.showInputDialog("�Է¹��� �� �ִ� â ����");
		// ������ �����δ� C����� scanf()�� ����. 
		
		// args[]�� �̿��ؼ� ������ �� �����ϱ�
		String id = args[0];
		String bright = args[1];
		// �����
		// 1. Run ��ư �� ȭ��ǥ �Ʒ��� ������.
		// 2. run configurations Ŭ���߽��ϴ�.
		// 3. ����ϰ� �ִ� ���� ����
		// 4. Arguments�� �̵�
		// 5. Arguments Ŭ�� �� �ʿ��� �� �Է��ϸ� ���Դϴ�.
		
		// �Է½� ���� ����
		// Arguments �ۼ� ����) "Busan 104" "15.6"
		//					 >> ["Busan 104", "15.6"]
		
		System.out.println("���Ͷ�" + id);
		
		
		// JOptionpane�� ����ϱ� ���ؼ��� import javax.swing.JOptionPane�� �ʿ��ϴ�.
		// �Է¹޴� ���� Ÿ���� String
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
		// String ==> Double (�� ��ȯ)
		// Double.parseDouble("1.24");
		// ��� : 1.24
		
		moodLamp.on();
	}
}