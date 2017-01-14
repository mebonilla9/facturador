package co.appreactor.facturador.modelo.entidades;

/**
 *
 * @autor Santiago
 */
public class TipoCliente {
    
    private Long idTipocCliente;
    private String nombre;
    private boolean estado;

    public TipoCliente() {
    }

    public Long getIdTipocCliente() {
        return idTipocCliente;
    }

    public void setIdTipocCliente(Long idTipocCliente) {
        this.idTipocCliente = idTipocCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    
}
