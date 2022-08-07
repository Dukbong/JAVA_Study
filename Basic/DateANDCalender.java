// ��¥�� �ð�
import java.util.Calendar;
import java.util.Date;

public class DateANDCalender {

	public static void main(String[] args) {
		CalendarTest2 s1 = new CalendarTest2();
		s1.get();
		System.out.printf("\n");
		
		CalendarTest3 s2 = new CalendarTest3();
		s2.dateSet();
		System.out.printf("\n");
		
		CalendarTest4 s3 = new CalendarTest4();
		s3.timeSet();
		System.out.printf("\n");
		
		CalendarTest5 s4 = new CalendarTest5();
		System.out.println(s4.getDayDiff("20010103", "20010101")); // 2
		System.out.println(s4.getDayDiff("20010103", "20010103")); // 0
		System.out.println(s4.getDayDiff("20010103", "200103")); // -1
		System.out.printf("\n");
		
		CalendarTest6 s5 = new CalendarTest6();
		s5.addTest();
		System.out.printf("\n");
		
		CalendarTest7 s6 = new CalendarTest7(); // �޷� �̱�
		String[] strArr = {"2022","08"};
		s6.test(strArr);
	}
}

// java.util.Date
// - ��¥�� �ð��� �ٷ� �������� ������� Ŭ���� (JDK 1.0)
// - Date�� �޼���� ���� ��� �ߴܵǾ�����, ������ ���̰� �ִ�.
//   - �ߴ� �ǰ� �ִ� ������ �ʹ� ���ϰ� ���� ������ ����.

// java.util.Calendar
// - DateŬ������ ������ ���ο� Ŭ�������� ������ ������ �����Ѵ�. (JDK 1.1)
// - �߻� Ŭ�����̹Ƿ� getInstance()�� ���� ������ ��ü�� ���� �Ѵ�.
// - get()���� ��¥�� �ð� �ʵ� �������� > int get(int field)
class CalendarTest1{
	Calendar cal = Calendar.getInstance(); // ���� ��¥�� �ð����� ���õȴ�.
	int thisYear = cal.get(Calendar.YEAR); // ���ذ� ������� �˾Ƴ���.
	int lastDayOfMonth = cal.getActualMaximum(Calendar.DATE); // �̴��� ���������� �˾Ƴ���.
}
// Calendar�� ���ǵ� �ʵ� (Calendar.Field)
// ��¥ ���� �ʵ�
// YEAR = ��
// MONTH = ��(0���� ����) > EX) 0 = 1��, 7 = 8��
// WEEK_OF_YEAR = �� ���� �� ��° �� ( 1�� 1�� ���� ���� )
// WEEK_OF_MONTH = �� ���� �� ��° ��
// DATE = ��
// DAY_OF_MONTH = �� ����  �� ��° ��
// DAY_OF_YEAR = �� ���� �� ���� �� ( 1�� 1�� ���� ���� )
// DAY_OF_WEEK = ���� ( 1 ~ 7 ) > 1 = �Ͽ���, 2 = ������
// DAY_OF_WEEK_IN_MONTH = �� ���� �� ��° ����
// ===============================================
// �ð� ���� �ʵ�
// HOUR = �ð�(0~11)
// HOUR_OF_DAY = �ð� (0~23)
// MINUTE = ��
// SECOND = ��
// MILLISECOND = õ���� 1��
// ZONE_OFFSET = GMT���� ���� ( õ���� ���� ���� ) > �ѱ��� +9 �̴�.
// AM_PM = 0 = ����, 1 = ����
class CalendarTest2{
	Calendar today = Calendar.getInstance(); // Calendar ��ü ����
	// ��ü�� �����Ǹ� �⺻������ ���� ��¥�� �ð����� �����ȴ�.
	void get() {
		System.out.println("���� �⵵ : " + today.get(Calendar.YEAR));
		// ���� ���� �ð��� �ƴ� �ٸ� �ð��� �˰� �������� set()�� �̿��ϸ� �ȴ�.
		System.out.println("��(0~11, 0:1��) : " + today.get(Calendar.MONTH));
		System.out.println("�� ���� ���° �� : " + today.get(Calendar.WEEK_OF_YEAR));
		System.out.println("�� ���� ���° �� : " + today.get(Calendar.WEEK_OF_MONTH));
		
		// DATE�� DAY_OF_MONTH�� ����.
		System.out.println("�� ���� ���� : " + today.get(Calendar.DATE));
		System.out.println("�� ���� ���� : " + today.get(Calendar.DAY_OF_MONTH));
		System.out.println("�� ���� ���� : " + today.get(Calendar.DAY_OF_YEAR));
		System.out.println("����(1~7 1:������) : " + today.get(Calendar.DAY_OF_WEEK));
		System.out.println("�� ���� �� ��° ���� : " + today.get(Calendar.DAY_OF_WEEK_IN_MONTH));
		System.out.println("����_����(0: ����, 1: ����) : " + today.get(Calendar.AM_PM));
		
		System.out.println("�ð�(0~11) : " + today.get(Calendar.HOUR));
		System.out.println("�ð�(0~23) : " + today.get(Calendar.HOUR_OF_DAY));
		System.out.println("��(0~59) : " + today.get(Calendar.MINUTE));
		System.out.println("��(0~59) : " + today.get(Calendar.SECOND));
		System.out.println("1000/1��(0~999) : " + today.get(Calendar.MILLISECOND));
		
		// õ���� 1�ʸ� �ð����� ǥ���ϱ� ���ؼ��� 3600000���� ��������� �Ѵ�. ( 1�ð� = 60 * 60�� )
		System.out.println("TimeZone(-12 ~ +12) : " + today.get(Calendar.ZONE_OFFSET)/(60*60*1000));
		System.out.println("�� ���� ������ ��  : " + today.getActualMaximum(Calendar.DATE)); // �� ���� ������ ���� ã�´�.
	}
}

