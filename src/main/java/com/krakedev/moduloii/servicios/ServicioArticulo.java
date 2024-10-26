package com.krakedev.moduloii.servicios;

import java.math.BigDecimal;
import java.security.Timestamp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.krakedev.moduloii.entidades.Articulo;
import com.krakedev.moduloii.entidades.Grupo;
import com.krakedev.moduloii.entidades.RegistroMovimiento;
import com.krakedev.moduloii.evaluacionfinal.utils.ConexionBDD;
import com.krakedev.moduloii.evaluacionfinal.utils.Convertidor;
import com.krakedev.moduloii.excepciones.InventarioException;

public class ServicioArticulo {
	private static final Logger LOGGER = LogManager.getLogger(ServicioArticulo.class);

	public static void insertarArticulo(Articulo articulo) throws Exception {
		Connection con = null;
		PreparedStatement ps = null;
		LOGGER.trace("Artículo a insertar>>> " + articulo.toString());
		try {
			// Abrir conexión
			con = ConexionBDD.conectar();
			ps = con.prepareStatement(
					"insert into articulo (id_articulo,id_grupo,nombre,precio_venta,precio_compra,estado)"
							+ "values (?,?,?,?,?,?);");
			ps.setString(1, articulo.getIdArticulo());
			ps.setString(2, articulo.getIdGrupo().getIdGrupo());
			ps.setString(3, articulo.getNombre());
			ps.setBigDecimal(4, articulo.getPrecioVenta());
			ps.setBigDecimal(5, articulo.getPrecioCompra());
			ps.setBoolean(6, articulo.isEstado());

			ps.executeUpdate();
		} catch (Exception e) {
			LOGGER.error("Error al insertar en la base de datos", e);
			throw new InventarioException("Error al insertar en la base de datos");
		} finally {
			// Cerrar conexión
			try {
				con.close();
			} catch (SQLException e) {
				LOGGER.error("Error con la conexión base de datos", e);
				throw new InventarioException("Ocurrió algo con la conexión a la base de datos.");
			}
		}
	}

	public static void insertarGrupo(Grupo grupo) throws Exception {
		Connection con = null;
		PreparedStatement ps = null;
		LOGGER.trace("Grupo a insertar>>> " + grupo.toString());
		try {
			// Abrir conexión
			con = ConexionBDD.conectar();
			ps = con.prepareStatement("insert into grupo(id_grupo,nombre)" + "values (?,?)");
			ps.setString(1, grupo.getIdGrupo());
			ps.setString(2, grupo.getNombre());

			ps.executeUpdate();
		} catch (Exception e) {
			LOGGER.error("Error al insertar en la base de datos", e);
			throw new InventarioException("Error al insertar en la base de datos");
		} finally {
			// Cerrar conexión
			try {
				con.close();
			} catch (SQLException e) {
				LOGGER.error("Error con la conexión base de datos", e);
				throw new InventarioException("Ocurrió algo con la conexión a la base de datos.");
			}
		}
	}

	public static void insertarMovimiento(RegistroMovimiento movimiento) throws Exception {
		Connection con = null;
		PreparedStatement ps = null;
		LOGGER.trace("Movimiento a insertar>>> " + movimiento.toString());
		try {
			// Abrir conexión
			con = ConexionBDD.conectar();
			ps = con.prepareStatement(
					"insert into registro_movimientos (id_articulo,cantidad,fecha_movimiento)" + "values(?,?,?);");
			ps.setString(1, movimiento.getIdArticulo().getIdArticulo());
			ps.setInt(2, movimiento.getCantidad());
			ps.setDate(3, new java.sql.Date(movimiento.getFecha_movimiento().getTime()));

			ps.executeUpdate();
		} catch (Exception e) {
			LOGGER.error("Error al insertar en la base de datos", e);
			throw new InventarioException("Error al insertar en la base de datos");
		} finally {
			// Cerrar conexión
			try {
				con.close();
			} catch (SQLException e) {
				LOGGER.error("Error con la conexión base de datos", e);
				throw new InventarioException("Ocurrió algo con la conexión a la base de datos.");
			}
		}
	}

	public static void actualizarMovimiento(RegistroMovimiento movimiento) throws Exception {
		Connection con = null;
		PreparedStatement ps = null;
		LOGGER.trace("Movimiento a actualizar>>> " + movimiento.toString());
		try {
			// Abrir conexión
			con = ConexionBDD.conectar();
			ps = con.prepareStatement(
					"update registro_movimientos set id_articulo = ?, cantidad = ?, fecha_movimiento = ? where id_registro = ?");
			ps.setString(1, movimiento.getIdArticulo().getIdArticulo());
			ps.setInt(2, movimiento.getCantidad());
			ps.setDate(3, new java.sql.Date(movimiento.getFecha_movimiento().getTime()));
			ps.setInt(4, movimiento.getIdRegistro());

			ps.executeUpdate();
		} catch (Exception e) {
			LOGGER.error("Error al actualizar en la base de datos", e);
			throw new InventarioException("Error al actualizar en la base de datos");
		} finally {
			// Cerrar conexión
			try {
				con.close();
			} catch (SQLException e) {
				LOGGER.error("Error con la conexión base de datos", e);
				throw new InventarioException("Ocurrió algo con la conexión a la base de datos.");
			}
		}
	}

