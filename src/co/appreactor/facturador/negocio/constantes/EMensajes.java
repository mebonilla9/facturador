/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.appreactor.facturador.negocio.constantes;

/**
 *
 * @author Lord_Nightmare
 */
public enum EMensajes {

    INSERTO(1, "Se insertó correctamente"),
    MODIFICO(1, "Se modificó correctamente"),
    ELIMINO(1, "Se eliminó correctamente"),
    CONSULTO(1, "Se ha consultado correctamente"),
    ERROR_INSERTO(-1, "Error al insertar el registro"),
    ERROR_MODIFICO(-1, "Error al modificar el registro"),
    ERROR_ELIMINO(-1, "Error al eliminar el registro"),
    ERROR_CONSULTO(-1, "Error al consultar el registro"),
    ERROR_REGISTRO_EXISTE(-1, "El registro ya existe"),
    ERROR_CONEXION_BD(-2, "No hay conexión con la base de datos");

    private int codigo;
    private String descripcion;

    private EMensajes(int codigo, String descripcion) {
        this.codigo = codigo;
        this.descripcion = descripcion;
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
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
