
package Modelos;

/**
 *
 * @author Albert Acosta
 */
public class Usuarios_M {
    
    public int id;
    public String usuario;
    public String clave;
    public int tipo_usuario;

    public Usuarios_M() {
    }

    public Usuarios_M(int id, String usuario, String clave, int tipo_usuario) {
        this.id = id;
        this.usuario = usuario;
        this.clave = clave;
        this.tipo_usuario = tipo_usuario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public int getTipo_usuario() {
        return tipo_usuario;
    }

    public void setTipo_usuario(int tipo_usuario) {
        this.tipo_usuario = tipo_usuario;
    }
    
    
    
}
