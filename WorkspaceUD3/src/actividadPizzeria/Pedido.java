package actividadPizzeria;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
	private List<Producto> productosPedido;

	public Pedido() {
		this.productosPedido = new ArrayList<>();
	}

	public List<Producto> getProductosPedido() {
		return productosPedido;
	}

	public void addProductosPedido(Producto p) {
		productosPedido.add(p);
	}

	@Override
	public String toString() {
		return "Productos -> " + productosPedido;
	}
}