package com.github.stack;

import com.github.array.Array;

/**
 * 基于动态数组实现栈
 * 
 * @author ZEALER
 * @date: 2019年1月19日
 */
public class ArrayStack<E> implements Stack<E> {

	private Array<E> array;

	public ArrayStack(int capacity) {
		this.array = new Array<>(capacity);
	}

	public ArrayStack() {
		this.array = new Array<>();
	}

	/**
	 * 获取栈中元素个数
	 */
	@Override
	public int getSize() {
		return array.getSize();
	}

	/**
	 * 判断栈是否为空
	 */
	@Override
	public boolean isEmpty() {
		return array.isEmpty();
	}

	/**
	 * 入栈
	 */
	@Override
	public void push(E e) {
		array.addLast(e);
	}

	/**
	 * 出栈
	 */
	@Override
	public E pop() {
		return array.removeLast();
	}

	/**
	 * 查看栈顶元素
	 */
	@Override
	public E peek() {
		return array.getLast();
	}

	@Override
	public String toString() {
		StringBuilder res = new StringBuilder();
		res.append("Array Stack: ");
		res.append('[');
		for (int i = 0; i < array.getSize(); i++) {
			res.append(array.get(i));
			if (i != array.getSize() - 1)
				res.append(", ");
		}
		res.append("] top");
		return res.toString();
	}
}
