package com.huarui.something;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * Created by sloan on 2019/9/16.
 * 信号灯
 *
 * 争车位
 */
public class SemaphoreDemo {


    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);  //3个停车位...

        for (int i = 1; i < 7 ; i++) {  //6辆车..

            new Thread(()->{
                try {

                    semaphore.acquire();
                    System.out.println("第"+Thread.currentThread().getName()+"辆车进来了!!!");
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println("第"+Thread.currentThread().getName()+"辆车又走了~~~");
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    semaphore.release();
                }
            },i+"").start();

        }
    }

}

/**

 第1辆车进来了...
 第3辆车进来了...
 第2辆车进来了...
 第1辆车又走了...
 第2辆车又走了...
 第3辆车又走了...
 第5辆车进来了...
 第4辆车进来了...
 第6辆车进来了...
 第5辆车又走了...
 第6辆车又走了...
 第4辆车又走了...
 */