	public static void actualizarGrupo(Grupo grupo) throws Exception {
		Connection con = null;
		PreparedStatement ps = null;
		LOGGER.trace("Grupo a actualizar>>> " + grupo.toString());
		try {
			// Abrir conexión
			con = ConexionBDD.conectar();
			ps = con.prepareStatement("update grupo set nombre = ? where id_grupo = ?");
			ps.setString(1, grupo.getNombre());
			ps.setString(2, grupo.getIdGrupo());

			ps.executeUpdate();
		} catch (Exception e) {
			LOGGER.error("Error al actualizar en la base de datos", e);
			throw new InventarioException("Error al actualizar en la base de datos");
		} finally {
			// Cerrar conexión
			try {
				con.close();
			} catch (SQLException e) {
				LOGGER.error("Error con la conexión base de datos", e);
				throw new InventarioException("Ocurrió algo con la conexión a la base de datos.");
			}
		}
	}

	public static void actualizarArticulo(Articulo articulo) throws Exception {
		Connection con = null;
		PreparedStatement ps = null;
		LOGGER.trace("Artículo a insertar>>> " + articulo.toString());
		try {
			// Abrir conexión
			con = ConexionBDD.conectar();
			ps = con.prepareStatement(
					"update articulo set id_grupo = ?, nombre = ?, precio_venta = ?, precio_compra = ?, estado = ? where id_articulo = ?");
			ps.setString(1, articulo.getIdGrupo().getIdGrupo());
			ps.setString(2, articulo.getNombre());
			ps.setBigDecimal(3, articulo.getPrecioVenta());
			ps.setBigDecimal(4, articulo.getPrecioCompra());
			ps.setBoolean(5, articulo.isEstado());
			ps.setString(6, articulo.getIdArticulo());

			ps.executeUpdate();
		} catch (Exception e) {
			LOGGER.error("Error al actualizar en la base de datos", e);
			throw new InventarioException("Error al actualizar en la base de datos");
		} finally {
			// Cerrar conexión
			try {
				con.close();
			} catch (SQLException e) {
				LOGGER.error("Error con la conexión base de datos", e);
				throw new InventarioException("Ocurrió algo con la conexión a la base de datos.");
			}
		}
	}

