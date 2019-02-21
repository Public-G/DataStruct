package com.github.tree.trie;

import java.util.TreeMap;

/**
 * Trie树
 * 
 * @author ZEALER
 * @date: 2019年2月9日
 */
public class Trie {

	private class Node {
		public boolean isEndingChar;
		public TreeMap<Character, Node> next;

		public Node(boolean isEndingChar) {
			this.isEndingChar = isEndingChar;
			next = new TreeMap<>();
		}

		public Node() {
			this(false);
		}
	}

	private Node root;
	private int size;

	public Trie() {
		root = new Node();
		size = 0;
	}

	/**
	 * 获得Trie中存储的单词数量
	 * 
	 * @return
	 */
	public int getSize() {
		return size;
	}
	
	/**
	 * 向Trie中添加一个新的单词word
	 * 
	 * @param word
	 */
	public void add(String word) {
		Node cur = root;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if(cur.next.get(c) == null)
                cur.next.put(c, new Node());
			cur = cur.next.get(c);
		}
		
		if (!cur.isEndingChar) {
			cur.isEndingChar = true;
			size ++;
		}
	}
	
	/**
	 * 查询单词word是否在Trie中
	 * 
	 * @param word
	 * @return
	 */
	public boolean contains(String word) {
		Node cur = root;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if(cur.next.get(c) == null)
                return false;
			cur = cur.next.get(c);
		}
		
		return cur.isEndingChar;
	}
	
	/**
	 * 查询是否在Trie中有单词以prefix为前缀
	 * 
	 * @param prefix
	 * @return
	 */
	public boolean isPrefix(String prefix) { 
		Node cur = root;
		for (int i = 0; i < prefix.length(); i++) {
			char c = prefix.charAt(i);
			if(cur.next.get(c) == null)
                return false;
			cur = cur.next.get(c);
		}
		
		return true;
	}
}
