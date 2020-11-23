package Thread;

public class JoinDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread previousThread = Thread.currentThread();
        for (int i = 1; i <= 10; i++) {
            Thread curThead = new JoinThread(previousThread);
            curThead.start();
            previousThread = curThead;
        }
    }

    static class JoinThread extends Thread {
        private Thread thread;

        public JoinThread(Thread thread) {
            this.thread = thread;
        }

        @Override
        public void run() {
            try {
                /**
                 * 本次打印会按照顺序打印
                 * 即：每个线程都会前一个线程运行结束才会运行
                 */
                thread.join();
                Thread.sleep(1000);
                System.out.println(thread.getName() + "terminated.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
