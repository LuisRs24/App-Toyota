package Entidad;

public class Almacen {
	private int num_alm, cap_alm;
	private String dir_alm, fon_alm, email_alm, dpto_alm;
	
	//Constructor sin parámetros	
	public Almacen() {
	}
	
	//Constructor con parámetros
	public Almacen(int num_alm, String dir_alm, String fon_alm, String email_alm, int cap_alm, String dpto_alm) {
		super();
		this.num_alm = num_alm;
		this.dir_alm = dir_alm;
		this.fon_alm = fon_alm;
		this.email_alm = email_alm;
		this.cap_alm = cap_alm;
		this.dpto_alm = dpto_alm;
	}

	public int getNum_alm() {
		return num_alm;
	}

	public void setNum_alm(int num_alm) {
		this.num_alm = num_alm;
	}

	public String getDir_alm() {
		return dir_alm;
	}

	public void setDir_alm(String dir_alm) {
		this.dir_alm = dir_alm;
	}

	public String getFon_alm() {
		return fon_alm;
	}

	public void setFon_alm(String fon_alm) {
		this.fon_alm = fon_alm;
	}

	public String getEmail_alm() {
		return email_alm;
	}

	public void setEmail_alm(String email_alm) {
		this.email_alm = email_alm;
	}

	public int getCap_alm() {
		return cap_alm;
	}

	public void setCap_alm(int cap_alm) {
		this.cap_alm = cap_alm;
	}

	public String getDpto_alm() {
		return dpto_alm;
	}

	public void setDpto_alm(String dpto_alm) {
		this.dpto_alm = dpto_alm;
	}
	
	
	

}
