package Mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import Entidad.Venta;
import Interfaces.InterfazVentaDAO;
import Utils.MySQLConexion8;

public class VentaGestionDAO implements InterfazVentaDAO{

	@Override
	public int registrarVenta(Venta Ven) {
		int estado=0;
		Connection con = null;
		PreparedStatement pstm = null;
		try {			
				con = MySQLConexion8.getConexion();
				String sql = "INSERT INTO tb_venta VALUES(?,?,?,?,?,?,?,?,?);";
				pstm = con.prepareStatement(sql);
				pstm.setInt(1, Ven.getCod_venta());
				pstm.setInt(2, Ven.getDni_cli());
				pstm.setString(3, Ven.getNom_cli());
				pstm.setString(4, Ven.getFono_cli());
				pstm.setString(5, Ven.getId_aut());
				pstm.setString(6, Ven.getFecha_venta());
				pstm.setDouble(7, Ven.getPrecio_venta());
				pstm.setDouble(8, Ven.getDscto_venta());
				pstm.setDouble(9, Ven.getMont_tot_venta());
				
				estado = pstm.executeUpdate();			
		
		} catch (Exception e) {
			System.out.println("Error en la instrucci�n SQL INSERT INTO tb_venta VALUES(?,?,?,?,?,?,?,?,?);" + e.getMessage());		
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
	public Venta buscarVenta(int codVen) {
		Venta vent = null;
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet res = null;
		try {
			con = MySQLConexion8.getConexion();
			String sql = "SELECT * FROM tb_venta WHERE cod_venta=?;";
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, codVen);			
			res = pstm.executeQuery();
			
			if(res.next()) {
				vent = new Venta(res.getInt(1),
									res.getInt(2),
									res.getString(3),
									res.getString(4),
									res.getString(5),
									res.getString(6),
									res.getDouble(7),
									res.getDouble(8),
									res.getDouble(9));				
			}
		} catch (Exception e) {
			System.out.println("Error en la instrucci�n SQL SELECT * FROM tb_venta WHERE cod_venta=?;" + e.getMessage());
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
		return vent;
	}

	@Override
	public ArrayList<Venta> listarVenta() {
		Venta venta = null;
		ArrayList<Venta> listVenta = new ArrayList<Venta>();		
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet res = null;
		try {
			con = MySQLConexion8.getConexion();
			String sql = "SELECT * FROM tb_venta";
			pstm = con.prepareStatement(sql);	
			res = pstm.executeQuery();
			
			//bucle para listar Almacenes
			while(res.next()) {
				venta = new Venta();
				//asignamos los valores a los atributos privados
				venta.setCod_venta(res.getInt(1));
				venta.setDni_cli(res.getInt(2));
				venta.setNom_cli(res.getString(3));
				venta.setFono_cli(res.getString(4));
				venta.setId_aut(res.getString(5));
				venta.setFecha_venta(res.getString(6));
				venta.setPrecio_venta(res.getDouble(7));
				venta.setDscto_venta(res.getDouble(8));
				venta.setMont_tot_venta(res.getDouble(9));
				//agregamos a la lista
				listVenta.add(venta);
			}		
		} catch (Exception e) {
			System.out.println("Error en la instrucci�n SQL SELECT * FROM tb_venta" + e.getMessage());
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
		return listVenta;
	}

	@Override
	public ArrayList<Venta> listarVentaFecha(String fe) {
		Venta venta = null;
		ArrayList<Venta> listVentaFecha = new ArrayList<Venta>();		
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet res = null;
		try {
			con = MySQLConexion8.getConexion();
			String sql = "SELECT * FROM tb_venta WHERE fecha_venta=?;";
			pstm = con.prepareStatement(sql);	
			pstm.setString(1, fe);
			res = pstm.executeQuery();
			
			if(res.next()) {
				venta = new Venta(res.getInt(1),
								  res.getInt(2),
								  res.getString(3),
								  res.getString(4),
								  res.getString(5),
								  res.getString(6),
								  res.getDouble(7),
								  res.getDouble(8),
								  res.getDouble(9));
			}
			listVentaFecha.add(venta);				
		} catch (Exception e) {
			System.out.println("Error en la instrucci�n SQL SELECT * FROM tb_venta WHERE fecha_venta=?;" + e.getMessage());
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
		return listVentaFecha;
	}

	
}
