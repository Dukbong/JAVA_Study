import java.util.ArrayList;

public class AnnotationTest {
	//@SuppressWarnings
	@SuppressWarnings("deprecated")
	
	public static void main(String[] args) {
		/**
		 * The common interface extended by all annotation types. Note that an
		 * interface that manually extends this on does <i>not</i> define
		 * an annotation type.
		 * ...
		 * 
		 * @author Jang
		 * @since 1.5
		 */
		DeprecatedP t1 = new DeprecatedP();
		t1.DeprecatedMethod(); // Deprecated 애너테이션 메서드 사용
	}
}
// 이너테이션 직접 만들기
@interface TestInfoAnno{
	int count();
	String testdBy();
	String[] testTool();
}

class Tri{
	//애너테이션 사용예
	// @Test 이메서드가 테스트 대상임을 테스트 프로그램에게 말한다.
	// JUnit (단위) 테스트 프로그램이 확인한다.
	public void method() {
		//...
	}
}

//@Override 예시
class OverrideP{
	void parentMethod() {}
}
class OverrideC extends OverrideP{
	void parentmethod() {} // 오타가 있기 때문에 오버라이딩은 아니지만 정상 작동된다.
	@Deprecated // 이렇게 같이 사용할 수도 있다.
	@Override
	void parentMethod() {} // 오버라이딩 ( 컴파일이 오타가 있는지 확인해 준다. )
}

//@Deprecated 예시
class DeprecatedP{
	@Deprecated
	void DeprecatedMethod() {}
}

//@FunctionalInterface 예시
@FunctionalInterface // 함수형 인터페이스는 꼭 추상메서드 1개를 가져야한다.
interface FunctionalInterfaceP{
	void test(); // 추상메서드
	// void check(); >> 추상메서드이지만 이걸 추가하면 추상 메서드가 2개 이기 때문에 함수형인터페이스가 아니다.
}



/*
애너테이션이란? (오로지 설정 정보 제공)
  - 주석처럼 프로그래밍 언어에 영향을 미치지 않으며, 유용한 정보를 제공
    - 소스코드와 관련 문서의 불일치를 막아주는 역할을 한다.
    - 소스코드안에 이렇게 주석을 달면된다. => /**this is content*/
  //- javadoc.exe라는 프로그램이 위에서 작성한 주석을 추출해서 따로 문서를 만든다.


