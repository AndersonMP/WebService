package com.krakedev.moduloii.entidades;

import java.util.Date;

public class RegistroMovimiento {
	private int idRegistro;
	private Articulo idArticulo;
	private int cantidad;
	private Date fecha_movimiento;

	public RegistroMovimiento() {

	}

	public RegistroMovimiento(Articulo idArticulo, int cantidad, Date fecha_movimiento) {
		super();
		this.idArticulo = idArticulo;
		this.cantidad = cantidad;
		this.fecha_movimiento = fecha_movimiento;
	}

	public RegistroMovimiento(int idRegistro, Articulo idArticulo, int cantidad, Date fecha_movimiento) {
		super();
		this.idRegistro = idRegistro;
		this.idArticulo = idArticulo;
		this.cantidad = cantidad;
		this.fecha_movimiento = fecha_movimiento;
	}

	public Articulo getIdArticulo() {
		return idArticulo;
	}

	public void setIdArticulo(Articulo idArticulo) {
		this.idArticulo = idArticulo;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Date getFecha_movimiento() {
		return fecha_movimiento;
	}

	public void setFecha_movimiento(Date fecha_movimiento) {
		this.fecha_movimiento = fecha_movimiento;
	}

	public int getIdRegistro() {
		return idRegistro;
	}

	public void setIdRegistro(int idRegistro) {
		this.idRegistro = idRegistro;
	}

	@Override
	public String toString() {
		return "RegistroMovimiento [idRegistro=" + idRegistro + ", idArticulo=" + idArticulo + ", cantidad=" + cantidad
				+ ", fecha_movimiento=" + fecha_movimiento + "]";
	}

}
