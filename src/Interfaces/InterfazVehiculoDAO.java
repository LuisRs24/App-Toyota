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

	// Consultar Almacen por número de vehículo
	public Vehiculo buscarVehiculo(String numVehiculo);
	
	//Consultar Vehículo por modelo de Vehículo
	public ArrayList<Vehiculo> buscarVehiculoModelo(String mod);

	// Listar todos los vehículos
	public ArrayList<Vehiculo> listarVehiculo();

}
