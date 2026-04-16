
package arreglo;

import java.util.ArrayList;

import clases.ProductosLlevar;

public class ArregloProductosL {
	ArrayList<ProductosLlevar> ap;

	public ArregloProductosL() {
		ap = new ArrayList<ProductosLlevar>();
	}

	public void Adicionar(ProductosLlevar p) {
		ap.add(p);
	}

	public ProductosLlevar Obtener(int x) {
		return ap.get(x);
	}

	public int Tamaño() {
		return ap.size();
	}

	public ProductosLlevar Buscar(String nom) {
		for (int i = 0; i < Tamaño(); i++) {
			if (nom.equals(Obtener(i).getNombre())) {
				return Obtener(i);
			}
		}

		return null;
	}

	public int BuscarPosicion(String nom) {
		for (int i = 0; i < Tamaño(); i++) {
			if (nom.equalsIgnoreCase(Obtener(i).getNombre())) {
				return i;
			}
		}
		return -1;
	}

	public void Eliminar(int pos) {
		ap.remove(pos);
	}
}