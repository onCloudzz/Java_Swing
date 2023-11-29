public class BackPackThread implements Runnable {
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
                System.out.println("BackPackThread");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


