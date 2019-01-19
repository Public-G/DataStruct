package com.github.queue;

/**
 * 动态循环队列
 * 
 * @author ZEALER
 * @date: 2019年1月19日
 */
public class LoopQueue<E> implements Queue<E> {

	private E[] data;

	private int front, tail; // 队首、队尾指针

	private int size;

	public LoopQueue(int capacity) {
		data = (E[]) new Object[capacity + 1]; // 循环队列中有意浪费一个空间
		front = 0;
		tail = 0;
		size = 0;
	}

	public LoopQueue() {
		this(10);
	}

	/**
	 * 获取循环队列中元素的个数
	 */
	@Override
	public int getSize() {
		return this.size;
	}
	
	/**
	 * 获取循环队列容量
	 * @return
	 */
	public int getCapacity(){
        return this.data.length - 1;
    }


	/**
	 * 判断循环队列是否为空
	 */
	@Override
	public boolean isEmpty() {
		return this.front == this.tail;
	}

	/**
	 * 入队
	 */
	@Override
	public void enqueue(E e) {
		// 队列是否已满
		if ( (this.tail + 1) % this.data.length == this.front ) {
			resize(getCapacity() * 2);
		}
		
		this.data[this.tail] = e;
		this.tail = (this.tail + 1) % this.data.length; // 维护队尾指针
		this.size++;
	}

	/**
	 * 出队
	 */
	@Override
	public E dequeue() {
		if(isEmpty()) {
			throw new IllegalArgumentException("Cannot dequeue from an empty queue.");
		}
		
		E value = this.data[this.front];
		
		this.data[this.front] = null;
		this.front = (this.front + 1) % this.data.length; // 维护队首指针
		this.size--;
		
		if (this.size == (getCapacity() / 4) && (getCapacity() / 2) != 0) {
			resize(getCapacity() / 2);
		}
		
		return value;	
	}

	/**
	 * 查看队首元素
	 */
	@Override
	public E getFront() {
		 if(isEmpty()) {
			 throw new IllegalArgumentException("Queue is empty."); 
		 }
	            
		return this.data[this.front];
	}
	
	private void resize(int newCapacity) {
		E[] newData = (E[]) new Object[newCapacity + 1]; // 循环队列中浪费一个空间
		
		for (int i = 0; i < this.size; i++) {
			newData[i] = this.data[(this.front + i) % this.data.length];
		}
		
		this.data = newData;
		this.front = 0;
		this.tail = this.size;
	}
	
	 @Override
	    public String toString(){
	        StringBuilder res = new StringBuilder();
	        res.append(String.format("Queue: size = %d , capacity = %d\n", size, getCapacity()));
	        res.append("front [");
	        for(int i = front ; i != tail ; i = (i + 1) % data.length){
	            res.append(data[i]);
	            if((i + 1) % data.length != tail)
	                res.append(", ");
	        }
	        res.append("] tail");
	        return res.toString();
	    }

}
