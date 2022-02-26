import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Ejemplo2_servidor {
	public static void main(String[] args) {
		try {
			int numeroPuerto = 9999;// Puerto
			ServerSocket servidor = new ServerSocket(numeroPuerto);
			Socket clienteConectado = null;
			System.out.println("Esperando al cliente ");
			clienteConectado = servidor.accept();
			
			// CREO FLUJO DE ENTRADA DEL CLIENTE
			InputStream entrada = null;
			entrada = clienteConectado.getInputStream();
			DataInputStream flujoEntrada = new DataInputStream(entrada);
			
			//EL CLIENTE ME ENVIA UN MENSAJE
			System.out.println("Recibiendo del CLIENTE: \n\t" + 
			flujoEntrada.readUTF()) ;
			
			// CREO FLUJO DE SALIDA AL CLIENTE
			OutputStream salida = null;
			salida = clienteConectado.getOutputStream();
			DataOutputStream flujoSalida = new DataOutputStream(salida);
			
			System.out.println("Escribe el mensaje: ");
			Scanner tclCliente = new Scanner(System.in);
			String mensaje = tclCliente.nextLine();
			
			// ENVIO UN SALUDO AL CLIENTE
			flujoSalida.writeUTF(mensaje);
			
			// CERRAR STREAMS Y SOCKETS
			entrada.close(); 
			flujoEntrada.close() ; 
			salida.close (); 
			flujoSalida.close () ; 
			clienteConectado.close () ; 
			servidor.close() ;

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}