package com.github.tree;

import java.util.ArrayList;

import com.github.common.FileOperation;
import com.github.tree.avl.AVLTree;

public class AVLTest {
	
	public static void main(String[] args){
		 System.out.println("Pride and Prejudice");

	        ArrayList<String> words = new ArrayList<>();
	        if(FileOperation.readFile("./src/main/resources/pride-and-prejudice.txt", words)) {
	            System.out.println("Total words: " + words.size());

	            AVLTree<String, Integer> map = new AVLTree<>();
	            for (String word : words) {
	                if (map.contains(word))
	                    map.set(word, map.get(word) + 1);
	                else
	                    map.add(word, 1);
	            }

	            System.out.println("Total different words: " + map.getSize());
	            System.out.println("Frequency of PRIDE: " + map.get("pride"));
	            System.out.println("Frequency of PREJUDICE: " + map.get("prejudice"));

	            System.out.println("is BST : " + map.isBST());
	            System.out.println("is Balanced : " + map.isBalanced());
	            
//	            for(String word: words){
//	                map.remove(word);
//	                if(!map.isBST() || !map.isBalanced())
//	                    throw new RuntimeException("ERROR");
//	            }
	        }
	        
	        System.out.println();
    }

}
