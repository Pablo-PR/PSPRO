package ejemploHiloSimple2;

public class UsaHilo {
    public static void main (String[] args){
        HiloSimple hs = new HiloSimple();
        hs.run();
        for (int i = 0; i < 5; i++) {
            System.out.println ("Fuera del hilo...");
        }
    }
}
