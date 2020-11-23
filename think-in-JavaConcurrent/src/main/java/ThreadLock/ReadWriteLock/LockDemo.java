package ThreadLock.ReadWriteLock;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

public class LockDemo {

    public static int count = 0;

    static synchronized void addCount() {
        Lock writeLock = Locker.INSTANCE.writeLock();
        writeLock.lock();
        count++;
        //释放锁
        writeLock.unlock();
    }

    public static void main(String[] args) {
        ExecutorService executorService = new ThreadPoolExecutor(10, 1000,
                60L, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(10));

        for (int i = 0; i < 1000; i++) {
            Runnable r = new Runnable() {
                @Override
                public void run() {
                    LockDemo.addCount();
                }
            };
            executorService.execute(r);
        }
        executorService.shutdown();
        System.out.println(LockDemo.count);
    }
}
