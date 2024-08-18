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
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import Utils.Validaciones;
import Entidad.Almacen;
import Entidad.Vehiculo;
import Mantenimiento.VehiculoGestionDAO;

import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;

public class FrmVehiculo extends JFrame implements ActionListener, MouseListener {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblModelo;
	private JLabel lblNombre;
	private JLabel lblCilindros;
	private JLabel lblPeso;
	private JLabel lblTipoDeTransporte;
	private JLabel lblGps;
	private JLabel lblAsientos;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JTextField txtId;
	private JComboBox cboModelo;
	private JTextField txtMotor;
	private JTextField txtCilindros;
	private JTextField txtPesoneto;
	private JComboBox cboTransporte;
	private JTextField txtGPS;
	private JTextField txtAsientos;
	private JTextField txtYear;
	private JTable tbVehiculos;
	private JScrollPane scrollPane;
	private JButton btnRegistrar;
	private JButton btnActualizar;
	private JButton btnLimpiar;
	private JButton btnBorrar;
	private JComboBox cboAirbag;

	DefaultTableModel model = new DefaultTableModel();
	VehiculoGestionDAO gVehiculo = new VehiculoGestionDAO();

	private JLabel lblPesoBruto;
	private JTextField txtPesobruto;
	private JLabel lblNewLabel_3;
	private JComboBox cboCombustible;
	private JLabel lblMantenimientoDeVehculo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmVehiculo frame = new FrmVehiculo();
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
	public FrmVehiculo() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrmVehiculo.class.getResource("/img/toyo_log.png")));
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		setTitle("TOYOTA - Mantenimiento Veh\u00EDculo");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1036, 452);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblNewLabel = new JLabel("ID Auto");
		lblNewLabel.setBounds(10, 67, 116, 13);
		contentPane.add(lblNewLabel);

		lblModelo = new JLabel("Nombre Modelo");
		lblModelo.setBounds(10, 97, 116, 13);
		contentPane.add(lblModelo);

		lblNombre = new JLabel("Motor");
		lblNombre.setBounds(10, 127, 116, 13);
		contentPane.add(lblNombre);

		lblCilindros = new JLabel("Cilindros");
		lblCilindros.setBounds(10, 156, 116, 13);
		contentPane.add(lblCilindros);

		lblPeso = new JLabel("Peso Neto");
		lblPeso.setBounds(10, 185, 116, 13);
		contentPane.add(lblPeso);

		lblTipoDeTransporte = new JLabel("Tipo de Transmision");
		lblTipoDeTransporte.setBounds(10, 244, 116, 13);
		contentPane.add(lblTipoDeTransporte);

		lblGps = new JLabel("GPS");
		lblGps.setBounds(10, 271, 116, 13);
		contentPane.add(lblGps);

		lblAsientos = new JLabel("Asientos");
		lblAsientos.setBounds(10, 331, 116, 13);
		contentPane.add(lblAsientos);

		lblNewLabel_1 = new JLabel("Airbag");
		lblNewLabel_1.setBounds(10, 301, 116, 13);
		contentPane.add(lblNewLabel_1);

		lblNewLabel_2 = new JLabel("A\u00F1o");
		lblNewLabel_2.setBounds(10, 391, 116, 13);
		contentPane.add(lblNewLabel_2);

		txtId = new JTextField();
		txtId.setEditable(false);
		txtId.setBounds(134, 64, 96, 19);
		contentPane.add(txtId);
		txtId.setColumns(10);

		cboModelo = new JComboBox();
		cboModelo.setModel(new DefaultComboBoxModel(new String[] {"Seleccione...", "Hilux", "Corolla", "Yaris", "Hyundai", "Toyota", "aGYA", "Avanza", "Etios", "Fortuner", "Hiace", "4Runner", "Rav4"}));
		cboModelo.setBounds(134, 93, 96, 21);
		contentPane.add(cboModelo);

		txtMotor = new JTextField();
		txtMotor.setBounds(134, 124, 96, 19);
		contentPane.add(txtMotor);
		txtMotor.setColumns(10);

		txtCilindros = new JTextField();
		txtCilindros.setColumns(10);
		txtCilindros.setBounds(134, 153, 96, 19);
		contentPane.add(txtCilindros);

		txtPesoneto = new JTextField();
		txtPesoneto.setColumns(10);
		txtPesoneto.setBounds(134, 182, 96, 19);
		contentPane.add(txtPesoneto);

		cboTransporte = new JComboBox();
		cboTransporte.setModel(new DefaultComboBoxModel(new String[] {"Seleccione...", "Autom\u00E1tica", "Mec\u00E1nica"}));
		cboTransporte.setBounds(134, 240, 96, 21);
		contentPane.add(cboTransporte);

		txtGPS = new JTextField();
		txtGPS.setColumns(10);
		txtGPS.setBounds(134, 268, 96, 19);
		contentPane.add(txtGPS);

		txtAsientos = new JTextField();
		txtAsientos.setColumns(10);
		txtAsientos.setBounds(134, 328, 96, 19);
		contentPane.add(txtAsientos);

		txtYear = new JTextField();
		txtYear.setColumns(10);
		txtYear.setBounds(134, 388, 96, 19);
		contentPane.add(txtYear);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(240, 63, 769, 341);
		contentPane.add(scrollPane);

		tbVehiculos = new JTable();
		tbVehiculos.addMouseListener(this);
		scrollPane.setViewportView(tbVehiculos);
		tbVehiculos.setModel(new DefaultTableModel(new Object[][] {}, new String[] {}));
		tbVehiculos.setFillsViewportHeight(true);

		btnRegistrar = new JButton("REGISTRAR");
		btnRegistrar.setPressedIcon(new ImageIcon(FrmVehiculo.class.getResource("/img/abrir2.png")));
		btnRegistrar.setIcon(new ImageIcon(FrmVehiculo.class.getResource("/img/abrir.png")));
		btnRegistrar.addActionListener(this);
		btnRegistrar.setBounds(603, 13, 131, 40);
		contentPane.add(btnRegistrar);

		btnActualizar = new JButton("ACTUALIZAR");
		btnActualizar.setIcon(new ImageIcon(FrmVehiculo.class.getResource("/img/sync.png")));
		btnActualizar.setPressedIcon(new ImageIcon(FrmVehiculo.class.getResource("/img/sync2.png")));
		btnActualizar.setBounds(744, 13, 131, 40);
		contentPane.add(btnActualizar);

		btnLimpiar = new JButton("NUEVO");
		btnLimpiar.setPressedIcon(new ImageIcon(FrmVehiculo.class.getResource("/img/new2.png")));
		btnLimpiar.setIcon(new ImageIcon(FrmVehiculo.class.getResource("/img/Limpiar.png")));
		btnLimpiar.addActionListener(this);
		btnLimpiar.setBounds(462, 13, 131, 40);
		contentPane.add(btnLimpiar);

		btnBorrar = new JButton("BORRAR");
		btnBorrar.addActionListener(this);
		btnBorrar.setIcon(new ImageIcon(FrmVehiculo.class.getResource("/img/delete.png")));
		btnBorrar.setPressedIcon(new ImageIcon(FrmVehiculo.class.getResource("/img/delete2.png")));
		btnBorrar.setBounds(885, 13, 124, 40);
		contentPane.add(btnBorrar);

		cboAirbag = new JComboBox();
		cboAirbag.setModel(new DefaultComboBoxModel(new String[] {"Selecccione...", "SI", "NO"}));
		cboAirbag.setBounds(134, 297, 96, 21);
		contentPane.add(cboAirbag);

		model.addColumn("ID AUTO");
		model.addColumn("MODELO");
		model.addColumn("MOTOR");
		model.addColumn("CILINDRO");
		model.addColumn("PESO NETO");
		model.addColumn("PESO BRUTO");
		model.addColumn("TIPO TRANSPORTE");
		model.addColumn("GPS");
		model.addColumn("AIRBAG");
		model.addColumn("ASIENTOS");
		model.addColumn("COMBUSTIBLE");
		model.addColumn("A�O");

		tbVehiculos.setModel(model);

		lblPesoBruto = new JLabel("Peso Bruto");
		lblPesoBruto.setBounds(10, 214, 116, 13);
		contentPane.add(lblPesoBruto);

		txtPesobruto = new JTextField();
		txtPesobruto.setColumns(10);
		txtPesobruto.setBounds(134, 211, 96, 19);
		contentPane.add(txtPesobruto);

		lblNewLabel_3 = new JLabel("Combustible");
		lblNewLabel_3.setBounds(10, 361, 116, 13);
		contentPane.add(lblNewLabel_3);

		cboCombustible = new JComboBox();
		cboCombustible
				.setModel(new DefaultComboBoxModel(new String[] { "Seleccione...", "Gasolina", "Gas", "Petroleo" }));
		cboCombustible.setBounds(134, 357, 96, 21);
		contentPane.add(cboCombustible);
		
		lblMantenimientoDeVehculo = new JLabel("   Mantenimiento de Veh\u00EDculo");
		lblMantenimientoDeVehculo.setIcon(new ImageIcon(FrmVehiculo.class.getResource("/img/Veh\u00EDculo.png")));
		lblMantenimientoDeVehculo.setForeground(Color.BLACK);
		lblMantenimientoDeVehculo.setOpaque(true);
		lblMantenimientoDeVehculo.setHorizontalAlignment(SwingConstants.CENTER);
		lblMantenimientoDeVehculo.setFont(new Font("Cambria", Font.BOLD, 20));
		lblMantenimientoDeVehculo.setBackground(Color.LIGHT_GRAY);
		lblMantenimientoDeVehculo.setBounds(10, 13, 442, 32);
		contentPane.add(lblMantenimientoDeVehculo);
		cargarTable();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnBorrar) {
			actionPerformedBtnBorrar(e);
		}
		if (e.getSource() == btnLimpiar) {
			actionPerformedBtnLimpiar(e);
		}
		if (e.getSource() == btnRegistrar) {
			actionPerformedBtnRegistrar(e);
		}
	}

	protected void actionPerformedBtnRegistrar(ActionEvent e) {
		ingresar();
	}

	private void cargarTable() {
		model.setRowCount(0);
		ArrayList<Vehiculo> list = gVehiculo.listarVehiculo();
		if (list.size() != 0) {
			for (Vehiculo vehi : list) {
				Object[] row = { vehi.getId(), vehi.getNommodel(), vehi.getMotor(), vehi.getCilindros(),
						vehi.getPesoneto(), vehi.getPesobruto(), vehi.getTiptransmision(), vehi.getGps(),
						vehi.getSinoairbag(), vehi.getAsientos(), vehi.getTipcombustible(), vehi.getYear() };
				model.addRow(row);
			}
			tbVehiculos.setModel(model);
		} else {
			JOptionPane.showMessageDialog(null, "Lista vacia!");
		}
	}

	void ingresar() {

		String nommodel, motor, tiptransporte, gps, sinoairbag, tipcombustible;
		double pesoneto;
		double pesobruto;
		int asientos, year;
		int cilindros;

		nommodel = leerNombreModelo();
		motor = leerMotor();
		cilindros = leerCilindros();
		pesoneto = leerPesoneto();
		pesobruto = leerPesobruto();
		tiptransporte = leerTipoTransporte();
		gps = leerGPS();
		sinoairbag = leerSinoAirbag();
		asientos = leerAsientos();
		tipcombustible = leerTipoCombustible();
		year = leerYear();

		if (nommodel == null || motor == null || cilindros == -1 || pesoneto == -1 || pesobruto == -1
				|| tiptransporte == null || gps == null || sinoairbag == null || asientos == -1
				|| tipcombustible == null || year == -1) {
			return;

		} else {
			Vehiculo vehi = new Vehiculo();
			vehi.setId(generarCodigoVehiculo());
			vehi.setNommodel(nommodel);
			vehi.setMotor(motor);
			vehi.setCilindros(cilindros);
			vehi.setPesoneto(pesoneto);
			vehi.setPesobruto(pesobruto);
			vehi.setTiptransporte(tiptransporte);
			vehi.setGps(gps);
			vehi.setSinoairbag(sinoairbag);
			vehi.setAsientos(asientos);
			vehi.setTipcombustible(tipcombustible);
			vehi.setYear(year + "");

			int result = gVehiculo.registrarVehiculo(vehi);
			if (result != 0) {
				JOptionPane.showMessageDialog(null, "Almacen registrado exitosamente");
				cargarTable();
			} else {
				JOptionPane.showMessageDialog(null, "No se pudo registrar el almacen");
			}
		}
	}

	private String leerTipoCombustible() {
		return cboCombustible.getSelectedItem().toString();
	}

	int leerCombustible() {
		int combustible = -1;
		combustible = cboCombustible.getSelectedIndex();
		if (combustible == 0) {
			mensajeError("Selecciona el tipo de combustible");
		}
		return combustible;
	}

	int leerAirbag() {
		// TODO Auto-generated method stub
		int airbag;

		airbag = cboAirbag.getSelectedIndex();
		if (airbag == 0) {
			mensajeError("Selecciona una de la 2 opciones");
		}

		return airbag;
	}

	private String leerSinoAirbag() {
		// TODO Auto-generated method stub
		return cboAirbag.getSelectedItem().toString();
	}

	double leerPesobruto() {
		// TODO Auto-generated method stub
		return Double.parseDouble(txtPesobruto.getText());
	}

	int leerCilindros() {
		// TODO Auto-generated method stub
		int cilindros = 0;
		if (txtCilindros.getText().length() == 0) {
			mensajeError("Ingresa la cantidad de Cilindros");
		} else {
			cilindros = Integer.parseInt(txtCilindros.getText());
		}
		return cilindros;
	}

	int leerTransmision() {
		// TODO Auto-generated method stub
		int transmision;
		transmision = cboAirbag.getSelectedIndex();
		if (transmision == 0) {
			mensajeError("Selecciona el tipo de Transporte");
		}
		return transmision;
	}

	int leerTransporte() {

		int transporte;
		transporte = cboTransporte.getSelectedIndex();
		if (transporte == 0) {
			mensajeError("Selecciona el tipo de Transporte");
		}
		return transporte;
	}

	int leerModelo() {
		// TODO Auto-generated method stub
		int modelo;
		modelo = cboModelo.getSelectedIndex();
		if (modelo == 0) {
			mensajeError("Selecciona el Modelo");
		}
		return modelo;
	}

	int leerYear() {
		// TODO Auto-generated method stub
		int año = -1;
		if (txtYear.getText().length() == 0) {
			mensajeError("Ingresa el año");
		} else {
			año = Integer.parseInt(txtYear.getText());
		}
		return año;
	}

	int leerAsientos() {
		// TODO Auto-generated method stub
		int asientos = -1;
		if (txtAsientos.getText().length() == 0) {
			mensajeError("Ingresa la cantidad de asientos");
		} else {
			asientos = Integer.parseInt(txtAsientos.getText());
		}
		return asientos;
	}

	double leerPesoneto() {
		// TODO Auto-generated method stub
		return Double.parseDouble(txtPesoneto.getText());
	}

	private String leerId() {
		String id = null;
		// validar caja vacia
		if (txtId.getText().trim().length() == 8) {
			mensajeError("Ingresar c�digo de producto");
			txtId.requestFocus();
		} else if (txtId.getText().trim().matches(Validaciones.IdVehiculo)) {
			id = txtId.getText().trim();

		} else {
			mensajeError("Formato incorrecto!! Ejm P0001 o p0001");
			txtId.setText("");
			txtId.requestFocus();
		}
		return id;
	}

	private String leerNombreTransmision() {
		// TODO Auto-generated method stub
		return cboAirbag.getSelectedItem().toString();
	}

	private String leerGPS() {
		String gps = null;
		/// validar caja vacia
		if (txtGPS.getText().trim().length() == 0) {
			mensajeError("Ingresar nombre de producto");
			txtGPS.requestFocus();
		} else if (txtGPS.getText().trim().length()==2) {
			gps = txtGPS.getText().trim();

		} else {
			mensajeError("Formato incorrecto!! solo 2 caracteres");
			txtGPS.setText("");
			txtGPS.requestFocus();
		}
		return gps;
	}

	private String leerTipoTransporte() {
		// TODO Auto-generated method stub
		return cboTransporte.getSelectedItem().toString();
	}

	private String leerMotor() {
		String motor = null;
		if (txtMotor.getText().trim().length() == 0) {
			mensajeError("Ingrese el nombre del Motor");
			txtMotor.requestFocus();
		} else if (txtMotor.getText().trim().matches(Validaciones.MotorNombre)) {
			motor = txtMotor.getText().trim();
		} else {
			mensajeError("Formato incorrecto!! como minimo 4 caracteres");
			txtMotor.setText("");
			txtMotor.requestFocus();
		}
		return motor;
	}

	private String leerNombreModelo() {
		// TODO Auto-generated method stub
		return cboModelo.getSelectedItem().toString();
	}

	private void mensajeError(String msg) {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(this, msg, "Error", 0);

	}

	void MostrarDatos(int fila) {

		String id, modelo, motor, gps, pesoNeto, sinoairbag, combustible, pesoBruto, asientos, year, transporte, cilindros;

		id = tbVehiculos.getValueAt(fila, 0).toString();
		modelo = tbVehiculos.getValueAt(fila, 1).toString();
		motor = tbVehiculos.getValueAt(fila, 2).toString();
		cilindros = tbVehiculos.getValueAt(fila, 3).toString();
		pesoNeto = tbVehiculos.getValueAt(fila, 4).toString();
		pesoBruto = tbVehiculos.getValueAt(fila, 5).toString();
		transporte = tbVehiculos.getValueAt(fila, 6).toString();		
		gps = tbVehiculos.getValueAt(fila, 7).toString();
		sinoairbag = tbVehiculos.getValueAt(fila, 8).toString();
		asientos = tbVehiculos.getValueAt(fila, 9).toString();
		combustible = tbVehiculos.getValueAt(fila, 10).toString();
		year = tbVehiculos.getValueAt(fila, 11).toString();

		txtId.setText(id);
		cboModelo.setSelectedItem(modelo);
		txtMotor.setText(motor);
		txtCilindros.setText(cilindros);
		txtPesoneto.setText(pesoNeto);
		txtPesobruto.setText(pesoBruto);
		cboTransporte.setSelectedItem(transporte);
		txtGPS.setText(gps);
		cboAirbag.setSelectedItem(sinoairbag);
		txtAsientos.setText(asientos);
		cboCombustible.setSelectedItem(combustible);
		txtYear.setText(year);
	}

	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == tbVehiculos) {
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
		int fila = tbVehiculos.getSelectedRow();
		MostrarDatos(fila);
	}

	protected void actionPerformedBtnLimpiar(ActionEvent e) {
		txtId.setText(generarCodigoVehiculo());
		cboModelo.setSelectedIndex(0);
		txtMotor.setText(null);
		txtCilindros.setText(null);
		txtPesoneto.setText(null);
		cboTransporte.setSelectedIndex(0);
		txtGPS.setText(null);
		txtAsientos.setText(null);
		cboAirbag.setSelectedIndex(0);
		txtYear.setText(null);
		cboCombustible.setSelectedIndex(0);
		txtPesobruto.setText(null);

	}
	
	private String generarCodigoVehiculo() {
		String codeLastVehi = "";
		if (tbVehiculos.getRowCount() == 0) {
			codeLastVehi = "VHT001";
		} else {
			codeLastVehi = tbVehiculos.getValueAt(tbVehiculos.getRowCount() - 1, 0) + "";
		}
		String newCode = "";
		for (char ss : codeLastVehi.toCharArray()) {
			if (!String.valueOf(ss).equalsIgnoreCase("V") && !String.valueOf(ss).equalsIgnoreCase("H")
					&& !String.valueOf(ss).equalsIgnoreCase("T")) {
				newCode += String.valueOf(ss);
			}
		}
		int num = Integer.parseInt(newCode);
		String FinalCode = "";
		if (num < 10) {
			FinalCode = "VHT00" + (num + 1);
		} else if (num < 100) {
			FinalCode = "VHT0" + (num + 1);
		} else if (num < 1000) {
			FinalCode = "VHT" + (num + 1);
		}
		return FinalCode;
	}
	protected void actionPerformedBtnBorrar(ActionEvent e) {
		int rowSelection = tbVehiculos.getSelectedRow();
		if (rowSelection != -1) {
			int result = JOptionPane.showConfirmDialog(null, "�Seguro que desea continuar?", "ADVERTENCIA",
					JOptionPane.YES_NO_OPTION);
			if(result == 0) {
				gVehiculo.eliminarVehiculo(tbVehiculos.getValueAt(rowSelection, 0).toString());
				cargarTable();
			}
		}
	}
}
