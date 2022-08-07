// 날짜와 시간
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
		
		CalendarTest7 s6 = new CalendarTest7(); // 달력 뽑기
		String[] strArr = {"2022","08"};
		s6.test(strArr);
	}
}

// java.util.Date
// - 날짜와 시간을 다룰 목적으로 만들어진 클래스 (JDK 1.0)
// - Date의 메서드는 거의 사용 중단되었지만, 여전히 쓰이고 있다.
//   - 중단 되고 있는 이유는 너무 급하게 만들어서 단점이 많다.

// java.util.Calendar
// - Date클래스를 개선한 새로운 클래스지만 여전히 단점이 존재한다. (JDK 1.1)
// - 추상 클래스이므로 getInstance()를 통해 구현된 객체를 얻어야 한다.
// - get()으로 날짜와 시간 필드 가져오기 > int get(int field)
class CalendarTest1{
	Calendar cal = Calendar.getInstance(); // 현재 날짜와 시간으로 셋팅된다.
	int thisYear = cal.get(Calendar.YEAR); // 올해가 몇년인지 알아낸다.
	int lastDayOfMonth = cal.getActualMaximum(Calendar.DATE); // 이달의 마지막날을 알아낸다.
}
// Calendar에 정의된 필드 (Calendar.Field)
// 날짜 관련 필드
// YEAR = 년
// MONTH = 월(0부터 시작) > EX) 0 = 1월, 7 = 8월
// WEEK_OF_YEAR = 그 해의 몇 번째 주 ( 1월 1일 부터 시작 )
// WEEK_OF_MONTH = 그 달의 몇 번째 주
// DATE = 일
// DAY_OF_MONTH = 그 달의  몇 번째 일
// DAY_OF_YEAR = 그 해의 몇 번쨰 일 ( 1월 1일 부터 시작 )
// DAY_OF_WEEK = 요일 ( 1 ~ 7 ) > 1 = 일요일, 2 = 월요일
// DAY_OF_WEEK_IN_MONTH = 그 달의 몇 번째 요일
// ===============================================
// 시간 관련 필드
// HOUR = 시간(0~11)
// HOUR_OF_DAY = 시간 (0~23)
// MINUTE = 분
// SECOND = 초
// MILLISECOND = 천분의 1초
// ZONE_OFFSET = GMT기준 시차 ( 천분의 일초 단위 ) > 한국은 +9 이다.
// AM_PM = 0 = 오전, 1 = 오후
class CalendarTest2{
	Calendar today = Calendar.getInstance(); // Calendar 객체 생성
	// 객체가 생성되면 기본적으로 현재 날짜와 시간으로 설정된다.
	void get() {
		System.out.println("올해 년도 : " + today.get(Calendar.YEAR));
		// 만약 현재 시간이 아닌 다른 시간을 알고 싶을때는 set()을 이용하면 된다.
		System.out.println("월(0~11, 0:1월) : " + today.get(Calendar.MONTH));
		System.out.println("올 해의 몇번째 주 : " + today.get(Calendar.WEEK_OF_YEAR));
		System.out.println("이 달의 몇번째 주 : " + today.get(Calendar.WEEK_OF_MONTH));
		
		// DATE와 DAY_OF_MONTH는 같다.
		System.out.println("이 달의 몇일 : " + today.get(Calendar.DATE));
		System.out.println("이 달의 몇일 : " + today.get(Calendar.DAY_OF_MONTH));
		System.out.println("이 해의 몇일 : " + today.get(Calendar.DAY_OF_YEAR));
		System.out.println("요일(1~7 1:월요일) : " + today.get(Calendar.DAY_OF_WEEK));
		System.out.println("이 달의 몇 번째 요일 : " + today.get(Calendar.DAY_OF_WEEK_IN_MONTH));
		System.out.println("오전_오후(0: 오전, 1: 오후) : " + today.get(Calendar.AM_PM));
		
		System.out.println("시간(0~11) : " + today.get(Calendar.HOUR));
		System.out.println("시간(0~23) : " + today.get(Calendar.HOUR_OF_DAY));
		System.out.println("분(0~59) : " + today.get(Calendar.MINUTE));
		System.out.println("초(0~59) : " + today.get(Calendar.SECOND));
		System.out.println("1000/1초(0~999) : " + today.get(Calendar.MILLISECOND));
		
		// 천분의 1초를 시간으로 표시하기 위해서는 3600000으로 나누어줘야 한다. ( 1시간 = 60 * 60초 )
		System.out.println("TimeZone(-12 ~ +12) : " + today.get(Calendar.ZONE_OFFSET)/(60*60*1000));
		System.out.println("이 달의 마지막 날  : " + today.getActualMaximum(Calendar.DATE)); // 이 달의 마지막 일을 찾는다.
	}
}

