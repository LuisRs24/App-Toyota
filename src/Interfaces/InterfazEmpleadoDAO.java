package Interfaces;

import java.util.ArrayList;

import Entidad.Empleado;

public interface InterfazEmpleadoDAO {
	//Registrar 
	public int registrarEmpleado(Empleado E);
			
	//Actualizar
	public int actualizarEmpleado(Empleado E);
			
	//Eliminar
	public int eliminarEmpleado(String codEmp);
			
	//Consultar Empleado por código de empleado
	public Empleado buscarEmpleado(String codEmp);
			
	//Listar todos los empleados
	public ArrayList<Empleado> listarEmpleado();
	
	//Buscar por nombre de empleado
	public Empleado buscarNombre(String nomEmp);
	
}
