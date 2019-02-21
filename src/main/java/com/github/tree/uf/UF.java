package com.github.tree.uf;

/**
 * 并查集接口
 * 
 * @author ZEALER
 * @date: 2019年2月9日
 */
public interface UF {
	
	/**
	 * 并查集一共考虑多少个元素
	 * 
	 * @return
	 */
	int getSize();
	
	/**
	 * 两个元素是否属于一个集合（是否可以连接）
	 * 
	 * @param p
	 * @param q
	 * @return
	 */
	boolean isConnected(int p, int q);
	
	/**
	 * 将两个元素合并在一个集合中
	 * 
	 * @param p
	 * @param q
	 */
	void unionElements(int p, int q);

}
