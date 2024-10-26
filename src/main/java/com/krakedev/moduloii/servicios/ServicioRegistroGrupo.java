package com.krakedev.moduloii.servicios;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.krakedev.moduloii.entidades.Grupo;
import com.krakedev.moduloii.excepciones.InventarioException;

public class ServicioRegistroGrupo {
	@Path("bases")

	public class ServiciosGrupo {

		@Path("insertar_Grupo")
		@POST
		@Consumes(MediaType.APPLICATION_JSON)
		public Response insertar(Grupo grupo) throws Exception {

			System.out.println(">>>>" + grupo);
			try {
				ServicioArticulo.insertarGrupo(grupo);
				return Response.ok().build();
			} catch (InventarioException e) {
				e.printStackTrace();
				return Response.serverError().build();
			}

		}
	}

	@Path("eliminar_Grupo")
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	public Response eliminarGrupo(Grupo grupo) throws Exception {

		System.out.println(">>>>" + grupo);
		try {
			ServicioArticulo.eliminarGrupo(grupo);
			return Response.ok().build();
		} catch (InventarioException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}

	}

}
