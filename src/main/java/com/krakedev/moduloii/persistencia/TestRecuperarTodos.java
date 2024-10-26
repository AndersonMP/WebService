package com.krakedev.moduloii.persistencia;

import java.util.ArrayList;

import com.krakedev.moduloii.entidades.Articulo;
import com.krakedev.moduloii.servicios.ServicioArticulo;

public class TestRecuperarTodos {
	public static void main(String[] args) {
		try {
			ArrayList<Articulo> articulos = ServicioArticulo.recuperarTodos();
			System.out.println(articulos);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
}
