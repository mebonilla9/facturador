/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.appreactor.facturador.modelo.dao;

import co.appreactor.facturador.modelo.conexion.BdConexion;
import co.appreactor.facturador.modelo.entidades.Cliente;
import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author yefer
 */
public class ClienteDao implements IGenericoDao<Cliente>{
    
    private final int ID=1;
    private final Connection cnn;
    public ClienteDao(Connection cnn){
        this.cnn=cnn;
    }
    
    @Override
    public void insertar(Cliente entidad) throws SQLException {
        PreparedStatement Sentencia =null;
        int i=1;
        try{
            String sql ="insert into cliente(nombre,correo,telefono,direccion,estado) values (?,?,?,?,?)";
            Sentencia= cnn.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
            Sentencia.setObject(i++,entidad.getNombre());
            Sentencia.setObject(i++,entidad.getCorreo());
            Sentencia.setObject(i++,entidad.getTelefono());
            Sentencia.setObject(i++,entidad.getDireccion());
            Sentencia.setObject(i++,entidad.getEstado());
            Sentencia.executeUpdate();
            ResultSet resultado=Sentencia.getGeneratedKeys();
            
            if(resultado.next()){
               entidad.setIdCliente(resultado.getLong(ID)); 
            }
            
        }finally {
           BdConexion.desconectar(Sentencia);
        }
    }

    @Override
    public void editar(Cliente entidad) throws SQLException {
        PreparedStatement Sentencia =null;
        int i=0;
        
        try{
            String sql ="update cliente set nombre = ?,correo = ?, telefono = ?,direccion = ?, estado = ? where id_cliente = ?";
        Sentencia = cnn.prepareStatement(sql);
        Sentencia.setObject(i++, entidad.getNombre());
        Sentencia.setObject(i++, entidad.getCorreo());
        Sentencia.setObject(i++, entidad.getTelefono());
        Sentencia.setObject(i++, entidad.getDireccion());
        Sentencia.setObject(i++, entidad.getEstado());
        Sentencia.setObject(i++, entidad.getIdCliente());
        
         }finally {
            BdConexion.desconectar(Sentencia);
        }
    }

    @Override
    public List<Cliente> consultar() throws SQLException {
       PreparedStatement Sentencia =null;
       List<Cliente> lista = new ArrayList<>();
       int i=1;
       
       try{
         String sql="select * from cliente";
         Sentencia = cnn.prepareStatement(sql);
         ResultSet result = Sentencia.executeQuery();
         while(result.next()){
             Cliente cli = new Cliente();
             cli.setNombre(result.getString("nombre"));
             cli.setCorreo(result.getString("correo"));
             cli.setTelefono(result.getString("telefono"));
             cli.setDireccion(result.getString("direccion"));
             cli.setEstado(result.getBoolean("estado"));
             lista.add(cli);
         }
       }finally{
            BdConexion.desconectar(Sentencia);
        }
         return lista;
    }

    @Override
    public Cliente consultar(Long id) throws SQLException {
       
        PreparedStatement Sentencia = null;
        
        Cliente cli = new Cliente();
        try {
            String sql = "select * from cliente where id_cliente = ?";
            Sentencia = cnn.prepareStatement(sql);
            Sentencia.setLong(1, id);
            ResultSet result = Sentencia.executeQuery();
            if (result.next()) {
                cli.setIdCliente(result.getLong("id_cliente"));
                cli.setNombre(result.getString("nombre"));
                cli.setCorreo(result.getString("correo"));
                cli.setTelefono(result.getString("telefono"));
                cli.setDireccion(result.getString("direccion"));
                cli.setEstado(result.getBoolean("estado"));
            }
        } finally {
            BdConexion.desconectar(Sentencia);
        }
        return cli; 
    }
    
}
