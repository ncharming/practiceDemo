package Thread;

public class InterruptDemo {
    public static void main(String[] args) {
        //sleepThread睡眠1000ms
        final Thread sleepThread = new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                super.run();
            }
        };

        //busyThread一直执行死循环
        Thread busyThread = new Thread() {
            @Override
            public void run() {
                while (true) ;
            }
        };

        sleepThread.start();
        busyThread.start();
        sleepThread.interrupt();
        busyThread.interrupt();
        while (sleepThread.isInterrupted()) ;
        /**
         * 线程进入阻塞状态后，调用 interrupt()，中断标志设为 true。表示可以线程可以中断了，但是具体中断还是继续运行由线程自己决定
         *
         */
        System.out.println("sleepThread isInterrupted: " + sleepThread.isInterrupted());//false

        System.out.println("busyThread isInterrupted: " + busyThread.isInterrupted());
    }
}
