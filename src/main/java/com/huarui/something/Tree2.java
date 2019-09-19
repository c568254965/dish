package com.huarui.something;

/**
 * Created by sloan on 2019/9/11.
 */

/**
 * 饿汉的单例模式..
 *
 * 静态代码块
 *
 */
public class Tree2 {

    private Tree2(){}

    public static Tree2 tree;

    static{
        tree = new Tree2();

    }
    public static Tree2 getInstance(){
        return tree;
    }


}
