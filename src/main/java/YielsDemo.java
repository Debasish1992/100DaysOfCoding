class YielsDemo extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            // Control passes to child thread
            Thread.yield();
            System.out.println(Thread.currentThread().getName()
                    + " in control");
        }
    }

}

class myThreader {
    public static void main(String[] args) {
        YielsDemo thread = new YielsDemo();
        thread.start();

        for (int i=0; i<5; i++) {
            // After execution of child Thread
            // main thread takes over
            System.out.println(Thread.currentThread().getName()
                    + " in control inside main");
        }
    }
}
