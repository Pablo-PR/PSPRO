package examenCursoPasado;

public class main {
    public static void main(String[] args) {
        CuentaBancaria cb = new CuentaBancaria(40);
        UsuarioCuentaBancaria hJesus = new UsuarioCuentaBancaria("Juan", cb);
        UsuarioCuentaBancaria hManuela = new UsuarioCuentaBancaria("Manuela", cb);

        hJesus.start();
        hManuela.start();
    }
}
