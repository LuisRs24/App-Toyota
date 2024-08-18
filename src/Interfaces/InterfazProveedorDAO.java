package Interfaces;

import java.util.ArrayList;

import Entidad.Proveedor;

public interface InterfazProveedorDAO {
	//Registrar 
		public int registrarProveedor(Proveedor P);
		
		//Actualizar
		public int actualizarProveedor(Proveedor P);
		
		//Eliminar
		public int eliminarProveedor(int codProv);
		
		//Consultar Proveedor por código de proveedor
		public Proveedor buscarProveedor(int codProv);
		
		//COnsultar Proveedor por nombre de proveedor
		public Proveedor buscarProveedorNombre(String nomProv);
		
		//Listar todos los proveedores
		public ArrayList<Proveedor> listarProveedor();
		
		

}
