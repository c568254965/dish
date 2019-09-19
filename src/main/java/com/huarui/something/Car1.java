package com.huarui.something;

/**
 * Created by sloan on 2019/9/11.
 */

/**
 * 饿汉的单例模式   静态常量
 * 用类加载机制避免了多线程的同步问题，没有达到懒加载的效果.造成内存浪费
 */
public class Car1 {

    private Car1(){}

    private final   static Car1 car = new Car1();

    public static Car1 getInstance(){
        return car;

    }

}
