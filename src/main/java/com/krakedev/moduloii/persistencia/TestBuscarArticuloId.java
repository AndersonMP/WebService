package com.krakedev.moduloii.persistencia;

import com.krakedev.moduloii.entidades.Articulo;
import com.krakedev.moduloii.servicios.ServicioArticulo;

public class TestBuscarArticuloId {
	public static void main(String[] args) {
		try {
			Articulo art = ServicioArticulo.buscarArticuloPorId("P002");
			System.out.println(art);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}

}
