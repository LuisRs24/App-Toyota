package Mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Entidad.Empleado;
import Interfaces.InterfazEmpleadoDAO;
import Utils.MySQLConexion8;

public class EmpleadoGestionDAO implements InterfazEmpleadoDAO{

	@Override
	public int registrarEmpleado(Empleado E) {
		int estado=0;
		Connection con = null;
		PreparedStatement pstm = null;
		try {			
				con = MySQLConexion8.getConexion();
				String sql = "INSERT INTO tb_empleado VALUES(?,?,?,?,?,?,?);";
				pstm = con.prepareStatement(sql);
				pstm.setString(1, E.getCod_emple());
				pstm.setString(2, E.getNom_emple());
				pstm.setString(3, E.getCar_emple());
				pstm.setDouble(4, E.getSueldo_emple());
				pstm.setString(5, E.getDir_emple());
				pstm.setString(6, E.getTel_emple());
				pstm.setString(7, E.getEmail_emple());
				
				estado = pstm.executeUpdate();			
		
		} catch (Exception e) {
			System.out.println("Error en la instrucción SQL registrarEmpleado;" + e.getMessage());		
		}finally {
			try {
				if(pstm != null)
					pstm.close();
				if(con != null)
					con.close();
			} catch (Exception e2) {
				System.out.println("Error al cerrar la base de datos"+e2.getLocalizedMessage());
			}
		}
		return estado;
	}

	@Override
	public int actualizarEmpleado(Empleado E) {
		int estado=0;
		Connection con = null;
		PreparedStatement pstm = null;
		try {			
				con = MySQLConexion8.getConexion();
				String sql = "UPDATE tb_empleado SET nombre_emple=?, cargo_emple=?, sueldo_emple=?, direccion_emple=?, telefono_emple=?, email_emple=? WHERE cod_emple=?;";
				
				pstm = con.prepareStatement(sql);
				//Obtenerparámetros		
				
				pstm.setString(1, E.getNom_emple());
				pstm.setString(2, E.getCar_emple());
				pstm.setDouble(3, E.getSueldo_emple());
				pstm.setString(4, E.getDir_emple());
				pstm.setString(5, E.getTel_emple());
				pstm.setString(6, E.getEmail_emple());
				pstm.setString(7, E.getCod_emple());
				
				estado = pstm.executeUpdate();			
		
		} catch (Exception e) {
			System.out.println("Error en la instrucción SQL ActualizarEmpleado" + e.getMessage());		
		}finally {
			try {
				if(pstm != null)
					pstm.close();
				if(con != null)
					con.close();
			} catch (Exception e2) {
				System.out.println("Error al cerrar la base de datos"+e2.getLocalizedMessage());
			}
		}
		return estado;
	}

	@Override
	public int eliminarEmpleado(String codEmp) {
		int estado=0;
		Connection con = null;
		PreparedStatement pstm = null;
		try {			
				con = MySQLConexion8.getConexion();
				String sql = "delete from tb_empleado WHERE cod_emple=?;";
				
				pstm = con.prepareStatement(sql);
				//Obtenerparámetros		

				pstm.setString(1, codEmp);
				
				estado = pstm.executeUpdate();			
		
		} catch (Exception e) {
			System.out.println("Error en la instrucción SQL EliminarEmpleado" + e.getMessage());		
		}finally {
			try {
				if(pstm != null)
					pstm.close();
				if(con != null)
					con.close();
			} catch (Exception e2) {
				System.out.println("Error al cerrar la base de datos"+e2.getLocalizedMessage());
			}
		}
		return estado;
	}

