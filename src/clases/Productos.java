package clases;

public class Productos {
	private String nombre, fechaVencimiento;
	private double precio;
	private int stock;
	public static double precioListar = 0;
	

	public Productos(String nombre, String fechaVencimiento, double precio, int stock) {
		super();
		this.nombre = nombre;
		this.fechaVencimiento = fechaVencimiento;
		this.precio = precio;
		this.stock = stock;
	}


	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getFechaVencimiento() {
		return fechaVencimiento;
	}



	public void setFechaVencimiento(String fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}



	public double getPrecio() {
		return precio;
	}



	public void setPrecio(double precio) {
		this.precio = precio;
	}



	public int getStock() {
		return stock;
	}



	public void setStock(int stock) {
		this.stock = stock;
	}
	
	public double PrecioTotal(int c)
	{
		precioListar += precio * c;
		
		stock -= c;
		
		return precio * c;
	}
	
	public void VolverStock(double p, int c)
	{
		precioListar -= p * c;
		
		stock += c;
	}
}
