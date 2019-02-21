package com.github.tree;

import java.util.Random;

import com.github.tree.uf.UF;
import com.github.tree.uf.UnionFindFive;
import com.github.tree.uf.UnionFindFour;
import com.github.tree.uf.UnionFindSix;
import com.github.tree.uf.UnionFindThree;

public class UFTest {
	
	private static double testUF(UF uf, int m){

        int size = uf.getSize();
        Random random = new Random();

        long startTime = System.nanoTime();


        for(int i = 0 ; i < m ; i ++){
            int a = random.nextInt(size);
            int b = random.nextInt(size);
            uf.unionElements(a, b);
        }

        for(int i = 0 ; i < m ; i ++){
            int a = random.nextInt(size);
            int b = random.nextInt(size);
            uf.isConnected(a, b);
        }

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }
	
	public static void main(String[] args) {
		// UnionFindOne 慢于 UnionFindTwo
//      int size = 100000;
//      int m = 10000;

        // UnionFindTwo 慢于 UnionFindOne, 但UnionFindThree明显最快
//      int size = 100000;
//      int m = 100000;
		
		// UnionFindThree 和 UnionFindFour 相差无几。UnionFindSix 因为使用递归，比 UnionFindFive差一点
		// UnionFindThree : 10.213835281 s
		// UnionFindFour : 10.41084643 s
		// UnionFindFive : 6.886087694 s
		// UnionFindSix : 6.728840059 s
		int size = 10000000;
	    int m = 10000000;

//      UF uf1 = new UnionFindOne(size);
//      System.out.println("UnionFindOne : " + testUF(uf1, m) + " s");
//
//      UF uf2 = new UnionFindTwo(size);
//      System.out.println("UnionFindTwo : " + testUF(uf2, m) + " s");

      UF uf3 = new UnionFindThree(size);
      System.out.println("UnionFindThree : " + testUF(uf3, m) + " s");
      
      UF uf4 = new UnionFindFour(size);
      System.out.println("UnionFindFour : " + testUF(uf4, m) + " s");
      
      UF uf5 = new UnionFindFive(size);
      System.out.println("UnionFindFive : " + testUF(uf5, m) + " s");
      
      UF uf6 = new UnionFindSix(size);
      System.out.println("UnionFindSix : " + testUF(uf6, m) + " s");
	}

}
