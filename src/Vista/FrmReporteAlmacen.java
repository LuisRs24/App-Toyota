package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Entidad.Almacen;
import Mantenimiento.AlmacenGestionDAO;

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

public class FrmReporteAlmacen extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblReporteAlmacen;
	private JLabel lblNewLabel_1;
	private JButton btnReporte;
	private JComboBox cboDepartamento;
	private JLabel lblNewLabel;
	private JComboBox cboNumAlmacen;
	
	AlmacenGestionDAO gAlmacen = new AlmacenGestionDAO();
	DefaultTableModel model = new DefaultTableModel();
	private JTable tblAlmacen;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmReporteAlmacen frame = new FrmReporteAlmacen();
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
	public FrmReporteAlmacen() {
		setTitle("TOYOTA - Reporte Almacenes");
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrmReporteAlmacen.class.getResource("/img/toyo_log.png")));
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
		
		lblReporteAlmacen = new JLabel("Reporte de Almacenes");
		lblReporteAlmacen.setForeground(new Color(0, 0, 0));
		lblReporteAlmacen.setOpaque(true);
		lblReporteAlmacen.setHorizontalAlignment(SwingConstants.CENTER);
		lblReporteAlmacen.setFont(new Font("Cambria", Font.PLAIN, 20));
		lblReporteAlmacen.setBackground(Color.LIGHT_GRAY);
		lblReporteAlmacen.setBounds(10, 14, 966, 37);
		contentPane.add(lblReporteAlmacen);
		
		lblNewLabel_1 = new JLabel("C\u00F3digo :");
		lblNewLabel_1.setBounds(55, 84, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		btnReporte = new JButton("Reporte");
		btnReporte.addActionListener(this);
		btnReporte.setIcon(new ImageIcon(FrmReporteAlmacen.class.getResource("/img/busqueda.png")));
		btnReporte.setBounds(802, 71, 138, 40);
		contentPane.add(btnReporte);
		
		cboDepartamento = new JComboBox();
		cboDepartamento.addActionListener(this);
		cboDepartamento.setBounds(434, 80, 209, 22);
		contentPane.add(cboDepartamento);
		
		lblNewLabel = new JLabel("Departamento");
		lblNewLabel.setBounds(315, 84, 109, 14);
		contentPane.add(lblNewLabel);
		
		cboNumAlmacen = new JComboBox();
		cboNumAlmacen.addActionListener(this);
		cboNumAlmacen.setBounds(111, 80, 113, 22);
		contentPane.add(cboNumAlmacen);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 122, 966, 302);
		contentPane.add(scrollPane);
		
		tblAlmacen = new JTable();
		scrollPane.setViewportView(tblAlmacen);
		
		model.addColumn("Numero");
		model.addColumn("Direccion");
		model.addColumn("Telefono");
		model.addColumn("Email");
		model.addColumn("Capacidad");
		model.addColumn("Departamento");	
		
		CargarCboNumAlmacen();
		CargarCboDepartamentos();
	}
	private void CargarCboDepartamentos() {
		//Obtenemos resultados
		ArrayList<Almacen> listAlmacen = gAlmacen.listarAlmacen();
		
		//validamos resultado
		if(listAlmacen.size()==0) {
			mensajeError("Lista de Almacenes vacía");
		}else {
			cboDepartamento.addItem("Seleccione...");
			for(Almacen almacen:listAlmacen) {
				//agregamos datos al CboDepartamentos
				cboDepartamento.addItem(almacen.getDpto_alm());
			}
		}
	}
	private void CargarCboNumAlmacen() {
		//Obtenemos resultados
		ArrayList<Almacen> listAlmacen = gAlmacen.listarAlmacen();
		
		//validamos resultado
		if(listAlmacen.size()==0) {
			mensajeError("Lista de Almacenes vacía");
		}else {
			cboNumAlmacen.addItem("Seleccione...");
			for(Almacen almacen:listAlmacen) {
				//agregamos datos al CboNumAlmacen
				cboNumAlmacen.addItem(almacen.getNum_alm());
			}
		}
	}	
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnReporte) {
			actionPerformedBtnReporte(e);
		}
		if (e.getSource() == cboDepartamento) {
			actionPerformedCboDepartamento(e);
		}
		if (e.getSource() == cboNumAlmacen) {
			actionPerformedCboNumAlmacen(e);
		}
	}
	protected void actionPerformedCboNumAlmacen(ActionEvent e) {
		int indice = cboNumAlmacen.getSelectedIndex();
		int num;
		if(indice==0) {
			return;
		}else {	
			num = (int)cboNumAlmacen.getSelectedItem();
			model.setRowCount(0);
			tblAlmacen.setModel(model);
			 Almacen alm = gAlmacen.buscarAlmacen(num);
			 
			 if(alm == null) {
				 mensajeError("No existe una venta con ese código");
			 }else {
				 Object [] row = {alm.getNum_alm(),
						 		  alm.getDir_alm(),
						 		  alm.getFon_alm(),
						 		  alm.getEmail_alm(),
						 		  alm.getCap_alm(),
						 		  alm.getDpto_alm()};			 
				 
				 			model.addRow(row);	
			 }
		}
	}
	protected void actionPerformedCboDepartamento(ActionEvent e) {
		int indice = cboDepartamento.getSelectedIndex();
		String dep;
		if(indice==0) {
			return;
		}else {	
			dep = cboDepartamento.getSelectedItem().toString();
			model.setRowCount(0);
			tblAlmacen.setModel(model);
			 Almacen alm = gAlmacen.buscarAlmacenDepartamento(dep);
			 
			 if(alm == null) {
				 mensajeError("No existe una venta con ese código");
			 }else {
				 Object [] row = {alm.getNum_alm(),
						 		  alm.getDir_alm(),
						 		  alm.getFon_alm(),
						 		  alm.getEmail_alm(),
						 		  alm.getCap_alm(),
						 		  alm.getDpto_alm()};			 
				 
				 			model.addRow(row);	
			 }
		}
	}	
	protected void actionPerformedBtnReporte(ActionEvent e) {
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
	
	private void mensajeError(String msj) {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(this, msj,"Error!!",0);
	}
}
