import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Deprecated // 사용 중지 권장
@SuppressWarnings("1111") // 유효하지 않은 애너테이션은 무시된다.
@TestInfo(testedBy = "aaa", testDate = @DateTime(yymmdd = "160101", hhmmss = "235959"))
public class Annotation_Q {

	public static void main(String[] args) {
		Class<Annotation_Q> cls = Annotation_Q.class;
		// Annotation_Q의 Class 객체를 얻는다.
		
		TestInfo anno = cls.getAnnotation(TestInfo.class);
		System.out.println("anno.testedBy() = " + anno.testedBy());
		System.out.println("anno.testDate().yymmdd() = " + anno.testDate().yymmdd());
		System.out.println("anno.testDate().hhmmss() = " + anno.testDate().hhmmss());
		
		for(String str : anno.testTools()) {
			System.out.println("testTools = " + str);
		}
		System.out.println();
		
		Annotation[] annoArr = cls.getAnnotations();
		
		for (Annotation a : cls.getAnnotations()) {
			System.out.println(a);
		}
	}

}

@Retention(RetentionPolicy.RUNTIME) // 실행 시에 사용 가능하도록 지정
@interface TestInfo{
	int count() default 1;
	String testedBy();
	String[] testTools() default "JUnit";
	TestType testType() default TestType.FIRST;
	DateTime testDate();
}
@Retention(RetentionPolicy.RUNTIME) // 실행 시에 사용 가능하도록 지정
@interface DateTime{
	String yymmdd();
	String hhmmss();
}
enum TestType{FIRST, FINAL}