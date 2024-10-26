package com.krakedev.evaluacion.servicios;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.krakedev.entidades.Categorias;
import com.krakedev.evaluacion.execpciones.KrakeException;
import com.krakedev.evaluacion.persistencia.HistorialBDD;

@Path("funciones")
public class ServiciosCategoria {
	@Path("probarInsertar")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insertar(Categorias categoria) {
		System.out.println("Insertando categoría: " + categoria);
		HistorialBDD his = new HistorialBDD();
		try {
			his.insertar(categoria);
			return Response.ok().build();
		} catch (KrakeException e) {
			e.printStackTrace();
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity("Error al insertar la categoría").build();
		}
	}

	@Path("pruebaActualizar")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response actualizar(Categorias categoria) {
		System.out.println("Actualizando categoría: " + categoria);
		HistorialBDD his = new HistorialBDD();
		try {
			his.actualizar(categoria);
			return Response.ok().build();
		} catch (KrakeException e) {
			e.printStackTrace();
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity("Error al actualizar la categoría").build();
		}
	}

	@Path("buscarPorID/{idCatParam}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscarPorID(@PathParam("idCatParam") String idCat) {
		System.out.println("Buscando categoría por ID: " + idCat);
		HistorialBDD his = new HistorialBDD();
		try {
			Categorias categoria = his.buscarPorID(idCat);
			if (categoria != null) {
				return Response.ok(categoria).build();
			} else {
				return Response.status(Status.NOT_FOUND).entity("Categoría no encontrada").build();
			}
		} catch (KrakeException e) {
			e.printStackTrace();
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity("Error al buscar la categoría").build();
		}
	}

	@Path("probarRecuperar")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response obtenerCategorias() {
		HistorialBDD his = new HistorialBDD();
		try {
			ArrayList<Categorias> categorias = his.recuperarCategorias();
			return Response.ok(categorias).build();
		} catch (KrakeException e) {
			e.printStackTrace();
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity("Error al recuperar categorías").build();
		}
	}
	
	

	/*
	 * public Response insertar(HistorialMovimientos historial) {
	 * System.out.println(">>>>>" + historial); Categorias cat = new Categorias();
	 * Productos pro = new Productos(); HistorialBDD his = new HistorialBDD();
	 * historial.setIdProducto(pro);
	 * 
	 * try { historial.setCantidad(15); cat.setIdCaegorias("C002");
	 * cat.setNombre("Snacks"); pro.setId_productos("POO6");
	 * pro.setIdCategorias(cat); pro.setNombre("Cheetos"); pro.setPrecioCompra(new
	 * BigDecimal(0.20)); pro.setPrecioVenta(new BigDecimal(0.35)); historial = new
	 * HistorialMovimientos(); historial.setFechaMovimiento(new
	 * java.sql.Date(Convertidor.convertirFecha("2021-09-12 13:00").getTime()));
	 * his.insertar(historial); return Response.ok().build(); } catch
	 * (KrakeException e) { // TODO Auto-generated catch block e.printStackTrace();
	 * return Response.serverError().build(); } catch (Exception e) { // TODO
	 * Auto-generated catch block e.printStackTrace(); return
	 * Response.serverError().build(); }
	 */

}
