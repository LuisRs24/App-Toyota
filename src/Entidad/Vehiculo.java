package Entidad;

public class Vehiculo {
	
	private String id;
	private String nommodel;
	private String motor;
	private int cilindros;
	private double pesoneto;
	private double pesobruto;
	private String tipTransmision;
	private String gps;
	private String sinoairbag;
	private int asientos;
	private String tipcombustible;
	private String year;
	
	public Vehiculo() {		
	}

	public Vehiculo(String id, String nommodel, String motor, int cilindros, double pesoneto, double pesobruto,
			String tiptransporte, String gps, String sinoairbag, int asientos, String tipcombustible, String year) {
		this.id = id;
		this.nommodel = nommodel;
		this.motor = motor;
		this.cilindros = cilindros;
		this.pesoneto = pesoneto;
		this.pesobruto = pesobruto;
		this.tipTransmision = tiptransporte;
		this.gps = gps;
		this.sinoairbag = sinoairbag;
		this.asientos = asientos;
		this.tipcombustible = tipcombustible;
		this.year = year;
	}

	public String getId() {
		return id;
	}

	public String getNommodel() {
		return nommodel;
	}

	public String getMotor() {
		return motor;
	}

	public int getCilindros() {
		return cilindros;
	}

	public double getPesoneto() {
		return pesoneto;
	}

	public double getPesobruto() {
		return pesobruto;
	}

	public String getTiptransmision() {
		return tipTransmision;
	}

	public String getGps() {
		return gps;
	}

	public String getSinoairbag() {
		return sinoairbag;
	}

	public int getAsientos() {
		return asientos;
	}

	public String getTipcombustible() {
		return tipcombustible;
	}

	public String getYear() {
		return year;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setNommodel(String nommodel) {
		this.nommodel = nommodel;
	}

	public void setMotor(String motor) {
		this.motor = motor;
	}

	public void setCilindros(int cilindros) {
		this.cilindros = cilindros;
	}

	public void setPesoneto(double pesoneto) {
		this.pesoneto = pesoneto;
	}

	public void setPesobruto(double pesobruto) {
		this.pesobruto = pesobruto;
	}

	public void setTiptransporte(String tiptransporte) {
		this.tipTransmision = tiptransporte;
	}

	public void setGps(String gps) {
		this.gps = gps;
	}

	public void setSinoairbag(String sinoairbag) {
		this.sinoairbag = sinoairbag;
	}

	public void setAsientos(int asientos) {
		this.asientos = asientos;
	}

	public void setTipcombustible(String tipcombustible) {
		this.tipcombustible = tipcombustible;
	}

	public void setYear(String year) {
		this.year = year;
	}

}
