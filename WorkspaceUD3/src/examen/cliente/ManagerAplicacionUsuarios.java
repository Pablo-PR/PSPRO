package examen.cliente;

import examen.modelo.Usuario;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;

public class ManagerAplicacionUsuarios {
	public static final String endPoint = "http://idocentic.website/servicios_para_explotar/aplicacion_usuarios/";
	// Atributos de la clase
	// Define aquí los atributos que vayas a usar en la clase
	public String nombre, apellido1, apellido2, usuario, password;
	
	
	// Métodos de la clase
	// Completa los métodos solicitados y aquellos que consideres necesarios.
	/**
	 * Llamará al servicio correspondiente para insertar un usuario en el sistema 
	 * con los datos pasados como parámetro.
	 * 
	 * @param nombre - del usuario a insertar
	 * @param apellido1 - del usuario a insertar
	 * @param apellido2 - del usuario a insertar
	 * @param usuario - del usuario a insertar
	 * @param password - del usuario a insertar
	 * @return
	 */
	public boolean insertaUsuario(String nombre, String apellido1, String apellido2, String usuario, String password) throws IOException {
		String direccionUrl = endPoint + "insertaUsuario.php?NOMBRE=" + nombre + "&APELLIDO1=" + apellido1 + "&APELLIDO2=" + apellido2 + "&USUARIO=" + usuario + "&PASSWORD=" + password;
		boolean usuarioInsertado = false;

		if (obtenerResultadoUrl(direccionUrl).equals("OK")) {
			usuarioInsertado = true;
		}

		return usuarioInsertado;
	}

	/**
	 * Devolverá true si existe en el sistema un usuario con usuario y password 
	 * iguales a los pasados como parámetros.
	 * 
	 * @param usuario
	 * @param password
	 * @return
	 */
	public boolean compruebaUsuario(String usuario, String password) throws IOException {
		String direccionUrl = endPoint + "compruebaUsuario.php?USUARIO=" + usuario + "&PASSWORD=" + password;
		boolean usuarioExistente = false;

		URL url = new URL(direccionUrl);
		BufferedReader in;

		InputStream inputStream = url.openStream();
		in = new BufferedReader(new InputStreamReader(inputStream));
		String cadena;
		ArrayList<String> inputLine = new ArrayList<>();
		ArrayList<String> listValores = new ArrayList<>();
		String[] valores;

		while ((cadena = in.readLine()) != null) {
			inputLine.add(cadena);
		}

		if (!inputLine.get(0).equals("KO")) {
			usuarioExistente = true;

			for (String s: inputLine) {
				System.out.println(s);
				valores = s.split("=");
				listValores.add(valores[1]);
			}

			this.nombre = listValores.get(0);
			this.apellido1 = listValores.get(1);
			this.apellido2 = listValores.get(2);
			this.usuario = listValores.get(3);
			this.password = listValores.get(4);
		}

		return usuarioExistente;
	}
	
	/** Comprobará si existe un usuario con el usuario y password pasados como parámetro. 
	 * En caso de existir, lo borrará y devolverá true.
	 * Si por el contrario, el usuario no existe, devolverá false.
	 * 
	 * @param usuario
	 * @param password
	 * @return
	 */
	public boolean borraUsuario(String usuario, String password) throws IOException {
		String direccionUrl = endPoint + "borraUsuario.php?USUARIO=" + usuario + "&PASSWORD=" + password;

		URL url = new URL(direccionUrl);
		BufferedReader in;

		InputStream inputStream = url.openStream();

		return true;
	}	
	 
	/**
	 * Devolverá un objeto de tipo Usuario con los valores del usuario obtenido
	 * mediante usuario y password
	 * 
	 * @param usuario
	 * @param password
	 * @return
	 */
	public Usuario generaUsuario(String usuario, String password) throws IOException {
		Usuario objUsuario = null;

		if (compruebaUsuario(usuario, password)) {
			objUsuario = new Usuario(this.nombre, this.apellido1, this.apellido2, this.usuario, this.password);
		}
		
		return objUsuario;
	}

	//Método para la obtención de datos de una URL que devuelva cadena de texto.
	private String obtenerResultadoUrl(String direccionUrl) throws IOException {
		URL url = new URL(direccionUrl);
		BufferedReader in;

		InputStream inputStream = url.openStream();
		in = new BufferedReader(new InputStreamReader(inputStream));
		return in.readLine();
	}
}