// set()으로 날짜와 시간을 지정하기
// - void set(int field, int value);
// - void set(int year, int month, int date);
// - void set(int year, int month, int date, int hourOfDay, int minute);
// - void set(int year, int month, int date, int hourOfDay, int minute, int second);
//   - 활용해보기
//     - 먼저 Calendar객체를 생성해준다. Calendar date = Calendar.getInstance();
//     - 날짜를 지정해준다.            date.set(2017,7,15); > 2017년 8월 15일
//       - 월(Month)은 0부터 시작하기 때문에 월+1한 값이 나온다.
//     - 년 월 일 따로따로 바꿔주기
//       - date.set(Calendar.YEAR, 2017);
//       - date.set(Calendar.MONTH, 7); > 8
//       - date.set(Calendar.DATE, 15);
//     - 시간만 따로 지정하는 방법은 없기 때문에 따로따로 바꿔줘야한다.
//       - 10시 20분 30초로 설정하기
//       - Calendar time = Calendar.getInstance();
//       - time.set(Calendar.HOUR_OF_DAY, 10);
//       - time.set(Calendar.MINUTE, 20);
//       - time.set(Calendar.SECOND, 30);
class CalendarTest3{
	final String[] DAY_OF_WEEK = {"","일","월","화","수","목","금","토"};
	Calendar date1 = Calendar.getInstance();
	Calendar date2 = Calendar.getInstance();
	
	// month의 경우 0부터 시작하기 때문에 4월인 경우 3으로 지정해야한다.
	// date1.set(2019, Calendar.APRIL, 29);와 같이 할수도 있다.
	void dateSet() {
		date1.set(2019,3,29); // 2019년 4월 29일
		System.out.println("date1은 " + toString(date1) + DAY_OF_WEEK[date1.get(Calendar.DAY_OF_WEEK)] + "요일이고,");
		System.out.println("오늘(date2)은 " + toString(date2) + DAY_OF_WEEK[date2.get(Calendar.DAY_OF_WEEK)] + "요일입니다.");
		
		// 두 날짜간의 차이를 얻으려면, getTimeInMillis() 천분의 일초 단위로 변환해한다.
		long difference = (date2.getTimeInMillis() - date1.getTimeInMillis())/1000;
		System.out.println("그 날(date1)부터 지금(date2)까지 " + difference + "초가 지났습니다.");
		System.out.println("일(day)로 계산하면 " + difference/(24*60*60) + "일 입니다.");
	}
	
	public static String toString(Calendar date) {
		return date.get(Calendar.YEAR) + "년" + (date.get(Calendar.MONTH)+1) + "월" + date.get(Calendar.DATE) + "일 ";
	}
}

class CalendarTest4{
	final int[] TIME_UNIT = {3600,60,1};
	final String[] TIME_UNIT_NAME = {"시간 ", "분 ", "초"};
	
	Calendar time1 = Calendar.getInstance();
	Calendar time2 = Calendar.getInstance();
	
	void timeSet() {
		time1.set(Calendar.HOUR_OF_DAY, 10);
		time1.set(Calendar.MINUTE, 20);
		time1.set(Calendar.SECOND, 30);
		
		time2.set(Calendar.HOUR_OF_DAY, 20);
		time2.set(Calendar.MINUTE, 30);
		time2.set(Calendar.SECOND, 10);
		
		System.out.println("time1 : " + time1.get(Calendar.HOUR_OF_DAY) + "시" + time1.get(Calendar.MINUTE) + "분" + time1.get(Calendar.SECOND) + "초");
		System.out.println("time2 : " + time1.get(Calendar.HOUR_OF_DAY) + "시" + time2.get(Calendar.MINUTE) + "분" + time2.get(Calendar.SECOND) + "초");
		
		long difference = Math.abs(time2.getTimeInMillis() - time1.getTimeInMillis())/1000;
		System.out.println("time1과 time2의 차이는 " + difference + "초입니다.");
		
		String tmp = "";
		for (int i = 0; i < TIME_UNIT.length; i++) {
			tmp = tmp + difference/TIME_UNIT[i] + TIME_UNIT_NAME[i];
			difference = difference % TIME_UNIT[i];
		}
		System.out.println("시분초로 변환하면 " + tmp + "입니다.");
	}
}

// clear()는 Calendar객체의 모든 필드를 초기화 헤준다.
// - Calendar dt = Calendar.getInstance(); > 현재시간
// - System.out.println(new Date(dt.getTimeInMillis()); > Mon Aug 08 01:18:32 KST 2022
//   - 현재 시간에 관련된 내용들이 나온다.
// - dt.clear(); // 모든 필드 초기화
// - System.out.println(new Date(dt.getTimeInMillis()); > Thu Jan 01 00:00:00 KST 1970
//   - 초기화하게 되면 1970년 1월 1일 0시 0분 0초 가 된다.

