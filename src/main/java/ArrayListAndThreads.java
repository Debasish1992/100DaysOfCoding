import java.util.ArrayList;

public class ArrayListAndThreads {
    ArrayList<String> myArray = new ArrayList<>();

    synchronized void addDataToArray(String data){
        myArray.add(data);
        System.out.println(Thread.currentThread().getName() + myArray.toString());
        //System.out.println(Thread.currentThread().getName());
    }
}

class mainClass{

    public static void main(String[] args) throws Exception {

        ArrayListAndThreads arrayListAndThreads = new ArrayListAndThreads();

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                arrayListAndThreads.addDataToArray("My Data " + i);
            }

        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                arrayListAndThreads.addDataToArray("My Data " + i);
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
    }
}
