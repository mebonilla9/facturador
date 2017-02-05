/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.appreactor.facturador.negocio.delegados;

import co.appreactor.facturador.modelo.dao.ProductoDao;
import co.appreactor.facturador.modelo.entidades.Producto;
import co.appreactor.facturador.negocio.excepciones.FacturadorException;
import java.sql.Connection;

/**
 *
 * @author yefer
 */
public class ProductoDelegado  extends GenericoDelegado <Producto>{
    
    private final ProductoDao productoDao;
    public ProductoDelegado(Connection cnn) throws FacturadorException {
        super(cnn);
        
        productoDao = new ProductoDao(cnn);
        genericoDao = productoDao;
    }
    
    
    
}
