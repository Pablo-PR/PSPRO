import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Ejemplo1_servidor {
	public static void main(String[] args) {
		int puerto = 9999;// Puerto
		ServerSocket servidor = null;
		try {
			servidor = new ServerSocket(puerto);
									
			System.out.println("Escuchando en " + servidor.getLocalPort());
			
			Socket cliente1= servidor.accept();//esperando a un cliente
			//realizar acciones con clientel
			System.out.println(cliente1);
			Socket cliente2 = servidor.accept();//esperando a otro cliente
			//realizar acciones con cliente2
			servidor.close(); //cierro socket servidor
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
