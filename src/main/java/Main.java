public class Main {

    public static void main(String[] args) throws Exception {
        Counter counter = new Counter();
        Thread thread1 = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                counter.increment();
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                counter.increment();
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
        System.out.println("Count " + counter.count);
    }

    static class Counter {
        int count;

        public synchronized void increment() {
            count += 1;
            System.out.println("Count in function" + count);
        }
    }
}