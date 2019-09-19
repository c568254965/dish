package com.huarui.something;

import com.mysql.jdbc.TimeUtil;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 *
 * ReadWriteLock
 * 读写锁..
 * Created by sloan on 2019/9/16.
 */
public class CacheLockDemo {

    private volatile HashMap<String,String> map = new HashMap<>();

    //private Lock lock = new ReentrantLock();
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    private String get(String key){

        lock.readLock().lock();
        //lock.lock();
        try {
            System.out.println(
                    Thread.currentThread().getName()+"获取："+key
            );
            TimeUnit.MILLISECONDS.sleep(300);


            String result = map.get(key);
            System.out.println(Thread.currentThread().getName()+"result:"+result);

            return result;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.readLock().lock();
           // lock.unlock();
        }
return null;
    };

    private void put(String key,String value){

        lock.writeLock().lock();
        //lock.lock();
        try {
            System.out.println(Thread.currentThread().getName()+"正在插入:"+key+",值："+value);

            TimeUnit.MILLISECONDS.sleep(300);
            map.put(key,value);
            System.out.println(Thread.currentThread().getName()+"插入完成:");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.writeLock().unlock();
           // lock.unlock();

        }

    }


    public static void main(String[] args) {
        CacheLockDemo demo = new CacheLockDemo();


        for (int i = 0; i < 5; i++) {

            final int index = i;
            new Thread(()->{
                demo.put(index+"",index+"");
            },i+"").start();
        }


        for (int i = 0; i < 5; i++) {

            final int index = i;
            new Thread(()->{
                demo.get(index+"");
            },i+"").start();
        }


    }

}
/**

 ReadWriteLock:

 0正在插入:0,值：0
 0插入完成:
 1正在插入:1,值：1
 1插入完成:
 2正在插入:2,值：2
 2插入完成:
 3正在插入:3,值：3
 3插入完成:
 4正在插入:4,值：4
 4插入完成:
 0获取：0
 1获取：1
 2获取：2
 4获取：4
 3获取：3
 0result:0
 1result:1
 2result:2
 4result:4
 3result:3

 ReentrantLock:

 0正在插入:0,值：0
 0插入完成:
 1正在插入:1,值：1
 1插入完成:
 2正在插入:2,值：2
 2插入完成:
 3正在插入:3,值：3
 3插入完成:
 4正在插入:4,值：4
 4插入完成:
 0获取：0
 0result:0
 1获取：1
 1result:1
 2获取：2
 2result:2
 3获取：3
 3result:3
 4获取：4
 4result:4




 0正在插入:0,值：0
 0获取：0
 1获取：1
 2获取：2
 3获取：3
 4获取：4
 0插入完成:
 1result:null
 2result:null
 4result:null
 1正在插入:1,值：1
 0result:0
 3result:null
 1插入完成:
 2正在插入:2,值：2
 2插入完成:
 3正在插入:3,值：3
 3插入完成:
 4正在插入:4,值：4
 4插入完成:


 不用ReentrantLock
 原因：ReentrantLock的粒度太大..不能支持读锁，读可以多个线程同时读.一致性得到保证，不过效率太低
 */