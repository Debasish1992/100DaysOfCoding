public class StaticSynchronization  {
    Demo demoInterface;
    synchronized static void executeAmount(int amount){
        int calculatedAmount = 1;
        System.out.println(" Amount is " + amount);
        for (int i = 0; i < 10; i++) {
            calculatedAmount = amount * i;
            System.out.println("Calculated Amount " + calculatedAmount);
        }
    }


}

class myClass implements Demo {
    public static void main(String[] args) {
        new Thread(){
            @Override
            public void run() {
                StaticSynchronization.executeAmount(10);
            }
        }.start();
    }

    @Override
    public void getValueInActivity(int value) {

    }
}