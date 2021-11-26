package ejemplo3;

public class main {
    public static void main(String[] args) {
        Contador cont = new Contador(100);
        HiloIncrementador a = new HiloIncrementador("HiloA", cont);
        HiloIncrementador b = new HiloIncrementador("HiloB", cont);
        a.start();
        b.start();
    }
}
