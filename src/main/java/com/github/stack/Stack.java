package com.github.stack;

/**
 * 栈接口
 * 
 * @author ZEALER
 * @date: 2019年1月19日
 */
public interface Stack<E> {
	
	/**
	 * 获取栈中元素的个数
	 * 
	 * @return
	 */
	int getSize();
	
	/**
	 * 判断栈是否为空
	 * 
	 * @return
	 */
    boolean isEmpty();
    
    /**
     * 入栈
     * 
     * @param e
     */
    void push(E e);
    
    /**
     * 出栈
     * 
     * @return
     */
    E pop();
    
    /**
     * 查看栈顶元素
     * 
     * @return
     */
    E peek();

}
