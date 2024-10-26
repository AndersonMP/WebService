package com.krakedev.moduloii.persistencia;

import com.krakedev.moduloii.entidades.Grupo;
import com.krakedev.moduloii.servicios.ServicioArticulo;

public class TestInsertarGrupo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Grupo grupo = new Grupo("C008", "Enlatados");
		try {
			ServicioArticulo.insertarGrupo(grupo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Error en el sistema: " + e.getMessage());

		}

	}
}
