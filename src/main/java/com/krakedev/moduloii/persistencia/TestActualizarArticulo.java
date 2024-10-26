package com.krakedev.moduloii.persistencia;

import java.math.BigDecimal;

import com.krakedev.moduloii.entidades.Articulo;
import com.krakedev.moduloii.entidades.Grupo;
import com.krakedev.moduloii.servicios.ServicioArticulo;

public class TestActualizarArticulo {
	public static void main(String[] args) {
		Grupo grupo = new Grupo("C001", "Bebidas");
		Articulo articulo = new Articulo();
		try {
			articulo.setIdArticulo("P0011");
			articulo.setIdGrupo(grupo);
			articulo.setNombre("Gelatony 100g");
			articulo.setPrecioCompra(new BigDecimal(1.15));
			articulo.setPrecioVenta(new BigDecimal(1.50));
			articulo.setEstado(true);
			ServicioArticulo.actualizarArticulo(articulo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Error en el sistema: " + e.getMessage());

		}
	}
}
