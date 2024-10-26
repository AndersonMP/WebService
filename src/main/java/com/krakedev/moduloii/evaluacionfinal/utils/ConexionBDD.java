package com.krakedev.moduloii.evaluacionfinal.utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.krakedev.moduloii.excepciones.InventarioException;


public class ConexionBDD {
	public static Connection conectar() throws InventarioException {
		Context ctx = null;
		DataSource ds = null;
		Connection con = null;

		try {
			ctx = new InitialContext();
			// JNDI
			ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/ConexionPG");
			con = ds.getConnection();

		} catch (NamingException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			throw new InventarioException("Error al obetner conexión");
		}
		
		return con;

	}
}