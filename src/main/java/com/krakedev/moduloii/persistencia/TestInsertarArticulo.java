package com.krakedev.moduloii.persistencia;

import java.math.BigDecimal;

import com.krakedev.moduloii.entidades.Articulo;
import com.krakedev.moduloii.entidades.Grupo;
import com.krakedev.moduloii.servicios.ServicioArticulo;

public class TestInsertarArticulo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Grupo grupo = new Grupo("C001", "Bebidas");
		Articulo articulo = new Articulo();
		try {
			articulo.setIdArticulo("P0011");
			articulo.setIdGrupo(grupo);
			articulo.setNombre("Gelatina 10g");
			articulo.setPrecioCompra(new BigDecimal(0.5));
			articulo.setPrecioVenta(new BigDecimal(0.15));
			articulo.setEstado(true);
			ServicioArticulo.insertarArticulo(articulo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Error en el sistema: " + e.getMessage());

		}

	}

}
