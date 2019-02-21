package com.github.tree.segment;

/**
 * 线段树 将线段树看成满二叉树，然后用数组来表示这个线段树，最后一层多余的元素使用null来表示
 * 
 * @author ZEALER
 * @date: 2019年2月3日
 */
public class SegmentTree<E> {

	private E[] tree;
	private E[] data;
	private Merger<E> merger;

	public SegmentTree(E[] arr, Merger<E> merger) {
		this.merger = merger;

		data = (E[]) new Object[arr.length];
		for (int i = 0; i < arr.length; i++) {
			data[i] = arr[i];
		}

		tree = (E[]) new Object[4 * arr.length];
		buildSegmentTree(0, 0, data.length - 1);
	}

	/**
	 * 在treeIndex的位置创建表示区间[l...r]的线段树
	 * 
	 * @param treeIndex
	 * @param l
	 * @param r
	 */
	private void buildSegmentTree(int treeIndex, int l, int r) {
		if (l == r) {
			tree[treeIndex] = data[l];
			return;
		}

		int leftTreeIndex = leftChild(treeIndex);
		int rightTreeIndex = rightChild(treeIndex);

		// int mid = (l + r) / 2;
		int mid = l + (r - l) / 2;
		buildSegmentTree(leftTreeIndex, l, mid);
		buildSegmentTree(rightTreeIndex, mid + 1, r);

		tree[treeIndex] = merger.merge(tree[leftTreeIndex], tree[rightTreeIndex]);
	}

	/**
	 * 获取元素个数
	 * 
	 * @return
	 */
	public int getSize() {
		return data.length;
	}

	/**
	 * 根据索引获取元素
	 * 
	 * @param index
	 * @return
	 */
	public E get(int index) {
		if (index < 0 || index >= data.length)
			throw new IllegalArgumentException("Index is illegal.");
		return data[index];
	}

	/**
	 * 返回区间[queryL, queryR]的值
	 * 
	 * @param queryL
	 * @param queryR
	 * @return
	 */
	public E query(int queryL, int queryR) {
		if (queryL < 0 || queryL >= data.length || queryR < 0 || queryR >= data.length || queryL > queryR)
			throw new IllegalArgumentException("Index is illegal.");

		return query(0, 0, data.length - 1, queryL, queryR);
	}
	
	/**
	 * 在以treeIndex为根的线段树中[l...r]的范围里，搜索区间[queryL...queryR]的值
	 * 
	 * @param treeIndex
	 * @param l
	 * @param r
	 * @param queryL
	 * @param queryR
	 * @return
	 */
	private E query(int treeIndex, int l, int r, int queryL, int queryR) {
		if (l == queryL && r == queryR) {
			return tree[treeIndex];
		}

		int mid = l + (r - l) / 2;
		// treeIndex的节点分为[l...mid]和[mid+1...r]两部分

		int leftTreeIndex = leftChild(treeIndex);
		int rightTreeIndex = rightChild(treeIndex);
		if (queryL >= mid + 1) // 在右子树
			return query(rightTreeIndex, mid + 1, r, queryL, queryR);
		else if (queryR <= mid) // 在左子树
			return query(leftTreeIndex, l, mid, queryL, queryR);

		// 左子树和右子树都有
		E leftResult = query(leftTreeIndex, l, mid, queryL, mid);
		E rightResult = query(rightTreeIndex, mid + 1, r, mid + 1, queryR);
		return merger.merge(leftResult, rightResult);
	}

	/**
	 * 将index位置的值，更新为e
	 * 
	 * @param index
	 * @param e
	 */
	public void set(int index, E e) {
		if (index < 0 || index >= data.length)
			throw new IllegalArgumentException("Index is illegal");

		data[index] = e;
		set(0, 0, data.length - 1, index, e);
	}

	/**
	 * 在以treeIndex为根的线段树中更新index的值为e
	 * 
	 * @param treeIndex
	 * @param l
	 * @param r
	 * @param index
	 * @param e
	 */
	private void set(int treeIndex, int l, int r, int index, E e) {
		if (l == r) {
			tree[treeIndex] = e;
			return;
		}
		
		int mid = l + (r - l) / 2;
		// treeIndex的节点分为[l...mid]和[mid+1...r]两部分
		
		int leftTreeIndex = leftChild(treeIndex);
		int rightTreeIndex = rightChild(treeIndex);
		if(index >= mid + 1)
            set(rightTreeIndex, mid + 1, r, index, e);
		else // index <= mid
			set(leftTreeIndex, l, mid, index, e);
		
		tree[treeIndex] = merger.merge(tree[leftTreeIndex], tree[rightTreeIndex]);

	}

	/**
	 * 返回完全二叉树的数组表示中，一个索引所表示的元素的右孩子节点的索引
	 * 
	 * @param index
	 * @return
	 */
	private int rightChild(int index) {
		return 2 * index + 2;
	}

	/**
	 * 返回完全二叉树的数组表示中，一个索引所表示的元素的左孩子节点的索引
	 * 
	 * @param treeIndex
	 * @return
	 */
	private int leftChild(int index) {
		return 2 * index + 1;
	}

	@Override
	public String toString() {
		StringBuilder res = new StringBuilder();
		res.append('[');
		for (int i = 0; i < tree.length; i++) {
			if (tree[i] != null)
				res.append(tree[i]);
			else
				res.append("null");

			if (i != tree.length - 1)
				res.append(", ");
		}
		res.append(']');
		return res.toString();
	}
}
