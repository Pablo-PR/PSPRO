package ejemploHiloSimple2;

public class HiloSimple implements Runnable {
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("En el Hilo...");
        }
    }
}