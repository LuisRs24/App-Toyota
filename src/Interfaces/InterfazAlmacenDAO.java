package Interfaces;

import java.util.ArrayList;

import Entidad.Almacen;

public interface InterfazAlmacenDAO {
	//Registrar 
	public int registrarAlmacen(Almacen A);
	
	//Actualizar
	public int actualizarAlmacen(Almacen A);
	
	//Eliminar
	public int eliminarALmacen(int numAlmacen);
	
	//Consultar Almacen por número de almacén
	public Almacen buscarAlmacen(int numALmacen);
	
	//Consultar Almacen por Departamento
	public Almacen buscarAlmacenDepartamento(String dep);
	
	//Listar todos los almacenes
	public ArrayList<Almacen> listarAlmacen();

}
