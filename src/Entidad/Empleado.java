package Entidad;

public class Empleado {	
	
	private String cod_emple, nom_emple,car_emple;
	private double sueldo_emple;
	private String dir_emple;
	private String tel_emple, email_emple;
	
	public Empleado() {
	}

	public Empleado(String cod_emple, String nom_emple, String car_emple, double sueldo_emple, String dir_emple,
			String tel_emple, String email_emple) {
		super();
		this.cod_emple = cod_emple;
		this.nom_emple = nom_emple;
		this.car_emple = car_emple;
		this.sueldo_emple = sueldo_emple;
		this.dir_emple = dir_emple;
		this.tel_emple = tel_emple;
		this.email_emple = email_emple;
	}

	public String getCod_emple() {
		return cod_emple;
	}

	public void setCod_emple(String cod_emple) {
		this.cod_emple = cod_emple;
	}

	public String getNom_emple() {
		return nom_emple;
	}

	public void setNom_emple(String nom_emple) {
		this.nom_emple = nom_emple;
	}

	public String getCar_emple() {
		return car_emple;
	}

	public void setCar_emple(String car_emple) {
		this.car_emple = car_emple;
	}

	public double getSueldo_emple() {
		return sueldo_emple;
	}

	public void setSueldo_emple(double sueldo_emple) {
		this.sueldo_emple = sueldo_emple;
	}

	public String getDir_emple() {
		return dir_emple;
	}

	public void setDir_emple(String dir_emple) {
		this.dir_emple = dir_emple;
	}

	public String getTel_emple() {
		return tel_emple;
	}

	public void setTel_emple(String tel_emple) {
		this.tel_emple = tel_emple;
	}

	public String getEmail_emple() {
		return email_emple;
	}

	public void setEmail_emple(String email_emple) {
		this.email_emple = email_emple;
	}
}
