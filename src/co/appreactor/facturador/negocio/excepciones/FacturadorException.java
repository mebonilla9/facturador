/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.appreactor.facturador.negocio.excepciones;

import co.appreactor.facturador.negocio.constantes.EMensajes;

/**
 *
 * @author Lord_Nightmare
 */
public class FacturadorException extends Exception{
    
    private int codigo;
    private String mensaje;
    private Object datos;

    public FacturadorException(EMensajes mensaje){
        this.codigo = mensaje.getCodigo();
        this.mensaje = mensaje.getDescripcion();
    }
    
    public FacturadorException(EMensajes mensaje,Object datos){
        this.codigo = mensaje.getCodigo();
        this.mensaje = mensaje.getDescripcion();
        this.datos = datos;
    }
    
    /**
     * @return the codigo
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the mensaje
     */
    public String getMensaje() {
        return mensaje;
    }

    /**
     * @param mensaje the mensaje to set
     */
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    /**
     * @return the datos
     */
    public Object getDatos() {
        return datos;
    }

    /**
     * @param datos the datos to set
     */
    public void setDatos(Object datos) {
        this.datos = datos;
    }
    
    
    
}
