package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import com.toedter.calendar.JDateChooser;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;

import Entidad.Venta;
import Interfaces.InterfazVentaDAO;
import Mantenimiento.VentaGestionDAO;

import java.awt.Toolkit;

public class FrmReporteVentas extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JButton btnLista;
	private JLabel lblNewLabel_2;
	private JDateChooser dcFecha;
	private JButton btnReporte;
	private JComboBox cboCodVenta;
	
	private JButton btnNewButton;
	private JTable tblVenta;
	private JScrollPane scrollPane;
	
	Date fecha = new Date();
	//Formatear la fecha
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");	
	VentaGestionDAO vgdao = new VentaGestionDAO();
	DefaultTableModel model = new DefaultTableModel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmReporteVentas frame = new FrmReporteVentas();
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
	public FrmReporteVentas() {
		setTitle("TOYOTA - Reporte Ventas");
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrmReporteVentas.class.getResource("/img/toyo_log.png")));
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 945, 504);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("Reporte de Ventas");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setOpaque(true);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Cambria", Font.PLAIN, 20));
		lblNewLabel.setBackground(Color.LIGHT_GRAY);
		lblNewLabel.setBounds(10, 11, 909, 37);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Cod. Venta");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(56, 88, 79, 14);
		contentPane.add(lblNewLabel_1);
		
		btnLista = new JButton("Listar Ventas");
		btnLista.addActionListener(this);
		btnLista.setIcon(new ImageIcon(FrmReporteVentas.class.getResource("/img/reportes.png")));
		btnLista.setBounds(363, 74, 132, 44);
		contentPane.add(btnLista);
		
		lblNewLabel_2 = new JLabel("Fecha");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(559, 88, 38, 14);
		contentPane.add(lblNewLabel_2);
		
		dcFecha = new JDateChooser();
		dcFecha.setDateFormatString("yyyy-MM-dd");
		dcFecha.setBounds(614, 88, 113, 22);
		contentPane.add(dcFecha);
		
		btnReporte = new JButton("Reporte");
		btnReporte.addActionListener(this);
		btnReporte.setIcon(new ImageIcon(FrmReporteVentas.class.getResource("/img/busqueda.png")));
		btnReporte.setBounds(761, 72, 136, 44);
		contentPane.add(btnReporte);
		
		cboCodVenta = new JComboBox();
		cboCodVenta.addActionListener(this);
		cboCodVenta.setBounds(145, 85, 102, 22);
		contentPane.add(cboCodVenta);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 139, 909, 315);
		contentPane.add(scrollPane);
		
		tblVenta = new JTable();
		scrollPane.setViewportView(tblVenta);
		
		model.addColumn("Cod Venta");
		model.addColumn("DNI Cliente");
		model.addColumn("Nom. CLiente");
		model.addColumn("Telefono");
		model.addColumn("ID Auto");
		model.addColumn("Fecha Venta");
		model.addColumn("Precio Venta");
		model.addColumn("Descuento");
		model.addColumn("Monto Total");
		
		CargarCboVentass();
		
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnReporte) {
			actionPerformedBtnReporte(e);
		}
		if (e.getSource() == btnLista) {
			actionPerformedBtnLista(e);
		}
		if (e.getSource() == cboCodVenta) {
			actionPerformedCboCodVenta(e);
		}
	}
	protected void actionPerformedCboCodVenta(ActionEvent e) {		
		int indice = cboCodVenta.getSelectedIndex();
		int cod;
		if(indice==0) {
			return;
		}else {	
			cod = (int) cboCodVenta.getSelectedItem();
			model.setRowCount(0);
			tblVenta.setModel(model);
			 Venta ventaGen = vgdao.buscarVenta(cod);
			 
			 if(ventaGen == null) {
				 mensajeError("No existe una venta con ese c�digo");
			 }else {
				 Object [] row = {ventaGen.getCod_venta(),
							ventaGen.getDni_cli(),
							ventaGen.getNom_cli(),
							ventaGen.getFono_cli(),
							ventaGen.getId_aut(),
							ventaGen.getFecha_venta(),
							"S/. "+ventaGen.getPrecio_venta(),
							"S/. "+ventaGen.getDscto_venta(),
							"S/. "+ventaGen.getMont_tot_venta()};			 
				 
				 			model.addRow(row);	
			 }
		}
	}		
	
	private void CargarCboVentass() {
		//Obtenemos resultados
		ArrayList<Venta> listVen = vgdao.listarVenta();
		
		//validamos resultado
		if(listVen.size()==0) {
			mensajeError("Lista de ventas vac�a");
		}else {
			cboCodVenta.addItem("Seleccione...");
			for(Venta codVenta:listVen) {
				//agregamos datos al CboTipo
				cboCodVenta.addItem(codVenta.getCod_venta());
			}
		}
	}
	
	private void buscarVentaFecha() {
		model.setRowCount(0);
		String fe = getFechaReserva();     
		ArrayList<Venta> list = vgdao.listarVentaFecha(fe);		
			try {
				for (Venta vent : list) {
					Object [] row = {vent.getCod_venta(),
									vent.getDni_cli(),
									vent.getNom_cli(),
									vent.getFono_cli(),
									vent.getId_aut(),
									vent.getFecha_venta(),
									"S/. "+vent.getPrecio_venta(),
									"S/. "+vent.getDscto_venta(),
									"S/. "+vent.getMont_tot_venta()};
					model.addRow(row);
				}
				tblVenta.setModel(model);
			} catch (Exception e) {
				mensajeError("No existen ventas registaradas en la fecha indicada");
			}	
	}
	
	private String getFechaReserva() {
		//Obtenemos la fecha
		return sdf.format(dcFecha.getDate());
	}
		
	protected void actionPerformedBtnLista(ActionEvent e) {
		listarVentasTabla();
	}
	
	private void listarVentasTabla() {
		model.setRowCount(0);
		
		ArrayList<Venta> list = vgdao.listarVenta();
		if(list.size() != 0) {
			for (Venta vent : list) {
				Object [] row = {vent.getCod_venta(),
								vent.getDni_cli(),
								vent.getNom_cli(),
								vent.getFono_cli(),
								vent.getId_aut(),
								vent.getFecha_venta(),
								"S/. "+vent.getPrecio_venta(),
								"S/. "+vent.getDscto_venta(),
								"S/. "+vent.getMont_tot_venta()};
				model.addRow(row);
			}
			tblVenta.setModel(model);
		}else {
			mensajeError("Lista Vac�a");
		}
	}

	private void mensajeError(String msj) {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(this, msj,"Error!!",0);
	}	
	protected void actionPerformedBtnReporte(ActionEvent e) {		
		buscarVentaFecha();
	}
}
