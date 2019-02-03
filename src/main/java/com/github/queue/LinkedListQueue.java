package com.github.queue;

/**
 * 基于链表实现队列
 * 
 * @author ZEALER
 * @date: 2019年1月23日
 */
public class LinkedListQueue<E> implements Queue<E> {
	
	private class Node {
			
			public E e;
			public Node next;
			
			public Node(E e, Node next) {
				this.e = e;
				this.next = next;
			}
			
			public Node(E e) {
				this(e, null);
			}
			
			public Node(){
	            this(null, null);
	        }
			
			@Override
	        public String toString(){
	            return e.toString();
	        }
		}
	
	private Node head; // 头节点，负责删除，作为队首 
	private Node tail; // 尾节点 ，负责添加，作为队尾
	private int size;
	
	public LinkedListQueue() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}

	@Override
	public int getSize() {
		return this.size;
	}

	@Override
	public boolean isEmpty() {
		return this.size == 0;
	}

	@Override
	public void enqueue(E e) {
		if (this.tail == null) {
			this.tail = new Node(e);
			this.head = this.tail;
		} else {
			this.tail.next = new Node(e);
			this.tail = this.tail.next;
		}
		
		this.size ++;
	}

	@Override
	public E dequeue() {
		if (isEmpty()) {
			throw new IllegalArgumentException("Cannot dequeue from an empty queue.");
		}
		
		Node retNode = this.head;
		this.head = this.head.next;
		retNode.next = null;
		if (this.head == null) { // 如果队列中只有一个元素，维护下tail
			this.tail = null;
		}
		
		this.size --;
		
		return retNode.e;
	}

	@Override
	public E getFront() {
		if (isEmpty()) {
			throw new IllegalArgumentException("Queue is empty.");
		}
		
		return this.head.e;
	}
	
	@Override
	public String toString() {
		StringBuilder res = new StringBuilder();
        res.append("LinkedList Queue: ");
        res.append("front [");
        
        Node cur = this.head;
        while (cur != null) {
        	res.append(cur + "->");
        	cur = cur.next;
        }
        res.append("NULL] tail");
        return res.toString();
	}

}
