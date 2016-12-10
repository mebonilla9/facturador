/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.appreactor.facturador.modelo.dao;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Lord_Nightmare
 */
public interface IGenericoDao<T> {
    
    public void insertar(T entidad) throws SQLException;
    public void editar(T entidad) throws SQLException;
    public List<T> consultar() throws SQLException;
    public T consultar(Long id) throws SQLException;
    
}
