package Hilo;

import Vista.Logueo;

public class HiloTiempo implements Runnable {
	private Logueo logg;
	
	public HiloTiempo(Logueo logg) {
		this.logg = logg;
	}

	@Override
	public void run() {
		// Generamos el contador que irá disminuyendo de 1 en 1 hasta llegar a 0
		for (int i = 20; i >= 0; i--) {
			Logueo.lblTiempo.setText(i + " Segundos");
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				// e.printStackTrace();
				System.out.println("Erro en la pausa del contador" + e.getMessage());
			}
		}

		// Cerramos la ventana logue
		logg.dispose();
		
	}

}
