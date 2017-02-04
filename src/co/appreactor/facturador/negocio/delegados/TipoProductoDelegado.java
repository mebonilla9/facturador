/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.appreactor.facturador.negocio.delegados;

import co.appreactor.facturador.modelo.dao.TipoProductoDao;
import co.appreactor.facturador.modelo.entidades.TipoProducto;
import co.appreactor.facturador.negocio.delegados.GenericoDelegado;
import co.appreactor.facturador.negocio.excepciones.FacturadorException;
import java.sql.Connection;

/**
 *
 * @author Capacitaciones_pc47
 */
public class TipoProductoDelegado extends GenericoDelegado<TipoProducto>{
    
    private final TipoProductoDao tipoProductoDao;

    public TipoProductoDelegado(Connection cnn) throws FacturadorException {
        super(cnn);
        tipoProductoDao = new TipoProductoDao (cnn);
        genericoDao = tipoProductoDao;
    }
    
}