// - 특정 필드만 초기화 할 수 있다. clear(int field)
//   - Calendar dt2 = Calendar.getInstance();
//   - System.out.println(new Date(dt2.getTimeInMillis()); > Mon Aug 08 01:18:32 KST 2022
//   - dt2.clear(Calendar.SECOND); > 초를 0으로 초기화
//   - dt2.clear(Calendar.MINUTE); > 분을 0츠로 초기화
//   - dt2.clear(Calendar.HOUR_OF_DAY); > 시간을 0으로 초기화
//   - dt2.clear(Calendar.HOUR); > 시간을 0으로 초기화
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
			// 정확한 계산을 위해서 초기화를 먼저 시켜줘야 한다.
			// 초기화해주지 않으면 미세한 ms차이가 발생합니다.
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

// add()는 특정 필드의 값을 증가 또는 감소 (다른 필드에 영향 O)
// - Calendar date = Calendar.getInstance();
// - date.clear();
// - date.set(2020,7,31);
// - date.add(Calendar.DATE, 1); // 날짜(DATE)에 1을 더한다. > 9월 1일이 된다.
// - date.add(Calendar.MONTH, -8); // 월(MONTH)에서 8을 뺀다. > 1월 1일이 된다.

// roll()은 특정 필드의 값을 증가 또는 감소 (다른 필드에 영향 x)
//- Calendar date = Calendar.getInstance();
//- date.clear();
//- date.set(2020,7,31);
//- date.roll(Calendar.DATE, 1); // 날짜(DATE)에 1을 더한다. > 2020년 8월 1일이 된다.
//- date.roll(Calendar.MONTH, -8); // 월(MONTH)에서 8을 뺀다. > 2020년 12월  31일이 된다.
class CalendarTest6{
	Calendar date = Calendar.getInstance();
	
	void addTest() {
		date.clear();
		date.set(2019, 7, 31);
		System.out.println(toString(date));
		System.out.println("= 1일 후 =");
		date.add(Calendar.DATE, 1);
		System.out.println(toString(date));
		
		System.out.println("= 6달 전 =");
		date.add(Calendar.MONTH, -6);
		System.out.println(toString(date));
		
		System.out.println("= 31일 후(roll) =");
		date.roll(Calendar.DATE, 31);
		System.out.println(toString(date));
		
		System.out.println("= 31일 후(add) =");
		date.add(Calendar.DATE, 31);
		System.out.println(toString(date));
	}
	
	public String toString(Calendar date) {
		return date.get(Calendar.YEAR) + "년" + (date.get(Calendar.MONTH)+1) + "월" + date.get(Calendar.DATE) + "일";
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
		
		Calendar sDay = Calendar.getInstance(); // 시작일
		Calendar eDay = Calendar.getInstance(); // 끝일
		sDay.clear();
		eDay.clear();
		// 월의 경우 0부터 11까지의 값을 가지므로 1을 빼주어야 한다.
		// 예를 들어, 2019년 11월 1일은 sDay.set(2019,10,1)과 같
		sDay.set(year, month-1, 1);
		eDay.set(year, month, 1);
		// 다음달의 첫날(12월 1일)에서 하루를 빼면 현재달의 마지막 날 (11월30일)이 된다.
		//   - 마지막 날짜를 구할 수 있다.
		eDay.add(Calendar.DATE, -1); 
		// 첫 번쨰 요일이 무슨 요일인지 알아낸다.
		START_DAY_OF_WEEK = sDay.get(Calendar.DAY_OF_WEEK);
		// eDay에 저장되어있는 날짜를 가져온다.
		END_DAY = eDay.get(Calendar.DATE);
		System.out.println("      " + a[0] + "년 " + a[1]+ "월");
		System.out.println(" SU MO TU WE TH FR SA");
		
		// 해당 월의 1일이 어느요일인지에 따라서 공백을 출력한다.
		// 만약 1일이 수요일이라면 공백을 세번 찍는다. (일요일 부터 시작)
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

// Date와 Calendar간의 변환
// - Date의 메서드는 대부분 사용하지 않을것을 권장되고 있지만 여전히 사용되고 있습니다.
//   - 1. Calendar를 Date로 변환
//        - Calendar cal = Calendar.getInstance();
//        - Date d = new Date(cal.getTimeMillis()); // Date(long date)
//   - 2. Date를 Calendar로 변환
//        - Date d = new Date();
//        - Calendar cal = Calendar.getInstance();
//        - cal.setTime(d);

// java.time 패키지
// - Date와 Calendar의 단점을 개선한 새로운 클래스를 제공 (JDK 1.8)
//   - Date와 Calendar의 단점으로는 날짜와 시간이 무조건 같이 나온다는 것이다.
//   - java.time 패키지에서는 날짜는 LocalDate 시간은 LocalTime 같이는 LocalDateTime으로 이용이 가능하다.

