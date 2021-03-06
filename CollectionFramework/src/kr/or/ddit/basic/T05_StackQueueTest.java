package kr.or.ddit.basic;

import java.util.LinkedList;

public class T05_StackQueueTest {
	public static void main(String[] args) {
		// 스택 =>  (LIFO)의 자료구조
		// 큐 =>  (FIFO)의 자료구조
		
		// 스택과 큐는 LinkedList를 이용하여 사용 할 수 있다
		LinkedList<String> stack = new  LinkedList<String>();
		
		// 스택의 명령 
		// 자료입력 : push (저장할 값) 
		// 자료출력 : pop() => 자료를 꺼내온 후 꺼내온 자료를 스택에서 삭제한다 
		
		stack.push("한정환");
		stack.push("전성희");
		stack.push("백화점 세이");
		
		System.out.println("현재 값들1 : " + stack);
		
		String data = stack.pop();
		System.out.println("꺼내온 자료1 : " + data);
		System.out.println("꺼내온 자료2 : " + stack.pop());
		System.out.println("현재 값들2 : " + stack);
		
		stack.push("정지후");
		System.out.println("현재 값들3 : " + stack);
		System.out.println("꺼내온 자료3 : " + stack.pop());
		System.out.println("=========================");
		System.out.println();
		
		
		LinkedList<String> queue  = new LinkedList<String>();
		
		// 큐의 명령
		// 자료입력 : offer
		// 자료 출력 : poll() => 자료를 큐에서 꺼내온 후 자료는 큐에서 삭제된다.
		
		
		queue.offer("전성희");
		queue.offer("한정환");
		queue.offer("김재권");
		queue.offer("정수영");
		queue.offer("방민주씨");
		
		System.out.println("현재 큐의 값1 : " + queue);
		
		String temp = queue.poll();
		
		System.out.println("꺼내온 자료 : " + temp);
		System.out.println("꺼내온 자료 : " + queue.poll());
		System.out.println("현재 큐의 값2 : " + queue);
		
		
		if(queue.offer("전성희")) {
			System.out.println("신규등록자 : 전성희");
		}
		
		System.out.println("현재 큐의 값3 : " + queue);
		System.out.println("꺼내온 자료 : " + queue.poll());
	
	}
}
