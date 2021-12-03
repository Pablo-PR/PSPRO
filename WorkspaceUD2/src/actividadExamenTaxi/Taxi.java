package actividadExamenTaxi;
public class Taxi {
	private double precioKmCarrera = 2.5;
	private double importeCarrera = 0;
	private int numKmCarrera = 0;
	private boolean disponible = true;
	
	public synchronized void iniciaCarrera(Cliente c) {
		while (!disponible){
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		disponible = false;
		this.importeCarrera = 0;
		this.numKmCarrera = c.numKmCarrera;
		System.out.println(c.nombreCliente + " toma el taxi.");
	}
	
	public synchronized void finalizaCarrera(Cliente c) {
		this.importeCarrera = this.numKmCarrera * this.precioKmCarrera;
		String mensaje = "Finaliza el trayecto de: " + c.nombreCliente;
		mensaje       += "(" + this.numKmCarrera + "): ";
		mensaje       += this.importeCarrera + " euros.";
		System.out.println(mensaje);
		disponible = true;
		notifyAll();
	}
}
