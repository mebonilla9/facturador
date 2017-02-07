/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.appreactor.facturador.negocio.delegados;

import co.appreactor.facturador.modelo.dao.DetalleFacturaDao;
import co.appreactor.facturador.modelo.entidades.DetalleFactura;
import co.appreactor.facturador.negocio.excepciones.FacturadorException;
import java.sql.Connection;

/**
 *
 * @author yefer
 */
public class DetalleFacturaDelegado extends GenericoDelegado <DetalleFactura>{
    
    private final DetalleFacturaDao detalleFacturaDao;
    
    public DetalleFacturaDelegado(Connection cnn) throws FacturadorException {
        super(cnn);
       detalleFacturaDao = new DetalleFacturaDao(cnn); 
       genericoDao = detalleFacturaDao;
    }
    
}
