package mx.uacam.fi.al60876.mueble.Model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "mueble")
public class Mueble implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String tipo_mueble;
    private Integer lote;
    private Integer precio;

    @OneToOne(mappedBy = "mueble")
    private Cliente cliente;

    public Cliente getClientes()
    {

        return cliente;
    }

    public Mueble() {
    }

    public Mueble(String tipo_mueble, Integer lote, Integer precio) {
        this.tipo_mueble = tipo_mueble;
        this.lote = lote;
        this.precio = precio;
    }

    public Integer getId() {

        return id;
    }

    public void setId(Integer id) {

        this.id = id;
    }

    public String getTipo_mueble() {

        return tipo_mueble;
    }

    public void setTipo_mueble(String tipo_mueble) {

        this.tipo_mueble = tipo_mueble;
    }

    public Integer getLote() {

        return lote;
    }

    public void setLote(Integer lote) {

        this.lote = lote;
    }

    public Integer getPrecio() {

        return precio;
    }

    public void setPrecio(Integer precio) {

        this.precio = precio;
    }

    @Override
    public String toString() {
        return "mueble{" +
                "id=" + id +
                ", tipo_mueble='" + tipo_mueble + '\'' +
                ", lote='" + lote + '\'' +
                ", precio=" + precio +
                '}';
    }
}
