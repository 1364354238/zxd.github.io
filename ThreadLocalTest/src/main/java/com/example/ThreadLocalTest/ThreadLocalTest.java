package com.example.ThreadLocalTest;

import java.util.Hashtable;
import java.util.Map;
import java.util.Random;

/**
 * @author dzx
 * @date 2021/10/16 -11:54
 */
public class ThreadLocalTest {
    public static Map<String, Object> data = new Hashtable<>();
    //    T用ThreadLocal存数据
    public static ThreadLocal<Object> threadLocal = new ThreadLocal<>();
    private static Random random = new Random();

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            new Thread(new Task()).start();

        }
    }

    public static class Task implements Runnable{
        @Override
        public void run() {
//           s随机生成一个变量，保存到ThreadLocal
            int num = random.nextInt(1000);
//            获取当前线程名
            String name=Thread.currentThread().getName();
            System.out.println(name+"-------"+num);
            data.put(name, num);
            threadLocal.set(num);
            try {
                Thread.sleep(2000);
            }catch (Exception e){
                e.printStackTrace();
            }
//          在run方法结束前，以当前线程名获取出数据并打印
            System.out.println(data.get(name) + "-----" + name);
//            ThreadLocal打印
            System.out.println("ThreadLocal:"+threadLocal.get()+"----------"+name);

        }
    }
}
