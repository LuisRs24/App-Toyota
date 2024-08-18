package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import Entidad.Proveedor;
import Mantenimiento.ProveedorGestionDAO;
import Utils.Validaciones;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;

public class FrmProveedor extends JFrame implements ActionListener, MouseListener {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNombre;
	private JLabel lblDireccion;
	private JLabel lblEmail;
	private JLabel lblEmail_1;
	private JTextField txtCodigo;
	private JTextField txtNombre;
	private JTextField txtDireccion;
	private JTextField txtTelefono;
	private JTextField txtEmail;
	private JTable tbProveedor;
	private JScrollPane scrollPane;
	private JButton btnLimpiar;
	private JButton btnRegistrar;
	private JButton btnBorrar;
	private JButton btnActualizar;

	DefaultTableModel model = new DefaultTableModel();
	ProveedorGestionDAO gProv = new ProveedorGestionDAO();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmProveedor frame = new FrmProveedor();
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
	public FrmProveedor() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrmProveedor.class.getResource("/img/toyo_log.png")));
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		setTitle("TOYOTA - Mantenimiento Proveedor");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 958, 351);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblNewLabel = new JLabel("Codigo :");
		lblNewLabel.setBounds(10, 98, 52, 13);
		contentPane.add(lblNewLabel);

		lblNombre = new JLabel("Nombre :");
		lblNombre.setBounds(10, 140, 52, 13);
		contentPane.add(lblNombre);

		lblDireccion = new JLabel("Direccion :");
		lblDireccion.setBounds(10, 182, 64, 13);
		contentPane.add(lblDireccion);

		lblEmail = new JLabel("Telefono :");
		lblEmail.setBounds(10, 224, 72, 13);
		contentPane.add(lblEmail);

		lblEmail_1 = new JLabel("Email :");
		lblEmail_1.setBounds(10, 266, 52, 13);
		contentPane.add(lblEmail_1);

		txtCodigo = new JTextField();
		txtCodigo.setEditable(false);
		txtCodigo.setBounds(81, 95, 123, 19);
		contentPane.add(txtCodigo);
		txtCodigo.setColumns(10);

		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(81, 137, 123, 19);
		contentPane.add(txtNombre);

		txtDireccion = new JTextField();
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(81, 179, 123, 19);
		contentPane.add(txtDireccion);

		txtTelefono = new JTextField();
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(81, 221, 123, 19);
		contentPane.add(txtTelefono);

		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(81, 263, 123, 19);
		contentPane.add(txtEmail);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(214, 65, 720, 239);
		contentPane.add(scrollPane);

		btnLimpiar = new JButton("NUEVO");
		btnLimpiar.addActionListener(this);
		btnLimpiar.setIcon(new ImageIcon(FrmProveedor.class.getResource("/img/Limpiar.png")));
		btnLimpiar.setPressedIcon(new ImageIcon(FrmProveedor.class.getResource("/img/new2.png")));
		btnLimpiar.setBounds(325, 11, 116, 40);
		contentPane.add(btnLimpiar);

		btnRegistrar = new JButton("REGISTRAR");
		btnRegistrar.setPressedIcon(new ImageIcon(FrmProveedor.class.getResource("/img/abrir2.png")));
		btnRegistrar.setIcon(new ImageIcon(FrmProveedor.class.getResource("/img/abrir.png")));
		btnRegistrar.addActionListener(this);
		btnRegistrar.setBounds(470, 11, 131, 40);
		contentPane.add(btnRegistrar);

		btnBorrar = new JButton("ELIMINAR");
		btnBorrar.setIcon(new ImageIcon(FrmProveedor.class.getResource("/img/delete.png")));
		btnBorrar.setPressedIcon(new ImageIcon(FrmProveedor.class.getResource("/img/delete2.png")));
		btnBorrar.addActionListener(this);
		btnBorrar.setBounds(790, 10, 123, 40);
		contentPane.add(btnBorrar);

		btnActualizar = new JButton("ACTUALIZAR");
		btnActualizar.addActionListener(this);
		btnActualizar.setPressedIcon(new ImageIcon(FrmProveedor.class.getResource("/img/sync2.png")));
		btnActualizar.setIcon(new ImageIcon(FrmProveedor.class.getResource("/img/sync.png")));
		btnActualizar.setBounds(630, 11, 131, 40);
		contentPane.add(btnActualizar);

		model.addColumn("CÓDIGO");
		model.addColumn("NOMBRE");
		model.addColumn("DIRECCIÓN");
		model.addColumn("TELÉFONO");
		model.addColumn("EMAIL");

		tbProveedor = new JTable();
		tbProveedor.setBounds(224, 123, 582, 181);
		tbProveedor.addMouseListener(this);
		tbProveedor.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Codigo", "Nombre", "Direccion", "Telefono", "Email" }));
		tbProveedor.setFillsViewportHeight(true);

		tbProveedor.setModel(model);
		scrollPane.setViewportView(tbProveedor);

		JLabel lblProveeedor = new JLabel("   Proveeedor");
		lblProveeedor.setIcon(new ImageIcon(FrmProveedor.class.getResource("/img/Proveeedor.png")));
		lblProveeedor.setForeground(Color.BLACK);
		lblProveeedor.setOpaque(true);
		lblProveeedor.setHorizontalAlignment(SwingConstants.CENTER);
		lblProveeedor.setFont(new Font("Cambria", Font.BOLD, 20));
		lblProveeedor.setBackground(Color.LIGHT_GRAY);
		lblProveeedor.setBounds(10, 11, 286, 40);
		contentPane.add(lblProveeedor);
		cargarTable();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnActualizar) {
			do_btnActualizar_actionPerformed(e);
		}
		if (e.getSource() == btnLimpiar) {
			do_btnLimpiar_actionPerformed(e);
		}
		if (e.getSource() == btnBorrar) {
			actionPerformedBtnBorrar(e);
		}
		if (e.getSource() == btnRegistrar) {
			actionPerformedBtnRegistrar(e);
		}
	}

	protected void actionPerformedBtnRegistrar(ActionEvent e) {
		ingresar();
	}

	void ingresar() {
		int cod;
		String nombre, direcc, email, telef;

		cod = generarNumeroProveedor();
		nombre = leerProveedor();
		direcc = leerDireccion();
		telef = leerTelef();
		email = leerEmail();

		if (cod == -1 || direcc == null || email == null || telef == null || nombre == null) {
			return;

		} else {
			Proveedor pro = new Proveedor();
			pro.setCod(cod);
			pro.setNomprove(nombre);
			pro.setDirecc(direcc);
			pro.setTelef(telef);
			pro.setEmail(email);
			int result = gProv.registrarProveedor(pro);
			if (result != 0) {
				JOptionPane.showMessageDialog(null, "Proveedor registrado exitosamente");
				cargarTable();
			} else {
				JOptionPane.showMessageDialog(null, "No se pudo registrar el almacen");
			}
		}
	}
	
	private int generarNumeroProveedor() {
		int codeLastProveedor = 0;
		if (tbProveedor.getRowCount() == 0) {
			return codeLastProveedor = 1;
		} else {
			codeLastProveedor = (int) tbProveedor.getValueAt(tbProveedor.getRowCount() - 1, 0);
			int FinalCode = codeLastProveedor+1;
			return FinalCode;
		}
	}

	protected void do_btnActualizar_actionPerformed(ActionEvent e) {
		actualizarProveedor();
	}

	private void actualizarProveedor() {
		int cod;
		String nombre, direcc, email, telef;

		cod = leerCodigo();
		nombre = leerProveedor();
		direcc = leerDireccion();
		telef = leerTelef();
		email = leerEmail();

		if (cod == -1 || direcc == null || email == null || telef == null || nombre == null) {
			return;
		} else {
			Proveedor pro = new Proveedor();
			pro.setNomprove(nombre);
			pro.setDirecc(direcc);
			pro.setTelef(telef);
			pro.setEmail(email);
			pro.setCod(cod);
			int result = gProv.actualizarProveedor(pro);
			if (result != 0) {
				JOptionPane.showMessageDialog(null, "Proveedor Actualizado exitosamente");
				cargarTable();
			} else {
				JOptionPane.showMessageDialog(null, "No se pudo Actualizar el Proveedor");
			}
		}
	}

	private void cargarTable() {
		model.setRowCount(0);
		ArrayList<Proveedor> list = gProv.listarProveedor();
		if (list.size() != 0) {
			for (Proveedor p : list) {
				Object[] row = { p.getCod(), p.getNomprove(), p.getDirecc(), p.getTelef(), p.getEmail() };
				model.addRow(row);
			}
			tbProveedor.setModel(model);
		} else {
			JOptionPane.showMessageDialog(null, "Lista vacia!");
		}
	}

	private String leerTelef() {
		String leertelef = null;
		if (txtTelefono.getText().length() == 0) {
			mensajeError("Ingresa el numero de telefono");
		} else {
			leertelef = txtTelefono.getText();
		}
		return leertelef;
	}

	private String leerEmail() {
		String email = null;
		if (txtEmail.getText().trim().length() == 0) {
			mensajeError("Ingresa el email");
			txtEmail.requestFocus();
		} else if (txtEmail.getText().trim().matches(Validaciones.EmailProveedor)) {
			email = txtEmail.getText().trim();
		}
		return email;
	}

	private String leerDireccion() {
		String direcc = null;
		// validar caja vacia
		if (txtDireccion.getText().trim().length() == 0) {
			mensajeError("Ingresa la dirección");
			txtDireccion.requestFocus();
		}
		direcc = txtDireccion.getText().trim();
		return direcc;
	}

	private String leerProveedor() {
		String nomprove = null;
		// validar caja vacia
		if (txtNombre.getText().trim().length() == 0) {
			mensajeError("Ingrese el nombre del Personal");
			txtNombre.requestFocus();
		} else if (txtNombre.getText().trim().matches(Validaciones.NombreProveedor)) {
			nomprove = txtNombre.getText().trim();
		} else {
			mensajeError("Formato incorrecto !! de 3 a 20 caracteres");
			txtNombre.setText("");
			txtNombre.requestFocus();
		}
		return nomprove;

	}

	private int leerCodigo() {
		int cod = -1;
		// validar caja vacia
		if (txtCodigo.getText().trim().length() == 8) {
			mensajeError("Ingresa el codigo del Personal");
			txtCodigo.requestFocus();
		} else if (txtCodigo.getText().trim().matches(Validaciones.CodigoProveedor)) {
			cod = Integer.parseInt(txtCodigo.getText());
		} else {
			mensajeError("Formato incorrecto! Ej. P001");
			txtCodigo.setText("");
			txtCodigo.requestFocus();
		}
		return cod;
	}

	private void mensajeError(String msj) {
		JOptionPane.showMessageDialog(this, msj, "Error !!", 0);
	}

	void MostrarDatos(int fila) {
		try {
			String cod, nomprove, direcc, email, telef;

			cod = tbProveedor.getValueAt(fila, 0).toString();
			nomprove = tbProveedor.getValueAt(fila, 1).toString();
			direcc = tbProveedor.getValueAt(fila, 2).toString();
			telef = tbProveedor.getValueAt(fila, 3).toString();
			email = tbProveedor.getValueAt(fila, 4).toString();

			txtCodigo.setText(cod);
			txtNombre.setText(nomprove);
			txtDireccion.setText(direcc);
			txtEmail.setText(email);
			txtTelefono.setText(telef);
		} catch (Exception e) {
			mensajeError("Fila Vacía");
		}
	}

	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == tbProveedor) {
			mouseClickedTable(e);
		}
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}

	protected void mouseClickedTable(MouseEvent e) {
		int fila = tbProveedor.getSelectedRow();
		MostrarDatos(fila);
	}

	protected void actionPerformedBtnBorrar(ActionEvent e) {
		int rowSelection = tbProveedor.getSelectedRow();
		if (rowSelection != -1) {
			int result = JOptionPane.showConfirmDialog(null, "¿Seguro que desea continuar?", "ADVERTENCIA",
					JOptionPane.YES_NO_OPTION);
			if (result == 0) {
				gProv.eliminarProveedor(Integer.parseInt(tbProveedor.getValueAt(rowSelection, 0) + ""));
				cargarTable();
			}
		}
	}

	protected void do_btnLimpiar_actionPerformed(ActionEvent e) {
		txtNombre.setText("");
		txtCodigo.setText(generarNumeroProveedor()+"");
		txtEmail.setText("");
		txtTelefono.setText("");
		txtDireccion.setText("");
	}
}
