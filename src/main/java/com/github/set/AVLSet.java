package com.github.set;

import com.github.tree.avl.AVLTree;

/**
 * 基于 AVL 树实现集合
 * 
 * @author ZEALER
 * @date: 2019年2月11日
 */
public class AVLSet<E extends Comparable<E>> implements Set<E> {
	
	private AVLTree<E, Object> avl;
	
	public AVLSet() {
		avl = new AVLTree<>();
	}

	@Override
	public void add(E e) {
		avl.add(e, null);
	}

	@Override
	public void remove(E e) {
		avl.remove(e);
	}

	@Override
	public boolean contains(E e) {
		return avl.contains(e);
	}

	@Override
	public int getSize() {
		return avl.getSize();
	}

	@Override
	public boolean isEmpty() {
		return avl.isEmpty();
	}

}
