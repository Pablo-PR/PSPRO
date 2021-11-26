package examenCursoPasado;

public class UsuarioCuentaBancaria extends Thread {

    private CuentaBancaria c;
    String nom;

    public UsuarioCuentaBancaria(String n, CuentaBancaria c) {
        super(n);
        this.c = c;
    }

    @Override
    public void run() {
        for (int x = 1; x <= 4; x++) {
            c.retirarDinero(10, getName());
        }
    } // run
}