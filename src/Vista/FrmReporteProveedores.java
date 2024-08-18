package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Entidad.Almacen;
import Entidad.Proveedor;
import Mantenimiento.ProveedorGestionDAO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class FrmReporteProveedores extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblReporteDeProveedor;
	private JLabel lblNewLabel_1;
	private JButton btnReporte;
	private JComboBox cboNomProv;
	private JLabel lblNewLabel;
	private JComboBox cboCodProv;
	
	DefaultTableModel model = new DefaultTableModel();
	ProveedorGestionDAO gProv = new ProveedorGestionDAO();
	private JTable tblProveedor;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmReporteProveedores frame = new FrmReporteProveedores();
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
	public FrmReporteProveedores() {
		setTitle("TOYOTA - Reporte Proveedores");
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrmReporteProveedores.class.getResource("/img/toyo_log.png")));
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1002, 474);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblReporteDeProveedor = new JLabel("Reporte de Proveedor");
		lblReporteDeProveedor.setForeground(new Color(0, 0, 0));
		lblReporteDeProveedor.setOpaque(true);
		lblReporteDeProveedor.setHorizontalAlignment(SwingConstants.CENTER);
		lblReporteDeProveedor.setFont(new Font("Cambria", Font.PLAIN, 20));
		lblReporteDeProveedor.setBackground(Color.LIGHT_GRAY);
		lblReporteDeProveedor.setBounds(10, 14, 966, 37);
		contentPane.add(lblReporteDeProveedor);
		
		lblNewLabel_1 = new JLabel("C\u00F3digo :");
		lblNewLabel_1.setBounds(55, 84, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		btnReporte = new JButton("Reporte");
		btnReporte.addActionListener(this);
		btnReporte.setIcon(new ImageIcon(FrmReporteProveedores.class.getResource("/img/busqueda.png")));
		btnReporte.setBounds(802, 71, 138, 40);
		contentPane.add(btnReporte);
		
		cboNomProv = new JComboBox();
		cboNomProv.addActionListener(this);
		cboNomProv.setBounds(375, 80, 209, 22);
		contentPane.add(cboNomProv);
		
		lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setBounds(315, 84, 46, 14);
		contentPane.add(lblNewLabel);
		
		cboCodProv = new JComboBox();
		cboCodProv.addActionListener(this);
		cboCodProv.setBounds(111, 80, 113, 22);
		contentPane.add(cboCodProv);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 122, 966, 302);
		contentPane.add(scrollPane);
		
		tblProveedor = new JTable();
		scrollPane.setViewportView(tblProveedor);
		
		model.addColumn("CÓDIGO");
		model.addColumn("NOMBRE");
		model.addColumn("DIRECCIÓN");
		model.addColumn("TELÉFONO");
		model.addColumn("EMAIL");
		
		cargarCboCodProveedor();
		cargarCboNomProveedor();
	}	
	private void cargarCboNomProveedor() {
		//Obtenemos resultados
				ArrayList<Proveedor> listProv = gProv.listarProveedor();		
				//validamos resultado
				if(listProv.size()==0) {
					mensajeError("Lista de Almacenes vacía");
				}else {
					cboCodProv.addItem("Seleccione...");
					for(Proveedor prov:listProv) {
						//agregamos datos al CboNumAlmacen
						cboCodProv.addItem(prov.getCod());
					}
				}
	}

	private void cargarCboCodProveedor() {
		//Obtenemos resultados
				ArrayList<Proveedor> listProv = gProv.listarProveedor();
				
				//validamos resultado
				if(listProv.size()==0) {
					mensajeError("Lista de Almacenes vacía");
				}else {
					cboNomProv.addItem("Seleccione...");
					for(Proveedor prov:listProv) {
						//agregamos datos al CboDepartamentos
						cboNomProv.addItem(prov.getNomprove());
					}
				}
	}
	
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == cboNomProv) {
			actionPerformedCboNomProv(e);
		}
		if (e.getSource() == cboCodProv) {
			actionPerformedCboCodProv(e);
		}
		if (e.getSource() == btnReporte) {
			actionPerformedBtnReporte(e);
		}
	}
	protected void actionPerformedBtnReporte(ActionEvent e) {
		model.setRowCount(0);
		ArrayList<Proveedor> list = gProv.listarProveedor();
		if (list.size() != 0) {
			for (Proveedor p : list) {
				Object[] row = { p.getCod(), p.getNomprove(), p.getDirecc(), p.getTelef(), p.getEmail() };
				model.addRow(row);
			}
			tblProveedor.setModel(model);
		} else {
			JOptionPane.showMessageDialog(null, "Lista vacia!");
		}
	}
	
	private void mensajeError(String msj) {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(this, msj,"Error!!",0);
	}
	protected void actionPerformedCboCodProv(ActionEvent e) {
		int indice = cboCodProv.getSelectedIndex();
		int codProv;
		if(indice==0) {
			return;
		}else {	
			codProv = (int)cboCodProv.getSelectedItem();
			model.setRowCount(0);
			tblProveedor.setModel(model);
			 Proveedor prov = gProv.buscarProveedor(codProv);
			 
			 if(prov == null) {
				 mensajeError("No existe una venta con ese código");
			 }else {
				 Object [] row = {prov.getCod(),
						 		  prov.getNomprove(),
						 		  prov.getDirecc(),
						 		  prov.getTelef(),
						 		  prov.getEmail()};			 
				 
				 			model.addRow(row);	
			 }
		}
	}
	protected void actionPerformedCboNomProv(ActionEvent e) {
		int indice = cboNomProv.getSelectedIndex();
		String nomProv;
		if(indice==0) {
			return;
		}else {	
			nomProv = cboNomProv.getSelectedItem().toString();
			model.setRowCount(0);
			tblProveedor.setModel(model);
			 Proveedor prov = gProv.buscarProveedorNombre(nomProv);
			 
			 if(prov == null) {
				 mensajeError("No existe una venta con ese código");
			 }else {
				 Object [] row = {prov.getCod(),
						 		  prov.getNomprove(),
						 		  prov.getDirecc(),
						 		  prov.getTelef(),
						 		  prov.getEmail()};			 
				 
				 			model.addRow(row);	
			 }
		}
	}
}
