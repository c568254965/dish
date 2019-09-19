package com.huarui.something;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by sloan on 2019/9/16.
 *
 * AA打印5次，BB打印10次，CC打印15次
 */


class PrintIndex {
    private Integer index = 1;

    Lock lock = new ReentrantLock();

    Condition c1 = lock.newCondition();
    Condition c2 = lock.newCondition();
    Condition c3 = lock.newCondition();

    public void print5(){

        lock.lock();
        try {
            while (index != 1){

                c1.await();
            }
            for (int i = 0; i < 5; i++) {
                System.out.println("AA"+"    "+(i+1));
            }
            index = 2;
            c2.signal();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void print10(){

        lock.lock();
        try {
            while (index != 2){

                c2.await();
            }
            for (int i = 0; i < 10; i++) {
                System.out.println("BB"+"    "+(i+1));
            }
            index = 3;
            c3.signal();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }


    public void print15(){

        lock.lock();
        try {
            while (index != 3){

                c3.await();
            }
            for (int i = 0; i < 15; i++) {
                System.out.println("CC"+"    "+(i+1));
            }

            index = 1;
            c1.signal();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

}
public class LockDemo {
    public static void main(String[] args) {
        PrintIndex index = new PrintIndex();



            new Thread(()->{

                for (int i = 0;i<10;i++){
                    index.print5();

                }
            },"a").start();
            new Thread(()->{
                for (int i = 0;i<10;i++){
                    index.print10();

                }

            },"b").start();
            new Thread(()->{
                for (int i = 0;i<10;i++){
                    index.print15();

                }

            },"c").start();


    }
}

