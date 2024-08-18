package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.List;

import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.management.ValueExp;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

import Entidad.Almacen;
import Entidad.Vehiculo;
import Entidad.Venta;
import Interfaces.InterfazVehiculoDAO;
import Mantenimiento.VehiculoGestionDAO;
import java.awt.Toolkit;
import javax.swing.JComboBox;


public class FrmReporteVehiculos extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblReporteDeVehi;
	private JLabel lblNewLabel;
	private JTable tblRepVehiculo;
	private JScrollPane scrollPane;
	
	DefaultTableModel model = new DefaultTableModel();
	
	VehiculoGestionDAO vegdao = new VehiculoGestionDAO();
	private JButton btnListarVehi;
	private JComboBox cboID;
	private JComboBox cboModelo;
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmReporteVehiculos frame = new FrmReporteVehiculos();
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
	public FrmReporteVehiculos() {
		setTitle("TOYOTA - Reporte Veh\u00EDculos");
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrmReporteVehiculos.class.getResource("/img/toyo_log.png")));
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 990, 467);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblReporteDeVehi = new JLabel("Reporte de Veh\u00EDculo");
		lblReporteDeVehi.setForeground(Color.BLACK);
		lblReporteDeVehi.setOpaque(true);
		lblReporteDeVehi.setHorizontalAlignment(SwingConstants.CENTER);
		lblReporteDeVehi.setFont(new Font("Cambria", Font.PLAIN, 20));
		lblReporteDeVehi.setBackground(Color.LIGHT_GRAY);
		lblReporteDeVehi.setBounds(10, 10, 954, 37);
		contentPane.add(lblReporteDeVehi);
		
		lblNewLabel = new JLabel("ID Veh\u00EDculo");
		lblNewLabel.setBounds(84, 72, 76, 13);
		contentPane.add(lblNewLabel);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 105, 954, 315);
		contentPane.add(scrollPane);
		
		tblRepVehiculo = new JTable();
		scrollPane.setViewportView(tblRepVehiculo);
		tblRepVehiculo.setFillsViewportHeight(true);
		
		btnListarVehi = new JButton("Listar Vehiculos");
		btnListarVehi.setIcon(new ImageIcon(FrmReporteVehiculos.class.getResource("/img/reportes.png")));
		btnListarVehi.addActionListener(this);
		btnListarVehi.setBounds(795, 58, 145, 31);
		contentPane.add(btnListarVehi);
		
		cboID = new JComboBox();
		cboID.addActionListener(this);
		cboID.setBounds(170, 68, 118, 21);
		contentPane.add(cboID);
		
		cboModelo = new JComboBox();
		cboModelo.addActionListener(this);
		cboModelo.setBounds(509, 67, 145, 22);
		contentPane.add(cboModelo);
		
		lblNewLabel_1 = new JLabel("Modelo Veh\u00EDculo");
		lblNewLabel_1.setBounds(390, 71, 109, 14);
		contentPane.add(lblNewLabel_1);
		
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
		model.addColumn("AÑO");		
		
		CargarcboID();
		CargarcboModelo();
		
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == cboModelo) {
			actionPerformedCboModelo(e);
		}
		if (e.getSource() == cboID) {
			actionPerformedCboID(e);
		}
		if (e.getSource() == btnListarVehi) {
			actionPerformedBtnListarVehi(e);
		}
	}
	
	
	
	
	
	
	


	private void mensajeError(String msj) {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(this, msj,"Error !!",0);
	}
		

	protected void actionPerformedBtnListarVehi(ActionEvent e) {
		listarVehiculos();
	}
	
	
	private void listarVehiculos () {
		
		model.setRowCount(0);
		
		ArrayList<Vehiculo> list = vegdao.listarVehiculo();
		if(list.size() != 0) {
			for (Vehiculo vehi : list) {
				Object [] row = {vehi.getId(), vehi.getNommodel(), vehi.getMotor(), vehi.getCilindros(),
						vehi.getPesoneto(), vehi.getPesobruto(), vehi.getTiptransmision(), vehi.getGps(),
						vehi.getSinoairbag(), vehi.getAsientos(), vehi.getTipcombustible(), vehi.getYear()};
				
				model.addRow(row);
				}
		       tblRepVehiculo.setModel(model);
		}else {
		mensajeError("Lista Vacía");
		}
}
	protected void actionPerformedCboID(ActionEvent e) {
		
		int indice = cboID.getSelectedIndex();
		String id;
		if(indice == 0) {
			return;
		}else {
			id= cboID.getSelectedItem().toString();
			model.setRowCount(0);
			tblRepVehiculo.setModel(model);
			Vehiculo vehigen = vegdao.buscarVehiculo(id);
			
			if (vehigen == null) {
				 mensajeError("No existe una venta con ese id");
			}else {
				Object [] row = {vehigen.getId(), vehigen.getNommodel(), vehigen.getMotor(), vehigen.getCilindros(),
						vehigen.getPesoneto(), vehigen.getPesobruto(), vehigen.getTiptransmision(), vehigen.getGps(),
						vehigen.getSinoairbag(), vehigen.getAsientos(), vehigen.getTipcombustible(), vehigen.getYear()};
				
				model.addRow(row);
			}
		}
	}
	
	private void CargarcboID() {
		ArrayList<Vehiculo> listvehi = vegdao.listarVehiculo();
		
		if(listvehi.size()==0) {
			mensajeError("Lista de ventas vacía");
		}else {
			cboID.addItem("Seleccione...");
			for(Vehiculo idVehiculo :listvehi) {
				//agregamos datos al CboID
				cboID.addItem(idVehiculo.getId());
			}
		}
	}
	private void CargarcboModelo() {
		ArrayList<Vehiculo> listvehi = vegdao.listarVehiculo();
		
		if(listvehi.size()==0) {
			mensajeError("Lista de ventas vacía");
		}else {
			cboModelo.addItem("Seleccione...");
			for(Vehiculo modVeh :listvehi) {
				//agregamos datos al CboModelo
				cboModelo.addItem(modVeh.getNommodel());
			}
		}
	}	
	protected void actionPerformedCboModelo(ActionEvent e) {
		int indice = cboModelo.getSelectedIndex();
		String mod;
		if(indice==0) {
			return;
		}else {	
			mod = cboModelo.getSelectedItem().toString();
			model.setRowCount(0);
			 ArrayList<Vehiculo> listVeh = vegdao.buscarVehiculoModelo(mod);
			 if(listVeh.size() != 0) {
					for (Vehiculo vehi : listVeh) {
						Object [] row = {vehi.getId(), vehi.getNommodel(), vehi.getMotor(), vehi.getCilindros(),
								vehi.getPesoneto(), vehi.getPesobruto(), vehi.getTiptransmision(), vehi.getGps(),
								vehi.getSinoairbag(), vehi.getAsientos(), vehi.getTipcombustible(), vehi.getYear()};
						
						model.addRow(row);
						}
				       tblRepVehiculo.setModel(model);
				}else {
				mensajeError("Lista Vacía");					
			 }
		}
	}
}