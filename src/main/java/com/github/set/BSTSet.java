package com.github.set;

import com.github.tree.bst.BinarySearchTree;

/**
 * 基于二分搜索树实现集合（有序）
 * 
 * @author ZEALER
 * @date: 2019年1月28日
 */
public class BSTSet<E extends Comparable<E>> implements Set<E> {
	
	private BinarySearchTree<E> bst;
	
	public BSTSet() {
		this.bst = new BinarySearchTree<>();
	}

	/**
	 * 添加元素
	 */
	@Override
	public void add(E e) {
		bst.add(e);
	}

	/**
	 * 删除元素
	 */
	@Override
	public void remove(E e) {
		bst.remove(e);
	}

	/**
	 * 判断集合中是否包含元素e
	 */
	@Override
	public boolean contains(E e) {
		return bst.contains(e);
	}

	/**
	 * 获取集合中元素的个数
	 */
	@Override
	public int getSize() {
		return bst.size();
	}

	/**
	 * 判断集合是否为空
	 */
	@Override
	public boolean isEmpty() {
		return bst.isEmpty();
	}

}
