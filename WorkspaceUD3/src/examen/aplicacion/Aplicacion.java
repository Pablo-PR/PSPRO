package examen.aplicacion;

import examen.cliente.ManagerAplicacionUsuarios;
import examen.modelo.Usuario;

import java.io.IOException;
import java.util.Scanner;

public class Aplicacion {
	private static final Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {
		Scanner teclado;
		int opcion;
		ManagerAplicacionUsuarios manager = new ManagerAplicacionUsuarios();
		
		do {
			teclado = new Scanner(System.in);
			muestraMenu();
			opcion = Integer.parseInt(teclado.nextLine());
			if (opcion==1) {
				try {
					altaUsuario(manager);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (opcion==2) {
				try {
					bajaUsuario(manager);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (opcion==3) {
				try {
					consultaDatosUsuario(manager);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}while(opcion!=4);
		
		System.out.println("Hasta la próxima");
	}
	
	public static void muestraMenu() {
		System.out.println("¿Qué desea hacer?");
		System.out.println("1. Dar de alta usuario.");
		System.out.println("2. Borrar usuario.");
		System.out.println("3. Consultar datos de usuario.");
		System.out.println("4. Salir.");
	}
	
	/**
	 * Solicitará los datos del usuario a registrar y lo registrará.
	 * @param manager
	 */
	public static void altaUsuario(ManagerAplicacionUsuarios manager) throws IOException {
		System.out.println("Inserte los datos del usuario a insertar:");
		String nombre = solicitarCadena("Nombre: ");
		String apellido1 = solicitarCadena("Primer apellido: ");
		String apellido2 = solicitarCadena("Segundo apellido: ");
		String usuario = solicitarCadena("Usuario: ");
		String password = solicitarCadena("Password: ");

		if (manager.insertaUsuario(nombre, apellido1, apellido2, usuario, password)) {
			System.out.println("Usuario registrado con éxito.");
		}
	}
	
	/**
	 * Solicitará el usuario a borrar y lo borrará.
	 * Pintará "Usuario eliminado con éxito" en caso de existir."
	 * Pintará "El usuario insertado no existe para ser eliminado."
	 * @param manager
	 */
	public static void bajaUsuario(ManagerAplicacionUsuarios manager) throws IOException {
		System.out.println("Inserte los datos del usuario a borrar:");
		String usuario = solicitarCadena("Usuario: ");
		String password = solicitarCadena("Password: ");

		if (manager.compruebaUsuario(usuario, password)) {
			manager.borraUsuario(usuario, password);
			System.out.println("Usuario eliminado con éxito.");
		}
		else {
			System.out.println("El usuario insertado no existe.");
		}
	}
	
	/**
	 * 1. Solicitará al usuario por línea de comandos usuario y password a consultar, 
	 * 2. Creará un objeto de tipo usuario mediante la llamada al servicio correspondiente.
	 * 3. Pintará los datos del objeto por pantalla (observa toString de Usuario)
	 * 
	 * @param manager
	 */
	public static void consultaDatosUsuario(ManagerAplicacionUsuarios manager) throws IOException {
		Usuario objUsuario;

		System.out.println("Inserte los datos del usuario a consultar:");
		String usuario = solicitarCadena("Usuario: ");
		String password = solicitarCadena("Password: ");

		objUsuario = manager.generaUsuario(usuario, password);

		if (objUsuario == null) {
			System.out.println("Usuario no existente.");
		}
		else {
			System.out.println(objUsuario);
		}
	}

	private static String solicitarCadena(String string) {
		System.out.println(string);
		return teclado.nextLine();
	}
}
