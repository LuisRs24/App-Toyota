package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JProgressBar;
import javax.swing.JLabel;
import java.awt.Dialog.ModalExclusionType;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.event.ChangeListener;

import Hilo.HiloBarra;
import Hilo.HiloReloj;

import javax.swing.event.ChangeEvent;
import javax.swing.ImageIcon;
import java.awt.Component;
import java.awt.Toolkit;

public class FrmPreLoader extends JFrame implements ChangeListener {

	public JPanel contentPane;
	public static JProgressBar prbCarga;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmPreLoader frame = new FrmPreLoader();
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
	public FrmPreLoader() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrmPreLoader.class.getResource("/img/toyo_log.png")));
		setForeground(Color.BLACK);
		setTitle("Cargando...");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 324, 347);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		prbCarga = new JProgressBar();
		prbCarga.setMaximum(50);
		prbCarga.addChangeListener(this);
		prbCarga.setBounds(10, 278, 288, 19);
		contentPane.add(prbCarga);
		
		JLabel lblMensajes = new JLabel("El sistema est\u00E1 cargando, espere unos segundos");
		lblMensajes.setForeground(Color.YELLOW);
		lblMensajes.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMensajes.setHorizontalAlignment(SwingConstants.CENTER);
		lblMensajes.setBounds(0, 254, 313, 14);
		contentPane.add(lblMensajes);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel.setAlignmentY(0.0f);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(FrmPreLoader.class.getResource("/img/toyota_qethtiwh.gif")));
		lblNewLabel.setBounds(10, 0, 288, 280);
		contentPane.add(lblNewLabel);
		CargarBarra();
	}
	void CargarBarra() {
		HiloBarra hb = new HiloBarra();
		hb.start();		
	}
	
	public void stateChanged(ChangeEvent e) {
		if (e.getSource() == prbCarga) {
			stateChangedPrbCarga(e);
		}
	}
	protected void stateChangedPrbCarga(ChangeEvent e) {
		abrirVentanaPrincipal();
	}

	private void abrirVentanaPrincipal() {
		if(prbCarga.getValue()==50) {
			FrmMenuTOYOTA menu = new FrmMenuTOYOTA();
			menu.setVisible(true);
			this.dispose();
		}
	}
}
