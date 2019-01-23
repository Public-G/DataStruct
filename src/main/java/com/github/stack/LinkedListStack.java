package com.github.stack;

import com.github.linked.LinkedList;

/**
 * 基于链表实现栈
 * 
 * @author ZEALER
 * @date: 2019年1月23日
 */
public class LinkedListStack<E> implements Stack<E> {
	
	private LinkedList<E> list;
	
	public LinkedListStack() {
		list = new LinkedList<>();
	}

	/**
	 * 获取栈中元素个数
	 */
	@Override
	public int getSize() {
		return list.getSize();
	}

	/**
	 * 判断栈是否为空
	 */
	@Override
	public boolean isEmpty() {
		return getSize() == 0;
	}

	/**
	 * 入栈
	 */
	@Override
	public void push(E e) {
		list.addFirst(e);
	}

	/**
	 * 出栈
	 */
	@Override
	public E pop() {
		return list.removeFirst();
	}

	/**
	 * 查看栈顶元素
	 */
	@Override
	public E peek() {
		return list.getFirst();
	}
	
	@Override
	public String toString() {
		StringBuilder res = new StringBuilder();
		res.append("LinkedList Stack: ");
		res.append('[');
		res.append(list);
		res.append("] top");
		return res.toString();
	}

}
