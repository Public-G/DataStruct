package com.github.leetcode;

import java.util.Stack;

/**
 * leetcode第20题
 * 
 * @author ZEALER
 * @date: 2019年1月19日
 */
public class Solution20 {
	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();
		
		for (int i = 0; i < s.length(); i++) {
			Character charAt = s.charAt(i);
			if ('(' == charAt || '[' == charAt || '{' == charAt) {
				stack.push(charAt);
			} else {
				if (stack.isEmpty()) {
					return false;
				}
				
				Character pop = stack.pop();
				if (')' == charAt && '(' != pop) {
					return false;
				}
				
				if (']' == charAt && '[' != pop) {
					return false;
				}
				
				if ('}' == charAt && '{' != pop) {
					return false;
				}
			}
		}
		
		return stack.isEmpty();
	}
}
