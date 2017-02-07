/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.appreactor.facturador.negocio.delegados;

import co.appreactor.facturador.modelo.dao.FacturaDao;
import co.appreactor.facturador.negocio.excepciones.FacturadorException;
import java.sql.Connection;

/**
 *
 * @author yefer
 */
public class FacturaDelegado extends GenericoDelegado <FacturaDelegado>{
    
    private final FacturaDao facturaDao;
    
    public FacturaDelegado(Connection cnn) throws FacturadorException {
        super(cnn);
        facturaDao = new FacturaDao(cnn);
        genericoDao = facturaDao;
    }
    
}
