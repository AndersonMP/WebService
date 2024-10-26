package com.krakedev.moduloii.servicios;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.krakedev.moduloii.entidades.Articulo;

public class ServicioRegistroArticulo {
	@Path("bases")
	public class ServicioArticulos {

		@Path("insertar")
		@POST
		@Consumes(MediaType.APPLICATION_JSON)
		public Response insertar(Articulo articulo) {
			try {
				ServicioArticulo.insertarArticulo(articulo);
				return Response.ok().build();
			} catch (Exception e) {
				e.printStackTrace();
				return Response.serverError().build();
			}

		}

	}
}
