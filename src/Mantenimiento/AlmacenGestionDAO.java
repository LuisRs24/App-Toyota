package Mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Entidad.Almacen;
import Interfaces.InterfazAlmacenDAO;
import Utils.MySQLConexion8;

public class AlmacenGestionDAO implements InterfazAlmacenDAO {

	@Override
	public int registrarAlmacen(Almacen A) {
		int estado = 0;
		Connection con = null;
		PreparedStatement pstm = null;
		try {
			con = MySQLConexion8.getConexion();
			String sql = "INSERT INTO tb_almacen VALUES(?,?,?,?,?,?);";
			pstm = con.prepareStatement(sql);
			
			pstm.setInt(1,A.getNum_alm());
			pstm.setString(2, A.getDir_alm());
			pstm.setString(3, A.getFon_alm());
			pstm.setString(4, A.getEmail_alm());
			pstm.setInt(5, A.getCap_alm());
			pstm.setString(6, A.getDpto_alm());

			estado = pstm.executeUpdate();

		} catch (Exception e) {
			System.out.println("Error en la instrucción SQL registrar almacen" + e.getMessage());
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
	public int actualizarAlmacen(Almacen A) {
		int estado = 0;
		Connection con = null;
		PreparedStatement pstm = null;
		try {
			con = MySQLConexion8.getConexion();
			String sql = "UPDATE tb_almacen SET dir_almcn=?, fono_almcn=?, email_almcn=?, cap_almcn=?,dpto_almcn=? WHERE numero_almcn=?;";
			pstm = con.prepareStatement(sql);
			// Obtenerparámetros
			pstm.setString(1, A.getDir_alm());
			pstm.setString(2, A.getFon_alm());
			pstm.setString(3, A.getEmail_alm());
			pstm.setInt(4, A.getCap_alm());
			pstm.setString(5, A.getDpto_alm());

			pstm.setInt(6, A.getNum_alm());

			estado = pstm.executeUpdate();

		} catch (Exception e) {
			System.out.println("Error en la instrucción SQL actualizar almacen;" + e.getMessage());
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
	public int eliminarALmacen(int numAlmacen) {
		int estado = 0;
		Connection con = null;
		PreparedStatement pstm = null;
		try {
			con = MySQLConexion8.getConexion();
			String sql = "DELETE FROM tb_almacen WHERE numero_almcn=?;";
			pstm = con.prepareStatement(sql);

			// Eliminar por el número de almacen
			pstm.setInt(1, numAlmacen);

			// Ejecutamos instrucción SQL
			estado = pstm.executeUpdate();

		} catch (Exception e) {
			System.out.println("Error en la instrucción SQL EliminarAlamacen" + e.getMessage());
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
	public Almacen buscarAlmacen(int numALmacen) {
		Almacen alm = null;
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet res = null;
		try {
			con = MySQLConexion8.getConexion();
			String sql = "SELECT * FROM tb_almacen WHERE numero_almcn=?;";
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, numALmacen);			
			res = pstm.executeQuery();
			
			if(res.next()) {
				alm = new Almacen(res.getInt(1),
									res.getString(2),
									res.getString(3),
									res.getString(4),
									res.getInt(5),
									res.getString(6));				
			}
		} catch (Exception e) {
			System.out.println("Error en la instrucción SQL SELECT * FROM tb_almacen WHERE numero_almcn=?;" + e.getMessage());
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
		return alm;
	}

	@Override
	public ArrayList<Almacen> listarAlmacen() {
		Almacen alm = null;
		ArrayList<Almacen> listAlmacen = new ArrayList<Almacen>();
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet res = null;
		try {
			con = MySQLConexion8.getConexion();
			String sql = "SELECT * FROM tb_almacen;";
			pstm = con.prepareStatement(sql);
			res = pstm.executeQuery();

			// bucle para listar Almacenes
			while (res.next()) {
				alm = new Almacen();
				// asignamos los valores a los atributos privados
				alm.setNum_alm(res.getInt(1));
				alm.setDir_alm(res.getString(2));
				alm.setFon_alm(res.getString(3));
				alm.setEmail_alm(res.getString(4));
				alm.setCap_alm(res.getInt(5));
				alm.setDpto_alm(res.getString(6));
				// agregamos a la lista
				listAlmacen.add(alm);
			}
		} catch (Exception e) {
			System.out.println("Error en la instrucción SQL listar almacen" + e.getMessage());
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
		return listAlmacen;
	}

	@Override
	public Almacen buscarAlmacenDepartamento(String dep) {
		Almacen alm = null;
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet res = null;
		try {
			con = MySQLConexion8.getConexion();
			String sql = "SELECT * FROM tb_almacen WHERE dpto_almcn=?;";
			pstm = con.prepareStatement(sql);
			pstm.setString(1, dep);			
			res = pstm.executeQuery();
			
			if(res.next()) {
				alm = new Almacen(res.getInt(1),
									res.getString(2),
									res.getString(3),
									res.getString(4),
									res.getInt(5),
									res.getString(6));				
			}
		} catch (Exception e) {
			System.out.println("Error en la instrucción SQL SELECT * FROM tb_almacen WHERE dpto_almcn=?;" + e.getMessage());
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
		return alm;
	}
}
