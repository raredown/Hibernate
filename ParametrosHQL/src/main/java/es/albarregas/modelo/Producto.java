package es.albarregas.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "productos")
public class Producto implements Serializable {
    public static enum Estatus{ACTIVO, INACTIVO};

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdProducto")
    private int id;
    
    @Column(name = "Nombre", length = 30)
    private String nombre;
    
    @Column(name = "CodigoBarras", length = 40)
    private String codigoBarras;
    
    @Column(name = "Precio", scale = 2)
    private float precio;
    
    @Column(name = "Estado")
    private Estatus estado = Estatus.ACTIVO;

    public Producto() {
    }

    public Producto(String nombre, String codigoBarras, float precio) {
        this.nombre = nombre;
        this.codigoBarras = codigoBarras;
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public Estatus getEstado() {
        return estado;
    }

    public void setEstado(Estatus estado) {
        this.estado = estado;
    }
    
    
}
