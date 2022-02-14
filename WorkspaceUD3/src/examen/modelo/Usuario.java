package examen.modelo;

public class Usuario {
	private String usuario;
	private String password;
	private String nombre;
	private String apellido1;
	private String apellido2;
		
	/**
	 * @param usuario
	 * @param password
	 * @param nombre
	 * @param apellido1
	 * @param apellido2
	 */
	public Usuario(String nombre, String apellido1, String apellido2, String usuario, String password) {
		super();
		this.usuario = usuario;
		this.password = password;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
	}
	/**
	 * @return the usuario
	 */
	public String getUsuario() {
		return usuario;
	}
	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * @return the apellido1
	 */
	public String getApellido1() {
		return apellido1;
	}
	/**
	 * @param apellido1 the apellido1 to set
	 */
	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}
	/**
	 * @return the apellido2
	 */
	public String getApellido2() {
		return apellido2;
	}
	/**
	 * @param apellido2 the apellido2 to set
	 */
	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String usuario = "**Usuario**";
		
		usuario += "\n";
		usuario += "-> Nombre: " + nombre;
		usuario += "\n";
		usuario += "-> Apellido1: " + apellido1;
		usuario += "\n";
		usuario += "-> Apellido2: " + apellido2;
		usuario += "\n";
		usuario += "-> Usuario: " + this.usuario;
		usuario += "\n";
		usuario += "-> Password: " + password;
		usuario += "\n";
		
		usuario += "**********";
		
		return usuario;
	}
}