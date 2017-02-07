/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.appreactor.facturador.negocio.delegados;

import co.appreactor.facturador.modelo.dao.UsuarioDao;
import co.appreactor.facturador.negocio.excepciones.FacturadorException;
import java.sql.Connection;

/**
 *
 * @author yefer
 */
public class UsuarioDelegado extends GenericoDelegado <UsuarioDelegado> {
    
    private final UsuarioDao usuarioDao;
    public UsuarioDelegado(Connection cnn) throws FacturadorException {
        super(cnn);
        
        usuarioDao = new UsuarioDao(cnn);
       genericoDao = usuarioDao;
       
    }
    
}
