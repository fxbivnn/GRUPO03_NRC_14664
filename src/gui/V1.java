package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import arreglo.ArregloProducto;
import arreglo.ProductoLlevar;
import clases.Productos;

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
		setBounds(100, 100, 635, 481);
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
		lblNewLabel_1.setBounds(11, 89, 91, 12);
		contentPane.add(lblNewLabel_1);
		
		txtNP = new JTextField();
		txtNP.setColumns(10);
		txtNP.setBounds(112, 86, 96, 18);
		contentPane.add(txtNP);
		
		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(this);
		btnAdicionar.setBounds(218, 74, 84, 20);
		contentPane.add(btnAdicionar);
		
		btnReportar = new JButton("Reportar");
		btnReportar.addActionListener(this);
		btnReportar.setBounds(218, 104, 84, 20);
		contentPane.add(btnReportar);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(this);
		btnBuscar.setBounds(218, 134, 84, 20);
		contentPane.add(btnBuscar);
		
		txtC = new JTextField();
		txtC.setColumns(10);
		txtC.setBounds(111, 118, 96, 18);
		contentPane.add(txtC);
		
		JLabel lblNewLabel_3 = new JLabel("Cantidad:");
		lblNewLabel_3.setBounds(10, 121, 91, 12);
		contentPane.add(lblNewLabel_3);
		
		txtS = new JTextArea();
		txtS.setEditable(false);
		txtS.setBounds(323, 145, 288, 271);
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
		lblNewLabel_4.setBounds(416, 114, 106, 22);
		contentPane.add(lblNewLabel_4);

		cabezal();
		ListarProdcutos(1);
	}
	
	ArregloProducto AP = new ArregloProducto();
	ProductoLlevar PL = new ProductoLlevar();
	private JButton btnAdicionar;
	private JTextArea txtS;
	private JButton btnReportar;
	private JTextArea txtPL;
	private JButton btnBuscar;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_4;
	
	
	public void ListarProdcutos(int op)
	{
		if (op == 1)
		{
			for (int i = 0; i < AP.Tamaño(); i++)
			{
				Productos p = AP.Obtener(i);
				txtS.append(p.getNombre() + "\t" + p.getStock() + "\t" + p.getFechaVencimiento() +"\n");
			}
		}
		else 
		{
			for (int i = 0; i < PL.Tamaño(); i++)
			{
				Productos p = PL.Obtener(i);
				txtPL.append(p.getNombre() + "\t" + p.getPrecio() + "        X   " + "\t" + p.getStock() + "\t" + p.getFechaVencimiento() +"\n");
			}
		}
	}
	
	public void cabezal()
	{
		txtS.append("Producto\tStock\tFecha Vencimiento\n");
	}
	
	public void actionPerformed(ActionEvent e) {
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
		if (txtNP.getText().trim().isEmpty() && txtC.getText().trim().isEmpty())  JOptionPane.showMessageDialog(this, "Debe rellenar todos cuadros de Nombre producto y Cantidad");
		else if (txtNP.getText().trim().isEmpty()) JOptionPane.showMessageDialog(this, "Debe ingresar un nombre de producto");
		else if (txtC.getText().trim().isEmpty()) JOptionPane.showMessageDialog(this, "Debe ingresar la cantidad a llevar");
		else 
		{
		String nom = txtNP.getText();
		int cant = Integer.parseInt(txtC.getText());
		Productos nb = AP.Buscar(nom);
		

		if (nb != null)
		{
			Productos p = new Productos(nb.getNombre(), nb.getFechaVencimiento(), nb.getPrecio(), cant);
			nb.PrecioTotal(cant);
			PL.Adicionar(p);
			txtS.setText("");
			cabezal();
			ListarProdcutos(1);
			
			JOptionPane.showMessageDialog(this, "Se ha adicionado el producto " + nom + " correctamente");
		}
		else
		{
			JOptionPane.showMessageDialog(this, "El producto " + nom + " no se encuentra en nuestra lista o no existe");
		}
		}
	}
	protected void do_btnReportar_actionPerformed(ActionEvent e) {
		
		for (int i = 0; i < PL.Tamaño(); i++)
		{
			Productos p = PL.Obtener(i);
			txtPL.setText("");
			txtPL.append("Producto\tPrecio      Cantidad       Fecha Vencimiento\n");
			ListarProdcutos(2);
		}
	}
	protected void do_btnBuscar_actionPerformed(ActionEvent e) {
		if (txtNP.getText().trim().isEmpty()) JOptionPane.showMessageDialog(this, "Debe ingresar un nombre de producto");
		else
		{
		
		String nom = txtNP.getText();
		Productos nb = AP.Buscar(nom);
		
		if (nb != null)
		{
			JOptionPane.showMessageDialog(this, "EL producto " + nom + " se encuentra en la lista");
		}
		else
		{
			JOptionPane.showMessageDialog(this, "EL producto " + nom + " no se encuentra en la lista o no existe");
		}
	}
	}.
}
