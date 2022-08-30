
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
	//�ֳ����̼� ��뿹
	@Test // �̸޼��尡 �׽�Ʈ ������� �׽�Ʈ ���α׷����� ���Ѵ�.
	// JUnit (����) �׽�Ʈ ���α׷��� Ȯ���Ѵ�.
	public void method() {
		//...
	}
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
 */