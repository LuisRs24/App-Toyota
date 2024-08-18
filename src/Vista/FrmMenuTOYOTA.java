package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import Hilo.HiloReloj;

import javax.swing.JMenuBar;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class FrmMenuTOYOTA extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JLabel lblFondo;
	private JMenu mnSistema;
	private JMenu mnMantenimiento;
	private JMenu mnInformacion;
	private JMenuItem mntSalir;
	private JMenuItem mntAlmacen;
	private JMenuItem mntEmpleado;
	private JMenuItem mntProveedor;
	private JMenuItem mntVehiculo;
	private JMenu mnReportes;
	private JMenuItem rptVentas;
	private JMenuItem rptVehiculos;
	private JMenu mnVenta;

	private JMenuItem mntmNewMenuItem;
	private JMenuItem rptEmpleado;
	private JMenuItem rptAlmacen;
	private JMenuItem rptProveedor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmMenuTOYOTA frame = new FrmMenuTOYOTA();
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
	public FrmMenuTOYOTA() {
		setLocationByPlatform(true);
		setResizable(false);
		setTitle("TOYOTA");
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrmMenuTOYOTA.class.getResource("/img/toyo_log.png")));
		
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
		}
		catch(Exception ex){
			ex.printStackTrace();	
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 490, 319);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 480, 30);
		contentPane.add(menuBar);
		
		mnSistema = new JMenu("Sistema");
		mnSistema.setIcon(new ImageIcon(FrmMenuTOYOTA.class.getResource("/img/pc.png")));
		menuBar.add(mnSistema);
		
		mntSalir = new JMenuItem("Salir");
		mntSalir.addActionListener(this);
		mntSalir.setIcon(new ImageIcon(FrmMenuTOYOTA.class.getResource("/img/salir.png")));
		mnSistema.add(mntSalir);
		
		mnMantenimiento = new JMenu("Mantenimiento");
		mnMantenimiento.setIcon(new ImageIcon(FrmMenuTOYOTA.class.getResource("/img/mant.png")));
		menuBar.add(mnMantenimiento);
		
		mntAlmacen = new JMenuItem("Almac\u00E9n");
		mntAlmacen.addActionListener(this);
		mntAlmacen.setIcon(new ImageIcon(FrmMenuTOYOTA.class.getResource("/img/almacen3.png")));
		mnMantenimiento.add(mntAlmacen);
		
		mntEmpleado = new JMenuItem("Empleado");
		mntEmpleado.addActionListener(this);
		mntEmpleado.setIcon(new ImageIcon(FrmMenuTOYOTA.class.getResource("/img/Empleado.png")));
		mnMantenimiento.add(mntEmpleado);
		
		mntProveedor = new JMenuItem("Proveedor");
		mntProveedor.addActionListener(this);
		mntProveedor.setIcon(new ImageIcon(FrmMenuTOYOTA.class.getResource("/img/Proveeedor.png")));
		mnMantenimiento.add(mntProveedor);
		
		mntVehiculo = new JMenuItem("Veh\u00EDculo");
		mntVehiculo.addActionListener(this);
		mntVehiculo.setIcon(new ImageIcon(FrmMenuTOYOTA.class.getResource("/img/mant auto.png")));
		mnMantenimiento.add(mntVehiculo);
		
		mnVenta = new JMenu("Venta");
		mnVenta.addActionListener(this);
		mnVenta.setIcon(new ImageIcon(FrmMenuTOYOTA.class.getResource("/img/Venta.png")));
		menuBar.add(mnVenta);
		
		mntVehiculo = new JMenuItem("Veh\u00EDculos");
		mntVehiculo.addActionListener(this);
		mntVehiculo.setIcon(new ImageIcon(FrmMenuTOYOTA.class.getResource("/img/vehi.png")));
		mnVenta.add(mntVehiculo);
		
		mnReportes = new JMenu("Reportes");
		mnReportes.setIcon(new ImageIcon(FrmMenuTOYOTA.class.getResource("/img/reportes.png")));
		menuBar.add(mnReportes);
		
		rptVentas = new JMenuItem("Ventas");
		rptVentas.setIcon(new ImageIcon(FrmMenuTOYOTA.class.getResource("/img/repor venta.png")));
		rptVentas.addActionListener(this);
		
		rptAlmacen = new JMenuItem("Almacen");
		rptAlmacen.addActionListener(this);
		rptAlmacen.setIcon(new ImageIcon(FrmMenuTOYOTA.class.getResource("/img/almacen2.png")));
		mnReportes.add(rptAlmacen);
		
		rptEmpleado = new JMenuItem("Empleado");
		rptEmpleado.addActionListener(this);
		rptEmpleado.setIcon(new ImageIcon(FrmMenuTOYOTA.class.getResource("/img/empleados.png")));
		mnReportes.add(rptEmpleado);
		
		rptProveedor = new JMenuItem("Proveedor");
		rptProveedor.addActionListener(this);
		rptProveedor.setIcon(new ImageIcon(FrmMenuTOYOTA.class.getResource("/img/Proveeedores.png")));
		mnReportes.add(rptProveedor);
		mnReportes.add(rptVentas);
		
		rptVehiculos = new JMenuItem("Veh\u00EDculos");
		rptVehiculos.setIcon(new ImageIcon(FrmMenuTOYOTA.class.getResource("/img/repor Vehiculo.png")));
		rptVehiculos.addActionListener(this);
		mnReportes.add(rptVehiculos);
		
		mnInformacion = new JMenu("Info");
		mnInformacion.addActionListener(this);
		mnInformacion.setIcon(new ImageIcon(FrmMenuTOYOTA.class.getResource("/img/Informacion.png")));
		menuBar.add(mnInformacion);
		
		mntmNewMenuItem = new JMenuItem("Cr\u00E9ditos");
		mntmNewMenuItem.addActionListener(this);
		mntmNewMenuItem.setIcon(new ImageIcon(FrmMenuTOYOTA.class.getResource("/img/estudiantes.png")));
		mnInformacion.add(mntmNewMenuItem);
		
		lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon(FrmMenuTOYOTA.class.getResource("/img/fondoP.gif")));
		lblFondo.setBounds(0, 29, 480, 251);
		contentPane.add(lblFondo);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mntmNewMenuItem) {
			actionPerformedMntmNewMenuItem(e);
		}
		if (e.getSource() == mntVehiculo) {
			actionPerformedMntVehiculo(e);
		}
		if (e.getSource() == rptProveedor) {
			actionPerformedRptProveedor(e);
		}
		if (e.getSource() == rptEmpleado) {
			actionPerformedRptEmpleado(e);
		}
		if (e.getSource() == rptAlmacen) {
			actionPerformedRptAlmacen(e);
		}
		if (e.getSource() == mnVenta) {
			actionPerformedMnVenta(e);
		}
		if (e.getSource() == mntVehiculo) {
			actionPerformedMntVehiculo(e);
		}
		if (e.getSource() == mntProveedor) {
			actionPerformedMntProveedor(e);
		}
		if (e.getSource() == mntEmpleado) {
			actionPerformedMntEmpleado(e);
		}
		if (e.getSource() == mnInformacion) {
			actionPerformedMnNewMenu_2(e);
		}
		if (e.getSource() == rptVentas) {
			actionPerformedRptVentas(e);
		}
		if (e.getSource() == rptVehiculos) {
			actionPerformedRptVehiculos(e);
		}
		if (e.getSource() == mntAlmacen) {
			actionPerformedMntmNewMenuItem_1(e);
		}
		if (e.getSource() == mntSalir) {
			actionPerformedMntSalir(e);
		}
	}
	protected void actionPerformedMntSalir(ActionEvent e) {
		System.exit(0);
	}
	protected void actionPerformedMntmNewMenuItem_1(ActionEvent e) {
		FrmAlmacen almacen = new FrmAlmacen();
		almacen.setVisible(true);
	}
	protected void actionPerformedRptVehiculos(ActionEvent e) {
		FrmReporteVehiculos rptVehi = new FrmReporteVehiculos();
		rptVehi.setVisible(true);
	}
	protected void actionPerformedRptVentas(ActionEvent e) {
		FrmReporteVentas rptVentas = new FrmReporteVentas();
		rptVentas.setVisible(true);
	}
	protected void actionPerformedMnNewMenu_2(ActionEvent e) {		
	}
	
	protected void actionPerformedMntEmpleado(ActionEvent e) {
		FrmEmpleado empleado = new FrmEmpleado();
		empleado.setVisible(true);
	}
	protected void actionPerformedMntProveedor(ActionEvent e) {
		FrmProveedor proveedor = new FrmProveedor();
		proveedor.setVisible(true);
	}
	protected void actionPerformedMntVehiculo(ActionEvent e) {
		FrmVehiculo vehiculo = new FrmVehiculo();
		vehiculo.setVisible(true);
	}
	protected void actionPerformedMnVenta(ActionEvent e) {
		
	}
	protected void actionPerformedRptAlmacen(ActionEvent e) {
		FrmReporteAlmacen almacen = new FrmReporteAlmacen();
		almacen.setVisible(true);
	}
	protected void actionPerformedRptEmpleado(ActionEvent e) {
		FrmReporteEmpleado empleado = new FrmReporteEmpleado();
		empleado.setVisible(true);
	}
	protected void actionPerformedRptProveedor(ActionEvent e) {
		FrmReporteProveedores proveedor = new FrmReporteProveedores();
		proveedor.setVisible(true);
	}
	protected void actionPerformedMntVehiculo1(ActionEvent e) {
		FrmVenta venta = new FrmVenta();
		venta.setVisible(true);
	}
	protected void actionPerformedMntmNewMenuItem(ActionEvent e) {
		FrmInformacion info = new FrmInformacion();
		info.setVisible(true);
	}
}
