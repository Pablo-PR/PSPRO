package ejerciciosBoletin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class Ejercicio5 {
    public static void main(String[] args) {
        String numPalabras;
        String[] arraySalida;
        StringBuilder salidaTerminal = new StringBuilder();

        try {
            URL urlConexion = new URL("http://idocentic.website/mayusculas.php?FRASE=hola%20mundo%20viva%20la%20vida");
            BufferedReader in;

            InputStream inputStream = urlConexion.openStream();
            in = new BufferedReader(new InputStreamReader(inputStream));
            String inputLine;

            inputLine = in.readLine();
            arraySalida = inputLine.split("<br/>");

            numPalabras = arraySalida[0];

            for (int i = 0; i < arraySalida.length-1; i++){
                salidaTerminal.append(arraySalida[i+1]);

                if (i+1 == arraySalida.length-1){
                    salidaTerminal.append(". ");
                } else{
                    salidaTerminal.append(" ");
                }
            }

            salidaTerminal.append("Esta frase tiene " + numPalabras + " palabras.");

            System.out.println(salidaTerminal);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
