
package ModelosVista;

/**
 *
 * @author Albert Acosta
 */
public class view_users {
    
    public int codigo;
    public String usuario, clave, tipo;

    public view_users() {
    }

    public view_users(int codigo, String usuario, String clave, String tipo) {
        this.codigo = codigo;
        this.usuario = usuario;
        this.clave = clave;
        this.tipo = tipo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    
    
}
