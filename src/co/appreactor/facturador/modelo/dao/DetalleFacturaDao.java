/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.appreactor.facturador.modelo.dao;

import co.appreactor.facturador.modelo.conexion.BdConexion;
import co.appreactor.facturador.modelo.entidades.DetalleFactura;
import co.appreactor.facturador.modelo.entidades.Factura;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author capacitaciones
 */
public class DetalleFacturaDao implements IGenericoDao<DetalleFactura> {

    private final int ID = 1;
    private final Connection cnn;

    public DetalleFacturaDao(Connection cnn) {
        this.cnn = cnn;
    }
    
  
    
    @Override
    public void insertar(DetalleFactura entidad) throws SQLException {
        PreparedStatement sentencia = null;
        int i=1;
        try{ 
        String sql = "insert into detalle_factura(cantidad,valor_parcial,id_producto,id_factura) values (?,?,?,?)";
            sentencia = cnn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            sentencia.setObject(i++, entidad.getCantidad());
            sentencia.setObject(i++, entidad.getValorParcial());
            sentencia.setObject(i++, entidad.getIdProducto());
            sentencia.setObject(i++, entidad.getIdFactura());
            sentencia.executeUpdate();
            ResultSet resultado = sentencia.getGeneratedKeys();
             if (resultado.next()) {
                
                entidad.setIdDetalleFactura(resultado.getLong(ID));
            
            }
            
        } finally {
            
            BdConexion.desconectar(sentencia);
            
        }
    }

    @Override
    public void editar(DetalleFactura entidad) throws SQLException {
      PreparedStatement sentencia = null;  
      int i=1;
        try {
             String sql = "update roll set cantidad = ?, valor_parcial = ?, id_producto = ?, id_factura = ?, where id_detalle_factura = ?";
            sentencia = cnn.prepareStatement(sql);
            sentencia.setObject(i++, entidad.getCantidad());
            sentencia.setObject(i++, entidad.getValorParcial());
            sentencia.setObject(i++, entidad.getIdProducto());
            sentencia.setObject(i++, entidad.getIdFactura());
            sentencia.executeUpdate();
                
        } finally  {
            BdConexion.desconectar(sentencia);
            
        }
      
    }

    @Override
    public List<DetalleFactura> consultar() throws SQLException {
       PreparedStatement sentencia = null;
        List<DetalleFactura> lista = new ArrayList<>();
        try {
            String sql = "select * from detalle_factura";
            sentencia = cnn.prepareStatement(sql);
            ResultSet result = sentencia.executeQuery();
            while (result.next()) {
            
                DetalleFactura detalleFactura = new DetalleFactura();
                detalleFactura.setIdDetalleFactura(result.getLong("id_detalle_factura"));
                detalleFactura.setCantidad(result.getInt("cantidad"));
                detalleFactura.setValorParcial(result.getDouble("valor_parcial"));
                //detalleFactura.setIdProducto(result.getLong("id_producto"));
                //detalleFactura.setIdFactura(result.getLong("id_factura"));
                lista.add(detalleFactura);
            
            } 
        } finally  {
             BdConexion.desconectar(sentencia);
        }
        return lista;
    }

    @Override
    public DetalleFactura consultar(Long id) throws SQLException {
        PreparedStatement sentencia = null;
        return new DetalleFactura();
    }

}