public class ThreadingAgain {
    Demo demoInterface = (Demo) this;
    int count  = 0;
    public void incrementCount(){
        count += 1;
        System.out.println("The counter Thread" + Thread.currentThread().getId() + " " + count);
        demoInterface.getValueInActivity(30);
    }
}

class NewThread extends Thread {

    public void run(){
        for (int i = 1; i <= 5; i++) {
            System.out.println("This is inside thread class "+ i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class incrementCounter implements Demo{
    public static void main(String[] args) throws Exception{
        ThreadingAgain threadingAgain = new ThreadingAgain();
        NewThread newThread = new NewThread();

        Thread threadOne = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                threadingAgain.incrementCount();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread threadTwo = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                threadingAgain.incrementCount();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        threadOne.start();
        threadTwo.start();
        newThread.run();

        threadOne.join();
        threadTwo.join();
        newThread.join();
        System.out.println("The counter" + threadingAgain.count);
    }

    @Override
    public void getValueInActivity(int value) {
        System.out.println(value);
    }
}
