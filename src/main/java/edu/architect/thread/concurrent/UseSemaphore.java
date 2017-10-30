package edu.architect.thread.concurrent;

import java.util.concurrent.ExecutorService;  
import java.util.concurrent.Executors;  
import java.util.concurrent.Semaphore;  

/**
 * Semaphore（信号量）是用来控制同时访问特定资源的线程数量，它通过协调各个线程，以
 * 保证合理的使用公共资源.
 * 多年以来，我都觉得从字面上很难理解Semaphore所表达的含义，只能把它比作是控制流
 * 量的红绿灯。比如××马路要限制流量，只允许同时有一百辆车在这条路上行使，其他的都必须
 * 在路口等待，所以前一百辆车会看到绿灯，可以开进这条马路，后面的车会看到红灯，不能驶
 * 入××马路，但是如果前一百辆中有5辆车已经离开了××马路，那么后面就允许有5辆车驶入马
 * 路，这个例子里说的车就是线程，驶入马路就表示线程在执行，离开马路就表示线程执行完
 * 成，看见红灯就表示线程被阻塞，不能执行。
 * @author Frey Zhi
 *
 */
public class UseSemaphore {  
	  
    public static void main(String[] args) {  
        // 线程池  
        ExecutorService exec = Executors.newCachedThreadPool();  
        // 只能5个线程同时访问  
        final Semaphore semp = new Semaphore(5);  
        // 模拟20个客户端访问  
        for (int index = 0; index < 20; index++) {  
            final int NO = index;  
            Runnable run = new Runnable() {  
                public void run() {  
                    try {  
                        // 获取许可  
                        semp.acquire();  
                        System.out.println("Accessing: " + NO);  
                        //模拟实际业务逻辑
                        Thread.sleep((long) (Math.random() * 10000));  
                        // 访问完后，释放  
                        semp.release();  
                    } catch (InterruptedException e) {  
                    }  
                }  
            };  
            exec.execute(run);  
        } 
        
        try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        
        //System.out.println(semp.getQueueLength());
        
        
        
        // 退出线程池  
        exec.shutdown();  
    }  
  
}  