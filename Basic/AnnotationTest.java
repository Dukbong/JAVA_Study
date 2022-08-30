
public class AnnotationTest {

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
		
	}
}

class Tri{
	//애너테이션 사용예
	@Test // 이메서드가 테스트 대상임을 테스트 프로그램에게 말한다.
	// JUnit (단위) 테스트 프로그램이 확인한다.
	public void method() {
		//...
	}
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
 */