package com.krakedev.moduloii.persistencia;

import com.krakedev.moduloii.entidades.Articulo;
import com.krakedev.moduloii.entidades.RegistroMovimiento;
import com.krakedev.moduloii.servicios.ServicioArticulo;

public class TestBuscarMovimientoId {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			RegistroMovimiento rm = ServicioArticulo.buscarMovimientoPorId(1);
			System.out.println(rm);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}

}
