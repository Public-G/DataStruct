package com.github.queue;

import com.github.tree.heap.MaxHeap;

/**
 * 基于最大堆实现优先级队列
 * Java中的PriorityQueue是基于最小堆实现的，大小是相对的，可以定义。
 * 
 * @author ZEALER
 * @date: 2019年1月29日
 */
public class PriorityQueue<E extends Comparable<E>> implements Queue<E> {
	
	private MaxHeap<E> maxHeap;

	/**
	 * 获取队列中元素的个数
	 */
	@Override
	public int getSize() {
		return maxHeap.size();
	}

	/**
	 * 判断队列是否为空
	 */
	@Override
	public boolean isEmpty() {
		return maxHeap.isEmpty();
	}

	/**
	 * 入队
	 * 
	 * @see MaxHeap
	 */
	@Override
	public void enqueue(E e) {
		maxHeap.add(e);
	}

	/**
	 * 出队
	 * 
	 * @see MaxHeap
	 */
	@Override
	public E dequeue() {
		return maxHeap.extractMax();
	}

	/**
	 * 查看队首元素
	 */
	@Override
	public E getFront() {
		return maxHeap.findMax();
	}

}
