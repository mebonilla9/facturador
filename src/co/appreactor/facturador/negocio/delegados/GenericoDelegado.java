/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.appreactor.facturador.negocio.delegados;

import co.appreactor.facturador.modelo.conexion.BdConexion;
import co.appreactor.facturador.modelo.dao.IGenericoDao;
import co.appreactor.facturador.negocio.constantes.EMensajes;
import co.appreactor.facturador.negocio.excepciones.FacturadorException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Lord_Nightmare
 */
public abstract class GenericoDelegado<T> {
    
    protected Connection cnn;
    protected IGenericoDao genericoDao;

    public GenericoDelegado(Connection cnn) throws FacturadorException{
        this.cnn = cnn;
    }
    
    public void insertar(T entidad) throws FacturadorException{
        try {
            genericoDao.insertar(entidad);
        } catch (SQLException e) {
            BdConexion.rollback(cnn);
            throw new FacturadorException(EMensajes.ERROR_INSERTO);
        }
    }
    
    public void editar(T entidad) throws FacturadorException{
        try {
            genericoDao.editar(entidad);
        } catch (SQLException e) {
            BdConexion.rollback(cnn);
            throw new FacturadorException(EMensajes.ERROR_INSERTO);
        }
    }
    
    public List<T> consultar() throws FacturadorException{
        try {
            return genericoDao.consultar();
        } catch (SQLException e) {
            BdConexion.rollback(cnn);
            throw new FacturadorException(EMensajes.ERROR_CONSULTO);
        }
    }
    
    public T consultar(Long id) throws FacturadorException{
        try {
            return (T) genericoDao.consultar(id);
        } catch (SQLException e) {
            BdConexion.rollback(cnn);
            throw new FacturadorException(EMensajes.ERROR_CONSULTO);
        }
    }
    
}
