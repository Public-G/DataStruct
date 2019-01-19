package com.github.queue;

import java.util.Random;

public class QueueTest {
	
	/**
	 * 测试使用q运行opCount个enqueueu和dequeue操作所需要的时间，单位：秒
	 * @param q
	 * @param opCount
	 * @return
	 */
    private static double testQueue(Queue<Integer> q, int opCount){

        long startTime = System.nanoTime();

        Random random = new Random();
        for(int i = 0 ; i < opCount ; i ++) {
        	q.enqueue(random.nextInt(Integer.MAX_VALUE));
        } 
        for(int i = 0 ; i < opCount ; i ++) {
        	q.dequeue();
        }

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }
	
	public static void main(String[] args) {
		// 测试1
//		ArrayQueue<Integer> queue = new ArrayQueue<>();
//        for(int i = 0 ; i < 10 ; i ++){
//            queue.enqueue(i);
//            System.out.println(queue);
//            if(i % 3 == 2){
//                queue.dequeue();
//                System.out.println(queue);
//            }
//        }
		
		// 测试2
//		LoopQueue<Integer> queue = new LoopQueue<>(5);
//        for(int i = 0 ; i < 10 ; i ++){
//            queue.enqueue(i);
//            System.out.println(queue);
//
//            if(i % 3 == 2){
//                queue.dequeue();
//                System.out.println(queue);
//            }
//        }
		
		int opCount = 1000000;

        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        double time1 = testQueue(arrayQueue, opCount);
        System.out.println("ArrayQueue, time: " + time1 + " s"); // ArrayQueue, time: 608.414003465 s

        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        double time2 = testQueue(loopQueue, opCount);
        System.out.println("LoopQueue, time: " + time2 + " s"); // LoopQueue, time: 0.118408817 s
	}

}
