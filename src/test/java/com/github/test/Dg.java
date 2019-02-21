package com.github.test;

/**
 * 假如这里有n个台阶，每次你可以跨1个台阶或者2个台阶，请问走这n个台阶有多少种走法？
 * 如果有7个台阶，你可以2，2，2，1这样子上去，也可以1，2，1，1，2这样子上去，总之走法有很多，那如何用编程求得总共有多少种走法呢？
 * 
 * @author ZEALER
 * @date: 2019年1月26日
 */
public class Dg {

	public static void main(String[] args) {
		int result = function(40);	
		System.out.println("result = " + result); // result = 165580141
		
		int result2 = function2(40);	
		System.out.println("result2 = " + result2); // result2 = 165580141
	}

	// 递归实现
	private static int function(int n) {
		return (n == 1 || n == 2) ? n : function(n - 1) + function(n - 2);
//		if (n == 1)
//			return 1;
//		
//		if (n == 2)
//			return 2;
//		
//		// n-1个台阶的走法 + n-2个台阶的走法
//		return function(n - 1) + function(n - 2);
	}
	
	// 非递归实现
	private static int function2(int n) { 
		if (n == 1)
			return 1;
		
		if (n == 2)
			return 2;
		
		int ret = 0;
		
		int prepre = 1;
		int pre = 2; 
		
		/**
		 * 	  f2	
		 * 	 /
		 * f4
		 *   \	/f1
		 *    f3
		 *    	\f2
		 */
		for (int i = 3; i <= n; i++) {
			ret = prepre + pre; // f(n) = f(n - 1) + f(n - 2)
			
			// 1 		2 		3 	5 	8 	13 		... 	有点类似斐波那契数列
			// prepre	pre
			//			prepre	pre
			// 						...   ...
			prepre = pre;
			pre = ret;  
		}
		
		return ret;
	}

}
