import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Ejercicio4 {
    public static void main(String[] args) {
        URL url = null;
        String linea;

        try {
            url = new URL("http://idocentic.website/prueba.html");
            BufferedReader in;
            FileWriter fw = new FileWriter("/Users/pablo/ejercicio4.txt");
            PrintWriter pw = new PrintWriter(fw);

            InputStream inputStream = url.openStream();
            in = new BufferedReader(new InputStreamReader(inputStream));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                linea = in.readLine();
                pw.println(linea);
            }
            in.close();
            pw.close();
            fw.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
