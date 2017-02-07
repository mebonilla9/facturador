/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.appreactor.facturador.negocio.delegados;

import co.appreactor.facturador.modelo.dao.TipoClienteDao;
import co.appreactor.facturador.negocio.excepciones.FacturadorException;
import java.sql.Connection;

/**
 *
 * @author yefer
 */
public class TipoClienteDelegado extends GenericoDelegado <TipoClienteDelegado>{
    
    private final TipoClienteDao tipoClienteDao;
    
    public TipoClienteDelegado(Connection cnn) throws FacturadorException {
        super(cnn);
     tipoClienteDao= new TipoClienteDao(cnn);     
    }
    
}
