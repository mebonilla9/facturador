/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.appreactor.facturador.modelo.dao;

import co.appreactor.facturador.modelo.conexion.BdConexion;
import co.appreactor.facturador.modelo.entidades.Rol;
import co.appreactor.facturador.modelo.entidades.TipoProducto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.spi.DirStateFactory;

/**
 *
 * @author capacitaciones
 */
public class TipoProductoDao implements IGenericoDao<TipoProducto> {

    private final int ID = 1;
    private final Connection cnn;

    public TipoProductoDao(Connection cnn) {
        this.cnn = (Connection) cnn;
    }

    @Override
    public void insertar(TipoProducto entidad) throws SQLException {
        PreparedStatement sentencia = null;

        int i = 1;
        try {
            String sql = "insert into TipoProducto (nombre,estado) values (?,?)";

            sentencia = cnn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            sentencia.setObject(i++, entidad.getNombre());
            sentencia.setObject(i++, entidad.getEstado());
            sentencia.executeUpdate();
            ResultSet resultado = sentencia.getGeneratedKeys();
            if (resultado.next()) {
                entidad.setIdTipoProducto(resultado.getLong(ID));
            }
        } finally {
            BdConexion.desconectar(sentencia);
        }
    }

    @Override
    public void editar(TipoProducto entidad) throws SQLException {
        PreparedStatement sentencia = null;
        int i = 1;
        try {
            String sql = "update TipoProducto set nombre = ?, estado = ? where TipoProducto= ?";
            sentencia = cnn.prepareStatement(sql);
            sentencia.setObject(i++, entidad.getNombre());
            sentencia.setObject(i++, entidad.getEstado());
            sentencia.setObject(i++, entidad.getIdTipoProducto());
        } finally {
            BdConexion.desconectar(sentencia);
        }
    }

    @Override
    public List<TipoProducto> consultar() throws SQLException {
        PreparedStatement sentencia = null;
        List<TipoProducto> lista = new ArrayList<>();
        try {
            String sql = "select * from TipoProducto";
            sentencia = cnn.prepareStatement(sql);
            ResultSet result = sentencia.executeQuery();
            while (result.next()) {
                TipoProducto tipoProducto = new TipoProducto();
                tipoProducto.setIdTipoProducto(result.getLong("id_TipoProducto"));
                tipoProducto.setNombre(result.getString("Nombre"));
                tipoProducto.setEstado(result.getBoolean("Estado"));
                lista.add(tipoProducto);
            }
        } finally {
            BdConexion.desconectar(sentencia);
        }
        return lista;
    }

    @Override
    public TipoProducto consultar(Long id) throws SQLException {
        PreparedStatement sentencia = null;

        TipoProducto tipoProducto = new TipoProducto();
        try {
            String sql = "select * from rol where id_TipoProducto = ?";
            sentencia = cnn.prepareStatement(sql);
            sentencia.setLong(1, id);
            ResultSet result = sentencia.executeQuery();
            if (result.next()) {
                tipoProducto.setIdTipoProducto(result.getLong("id_TipoProducto"));
                tipoProducto.setNombre(result.getString("Nombre"));
                tipoProducto.setEstado(result.getBoolean("Estado"));
            }

        } finally {
            BdConexion.desconectar(sentencia);
        }
        return tipoProducto;

    }
}
