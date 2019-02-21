package com.github.map;

/**
 * 基于二分搜索树实现映射（有序）
 * 
 * @author ZEALER
 * @date: 2019年1月28日
 */
public class BSTMap<K extends Comparable<K>, V> implements Map<K, V> {

	private class Node {
		public K key;
		public V value;
		public Node left, right;

		public Node(K key, V value) {
			this.key = key;
			this.value = value;
			this.left = null;
			this.right = null;
		}
	}

	private Node root;
	private int size;

	/**
	 * 返回以node为根节点的二分搜索树中, key所在的节点
	 * 
	 * @param node
	 * @param key
	 * @return
	 */
	private Node getNode(Node node, K key) {
		if (node == null) {
			return null;
		}

		if (key.compareTo(node.key) == 0) {
			return node;
		} else if (key.compareTo(node.key) < 0) {
			return getNode(node.left, key);
		} else { // key.compareTo(node.key) > 0
			return getNode(node.right, key);
		}
	}

	/**
	 * 添加元素
	 */
	@Override
	public void add(K key, V value) {
		root = add(root, key, value);
	}

	/**
	 * 向以node为根的二分搜索树中插入元素(key, value)，递归算法 返回插入新节点后二分搜索树的根
	 * 
	 * @param node
	 * @param e
	 * @return
	 */
	private Node add(Node node, K key, V value) {
		if (node == null) {
			this.size++;
			return new Node(key, value);
		}

		if (key.compareTo(node.key) < 0) {
			node.left = add(node.left, key, value);
		} else if (key.compareTo(node.key) > 0) {
			node.right = add(node.right, key, value);
		} else { // (key.compareTo(node.key) == 0
			node.value = value;
		}

		return node;
	}

	/**
	 * 删除元素
	 */
	@Override
	public V remove(K key) {
		Node node = getNode(root, key);

		if (node != null) {
			root = remove(root, key);
			return node.value;
		}
		return null;
	}
	
	/**
	 * 删除掉以node为根的二分搜索树中键为key的节点, 递归算法 返回删除节点后新的二分搜索树的根
	 * 
	 * @param node
	 * @param key
	 * @return
	 */
	private Node remove(Node node, K key) {
		if (node == null) {
			return null;
		}
		
		if (key.compareTo(node.key) < 0) {
			node.left = remove(node.left, key);
			return node;
		} else if (key.compareTo(node.key) > 0) {
			node.right = remove(node.right, key);
			return node;
		} else { // key.compareTo(node.key) == 0
			
			// 待删除节点左子树为空的情况
			if (node.left == null) {
				Node rightNode = node.right; // 右节点可以为空
				node.right = null;
				size--;
				return rightNode;
			}

			// 待删除节点右子树为空的情况
			if (node.right == null) {
				Node leftNode = node.left; // 左节点可以为空
				node.left = null;
				size--;
				return leftNode;
			}

			// 待删除节点左右子树均不为空的情况

			// 找到比待删除节点大的最小节点, 即待删除节点右子树的最小节点（或者找到比待删除节点小的最大节点, 即待删除节点左子树的最大节点）
			// 用这个节点顶替待删除节点的位置
			Node successor = minimum(node.right);

			successor.right = removeMin(node.right);
			this.size++;
			successor.left = node.left;

			node.left = node.right = null;
			this.size--;
			
			return successor;
		}
	}
	
	/**
	 * 返回以node为根的二分搜索树的最小值所在的节点
	 * 
	 * @param node
	 * @return
	 */
	private Node minimum(Node node) {
		if (node.left == null) {
			return node;
		}

		return minimum(node.left);
	}
	
	/**
	 * 删除掉以node为根的二分搜索树中的最小节点 返回删除节点后新的二分搜索树的根
	 * 
	 * @param node
	 * @return
	 */
	private Node removeMin(Node node) {
		if (node.left == null) {
			Node rightNode = node.right;
			node.right = null;
			this.size--;
			return rightNode; // 要删除的node的右子树作为node父节点的左子树
		}

		node.left = removeMin(node.left);
		return node;
	}
	
	/**
	 * 判断映射中是否包含指定key
	 */
	@Override
	public boolean contains(K key) {
		return getNode(root, key) != null;
	}

	/**
	 * 根据key获取元素的value
	 */
	@Override
	public V get(K key) {
		Node node = getNode(root, key);
		return node == null ? null : node.value;
	}

	/**
	 * 修改映射
	 */
	@Override
	public void set(K key, V newValue) {
		Node node = getNode(root, key);
		
		if (node == null) {
			throw new IllegalArgumentException(key + "doesn't exist!");
		}
		
		node.value = newValue;
	}

	/**
	 * 获取映射中元素的个数
	 */
	@Override
	public int getSize() {
		return this.size;
	}

	/**
	 * 判断映射是否为空
	 */
	@Override
	public boolean isEmpty() {
		return this.size == 0;
	}

}
