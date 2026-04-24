package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import arreglo.ArregloProducto;
import arreglo.ArregloProductosL;
import clases.Productos;
import clases.ProductosLlevar;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class V1 extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNP;
	private JTextField txtC;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					V1 frame = new V1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public V1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 703, 481);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("INKAFARMA");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(248, 10, 115, 22);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Nombre producto:");
		lblNewLabel_1.setBounds(10, 69, 91, 12);
		contentPane.add(lblNewLabel_1);

		txtNP = new JTextField();
		txtNP.setColumns(10);
		txtNP.setBounds(112, 66, 96, 18);
		contentPane.add(txtNP);

		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(this);
		btnAdicionar.setBounds(218, 42, 84, 20);
		contentPane.add(btnAdicionar);

		btnReportar = new JButton("Reportar");
		btnReportar.addActionListener(this);
		btnReportar.setBounds(218, 65, 84, 20);
		contentPane.add(btnReportar);

		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(this);
		btnBuscar.setBounds(218, 90, 84, 20);
		contentPane.add(btnBuscar);

		txtC = new JTextField();
		txtC.setColumns(10);
		txtC.setBounds(112, 91, 96, 18);
		contentPane.add(txtC);

		JLabel lblNewLabel_3 = new JLabel("Cantidad:");
		lblNewLabel_3.setBounds(10, 94, 91, 12);
		contentPane.add(lblNewLabel_3);

		txtS = new JTextArea();
		txtS.setEditable(false);
		txtS.setBounds(391, 145, 288, 271);
		contentPane.add(txtS);

		txtPL = new JTextArea();
		txtPL.setBounds(10, 207, 303, 209);
		contentPane.add(txtPL);

		lblNewLabel_2 = new JLabel("Lista productos");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(97, 174, 115, 22);
		contentPane.add(lblNewLabel_2);

		lblNewLabel_4 = new JLabel("Stock productos");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(495, 114, 106, 22);
		contentPane.add(lblNewLabel_4);
		{
			btnModificar = new JButton("Modificar");
			btnModificar.addActionListener(this);
			btnModificar.setBounds(219, 116, 84, 20);
			contentPane.add(btnModificar);
		}
		{
			btnEliminar = new JButton("Eliminar");
			btnEliminar.addActionListener(this);
			btnEliminar.setBounds(220, 141, 84, 20);
			contentPane.add(btnEliminar);
		}
		{
			lblNewLabel_5 = new JLabel("Nuevo nombre:");
			lblNewLabel_5.setBounds(10, 122, 91, 12);
			contentPane.add(lblNewLabel_5);
		}
		{
			txtNN = new JTextField();
			txtNN.setColumns(10);
			txtNN.setBounds(112, 119, 96, 18);
			contentPane.add(txtNN);
		}
		{
			lblNewLabel_6 = new JLabel("Nueva cantidad:");
			lblNewLabel_6.setBounds(10, 145, 91, 12);
			contentPane.add(lblNewLabel_6);
		}
		{
			txtNC = new JTextField();
			txtNC.setColumns(10);
			txtNC.setBounds(112, 145, 96, 18);
			contentPane.add(txtNC);
		}

		cabezal(true);
		ListarProdcutos(true);
	}

	ArregloProducto AP = new ArregloProducto();
	ArregloProductosL PL = new ArregloProductosL();
	private JButton btnAdicionar;
	private JTextArea txtS;
	private JButton btnReportar;
	private JTextArea txtPL;
	private JButton btnBuscar;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_4;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JLabel lblNewLabel_5;
	private JTextField txtNN;
	private JLabel lblNewLabel_6;
	private JTextField txtNC;

	public void ListarProdcutos(boolean op) {
		if (op) {
			for (int i = 0; i < AP.Tamaño(); i++) {
				Productos p = AP.Obtener(i);
				txtS.append(p.getNombre() + "\t" + p.getStock() + "\t" + p.getFechaVencimiento() + "\n");
			}
		} else {
			for (int i = 0; i < PL.Tamaño(); i++) {
				ProductosLlevar p = PL.Obtener(i);
				txtPL.append(p.getNombre() + "\t" + p.getPrecio() + "        X   " + "\t" + p.getStock() + "\t"
						+ p.getFechaVencimiento() + "\n");
			}
		}
	}

	public void cabezal(boolean op) {
		if (op)
			txtS.append("Producto\tStock\tFecha Vencimiento\n");
		else
			txtPL.append("Producto\tPrecio      Cantidad       Fecha Vencimiento\n");
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnEliminar) {
			do_btnEliminar_actionPerformed(e);
		}
		if (e.getSource() == btnModificar) {
			do_btnModificar_actionPerformed(e);
		}
		if (e.getSource() == btnBuscar) {
			do_btnBuscar_actionPerformed(e);
		}
		if (e.getSource() == btnReportar) {
			do_btnReportar_actionPerformed(e);
		}
		if (e.getSource() == btnAdicionar) {
			do_btnAdicionar_actionPerformed(e);
		}
	}

	protected void do_btnAdicionar_actionPerformed(ActionEvent e) {
		try {
			if (txtNP.getText().trim().isEmpty() && txtC.getText().trim().isEmpty())
				JOptionPane.showMessageDialog(this, "Debe rellenar todos cuadros de Nombre producto y Cantidad");
			else if (txtNP.getText().trim().isEmpty())
				JOptionPane.showMessageDialog(this, "Debe ingresar un nombre de producto");
			else if (txtC.getText().trim().isEmpty())
				JOptionPane.showMessageDialog(this, "Debe ingresar la cantidad a llevar");
			else {
				String nom = txtNP.getText();
				int cant = Integer.parseInt(txtC.getText());
				Productos nb = AP.Buscar(nom, cant);

				if (nb != null) {
					ProductosLlevar p = new ProductosLlevar(nb.getNombre(), nb.getFechaVencimiento(), nb.getPrecio(),
							cant);
					p.PrecioTotal(cant);
					PL.Adicionar(p);
					nb.ConsumirStock(cant);
					txtS.setText("");
					cabezal(true);
					ListarProdcutos(true);

					JOptionPane.showMessageDialog(this, "Se ha adicionado el producto " + nom + " correctamente");
				} else {
					JOptionPane.showMessageDialog(this,
							"El producto " + nom + " no se encuentra en nuestra lista o no hay stock suficiente\"");
				}
			}
		} catch (Exception m) {
			JOptionPane.showMessageDialog(this, "La cantidad debe ser un número entero");
		}
	}

	protected void do_btnReportar_actionPerformed(ActionEvent e) {

		for (int i = 0; i < PL.Tamaño(); i++) {
			ProductosLlevar p = PL.Obtener(i);
			txtPL.setText("");
			cabezal(false);
			ListarProdcutos(false);
		}
	}

	protected void do_btnBuscar_actionPerformed(ActionEvent e) {
		if (txtNP.getText().trim().isEmpty())
			JOptionPane.showMessageDialog(this, "Debe ingresar un nombre de producto");
		else {
			String nom = txtNP.getText();
			ProductosLlevar bp = PL.Buscar(nom);

			if (bp != null) {
				JOptionPane.showMessageDialog(this, "EL producto " + nom + " se encuentra en la lista");
			} else {
				JOptionPane.showMessageDialog(this, "EL producto " + nom + " no se encuentra en la lista o no existe");
			}
		}
	}

	protected void do_btnModificar_actionPerformed(ActionEvent e) {
		if (txtNP.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Debe ingresar un nombre de producto");
			return;
		}

		String nom = txtNP.getText().trim();
		String nomNue = txtNN.getText().trim();
		String cantNuevaTexto = txtNC.getText().trim();

		try {
			if (!nomNue.isEmpty() && !cantNuevaTexto.isEmpty()) {
				int nuevaCant = Integer.parseInt(cantNuevaTexto);

				if (nuevaCant <= 0) {
					JOptionPane.showMessageDialog(this, "La nueva cantidad debe ser mayor que cero");
					return;
				}

				ProductosLlevar nPL = PL.Buscar(nom);
				Productos nAP = AP.Buscar(nom);

				if (nPL == null) {
					JOptionPane.showMessageDialog(this, "El producto " + nom + " no se encuentra en la lista");
					return;
				}

				if (nAP == null) {
					JOptionPane.showMessageDialog(this, "El producto original no existe en el stock general");
					return;
				}

				int antiguaCant = nPL.getStock();

				nAP.VolverStock(antiguaCant);

				Productos nAP2 = AP.Buscar(nomNue, nuevaCant);

				if (nAP2 == null) {

					nAP.ConsumirStock(antiguaCant);

					JOptionPane.showMessageDialog(this, "El nuevo producto no existe o no hay stock suficiente");
					return;
				}

				nPL.setNombre(nomNue);
				nPL.setStock(nuevaCant);
				nAP2.ConsumirStock(nuevaCant);

				JOptionPane.showMessageDialog(this, "Producto modificado correctamente");
			}

			else if (!nomNue.isEmpty() && cantNuevaTexto.isEmpty()) {
				ProductosLlevar npPL = PL.Buscar(nom);
				Productos nbAP = AP.Buscar(nom);

				if (npPL == null) {
					JOptionPane.showMessageDialog(this, "El producto " + nom + " no se encuentra en la lista");
					return;
				}

				if (nbAP == null) {
					JOptionPane.showMessageDialog(this, "El producto original no existe en el stock general");
					return;
				}

				int cantidadActual = npPL.getStock();

				nbAP.VolverStock(cantidadActual);

				Productos nbAP2 = AP.Buscar(nomNue, cantidadActual);

				if (nbAP2 == null) {

					nbAP.ConsumirStock(cantidadActual);

					JOptionPane.showMessageDialog(this, "El nuevo producto no existe o no tiene stock suficiente");
					return;
				}

				npPL.setNombre(nomNue);
				nbAP2.ConsumirStock(cantidadActual);

				JOptionPane.showMessageDialog(this, "Nombre del producto modificado correctamente");
			}

			else if (!cantNuevaTexto.isEmpty() && nomNue.isEmpty()) {
				int nuevaCant = Integer.parseInt(cantNuevaTexto);

				if (nuevaCant <= 0) {
					JOptionPane.showMessageDialog(this, "La nueva cantidad debe ser mayor que cero");
					return;
				}

				ProductosLlevar ncPL = PL.Buscar(nom);
				Productos ncAP = AP.Buscar(nom);

				if (ncPL == null) {
					JOptionPane.showMessageDialog(this, "El producto " + nom + " no se encuentra en la lista");
					return;
				}

				if (ncAP == null) {
					JOptionPane.showMessageDialog(this, "El producto no existe en el stock general");
					return;
				}

				int antiguaCant = ncPL.getStock();

				ncAP.VolverStock(antiguaCant);

				Productos productoValidado = AP.Buscar(nom, nuevaCant);

				if (productoValidado == null) {

					ncAP.ConsumirStock(antiguaCant);

					JOptionPane.showMessageDialog(this, "No hay stock suficiente para la nueva cantidad");
					return;
				}

				ncPL.setStock(nuevaCant);
				productoValidado.ConsumirStock(nuevaCant);

				JOptionPane.showMessageDialog(this, "Cantidad modificada correctamente");
			}

			else {
				JOptionPane.showMessageDialog(this, "Debe ingresar un nuevo nombre o una nueva cantidad");
				return;
			}

			txtPL.setText("");
			cabezal(false);
			ListarProdcutos(false);

			txtS.setText("");
			cabezal(true);
			ListarProdcutos(true);

		} catch (NumberFormatException ex) {
			JOptionPane.showMessageDialog(this, "La nueva cantidad debe ser un número entero");
		}
	}

	protected void do_btnEliminar_actionPerformed(ActionEvent e) {
		try
		{
		if (txtNP.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Debe ingresar un nombre de producto");
			return;
		} else {

			String nom = txtNP.getText().trim();

			int index = PL.BuscarPosicion(nom);
			ProductosLlevar bpPL = PL.Buscar(nom);
			Productos bpAP = AP.Buscar(nom);

			bpAP.VolverStock(bpPL.getStock());
			PL.Eliminar(index);

			txtPL.setText("");
			cabezal(false);
			ListarProdcutos(false);
			txtS.setText("");
			cabezal(true);
			ListarProdcutos(true);
		}
		}catch(Exception m)
		{
			JOptionPane.showMessageDialog(this, "El nombre de producto no puede contener enteros");
		}
	}
}
