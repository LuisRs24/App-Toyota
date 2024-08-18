package Entidad;

public class Venta {
	private int cod_venta, dni_cli;
	private	String nom_cli,fono_cli, id_aut, fecha_venta;
	private double precio_venta, dscto_venta,mont_tot_venta;
	
	//Constructor sin parámetros
	public Venta() {
	}
	
	//Constructor con parámetros
	public Venta(int cod_venta, int dni_cli, String nom_cli, String fono_cli, String id_aut, String fecha_venta,
			double precio_venta, double dscto_venta, double mont_tot_venta) {
		super();
		this.cod_venta = cod_venta;
		this.dni_cli = dni_cli;
		this.nom_cli = nom_cli;
		this.fono_cli = fono_cli;
		this.id_aut = id_aut;
		this.fecha_venta = fecha_venta;
		this.precio_venta = precio_venta;
		this.dscto_venta = dscto_venta;
		this.mont_tot_venta = mont_tot_venta;
	}

	public int getCod_venta() {
		return cod_venta;
	}

	public void setCod_venta(int cod) {
		this.cod_venta = cod;
	}

	public int getDni_cli() {
		return dni_cli;
	}

	public void setDni_cli(int dni_cli) {
		this.dni_cli = dni_cli;
	}

	public String getNom_cli() {
		return nom_cli;
	}

	public void setNom_cli(String nom_cli) {
		this.nom_cli = nom_cli;
	}

	public String getFono_cli() {
		return fono_cli;
	}

	public void setFono_cli(String fono_cli) {
		this.fono_cli = fono_cli;
	}

	public String getId_aut() {
		return id_aut;
	}

	public void setId_aut(String id_aut) {
		this.id_aut = id_aut;
	}

	public String getFecha_venta() {
		return fecha_venta;
	}

	public void setFecha_venta(String fecha_venta) {
		this.fecha_venta = fecha_venta;
	}

	public double getPrecio_venta() {
		return precio_venta;
	}

	public void setPrecio_venta(double precio_venta) {
		this.precio_venta = precio_venta;
	}

	public double getDscto_venta() {
		return dscto_venta;
	}

	public void setDscto_venta(double dscto_venta) {
		this.dscto_venta = dscto_venta;
	}

	public double getMont_tot_venta() {
		return mont_tot_venta;
	}

	public void setMont_tot_venta(double mont_tot_venta) {
		this.mont_tot_venta = mont_tot_venta;
	}	
}
