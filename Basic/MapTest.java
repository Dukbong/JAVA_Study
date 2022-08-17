import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class MapTest {

	public static void main(String[] args) {
		// ���� 1
		 HashMap map = new HashMap();
		 map.put("myid", "1234");
		 map.put("asdf", "1111");
		 map.put("asdf", "1234");
		 
		 Scanner s = new Scanner(System.in);
		 
		 while(true) {
			 System.out.println("id�� ��й�ȣ�� �Է��ϼ���.");
			 System.out.print("id : ");
			 String id = s.nextLine().trim();
			 
			 System.out.println("pw : ");
			 String pw = s.nextLine().trim();
			 System.out.println();
			 
			 if(!map.containsKey(id)) {
				 System.out.println("�Է��Ͻ� id�� �������� �ʽ��ϴ�. �ٽ� �Է��ϼ���.");
				 continue;
			 }
			 
			 if(!(map.get(id).equals(pw))) {
				 System.out.println("��й�ȣ�� ��ġ���� �ʽ��ϴ�. �ٽ� �Է����ֻ���.");
			 }else {
				 System.out.println("id�� pw�� ��ġ�մϴ�.");
				 break;
			 }
		 }
		 
		 // ����2
		 HashMap map2 = new HashMap();
		 map2.put("jang", 90);
		 map2.put("jang", new Integer(100));
		 map2.put("choi", new Integer(100));
		 map2.put("hong", new Integer(80));
		 map2.put("wuri", new Integer(90));
		 
		 Set set = map2.entrySet();
		 Iterator it = set.iterator();
		 
		 while(it.hasNext()) {
			 Map.Entry e = (Map.Entry)it.next();
			 System.out.println("�̸� : " + e.getKey() + "���� : " + e.getValue());
		 }
		 
		 set = map2.keySet();
		 System.out.println("������ ��� : " + set);
		 
		 Collection values = map.values();
		 it = values.iterator();
		 
		 int total = 0;
		 
		 while (it.hasNext()) {
			 Integer i = (Integer)it.next();
			 total = total + i.intValue();
		 }
		 
		 System.out.println("������ : " + total);
		 System.out.println("��� : " + (float)total/set.size());
		 System.out.println("�ְ����� : " + Collections.max(values) );
		 System.out.println("�������� : " + Collections.min(values));
		 
		 // ���� 3
		 String [] data = {"A","K","A","W","D","A","K","K","K","Z","D"};
		 HashMap map3 = new HashMap();
		 for (int i = 0; i < data.length; i++) {
			 if(map.containsKey(data[i])) {
				 int value = (int)map.get(data[i]);
				 map.put(data[i], value+1);
			 }else {
				 map.put(data[i],  1);
			 }
			 Iterator it2 = map.entrySet().iterator();
			 
			 while(it2.hasNext()) {
				 Map.Entry entry = (Map.Entry)it2.next();
				 int value2 = (int)entry.getValue();
				 System.out.println(entry.getKey() + ":" + printBar('#',value2) + " " + value2);
			 }
		 }
	}

}

/*
Map�� ���� x �ߺ�(Ű x �� o)
 - HashMap�� Hashtable�� Map�������̽��� ����, �����͸� Ű�� ���� ������ ����
   - HashMap�� ����ȭ x, Hashtable�� ����ȭ o ( Hashtable�� �������̰� HashMap�� �Ź����̴�.)

HashMap
 - ������ �����Ϸ��� LinkedHashMap Ŭ������ ����ϸ� �ȴ�.
TreeMap ( TreeSet�� �����ϴ�. )
 - ���� �˻��� ���Ŀ� ������ �÷��� Ŭ����
 - HashMap���� ������ �߰�, ���� ȿ������ ��������.
 
 
HashMap
 - �ؽ�(hashing)������� �����͸� ����(put), �����Ͱ� ���Ƶ� �˻��� ������.
   - �ؽ��̶�? �ؽ� �Լ��� �̿��ؼ� �ؽ����̺� �����͸� �����ϰ� �о���� ���̴�.
     - �ؽ����̺��� �迭(���ټ�)�� ��ũ�� ����Ʈ(���� ����)�� ���յ� �����̴�.
       - �ؽ����̺� ����� �����͸� �������� ����
         1) Ű�� �ؽ��Լ��� ȣ���ؼ� �ؽ��ڵ带 ��´�.
         2) �ؽ��ڵ忡 �����ϴ� ��ũ�帮��Ʈ�� �迭���� ã�´�.
         3) ��ũ�帮��Ʈ���� Ű�� ��ġ�ϴ� �����͸� ã�´�.
           - �ؽ��Լ��� ���� Ű�� ���� �׻� ���� hashcode�� ��ȯ�ؾ��Ѵ�.
           - ���δٸ� Ű������ ���� ���� hashcode�� ��ȯ�� �� �� �ִ�.
   HashMap map = new HashMap(); >> ������
   map.put("Myid", "1234");
   map.put("asdf", "1111");
   map.put("asdf", "1234"); // key�� �ߺ��� �Ǹ� ���� ksy���� ������ ������������ ����ȴ�.
   >> ���� ���� ���
      key  value
      Myid 1234
      asdf 1234

HashMap�� �ֿ� �޼���
 - HashMap() : �⺻ ������
 - HashMap(int initialCapacity) : ������ (�ʱ�뷮)
 - HashMap(int initialCapacity, float loadFactor)
 - HashMap(Map m)
 
 - Object put(Object key, Object value) : �߰�
 - Object putAll(Map m) : �߰�
 - Object remove(Object key) : ����
 - Object replace(Object key, Object value) : ����
 - boolean replace(Object key, Object oldValue, Object newValue) : ����
 
 >> �б�
 - Set entrySet() : Ű�� �� ������ ��������
 - Set keySet() : Ű�� ��������
 - Collection values() : ���� ��������
 
  - Object get(Object key) : ������ Ű(key)�� �ش��ϴ� value�� ��ȯ�Ѵ�. 
  - Object getOrDefault(Object key, Object defaultValue) : ������ key�� ������ ������ ��(defaultValue)�� ��ȯ�Ѵ�.
  - boolean containsKey(Object key) : Ű�� ���� HashMap�� �����ϴ���
  - boolean containsValue(Object value) : ���� ���� HashMap�� �����ϴ���

*/