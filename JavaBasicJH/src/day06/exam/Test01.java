package day06.exam;

class Node {
	int data;
	Node next;
	Node prev;
}
public class Test01 {
	public static void main(String[] args) {
		Node head  = new Node();
		head.data = 0;
		Node tail = head;
				
		tail.next = new Node();
		tail.next.data = 10;
		tail.next.prev = tail;
		tail = tail.next;
		
		tail.next = new Node();
		tail.next.data = 20;
		tail.next.prev = tail;
		tail = tail.next;
		
		tail.next = new Node();
		tail.next.data = 30;
		tail.next.prev = tail;
		tail = tail.next;
		 
		
		Node t = head.next;
		while (t!=null) {
			System.out.println(t.data);
			t = t.next;
		}
		
		System.out.println();
		
		Node k = tail;
		while (k != null) {
			System.out.println(k.data);
			k = k.prev;
			
		}
		
	}
}
