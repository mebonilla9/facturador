/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.appreactor.facturador.negocio.delegados;

import co.appreactor.facturador.modelo.dao.RolDao;
import co.appreactor.facturador.modelo.entidades.Rol;
import co.appreactor.facturador.negocio.excepciones.FacturadorException;
import java.sql.Connection;

/**
 *
 * @author Lord_Nightmare
 */
public class RolDelegado extends GenericoDelegado<Rol>{
    
    private final RolDao rolDao;

    public RolDelegado(Connection cnn) throws FacturadorException {
        super(cnn);
        rolDao = new RolDao(cnn);
        genericoDao = rolDao;
    }
    
    
    
}
