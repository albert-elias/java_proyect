
package Modelos;

/**
 *
 * @author Albert Acosta
 */
public class TipoUsuario_M {
    
    public int id;
    public String name;

    public TipoUsuario_M() {
    }

    public TipoUsuario_M(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
        
}