// set()���� ��¥�� �ð��� �����ϱ�
// - void set(int field, int value);
// - void set(int year, int month, int date);
// - void set(int year, int month, int date, int hourOfDay, int minute);
// - void set(int year, int month, int date, int hourOfDay, int minute, int second);
//   - Ȱ���غ���
//     - ���� Calendar��ü�� �������ش�. Calendar date = Calendar.getInstance();
//     - ��¥�� �������ش�.            date.set(2017,7,15); > 2017�� 8�� 15��
//       - ��(Month)�� 0���� �����ϱ� ������ ��+1�� ���� ���´�.
//     - �� �� �� ���ε��� �ٲ��ֱ�
//       - date.set(Calendar.YEAR, 2017);
//       - date.set(Calendar.MONTH, 7); > 8
//       - date.set(Calendar.DATE, 15);
//     - �ð��� ���� �����ϴ� ����� ���� ������ ���ε��� �ٲ�����Ѵ�.
//       - 10�� 20�� 30�ʷ� �����ϱ�
//       - Calendar time = Calendar.getInstance();
//       - time.set(Calendar.HOUR_OF_DAY, 10);
//       - time.set(Calendar.MINUTE, 20);
//       - time.set(Calendar.SECOND, 30);
class CalendarTest3{
	final String[] DAY_OF_WEEK = {"","��","��","ȭ","��","��","��","��"};
	Calendar date1 = Calendar.getInstance();
	Calendar date2 = Calendar.getInstance();
	
	// month�� ��� 0���� �����ϱ� ������ 4���� ��� 3���� �����ؾ��Ѵ�.
	// date1.set(2019, Calendar.APRIL, 29);�� ���� �Ҽ��� �ִ�.
	void dateSet() {
		date1.set(2019,3,29); // 2019�� 4�� 29��
		System.out.println("date1�� " + toString(date1) + DAY_OF_WEEK[date1.get(Calendar.DAY_OF_WEEK)] + "�����̰�,");
		System.out.println("����(date2)�� " + toString(date2) + DAY_OF_WEEK[date2.get(Calendar.DAY_OF_WEEK)] + "�����Դϴ�.");
		
		// �� ��¥���� ���̸� ��������, getTimeInMillis() õ���� ���� ������ ��ȯ���Ѵ�.
		long difference = (date2.getTimeInMillis() - date1.getTimeInMillis())/1000;
		System.out.println("�� ��(date1)���� ����(date2)���� " + difference + "�ʰ� �������ϴ�.");
		System.out.println("��(day)�� ����ϸ� " + difference/(24*60*60) + "�� �Դϴ�.");
	}
	
	public static String toString(Calendar date) {
		return date.get(Calendar.YEAR) + "��" + (date.get(Calendar.MONTH)+1) + "��" + date.get(Calendar.DATE) + "�� ";
	}
}

class CalendarTest4{
	final int[] TIME_UNIT = {3600,60,1};
	final String[] TIME_UNIT_NAME = {"�ð� ", "�� ", "��"};
	
	Calendar time1 = Calendar.getInstance();
	Calendar time2 = Calendar.getInstance();
	
