public class InterThreadComm {


    int totalAmount;

    InterThreadComm (int totalAmountLeft){
        this.totalAmount = totalAmountLeft;
    }

    synchronized void spendAmount(int requestedAmount) throws InterruptedException {
        System.out.println("Going to spent this amount");

        if (requestedAmount > this.totalAmount) {
            wait();
        }


        if (totalAmount > requestedAmount) {
            this.totalAmount -= requestedAmount;
            System.out.println("WithDraw Completed");
        }else{
            System.out.println("You still do not have sufficient balance for withdraw");
        }
    }

    synchronized void depositAmount() {
        totalAmount += + totalAmount;
        System.out.println("Deposite Completed");
        notify();
    }
}

class ManageWithdraws {
    public static void main(String[] args) {
        InterThreadComm interThreadComm = new InterThreadComm(1000);

        new Thread(){
            @Override
            public void run() {
                try {
                    interThreadComm.spendAmount(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                interThreadComm.depositAmount();
            }
        }.start();

    }
}
