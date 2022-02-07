package ejerciciosBoletin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;

public class Ejercicio7 {
    public static void main(String[] args) {
        String linea;

        try {
            URL url = new URL ("http://idocentic.website/servicios_para_explotar/obtener_ip.php");

            InputStream in = url.openStream();
            BufferedReader bf = new BufferedReader(new InputStreamReader(in));
            linea = bf.readLine();

            System.out.println(linea);

            InetAddress dir = InetAddress.getByName(linea.trim());

            System.out.println("\tMetodo getHostName(): " + dir.getHostName());
            System.out.println("\tMetodo getHostAddress(): " + dir.getHostAddress());
            System.out.println("\tMetodo getCanonicalHostName(): " + dir.getCanonicalHostName());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
