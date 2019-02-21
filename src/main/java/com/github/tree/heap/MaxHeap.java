package com.github.tree.heap;

import com.github.array.Array;

/**
 * 基于动态数组实现最大堆（从下标0开始存储）
 * 
 * @author ZEALER
 * @date: 2019年1月29日
 */
public class MaxHeap<E extends Comparable<E>> {

	private Array<E> data;

	public MaxHeap(int capacity) {
		this.data = new Array<>(capacity);
	}

	public MaxHeap() {
		this.data = new Array<>();
	}
	
	/**
	 * 将传入的数组转换成最大堆（Heapify）
	 * 
	 * @param arr
	 */
	public MaxHeap(E[] arr) { 
		this.data = new Array<>(arr);
		 for(int i = parent(arr.length - 1) ; i >= 0 ; i --) { // parent(arr.length - 1)找到最后一个非叶子节点
			 siftDown(i);  
		 }
	}

	/**
	 * 返回堆中的元素个数
	 * 
	 * @return
	 */
	public int size() {
		return data.getSize();
	}

	/**
	 * 判断堆是否为空
	 * 
	 * @return
	 */
	public boolean isEmpty() {
		return data.isEmpty();
	}

	/**
	 * 返回完全二叉树的数组表示中，一个索引所表示的元素的父亲节点的索引
	 * 
	 * @param index
	 * @return
	 */
	private int parent(int index) {
		if (index == 0) {
			throw new IllegalArgumentException("index-0 doesn't have parent.");
		}

		if (index < 0) {
			throw new IllegalArgumentException("Parent failed. Require index > 0");
		}

		return (index - 1) / 2;
	}

	/**
	 * 返回完全二叉树的数组表示中，一个索引所表示的元素的左孩子节点的索引
	 * 
	 * @param index
	 * @return
	 */
	private int leftChild(int index) {
		if (index < 0) {
			throw new IllegalArgumentException("Parent failed. Require index >= 0");
		}

		return index * 2 + 1;
	}

	/**
	 * 返回完全二叉树的数组表示中，一个索引所表示的元素的右孩子节点的索引
	 * 
	 * @param index
	 * @return
	 */
	private int rightChild(int index) {
		if (index < 0) {
			throw new IllegalArgumentException("Parent failed. Require index >= 0");
		}

		return index * 2 + 2;
	}

	/**
	 * 向堆中添加元素
	 * 
	 * @param e
	 */
	public void add(E e) {
		data.addLast(e);
		siftUp(data.getSize() - 1);
	}

	/**
	 * 上浮
	 * 
	 * @param k
	 */
	private void siftUp(int k) {
		while (k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0) {
			data.swap(k, parent(k));
			k = parent(k);
		}
	}

	/**
	 * 查看堆中的最大元素
	 * 
	 * @return
	 */
	public E findMax() {
		if (data.getSize() == 0)
			throw new IllegalArgumentException("Can not findMax when heap is empty.");

		return data.getFirst();
	}

	/**
	 * 取出堆中最大元素
	 * 
	 * @return
	 */
	public E extractMax() {
		E ret = findMax();

		data.swap(0, data.getSize() - 1);
		data.removeLast();
		siftDown(0);

		return ret;
	}

	private void siftDown(int k) {
		while(leftChild(k) < data.getSize()) { // 左孩子一定要存在（右孩子不一定要存在），不然无法比较
			int j = leftChild(k); // 在此轮循环中,data[k]和data[j]交换位置
			if( j + 1 < data.getSize() &&
                    data.get(j + 1).compareTo(data.get(j)) > 0 ) // 右孩子存在且值比左孩子大
                j ++;
            // data[j] 是 leftChild 和 rightChild 中的最大值
			if(data.get(k).compareTo(data.get(j)) >= 0 ) // k节点已是最大值
                break;
			
			 data.swap(k, j);
	         k = j;
		}
	}
	
	/**
	 * 取出堆中的最大元素，并且替换成元素e
	 * 
	 * @param e
	 * @return
	 */
	public E replace(E e) {
		E ret = findMax();
		data.set(0, e);
		siftDown(0);
		
		return ret;
	}

}
