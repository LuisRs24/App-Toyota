package Hilo;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JLabel;

import Vista.FrmPreLoader;
import Vista.FrmMenuTOYOTA;

public class HiloReloj extends Thread{
	private JFrame ventana;
	private JLabel lblhora;

public HiloReloj(JFrame ventana, JLabel lblhora) {
		super();
		this.ventana = ventana;
		this.lblhora = lblhora;
	}

@Override
public void run() {
	// TODO Auto-generated method stub
	//super.run();
	
	while(true) {
		//obtenmos la hora del sistema
		Date fecha = new Date();
		
		//indicamos el patrón
		SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
		
		//Mostrar la hora en el lblHOra
		lblhora.setText(sdf.format(fecha)); //Ventana donde mostrar la hora
	}
	
}
}
