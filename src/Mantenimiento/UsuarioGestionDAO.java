package Mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Entidad.Usuario;
import Entidad.Vehiculo;
import Interfaces.InterfazUsuarioDAO;
import Utils.MySQLConexion8;

public class UsuarioGestionDAO implements InterfazUsuarioDAO{

	@Override
	public Usuario buscarUsuario(String us) {
		Usuario usu = null;
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet res = null;
		try {
			con = MySQLConexion8.getConexion();
			String sql = "SELECT * FROM tb_usuario WHERE cod_usuario=?;";
			pstm = con.prepareStatement(sql);
			pstm.setString(1, us);			
			res = pstm.executeQuery();
			
			if(res.next()) {
				usu = new Usuario(res.getString(1),
								   res.getString(2));				
			}
		} catch (Exception e) {
			System.out.println("Error en la instrucción SQL SELECT * FROM tb_usuario WHERE cod_usuario=?;" + e.getMessage());
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
		return usu;
	}

}
