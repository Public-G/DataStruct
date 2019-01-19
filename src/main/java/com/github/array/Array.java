package com.github.array;

/**
 * 封装数组（动态数组）
 * 
 * @author ZEALER
 * @date: 2019年1月18日
 */
public class Array<E> {

	private E[] data;

	private int size;

	/**
	 * 构造函数，传入数组的容量capacity构造Array
	 * 
	 * @param capacity
	 */
	public Array(int capacity) {
		this.data = (E[]) new Object[capacity];
		this.size = 0;
	}

	/**
	 * 无参数的构造函数，默认数组的容量capacity=10
	 */
	public Array() {
		this(10);
	}

	/**
	 * 在index索引的位置插入一个新元素e
	 * 
	 * @param index
	 * @param e
	 */
	public void add(int index, E e) {
		if (index < 0 || index > this.size) {
			throw new IllegalArgumentException("Add failed. Require index >= 0 and index <= size.");
		}

		// 数组满时进行扩容
		if (this.size == this.data.length) {
			resize(this.data.length * 2);
		}

		// index之后的元素往后移动一位
		for (int i = this.size - 1; i > index; i--) {
			this.data[i + 1] = this.data[i];
		}

		this.data[index] = e;

		this.size++;
	}

	/**
	 * 在所有元素前添加一个新元素
	 * 
	 * @param e
	 */
	public void addFirst(E e) {
		add(0, e);
	}

	/**
	 * 向所有元素后添加一个新元素
	 * 
	 * @param e
	 */
	public void addLast(E e) {
		add(this.size, e);
	}

	/**
	 * 查找数组中是否有元素e
	 * 
	 * @param e
	 * @return
	 */
	public boolean contains(E e) {
		for (int i = 0; i < this.size; i++) {
			if (this.data[i].equals(e)) {
				return true;
			}
		}

		return false;
	}

	/**
	 * 查找数组中元素e所在的索引，如果不存在元素e，则返回-1
	 * 
	 * @param e
	 * @return
	 */
	public int find(E e) {
		for (int i = 0; i < this.size; i++) {
			if (this.data[i].equals(e)) {
				return i;
			}
		}

		return -1;
	}

	/**
	 * 获取index索引位置的元素
	 * 
	 * @param index
	 * @return
	 */
	public E get(int index) {
		if (index < 0 || index >= this.size) {
			throw new IllegalArgumentException("Get failed. Index is illegal.");
		}

		return this.data[index];
	}

	/**
	 * 获取第一个元素
	 * 
	 * @return
	 */
	public E getFirst() {
		return get(0);
	}

	/**
	 * 获取最后一个元素
	 * 
	 * @return
	 */
	public E getLast() {
		return get(this.size - 1);
	}

	/**
	 * 获取数组的容量
	 * 
	 * @return
	 */
	public int getCapacity() {
		return this.data.length;
	}

	/**
	 * 获取数组中的元素个数
	 * 
	 * @return
	 */
	public int getSize() {
		return this.size;
	}

	/**
	 * 返回数组是否为空
	 * 
	 * @return
	 */
	public boolean isEmpty() {
		return this.size == 0;
	}

	/**
	 * 从数组中删除index位置的元素, 返回删除的元素
	 * 
	 * @param index
	 * @return
	 */
	public E remove(int index) {
		if (index < 0 || index >= this.size) {
			throw new IllegalArgumentException("Remove failed. Index is illegal.");
		}

		E value = this.data[index];

		// index之后的元素向前移动一位
		for (int i = index + 1; i < this.size; i++) {
			this.data[i - 1] = this.data[i];
		}

		this.size--;
		this.data[size] = null; // 加快垃圾回收

		// 数组中的元素为数组长度的 1/4，且数组长度不为1时进行缩容
		if (this.size == (this.data.length / 4) && (data.length / 2) != 0) { // 防止复杂度的震荡（在临界值（数组已满）处添加元素后又删除元素）
			resize(this.data.length / 2);
		}

		return value;
	}

	/**
	 * 从数组中删除元素e
	 * 
	 * @param e
	 */
	public void removeElement(E e) {
		int index = find(e);
		if (index != -1) {
			remove(index);
		}
	}

	/**
	 * 从数组中删除第一个元素, 返回删除的元素
	 * 
	 * @return
	 */
	public E removeFirst() {
		return remove(0);
	}

	/**
	 * 从数组中删除最后一个元素, 返回删除的元素
	 * 
	 * @return
	 */
	public E removeLast() {
		return remove(this.size - 1);
	}

	/**
	 * 修改index索引位置的元素为e
	 * 
	 * @param index
	 * @param e
	 */
	public void set(int index, E e) {
		if (index < 0 || index >= this.size) {
			throw new IllegalArgumentException("Set failed. Index is illegal.");
		}

		this.data[index] = e;
	}

	/**
	 * 将数组空间的容量变成newCapacity大小
	 * 
	 * @param newCapacity
	 */
	private void resize(int newCapacity) {
		E[] newData = (E[]) new Object[newCapacity];

		for (int i = 0; i < this.size; i++) {
			newData[i] = this.data[i];
		}

		this.data = newData;
	}

	@Override
	public String toString() {
		StringBuilder res = new StringBuilder();
		res.append(String.format("Array: size = %d , capacity = %d\n", this.size, this.data.length));
		res.append('[');
		for (int i = 0; i < this.size; i++) {
			res.append(this.data[i]);
			if (i != this.size - 1) {
				res.append(", ");
			}

		}
		res.append(']');
		return res.toString();
	}

}
