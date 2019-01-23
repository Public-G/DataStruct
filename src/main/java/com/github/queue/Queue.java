package com.github.queue;

/**
 * 队列接口
 * 
 * @author ZEALER
 * @date: 2019年1月19日
 */
public interface Queue<E> {

	/**
	 * 获取队列中元素的个数
	 * 
	 * @return
	 */
	int getSize();

	/**
	 * 判断栈是否为空
	 * 
	 * @return
	 */
	boolean isEmpty();

	/**
	 * 入队
	 * 
	 * @param e
	 */
	void enqueue(E e);

	/**
	 * 出队
	 * 
	 * @return
	 */
	E dequeue();

	/**
	 * 查看队首元素
	 * 
	 * @return
	 */
	E getFront();
}
