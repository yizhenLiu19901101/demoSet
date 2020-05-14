package interview;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CountDownLatchTest {
    // 运动员数量
    private static int SPORTSMAN_COUNT = 5;
    // 成绩单
    private static List<Sportsman> transcript = new ArrayList<>(SPORTSMAN_COUNT);

    private static final Random random = new Random();

    //计数器，用于判断发令之前运动员是否已经进⼊入准备状态，需要等待5个运动员准备就绪，占有锁，等待5个运动员完成，释放锁。
    private static CountDownLatch readyLatch = new CountDownLatch(SPORTSMAN_COUNT);

    // 计数器，⽤用于判断裁判是否已经发令，占有锁，等待裁判发令完成，释放锁
    private static CountDownLatch startLatch = new CountDownLatch(1);

    // 计数器，设置终点屏障，⽤用于计算成绩，需要所有线程都到达，然后继续执行
    private static CyclicBarrier cb = new CyclicBarrier(SPORTSMAN_COUNT, new Runnable() {
        @Override
        public void run() {
            // 给成绩到数组排序
            CountDownLatchTest.transcript.sort((Sportsman p1, Sportsman p2) -> p1.getTranscript() - p2.getTranscript());
            System.out.println("排名成绩单：" + CountDownLatchTest.transcript);
            // 清掉对象
            CountDownLatchTest.transcript.clear();
        }
    });

    /**
     * 主方法
     * @param args
     */
    public static void main(String[] args) {
        //用于判断发令之前运动员是否已经进⼊准备状态，需要等待10个运动员准备就绪，占有锁，等待10 个运动员完成，释放锁。
        // CountDownLatch readyLatch = new CountDownLatch(SPORTSMAN_COUNT);
        // ⽤用于判断裁判是否已经发令，占有锁，等待裁判发令完成，释放锁
        // CountDownLatch startLatch = new CountDownLatch(1);
        // 启动10个线程，也就是10个运动员，做准备⼯工作
        ExecutorService es = Executors.newFixedThreadPool(SPORTSMAN_COUNT);
        for (int i = 0; i < SPORTSMAN_COUNT; i++) {
            RunTask task = new RunTask(( i+ 1) + "号运动员", readyLatch, startLatch);
            es.submit(task);
        }
        // 当前运动员在其他运动员准备就绪前⼀一直等待，也就是说等readyLatch倒数计数器器为0之前⼀一直等待
        try {
            readyLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //裁判发令，释放锁
        startLatch.countDown();
        System.out.println("裁判：所有运动员准备完毕，开始跑...");
    }

    /**运动员类*/
    static class Sportsman {
        private String name;
        private int transcript;

        public Sportsman(String name, int transcript) {
            this.name = name;
            this.transcript = transcript;
        }

        @Override
        public boolean equals(Object obj) {
            boolean result = false;
            if (obj instanceof Sportsman) {
                result = ((Sportsman) obj).getTranscript() == this.transcript;
            }
            return result;
        }

        @Override
        public String toString() {
            return this.name + ":" + this.transcript + " ms";
        }
        public String getName() {
            return name;
        }
        public int getTranscript() {
            return transcript;
        }
    }
    /**
    /**
     * 跑任务类
     */
    static class RunTask implements Runnable {
        // 独占锁
        private Lock lock = new ReentrantLock();
        private CountDownLatch ready;
        private CountDownLatch start;
        private String name;
        /**
         * (构造⽅方法)
         * @param ready
         * @param start
         * @param name  运动员名称
         */
        public RunTask(String name, CountDownLatch ready, CountDownLatch start) {
            this.ready = ready;
            this.start = start;
            this.name = name;
        }

        @Override
        public void run() {
            lock.lock();
            try {
                // 运动员准备就绪的逻辑,准备readyTime秒
                int readyTime = random.nextInt(1000);
                System.out.println(name + ":我需要" + readyTime + "秒的时间准备。");
                try {
                    Thread.sleep(readyTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(name + "我已经准备完毕！");
                // 释放锁readyLatch-1，表示⼀一个运动员已经就绪
                ready.countDown();
                //待裁判发开始命令
                try{
                    start.await();
                } catch (InterruptedException e) {
                }
                System.out.println(name + "：开跑...");
                int costTime = random.nextInt(500);
                try {
                    Thread.sleep(costTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(name + "：开跑到达终点。成绩:" + costTime + "ms");
                transcript.add(new Sportsman(name, costTime));
                // 等待成绩
                cb.await();
            } catch(Exception e) {
            } finally {
                lock.unlock();
            }
        }
    }
}