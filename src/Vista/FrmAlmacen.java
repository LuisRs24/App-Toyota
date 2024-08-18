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
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;

import Utils.Validaciones;
import Entidad.Almacen;
import Entidad.Vehiculo;
import Mantenimiento.AlmacenGestionDAO;

import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class FrmAlmacen extends JFrame implements ActionListener, MouseListener {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JTextField txtNumero;
	private JLabel lblDireccion;
	private JTextField txtDireccion;
	private JLabel lblTelefono;
	private JTextField txtTelefono;
	private JLabel lblEmail;
	private JTextField txtEmail;
	private JLabel lblCapacidad;
	private JTextField txtCapacidad;
	private JLabel lblEmail_2;
	private JButton btnRegistrar;
	private JScrollPane scrollPane;
	private JButton btnActualizar;
	private JButton btnEliminar;

	DefaultTableModel model = new DefaultTableModel();
	AlmacenGestionDAO gAlmacen = new AlmacenGestionDAO();
	private JLabel lblMantenimientoDeAlmacen;
	private JButton btnNuevo;
	private JTable tblAlmacen;
	private JScrollPane scrollPane_1;
	private JComboBox cboDepartamento;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmAlmacen frame = new FrmAlmacen();
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
	public FrmAlmacen() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrmAlmacen.class.getResource("/img/toyo_log.png")));
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		setTitle("TOYOTA - Mantenimiento Almacen");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 998, 329);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);

		lblNewLabel = new JLabel("Nro. Almacen");
		lblNewLabel.setBounds(10, 90, 76, 13);
		contentPane.add(lblNewLabel);

		txtNumero = new JTextField();
		txtNumero.setEditable(false);
		txtNumero.setBounds(96, 87, 137, 19);
		contentPane.add(txtNumero);
		txtNumero.setColumns(10);

		lblDireccion = new JLabel("Direccion ");
		lblDireccion.setBounds(10, 156, 62, 13);
		contentPane.add(lblDireccion);

		txtDireccion = new JTextField();
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(96, 153, 137, 19);
		contentPane.add(txtDireccion);

		lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(10, 222, 62, 13);
		contentPane.add(lblTelefono);

		txtTelefono = new JTextField();
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(96, 219, 137, 19);
		contentPane.add(txtTelefono);

		lblEmail = new JLabel("Email");
		lblEmail.setBounds(10, 123, 62, 13);
		contentPane.add(lblEmail);

		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(96, 120, 137, 19);
		contentPane.add(txtEmail);

		lblCapacidad = new JLabel("Capacidad");
		lblCapacidad.setBounds(10, 189, 62, 13);
		contentPane.add(lblCapacidad);

		txtCapacidad = new JTextField();
		txtCapacidad.setColumns(10);
		txtCapacidad.setBounds(96, 186, 137, 19);
		contentPane.add(txtCapacidad);

		lblEmail_2 = new JLabel("Departamento");
		lblEmail_2.setBounds(10, 255, 90, 13);
		contentPane.add(lblEmail_2);

		btnRegistrar = new JButton("GUARDAR");
		btnRegistrar.setPressedIcon(new ImageIcon(FrmAlmacen.class.getResource("/img/abrir2.png")));
		btnRegistrar.setIcon(new ImageIcon(FrmAlmacen.class.getResource("/img/abrir.png")));
		btnRegistrar.addActionListener(this);
		btnRegistrar.setBounds(569, 12, 122, 50);
		contentPane.add(btnRegistrar);

		btnActualizar = new JButton("ACTUALIZAR");
		btnActualizar.addActionListener(this);
		btnActualizar.setPressedIcon(new ImageIcon(FrmAlmacen.class.getResource("/img/sync2.png")));
		btnActualizar.setIcon(new ImageIcon(FrmAlmacen.class.getResource("/img/sync.png")));
		btnActualizar.setBounds(701, 12, 139, 50);
		contentPane.add(btnActualizar);

		btnEliminar = new JButton("ELIMINAR");
		btnEliminar.addActionListener(this);
		btnEliminar.setPressedIcon(new ImageIcon(FrmAlmacen.class.getResource("/img/delete2.png")));
		btnEliminar.setIcon(new ImageIcon(FrmAlmacen.class.getResource("/img/delete.png")));
		btnEliminar.setBounds(850, 12, 122, 50);
		contentPane.add(btnEliminar);
		
		lblMantenimientoDeAlmacen = new JLabel("   Mantenimiento de Almacen");
		lblMantenimientoDeAlmacen.setIcon(new ImageIcon(FrmAlmacen.class.getResource("/img/almacen.png")));
		lblMantenimientoDeAlmacen.setForeground(Color.BLACK);
		lblMantenimientoDeAlmacen.setOpaque(true);
		lblMantenimientoDeAlmacen.setHorizontalAlignment(SwingConstants.CENTER);
		lblMantenimientoDeAlmacen.setFont(new Font("Cambria", Font.BOLD, 20));
		lblMantenimientoDeAlmacen.setBackground(Color.LIGHT_GRAY);
		lblMantenimientoDeAlmacen.setBounds(10, 12, 410, 50);
		contentPane.add(lblMantenimientoDeAlmacen);
		
		btnNuevo = new JButton("NUEVO");
		btnNuevo.addActionListener(this);
		btnNuevo.setIcon(new ImageIcon(FrmAlmacen.class.getResource("/img/Limpiar.png")));
		btnNuevo.setBounds(430, 12, 122, 50);
		contentPane.add(btnNuevo);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(243, 87, 729, 184);
		contentPane.add(scrollPane_1);
		
		tblAlmacen = new JTable();
		scrollPane_1.setViewportView(tblAlmacen);
		
		cboDepartamento = new JComboBox();
		cboDepartamento.setModel(new DefaultComboBoxModel(new String[] {"Seleccione...", "Amazonas", "Ancash", "Apurimac", "Arequipa", "Ayacucho", "Cajamarca", "Callao", "Cusco", "Huancavelica", "Huanuco", "Ica", "Junin", "La Libertad", "Lambayeque", "Lima", "Loreto", "Madre De Dios", "Moquegua", "Pasco", "Piura", "Puno", "San Martin", "Tacna", "Tumbes", "Ucayali"}));
		cboDepartamento.setBounds(96, 250, 137, 21);
		contentPane.add(cboDepartamento);
		tblAlmacen.addMouseListener(this);		
		cargarTable();
		
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNuevo) {
			actionPerformedBtnNuevo(e);
		}
		if (e.getSource() == btnActualizar) {
			do_btnActualizar_actionPerformed(e);
		}
		if (e.getSource() == btnEliminar) {
			do_btnEliminar_actionPerformed(e);
		}
		if (e.getSource() == btnRegistrar) {
			actionPerformedbtnRegistrar(e);
		}
	}
	
	protected void actionPerformedbtnRegistrar(ActionEvent e) {
		ingresar();
	}

	private void ingresar() {

		String direcc, email, departamento, telef;
		int numero, capacidad;

		numero = generarNumeroAlmacen();
		direcc = leerDireccion();
		telef = leerTelefono();
		email = leerEmail();
		capacidad = leerCapacidad();
		departamento = leerDepartamento();

		if (numero == -1 ||direcc == null || email == null || telef == null || capacidad == -1 || departamento == null) {
			return;
		} else {
			Almacen al = new Almacen();
			al.setNum_alm(numero);
			al.setDir_alm(direcc);
			al.setFon_alm(telef);
			al.setEmail_alm(email);
			al.setCap_alm(capacidad);
			al.setDpto_alm(departamento);
			int result = gAlmacen.registrarAlmacen(al);
			if (result != 0) {
				JOptionPane.showMessageDialog(null, "Almacen registrado exitosamente");
				cargarTable();
			} else {
				JOptionPane.showMessageDialog(null, "No se pudo registrar el almacen");
			}
		}
	}
	
	private int generarNumeroAlmacen() {
		int codeLastAlmacen = 0;
		if (tblAlmacen.getRowCount() == 0) {
			return codeLastAlmacen = 1;
		} else {
			codeLastAlmacen = (int) tblAlmacen.getValueAt(tblAlmacen.getRowCount() - 1, 0);
			int FinalCode = codeLastAlmacen+1;
			return FinalCode;
		}
	}

	public void cargarTable() {
		model = new DefaultTableModel();
		model.addColumn("Numero");
		model.addColumn("Direccion");
		model.addColumn("Telefono");
		model.addColumn("Email");
		model.addColumn("Capacidad");
		model.addColumn("Departamento");
		ArrayList<Almacen> list = gAlmacen.listarAlmacen();
		if (list.size() != 0) {
			for (Almacen am : list) {
				Object[] row = { am.getNum_alm(), am.getDir_alm(), am.getFon_alm(), am.getEmail_alm(), am.getCap_alm(),
						am.getDpto_alm() };
				model.addRow(row);
			}
		} else {
			JOptionPane.showMessageDialog(null, "Lista vacia!");
		}
				
		tblAlmacen.setModel(model);
	}

	private String leerTelefono() {
		String leertelef = null;
		if (txtTelefono.getText().length() == 0) {
			mensajeError("Ingresa el numero de telefono");
		} else {
			leertelef = txtTelefono.getText().trim();
		}
		return leertelef;
	}

	private int leerNumero() {
		int num = -1;
		if (txtNumero.getText().length() == 0) {
			mensajeError("Ingresa el Numero");
		} else {
			num = Integer.parseInt(txtNumero.getText());
		}
		return num;
	}

	String leerDepartamento() {
		String departamentos = null;
		// validar caja vacia
		if (cboDepartamento.getSelectedItem().toString().trim().length() == 0) {
			mensajeError("Seleccione el Departamento");
		} else{
			departamentos = cboDepartamento.getSelectedItem().toString();		
		}
		return departamentos;
	}

	private int leerCapacidad() {
		int capa = -1;
		if (txtCapacidad.getText().length() == 0) {
			mensajeError("Ingresa la capacidad");
		} else {
			capa = Integer.parseInt(txtCapacidad.getText());
		}
		return capa;
	}

	private String leerEmail() {
		String email = null;
		if (txtEmail.getText().trim().length() == 0) {
			mensajeError("Ingresa el email");
			txtEmail.requestFocus();
		} else if (txtEmail.getText().trim().matches(Validaciones.EmailPersonal)) {
			email = txtEmail.getText().trim();
		} else {
			mensajeError("Formato incorrecto !! de 10 a 30 caracteres");
			txtEmail.setText("");
			txtEmail.requestFocus();

		}
		return email;
	}

	private String leerDireccion() {
		String direcc = null;
		if (txtDireccion.getText().trim().length() == 0) {
			mensajeError("Ingresa la dirección");
			txtDireccion.requestFocus();
		} else if (txtDireccion.getText().trim().matches(Validaciones.DireccionPersonal)) {
			direcc = txtDireccion.getText().trim();
		}
		return direcc;
	}

	private void mensajeError(String msj) {
		JOptionPane.showMessageDialog(this, msj, "Error !!", 0);
	}

	private void MostrarDatos(int fila) {

		try {
			String direcc, email, departamento, numero, telef, capacidad;

			numero = tblAlmacen.getValueAt(fila, 0).toString();
			direcc = tblAlmacen.getValueAt(fila, 1).toString();
			telef = tblAlmacen.getValueAt(fila, 2).toString();
			email = tblAlmacen.getValueAt(fila, 3).toString();
			capacidad = tblAlmacen.getValueAt(fila, 4).toString();
			departamento = tblAlmacen.getValueAt(fila, 5).toString();

			txtNumero.setText(numero);
			cboDepartamento.setSelectedItem(departamento);
			txtTelefono.setText(telef);
			txtCapacidad.setText(capacidad);
			txtEmail.setText(email);
			txtDireccion.setText(direcc);
		} catch (Exception e) {
			mensajeError("No existen datos en la tabla");
		}

	}

	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == tblAlmacen) {
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
		int fila = tblAlmacen.getSelectedRow();
		MostrarDatos(fila);

	}

	protected void do_btnEliminar_actionPerformed(ActionEvent e) {
		int rowSelection = tblAlmacen.getSelectedRow();
		if (rowSelection != -1) {
			int result = JOptionPane.showConfirmDialog(null, "¿Seguro que desea continuar?", "ADVERTENCIA",
					JOptionPane.YES_NO_OPTION);
			if(result == 0) {
				gAlmacen.eliminarALmacen(Integer.parseInt(tblAlmacen.getValueAt(rowSelection, 0)+""));
				cargarTable();
			}
		}
	}
	protected void do_btnActualizar_actionPerformed(ActionEvent e) {


		String direcc, email, departamento, telef;
		int capacidad, numero;

		numero = leerNumero();
		direcc = leerDireccion();
		telef = leerTelefono();
		email = leerEmail();
		capacidad = leerCapacidad();
		departamento = leerDepartamento();

		if (direcc == null || email == null || telef == null || capacidad == -1 || departamento == null) {
			return;
		} else {
			Almacen al = new Almacen();
			al.setDir_alm(direcc);
			al.setFon_alm(telef);
			al.setEmail_alm(email);
			al.setCap_alm(capacidad);
			al.setDpto_alm(departamento);
			al.setNum_alm(numero);
			int result = gAlmacen.actualizarAlmacen(al);
			if (result != 0) {
				mensajeError("Almacen Actualizado exitosamente");
				cargarTable();
			} else {
				mensajeError("No se pudo Actualizar el almacen");
			}
		}
	
	}
	protected void actionPerformedBtnNuevo(ActionEvent e) {
		txtNumero.setText(generarNumeroAlmacen()+"");
		cboDepartamento.setSelectedIndex(0);
		txtTelefono.setText("");
		txtCapacidad.setText("");
		txtEmail.setText("");
		txtDireccion.setText("");
		txtNumero.requestFocus();		
	}
}
