package actividadPizzeria;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio2 {
	private static final Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {
		ClienteServicio cs = new ClienteServicio();
		int idTienda;

		try {
			idTienda = cs.nuevoEstablecimiento("A%20la%20carta");

			mostrarMenu(idTienda);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void mostrarMenu(int idTienda) throws IOException {
		String opc;

		System.out.println("Pizzería \"A la carta\"");

		do {
			opc = solicitarCadena("¿Desea registrar un pedido? (S/N)").toUpperCase();
		} while (!opc.equals("S") && !opc.equals("N"));

		if (opc.equals("S")) {
			registrarPedido(idTienda);
		}
		else {
			System.out.println("Tenga un buen día.");
		}
	}

	private static void registrarPedido(int idTienda) throws IOException {
		ClienteServicio cs = new ClienteServicio();
		Producto producto;
		Pedido pedido = new Pedido();
		ArrayList<String> listaPizzas = cs.consultarProductos();
		ArrayList<String> listaValores = new ArrayList<>();
		ArrayList<String> nombres = new ArrayList<>();
		String[] nombrePizza;
		int opc;

		do {
			int i = 1;
			System.out.println("Iniciando su pedido\n" +
					"¿Qué artículo desea?");

			for (String s: listaPizzas) {
				nombrePizza = s.split("=");
				listaValores.add(nombrePizza[0]);
				nombres.add(nombrePizza[1]);
				System.out.println(i + ". " + nombrePizza[1]);
				i++;
			}

			opc = Integer.parseInt(solicitarCadena(""));

			producto = new Producto(listaValores.get(opc - 1), nombres.get(opc - 1));
			pedido.addProductosPedido(producto);
		} while (solicitarCadena("¿Finalizar pedido? (S/N)").toUpperCase().equals("N"));

		System.out.println("Pedido pendiente de registrar:\n" +
				pedido);

		if (solicitarCadena("\n¿Registrar pedido? (S/N)").equalsIgnoreCase("S")) {
			Tienda tienda = new Tienda("A la carta", cs);
			tienda.setIdTienda(idTienda);
			tienda.registraPedido(pedido);
		}
		else {
			mostrarMenu(idTienda);
		}
	}

	private static String solicitarCadena(String string) {
		System.out.println(string);
		return teclado.nextLine();
	}
}