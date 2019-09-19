package com.huarui.something;

/**
 * Created by sloan on 2019/9/12.
 */


/**
 * 懒汉式  单例模式
 *
 * 用到的时候再去创建...

 */
public class Dog3 {

    //私有的构造方法，防止new
    private Dog3(){
        System.out.println("我是构造方法....");
    }





//    //* 线程不安全.. 单线程的时候才用
//    private static Dog3 dog;
//    public static Dog3 getInstance(){
//
//        //多个线程进来的时候，都走到了这个判断里面...就new了不止一个对象
//        if(dog == null){
//            dog = new Dog3();
//        }
//
//        return dog;
//
//    }

    public static void main(String[] args) {

//        for (int i = 0; i < 30; i++) {
//            new Thread(()->{
//                Dog3.getInstance();
//            },String.valueOf(i)).start();
//        }
    }
// =====================================
// =====================================
// =====================================
//       // * 线程安全..    同步方法
//    private static Dog3 dog;
//
//    public synchronized static Dog3 getInstance(){   //加了同步锁。。效率太低..
//
//        //多个线程进来的时候，都走到了这个判断里面...就new了不止一个对象
//        if(dog == null){
//            dog = new Dog3();
//        }
//
//        return dog;
//
//    }
// =====================================
// =====================================
// =====================================

    //       // * 线程安全..    同步方法
//    private static Dog3 dog;
//
//    public synchronized static Dog3 getInstance(){   //加了同步锁。。效率太低..
//
//        //多个线程进来的时候，都走到了这个判断里面...就new了不止一个对象
//        if(dog == null){
//            dog = new Dog3();
//        }
//
//        return dog;
//
//    }
// =====================================
// =====================================
// =====================================


    //同步代码块，线程不安全，不能用..
//    private static Dog3 dog;
//
//    public synchronized static Dog3 getInstance() {   //加了同步锁。。效率太低..
//        if (dog == null) {
//            //多个线程都走到这里....创建多个new Dog3()
//            synchronized (Dog3.class) {
//                    dog = new Dog3();
//            }
//        }
//        return dog;
//
//    }
    // * 线程安全..    同步代码   双重检查...
//    private static volatile Dog3 dog; //volatile 轻量级synchronized  对象更新立即更新到主存  禁止指令重排.
//
//    public  static Dog3 getInstance() {
//
//        //双重检查.... ==null
//        if (dog == null) {
//            synchronized (Dog3.class) {
//                if (dog == null) {
//                    dog = new Dog3();
//                }
//
//            }
//
//
//        }
//        return dog;
//
//    }
}