	public static Articulo buscarArticuloPorId(String idArticulo) throws Exception {
		Articulo art = new Articulo();
		LOGGER.trace("Articulo a buscar>>> " + idArticulo);
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = ConexionBDD.conectar();
			ps = con.prepareStatement("Select * from articulo where id_articulo = ?");
			ps.setString(1, idArticulo);

			rs = ps.executeQuery();

			if (rs.next()) {
				String idArt = rs.getString("id_articulo");
				String idGrup = rs.getString("id_grupo");
				String nombre = rs.getString("nombre");
				String preVen = rs.getString("precio_venta");
				String preCom = rs.getString("precio_compra");
				BigDecimal precioVen = new BigDecimal(preVen.replace(",", "").replace("$", ""));
				BigDecimal precioCom = new BigDecimal(preCom.replace(",", "").replace("$", ""));
				boolean estado = rs.getBoolean("estado");
				// Date fechaNacimiento = new Date(rs.getDate("fecha_nacimiento").getTime());
				// Date horaNacimiento = rs.getTime("hora_nacimiento");

				Grupo g = new Grupo("C005", "Carnes");
				art.setIdArticulo(idArticulo);
				art.setIdGrupo(g);
				art.setNombre(nombre);
				art.setPrecioVenta(precioVen);
				art.setPrecioCompra(precioCom);
				art.setEstado(estado);
			}

		} catch (Exception e) {
			LOGGER.error("Error al consultar registro en la base de datos", e);
			throw new Exception("Error al consultar registro en la base de datos");
		} finally {
			try {
				rs.close();
				con.close();
			} catch (SQLException e) {
				LOGGER.error("Error conexión de la base de datos", e);
				throw new Exception("Error conexión de la base de datos");
			}
		}
		return art;
	}

	public static Grupo buscarGrupoPorId(String idGrupo) throws Exception {
		Grupo g = new Grupo();
		LOGGER.trace("Grupo a buscar>>> " + idGrupo);
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = ConexionBDD.conectar();
			ps = con.prepareStatement("Select * from grupo where id_grupo = ?");
			ps.setString(1, idGrupo);

			rs = ps.executeQuery();

			if (rs.next()) {
				String idGrup = rs.getString("id_grupo");
				String nombre = rs.getString("nombre");
				// Date fechaNacimiento = new Date(rs.getDate("fecha_nacimiento").getTime());
				// Date horaNacimiento = rs.getTime("hora_nacimiento");
				g.setIdGrupo(idGrupo);
				g.setNombre(nombre);
			}

		} catch (Exception e) {
			LOGGER.error("Error al consultar registro en la base de datos", e);
			throw new Exception("Error al consultar registro en la base de datos");
		} finally {
			try {
				rs.close();
				con.close();
			} catch (SQLException e) {
				LOGGER.error("Error conexión de la base de datos", e);
				throw new Exception("Error conexión de la base de datos");
			}
		}
		return g;
	}

	public static RegistroMovimiento buscarMovimientoPorId(int idMovimiento) throws Exception {
		RegistroMovimiento rm = new RegistroMovimiento();
		LOGGER.trace("Grupo a buscar>>> " + idMovimiento);
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = ConexionBDD.conectar();
			ps = con.prepareStatement("Select * from registro_movimientos where id_registro = ?");
			ps.setInt(1, idMovimiento);

			rs = ps.executeQuery();

			if (rs.next()) {
				int idReg = rs.getInt("id_registro");
				String idArt = rs.getString("id_articulo");
				int cantidad = rs.getInt("cantidad");
				Date fechaMov = new Date(rs.getDate("fecha_movimiento").getTime());
				Articulo art = new Articulo();
				art.setIdArticulo(idArt);
				rm.setIdRegistro(idReg);
				rm.setIdArticulo(art);
				rm.setCantidad(cantidad);
				rm.setFecha_movimiento(fechaMov);
			}

		} catch (Exception e) {
			LOGGER.error("Error al consultar registro en la base de datos", e);
			throw new Exception("Error al consultar registro en la base de datos");
		} finally {
			try {
				rs.close();
				con.close();
			} catch (SQLException e) {
				LOGGER.error("Error conexión de la base de datos", e);
				throw new Exception("Error conexión de la base de datos");
			}
		}
		return rm;
	}

	public static ArrayList<Articulo> recuperarTodos() throws Exception {
		ArrayList<Articulo> articulos = new ArrayList<Articulo>();
		LOGGER.trace("Artículos>>> ");
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = ConexionBDD.conectar();
			ps = con.prepareStatement("select * from articulo where estado = true;");

			rs = ps.executeQuery();

			while (rs.next()) {
				String idArt = rs.getString("id_articulo");
				String idGrupo = rs.getString("id_grupo");
				String nombre = rs.getString("nombre");
				String preVen = rs.getString("precio_venta");
				String preCom = rs.getString("precio_compra");
				boolean estado = rs.getBoolean("estado");

				BigDecimal precioVenta = new BigDecimal(preVen.replace(",", "").replace("$", ""));
				BigDecimal precioCompra = new BigDecimal(preCom.replace(",", "").replace("$", ""));

				Grupo g = new Grupo("C003", "Jugos");
				Articulo art = new Articulo();
				art.setIdArticulo(idArt);
				art.setIdGrupo(g);
				art.setNombre(nombre);
				art.setPrecioVenta(precioVenta);
				art.setPrecioCompra(precioCompra);
				art.setEstado(estado);

				articulos.add(art);
			}

		} catch (Exception e) {
			LOGGER.error("Error al consultar registro en la base de datos", e);
			throw new InventarioException("Error al consultar registro en la base de datos");
		} finally {
			try {
				rs.close();
				con.close();
			} catch (SQLException e) {
				LOGGER.error("Error conexión de la base de datos", e);
				throw new InventarioException("Error conexión de la base de datos");
			}
		}
		return articulos;
	}

	public static ArrayList<RegistroMovimiento> recuperarMovimientos(Date fecha) throws Exception {
		ArrayList<RegistroMovimiento> registros = new ArrayList<RegistroMovimiento>();
		LOGGER.trace("Movimientos>>> ");
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = ConexionBDD.conectar();
			ps = con.prepareStatement("select * from registro_movimientos  where fecha_movimiento = ?;");
			ps.setDate(1, new java.sql.Date(fecha.getTime()));
		
			rs = ps.executeQuery();
			while (rs.next()) {
				int idReg = rs.getInt("id_registro");
				String idArt = rs.getString("id_articulo");
				int cantidad = rs.getInt("cantidad");
				Date fechaMov = new Date(rs.getDate("fecha_movimiento").getTime());
				Grupo grupo = new Grupo("C001","Bebidas");
				Articulo art = new Articulo();
				art.setIdArticulo(idArt);
				art.setIdGrupo(grupo);
				art.setNombre("Jugos");
				art.setPrecioCompra(new BigDecimal(0.55));
				art.setPrecioVenta(new BigDecimal(0.9));
				art.setEstado(false);
				RegistroMovimiento regMov = new RegistroMovimiento(idReg,art,cantidad,fechaMov);
				
				registros.add(regMov);
			}

		} catch (Exception e) {
			LOGGER.error("Error al consultar registro en la base de datos", e);
			throw new InventarioException("Error al consultar registro en la base de datos");
		} finally {
			try {
				rs.close();
				con.close();
			} catch (SQLException e) {
				LOGGER.error("Error conexión de la base de datos", e);
				throw new InventarioException("Error conexión de la base de datos");
			}
		}
		return registros;
	}

}
