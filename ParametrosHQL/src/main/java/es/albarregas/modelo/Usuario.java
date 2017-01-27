package es.albarregas.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable
{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "IdUsuario")
    private int id;
    
    @Column(name = "Nombre", length = 30)
    private String nombre;
    
    @Column(name = "UserName", length = 30)
    private String username;
    
    @Column(name = "Password", length = 100)
    private String password;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "IdDireccion", nullable = true)
    private Direccion direccion;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "usuariosCompras",
            joinColumns = @JoinColumn(name = "usuarioId"),
            inverseJoinColumns = @JoinColumn(name = "compraId"))
    private List<Compra> compras = new ArrayList<>();

    public Usuario() {
    }

    public Usuario(String nombre, String username, String password) {
        this.nombre = nombre;
        this.username = username;
        this.password = password;
    }

    public long getId() {
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public List<Compra> getCompras() {
        return compras;
    }

    public void setCompras(List<Compra> compras) {
        this.compras = compras;
    }

    public void addCompra(Compra compra){
        this.compras.add(compra);
        compra.setUsuario(this);
    }
}
