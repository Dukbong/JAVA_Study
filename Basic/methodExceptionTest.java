import java.io.File;
import java.io.IOException;

public class methodExceptionTest {

	public static void main(String[] args) {
		try {
			File f = createFile(args[0]);
			System.out.println(f.getName() + " 파일이 성공적으로 생성되었습니다.");
		} catch (Exception e) {
			System.out.println(e.getMessage() + " 다시 입력해 주시기 바랍니다.");
		}

	}
	// 호출한 곳에서 예외처리 시키기
	static File createFile(String fileName) throws Exception{
		if (fileName == null || fileName.equals("")) {
			throw new Exception("파일 이름이 유효하지 않습니다.");
		}
		File f = new File(fileName);
		f.createNewFile(); // 실제 파일이 생성된다.
		return f;
	}
	
	// 메서드안에서 예외처리 하기
	static File createFile2(String fileName){
		try {
			if (fileName == null || fileName.equals("")) {
				throw new Exception("파일 이름이 유효하지 않습니다.");
			}
		}catch(Exception e) {
			fileName = "제목없음.txt";
		}
		
		File f = new File(fileName);
		try {
			f.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // 실제 파일이 생성된다.
		return f;
	}

}