	void timeSet() {
		time1.set(Calendar.HOUR_OF_DAY, 10);
		time1.set(Calendar.MINUTE, 20);
		time1.set(Calendar.SECOND, 30);
		
		time2.set(Calendar.HOUR_OF_DAY, 20);
		time2.set(Calendar.MINUTE, 30);
		time2.set(Calendar.SECOND, 10);
		
		System.out.println("time1 : " + time1.get(Calendar.HOUR_OF_DAY) + "��" + time1.get(Calendar.MINUTE) + "��" + time1.get(Calendar.SECOND) + "��");
		System.out.println("time2 : " + time1.get(Calendar.HOUR_OF_DAY) + "��" + time2.get(Calendar.MINUTE) + "��" + time2.get(Calendar.SECOND) + "��");
		
		long difference = Math.abs(time2.getTimeInMillis() - time1.getTimeInMillis())/1000;
		System.out.println("time1�� time2�� ���̴� " + difference + "���Դϴ�.");
		
		String tmp = "";
		for (int i = 0; i < TIME_UNIT.length; i++) {
			tmp = tmp + difference/TIME_UNIT[i] + TIME_UNIT_NAME[i];
			difference = difference % TIME_UNIT[i];
		}
		System.out.println("�ú��ʷ� ��ȯ�ϸ� " + tmp + "�Դϴ�.");
	}
}

// clear()�� Calendar��ü�� ��� �ʵ带 �ʱ�ȭ ���ش�.
// - Calendar dt = Calendar.getInstance(); > ����ð�
// - System.out.println(new Date(dt.getTimeInMillis()); > Mon Aug 08 01:18:32 KST 2022
//   - ���� �ð��� ���õ� ������� ���´�.
// - dt.clear(); // ��� �ʵ� �ʱ�ȭ
// - System.out.println(new Date(dt.getTimeInMillis()); > Thu Jan 01 00:00:00 KST 1970
//   - �ʱ�ȭ�ϰ� �Ǹ� 1970�� 1�� 1�� 0�� 0�� 0�� �� �ȴ�.

// - Ư�� �ʵ常 �ʱ�ȭ �� �� �ִ�. clear(int field)
//   - Calendar dt2 = Calendar.getInstance();
//   - System.out.println(new Date(dt2.getTimeInMillis()); > Mon Aug 08 01:18:32 KST 2022
//   - dt2.clear(Calendar.SECOND); > �ʸ� 0���� �ʱ�ȭ
//   - dt2.clear(Calendar.MINUTE); > ���� 0���� �ʱ�ȭ
//   - dt2.clear(Calendar.HOUR_OF_DAY); > �ð��� 0���� �ʱ�ȭ
//   - dt2.clear(Calendar.HOUR); > �ð��� 0���� �ʱ�ȭ
//- System.out.println(new Date(dt2.getTimeInMillis()); > Mon Aug 08 00:00:00 KST 2022

class CalendarTest5{
	int getDayDiff(String yyyymmdd1, String yyyymmdd2) {
		int diff = 0;
		try {
			int year1 = Integer.parseInt(yyyymmdd1.substring(0,4));
			int month1 = Integer.valueOf(yyyymmdd1.substring(4,6)) - 1;
			int day1 = Integer.parseInt(yyyymmdd1.substring(6,8));
			int year2 = Integer.parseInt(yyyymmdd2.substring(0,4));
			int month2 = Integer.valueOf(yyyymmdd2.substring(4,6)) - 1;
			int day2 = Integer.parseInt(yyyymmdd2.substring(6,8));
			
			Calendar date1 = Calendar.getInstance();
			Calendar date2 = Calendar.getInstance();
			// ��Ȯ�� ����� ���ؼ� �ʱ�ȭ�� ���� ������� �Ѵ�.
			// �ʱ�ȭ������ ������ �̼��� ms���̰� �߻��մϴ�.
			date1.clear();
			date2.clear();
			
			date1.set(year1, month1, day1);
			date2.set(year2, month2, day2);
			diff = (int)((date1.getTimeInMillis() - date2.getTimeInMillis())/(24*60*60*1000));
		}catch(Exception e) {
			diff = -1;
		}
		return diff;
	}
}

// add()�� Ư�� �ʵ��� ���� ���� �Ǵ� ���� (�ٸ� �ʵ忡 ���� O)
// - Calendar date = Calendar.getInstance();
// - date.clear();
// - date.set(2020,7,31);
// - date.add(Calendar.DATE, 1); // ��¥(DATE)�� 1�� ���Ѵ�. > 9�� 1���� �ȴ�.
// - date.add(Calendar.MONTH, -8); // ��(MONTH)���� 8�� ����. > 1�� 1���� �ȴ�.

