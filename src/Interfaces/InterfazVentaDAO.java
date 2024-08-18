package Interfaces;

import java.sql.Date;
import java.util.ArrayList;

import Entidad.Venta;

public interface InterfazVentaDAO {
	//Registrar 
	public int registrarVenta(Venta Ven);
	
	//Consultar venta por código de venta
	public Venta buscarVenta(int codVen);
	
	//Listar ventas por fecha
	public ArrayList<Venta> listarVentaFecha(String Fe);
	
	//Listar todas las Ventas
	public ArrayList<Venta> listarVenta();

}
