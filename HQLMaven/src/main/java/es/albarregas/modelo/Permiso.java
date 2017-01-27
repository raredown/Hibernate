package es.albarregas.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "permisos")
public class Permiso implements Serializable{
    
    public enum Estado {
        PENDIENTE,
        ACTIVO,
        INACTIVO
    };
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdPermiso")
    private int id;
    
    @Column(name = "Nombre", nullable = true, length = 100)
    private String nombre;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "Estado", nullable = true, length = 10)
    private Estado estado;

    public Permiso() {
    }

    public Permiso(String nombre, Estado estado) {
        this.nombre = nombre;
        this.estado = estado;
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

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
    
    
}
