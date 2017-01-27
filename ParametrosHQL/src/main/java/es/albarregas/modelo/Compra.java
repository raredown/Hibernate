package es.albarregas.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "compras")
public class Compra implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdCompra")
    private int id;
    
    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name = "compraProductos",
            joinColumns = @JoinColumn(name = "compraId"),
            inverseJoinColumns = @JoinColumn(name = "productoId"))
    private List<Producto> productos = new ArrayList<Producto>();
    
    @Column(name = "ImporteTotal", scale = 2)
    private double importeTotal;
    
    @ManyToOne
    private Usuario usuario;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public double getImporteTotal() {
        return importeTotal;
    }

    public void setImporteTotal(double importeTotal) {
        this.importeTotal = importeTotal;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public void addProducto(Producto producto){
        this.productos.add(producto);
        this.importeTotal += producto.getPrecio();
    }
}
