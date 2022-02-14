package actividadPizzeria;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

public class ClienteServicio {
	public static final String codAutor = "PPARROD2002";
	public static final String urlNuevaTienda = "http://idocentic.website/servicios_para_explotar/pizzeria_psp/inicializaPizzeria.php?COD_AUTOR=";
	public static final String urlInsertaPedido = "http://idocentic.website/servicios_para_explotar/pizzeria_psp/insertaPedido.php?COD_AUTOR=";
	public static final String urlInsertaProducto = "http://idocentic.website/servicios_para_explotar/pizzeria_psp/insertaProductoPedido.php?COD_AUTOR=";
	public static final String urlConsultaProductos = "http://idocentic.website/servicios_para_explotar/pizzeria_psp/consultaProductos.php";

	public Integer nuevoEstablecimiento (String nombreEstablecimiento) throws IOException {
		String direccionUrl = urlNuevaTienda + codAutor + "&NOMBRE_TIENDA=" + nombreEstablecimiento;

		return obtenerIntegerUrl(direccionUrl);
	}

	public Integer nuevoPedido(Integer idTienda) throws IOException {
		String direccionUrl = urlInsertaPedido + codAutor + "&ID_TIENDA=" + idTienda;

		return obtenerIntegerUrl(direccionUrl);
	}

	public boolean anadirProducto(Integer idTienda, Integer idPedido, String codProducto) throws IOException {
		URL url = new URL(urlInsertaProducto + codAutor + "&ID_TIENDA=" + idTienda + "&ID_PEDIDO=" + idPedido + "&COD_PRODUCTO=" + codProducto);
		BufferedReader in;
		boolean insertado = true;

		InputStream inputStream = url.openStream();
		in = new BufferedReader(new InputStreamReader(inputStream));
		String inputLine;

		inputLine = in.readLine();

		if (!inputLine.equals("OK")) {
			insertado = false;
		}

		return insertado;
	}

	private Integer obtenerIntegerUrl(String direccionUrl) throws IOException {
		URL url = new URL(direccionUrl);
		BufferedReader in;

		InputStream inputStream = url.openStream();
		in = new BufferedReader(new InputStreamReader(inputStream));
		String inputLine = in.readLine();

		return Integer.parseInt(inputLine);
	}

	public ArrayList<String> consultarProductos() throws IOException {
		URL url = new URL(urlConsultaProductos);
		BufferedReader in;

		InputStream inputStream = url.openStream();
		in = new BufferedReader(new InputStreamReader(inputStream));
		String cadena;
		ArrayList<String> inputLine = new ArrayList<>();

		while ((cadena = in.readLine()) != null) {
			inputLine.add(cadena);
		}

		return inputLine;
	}
}
