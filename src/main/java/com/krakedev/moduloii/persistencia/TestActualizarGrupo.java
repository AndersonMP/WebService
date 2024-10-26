package com.krakedev.moduloii.persistencia;

import com.krakedev.moduloii.entidades.Grupo;
import com.krakedev.moduloii.servicios.ServicioArticulo;

public class TestActualizarGrupo {
	public static void main(String[] args) {
		Grupo grupo = new Grupo("C008", "Conservables");
		try {
			ServicioArticulo.actualizarGrupo(grupo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Error en el sistema: " + e.getMessage());

		}
	}
}
