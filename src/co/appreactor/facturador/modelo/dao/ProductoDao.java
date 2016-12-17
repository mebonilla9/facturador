/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.appreactor.facturador.modelo.dao;

import java.sql.Connection;
import co.appreactor.facturador.modelo.conexion.BdConexion;
import co.appreactor.facturador.modelo.entidades.Producto;
import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author yefer
 */
public class ProductoDao implements IGenericoDao<Producto>{
    
    private final int ID=1;
    private final Connection cnn;
    public ProductoDao (Connection cnn){
        this.cnn=cnn;
    }

    @Override
    public void insertar(Producto entidad) throws SQLException {
        PreparedStatement Sentencia =null;
        int i=1;
        try{
            String sql ="insert into producto(nombre,precio_unitario,cantidad,estado) values (?,?,?,?)";
            Sentencia= cnn.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
            Sentencia.setObject(i++,entidad.getNombre());
            Sentencia.setObject(i++,entidad.getPrecioUnitario());
            Sentencia.setObject(i++,entidad.getCantidad());
            Sentencia.setObject(i++,entidad.getEstado());
            Sentencia.executeUpdate();
            ResultSet resultado=Sentencia.getGeneratedKeys();
            
            if(resultado.next()){
               entidad.setIdProducto(resultado.getLong(ID)); 
            }
            
        }finally {
           BdConexion.desconectar(Sentencia);
        }
    }

    @Override
    public void editar(Producto entidad) throws SQLException {
        PreparedStatement Sentencia =null;
        int i=0;
        
        try{
            String sql ="update producto set nombre = ?,precio_unitario = ?, cantidad = ?,estado = ? where id_producto = ?";
            Sentencia = cnn.prepareStatement(sql);
            Sentencia.setObject(i++,entidad.getNombre());
            Sentencia.setObject(i++,entidad.getPrecioUnitario());
            Sentencia.setObject(i++,entidad.getCantidad());
            Sentencia.setObject(i++,entidad.getEstado());
        
         }finally {
            BdConexion.desconectar(Sentencia);
        }
    }

  
    @Override
    public List<Producto> consultar() throws SQLException {
        PreparedStatement Sentencia =null;
       List<Producto> lista = new ArrayList<>();
       int i=1;
       
       try{
         String sql="select * from producto";
         Sentencia = cnn.prepareStatement(sql);
         ResultSet result = Sentencia.executeQuery();
         while(result.next()){
             Producto pro = new Producto();
             pro.setNombre(result.getString("nombre"));
             pro.setPrecioUnitario(result.getDouble("precio_unitario"));
             pro.setCantidad(result.getInt("cantidad"));
             pro.setEstado(result.getBoolean("estado"));
             lista.add(pro);
         }
       }finally{
            BdConexion.desconectar(Sentencia);
        }
        return lista;
    }

    @Override
    public Producto consultar(Long id) throws SQLException {
        PreparedStatement Sentencia = null;
        
        Producto pro = new Producto();
        try {
            String sql = "select * from producto where id_producto = ?";
            Sentencia = cnn.prepareStatement(sql);
            Sentencia.setLong(1, id);
            ResultSet result = Sentencia.executeQuery();
            if (result.next()) {
                pro.setIdProducto(result.getLong("id_producto"));
                pro.setNombre(result.getString("nombre"));
                pro.setPrecioUnitario(result.getDouble("precio_unitario"));
                pro.setCantidad(result.getInt("cantidad"));
                pro.setEstado(result.getBoolean("estado"));
            }
        } finally {
            BdConexion.desconectar(Sentencia);
        }
        return pro; 
    }
    
    
}
