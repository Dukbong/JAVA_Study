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
		t1.DeprecatedMethod(); // Deprecated �ֳ����̼� �޼��� ���
	}
}
// �̳����̼� ���� �����
@interface TestInfoAnno{
	int count();
	String testdBy();
	String[] testTool();
}

class Tri{
	//�ֳ����̼� ��뿹
	// @Test �̸޼��尡 �׽�Ʈ ������� �׽�Ʈ ���α׷����� ���Ѵ�.
	// JUnit (����) �׽�Ʈ ���α׷��� Ȯ���Ѵ�.
	public void method() {
		//...
	}
}

//@Override ����
class OverrideP{
	void parentMethod() {}
}
class OverrideC extends OverrideP{
	void parentmethod() {} // ��Ÿ�� �ֱ� ������ �������̵��� �ƴ����� ���� �۵��ȴ�.
	@Deprecated // �̷��� ���� ����� ���� �ִ�.
	@Override
	void parentMethod() {} // �������̵� ( �������� ��Ÿ�� �ִ��� Ȯ���� �ش�. )
}

//@Deprecated ����
class DeprecatedP{
	@Deprecated
	void DeprecatedMethod() {}
}

//@FunctionalInterface ����
@FunctionalInterface // �Լ��� �������̽��� �� �߻�޼��� 1���� �������Ѵ�.
interface FunctionalInterfaceP{
	void test(); // �߻�޼���
	// void check(); >> �߻�޼��������� �̰� �߰��ϸ� �߻� �޼��尡 2�� �̱� ������ �Լ����������̽��� �ƴϴ�.
}



/*
�ֳ����̼��̶�? (������ ���� ���� ����)
  - �ּ�ó�� ���α׷��� �� ������ ��ġ�� ������, ������ ������ ����
    - �ҽ��ڵ�� ���� ������ ����ġ�� �����ִ� ������ �Ѵ�.
    - �ҽ��ڵ�ȿ� �̷��� �ּ��� �޸�ȴ�. => /**this is content*/
  //- javadoc.exe��� ���α׷��� ������ �ۼ��� �ּ��� �����ؼ� ���� ������ �����.


