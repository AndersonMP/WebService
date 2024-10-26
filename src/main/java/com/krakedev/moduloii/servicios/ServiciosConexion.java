package com.krakedev.moduloii.servicios;

import java.sql.Connection;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.krakedev.moduloii.evaluacionfinal.utils.ConexionBDD;
import com.krakedev.moduloii.excepciones.InventarioException;

@Path("bases")
public class ServiciosConexion {

	@Path("probarConexion")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response probarConn() {
		System.out.println(">>>>>" + "Prueba Conexíon");
		Connection con = null;
		try {
			con = ConexionBDD.conectar();
			return Response.ok().build();
		} catch (InventarioException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}

	}
}
