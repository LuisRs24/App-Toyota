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
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;

import Entidad.Vehiculo;
import Entidad.Venta;
import Mantenimiento.VehiculoGestionDAO;
import Mantenimiento.VentaGestionDAO;

import java.awt.event.MouseListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;


public class FrmVenta extends JFrame implements ActionListener, MouseListener {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JTextField txtDNI;
	private JTextField txtTelefono;
	private JTextField txtPrecio;
	private JTextField txtDescuento;
	private JLabel lblNewLabel_6;
	private JTextField txtTotal;
	private JTable tblVenta;
	private JScrollPane scrollPane;
	private JButton btnLimpiar;
	private JButton btnRegistrar;
	private JLabel lblNewLabel_8;
	private JTextField txtNombre;
	private JLabel lblNewLabel_9;
	private JDateChooser txtFecha;
	
	DefaultTableModel model = new DefaultTableModel();
	VentaGestionDAO gVenta = new VentaGestionDAO();
	VehiculoGestionDAO gVehiculo = new VehiculoGestionDAO();
	SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");

	private JTextField txtCodigo;
	private JLabel lblVentaDeVehculos;
	private JScrollPane scrollPane_1;
	private JComboBox cboVehiculos;
	private JTextField txtNomVeh;
	private JLabel lblNewLabel_7;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmVenta frame = new FrmVenta();
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
	public FrmVenta() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrmVenta.class.getResource("/img/toyo_log.png")));
		setResizable(false);
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		setTitle("TOYOTA - Ventas");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1070, 432);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("Codigo :");
		lblNewLabel.setBounds(10, 80, 62, 13);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("DNI Cliente :");
		lblNewLabel_1.setBounds(10, 110, 85, 13);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Telefono");
		lblNewLabel_2.setBounds(10, 167, 62, 13);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Fecha :");
		lblNewLabel_3.setBounds(10, 253, 45, 27);
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Precio :");
		lblNewLabel_4.setBounds(10, 309, 45, 13);
		contentPane.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("Descuento :");
		lblNewLabel_5.setBounds(10, 335, 70, 13);
		contentPane.add(lblNewLabel_5);
		
		txtDNI = new JTextField();
		txtDNI.setBounds(90, 107, 110, 19);
		txtDNI.setColumns(10);
		contentPane.add(txtDNI);
		
		txtTelefono = new JTextField();
		txtTelefono.setBounds(90, 164, 110, 19);
		txtTelefono.setColumns(10);
		contentPane.add(txtTelefono);
		
		txtPrecio = new JTextField();
		txtPrecio.setBounds(90, 305, 110, 19);
		txtPrecio.setColumns(10);
		contentPane.add(txtPrecio);
		
		txtDescuento = new JTextField();
		txtDescuento.setBounds(90, 332, 110, 19);
		txtDescuento.setColumns(10);
		contentPane.add(txtDescuento);
		
		lblNewLabel_6 = new JLabel("Total :");
		lblNewLabel_6.setBounds(10, 366, 45, 13);
		contentPane.add(lblNewLabel_6);
		
		txtTotal = new JTextField();
		txtTotal.setBounds(90, 363, 110, 19);
		txtTotal.addMouseListener(this);
		txtTotal.setEditable(false);
		txtTotal.setColumns(10);
		contentPane.add(txtTotal);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(210, 60, 834, 322);
		contentPane.add(scrollPane);
		
		tblVenta = new JTable();
		tblVenta.addMouseListener(this);
		tblVenta.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Codigo", "DNI Cliente ", "Nombre Cliente", "Telefono", "Id Auto", "Fecha", "Precio", "Descuento", "Total"
			}
		));
		tblVenta.getColumnModel().getColumn(0).setPreferredWidth(66);
		tblVenta.getColumnModel().getColumn(0).setMinWidth(10);
		tblVenta.getColumnModel().getColumn(1).setPreferredWidth(87);
		tblVenta.getColumnModel().getColumn(2).setPreferredWidth(103);
		scrollPane.setViewportView(tblVenta);
		tblVenta.setFillsViewportHeight(true);
		
		btnLimpiar = new JButton("NUEVO");
		btnLimpiar.setBounds(676, 9, 176, 40);
		btnLimpiar.addActionListener(this);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 0, 2, 2);
		contentPane.add(scrollPane_1);
		btnLimpiar.setPressedIcon(new ImageIcon(FrmVenta.class.getResource("/img/new2.png")));
		btnLimpiar.setIcon(new ImageIcon(FrmVenta.class.getResource("/img/Limpiar.png")));
		contentPane.add(btnLimpiar);
		
		btnRegistrar = new JButton("REGISTRAR");
		btnRegistrar.setBounds(862, 9, 176, 40);
		btnRegistrar.setIcon(new ImageIcon(FrmVenta.class.getResource("/img/abrir.png")));
		btnRegistrar.setPressedIcon(new ImageIcon(FrmVenta.class.getResource("/img/abrir2.png")));
		btnRegistrar.addActionListener(this);
		contentPane.add(btnRegistrar);
		
		lblNewLabel_8 = new JLabel("Nombre Cliente");
		lblNewLabel_8.setBounds(10, 140, 85, 13);
		contentPane.add(lblNewLabel_8);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(90, 137, 110, 19);
		txtNombre.setColumns(10);
		contentPane.add(txtNombre);
		
		lblNewLabel_9 = new JLabel("ID Auto : ");
		lblNewLabel_9.setBounds(10, 194, 62, 13);
		contentPane.add(lblNewLabel_9);
		
		txtFecha = new JDateChooser();
		txtFecha.setForeground(Color.WHITE);
		txtFecha.setBounds(91, 257, 109, 20);
		txtFecha.setDateFormatString("yyy MM dd");
		contentPane.add(txtFecha);
		
		txtCodigo = new JTextField();
		txtCodigo.setEditable(false);
		txtCodigo.setBounds(90, 77, 110, 19);
		txtCodigo.setColumns(10);
		contentPane.add(txtCodigo);
		
		model.addColumn("Codigo");
		model.addColumn("DNI Cliente");
		model.addColumn("Nombre Cliente");
		model.addColumn("Telefono");
		model.addColumn("ID Auto");
		model.addColumn("Fecha");
		model.addColumn("Precio");
		model.addColumn("Descuento");
		model.addColumn("Total");
		
		tblVenta.setModel(model);
		
		lblVentaDeVehculos = new JLabel("   Venta de Veh\u00EDculos");
		lblVentaDeVehculos.setIcon(new ImageIcon(FrmVenta.class.getResource("/img/Venta.png")));
		lblVentaDeVehculos.setOpaque(true);
		lblVentaDeVehculos.setHorizontalAlignment(SwingConstants.CENTER);
		lblVentaDeVehculos.setForeground(Color.BLACK);
		lblVentaDeVehculos.setFont(new Font("Cambria", Font.BOLD, 20));
		lblVentaDeVehculos.setBackground(Color.LIGHT_GRAY);
		lblVentaDeVehculos.setBounds(10, 9, 656, 40);
		contentPane.add(lblVentaDeVehculos);	
		cboVehiculos = new JComboBox();
		cboVehiculos.addActionListener(this);
		cboVehiculos.setBounds(89, 189, 111, 22);
		contentPane.add(cboVehiculos);
		
		CargarCboVehiculos();
		cargarFecha();		
		listarVentasTabla();
		txtCodigo.setText(tblVenta.getValueAt(tblVenta.getRowCount() - 1, 0).toString());
		
		txtNomVeh = new JTextField();
		txtNomVeh.setEditable(false);
		txtNomVeh.setBounds(90, 222, 85, 20);
		contentPane.add(txtNomVeh);
		txtNomVeh.setColumns(10);
		
		lblNewLabel_7 = new JLabel("Nom. Modelo");
		lblNewLabel_7.setBounds(10, 225, 71, 14);
		contentPane.add(lblNewLabel_7);
		
		btnNewButton = new JButton("");
		btnNewButton.addActionListener(this);
		btnNewButton.setIcon(new ImageIcon(FrmVenta.class.getResource("/img/Veh\u00EDculo.png")));
		btnNewButton.setBounds(180, 218, 25, 27);
		contentPane.add(btnNewButton);
	}
	
	private void cargarFecha() {
		Date feAct;
		try {
			feAct = formato.parse(LocalDateTime.now().toString());
			txtFecha.setDate(feAct);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private void listarVentasTabla() {
		model.setRowCount(0);
		
		ArrayList<Venta> list = gVenta.listarVenta();
		if(list.size() != 0) {
			for (Venta vent : list) {
				Object [] row = {vent.getCod_venta(),
								vent.getDni_cli(),
								vent.getNom_cli(),
								vent.getFono_cli(),
								vent.getId_aut(),
								vent.getFecha_venta(),
								vent.getPrecio_venta(),
								vent.getDscto_venta(),
								vent.getMont_tot_venta()};
				model.addRow(row);
			}
			tblVenta.setModel(model);
		}else {
			mensajeError("Lista Vac�a");
		}
	}		
	

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNewButton) {
			actionPerformedBtnNewButton(e);
		}
		if (e.getSource() == cboVehiculos) {
			actionPerformedCboVehiculos(e);
		}
		if (e.getSource() == btnLimpiar) {
			actionPerformedBtnLimpiar(e);
		}
		if (e.getSource() == btnRegistrar) {
			actionPerformedBtnRegistrar(e);
		}
	}
	protected void actionPerformedBtnRegistrar(ActionEvent e) {
		registrarVenta();
	}
	

	 private int leerCodigo() {
			int cod;
			cod=Integer.parseInt(txtCodigo.getText());
			return cod;	
		}

	double leerTotal() {
		// TODO Auto-generated method stub
		return Double.parseDouble(txtTotal.getText());
	}

	double leerPrecio() {
		// TODO Auto-generated method stub
		return Double.parseDouble(txtPrecio.getText());
	}

	double leerDescuento() {
		// TODO Auto-generated method stub
		return Double.parseDouble(txtDescuento.getText());
	}

	int leerDni() {
		 int dni=0;
			if(txtDNI.getText().length()==0) {
				mensajeError("Ingresa el numero de telefono");
			}else {
				dni= Integer.parseInt(txtDNI.getText());
			}
			return dni;
	 }

	String leerTelefono() {
		 String leertelef = null;
			if(txtTelefono.getText().length()==0) {
				mensajeError("Ingresa el numero de telefono");
			}else {
				leertelef= txtTelefono.getText();
			}
			return leertelef;
	 }
	private String leerFecha() {
		String fecha = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		fecha = sdf.format(txtFecha.getDate());
		
		return fecha;
	}

	private String leerNombre() {
		String nombre=null;
		//validar caja vacia
		if(txtNombre.getText().trim().length()==0) {
			mensajeError("Ingresar nombre de producto");
			txtNombre.requestFocus();
		}
		nombre=txtNombre.getText().trim();
		
		return nombre;	
	}
		
	String leerIdAuto() {
		String id=null;
		//validar caja vacia
		if(cboVehiculos.getSelectedIndex()==0) {
			mensajeError("seleccione el id de un veh�culo");
		}	
		id=cboVehiculos.getSelectedItem()+"";
		
			
		return id;	
	}

	private void mensajeError(String msj) {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(this, msj,"Error",0);
		
	}
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == tblVenta) {
			mouseClickedTblVenta(e);
		}
		if (e.getSource() == txtTotal) {
			mouseClickedTxtTotal(e);
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
	protected void mouseClickedTxtTotal(MouseEvent e) {
		precioTotal();
	}
	
	private void precioTotal() {
		double precio, descuento, total;
		
		precio = Double.parseDouble(txtPrecio.getText());
		descuento = Double.parseDouble(txtDescuento.getText());
		total = precio - descuento;
		
		txtTotal.setText(total+"");				
	}

	
	void MostrarDatos (int fila) {
		String cod ,idauto ,nombre ,telefono ,dni ,descuento,precio ,total;
		Date fecha;		
		
		try {
			cod = tblVenta.getValueAt(fila, 0).toString();
			dni = tblVenta.getValueAt(fila, 1).toString();
			nombre = tblVenta.getValueAt(fila, 2).toString();
			telefono = tblVenta.getValueAt(fila, 3).toString();
			idauto = tblVenta.getValueAt(fila, 4).toString();			
			fecha = formato.parse(tblVenta.getValueAt(fila, 5).toString());
			precio = tblVenta.getValueAt(fila, 6).toString();	
			descuento = tblVenta.getValueAt(fila, 7).toString();
			total = tblVenta.getValueAt(fila, 8).toString();
			
			txtCodigo.setText(cod);
			cboVehiculos.setSelectedItem(idauto);
			txtNombre.setText(nombre);
			txtFecha.setDate(fecha);
			txtTelefono.setText(telefono);
			txtDNI.setText(dni);
			txtDescuento.setText(descuento);	    
			txtPrecio.setText(precio);
			txtTotal.setText(total);
		} catch (Exception e) {
			mensajeError("No hay datos en la fila seleccionada");
		}	
		
	} 
	
	
	private Date parse(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	protected void mouseClickedTblVenta(MouseEvent e) {
		int fila = tblVenta.getSelectedRow();
		MostrarDatos(fila);
		
	}
	protected void actionPerformedBtnLimpiar(ActionEvent e) {
		txtCodigo.setText(generarCodigoVenta()+"");
		cboVehiculos.setSelectedIndex(0);;
		txtNombre.setText("");
		txtTelefono.setText("");
		txtDNI.setText("");
		txtDescuento.setText("");	    
		txtPrecio.setText("");
		txtTotal.setText("");
		cargarFecha();
	}
	
	private void registrarVenta() {
		int cod, dni;
		String nombre, telefono, idauto, fecha;
		double descuento, precio, total;
		
		cod = leerCodigo();
		dni = leerDni();
		nombre = leerNombre();
		telefono = leerTelefono();
		idauto = leerIdAuto();		
		fecha = leerFecha();
		precio = leerPrecio();
		descuento = leerDescuento();		
		total = leerTotal();
		
		
		if (cod== -1 || dni == -1 || nombre == null || telefono == null || idauto == null || precio == 0 || descuento == 0) {
			mensajeError("No se permiten campos vac�os");
		}else {
			Venta V = new Venta();
			V.setCod_venta(generarCodigoVenta());
			V.setDni_cli(dni);
			V.setNom_cli(nombre);
			V.setFono_cli(telefono);
			V.setId_aut(idauto);
			V.setFecha_venta(fecha);;
			V.setPrecio_venta(precio);
			V.setDscto_venta(descuento);
			V.setMont_tot_venta(total);

			int result = gVenta.registrarVenta(V);
			if (result != 0) {
				JOptionPane.showMessageDialog(null, "Venta registrada exitosamente");
				listarVentasTabla();
			} else {
				JOptionPane.showMessageDialog(null, "No se pudo registrar la venta");
			}
		}
	}
	private int generarCodigoVenta() {
		int codeLastVenta = 0;
		if (tblVenta.getRowCount() == 0) {
			return codeLastVenta = 1;
		} else {
			codeLastVenta = (int) tblVenta.getValueAt(tblVenta.getRowCount() - 1, 0);
			int FinalCode = codeLastVenta+1;
			return FinalCode;
		}
	}
	
	private void CargarCboVehiculos() {
		//Obtenemos resultados
		ArrayList<Vehiculo> listVeh = gVehiculo.listarVehiculo();
		
		//validamos resultado
		if(listVeh.size()==0) {
			mensajeError("Lista de veh�culos vac�a");
		}else {
			cboVehiculos.addItem("Seleccione...");
			for(Vehiculo tipVehiculo:listVeh) {
				//agregamos datos al CboTipo
				cboVehiculos.addItem(tipVehiculo.getId());
			}
		}
	}
	protected void actionPerformedCboVehiculos(ActionEvent e) {
		int indice = cboVehiculos.getSelectedIndex();
		String idVeh;
		if(indice==0 ) {
			return;
		}else {
			idVeh = cboVehiculos.getSelectedItem().toString();			
			Vehiculo veh = gVehiculo.buscarVehiculo(idVeh);
			txtNomVeh.setText(veh.getNommodel());
		}
		
	}
	String mostrarIDVehiculo() {	
		String idVeh;
		
		idVeh = cboVehiculos.getSelectedItem().toString();
		
		return idVeh;
	}
	
	protected void actionPerformedBtnNewButton(ActionEvent e) {
		int id;
		id = cboVehiculos.getSelectedIndex();
		if(id==0) {
			mensajeError("Por favor antes deleccione alg�n veh�culo");
		}else {			
			detallarVehiculo();		
		}
	}
	
	private void detallarVehiculo() {
		String id, nomV;
			id = mostrarIDVehiculo();	
			
		Vehiculo veh = gVehiculo.buscarVehiculo(id);
		if(veh==null) {
			mensajeError("vehiculo vac�o  "+veh );
		}else {
		nomV = veh.getNommodel()+"";
		mensajeInformativo("MOTOR	                          :   "+veh.getMotor()+"\n"+
						  "Nro. CILINDROS           :    "+veh.getCilindros()+"\n"+
						  "PESO NETO                  :    "+veh.getPesoneto()+"\n"+
						  "PESO BRUTO	   	           :    "+veh.getPesobruto()+"\n"+
						  "TRANSMISI�N            :    "+veh.getTiptransmision()+"\n"+
						  "GPS                               :    "+veh.getGps()+"\n"+
						  "AIRBAG                         :    "+veh.getSinoairbag()+"\n"+
						  "Nro. ASIENTOS           :    "+veh.getAsientos()+"\n"+
						  "Tipo COMBUSTIBLE  :    "+veh.getTipcombustible()+"\n"+
						  "A�o FABRICACI�N    :    "+veh.getYear(),id,nomV);
		}
	}
		
	
	
	private void mensajeInformativo(String msj,String id, String veh){
		JOptionPane.showMessageDialog(this, msj,id+" - "+veh+"",JOptionPane.INFORMATION_MESSAGE);
	}
}
