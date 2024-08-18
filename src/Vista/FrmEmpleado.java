package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import Entidad.Empleado;
import Mantenimiento.EmpleadoGestionDAO;
import Utils.Validaciones;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.Toolkit;

public class FrmEmpleado extends JFrame implements MouseListener, ActionListener {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtSueldo;
	private JTextField txtDireccion;
	private JTextField txtTelefono;
	private JTextField txtEmail;
	private JComboBox cboCargo;
	private JTable tbEmpleado;
	private JButton btnEliminar;
	private JButton btnActualizar;

	DefaultTableModel modelo = new DefaultTableModel();
	EmpleadoGestionDAO gEmp = new EmpleadoGestionDAO();
	private JButton btnLimpiar;
	private JTextField txtCodigo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmEmpleado frame = new FrmEmpleado();
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
	public FrmEmpleado() {
		setResizable(false);
		setTitle("TOYOTA - Mantenimiento Empleado");
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrmEmpleado.class.getResource("/img/toyo_log.png")));
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 979, 325);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);

		JLabel lblRegistroDeUsuario = new JLabel("   Mantenimiento de Empleado");
		lblRegistroDeUsuario.setIcon(new ImageIcon(FrmEmpleado.class.getResource("/img/Empleado.png")));
		lblRegistroDeUsuario.setForeground(Color.BLACK);
		lblRegistroDeUsuario.setOpaque(true);
		lblRegistroDeUsuario.setBackground(Color.LIGHT_GRAY);
		lblRegistroDeUsuario.setFont(new Font("Cambria", Font.BOLD, 20));
		lblRegistroDeUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistroDeUsuario.setBounds(10, 13, 406, 32);
		contentPane.add(lblRegistroDeUsuario);

		JLabel lblCdigo = new JLabel("C\u00F3digo:");
		lblCdigo.setBounds(10, 54, 67, 14);
		contentPane.add(lblCdigo);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(10, 79, 67, 14);
		contentPane.add(lblNombre);

		txtNombre = new JTextField();
		txtNombre.setBorder(null);
		txtNombre.setBounds(87, 76, 130, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);

		txtSueldo = new JTextField();
		txtSueldo.setBorder(null);
		txtSueldo.setColumns(10);
		txtSueldo.setBounds(87, 137, 130, 20);
		contentPane.add(txtSueldo);

		JButton btnRegistrar = new JButton("GUARDAR");
		btnRegistrar.setPressedIcon(new ImageIcon(FrmEmpleado.class.getResource("/img/abrir2.png")));
		btnRegistrar.setIcon(new ImageIcon(FrmEmpleado.class.getResource("/img/abrir.png")));
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				registrarDatos();
			}
		});
		btnRegistrar.setBounds(545, 9, 123, 40);
		contentPane.add(btnRegistrar);

		btnLimpiar = new JButton("NUEVO");
		btnLimpiar.addActionListener(this);
		btnLimpiar.setPressedIcon(new ImageIcon(FrmEmpleado.class.getResource("/img/new2.png")));
		btnLimpiar.setIcon(new ImageIcon(FrmEmpleado.class.getResource("/img/Limpiar.png")));
		btnLimpiar.setBounds(426, 9, 109, 40);
		contentPane.add(btnLimpiar);

		JLabel lblCargo = new JLabel("Cargo:");
		lblCargo.setBounds(10, 109, 67, 14);
		contentPane.add(lblCargo);

		JLabel lblNewLabel = new JLabel("Sueldo:");
		lblNewLabel.setBounds(10, 139, 67, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_2 = new JLabel("Direccion:");
		lblNewLabel_2.setBounds(10, 169, 67, 14);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Telefono:");
		lblNewLabel_3.setBounds(10, 199, 67, 14);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Email:");
		lblNewLabel_4.setBounds(10, 229, 67, 14);
		contentPane.add(lblNewLabel_4);

		txtDireccion = new JTextField();
		txtDireccion.setBorder(null);
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(87, 167, 130, 20);
		contentPane.add(txtDireccion);

		txtTelefono = new JTextField();
		txtTelefono.setBorder(null);
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(87, 197, 130, 20);
		contentPane.add(txtTelefono);

		txtEmail = new JTextField();
		txtEmail.setBorder(null);
		txtEmail.setColumns(10);
		txtEmail.setBounds(87, 226, 130, 20);
		contentPane.add(txtEmail);

		cboCargo = new JComboBox();
		cboCargo.setModel(new DefaultComboBoxModel(
				new String[] { "Seleccione....", "Gerente", "Sub Gerente", "Secretario/a", "Asistente" }));
		cboCargo.setBounds(87, 106, 130, 20);
		contentPane.add(cboCargo);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(227, 56, 726, 219);
		contentPane.add(scrollPane);

		tbEmpleado = new JTable();
		tbEmpleado.addMouseListener(this);
		scrollPane.setViewportView(tbEmpleado);

		btnEliminar = new JButton("ELIMINAR");
		btnEliminar.addActionListener(this);
		btnEliminar.setPressedIcon(new ImageIcon(FrmEmpleado.class.getResource("/img/delete2.png")));
		btnEliminar.setIcon(new ImageIcon(FrmEmpleado.class.getResource("/img/delete.png")));
		btnEliminar.setBounds(678, 9, 123, 40);
		contentPane.add(btnEliminar);

		btnActualizar = new JButton("ACTUALIZAR");
		btnActualizar.addActionListener(this);
		btnActualizar.setPressedIcon(new ImageIcon(FrmEmpleado.class.getResource("/img/sync2.png")));
		btnActualizar.setIcon(new ImageIcon(FrmEmpleado.class.getResource("/img/sync.png")));
		btnActualizar.setBounds(811, 9, 142, 40);
		contentPane.add(btnActualizar);
		
		txtCodigo = new JTextField();
		txtCodigo.setEditable(false);
		txtCodigo.setBounds(87, 51, 130, 20);
		contentPane.add(txtCodigo);
		txtCodigo.setColumns(10);

		modelo.addColumn("CODIGO");
		modelo.addColumn("NOMBRE");
		modelo.addColumn("CARGO");
		modelo.addColumn("SUELDO");
		modelo.addColumn("DIRECCION");
		modelo.addColumn("TELEFONO");
		modelo.addColumn("EMAIL");

		cargarTabla();
	}

	private void registrarDatos() {
		if (txtNombre.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(null, "El campo NOMBRE esta vacio!");
		} else if (!txtNombre.getText().trim().matches(Validaciones.NombrePersonal)) {
			JOptionPane.showMessageDialog(null,
					"El campo NOMBRE no cumple con el formato requerido!\nSolo caracteres alfabeticos hasta un maximo de 20 \ny minimo 3 caracteres");
		}  else if (cboCargo.getSelectedIndex() == 0) {
			JOptionPane.showMessageDialog(null, "Debe seleccionar un cargo!");
		} else if (txtSueldo.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(null, "El campo SUELDO esta vacio!");
		} else if (txtTelefono.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(null, "El campo TELEFONO esta vacio!");
		} else if (!txtTelefono.getText().matches(Validaciones.TelefonoPersonal)) {
			JOptionPane.showMessageDialog(null, "El campo TELEFONO Debe tener 9 Numeros!");
		} else if (txtDireccion.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(null, "El campo DIRECCION esta vacio!");
		} else if (txtEmail.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(null, "El campo CORREO esta vacio!");
		} else if (!txtDireccion.getText().trim().matches(Validaciones.DireccionPersonal)) {
			JOptionPane.showMessageDialog(null,
					"El campo DIRECCION no cumple con el formato requerido!\nMaximo 30 caracteres");
		} else if (!txtEmail.getText().trim().matches(Validaciones.EmailPersonal)) {
			JOptionPane.showMessageDialog(null, "El campo CORREO no cumple con el formato requerido!");
		} else {
			Empleado emple = new Empleado();
			emple.setCod_emple(generarCodigoEmpleado());
			emple.setNom_emple(txtNombre.getText().trim());
			emple.setCar_emple(cboCargo.getSelectedItem() + "");
			emple.setSueldo_emple(Double.parseDouble(txtSueldo.getText().trim()));
			emple.setDir_emple(txtDireccion.getText().trim());
			emple.setTel_emple(txtTelefono.getText().trim());
			emple.setEmail_emple(txtEmail.getText().trim());

			int result = gEmp.registrarEmpleado(emple);
			if (result != 0) {
				JOptionPane.showMessageDialog(null, "Se registro el empleado satisfactoriamente");
				cargarTabla();
			}
		}

	}

	private String generarCodigoEmpleado() {
		String codeLastEmple = "";
		if (tbEmpleado.getRowCount() == 0) {
			codeLastEmple = "EMP001";
		} else {
			codeLastEmple = tbEmpleado.getValueAt(tbEmpleado.getRowCount() - 1, 0) + "";
		}
		String newCode = "";
		for (char ss : codeLastEmple.toCharArray()) {
			if (!String.valueOf(ss).equalsIgnoreCase("E") && !String.valueOf(ss).equalsIgnoreCase("M")
					&& !String.valueOf(ss).equalsIgnoreCase("P")) {
				newCode += String.valueOf(ss);
			}
		}
		int num = Integer.parseInt(newCode);
		String FinalCode = "";
		if (num < 10) {
			FinalCode = "EMP01" + (num + 1);
		} else if (num < 100) {
			FinalCode = "EMP0" + (num + 1);
		} else if (num < 1000) {
			FinalCode = "EMP" + (num + 1);
		}
		return FinalCode;
	}

	private void cargarTabla() {
		modelo.setRowCount(0);
		ArrayList<Empleado> listEmp = gEmp.listarEmpleado();
		for (Empleado emp : listEmp) {
			Object[] row = { emp.getCod_emple(), emp.getNom_emple(), emp.getCar_emple(),
					emp.getSueldo_emple(), emp.getDir_emple(), emp.getTel_emple(), emp.getEmail_emple() };
			modelo.addRow(row);
		}
		tbEmpleado.setModel(modelo);
	}

	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == tbEmpleado) {
			do_tbEmpleado_mouseClicked(e);
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

	protected void do_tbEmpleado_mouseClicked(MouseEvent e) {
		int numRow = tbEmpleado.getSelectedRow();
		
		txtCodigo.setText(tbEmpleado.getValueAt(numRow, 0) + "");
		txtNombre.setText(tbEmpleado.getValueAt(numRow, 1) + "");
		cboCargo.setSelectedItem(tbEmpleado.getValueAt(numRow, 2) + "");
		txtSueldo.setText(tbEmpleado.getValueAt(numRow, 3) + "");
		txtDireccion.setText(tbEmpleado.getValueAt(numRow, 4) + "");
		txtTelefono.setText(tbEmpleado.getValueAt(numRow, 5) + "");
		txtEmail.setText(tbEmpleado.getValueAt(numRow, 6) + "");
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnActualizar) {
			do_btnActualizar_actionPerformed(e);
		}
		if (e.getSource() == btnEliminar) {
			do_btnEliminar_actionPerformed(e);
		}
		if (e.getSource() == btnLimpiar) {
			do_btnLimpiar_actionPerformed(e);
		}
	}

	protected void do_btnLimpiar_actionPerformed(ActionEvent e) {
		txtCodigo.setText(generarCodigoEmpleado());
		txtNombre.setText("");
		cboCargo.setSelectedIndex(0);
		txtSueldo.setText("");
		txtDireccion.setText("");
		txtTelefono.setText("");
		txtEmail.setText("");
	}

	protected void do_btnEliminar_actionPerformed(ActionEvent e) {
		int selection = tbEmpleado.getSelectedRow();
		if (selection != -1) {
			int condicion = JOptionPane.showConfirmDialog(null, "¿Seguro que desea eliminar al empleado seleccionado?",
					"ADVERTENCIA", JOptionPane.YES_NO_OPTION);
			if (condicion == 0) {
				int result = gEmp.eliminarEmpleado(tbEmpleado.getValueAt(selection, 0) + "");
				if (result != 0) {
					JOptionPane.showMessageDialog(null, "Se ha eliminado al empleado satisfactoriamente");
					cargarTabla();
				}
			}
		} else {
			JOptionPane.showMessageDialog(null, "Selecciona un empleado");
		}
	}

	protected void do_btnActualizar_actionPerformed(ActionEvent e) {

		ActualizarDatos();
	}

	private void ActualizarDatos() {
		int rowSelection = tbEmpleado.getSelectedRow();
		if(rowSelection != -1) {
			if (txtNombre.getText().trim().equals("")) {
				JOptionPane.showMessageDialog(null, "El campo NOMBRE esta vacio!");
			} else if (!txtNombre.getText().trim().matches(Validaciones.NombrePersonal)) {
				JOptionPane.showMessageDialog(null,
						"El campo NOMBRE no cumple con el formato requerido!\nSolo caracteres alfabeticos hasta un maximo de 20 \ny minimo 3 caracteres");
			} else if (cboCargo.getSelectedIndex() == 0) {
				JOptionPane.showMessageDialog(null, "Debe seleccionar un cargo!");
			} else if (txtSueldo.getText().trim().equals("")) {
				JOptionPane.showMessageDialog(null, "El campo SUELDO esta vacio!");
			} else if (txtTelefono.getText().trim().equals("")) {
				JOptionPane.showMessageDialog(null, "El campo TELEFONO esta vacio!");
			} else if (!txtTelefono.getText().matches(Validaciones.TelefonoPersonal)) {
				JOptionPane.showMessageDialog(null, "El campo TELEFONO Debe tener 9 Numeros!");
			} else if (txtDireccion.getText().trim().equals("")) {
				JOptionPane.showMessageDialog(null, "El campo DIRECCION esta vacio!");
			} else if (txtEmail.getText().trim().equals("")) {
				JOptionPane.showMessageDialog(null, "El campo CORREO esta vacio!");
			} else if (!txtDireccion.getText().trim().matches(Validaciones.DireccionPersonal)) {
				JOptionPane.showMessageDialog(null,
						"El campo DIRECCION no cumple con el formato requerido!\nMaximo 30 caracteres");
			} else if (!txtEmail.getText().trim().matches(Validaciones.EmailPersonal)) {
				JOptionPane.showMessageDialog(null, "El campo CORREO no cumple con el formato requerido!");
			}  else {
				Empleado emple = new Empleado();
				emple.setCod_emple(tbEmpleado.getValueAt(rowSelection, 0)+"");
				emple.setNom_emple(txtNombre.getText().trim());
				emple.setCar_emple(cboCargo.getSelectedItem() + "");
				emple.setSueldo_emple(Double.parseDouble(txtSueldo.getText().trim()));
				emple.setDir_emple(txtDireccion.getText().trim());
				emple.setTel_emple(txtTelefono.getText().trim());
				emple.setEmail_emple(txtEmail.getText().trim());

				int result = gEmp.actualizarEmpleado(emple);
				if (result != 0) {
					JOptionPane.showMessageDialog(null, "Se Actualizo el empleado satisfactoriamente");
					cargarTabla();
				}
			}

		
		}else {
			JOptionPane.showMessageDialog(null, "Debe seleccionar un empleado");
		}
	}
}
