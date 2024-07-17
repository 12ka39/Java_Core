import java.util.Stack;
// 스택은 먼저 들어온 게 먼저 나간다.
public class StackDemo {

	public static void main(String[] args) {
		
		
		// push(), pop(), peek(), empty()
		
		String[] array = {"한지민", "박지민", "홍지민", "한지민", "홍지민", "신지민", "곽지민"};
		Stack<String> stack = new Stack();
		for (String element : array) {
			stack.push(element);
		}
		// peek는 몇 번을 돌려도 같다 (가리키기만 한다)-- 삭제하지 않음
		System.out.println(stack.peek()); // 곽지민
		System.out.println(stack.peek()); // 곽지민
		System.out.println(stack.peek()); // 곽지민
		
		// pop은 나중에 들어온 거 먼저 찍어주고 삭제
		System.out.println(stack.pop()); // 곽지민
		System.out.println(stack.pop()); // 신지민
		System.out.println(stack.pop()); // 홍지민
		
		//스택이 비지 않았을 때까지만
		while(!stack.empty()) System.out.print(stack.pop() + ",");  // 제일 먼저 들어온 게 제일 나중에 삭제된다
	}
}
