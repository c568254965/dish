package com.huarui.something;

import java.util.concurrent.TimeUnit;

/**
 * Created by sloan on 2019/9/12.
 */

class MyData{

    volatile int  i = 0;
    public void changeID(){
        i = 60;
        System.out.println("i 的值已经变化.."+i);
    }
        }

public class VolatileDemo {




    public static void main(String[] args) {

         MyData myData = new MyData();

         //第一个线程...
        new Thread(
                ()->{
                    System.out.println(Thread.currentThread().getName()+" come in ");
                    try {
                        TimeUnit.SECONDS.sleep(3);
                        myData.changeID();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+" change data ");

                },"AAA"
        ).start();


        //第二个线程...
        while (myData.i == 0){

            //main线程一直等待
            System.out.println("i:"+myData.i);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName()+"  over.......");

    }
}
