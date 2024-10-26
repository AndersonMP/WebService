package com.krakedev.moduloii.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.krakedev.moduloii.evaluacionfinal.utils.ConexionBDD;
import com.krakedev.moduloii.excepciones.InventarioException;

public class TestConexionBDD {

	public void probarConexion() throws InventarioException {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = ConexionBDD.conectar();

			if (con != null) {
				System.out.println("Conexión Éxitosa");
			} else {
				System.out.println("Erro al Conectarse");
			}
		} catch (InventarioException e) {
			throw e;
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new InventarioException("Error de infraestructura: " + e.getMessage());
			}
		}
	}

}
