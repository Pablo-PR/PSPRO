package actividadPizzeria;

import java.io.IOException;

public class Tienda {
	private String nombreEstablecimiento;
	private Integer idTienda;
	public ClienteServicio cs;

	public Tienda(String nombreEstablecimiento, ClienteServicio cs) {
		this.nombreEstablecimiento = nombreEstablecimiento;
		this.cs = cs;
	}

	public String getNombreEstablecimiento() {
		return nombreEstablecimiento;
	}

	public void setNombreEstablecimiento(String nombreEstablecimiento) {
		this.nombreEstablecimiento = nombreEstablecimiento;
	}

	public Integer getIdTienda() {
		return idTienda;
	}

	public void setIdTienda(Integer idTienda) {
		this.idTienda = idTienda;
	}

	public ClienteServicio getCs() {
		return cs;
	}

	public void setCs(ClienteServicio cs) {
		this.cs = cs;
	}

	/**
	 * Registra el pedido pasado en ped en la tienda idTienda.
	 * @param ped
	 * @return
	 */
	public boolean registraPedido(Pedido ped) throws IOException {
		boolean insertadoConExito = false;
		int pedido;

		pedido = cs.nuevoPedido(idTienda);

		for (Producto p: ped.getProductosPedido()) {
			insertadoConExito = cs.anadirProducto(idTienda, pedido, p.getCodProducto());
		}

		return insertadoConExito;
	}
}
