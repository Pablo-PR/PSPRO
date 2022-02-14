package actividadPizzeria;

import java.io.IOException;

public class Ejercicio1 {
	public static void main(String[] args) {
		ClienteServicio cs = new ClienteServicio();
		int idTienda1, idTienda2, idTienda3;

		try {
			idTienda1 = cs.nuevoEstablecimiento("Establecimiento%20uno");
			idTienda2 = cs.nuevoEstablecimiento("Establecimiento%20dos");
			idTienda3 = cs.nuevoEstablecimiento("Establecimiento%20tres");
			registrarPedidos(idTienda1, idTienda2, idTienda3, cs);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void registrarPedidos(int idTienda1, int idTienda2, int idTienda3, ClienteServicio cs) throws IOException {
		registarEnTienda1(idTienda1, cs);
		registarEnTienda2(idTienda2, cs);
		registarEnTienda3(idTienda3, cs);
	}

	private static void registarEnTienda3(int idTienda3, ClienteServicio cs) throws IOException {
		int pedido1;

		pedido1 = cs.nuevoPedido(idTienda3);
	}

	private static void registarEnTienda2(int idTienda2, ClienteServicio cs) throws IOException {
		int pedido1;

		pedido1 = cs.nuevoPedido(idTienda2);

		cs.anadirProducto(idTienda2, pedido1, "EXTRAQUESO");
		cs.anadirProducto(idTienda2, pedido1, "4ESTACION");
	}

	private static void registarEnTienda1(int idTienda1, ClienteServicio cs) throws IOException {
		int pedido1, pedido2;

		pedido1 = cs.nuevoPedido(idTienda1);
		pedido2 = cs.nuevoPedido(idTienda1);

		for (int i = 0; i < 3; i++) {
			cs.anadirProducto(idTienda1, pedido1, "CARBONARA");
		}

		for (int i = 0; i < 2; i++) {
			cs.anadirProducto(idTienda1, pedido1, "BARBACOA");
		}

		cs.anadirProducto(idTienda1, pedido1, "CASA");

		cs.anadirProducto(idTienda1, pedido2, "MARGARITA");
	}
}
