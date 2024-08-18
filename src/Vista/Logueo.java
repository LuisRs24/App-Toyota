package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Entidad.Empleado;
import Entidad.Usuario;
import Hilo.HiloTiempo;
import Mantenimiento.UsuarioGestionDAO;

import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.awt.event.WindowEvent;
import java.awt.event.FocusListener;
import java.awt.event.FocusEvent;
import javax.swing.SwingConstants;
import java.awt.Color;

public class Logueo extends JFrame implements WindowListener, ActionListener, FocusListener {

	private JPanel contentPane;
	private JTextField txtCodigo;
	private JPasswordField txtClave;
	public static Logueo frame;
	private JButton btnAceptar;
	private JLabel lblNewLabel;
	public static JLabel lblTiempo; // cambiamos a publica

	private UsuarioGestionDAO gUsu = new UsuarioGestionDAO();
	private Empleado empleado;
	private JLabel lblUsuario;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Logueo();
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
	public Logueo() {
		setResizable(false);
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		addWindowListener(this);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Logueo.class.getResource("/img/toyo_log.png")));
		setTitle("TOYOTA - Acceso al Sistema");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 425, 311);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);

		lblUsuario = new JLabel("USUARIO");
		lblUsuario.addFocusListener(this);
		lblUsuario.setFont(new Font("Cambria", Font.PLAIN, 16));
		lblUsuario.setBounds(147, 91, 96, 20);
		contentPane.add(lblUsuario);

		JLabel lblClave = new JLabel("CLAVE");
		lblClave.setFont(new Font("Cambria", Font.PLAIN, 16));
		lblClave.setBounds(204, 146, 76, 20);
		contentPane.add(lblClave);

		txtCodigo = new JTextField();
		txtCodigo.addFocusListener(this);
		txtCodigo.setBounds(265, 92, 103, 22);
		contentPane.add(txtCodigo);
		txtCodigo.setColumns(10);

		txtClave = new JPasswordField();
		txtClave.setBounds(272, 145, 103, 22);
		contentPane.add(txtClave);

		btnAceptar = new JButton("Aceptar");
		btnAceptar.setHorizontalAlignment(SwingConstants.LEFT);
		btnAceptar.setIcon(new ImageIcon(Logueo.class.getResource("/img/check2.png")));
		btnAceptar.addActionListener(this);
		btnAceptar.setBounds(191, 205, 109, 33);
		contentPane.add(btnAceptar);

		JButton btnSalir = new JButton("Salir");
		btnSalir.setIcon(new ImageIcon(Logueo.class.getResource("/img/cancel.png")));
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSalir.setBounds(310, 205, 89, 33);
		contentPane.add(btnSalir);

		JLabel lblFondo = new JLabel("");
		lblFondo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFondo.setAutoscrolls(true);
		lblFondo.setIcon(new ImageIcon(Logueo.class.getResource("/img/img_login.png")));
		lblFondo.setBounds(0, 77, 194, 195);
		contentPane.add(lblFondo);

		lblNewLabel = new JLabel("Esta ventana se cerrar\u00E1 en:");
		lblNewLabel.setForeground(Color.YELLOW);
		lblNewLabel.setBounds(79, 30, 239, 14);
		contentPane.add(lblNewLabel);

		lblTiempo = new JLabel("10 Segundos");
		lblTiempo.setForeground(Color.YELLOW);
		lblTiempo.setBounds(257, 30, 96, 14);
		contentPane.add(lblTiempo);
	}

	// Crear el método para el contador
	void InicializarContador() {
		HiloTiempo ht = new HiloTiempo(this);
		Thread thr = new Thread(ht);
		thr.start();
	}

	public void windowActivated(WindowEvent e) {
	}

	public void windowClosed(WindowEvent e) {
	}

	public void windowClosing(WindowEvent e) {
	}

	public void windowDeactivated(WindowEvent e) {
	}

	public void windowDeiconified(WindowEvent e) {
	}

	public void windowIconified(WindowEvent e) {
	}

	public void windowOpened(WindowEvent e) {
		if (e.getSource() == this) {
			windowOpenedThis(e);
		}
	}

	protected void windowOpenedThis(WindowEvent e) {
		// Llamamos al método que inicializa el contador
		InicializarContador();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAceptar) {
			actionPerformedBtnAceptar(e);
		}
	}

	protected void actionPerformedBtnAceptar(ActionEvent e) {
		validarUsuario();
	}
	
	

	private void validarUsuario() {
		String cod = txtCodigo.getText().trim().toUpperCase();
		String pass = String.valueOf(txtClave.getPassword()).trim();
		
		int contra = Integer.parseInt(pass);
		
		Usuario Usu = gUsu.buscarUsuario(cod);	
		
		if (txtCodigo.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(null, "El campo CODIGO esta vacio","Advertencia",JOptionPane.WARNING_MESSAGE);
		} else if (String.valueOf(txtClave.getPassword()).trim().equals("")) {
			JOptionPane.showMessageDialog(null, "El campo CLAVE esta vacio","Advertencia",JOptionPane.WARNING_MESSAGE);
		} else if (Usu == null){
			mensajeError("El usuario ingresado no está registrado");
		}else {
				int passCon = Integer.parseInt(Usu.getClave());		
				
				if(contra == passCon) {
					FrmPreLoader v = new FrmPreLoader();
					v.setVisible(true);	
					this.setVisible(false);
									
				}else {
					mensajeError("Contraseña Inválida");
				}			
		}				
	}

	public void focusGained(FocusEvent e) {
	}
	public void focusLost(FocusEvent e) {
		if (e.getSource() == txtCodigo) {
			do_txtCodigo_focusLost(e);
		}
		if (e.getSource() == lblUsuario) {
			do_lblUsuario_focusLost(e);
		}
	}
	protected void do_lblUsuario_focusLost(FocusEvent e) {
	}
	protected void do_txtCodigo_focusLost(FocusEvent e) {
		txtCodigo.setText(txtCodigo.getText().trim().toUpperCase());
	}
	
	private void mensajeError(String msj) {
		JOptionPane.showMessageDialog(this, msj, "Error !!", 0);
	}
}
