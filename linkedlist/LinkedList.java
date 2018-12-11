package linkedlist;

import javax.swing.text.html.HTMLEditorKit.InsertHTMLTextAction;

public class LinkedList {

	public static class Node {
		private int data;
		private Node next;
		
		public Node(int data, Node next) {
			this.data = data;
			this.next = next;
		}
		
		public int getData() {
			return data;
		}
	}
	
	private Node head = null;
	
	public Node findByValue(int value) {
		Node p = head;
		while(p != null && p.data != value) {
			p = p.next;
		}
		return p;
	}
	
	public Node findByIndex(int index) {
		int pos = 0;
		Node p = head;
		while(p != null && pos != index) {
			pos++;
			p = p.next;
		}
		return p;
	}
	
	//无头结点
    //表头部插入
    //这种操作将于输入的顺序相反，逆序
    public void insertToHead(int value) {
    	Node p = new Node(value, null);
    	insertToHead(p);
    	
    }
	
    public void insertToHead(Node newNode) {
    	if (head == null) {
    		head = newNode;
    	}
    	newNode.next = head;
    	head = newNode;
    }
    
    //顺序插入    
    //链表尾部插入    
    public void insertTail(int value) {
    	Node newNode = new Node(value, null);
    	if(head == null) {
    		head.next = newNode;
    	}
    	Node p = head;
    	while(p != null) {
    		p = p.next;
    	}
    	newNode.next = p.next;// 是否多余
    	p.next = newNode;
    	
    }
    
    public void insertAfter(Node p, int value) {
        Node newNode = new Node(value, null);
        insertAfter(p, newNode);
    }
    
    public void insertAfter(Node p, Node newNode) {
    	if(p == null)
    		return;

    	newNode.next = p.next;
    	p.next = newNode;
    }
    
    public void insertBefore(Node p, Node newNode) {
    	if(p == null)
    		return;
    	
    	if(p == head) {
    		insertToHead(newNode);
    		return;
    	}
    	
    	Node q = head;
    	while(q != null && q.next != p) {
    		q = q.next;
    	}
    	
    	 if (q == null) {
             return;
         }

         newNode.next = p;
         q.next = newNode;
    }
}
