package Mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Entidad.Proveedor;
import Entidad.Vehiculo;
import Interfaces.InterfazVehiculoDAO;
import Utils.MySQLConexion8;

public class VehiculoGestionDAO implements InterfazVehiculoDAO {

	@Override
	public int registrarVehiculo(Vehiculo v) {
		int estado = 0;
		Connection con = null;
		PreparedStatement pstm = null;
		try {
			con = MySQLConexion8.getConexion();
			String sql = "INSERT INTO tb_automovil VALUES(?,?,?,?,?,?,?,?,?,?,?,?);";
			pstm = con.prepareStatement(sql);
			pstm.setString(1, v.getId());
			pstm.setString(2, v.getNommodel());
			pstm.setString(3, v.getMotor());
			pstm.setInt(4, v.getCilindros());
			pstm.setDouble(5, v.getPesoneto());
			pstm.setDouble(6, v.getPesobruto());
			pstm.setString(7, v.getTiptransmision());
			pstm.setString(8, v.getGps());
			pstm.setString(9, v.getSinoairbag());
			pstm.setInt(10, v.getAsientos());
			pstm.setString(11, v.getTipcombustible());
			pstm.setString(12, v.getYear());

			estado = pstm.executeUpdate();

		} catch (Exception e) {
			System.out.println("Error en la instrucción SQL registrar Vehiculo" + e.getMessage());
		} finally {
			try {
				if (pstm != null)
					pstm.close();
				if (con != null)
					con.close();
			} catch (Exception e2) {
				System.out.println("Error al cerrar la base de datos" + e2.getLocalizedMessage());
			}
		}
		return estado;
	}

	@Override
	public int actualizarVehiculo(Vehiculo v) {
		int estado = 0;
		Connection con = null;
		PreparedStatement pstm = null;
		try {
			con = MySQLConexion8.getConexion();
			String sql = "UPDATE tb_automovil SET nom_modelo_aut = ?, tipomotor_aut = ?, cilindros_aut = ?, peso_neto = ?, peso_bruto = ?, tipo_trans_aut = ?, gps_aut = ?, airbag_aut = ?, asientos_aut = ?, combustible_aut = ?, year_aut = ? where id_aut = ?;";
			pstm = con.prepareStatement(sql);
			// Obtenerparámetros
			pstm.setString(1, v.getNommodel());
			pstm.setString(2, v.getMotor());
			pstm.setInt(3, v.getCilindros());
			pstm.setDouble(4, v.getPesoneto());
			pstm.setDouble(5, v.getPesobruto());
			pstm.setString(6, v.getTiptransmision());
			pstm.setString(7, v.getGps());
			pstm.setString(8, v.getSinoairbag());
			pstm.setInt(9, v.getAsientos());
			pstm.setString(10, v.getTipcombustible());
			pstm.setString(11, v.getYear());
			pstm.setString(12, v.getId());

			estado = pstm.executeUpdate();

		} catch (Exception e) {
			System.out.println("Error en la instrucción SQL actualizar Vehiculo;" + e.getMessage());
		} finally {
			try {
				if (pstm != null)
					pstm.close();
				if (con != null)
					con.close();
			} catch (Exception e2) {
				System.out.println("Error al cerrar la base de datos" + e2.getLocalizedMessage());
			}
		}
		return estado;
	}

	@Override
	public int eliminarVehiculo(String numVehiculo) {
		int estado = 0;
		Connection con = null;
		PreparedStatement pstm = null;
		try {
			con = MySQLConexion8.getConexion();
			String sql = "DELETE FROM tb_automovil WHERE id_aut = ?;";
			pstm = con.prepareStatement(sql);

			// Eliminar por el número de Proveedor
			pstm.setString(1, numVehiculo);

			// Ejecutamos instrucción SQL
			estado = pstm.executeUpdate();

		} catch (Exception e) {
			System.out.println("Error en la instrucción SQL Eliminar Vehiculo" + e.getMessage());
		} finally {
			try {
				if (pstm != null)
					pstm.close();
				if (con != null)
					con.close();
			} catch (Exception e2) {
				System.out.println("Error al cerrar la base de datos" + e2.getLocalizedMessage());
			}
		}
		return estado;
	}

