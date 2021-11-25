package ejemploHiloSimple1;

public class ejemploHiloSimple {
    public static void main(String[] args) {
        HiloSimple hs = new HiloSimple();
        System.out.println("Empiezo");
        hs.start();
        System.out.println("Termino");
    }
}
