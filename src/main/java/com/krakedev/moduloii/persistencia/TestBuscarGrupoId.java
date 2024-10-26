package com.krakedev.moduloii.persistencia;

import com.krakedev.moduloii.entidades.Grupo;
import com.krakedev.moduloii.servicios.ServicioArticulo;

public class TestBuscarGrupoId {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Grupo grupo = ServicioArticulo.buscarGrupoPorId("C002");
			System.out.println(grupo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}

}
