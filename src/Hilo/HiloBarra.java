package Hilo;

import Vista.FrmPreLoader;

public class HiloBarra extends Thread {
	@Override
	public void run() {
		// TODO Auto-generated method stub
		//super.run();
		for (int i=0; i<=50;i++) {
			FrmPreLoader.prbCarga.setValue(i);		
			
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				System.out.println("Error en la carga de la barra"+e.getMessage());
			}
		}
	}
}