package Utils;

public class Validaciones {

	public static final String CodProd = "[P0-9]{5}";

//Personal
	public static final String CodigoPersonal = "[P][0-9]{3}";
	public static final String NombrePersonal = "[a-zA-z¡…Õ”⁄·ÈÌÛ˙\\s]{3,30}";
	public static final String DireccionPersonal = "[\\w.\\s]{10,80}";
	public static final String EmailPersonal = "^[\\w-]+(\\.[\\w-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	public static final String TelefonoPersonal = "[0-9]{9}";

//Proveedor
	public static final String CodigoProveedor = "[0-9]{1,}";
	public static final String NombreProveedor = "[a-zA-z¡…Õ”⁄·ÈÌÛ˙\\s]{3,30}";
	public static final String EmailProveedor = "^[\\w-]+(\\.[\\w-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	public static final String DireccionProveedor = "[\\w.\\s]{10,80}";

//Vehiculo
	public static final String MotorNombre = "[\\w-\\s]{4,30}";
	public static final String IdVehiculo = "[VHT][0-9]{6}";

}
