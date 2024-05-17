package other;

public class ThreadSafetyExample {
    private static int count = 0;
    public static void main(String[] args) {
        Counter06 counter06 = new Counter06();
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                counter06.increase();
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                counter06.increase();
            }
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final count: " + Counter06.count);
    }
}

class Counter06 {
    public static int count = 0;
    //自定义一个锁对象

    public void increase() {
        synchronized (String.class) {
            count++;
        }
    }
}
