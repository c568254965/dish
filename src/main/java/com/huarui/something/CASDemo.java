package com.huarui.something;
import java.util.concurrent.atomic.AtomicInteger;
/**
 * Created by sloan on 2019/9/12.
 */
public class CASDemo {

    public static void main(String[] args) {
        AtomicInteger automicInteger = new AtomicInteger(5);

        //拿着自己工作内存的值去和主内存的值去比较，如果是一样的，就改成2019，并同步到主内存...
        //如果比较失败，就重新获得主内存的真实值..
        boolean b = automicInteger.compareAndSet(5, 2019);
        System.out.println(b+",value:"+automicInteger.get());
        boolean b1 = automicInteger.compareAndSet(5, 1024);
        System.out.println(b1+",value:"+automicInteger.get());

    }
}
