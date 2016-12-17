/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.appreactor.facturador.modelo.dao;

import co.appreactor.facturador.modelo.conexion.BdConexion;
import co.appreactor.facturador.modelo.entidades.Rol;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lord_Nightmare
 */
public class RolDao implements IGenericoDao<Rol> {

    private final int ID = 1;
    private final Connection cnn;

    public RolDao(Connection cnn) {
        this.cnn = cnn;
    }

    @Override
    public void insertar(Rol entidad) throws SQLException {
        // El objeto que representa la sentencia que va a la base de datos
        PreparedStatement sentencia = null;
        // variable que permite incrementar la posicion del parametro de 
        // la sentencia preparada
        int i = 1;
        try {
            // Texto que representa la sentencia de insersion enviada a la base
            // de datos.
            String sql = "insert into rol(nombre,estado) values (?,?)";
            // se prepara la sentencia y se le asigna el retorno de la llave
            // generada a traves de un ResultSet
            sentencia = cnn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            // se inicia el paso de parametros de la sentencia preparada
            sentencia.setObject(i++, entidad.getNombre());
            sentencia.setObject(i++, entidad.getEstado());
            // se ejecuta la sentencia preparada de insersion
            sentencia.executeUpdate();
            // se recupera el resultado obtenido de la base de datos
            ResultSet resultado = sentencia.getGeneratedKeys();
            // se verifica si el resultado de la base de datos tiene informacion
            // que deba ser leida
            if (resultado.next()) {
                // si el resultado si tiene informacion asignamos la llave 
                // generada al atributo que representa la llave primaria de la
                // entidad
                entidad.setIdRol(resultado.getLong(ID));
            }
        } finally {
            // se desconecta la sentencia preparada de la conexion a la base 
            // de datos.
            BdConexion.desconectar(sentencia);
        }
    }

    @Override
    public void editar(Rol entidad) throws SQLException {
        PreparedStatement sentencia = null;
        int i = 1;
        try {
            String sql = "update roll set nombre = ?, estado = ? where id_rol = ?";
            sentencia = cnn.prepareStatement(sql);
            sentencia.setObject(i++, entidad.getNombre());
            sentencia.setObject(i++, entidad.getEstado());
            sentencia.setObject(i++, entidad.getIdRol());
            sentencia.executeUpdate();
        } finally {
            BdConexion.desconectar(sentencia);
        }
    }

    @Override
    public List<Rol> consultar() throws SQLException {
        // Se genera la instancia de la sentencia preparada
        PreparedStatement sentencia = null;
        // Se crea un objeto de tipo List vacio para ser retornado en caso de 
        // que la consulta no retorne datos
        List<Rol> lista = new ArrayList<>();
        try {
            String sql = "select * from rol";
            sentencia = cnn.prepareStatement(sql);
            ResultSet result = sentencia.executeQuery();
            while (result.next()) {
                Rol rol = new Rol();
                rol.setIdRol(result.getLong("id_rol"));
                rol.setNombre(result.getString("nombre"));
                rol.setEstado(result.getBoolean("estado"));
                lista.add(rol);
            }
        } finally {
            BdConexion.desconectar(sentencia);
        }
        return lista;
    }

    @Override
    public Rol consultar(Long id) throws SQLException {
        // Se genera la instancia de la sentencia preparada
        PreparedStatement sentencia = null;
        // Se crea un objeto de tipo List vacio para ser retornado en caso de 
        // que la consulta no retorne datos
        Rol rol = new Rol();
        try {
            String sql = "select * from rol where id_rol = ?";
            sentencia = cnn.prepareStatement(sql);
            sentencia.setLong(1, id);
            ResultSet result = sentencia.executeQuery();
            if (result.next()) {
                rol.setIdRol(result.getLong("id_rol"));
                rol.setNombre(result.getString("nombre"));
                rol.setEstado(result.getBoolean("estado"));
            }
        } finally {
            BdConexion.desconectar(sentencia);
        }
        return rol;
    }
}
