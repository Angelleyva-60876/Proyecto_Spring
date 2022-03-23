package mx.uacam.fi.al60876.mueble.Model;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "clientes")
public class Cliente implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private String direccion;

    @OneToOne
    @JoinColumn(name = "id_mueble")
    private Mueble mueble;

    public Cliente() {
    }

    public Cliente(String nombre,String direccion, Mueble mueble) {
        this.nombre = nombre;
        this. direccion= direccion;
        this.mueble = mueble;
    }

    public Integer getId() {

        return id;
    }

    public void setId(Integer id) {

        this.id = id;
    }

    public String getNombre() {

        return nombre;
    }

    public void setNombre(String nombre) {

        this.nombre = nombre;
    }

    public String getDireccion() {

        return direccion;
    }

    public void setDireccion(String direccion) {

        this.direccion = direccion;
    }

    public Mueble getMueble() {

        return mueble;
    }

    public void setMueble(Mueble mueble) {

        this.mueble = mueble;
    }

    @Override
    public String toString() {
        return "clientes{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\''+
                '}';
    }

}
