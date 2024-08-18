package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Mantenimiento.EmpleadoGestionDAO;
import Interfaces.InterfazEmpleadoDAO;
import Entidad.Empleado; 

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
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class FrmReporteEmpleado extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblReporteDeEmpleado;
	private JLabel lblNewLabel_1;
	private JButton btnReporte;
	private JComboBox cboNomEmp;
	private JLabel lblNewLabel;
	private JComboBox cboCodEmp;
	
	
	
	DefaultTableModel modelo = new DefaultTableModel();
	
	EmpleadoGestionDAO empgdao  = new EmpleadoGestionDAO();
	private JTable tblReporteEmpleados;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmReporteEmpleado frame = new FrmReporteEmpleado();
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
	public FrmReporteEmpleado() {
		setTitle("TOYOTA - Reporte Empleados");
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrmReporteEmpleado.class.getResource("/img/toyo_log.png")));
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
		
		lblReporteDeEmpleado = new JLabel("Reporte de Empleado");
		lblReporteDeEmpleado.setForeground(new Color(0, 0, 0));
		lblReporteDeEmpleado.setOpaque(true);
		lblReporteDeEmpleado.setHorizontalAlignment(SwingConstants.CENTER);
		lblReporteDeEmpleado.setFont(new Font("Cambria", Font.PLAIN, 20));
		lblReporteDeEmpleado.setBackground(Color.LIGHT_GRAY);
		lblReporteDeEmpleado.setBounds(10, 14, 966, 37);
		contentPane.add(lblReporteDeEmpleado);
		
		lblNewLabel_1 = new JLabel("C\u00F3digo :");
		lblNewLabel_1.setBounds(55, 84, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		btnReporte = new JButton("Reporte");
		btnReporte.addActionListener(this);
		btnReporte.setIcon(new ImageIcon(FrmReporteEmpleado.class.getResource("/img/busqueda.png")));
		btnReporte.setBounds(802, 71, 138, 40);
		contentPane.add(btnReporte);
		
		cboNomEmp = new JComboBox();
		cboNomEmp.addActionListener(this);
		cboNomEmp.setBounds(375, 80, 209, 22);
		contentPane.add(cboNomEmp);
		
		lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setBounds(315, 84, 46, 14);
		contentPane.add(lblNewLabel);
		
		cboCodEmp = new JComboBox();
		cboCodEmp.addActionListener(this);
		cboCodEmp.setBounds(111, 80, 113, 22);
		contentPane.add(cboCodEmp);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 146, 978, 290);
		contentPane.add(scrollPane);
		
		tblReporteEmpleados = new JTable();
		scrollPane.setViewportView(tblReporteEmpleados);
		tblReporteEmpleados.setFillsViewportHeight(true);
		
		
		modelo.addColumn("CODIGO");
		modelo.addColumn("NOMBRE");
		modelo.addColumn("CARGO");
		modelo.addColumn("SUELDO");
		modelo.addColumn("DIRECCION");
		modelo.addColumn("TELEFONO");
		modelo.addColumn("EMAIL");
		CargarCboEmpleado(); 
		CargarCbonomEmpleado();

	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnReporte) {
			actionPerformedBtnReporte(e);
		}
		if (e.getSource() == cboNomEmp) {
			actionPerformedCboNomEmp(e);
		}
		if (e.getSource() == cboCodEmp) {
			actionPerformedCboCodEmp(e);
		}
	}
	protected void actionPerformedCboCodEmp(ActionEvent e) {
		
		int indice = cboCodEmp.getSelectedIndex();
		String codempe;
		if(indice == 0) {
			return;
		}else {
			codempe=cboCodEmp.getSelectedItem().toString();
			modelo.setRowCount(0);
			tblReporteEmpleados.setModel(modelo);
			Empleado emplegen = empgdao.buscarEmpleado(codempe);
			
			if(emplegen == null) {
				mensajeError("No existe una venta con ese id");
			}else {
				Object [] row = {emplegen.getCod_emple(), emplegen.getNom_emple(), emplegen.getCar_emple(),
						emplegen.getSueldo_emple(), emplegen.getDir_emple(), emplegen.getTel_emple(), emplegen.getEmail_emple() };
				
				modelo.addRow(row);
			}
			
	
		}
	}

	private void mensajeError(String msj) {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(this, msj, "Error !!",0);
	}
	
	
	private void CargarCboEmpleado() {
		
		ArrayList<Empleado> listEmple = empgdao.listarEmpleado();
		if(listEmple.size()==0) {
			mensajeError("Lista Empleados vacía");
		}else {
			cboCodEmp.addItem("Seleccione...");
			for(Empleado codemple :listEmple) {
				//agregamos datos al CboTipo
				cboCodEmp.addItem(codemple.getCod_emple());
			}
		}
		
	}
	
	
    private void CargarCbonomEmpleado() {
		
		ArrayList<Empleado> listEmple = empgdao.listarEmpleado();
		if(listEmple.size()==0) {
			mensajeError("Lista de Empleados vacía");
		}else {
			cboNomEmp.addItem("Seleccione...");
			for(Empleado nomEmpleado :listEmple) {
				//agregamos datos al CboTipo
				cboNomEmp.addItem(nomEmpleado.getNom_emple());
			}
		}
		
	}

	protected void actionPerformedCboNomEmp(ActionEvent e) {
		
		int indice = cboNomEmp.getSelectedIndex();
		String nomemple;
		if(indice == 0) {
			return;
		}else {
			nomemple=cboNomEmp.getSelectedItem().toString();
			modelo.setRowCount(0);
			tblReporteEmpleados.setModel(modelo);
			Empleado nomemplegen = empgdao.buscarNombre(nomemple);
			
			if(nomemplegen == null) {
				mensajeError("No existe un Empleado con ese nombre");
			}else {
				Object [] row = {nomemplegen.getCod_emple(), nomemplegen.getNom_emple(), nomemplegen.getCar_emple(),
						nomemplegen.getSueldo_emple(), nomemplegen.getDir_emple(), nomemplegen.getTel_emple(), nomemplegen.getEmail_emple() };
				
				modelo.addRow(row);
			}
		}
	}
	
	protected void actionPerformedBtnReporte(ActionEvent e) {
		listarEmpleado();
	}
	
	private void listarEmpleado() {
		
		modelo.setRowCount(0);
		
		ArrayList<Empleado> list = empgdao.listarEmpleado();
		if(list.size() != 0) {
			for (Empleado emp : list) {
				Object [] row = {emp.getCod_emple(), emp.getNom_emple(), emp.getCar_emple(),
						emp.getSueldo_emple(), emp.getDir_emple(), emp.getTel_emple(), emp.getEmail_emple()};
				
				modelo.addRow(row);
				}
		       tblReporteEmpleados.setModel(modelo);
	}else {
		mensajeError("Lista Vacía");
	}
  }
}
