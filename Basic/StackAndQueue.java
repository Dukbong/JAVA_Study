import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class StackAndQueue {

	public static void main(String[] args) {
		//����
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
			System.out.println(st.pop()); // Stack���� �������� ���� �ϳ��� ����
		}
		System.out.println("= Queue =");
		while(!q.isEmpty()) {
			System.out.println(q.poll()); // Queue���� �� ó�� ���� �ϳ��� ����
		}
		
		// ���� 2
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
				System.out.println("��ȣ�� ��ġ�մϴ�.");
			}else {
				System.out.println("��ȣ�� ��ġ���� �ʽ��ϴ�.");
			}
		}catch(EmptyStackException e) {
			System.out.println("��ȣ�� ��ġ���� �Ƚ��ϴ�.");
			
		}
		
		// ���� 3
		System.out.println("help�� �ԏ��Ͽ� ������ ���� �ִ�.");
		while(true) {
			Scanner s = new Scanner(System.in);
			String input  = s.nextLine().trim();
			
			if ("".equals(input)) {
				continue;
			}
			if (input.equalsIgnoreCase("q")) {
				System.exit(0);
			}else if (input.equalsIgnoreCase("help")) {
				System.out.println("help - ������ �����ش�.");
				System.out.println("q �Ǵ� Q - ���α׷��� �����մϴ�.");
				System.out.println("history - �ֱٿ� �Է��� ��ɾ " + MAX_SIZE + "�� �����ݴϴ�.");
			}else if(input.equals("history")) {
				save(input);
				
				LinkedList list = (LinkedList)q;
				
				for (int j = 0; j < list.size(); j++) {
					System.out.println((j+1) + "." + list.get(j));
				}
			}
		}
		

	}
	    // ���� 3�� ����
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
���� (Stack) : ���İ��, ���İ�ȣ�˻�, ���������� �ڷ�/������
 - LIFO ���� (Last in First Out) �������� ����(push)�� ���� ���� ���� ����ȴ�.(pop)
 - ���� ȿ������ ������ �迭�̴�.
 - ���� : Stack st = new Stack();
   - �޼���
     - boolean empty() : Stack�� ����ִ� Ȯ��
     - Object peek() : Stack�� �� ���� ����� ��ü�� �����ش�. (�������� ����)
     - Object pop() : Stack�� �� ���� ����� ��ü�� �����Ѵ�. (����)
       - peek(), pop() ���� Stack�� ����ִٸ� EmptyStackException �߻�
     - Object push(Object item) : Stack�� ��ü(item)�� �����Ѵ�. (�߰�)
     - int search(Object o) : Stack�� �־��� ��ü(o)�� ã�Ƽ� ��ġ�� ��ȯ�Ѵ�.
       - ������ -1�� ��ȯ�Ѵ�. (�迭�� �޸� stack�� �ε����� 1���� �����ϸ� �� ���������� 1�̰� �׾Ʒ��� 2 ...)

ť (Queue) : �ֱ� ��� ����, �μ��۾� �����, ����(Buffer)
 - FIFO ���� (First in First Out)���� ���� ����(offer)�� ���� ���� ���� ����ȴ�.(poll)
 - ȿ������ ������ LinkedList
 - Queue�� �������̽��̱� ������ ������ �� ����.
   - �����ϴ� ���
   - 1. Queue�� ��������
   - 2. Queue�� ������ Ŭ���� ��� : LinkedList ( Queue q = new LinkedList(); )
   - �޼���
     - boolean add(Object o) : ������ ��ü(o)�� Queue�� �߰��Ѵ�. �����ϸ� true ��ȯ (�߰� - ���ܹ߻�)
       - ��������� �����ϸ� lllegalStateException �߻�
     - Object remove() : Queue���� ��ü�� ���� ��ȯ, ����ִٸ� NoSuchElementException �߻� (���� - ���ܹ߻�)
     - Object element() : �������� ��Ҹ� �о�´�. ����ִٸ� NoSuchElementException �߻�
     - �Ʒ��� �� �߿��ϴ�
     - boolean offer(Object o) : Queue�� ��ü�� ����, �����ϸ� true, �����ϸ� false ��ȯ (�߰�)
     - Object poll() : Queue���� ��ü�� ������ ��ȯ ����ִٸ� null�� ��ȯ (����)
     - Object peek() : �������� ��Ҹ� �о�´�. ����ִٸ� null ��ȯ

*/
