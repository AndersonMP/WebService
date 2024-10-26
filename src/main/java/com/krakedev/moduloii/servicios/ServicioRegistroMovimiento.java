package com.krakedev.moduloii.servicios;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.krakedev.moduloii.entidades.RegistroMovimiento;


@Path("bases")
public class ServicioRegistroMovimiento {
	@Path("registroMovimiento")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insertar(RegistroMovimiento registro) {
		System.out.println("Insertando Registro: " + registro.toString());
		ServicioArticulo sa = new ServicioArticulo();
		try {
			sa.insertarMovimiento(registro);
			return Response.ok().build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity("Error al insertar la categoría").build();
		}
	}

}


