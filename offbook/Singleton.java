package com.algorithm.offer.book;

//单例模式
public class Singleton {

    private static Singleton singleton;

    private Singleton(){

    }

    /*1
    第一种常见方式
    这是一种最简单的单例模式
    但是当程序在多线程的环境下运行 就不是一个成功的单例模式
    当唯一的对象没有被创建出来的时候 有两个线程同时进行创建对象的操作
    这时这两个线程都没有检测到唯一的对象 就会常见两个对象从而违反单例模式
     */
    public static Singleton getInstance(){
        if (singleton == null) {
            singleton = new Singleton();
        }
        return singleton;
    }

    /*2
    解决第一种创建方式的多线程问题
    可以使用饿汉式的创建方式 在类加载的时候就实例化对象
    但是如果这个对象没有被使用过就会造成浪费 也可以使用静态代码块
     */
    static {
        singleton = new Singleton();
    }

    //3
    // 线程安全 但是如果有多个线程需要这个类的实例的时候 线程同步 效率低
    public static synchronized Singleton getInstance1(){
        if (singleton == null){
            singleton = new Singleton();
        }
        return singleton;
    }

    //4
    // 在getInstance1的情况进行改进 虽然效率高了 但是线程不安全
    public static Singleton getInstance2(){
        if (singleton == null){
            synchronized (Singleton.class){
                singleton = new Singleton();
            }
        }
        return singleton;
    }

    //5
    // 在getInstance2 进行改进 使用双重的判定 线程安全 效率高
    public static Singleton getInstance3(){
        if (singleton == null){
            synchronized (Singleton.class){
                if (singleton == null){
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }

    //6
    //在2的基础上进行改进 使用静态内部类 即使Student类加载 只要不调用getInstance4方法
    //就不会造成内存浪费
    private static class StudentInstance{
        private static Singleton student = new Singleton();
    }

    public static Singleton getInstance4(){
        return StudentInstance.student;
    }
}