/*
 * 표준 애너테이션
 *   - java에서 제공하는 애너테이션
 *     - @Override : 오버라이딩하는 메서드라는것을 컴파일러에게 알린다.
 *     - @Deprecated : 앞으로 사용하지 않을 것을 권장하는 대상에 붙인다.
 *     - @SuppressWarnings : 컴파일러의 특정 경고메시지가 나타나지 않게 해준다.
 *     - @SafeVarargs : 지네릭스 타입의 가변인자에 사용한다. (JDK 1.7)
 *     - @FunctionalInterface : 함수형 인터페이스라는것을 알린다. (JDK 1.8)
 *     - @Native : native 메서드에서 참조되는 상수 앞에 붙인다. (JDK 1.8)
 *     - @Target* : 애너테이션이 적용가능한 대상을 지정하는데 사용한다.
 *       - 아래는 메타 애너테이션 ( 애너테이션을 만들 떄 사용한다. )
 *     - @Documented : 애너테이션 정보가 javadoc으로 작성된 문서에 포함되게 한다.
 *     - @Inherited : 애너테이션의 자식 클래스에 상속되도록 한다.
 *     - @Retention : 애너테이션이 유지되는 범위를 지정하는데 사용한다.
 *     - @Repeatable : 애너테이션을 반복해서 적용할 수 있게 한다.(JDK 1.8)
 *     
 * 
 * @Override
 *   - 오버라이딩을 올바르게 했는지 컴파일러가 체크하게 한다.
 *   - 오버라이딩할 메서드 이름을 잘못 적는 실수를 하는 경우가 많은데 이걸 찾아준다.
 *   - 오버라이딩할 때는 메서드 선언부 앞에 @Override를 붙인다.
 *   
 * @Deprecated
 *   - 앞으로 사용하지 않을 것을 권장하는 필드나 메서드에 붙힌다.
 *   - 예시로는 Date클래스의 getDate()가 있다.
 *     @Deprecated
 *     public int getDate(){
 *         return normalize().getDayOfMonth(); 
 *     }
 *   - @Deprecated가 붙은 대상이 사용된 코드를 컴파일하면 결고 메세지가 나온다. (에러 아님)
 *   
 * @FunctionalInterface
 *   - 함수형 인터페이스에 붙이면 컴파일러가 올바르게 작성했는지 체크한다.
 *   - 함수형 인터페이스에는 하나의 추상메서드만 가져야 한다는 제약이 있다.
 *     @FuntionalInterface
 *     public interface Runnable{
 *         public abstract void run(); // 추상메서드 1개
 *     }
 *     
 * @SuppressWarnings
 *   - 컴파일러의 경고 메시지가 나타나지 않게 억제한다.
 *   - 괄호 안에 억제하고자 하는 경고의 종류를 문자열로 지정한다.
 *     @SuppressWarnings("unchecked") // 제네릭 관련된 경고를 억제
 *     ArrayList list = new ArrayList(); // 제네릭 타입을 지정해주지 않았다.
 *     list.add(obj); // 여기서 다른 경고가 발생한다.
 *   - 두개 이상의 경고를 동시에 억제하려면 배열처럼 나열하면 된다.
 *     @SuppressWarnings({"deprecation", "unchecked", varargs"})
 * 
 * 
 * 메타 애너테이션
 *   - 애너테이션을 위한 애너테이션
 *   - java.lang.annotation패키지에 포함되어있다.
 *    
 * @Target
 *   - 애너테이션을 정의할때, 적용대상 지정하는데 사용한다.
 *      @Target({FIELD, TYPE, TYPE_USE}) // 적용 대상이 FIELD, TYPE, TYPE_USE이다.
 *      public @interface MyAnnotation{} // MyAnnotation 애너테이션을 정의한다.
 *      @MyAnnotation // 적용대상이 TYPE일떄 (클래스 또는 인터페이스)
 *      class Myclass{ 
 *          @MyAnnotation // 적용대상이 FIELD일떄 (멤버변수)
 *          int i;
 *          @MyAnnotation // 적용대상이 TYPE_USE일떄 (참조변수 일때)
 *          Myclass mc;
 *      }
 *      
 * @Retention
 *   - 애너테이션이 유지 되는 기간을 지정하는 사용된다.
 *     유지정책  - 의미
 *     SOURCE = 소스파일레만 존재, 클래스파일에는 존재하지 않는다.
 *     CLASS = 클래스파일에 존재 실행시에 사용 불가 (기본값)
 *     RUNTIME = 클래스파일에 존재 실행시에 사용가능
 *   - 컴파일러에 의해 사용되는 애너테이션의 유지 정책은 SOURCE이다.
 *     @Retention(RetentionPolicy.SOURCE)
 *                // 유지정책.SOURCE or CLASS, RUNTIME
 *     public @interface Override{} 
 *     
 *   - 실행시에 사용 가능한 애너테이션의 정책은 RUNTIME이다.
 * 
 * @Repeatable
 *   - 반복해서 붙일 수 있는 애너테이션을 정의할 때 사용
 *     @Repeatable(ToDos.class) // ToDo애너테이션을 여러번 반복해서 쓸 수 있게 해준다.
 *     @interface ToDo{
 *         String value();
 *     }
 *   - @Repeatable이 붙은 애너테이션은 반복해서 붙일 수 있다.
 *     @ToDo("Delete test codes")
 *     @ToDo("override inherited methods")
 *     class Myclass{
 *         // ...
 *     }
 *   - @Repeatable인 @ToDo를 하나로 묶을 컴테이너 애너테이션도 정의해야한다.
 *     @interface ToDos{
 *         ToDo[] value(); // ToDo 애너테이션 배열 타입의 요소를 선언, 이름이 반드시 value이어야한다.
 *     }
 *     
 *     
 * 애너테이션 타입 정의하기
 *   - 애너테이션을 직접 만들어 써보자
 *     @interface 애너테이션이름{
 *         타입 요소이름(); // 애너테이션 요소를 선언한다.
 *     }
 *   - 애너테이션의 메서드는 추상메서드이며 애너테이션을 적용할때 지정(순서  X)
 *     @interface TestInfo{
 *         int count();
 *         String testedBy();
 *         String[] testTools();
 *         TestType testType(); // Enum testType{First, Final}
 *         DateTime testDate(); // 자신이 아닌 다른 애너테이션(@DateTime)을 포함할 수 있다.
 *     }
 *     만든 TestInfo 애너테이션 사용
 *     @TestInfo( >> 모든 요소들에게 값을 지정해줘야한다.
 *         count = 3, testedBy = "Kim",
 *         testTools = {"JUnit", "AutoTester"},
 *         testType = TestType.FIRST,
 *         testDate = @DateTime(yymmdd = "160101", hhmmss = "235959")
 *     )
 *     public class NewClass{...}
 *     
 * 애너테이션의 요소
 *   - 적용시 값을 지정하지 않으면 사용될 수 있는 기본값 지정 가능 (null 제외)
 *     @interface TestInfo{
 *         int count() default 1; >> 기본 값을 1로 지정
 *     }
 *     사용시
 *     @TestInfo >> @TestInfo(int count = 1) 과 동일하다.
 *     public class NewClass{...}
 *
 * - 요소가 하나이고 이름이 value라면 생략이 가능하다.
 *   @interface TestInfo{
 *       String value();
 *   }
 *   사용시
 *   @TestInfo("passed") >> @TestInfo(value = "passed")와 동일하다.
 *   class NewClass{...}
 *   
 * - 요소의 타입이 배열인 경우, 괄호 {}를 사용해야한다.
 *  @interface TestInfo{
 *      String[] testTools();
 *  }
 *  사용시
 *  @TestInfo(testTools = {"JUnit", "AutoTester"}) >> 2개 이상일때
 *  @TestInfo(testTools = "JUnit") >> 1개 일떄
 *  @TestInfo(testTools = {}) >> 0개일떄도 {}는 반드시 해줘야한다.
 *  
 * - 모든 애너테이션의 조상
 *   - Annotation은 모든 애너테이션의 조상이지만 상속은 불가하다.
 *     @interface TestInfo extends Annotation{ // Error! 허용되지 않는 표현
 *         int count();
 *     }
 *   - 사실 Annotation은 인터페이스이다.
 *     package java.lang.annotation;
 *     public interface Annotation{
 *         boolean equals(Object obj);
 *         int hashCode();
 *         String toString();
 *         
 *         class <? extends Annotation> annotationType(); // 애너테이션의 타입을 반환
 *     }
 *     
 * 마커 애너테이션
 *   - 요소가 하나도 정의되지 않는 애너테이션
 *     - 예시로 @Override, @Deprecated
 *     
 * 애너테이션 요소의 규칙
 *   - 애너테이션의 요소를 선언할 때 아래의 규칙을 반드시 지켜야한다.
 *     - 요소의 타입은 기본형, String, enum, 애너테이션, Class(설계도)만 허용된다.
 *     - 괄호() 안에 매개변수를 선언할 수 없다.
 *     - 예외를 선언할 수 없다.
 *     - 요소를 타입 매개변수로 정의 할 수 없다.
 *     
 *   - 아래의 코드에서 잘못된 부분이 무엇인지 찾으시오.
 *     @interface Annotest{
 *         int id = 100;
 *         String major(int i, int j); // 매개변수 선언 불가능
 *         String minor() throws Exception; // 예외 선언 불가능
 *         ArrayList<T> list(); // 타입 매개변수 정의할 수 없다.
 *     }
 */