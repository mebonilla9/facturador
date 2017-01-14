/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.appreactor.facturador.modelo.dao;

import co.appreactor.facturador.modelo.conexion.BdConexion;
import co.appreactor.facturador.modelo.entidades.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Julian Joya
 */
public class UsuarioDao implements IGenericoDao<Usuario> {

    private final int ID = 1;
    private final Connection cnn;

    public UsuarioDao(Connection cnn) {
        this.cnn = cnn;
    }

    @Override
    public void insertar(Usuario entidad) throws SQLException {
        
        PreparedStatement sentencia = null;
        
        int i = 1;
        try {
            String sql = "insert into usuario(nombre,documento,telefono,direccion,correo,contrasena,estado,id_rol) values (?,?,?,?,?,?,?,?)";
            sentencia = cnn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            sentencia.setObject(i++, entidad.getNombre());
            sentencia.setObject(i++, entidad.getDocumento());
            sentencia.setObject(i++, entidad.getTelefono());
            sentencia.setObject(i++, entidad.getDireccion());
            sentencia.setObject(i++, entidad.getCorreo());
            sentencia.setObject(i++, entidad.getContrasena());
            sentencia.setObject(i++, entidad.getEstado());
            //sentencia.setObject(i++, entidad.getIdRol());
            sentencia.executeUpdate();
            ResultSet resultado = sentencia.getGeneratedKeys();
            if (resultado.next()) {
                entidad.setIdUsuario(resultado.getLong(ID));
            }
        } finally {
            BdConexion.desconectar(sentencia);
        }
    }

    @Override
    public void editar(Usuario entidad) throws SQLException {
        PreparedStatement sentencia = null;
        int i = 1;
        try {
            String sql = "update usuario set nombre = ?, documento = ?,telefono = ?,direccion = ?,correo = ?,contrasena = ?,estado = ? where id_rol = ?";
            sentencia = cnn.prepareStatement(sql);
            sentencia.setObject(i++, entidad.getNombre());
            sentencia.setObject(i++, entidad.getDocumento());
            sentencia.setObject(i++, entidad.getTelefono());
            sentencia.setObject(i++, entidad.getDireccion());
            sentencia.setObject(i++, entidad.getCorreo());
            sentencia.setObject(i++, entidad.getContrasena());
            sentencia.setObject(i++, entidad.getEstado());
            //sentencia.setObject(i++, entidad.getIdRol());
            sentencia.executeUpdate();
        } finally {
            BdConexion.desconectar(sentencia);
        }
    }

    @Override
    public List<Usuario> consultar() throws SQLException {
        PreparedStatement sentencia = null;
        List<Usuario> lista = new ArrayList<>();
        try {
            String sql = "select * from usuario";
            sentencia = cnn.prepareStatement(sql);
            ResultSet result = sentencia.executeQuery();
            while (result.next()) {
                Usuario usuario = new Usuario();
                usuario.setIdUsuario(result.getLong("id_usuario"));
                usuario.setNombre(result.getString("nombre"));
                usuario.setDocumento(result.getInt("documento"));
                usuario.setTelefono(result.getString("telefono"));
                usuario.setDireccion(result.getString("direccion"));
                usuario.setCorreo(result.getString("correo"));
                usuario.setContrasena(result.getString("contrasena"));
                usuario.setEstado(result.getBoolean("estado"));
                //usuario.setIdRol(result.getLong("id_rol"));
                lista.add(usuario);
            }
        } finally {
            BdConexion.desconectar(sentencia);
        }
        return lista;
    }

    @Override
    public Usuario consultar(Long id) throws SQLException {
        PreparedStatement sentencia = null;
        Usuario usuario = new Usuario();
        try {
            String sql = "select * from usuario where id_usuario = ?";
            sentencia = cnn.prepareStatement(sql);
            sentencia.setLong(1, id);
            ResultSet result = sentencia.executeQuery();
            if (result.next()) {
                usuario.setIdUsuario(result.getLong("id_usuario"));
                usuario.setNombre(result.getString("nombre"));
                usuario.setDocumento(result.getInt("documento"));
                usuario.setTelefono(result.getString("telefono"));
                usuario.setDireccion(result.getString("direccion"));
                usuario.setCorreo(result.getString("correo"));
                usuario.setContrasena(result.getString("contrasena"));
                usuario.setEstado(result.getBoolean("estado"));
                //usuario.setIdRol(result.getLong("id_rol"));
            }
        } finally {
            BdConexion.desconectar(sentencia);
        }
        return usuario;
    }
}