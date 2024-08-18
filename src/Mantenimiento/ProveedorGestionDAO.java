package Mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Entidad.Almacen;
import Entidad.Proveedor;
import Interfaces.InterfazEmpleadoDAO;
import Interfaces.InterfazProveedorDAO;
import Utils.MySQLConexion8;

public class ProveedorGestionDAO implements InterfazProveedorDAO{

	@Override
	public int registrarProveedor(Proveedor P) {
		int estado=0;
		Connection con = null;
		PreparedStatement pstm = null;
		try {			
				con = MySQLConexion8.getConexion();
				String sql = "INSERT INTO tb_proveedor VALUES(?,?,?,?,?);";
				pstm = con.prepareStatement(sql);
				pstm.setInt(1, P.getCod());
				pstm.setString(2, P.getNomprove());
				pstm.setString(3, P.getDirecc());
				pstm.setString(4, P.getTelef());
				pstm.setString(5, P.getEmail());
				
				
				estado = pstm.executeUpdate();			
		
		} catch (Exception e) {
			System.out.println("Error en la instrucción SQL INSERT INTO tb_proveedor VALUES(?,?,?,?,?);" + e.getMessage());		
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
	public int actualizarProveedor(Proveedor P) {
		int estado=0;
		Connection con = null;
		PreparedStatement pstm = null;
		try {			
				con = MySQLConexion8.getConexion();
				String sql = "UPDATE tb_proveedor SET nom_prov=?,dir_prov=?,fono_prov=?,email_prov=? WHERE cod_prov=?;";
				pstm = con.prepareStatement(sql);
				//Obtenerparámetros		
				pstm.setString(1, P.getNomprove());
				pstm.setString(2, P.getDirecc());
				pstm.setString(3, P.getTelef());
				pstm.setString(4, P.getEmail());
				
				
				pstm.setInt(5, P.getCod());
				
				estado = pstm.executeUpdate();			
		
		} catch (Exception e) {
			System.out.println("Error en la instrucción SQL UPDATE tb_proveedor SET nom_prov=?,dir_prov=?,fono_prov=?,email_prov=? WHERE cod_prov=?;" + e.getMessage());		
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
	public int eliminarProveedor(int codProv) {
		int estado=0;
		Connection con = null;
		PreparedStatement pstm = null;
		try {			
				con = MySQLConexion8.getConexion();
				String sql = "DELETE FROM tb_proveedor WHERE cod_prov=?;";
				pstm = con.prepareStatement(sql);
				
				//Eliminar por el número de almacen			
				pstm.setInt(1, codProv);
				//Ejecutamos instrucción SQL
				estado = pstm.executeUpdate();			
		
		} catch (Exception e) {
			System.out.println("Error en la instrucción SQL DELETE FROM tb_proveedor WHERE cod_prov=?;" + e.getMessage());		
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
	public Proveedor buscarProveedor(int codProv) {
		Proveedor prov = null;
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet res = null;
		try {
			con = MySQLConexion8.getConexion();
			String sql = "SELECT * FROM tb_proveedor WHERE cod_prov=?;";
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, codProv);			
			res = pstm.executeQuery();
			
			if(res.next()) {
				prov = new Proveedor(res.getInt(1),
									res.getString(2),
									res.getString(3),
									res.getString(4),
									res.getString(5));				
			}
		} catch (Exception e) {
			System.out.println("Error en la instrucción SQL SELECT * FROM tb_proveedor WHERE cod_prov=?;" + e.getMessage());
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
		return prov;
	}

	@Override
	public ArrayList<Proveedor> listarProveedor() {
		Proveedor prov = null;
		ArrayList<Proveedor> listProveedor = new ArrayList<Proveedor>();		
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet res = null;
		try {
			con = MySQLConexion8.getConexion();
			String sql = "SELECT * FROM tb_proveedor;";
			pstm = con.prepareStatement(sql);	
			res = pstm.executeQuery();
			
			//bucle para listar Almacenes
			while(res.next()) {
				prov = new Proveedor();
				//asignamos los valores a los atributos privados
				prov.setCod(res.getInt(1));
				prov.setNomprove(res.getString(2));
				prov.setDirecc(res.getString(3));
				prov.setTelef(res.getString(4));
				prov.setEmail(res.getString(5));
				
				//agregamos a la lista
				listProveedor.add(prov);
			}		
		} catch (Exception e) {
			System.out.println("Error en la instrucción SQL SELECT * FROM tb_proveedor;" + e.getMessage());
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
		return listProveedor;
	}

	@Override
	public Proveedor buscarProveedorNombre(String nomProv) {
		Proveedor prov = null;
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet res = null;
		try {
			con = MySQLConexion8.getConexion();
			String sql = "SELECT * FROM tb_proveedor WHERE nom_prov=?;";
			pstm = con.prepareStatement(sql);
			pstm.setString(1, nomProv);			
			res = pstm.executeQuery();
			
			if(res.next()) {
				prov = new Proveedor(res.getInt(1),
									res.getString(2),
									res.getString(3),
									res.getString(4),
									res.getString(5));				
			}
		} catch (Exception e) {
			System.out.println("Error en la instrucción SQL SELECT * FROM tb_proveedor WHERE nom_prov=?;" + e.getMessage());
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
		return prov;
	}
}
