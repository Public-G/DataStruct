package com.github.queue;

/**
 * 队列接口
 * 
 * @author ZEALER
 * @date: 2019年1月19日
 */
public interface Queue<E> {

	int getSize();

	boolean isEmpty();

	void enqueue(E e);

	E dequeue();

	E getFront();
}
