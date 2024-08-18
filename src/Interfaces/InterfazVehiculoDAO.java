package Interfaces;

import java.util.ArrayList;

import Entidad.Vehiculo;

public interface InterfazVehiculoDAO {
	// Registrar
	public int registrarVehiculo(Vehiculo A);

	// Actualizar
	public int actualizarVehiculo(Vehiculo A);

	// Eliminar
	public int eliminarVehiculo(String numVehiculo);

	// Consultar Almacen por n�mero de veh�culo
	public Vehiculo buscarVehiculo(String numVehiculo);
	
	//Consultar Veh�culo por modelo de Veh�culo
	public ArrayList<Vehiculo> buscarVehiculoModelo(String mod);

	// Listar todos los veh�culos
	public ArrayList<Vehiculo> listarVehiculo();

}
