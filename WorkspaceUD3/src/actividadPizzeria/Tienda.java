package actividadPizzeria;

public class Tienda {
	private String nombreEstablecimiento;
	private Integer idTienda;
	public ClienteServicio cs;
	
	/**
	 * Registra la tienda en el servicio.
	 * @param cs
	 * @param nombreEstablecimiento
	 */
	public Tienda(ClienteServicio cs, String nombreEstablecimiento) {
		/**
		 * 
		 */
	}
	
	/**
	 * Registra el pedido pasado en ped en la tienda idTienda.
	 * @param ped
	 * @return
	 */
	public boolean registraPedido(Pedido ped) {
		boolean insertadoConExito = false;
		return insertadoConExito;
	}
}
