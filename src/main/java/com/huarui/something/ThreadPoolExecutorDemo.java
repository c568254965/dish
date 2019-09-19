package com.huarui.something;

import java.util.concurrent.*;

/**
 * Created by sloan on 2019/9/19.
 */
public class ThreadPoolExecutorDemo {

    public static void main(String[] args) {

        ExecutorService executorService =
                new ThreadPoolExecutor(
                        2, 5, 1L, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(3),
                        Executors.defaultThreadFactory(), new ThreadPoolExecutor.DiscardPolicy());


        try {
            for (int i = 1; i < 100; i++) {


                executorService.execute(() -> {

                    System.out.println(Thread.currentThread().getName() + "~~");
                });

            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            executorService.shutdown();

        }


    }
}
/*

拒绝策略：
AbortPolicy  直接报错。
CallerRunsPolicy  回退到调用者    pool-1-thread-5~~
                                main~~
DiscardOldestPolicy  抛弃队列中等待最久的任务，把当前任务加入队列尝试再次提交
DiscardPolicy  直接抛弃，不处理也不跑出异常

 */