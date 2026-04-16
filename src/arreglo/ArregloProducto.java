package arreglo;

import java.util.ArrayList;

import clases.Productos;

public class ArregloProducto {
	
	ArrayList<Productos> ap;
	
	public ArregloProducto()
	{
		ap = new ArrayList<Productos>();
		Adicionar(new Productos("Paracetamol", "2030", 1.50, 100));
		Adicionar(new Productos("Ibuprofeno", "2027", 1.00, 100));
		Adicionar(new Productos("Cetirizina", "2029", 2.00, 100));
		Adicionar(new Productos("Antigripal", "2031", 1.50, 100));
		Adicionar(new Productos("Simeticona", "2031", 1.80, 100));
		Adicionar(new Productos("Bismutol", "2028", 2.10, 100));
		Adicionar(new Productos("Clorfenamina", "2030", 1.50, 100));
		Adicionar(new Productos("Aspirina", "2032", 1.70, 100));
		Adicionar(new Productos("Fluoxetina", "2027", 2.00, 100));
		Adicionar(new Productos("Alprazolam", "2028", 1.30, 100));
		Adicionar(new Productos("Pseudoefedrina", "2027", 1.50, 100));
		Adicionar(new Productos("Insulina", "2031", 1.90, 100));
		Adicionar(new Productos("Metformina", "2030", 1.40, 100));
		Adicionar(new Productos("Salbutamol", "2029", 2.10, 100));
		Adicionar(new Productos("Losartán", "2027", 1.00, 100));
	}
	
	public void Adicionar(Productos p)
	{
		ap.add(p);
	}
	
	public Productos Obtener(int x)
	{
		return ap.get(x);
	}
	
	public int Tamaño()
	{
		return ap.size();
	}
	
	public Productos Buscar(String nom)
	{
		for (int i = 0; i < Tamaño(); i++)
		{
			if (nom.equals(Obtener(i).getNombre()))
			{
				return Obtener(i);
			}
		}
		
		return null;
	}
}