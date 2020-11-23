package Thread;

import java.util.concurrent.*;

public class CreateThreadDemo {
    public static void main(String[] args) {
        Thread thread = new Thread() {
            @Override
            public void run() {
                super.run();
                System.out.println("Thread 启动一个线程");
            }
        };
        thread.start();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Runable 启动一个线程");
            }
        });
        thread1.start();


        /**
         * Excutors 加上 Callable 可以启动一个线程，且有返回值；上面两个没有返回值
         */
        ExecutorService service= Executors.newSingleThreadExecutor();
        Future<String> future=service.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "Callable 启动一个线程";
            }
        });
        try {
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


    }
}
