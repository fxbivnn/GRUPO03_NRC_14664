package arreglo;

import java.util.ArrayList;

import clases.Productos;

public class ArregloProducto {
	
	ArrayList<Productos> ap;
	
	public ArregloProducto()
	{
		ap = new ArrayList<Productos>();
		Adicionar(new Productos("Paracetamol", "2030", 1.50, 100));
		Adicionar(new Productos("Ibuprofeno", "2030", 1.00, 100));
		Adicionar(new Productos("Cetirizina", "2030", 2.00, 100));
		Adicionar(new Productos("Antigripal", "2030", 1.50, 100));
		Adicionar(new Productos("Nastisol Forte", "2030", 1.80, 100));
		Adicionar(new Productos("Bismutol", "2030", 2.10, 100));
		Adicionar(new Productos("Clorfenamina", "2030", 1.50, 100));
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