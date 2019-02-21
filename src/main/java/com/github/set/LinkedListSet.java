package com.github.set;

import com.github.linked.LinkedList;

/**
 * 基于链表实现集合（无序）
 * 
 * @author ZEALER
 * @date: 2019年1月28日
 */
public class LinkedListSet<E> implements Set<E> {
	
	private LinkedList<E> list;
	
	public LinkedListSet() {
		this.list = new LinkedList<>();
	}

	/**
	 * 添加元素
	 */
	@Override
	public void add(E e) {
		if (!list.contains(e)) {
			list.addFirst(e); // 向链表头添加元素，时间复杂度为O(1)（因为有虚拟头节点 / 哨兵）
		}
	}

	/**
	 * 删除元素
	 */
	@Override
	public void remove(E e) {
		list.removeElement(e);
	}

	/**
	 * 判断集合中是否包含元素e
	 */
	@Override
	public boolean contains(E e) {
		return list.contains(e);
	}

	/**
	 * 获取集合中元素的个数
	 */
	@Override
	public int getSize() {
		return list.getSize();
	}

	/**
	 * 判断集合是否为空
	 */
	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

}
