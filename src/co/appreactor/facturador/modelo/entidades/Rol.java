/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.appreactor.facturador.modelo.entidades;

/**
 *
 * @author Lord_Nightmare
 */
public class Rol {
    
    private Long idRol;
    private String nombre;
    private Boolean estado;

    public Rol() {
    }

    public Rol(Long idRol) {
        this.idRol = idRol;
    }

    /**
     * @return the idRol
     */
    public Long getIdRol() {
        return idRol;
    }

    /**
     * @param idRol the idRol to set
     */
    public void setIdRol(Long idRol) {
        this.idRol = idRol;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the estado
     */
    public Boolean getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(Boolean estado) {
        this.estado = estado;
    }     
}
