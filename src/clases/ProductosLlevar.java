package clases;

public class ProductosLlevar {
	private String nombre, fechaVencimiento;
	private double precio;
	private int cant;
	public static double precioListar = 0;
	

	public ProductosLlevar(String nombre, String fechaVencimiento, double precio, int cant) {
		super();
		this.nombre = nombre;
		this.fechaVencimiento = fechaVencimiento;
		this.precio = precio;
		this.cant = cant;
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
		return cant;
	}

	public void setStock(int stock) {
		this.cant = stock;
	}
	
	public void PrecioTotal(int c)
	{
		precioListar += precio * c;
	}
	.
}
