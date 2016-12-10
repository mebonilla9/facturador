/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.appreactor.facturador.modelo.dao;

import java.util.List;

/**
 *
 * @author Lord_Nightmare
 */
public interface IGenericoDao<T> {
    
    public void insertar(T entidad);
    public void editar(T entidad);
    public List<T> consultar();
    public T consultar(Long id);
    
}
