package com.github.queue;

import com.github.array.Array;

/**
 * 基于动态数组实现队列
 * 
 * @author ZEALER
 * @date: 2019年1月19日
 */
public class ArrayQueue<E> implements Queue<E> {
	
	private Array<E> array;
	
	public ArrayQueue(int capacity) {
		this.array = new Array<>(capacity);
	}
	
	public ArrayQueue() {
		this.array = new Array<>();
	}

	/**
	 * 获取队列中元素的个数
	 */
	@Override
	public int getSize() {
		return array.getSize();
	}

	/**
	 * 判断队列是否为空
	 */
	@Override
	public boolean isEmpty() {
		return array.isEmpty();
	}
	
	/**
	 * 获取队列容量
	 * @return
	 */
	public int getCapacity(){
        return array.getCapacity();
    }

	/**
	 * 入队
	 */
	@Override
	public void enqueue(E e) {
		array.addLast(e);
	}

	/**
	 * 出队
	 */
	@Override
	public E dequeue() {
		return array.removeFirst();
	}

	/**
	 * 查看队首元素
	 */
	@Override
	public E getFront() {
		return array.getFirst();
	}
	
	@Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("Queue: ");
        res.append("front [");
        for(int i = 0 ; i < array.getSize() ; i ++){
            res.append(array.get(i));
            if(i != array.getSize() - 1)
                res.append(", ");
        }
        res.append("] tail");
        return res.toString();
    }

}
