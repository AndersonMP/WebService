package com.krakedev.moduloii.persistencia;

import java.util.ArrayList;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.krakedev.moduloii.entidades.RegistroMovimiento;
import com.krakedev.moduloii.evaluacionfinal.utils.Convertidor;
import com.krakedev.moduloii.servicios.ServicioArticulo;

public class TestRecuperarMovimientoFecha {

	private static Logger LOGGER = LogManager.getLogger(TestRecuperarMovimientoFecha.class);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		try {
			String fechaMov = ("2023/05/28 08:15:00");
			Date fechaCon = Convertidor.convertirFecha(fechaMov);
			System.out.println(fechaCon);
			ArrayList<RegistroMovimiento> movimientos = ServicioArticulo.recuperarMovimientos(fechaCon);
			LOGGER.info(movimientos);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			LOGGER.error(e);
		}
	}

}
