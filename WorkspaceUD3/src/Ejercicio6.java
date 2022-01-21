import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class Ejercicio6 {
    public static void main(String[] args) {
        int paramA = 1;
        int paramB = 2;

        System.out.println(conectarServicio(paramA, paramB));
    }

    private static int conectarServicio(int paramA, int paramB) {
        int indicdeInicio;
        int resultado = 0;

        try {
            URL urlConexion = new URL("http://idocentic.website/servicios_para_explotar/suma_parametros.php?PARAM_A=" + paramA + "&PARAM_B=" + paramB);
            BufferedReader in;

            InputStream inputStream = urlConexion.openStream();
            in = new BufferedReader(new InputStreamReader(inputStream));
            String inputLine;

            inputLine = in.readLine();
            indicdeInicio = inputLine.lastIndexOf(" ");
            resultado = Integer.parseInt(inputLine.substring(indicdeInicio + 1, inputLine.length()-1));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return resultado;
    }
}
