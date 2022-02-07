package ejerciciosBoletin;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class Ejercicio8 {

    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.timeanddate.com/scripts/sunmap.php?iso=" + args[0].toString());
            byte[] buffer = new byte[1024];

            InputStream in = url.openStream();

            FileOutputStream fos = new FileOutputStream("imagenesEjercicio8/" + args[0].toString() + ".jpg");

            int len;

            while ((len = in.read(buffer)) > 0)
            {
                fos.write(buffer, 0, len);
            }

            in.close();
            fos.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
