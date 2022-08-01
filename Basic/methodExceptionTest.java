import java.io.File;
import java.io.IOException;

public class methodExceptionTest {

	public static void main(String[] args) {
		try {
			File f = createFile(args[0]);
			System.out.println(f.getName() + " ������ ���������� �����Ǿ����ϴ�.");
		} catch (Exception e) {
			System.out.println(e.getMessage() + " �ٽ� �Է��� �ֽñ� �ٶ��ϴ�.");
		}

	}
	// ȣ���� ������ ����ó�� ��Ű��
	static File createFile(String fileName) throws Exception{
		if (fileName == null || fileName.equals("")) {
			throw new Exception("���� �̸��� ��ȿ���� �ʽ��ϴ�.");
		}
		File f = new File(fileName);
		f.createNewFile(); // ���� ������ �����ȴ�.
		return f;
	}
	
	// �޼���ȿ��� ����ó�� �ϱ�
	static File createFile2(String fileName){
		try {
			if (fileName == null || fileName.equals("")) {
				throw new Exception("���� �̸��� ��ȿ���� �ʽ��ϴ�.");
			}
		}catch(Exception e) {
			fileName = "�������.txt";
		}
		
		File f = new File(fileName);
		try {
			f.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // ���� ������ �����ȴ�.
		return f;
	}

}

