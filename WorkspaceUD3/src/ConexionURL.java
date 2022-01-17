import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class ConexionURL {
    public static void main(String[] args) throws MalformedURLException {
        URL urlConecta = new URL("http://www.iescristobaldemonroy.es/wordpress/");
        BufferedReader in;

        try {
            InputStream inputStream = urlConecta.openStream();
            in = new BufferedReader(new InputStreamReader(inputStream));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println(inputLine);
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