	@Override
	public Empleado buscarEmpleado(String codEmp) {

		Empleado emp= null;

		PreparedStatement pstm = null;
		Connection con = null;
		ResultSet res = null;

		try {
			// Paso 1: Establecer la conexion con la base de datos
			con = MySQLConexion8.getConexion();

			// PASO 2: establecer la instruccion SQL listar consolas
			String sql = "SELECT * FROM tb_empleado WHERE cod_emple=?;";

			// Paso 3: Enviar la variable SQL al objeto (pstm) ---> obtener los comandos
			pstm = con.prepareStatement(sql);

			// PAso 4: Parametros -------> No hay
			pstm.setString(1, codEmp);
			
			// Paso 5: ejecutar la instruccion
			res = pstm.executeQuery();

			// paso 6

			while (res.next()) {
				emp = new Empleado();
				emp.setCod_emple(res.getString(1));
				emp.setNom_emple(res.getString(2));
				emp.setCar_emple(res.getString(3));
				emp.setSueldo_emple(res.getDouble(4));
				emp.setDir_emple(res.getString(5));
				emp.setTel_emple(res.getString(6));
				emp.setEmail_emple(res.getString(7));
			}

		} catch (Exception e) {
			System.out.println("Error >>> En la instruccion SQL Buscar Empleado por codigo" + e.getMessage());
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}

				if (con != null) {
					con.close();
				}

				if (res != null) {
					res.close();
				}
			} catch (Exception e2) {
				System.out.println("Error al cerrar la base de datos--->" + e2.getMessage());
			}
		}
		return emp;
	}

	@Override
	public ArrayList<Empleado> listarEmpleado() {
		ArrayList<Empleado> lista = new ArrayList<Empleado>();
		Empleado emp;

		PreparedStatement pstm = null;
		Connection con = null;
		ResultSet res = null;

		try {
			// Paso 1: Establecer la conexion con la base de datos
			con = MySQLConexion8.getConexion();

			// PASO 2: establecer la instruccion SQL listar consolas
			String sql = "SELECT * FROM tb_empleado;";

			// Paso 3: Enviar la variable SQL al objeto (pstm) ---> obtener los comandos
			pstm = con.prepareStatement(sql);

			// PAso 4: Parametros -------> No hay
			// Paso 5: ejecutar la instruccion
			res = pstm.executeQuery();

			// paso 6

			while (res.next()) {
				emp = new Empleado();
				emp.setCod_emple(res.getString(1));
				emp.setNom_emple(res.getString(2));
				emp.setCar_emple(res.getString(3));
				emp.setSueldo_emple(res.getDouble(4));
				emp.setDir_emple(res.getString(5));
				emp.setTel_emple(res.getString(6));
				emp.setEmail_emple(res.getString(7));


				lista.add(emp);
			}

		} catch (Exception e) {
			System.out.println("Error >>> En la instruccion SQL listar empleado " + e.getMessage());
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}

				if (con != null) {
					con.close();
				}

				if (res != null) {
					res.close();
				}
			} catch (Exception e2) {
				System.out.println("Error al cerrar la base de datos--->" + e2.getMessage());
			}
		}
		return lista;
	}

	public Empleado buscarNombre(String nomEmp) {
	
		Empleado emp = null;

		PreparedStatement pstm = null;
		Connection con = null;
		ResultSet res = null;

		try {
			// Paso 1: Establecer la conexion con la base de datos
			con = MySQLConexion8.getConexion();

			// PASO 2: establecer la instruccion SQL listar consolas
			String sql = "SELECT * FROM tb_empleado WHERE nombre_emple=?;";

			// Paso 3: Enviar la variable SQL al objeto (pstm) ---> obtener los comandos
			pstm = con.prepareStatement(sql);

			// PAso 4: Parametros -------> No hay
			pstm.setString(1, nomEmp);
			
			// Paso 5: ejecutar la instruccion
			res = pstm.executeQuery();

			// paso 6

			while (res.next()) {
				emp = new Empleado();
				emp.setCod_emple(res.getString(1));
				emp.setNom_emple(res.getString(2));
				emp.setCar_emple(res.getString(3));
				emp.setSueldo_emple(res.getDouble(4));
				emp.setDir_emple(res.getString(5));
				emp.setTel_emple(res.getString(6));
				emp.setEmail_emple(res.getString(7));
			}

		} catch (Exception e) {
			System.out.println("Error >>> En la instruccion SQL Buscar Empleado por nombre" + e.getMessage());
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}

				if (con != null) {
					con.close();
				}

				if (res != null) {
					res.close();
				}
			} catch (Exception e2) {
				System.out.println("Error al cerrar la base de datos--->" + e2.getMessage());
			}
		}
		return emp;

	}
}
