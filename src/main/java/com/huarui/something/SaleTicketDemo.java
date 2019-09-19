package com.huarui.something;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by sloan on 2019/9/18.
 */

class Ticket{

    private AtomicInteger num = new AtomicInteger(10);
    Lock lock = new ReentrantLock();


    Condition c1 = lock.newCondition();
    public void sale(){

        lock.lock();
        try {

            if (num.get() != 0){
                System.out.println(Thread.currentThread().getName()+"号售票员正在售票...票数："+num.get());
                num.getAndDecrement();
                System.out.println(Thread.currentThread().getName()+"号售票员售票结束~~~票数："+num.get());
            }else {


                System.out.println("票已售完..." + Thread.currentThread().getName() + "号售票员卖不出去了...");
                TimeUnit.SECONDS.sleep(1);
                System.out.println("开始补票....");

                this.addTicket();
                this.sale();
            }


        }catch (Exception e){
            e.printStackTrace();
        }finally {

            lock.unlock();
        }
    }

    public void  addTicket(){

        lock.lock();

        try {

            if(num.get()==0){
                num.compareAndSet(0,10);
                System.out.println("补票成功，新增了10张票..继续售卖...");
            }


        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

    }

}

class MyThread implements Runnable{

    @Override
    public void run() {

    }
}
public class SaleTicketDemo {


    public static void main(String[] args) throws InterruptedException {

//        new Thread(new MyThread(),"").start();

        Ticket ticket = new Ticket();

        for (int i = 1; i <= 100; i++) {

            new Thread(()->{

                ticket.sale();
            },i+"").start();
        }
 //       TimeUnit.SECONDS.sleep(3);
//        ticket.addTicket();
//


//        for (int i = 1; i <= 10; i++) {
//
//            new Thread(()->{
//
//                ticket.sale();
//            },"新"+i+"").start();
//        }
    }


}
