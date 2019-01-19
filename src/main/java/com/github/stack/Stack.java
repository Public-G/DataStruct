package com.github.stack;

/**
 * 栈接口
 * 
 * @author ZEALER
 * @date: 2019年1月19日
 */
public interface Stack<E> {
	
	int getSize();
	
    boolean isEmpty();
    
    void push(E e);
    
    E pop();
    
    E peek();

}
