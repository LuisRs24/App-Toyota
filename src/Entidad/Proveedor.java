package Entidad;

//import guis.proveedor;

public class Proveedor {
	private int cod;
	private String nomprove, direcc, telef, email;
	
	public Proveedor() {
		
	}

	public Proveedor(int cod, String nomprove, String direcc, String telef, String email) {
		super();
		this.cod = cod;
		this.nomprove = nomprove;
		this.direcc = direcc;
		this.telef = telef;
		this.email = email;
		
	}

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public String getNomprove() {
		return nomprove;
	}

	public void setNomprove(String nomprove) {
		this.nomprove = nomprove;
	}

	public String getDirecc() {
		return direcc;
	}

	public void setDirecc(String direcc) {
		this.direcc = direcc;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelef() {
		return telef;
	}

	public void setTelef(String telef) {
		this.telef = telef;
	}

	
}
