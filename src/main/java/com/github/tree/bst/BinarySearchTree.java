package com.github.tree.bst;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 二分搜索树
 * 
 * @author ZEALER
 * @date: 2019年1月28日
 */
public class BinarySearchTree<E extends Comparable<E>> {

	private class Node {
		public E e;
		public Node left, right;

		public Node(E e) {
			this.e = e;
			this.left = null;
			this.right = null;
		}
	}

	private Node root;
	private int size;

	public BinarySearchTree() {
		this.root = null;
		this.size = 0;
	}

	/**
	 * 获取树的节点个数
	 * 
	 * @return
	 */
	public int size() {
		return this.size;
	}

	/**
	 * 判断树是否为空
	 * 
	 * @return
	 */
	public boolean isEmpty() {
		return this.size == 0;
	}

	/**
	 * 添加元素
	 * 
	 * @param e
	 */
	public void add(E e) {
		root = add(root, e);
	}

	/**
	 * 向以node为根的二分搜索树中插入元素e，递归算法 返回插入新节点后二分搜索树的根
	 * 
	 * @param node
	 * @param e
	 * @return
	 */
	private Node add(Node node, E e) {
		if (node == null) {
			this.size++;
			return new Node(e);
		}

		if (e.compareTo(node.e) < 0) {
			node.left = add(node.left, e);
		} else if (e.compareTo(node.e) > 0) {
			node.right = add(node.right, e);
		}

		return node;
	}

	/**
	 * 判断是否包含元素e
	 * 
	 * @param e
	 * @return
	 */
	public boolean contains(E e) {
		return contains(root, e);
	}

	/**
	 * 看以node为根的二分搜索树中是否包含元素e, 递归算法
	 * 
	 * @param node
	 * @param e
	 * @return
	 */
	private boolean contains(Node node, E e) {
		if (node == null) {
			return false;
		}

		if (e.compareTo(node.e) == 0) {
			return true;
		} else if (e.compareTo(node.e) < 0) {
			return contains(node.left, e);
		} else { // e.compareTo(node.e) > 0
			return contains(node.right, e);
		}
	}

	/**
	 * 二分搜索树的前序遍历
	 */
	public void preOrder() {
		preOrder(root);
	}

	/**
	 * 二分搜索树的非递归前序遍历
	 */
	public void preOrderNR() {
		if (root == null) {
			return;
		}

		Stack<Node> stack = new Stack<>();
		stack.push(root);

		while (!stack.isEmpty()) {
			Node cur = stack.pop();
			System.out.println(cur.e);

			// 因为栈后入先出的特点，分别将右子树和左子树压入栈
			if (cur.right != null)
				stack.push(cur.right);
			if (cur.left != null)
				stack.push(cur.left);
		}
	}

	/**
	 * 前序遍历以node为根的二分搜索树, 递归算法
	 * 
	 * @param node
	 */
	private void preOrder(Node node) {
		if (node == null)
			return;

		// 遍历节点
		System.out.println(node.e);

		// 遍历左子树
		preOrder(node.left);

		// 遍历右子树
		preOrder(node.right);
	}

	/**
	 * 二分搜索树的中序遍历
	 */
	public void inOrder() {
		inOrder(root);
	}

	/**
	 * 中序遍历以node为根的二分搜索树, 递归算法
	 * 
	 * @param node
	 */
	private void inOrder(Node node) {
		if (node == null)
			return;

		inOrder(node.left);
		System.out.println(node.e);
		inOrder(node.right);
	}

	/**
	 * 二分搜索树的后序遍历
	 */
	public void postOrder() {
		postOrder(root);
	}

	/**
	 * 后序遍历以node为根的二分搜索树, 递归算法
	 * 
	 * @param node
	 */
	private void postOrder(Node node) {
		if (node == null)
			return;

		postOrder(node.left);
		postOrder(node.right);
		System.out.println(node.e);
	}

	/**
	 * 二分搜索树的层序遍历
	 */
	public void levelOrder() {
		if (root == null)
			return;

		Queue<BinarySearchTree<E>.Node> q = new LinkedList<>(); // 使用链表实现的队列
		q.add(root);

		while (!q.isEmpty()) {
			BinarySearchTree<E>.Node cur = q.poll();
			System.out.println(cur.e);

			if (cur.left != null) {
				q.add(cur.left);
			}
			if (cur.right != null) {
				q.add(cur.right);
			}
		}
	}

	/**
	 * 寻找二分搜索树的最小元素
	 * 
	 * @return
	 */
	public E minimum() {
		if (size == 0)
			throw new IllegalArgumentException("BST is empty");

		Node minNode = minimum(root);
		return minNode.e;
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
	 * 寻找二分搜索树的最大元素
	 * 
	 * @return
	 */
	public E maximum() {
		if (size == 0)
			throw new IllegalArgumentException("BST is empty");

		Node maxNode = maximum(root);
		return maxNode.e;
	}

	/**
	 * 返回以node为根的二分搜索树的最大值所在的节点
	 * 
	 * @param node
	 * @return
	 */
	private Node maximum(Node node) {
		if (node.right == null) {
			return node;
		}

		return maximum(node.right);
	}

	/**
	 * 从二分搜索树中删除最小值所在节点, 返回最小值
	 */
	public E removeMin() {
		E ret = minimum();
		root = removeMin(root);
		return ret;
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
	 * 从二分搜索树中删除最大值所在节点, 返回最大值
	 * 
	 * @return
	 */
	public E removeMax() {
		E ret = maximum();
		root = removeMax(root);
		return ret;
	}

	/**
	 * 删除掉以node为根的二分搜索树中的最大节点 返回删除节点后新的二分搜索树的根
	 * 
	 * @param node
	 * @return
	 */
	private Node removeMax(Node node) {
		if (node.right == null) {
			Node leftNode = node.left;
			node.left = null;
			this.size--;
			return leftNode; // 要删除的node的右子树作为node父节点的右子树
		}

		node.right = removeMin(node.right);
		return node;
	}

	/**
	 * 从二分搜索树中删除元素为e的节点
	 * 
	 * @param e
	 */
	public void remove(E e) {
		root = remove(root, e);
	}

	/**
	 * 删除掉以node为根的二分搜索树中值为e的节点, 递归算法 返回删除节点后新的二分搜索树的根
	 * 
	 * @param node
	 * @param e
	 * @return
	 */
	private Node remove(Node node, E e) {
		if (node == null)
			return null;

		if (e.compareTo(node.e) < 0) {
			node.left = remove(node.left, e);
			return node;
		} else if (e.compareTo(node.e) > 0) {
			node.right = remove(node.right, e);
			return node;
		} else { // node.e.compareTo(e) == 0
			
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

	@Override
	public String toString() {
		StringBuilder res = new StringBuilder();
		generateBSTString(root, 0, res);
		return res.toString();
	}

	/**
	 * 生成以node为根节点，深度为depth的描述二叉树的字符串
	 * 
	 * @param node
	 * @param depth
	 * @param res
	 */
	private void generateBSTString(Node node, int depth, StringBuilder res) {
		if (node == null) {
			res.append(generateDepthString(depth) + "null\n");
			return;
		}

		res.append(generateDepthString(depth) + node.e + "\n");
		generateBSTString(node.left, depth + 1, res);
		generateBSTString(node.right, depth + 1, res);

	};

	/**
	 * --表示深度
	 * 
	 * @param depth
	 * @return
	 */
	private String generateDepthString(int depth) {
		StringBuilder res = new StringBuilder();
		for (int i = 0; i < depth; i++)
			res.append("--");
		return res.toString();
	}

}
