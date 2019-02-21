package com.github.map;

import java.util.ArrayList;

import com.github.common.FileOperation;
import com.github.tree.rb.RBTree;

public class MapComparable {
	private static double testMap(Map<String, Integer> map, String filename){

        long startTime = System.nanoTime();

        System.out.println(filename);
        ArrayList<String> words = new ArrayList<>();
        if(FileOperation.readFile(filename, words)) {
            System.out.println("Total words: " + words.size());

            for (String word : words){
                if(map.contains(word))
                    map.set(word, map.get(word) + 1);
                else
                    map.add(word, 1);
            }

            System.out.println("Total different words: " + map.getSize());
            System.out.println("Frequency of PRIDE: " + map.get("pride"));
            System.out.println("Frequency of PREJUDICE: " + map.get("prejudice"));
        }

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }
	
	public static void main(String[] args) {

        String filename = "./src/main/resources/pride-and-prejudice.txt";

        BSTMap<String, Integer> bstMap = new BSTMap<>();
        double time1 = testMap(bstMap, filename);
        System.out.println("BST Map: " + time1 + " s"); // BST Map: 0.306420524 s

        System.out.println();

        LinkedListMap<String, Integer> linkedListMap = new LinkedListMap<>();
        double time2 = testMap(linkedListMap, filename);
        System.out.println("Linked List Map: " + time2 + " s"); // Linked List Map: 20.752163955 s
        
        System.out.println();
        
        AVLMap<String, Integer> avlMap = new AVLMap<>();
        double time3 = testMap(avlMap, filename);
        System.out.println("AVL Map: " + time3 + " s"); // AVL Map: 0.136653895 s
        
        System.out.println();
        
        RBTreeMap<String, Integer> rbMap = new RBTreeMap<>();
        double time4 = testMap(rbMap, filename);
        System.out.println("RBTree Map: " + time4 + " s"); // RBTree Map: 0.116367108 s
    }

}
