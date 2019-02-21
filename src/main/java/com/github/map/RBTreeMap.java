package com.github.map;

import com.github.tree.avl.AVLTree;
import com.github.tree.rb.RBTree;

/**
 * 基于红黑树实现映射
 * 
 * @author ZEALER
 * @date: 2019年2月14日
 */
public class RBTreeMap<K extends Comparable<K>, V> implements Map<K, V> {

	private RBTree<K, V> rb;

	public RBTreeMap() {
		rb = new RBTree<>();
	}

	@Override
	public void add(K key, V value) {
		rb.add(key, value);
	}

	@Override
	public V remove(K key) {
		return rb.remove(key);
	}

	@Override
	public boolean contains(K key) {
		return rb.contains(key);
	}

	@Override
	public V get(K key) {
		return rb.get(key);
	}

	@Override
	public void set(K key, V value) {
		rb.set(key, value);
	}

	@Override
	public int getSize() {
		return rb.getSize();
	}

	@Override
	public boolean isEmpty() {
		return rb.isEmpty();
	}
}
