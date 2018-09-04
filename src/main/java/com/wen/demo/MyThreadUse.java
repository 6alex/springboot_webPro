package com.wen.demo;

/**
 * @author wencun
 * @date 2018年4月4日 下午5:34:16
 * @version 1.0
 * @since JDK 1.8
 */
public class MyThreadUse {
    public static void main(String[] args) {
        new Thread(new MyThread("线程0")).start();   
        new Thread(new MyThread("线程1")).start();   
        new Thread(new MyThread("线程2")).start();   
        new Thread(new MyThread("线程3")).start();   
        new Thread(new MyThread("线程4")).start();   
        new Thread(new MyThread("线程5")).start();   
        new Thread(new MyThread("线程6")).start();   
        new Thread(new MyThread("线程7")).start();   
        new Thread(new MyThread("线程8")).start();   
        new Thread(new MyThread("线程9")).start();   
        
        Thread t = new Thread(new MyThread("线程10"));
        t.start();
        System.out.println("主线程结束");
    }
}
