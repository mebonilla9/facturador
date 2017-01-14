/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.appreactor.facturador.modelo.dao;

import co.appreactor.facturador.modelo.entidades.Factura;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import co.appreactor.facturador.modelo.conexion.BdConexion;


/**
 *
 * @author capacitaciones
 */
public class FacturaDao implements IGenericoDao<Factura>{
    
    private final int ID = 1;
    private final Connection cnn;
    
    public FacturaDao (Connection cnn){
        this.cnn = cnn;
    }

    @Override
    public void insertar(Factura entidad) throws SQLException {
        
        PreparedStatement sentencia = null;
        int i = 1;
        try {
            
            String sql = "insert into factura(fecha_generacion,fecha_pago,fecha_garantia,estado,id_cliente,id_usuario) values (?,?)";
            sentencia = cnn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            sentencia.setObject(i++, entidad.getFechaGeneracion());
            sentencia.setObject(i++, entidad.getFechaPago());
            sentencia.setObject(i++, entidad.getFechaGarantia());
            sentencia.setObject(i++, entidad.getEstado());
            sentencia.setObject(i++, entidad.getCliente());
            sentencia.setObject(i++, entidad.getUsuario());
            sentencia.executeUpdate();
            ResultSet resultado = sentencia.getGeneratedKeys();
            
            if (resultado.next()) {
                
                entidad.setIdFactura(resultado.getLong(ID));
            
            }
            
        } finally {
            
            BdConexion.desconectar(sentencia);
            
        }
        
    }

    @Override
    public void editar(Factura entidad) throws SQLException {
        
        PreparedStatement sentencia = null;
        int i = 1;
        
        try {
            
            String sql = "update roll set fecha_generacion = ?, fecha_pago = ?, fecha_garantia = ?, estado = ?, id_cliente = ?, id_usuario = ?, where id_factura = ?";
            sentencia = cnn.prepareStatement(sql);
            sentencia.setObject(i++, entidad.getFechaGeneracion());
            sentencia.setObject(i++, entidad.getFechaPago());
            sentencia.setObject(i++, entidad.getFechaGarantia());
            sentencia.setObject(i++, entidad.getEstado());
            sentencia.setObject(i++, entidad.getCliente());
            sentencia.setObject(i++, entidad.getUsuario());
            sentencia.executeUpdate();
            
        } finally {
            
            BdConexion.desconectar(sentencia);
        }
        
    }

    @Override
    public List<Factura> consultar() throws SQLException {
        
        PreparedStatement sentencia = null;
        List<Factura> lista = new ArrayList<>();
        
        try {
            
            String sql = "select * from factura";
            sentencia = cnn.prepareStatement(sql);
            ResultSet result = sentencia.executeQuery();
            
            while (result.next()) {
            
                Factura factura = new Factura();
                factura.setIdFactura(result.getLong("id_factura"));
                factura.setFechaGeneracion(result.getDate("fecha_generacion"));
                factura.setFechaPago(result.getDate("fecha_pago"));
                factura.setFechaGarantia(result.getDate("fecha_garantia"));
                factura.setEstado(result.getBoolean("estado"));
//                factura.setCliente(result.getObject("cliente"));
//                factura.setUsuario(result.getObject("usuario"));
                lista.add(factura);
            
            }
            
        } finally {
            
            BdConexion.desconectar(sentencia);
        }
        
        return lista;
        
    }

    @Override
    public Factura consultar(Long id) throws SQLException {
        
        PreparedStatement sentencia = null;
        Factura factura = new Factura();
        
        try {
            
            String sql = "select * from factura where id_factura = ?";
            sentencia = cnn.prepareStatement(sql);
            sentencia.setLong(1, id);
            ResultSet result = sentencia.executeQuery();
            
            if (result.next()) {
            
                factura.setIdFactura(result.getLong("id_factura"));
                factura.setFechaGeneracion(result.getDate("fecha_generacion"));
                factura.setFechaPago(result.getDate("fecha_pago"));
                factura.setFechaGarantia(result.getDate("fecha_garantia"));
                factura.setEstado(result.getBoolean("estado"));
//                factura.setCliente(result.getObject("cliente"));
//                factura.setUsuario(result.getObject("usuario"));
            
            }
            
        } finally {
            
            BdConexion.desconectar(sentencia);
            
        }
        
        return factura;
        
    }
    
      
}