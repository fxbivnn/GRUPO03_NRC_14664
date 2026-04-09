package arreglo;

import java.util.ArrayList;

import clases.Productos;

public class ProductoLlevar {
ArrayList<Productos> ap;
	
	public ProductoLlevar()
	{
		ap = new ArrayList<Productos>();
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
