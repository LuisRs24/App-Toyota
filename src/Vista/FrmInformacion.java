package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.Font;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.SystemColor;
import javax.swing.ImageIcon;

public class FrmInformacion extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmInformacion frame = new FrmInformacion();
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
	public FrmInformacion() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrmInformacion.class.getResource("/img/toyo_log.png")));
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		setTitle("Cr\u00E9ditos");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("INTEGRANTES");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBackground(Color.GRAY);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 15, 414, 47);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("- Luis Enrique Remigio Socorro ");
		lblNewLabel_1.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(61, 83, 332, 14);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("- Yoana Milagritos Contreras Aguilar ");
		lblNewLabel_2.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(61, 162, 332, 14);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("- Ernestor Eladio Gutierrez C\u00E1ceres");
		lblNewLabel_3.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(61, 108, 351, 14);
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("- Juan Eudes Mu\u00F1oz L\u00F3pez");
		lblNewLabel_4.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(61, 137, 203, 14);
		contentPane.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("\"Feliz D\u00EDa del Maestro Miss Vaneza Arteaga Vega");
		lblNewLabel_5.setForeground(new Color(50, 205, 50));
		lblNewLabel_5.setFont(new Font("Script MT Bold", Font.BOLD, 16));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(10, 205, 414, 45);
		contentPane.add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_6.setIcon(new ImageIcon(FrmInformacion.class.getResource("/img/CIBERTEC .png")));
		lblNewLabel_6.setBounds(312, 83, 98, 86);
		contentPane.add(lblNewLabel_6);
	}
}
