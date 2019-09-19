package com.huarui.something;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by sloan on 2019/9/16.
 *
 * 总结：
 * 1. 多个线程
 * 2. 操作（方法） eg:increment sub
 * 3. 资源操作类   Data
 * 4. 判断  什么时候获得锁，什么时候操作
 * 5. 调用方法干活
 * 6. 通知..
 *
 * 7.防止虚假唤醒
 *
 */

class Data{

  private  Integer i = 0;

  private Lock lock = new ReentrantLock();

  private Condition condition =  lock.newCondition();

  public void increment() throws Exception {

      lock.lock();
      try {
          while ( i != 0){
              condition.await();
          }

          i++;
          System.out.println(Thread.currentThread().getName()+",add i:"+i);
          condition.signalAll();
      }catch (Exception e){
          e.printStackTrace();
      }finally {

          System.out.println("加法释放锁..");

          lock.unlock();

      }




  }

  public void sub()throws Exception{

      lock.lock();
        try{
            while (i == 0){
                condition.await();
            }
            i--;
            System.out.println(Thread.currentThread().getName()+",sub i:"+i);
            condition.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            System.out.println("减法释放锁..");
            lock.unlock();
        }


  }
}
public class ConsumerDemo {

    public static void main(String[] args)throws Exception {
        Data data = new Data();

        for (int i = 0; i < 10; i++) {
            new Thread(()->{

                try {
                    data.increment();
                } catch (Exception e) {
                    e.printStackTrace();
                }


            },"AAA").start();


            new Thread(()->{
                try {
                    data.sub();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            },"BBB").start();
        }
    }
}
