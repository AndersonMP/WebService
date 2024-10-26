package com.krakedev.moduloii.persistencia;

import java.math.BigDecimal;
import java.util.Date;

import com.krakedev.moduloii.entidades.Articulo;
import com.krakedev.moduloii.entidades.Grupo;
import com.krakedev.moduloii.entidades.RegistroMovimiento;
import com.krakedev.moduloii.evaluacionfinal.utils.Convertidor;
import com.krakedev.moduloii.servicios.ServicioArticulo;

public class TestInsertarMovimientos {
	public static void main(String[] args) {
		Grupo grupo = new Grupo("C001", "Bebidas");
		Articulo articulo = new Articulo();
		RegistroMovimiento rm = new RegistroMovimiento();
		try {
			articulo.setIdArticulo("P0011");
			articulo.setIdGrupo(grupo);
			articulo.setNombre("Gelatina 10g");
			articulo.setPrecioCompra(new BigDecimal(0.5));
			articulo.setPrecioVenta(new BigDecimal(0.15));
			articulo.setEstado(true);
			rm.setIdArticulo(articulo);
			rm.setCantidad(2);
			Date fechaMov = Convertidor.convertirFecha("2021/05/18 09:15");
			rm.setFecha_movimiento(fechaMov);
			ServicioArticulo.insertarMovimiento(rm);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Error en el sistema: " + e.getMessage());

		}
	}

}
