package com.github.map;

/**
 * 基于链表实现映射（无序）
 * 
 * @author ZEALER
 * @date: 2019年1月28日
 */
public class LinkedListMap<K, V> implements Map<K, V> {
	
	private class Node {
		public K key;
		public V value;
		public Node next;
		
		public Node(K key, V value, Node next) {
			this.key = key;
			this.value = value;
			this.next = next;
		}
		
		public Node(K key) {
			this(key, null, null);
		}
		
		public Node(){
            this(null, null, null);
        }
		
		@Override
        public String toString(){
            return key.toString() + " : " + value.toString();
        }
	}
	
	// 虚拟头节点（哨兵，解决的是国家之间的边界问题。同理，这里说的哨兵也是解决“边界问题”的，不直接参与业务逻辑。）
	private Node dummyHead; 
    private int size;
    
    public LinkedListMap() {
    	this.dummyHead = new Node();
    	this.size = 0;
    }
    
    private Node getNode(K key) {
    	Node cur = dummyHead.next;
    	
    	while (cur != null) {
    		if (cur.key.equals(key)) {
    			return cur;
    		}
    		cur = cur.next;
    	}
    	
    	return null;
    }

    /**
     * 添加元素
     */
	@Override
	public void add(K key, V value) {
		Node node = getNode(key);
		
		if (node == null) {
			dummyHead.next = new Node(key, value, dummyHead.next); 
	    	this.size ++;
		} else {
			node.value = value;
		}
	}

	/**
	 * 删除元素
	 */
	@Override
	public V remove(K key) {
		Node prev = dummyHead;
		while (prev.next != null) { // 找到要删除的元素的前一个节点
			if (prev.next.key.equals(key)) {
				break;
			}
			prev = prev.next;
		}
		
		if (prev.next != null) {
			Node delNode = prev.next;
			prev.next = delNode.next;
			delNode.next = null;
			this.size --;
			return delNode.value;
		}
		
		return null;
	}

	/**
	 * 判断是否包含元素
	 */
	@Override
	public boolean contains(K key) {
		return getNode(key) != null;
	}

	/**
	 * 获取元素
	 */
	@Override
	public V get(K key) {
		Node node = getNode(key);
		return node == null ? null : node.value;
	}

	/**
	 * 修改元素
	 */
	@Override
	public void set(K key, V value) {
		Node node = getNode(key);
		
		if (node == null) {
			throw new IllegalArgumentException(key + "doesn't exist!");
		}
		
		node.value = value;
	}

	@Override
	public int getSize() {
		return this.size;
	}

	@Override
	public boolean isEmpty() {
		return this.size == 0;
	}

}
