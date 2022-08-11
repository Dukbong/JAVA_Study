import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class StackAndQueue {

	public static void main(String[] args) {
		//예제
		Stack st = new Stack();
		Queue q = new LinkedList();
		
		st.push("0");
		st.push("1");
		st.push("2");
		
		q.offer("0");
		q.offer("1");
		q.offer("2");
		
		System.out.println("= Stack =");
		while(!st.empty()) {
			System.out.println(st.pop()); // Stack에서 맨위에서 부터 하나씩 제거
		}
		System.out.println("= Queue =");
		while(!q.isEmpty()) {
			System.out.println(q.poll()); // Queue에서 맨 처음 부터 하나씩 제거
		}
		
		// 예제 2
		if(args.length != 1) {
			System.out.println("Usage : java StackAndQueue \"EXPRESSION\"");
			System.out.println("Example : java StackAndQueue \"((2 + 3)*1+3\"");
			System.exit(0);
		}
		Stack st2 = new Stack();
		String expression = args[0];
		
		System.out.println("Expression = " + expression);
		
		try {
			for (int i = 0; i < expression.length(); i++) {
				char ch = expression.charAt(i);
				
				if(ch == '(') {
					st2.push(ch + "");
				}else if(ch == ')') {
					st2.pop();
				}
			}
			if (st2.isEmpty()) {
				System.out.println("괄호가 일치합니다.");
			}else {
				System.out.println("괄호가 일치하지 않습니다.");
			}
		}catch(EmptyStackException e) {
			System.out.println("괄호가 일치하지 안습니다.");
			
		}
		
		// 예제 3
		System.out.println("help를 입룍하여 도움말을 볼수 있다.");
		while(true) {
			Scanner s = new Scanner(System.in);
			String input  = s.nextLine().trim();
			
			if ("".equals(input)) {
				continue;
			}
			if (input.equalsIgnoreCase("q")) {
				System.exit(0);
			}else if (input.equalsIgnoreCase("help")) {
				System.out.println("help - 도움말을 보여준다.");
				System.out.println("q 또는 Q - 프로그램을 종료합니다.");
				System.out.println("history - 최근에 입력한 명령어를 " + MAX_SIZE + "개 보여줍니다.");
			}else if(input.equals("history")) {
				save(input);
				
				LinkedList list = (LinkedList)q;
				
				for (int j = 0; j < list.size(); j++) {
					System.out.println((j+1) + "." + list.get(j));
				}
			}
		}
		

	}
	    // 예제 3번 내용
	static Queue q = new LinkedList();
	static final int MAX_SIZE = 5;
	
	public static void save(String input) {
		if(!"".equals(input)) {
			q.offer(input);
		}
		if(q.size() > MAX_SIZE) {
			q.remove();
		}
	}
	

}

/*
스택 (Stack) : 수식계산, 수식괄호검사, 웨브라우저의 뒤로/앞으로
 - LIFO 구조 (Last in First Out) 마지막에 저장(push)된 것을 제일 먼저 추출된다.(pop)
 - 가장 효율적인 구조는 배열이다.
 - 생성 : Stack st = new Stack();
   - 메서드
     - boolean empty() : Stack이 비어있는 확인
     - Object peek() : Stack의 맨 위에 저장된 객체를 보여준다. (삭제되지 않음)
     - Object pop() : Stack의 맨 위에 저장된 객체를 추출한다. (삭제)
       - peek(), pop() 만약 Stack이 비어있다면 EmptyStackException 발생
     - Object push(Object item) : Stack에 객체(item)을 저장한다. (추가)
     - int search(Object o) : Stack에 주어진 객체(o)를 찾아서 위치를 반환한다.
       - 없으면 -1을 반환한다. (배열과 달리 stack의 인덱스는 1부터 시작하며 맨 위에서부터 1이고 그아래는 2 ...)

큐 (Queue) : 최근 사용 문서, 인쇄작업 대기목록, 버퍼(Buffer)
 - FIFO 구조 (First in First Out)제일 먼저 저장(offer)한 것이 제일 먼저 추출된다.(poll)
 - 효율적인 구조는 LinkedList
 - Queue는 인터페이스이기 때문에 생성할 수 없다.
   - 생성하는 방법
   - 1. Queue를 직접구현
   - 2. Queue를 구현한 클래스 사용 : LinkedList ( Queue q = new LinkedList(); )
   - 메서드
     - boolean add(Object o) : 지정된 객체(o)를 Queue에 추가한다. 성공하면 true 반환 (추가 - 예외발생)
       - 저장공간이 부족하면 lllegalStateException 발생
     - Object remove() : Queue에서 객체를 꺼내 반환, 비어있다면 NoSuchElementException 발생 (삭제 - 예외발생)
     - Object element() : 삭제없이 요소를 읽어온다. 비어있다면 NoSuchElementException 발생
     - 아래가 더 중요하다
     - boolean offer(Object o) : Queue에 객체를 저장, 성공하면 true, 실패하면 false 반환 (추가)
     - Object poll() : Queue에서 객체를 꺼내서 반환 비어있다면 null을 반환 (삭제)
     - Object peek() : 삭제없이 요소를 읽어온다. 비어있다면 null 반환

*/