/*
 * ǥ�� �ֳ����̼�
 *   - java���� �����ϴ� �ֳ����̼�
 *     - @Override : �������̵��ϴ� �޼����°��� �����Ϸ����� �˸���.
 *     - @Deprecated : ������ ������� ���� ���� �����ϴ� ��� ���δ�.
 *     - @SuppressWarnings : �����Ϸ��� Ư�� ���޽����� ��Ÿ���� �ʰ� ���ش�.
 *     - @SafeVarargs : ���׸��� Ÿ���� �������ڿ� ����Ѵ�. (JDK 1.7)
 *     - @FunctionalInterface : �Լ��� �������̽���°��� �˸���. (JDK 1.8)
 *     - @Native : native �޼��忡�� �����Ǵ� ��� �տ� ���δ�. (JDK 1.8)
 *     - @Target* : �ֳ����̼��� ���밡���� ����� �����ϴµ� ����Ѵ�.
 *       - �Ʒ��� ��Ÿ �ֳ����̼� ( �ֳ����̼��� ���� �� ����Ѵ�. )
 *     - @Documented : �ֳ����̼� ������ javadoc���� �ۼ��� ������ ���Եǰ� �Ѵ�.
 *     - @Inherited : �ֳ����̼��� �ڽ� Ŭ������ ��ӵǵ��� �Ѵ�.
 *     - @Retention : �ֳ����̼��� �����Ǵ� ������ �����ϴµ� ����Ѵ�.
 *     - @Repeatable : �ֳ����̼��� �ݺ��ؼ� ������ �� �ְ� �Ѵ�.(JDK 1.8)
 *     
 * 
 * @Override
 *   - �������̵��� �ùٸ��� �ߴ��� �����Ϸ��� üũ�ϰ� �Ѵ�.
 *   - �������̵��� �޼��� �̸��� �߸� ���� �Ǽ��� �ϴ� ��찡 ������ �̰� ã���ش�.
 *   - �������̵��� ���� �޼��� ����� �տ� @Override�� ���δ�.
 *   
 * @Deprecated
 *   - ������ ������� ���� ���� �����ϴ� �ʵ峪 �޼��忡 ������.
 *   - ���÷δ� DateŬ������ getDate()�� �ִ�.
 *     @Deprecated
 *     public int getDate(){
 *         return normalize().getDayOfMonth(); 
 *     }
 *   - @Deprecated�� ���� ����� ���� �ڵ带 �������ϸ� ��� �޼����� ���´�. (���� �ƴ�)
 *   
 * @FunctionalInterface
 *   - �Լ��� �������̽��� ���̸� �����Ϸ��� �ùٸ��� �ۼ��ߴ��� üũ�Ѵ�.
 *   - �Լ��� �������̽����� �ϳ��� �߻�޼��常 ������ �Ѵٴ� ������ �ִ�.
 *     @FuntionalInterface
 *     public interface Runnable{
 *         public abstract void run(); // �߻�޼��� 1��
 *     }
 *     
 * @SuppressWarnings
 *   - �����Ϸ��� ��� �޽����� ��Ÿ���� �ʰ� �����Ѵ�.
 *   - ��ȣ �ȿ� �����ϰ��� �ϴ� ����� ������ ���ڿ��� �����Ѵ�.
 *     @SuppressWarnings("unchecked") // ���׸� ���õ� ��� ����
 *     ArrayList list = new ArrayList(); // ���׸� Ÿ���� ���������� �ʾҴ�.
 *     list.add(obj); // ���⼭ �ٸ� ��� �߻��Ѵ�.
 *   - �ΰ� �̻��� ��� ���ÿ� �����Ϸ��� �迭ó�� �����ϸ� �ȴ�.
 *     @SuppressWarnings({"deprecation", "unchecked", varargs"})
 * 
 * 
 * ��Ÿ �ֳ����̼�
 *   - �ֳ����̼��� ���� �ֳ����̼�
 *   - java.lang.annotation��Ű���� ���ԵǾ��ִ�.
 *    
 * @Target
 *   - �ֳ����̼��� �����Ҷ�, ������ �����ϴµ� ����Ѵ�.
 *      @Target({FIELD, TYPE, TYPE_USE}) // ���� ����� FIELD, TYPE, TYPE_USE�̴�.
 *      public @interface MyAnnotation{} // MyAnnotation �ֳ����̼��� �����Ѵ�.
 *      @MyAnnotation // �������� TYPE�ϋ� (Ŭ���� �Ǵ� �������̽�)
 *      class Myclass{ 
 *          @MyAnnotation // �������� FIELD�ϋ� (�������)
 *          int i;
 *          @MyAnnotation // �������� TYPE_USE�ϋ� (�������� �϶�)
 *          Myclass mc;
 *      }
 *      
 * @Retention
 *   - �ֳ����̼��� ���� �Ǵ� �Ⱓ�� �����ϴ� ���ȴ�.
 *     ������å  - �ǹ�
 *     SOURCE = �ҽ����Ϸ��� ����, Ŭ�������Ͽ��� �������� �ʴ´�.
 *     CLASS = Ŭ�������Ͽ� ���� ����ÿ� ��� �Ұ� (�⺻��)
 *     RUNTIME = Ŭ�������Ͽ� ���� ����ÿ� ��밡��
 *   - �����Ϸ��� ���� ���Ǵ� �ֳ����̼��� ���� ��å�� SOURCE�̴�.
 *     @Retention(RetentionPolicy.SOURCE)
 *                // ������å.SOURCE or CLASS, RUNTIME
 *     public @interface Override{} 
 *     
 *   - ����ÿ� ��� ������ �ֳ����̼��� ��å�� RUNTIME�̴�.
 * 
 * @Repeatable
 *   - �ݺ��ؼ� ���� �� �ִ� �ֳ����̼��� ������ �� ���
 *     @Repeatable(ToDos.class) // ToDo�ֳ����̼��� ������ �ݺ��ؼ� �� �� �ְ� ���ش�.
 *     @interface ToDo{
 *         String value();
 *     }
 *   - @Repeatable�� ���� �ֳ����̼��� �ݺ��ؼ� ���� �� �ִ�.
 *     @ToDo("Delete test codes")
 *     @ToDo("override inherited methods")
 *     class Myclass{
 *         // ...
 *     }
 *   - @Repeatable�� @ToDo�� �ϳ��� ���� �����̳� �ֳ����̼ǵ� �����ؾ��Ѵ�.
 *     @interface ToDos{
 *         ToDo[] value(); // ToDo �ֳ����̼� �迭 Ÿ���� ��Ҹ� ����, �̸��� �ݵ�� value�̾���Ѵ�.
 *     }
 *     
 *     
 * �ֳ����̼� Ÿ�� �����ϱ�
 *   - �ֳ����̼��� ���� ����� �Ẹ��
 *     @interface �ֳ����̼��̸�{
 *         Ÿ�� ����̸�(); // �ֳ����̼� ��Ҹ� �����Ѵ�.
 *     }
 *   - �ֳ����̼��� �޼���� �߻�޼����̸� �ֳ����̼��� �����Ҷ� ����(����  X)
 *     @interface TestInfo{
 *         int count();
 *         String testedBy();
 *         String[] testTools();
 *         TestType testType(); // Enum testType{First, Final}
 *         DateTime testDate(); // �ڽ��� �ƴ� �ٸ� �ֳ����̼�(@DateTime)�� ������ �� �ִ�.
 *     }
 *     ���� TestInfo �ֳ����̼� ���
 *     @TestInfo( >> ��� ��ҵ鿡�� ���� ����������Ѵ�.
 *         count = 3, testedBy = "Kim",
 *         testTools = {"JUnit", "AutoTester"},
 *         testType = TestType.FIRST,
 *         testDate = @DateTime(yymmdd = "160101", hhmmss = "235959")
 *     )
 *     public class NewClass{...}
 *     
 * �ֳ����̼��� ���
 *   - ����� ���� �������� ������ ���� �� �ִ� �⺻�� ���� ���� (null ����)
 *     @interface TestInfo{
 *         int count() default 1; >> �⺻ ���� 1�� ����
 *     }
 *     ����
 *     @TestInfo >> @TestInfo(int count = 1) �� �����ϴ�.
 *     public class NewClass{...}
 *
 * - ��Ұ� �ϳ��̰� �̸��� value��� ������ �����ϴ�.
 *   @interface TestInfo{
 *       String value();
 *   }
 *   ����
 *   @TestInfo("passed") >> @TestInfo(value = "passed")�� �����ϴ�.
 *   class NewClass{...}
 *   
 * - ����� Ÿ���� �迭�� ���, ��ȣ {}�� ����ؾ��Ѵ�.
 *  @interface TestInfo{
 *      String[] testTools();
 *  }
 *  ����
 *  @TestInfo(testTools = {"JUnit", "AutoTester"}) >> 2�� �̻��϶�
 *  @TestInfo(testTools = "JUnit") >> 1�� �ϋ�
 *  @TestInfo(testTools = {}) >> 0���ϋ��� {}�� �ݵ�� ������Ѵ�.
 *  
 * - ��� �ֳ����̼��� ����
 *   - Annotation�� ��� �ֳ����̼��� ���������� ����� �Ұ��ϴ�.
 *     @interface TestInfo extends Annotation{ // Error! ������ �ʴ� ǥ��
 *         int count();
 *     }
 *   - ��� Annotation�� �������̽��̴�.
 *     package java.lang.annotation;
 *     public interface Annotation{
 *         boolean equals(Object obj);
 *         int hashCode();
 *         String toString();
 *         
 *         class <? extends Annotation> annotationType(); // �ֳ����̼��� Ÿ���� ��ȯ
 *     }
 *     
 * ��Ŀ �ֳ����̼�
 *   - ��Ұ� �ϳ��� ���ǵ��� �ʴ� �ֳ����̼�
 *     - ���÷� @Override, @Deprecated
 *     
 * �ֳ����̼� ����� ��Ģ
 *   - �ֳ����̼��� ��Ҹ� ������ �� �Ʒ��� ��Ģ�� �ݵ�� ���Ѿ��Ѵ�.
 *     - ����� Ÿ���� �⺻��, String, enum, �ֳ����̼�, Class(���赵)�� ���ȴ�.
 *     - ��ȣ() �ȿ� �Ű������� ������ �� ����.
 *     - ���ܸ� ������ �� ����.
 *     - ��Ҹ� Ÿ�� �Ű������� ���� �� �� ����.
 *     
 *   - �Ʒ��� �ڵ忡�� �߸��� �κ��� �������� ã���ÿ�.
 *     @interface Annotest{
 *         int id = 100;
 *         String major(int i, int j); // �Ű����� ���� �Ұ���
 *         String minor() throws Exception; // ���� ���� �Ұ���
 *         ArrayList<T> list(); // Ÿ�� �Ű����� ������ �� ����.
 *     }
 */