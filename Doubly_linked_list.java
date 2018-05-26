package algorithm;

public class Doubly_linked_list {
	
	// Node structure
	class Node {
		
		private Node next;
		private Node prev;
		private Object data;
		
		public Node(Object data) {
			this.data = data;
		}
	}
	
	// Create an head (head has data, but prev and next are null).
	public Node createHead(Object node) {
		Node head = new Node(node);
		head.next = null;
		head.prev = null;
		return head;
	}
	
	// Add a node from head (from left), and adjust prev and next pointer
	//            |--------------| (newHead.next -> head <-> newHead.next = head)
	// |prev| 8 |next|    |prev| 9 |next| (8 is newHead, 9 is head)
	//        |-------------| (head.prev -> newHead <-> head.prev = newHead)
	public Node addFromHead(Object node, Node head) {
		Node newHead = new Node(node);
		newHead.next = head;
		head.prev = newHead;
		newHead.prev = null;
		return newHead;
	}
	
	// Add a node from tail (from right), and return the new tail.
	public Node addFromTail(Object node, Node tail) {
		Node newTail = new Node(node);
		tail.next = newTail;
		newTail.prev = tail;
		newTail.next = null;
		return newTail;
	}
	
	// Remove a value from list and return head pointer (check from head to tail, from left to right)
	public Node removeFromList(Object value, Node node) {
		Node temp = node;
		
		// Check from head, head point prev is empty
		if(temp.data == value) {
			temp.next.prev = null;
			return temp.next;
		} else {
			temp = temp.next;
		}
		
		// Check from head to second least node
		while(temp.next != null) {
			if(temp.data == value) {
				temp.prev.next = temp.next; // details see addFromHead
				temp.next.prev = temp.prev;
				return node;	
			}
			temp = temp.next;
		}
		
		// Check the very last node, as last node.next is null.
		if(temp.data == value) {
			temp.prev.next = null;
			return node;
		}
		// if value is not in the list, just return head.
		return node;
	}
	
	// Print from head to the tail (tail prev and next pointer = null, but data exist).
	public void printFromHead(Node node) {
		Node temp = node;
		while(temp.next != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
		// Last node.next = null, but node.data exists.
		System.out.println(temp.data);
	}
	
	// Print from tail back to head. (head prev and next pointer = null, but data exist)
	public void printFromTail(Node node) {
		Node temp = node;
		while(temp.prev != null) {
			System.out.println(temp.data);
			temp = temp.prev;
		}
		System.out.println(temp.data);
	}

	public static void main(String[] args) {
		Doubly_linked_list doublely_linked_list = new Doubly_linked_list();
		
		// Create first node as head and tail.
		Node head = doublely_linked_list.createHead(30);	// head (head is empty with prev and next point = null)
		Node tail = head;	// tail
		
		// Insert some data into the list.
		Node node = doublely_linked_list.addFromHead(10, head);
		node = doublely_linked_list.addFromHead(15, node);
		node = doublely_linked_list.addFromHead(25, node);
		tail = doublely_linked_list.addFromTail(20, tail);
		doublely_linked_list.printFromHead(node);
		System.out.println("-----");
		node = doublely_linked_list.removeFromList(30, node);
		
		// Print list.
		doublely_linked_list.printFromHead(node);
		System.out.println("-----");
		doublely_linked_list.printFromTail(tail);
	}
}