// roll()�� Ư�� �ʵ��� ���� ���� �Ǵ� ���� (�ٸ� �ʵ忡 ���� x)
//- Calendar date = Calendar.getInstance();
//- date.clear();
//- date.set(2020,7,31);
//- date.roll(Calendar.DATE, 1); // ��¥(DATE)�� 1�� ���Ѵ�. > 2020�� 8�� 1���� �ȴ�.
//- date.roll(Calendar.MONTH, -8); // ��(MONTH)���� 8�� ����. > 2020�� 12��  31���� �ȴ�.
class CalendarTest6{
	Calendar date = Calendar.getInstance();
	
	void addTest() {
		date.clear();
		date.set(2019, 7, 31);
		System.out.println(toString(date));
		System.out.println("= 1�� �� =");
		date.add(Calendar.DATE, 1);
		System.out.println(toString(date));
		
		System.out.println("= 6�� �� =");
		date.add(Calendar.MONTH, -6);
		System.out.println(toString(date));
		
		System.out.println("= 31�� ��(roll) =");
		date.roll(Calendar.DATE, 31);
		System.out.println(toString(date));
		
		System.out.println("= 31�� ��(add) =");
		date.add(Calendar.DATE, 31);
		System.out.println(toString(date));
	}
	
	public String toString(Calendar date) {
		return date.get(Calendar.YEAR) + "��" + (date.get(Calendar.MONTH)+1) + "��" + date.get(Calendar.DATE) + "��";
	}	
}

class CalendarTest7{
	
	void test(String[] a) {
		if (a.length != 2) {
			System.out.println("Usage : java CalendarTest7 2022 8");
			return;
		}
		int year = Integer.parseInt(a[0]);
		int month = Integer.parseInt(a[1]);
		int START_DAY_OF_WEEK = 0;
		int END_DAY = 0;
		
		Calendar sDay = Calendar.getInstance(); // ������
		Calendar eDay = Calendar.getInstance(); // ����
		sDay.clear();
		eDay.clear();
		// ���� ��� 0���� 11������ ���� �����Ƿ� 1�� ���־�� �Ѵ�.
		// ���� ���, 2019�� 11�� 1���� sDay.set(2019,10,1)�� ��
		sDay.set(year, month-1, 1);
		eDay.set(year, month, 1);
		// �������� ù��(12�� 1��)���� �Ϸ縦 ���� ������� ������ �� (11��30��)�� �ȴ�.
		//   - ������ ��¥�� ���� �� �ִ�.
		eDay.add(Calendar.DATE, -1); 
		// ù ���� ������ ���� �������� �˾Ƴ���.
		START_DAY_OF_WEEK = sDay.get(Calendar.DAY_OF_WEEK);
		// eDay�� ����Ǿ��ִ� ��¥�� �����´�.
		END_DAY = eDay.get(Calendar.DATE);
		System.out.println("      " + a[0] + "�� " + a[1]+ "��");
		System.out.println(" SU MO TU WE TH FR SA");
		
		// �ش� ���� 1���� ������������� ���� ������ ����Ѵ�.
		// ���� 1���� �������̶�� ������ ���� ��´�. (�Ͽ��� ���� ����)
		for (int i = 1; i < START_DAY_OF_WEEK; i++) {
			System.out.print("   ");
		}
		for (int i = 1, n = START_DAY_OF_WEEK; i <= END_DAY; i++, n++) {
			System.out.print((i < 10)?"  " +i:" "+i);
			if(n%7 == 0) {
				System.out.println();
			}
		}
	}
}

// Date�� Calendar���� ��ȯ
// - Date�� �޼���� ��κ� ������� �������� ����ǰ� ������ ������ ���ǰ� �ֽ��ϴ�.
//   - 1. Calendar�� Date�� ��ȯ
//        - Calendar cal = Calendar.getInstance();
//        - Date d = new Date(cal.getTimeMillis()); // Date(long date)
//   - 2. Date�� Calendar�� ��ȯ
//        - Date d = new Date();
//        - Calendar cal = Calendar.getInstance();
//        - cal.setTime(d);

// java.time ��Ű��
// - Date�� Calendar�� ������ ������ ���ο� Ŭ������ ���� (JDK 1.8)
//   - Date�� Calendar�� �������δ� ��¥�� �ð��� ������ ���� ���´ٴ� ���̴�.
//   - java.time ��Ű�������� ��¥�� LocalDate �ð��� LocalTime ���̴� LocalDateTime���� �̿��� �����ϴ�.

