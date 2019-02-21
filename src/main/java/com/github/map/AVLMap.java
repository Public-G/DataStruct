package com.github.map;

import com.github.tree.avl.AVLTree;

/**
 * 基于 AVL 树实现映射
 * 
 * @author ZEALER
 * @date: 2019年2月11日
 */
public class AVLMap<K extends Comparable<K>, V> implements Map<K, V> {

	private AVLTree<K, V> avl;

	public AVLMap() {
		avl = new AVLTree<>();
	}

	@Override
	public void add(K key, V value) {
		avl.add(key, value);
	}

	@Override
	public V remove(K key) {
		return avl.remove(key);
	}

	@Override
	public boolean contains(K key) {
		return avl.contains(key);
	}

	@Override
	public V get(K key) {
		return avl.get(key);
	}

	@Override
	public void set(K key, V value) {
		avl.set(key, value);
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