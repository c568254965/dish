package com.huarui.something;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by sloan on 2019/9/16.
 * 队列先进先出...
 */
public class BlockQueueDemo {

    public static void main(String[] args) {


        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<String>(3);

        blockingQueue.add("1");
        blockingQueue.add("2");
        blockingQueue.add("3");


        // 返回第一个..
        String element = blockingQueue.element();
        System.out.println(element);
        String remove = blockingQueue.remove();
        System.out.println(remove);
        String element2 = blockingQueue.element();
        System.out.println(element2);

        LinkedBlockingQueue<String> linkedBlockingQueue = new LinkedBlockingQueue<>(3);
        //linkedBlockingQueue.offer("")

    }
}
