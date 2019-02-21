package com.github.bst;

import com.github.tree.bst.BinarySearchTree;

public class BinarySearchTreeTest {

	public static void main(String[] args) {
		BinarySearchTree<Integer> bst = new BinarySearchTree<>();
	        int[] nums = {5, 3, 6, 8, 4, 2};
	        for(int num: nums)
	            bst.add(num);
	        
	        
        //////////////////
        //      5       //
        //    /   \     //
        //   3     6    //
        //  / \     \   //
        // 2   4     8  //
        //////////////////
        bst.preOrder();
        System.out.println("--------------------------华丽的分割线---------------------------");

        System.out.println(bst);
        
        bst.inOrder();
        System.out.println("--------------------------华丽的分割线---------------------------");

        bst.postOrder();
        System.out.println("--------------------------华丽的分割线---------------------------");
        
        bst.levelOrder();

	}

}
