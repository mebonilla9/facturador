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
public class Usuario {
    
    private Long idUsuario;
    private String nombre;
    private Integer documento;
    private String telefono;
    private String direccion;
    private String correo;
    private String contrasena;
    private Boolean estado;
    private Rol rol;

    public Usuario() {
    }
    
    public Usuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    
}