	@Override
	public Vehiculo buscarVehiculo(String idVe) {
		Vehiculo veh = null;
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet res = null;
		try {
			con = MySQLConexion8.getConexion();
			String sql = "SELECT * FROM tb_automovil WHERE id_aut=?;";
			pstm = con.prepareStatement(sql);
			pstm.setString(1, idVe);			
			res = pstm.executeQuery();
			
			if(res.next()) {
				veh = new Vehiculo(res.getString(1),
									res.getString(2),
									res.getString(3),
									res.getInt(4),
									res.getDouble(5),
									res.getDouble(6),
									res.getString(7),
									res.getString(8),
									res.getString(9),
									res.getInt(10),
									res.getString(11),
									res.getString(12));				
			}
		} catch (Exception e) {
			System.out.println("Error en la instrucción SQL SELECT * FROM tb_automovil WHERE id_aut=?;" + e.getMessage());
		}finally {
			try {
				if(pstm != null)
					pstm.close();
				if (res != null)
					res.close();
				if(con != null)
					con.close();
			} catch (Exception e2) {
				System.out.println("Error al cerrar la base de datos"+e2.getLocalizedMessage());
			}
		}		
		return veh;
	}

	@Override
	public ArrayList<Vehiculo> listarVehiculo() {
		Vehiculo vehi = null;
		ArrayList<Vehiculo> listVehiculo = new ArrayList<Vehiculo>();
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet res = null;
		try {
			con = MySQLConexion8.getConexion();
			String sql = "SELECT * FROM tb_automovil;";
			pstm = con.prepareStatement(sql);
			res = pstm.executeQuery();

			// bucle para listar Automovil
			while (res.next()) {
				vehi = new Vehiculo();
				// asignamos los valores a los atributos privados
				vehi.setId(res.getString(1));
				vehi.setNommodel(res.getString(2));
				vehi.setMotor(res.getString(3));
				vehi.setCilindros(res.getInt(4));
				vehi.setPesoneto(res.getDouble(5));
				vehi.setPesobruto(res.getDouble(6));
				vehi.setTiptransporte(res.getString(7));
				vehi.setGps(res.getString(8));
				vehi.setSinoairbag(res.getString(9));
				vehi.setAsientos(res.getInt(10));
				vehi.setTipcombustible(res.getString(11));
				vehi.setYear(res.getString(12));

				// agregamos a la lista
				listVehiculo.add(vehi);
			}
		} catch (Exception e) {
			System.out.println("Error en la instrucción SQL listar Vehiculo" + e.getMessage());
		} finally {
			try {
				if (pstm != null)
					pstm.close();
				if (res != null)
					res.close();
				if (con != null)
					con.close();
			} catch (Exception e2) {
				System.out.println("Error al cerrar la base de datos" + e2.getLocalizedMessage());
			}
		}
		return listVehiculo;
	}

	@Override
	public ArrayList<Vehiculo> buscarVehiculoModelo(String mod) {
		Vehiculo vehi = null;
		ArrayList<Vehiculo> listVeh = new ArrayList<Vehiculo>();
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet res = null;
		try {
			con = MySQLConexion8.getConexion();
			String sql = "SELECT * FROM tb_automovil WHERE nom_modelo_aut=?;";
			pstm = con.prepareStatement(sql);
			pstm.setString(1, mod);		
			res = pstm.executeQuery();

			// bucle para listar Automovil
			while (res.next()) {
				vehi = new Vehiculo();
				// asignamos los valores a los atributos privados
				vehi.setId(res.getString(1));
				vehi.setNommodel(res.getString(2));
				vehi.setMotor(res.getString(3));
				vehi.setCilindros(res.getInt(4));
				vehi.setPesoneto(res.getDouble(5));
				vehi.setPesobruto(res.getDouble(6));
				vehi.setTiptransporte(res.getString(7));
				vehi.setGps(res.getString(8));
				vehi.setSinoairbag(res.getString(9));
				vehi.setAsientos(res.getInt(10));
				vehi.setTipcombustible(res.getString(11));
				vehi.setYear(res.getString(12));

				// agregamos a la lista
				listVeh.add(vehi);
			}
		} catch (Exception e) {
			System.out.println("Error en la instrucción SQL SELECT * FROM tb_automovil WHERE nom_modelo_aut=?;" + e.getMessage());
		} finally {
			try {
				if (pstm != null)
					pstm.close();
				if (res != null)
					res.close();
				if (con != null)
					con.close();
			} catch (Exception e2) {
				System.out.println("Error al cerrar la base de datos" + e2.getLocalizedMessage());
			}
		}
		return listVeh;
	}
}
