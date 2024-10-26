package com.krakedev.moduloii.entidades;

import java.math.BigDecimal;

public class Articulo {
	private String idArticulo;
	private Grupo idGrupo;
	private String nombre;
	private BigDecimal precioVenta;
	private BigDecimal precioCompra;
	private boolean estado;

	public Articulo() {

	}

	public Articulo(String idArticulo, Grupo idGrupo, String nombre, BigDecimal precioVenta, BigDecimal precioCompra,
			boolean estado) {
		super();
		this.idArticulo = idArticulo;
		this.idGrupo = idGrupo;
		this.nombre = nombre;
		this.precioVenta = precioVenta;
		this.precioCompra = precioCompra;
		this.estado = estado;
	}

	public String getIdArticulo() {
		return idArticulo;
	}

	public void setIdArticulo(String idArticulo) {
		this.idArticulo = idArticulo;
	}

	public Grupo getIdGrupo() {
		return idGrupo;
	}

	public void setIdGrupo(Grupo idGrupo) {
		this.idGrupo = idGrupo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public BigDecimal getPrecioVenta() {
		return precioVenta;
	}

	public void setPrecioVenta(BigDecimal precioVenta) {
		this.precioVenta = precioVenta;
	}

	public BigDecimal getPrecioCompra() {
		return precioCompra;
	}

	public void setPrecioCompra(BigDecimal precioCompra) {
		this.precioCompra = precioCompra;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Articulo [idArticulo=" + idArticulo + ", idGrupo=" + idGrupo + ", nombre=" + nombre + ", precioVenta="
				+ precioVenta + ", precioCompra=" + precioCompra + ", estado=" + estado + "]";
	}

}
