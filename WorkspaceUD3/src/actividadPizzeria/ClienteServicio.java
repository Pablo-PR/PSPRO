package actividadPizzeria;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class ClienteServicio {
	public static final String codAutor = "PPARROD2002";
	public static final String urlNuevaTienda = "http://idocentic.website/servicios_para_explotar/pizzeria_psp/inicializaPizzeria.php?COD_AUTOR=";
	public static final String urlInsertaPedido = "http://idocentic.website/servicios_para_explotar/pizzeria_psp/insertaPedido.php?COD_AUTOR=";
	public static final String urlInsertaProducto = "http://idocentic.website/servicios_para_explotar/pizzeria_psp/insertaProductoPedido.php?COD_AUTOR=";
	public static final String urlConsultaProductos = "http://idocentic.website/servicios_para_explotar/pizzeria_psp/consultaProductos.php";

	public Integer nuevoEstablecimiento (String nombreEstablecimiento) throws IOException {
		URL url = new URL(urlNuevaTienda + codAutor + "&NOMBRE_TIENDA=" + nombreEstablecimiento);
		BufferedReader in;

		InputStream inputStream = url.openStream();
		in = new BufferedReader(new InputStreamReader(inputStream));
		String inputLine;

		inputLine = in.readLine();
		return Integer.parseInt(inputLine);
	}

	public Integer nuevoPedido(Integer idTienda) throws IOException {
		URL url = new URL(urlInsertaPedido + codAutor + "&ID_TIENDA=" + idTienda);
		BufferedReader in;

		InputStream inputStream = url.openStream();
		in = new BufferedReader(new InputStreamReader(inputStream));
		String inputLine;

		inputLine = in.readLine();
		return Integer.parseInt(inputLine);
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

	public void consultarProductos() throws IOException {
		URL url = new URL(urlConsultaProductos);
		BufferedReader in;

		InputStream inputStream = url.openStream();
		in = new BufferedReader(new InputStreamReader(inputStream));
		String inputLine;

		inputLine = in.readLine();
	}
}
