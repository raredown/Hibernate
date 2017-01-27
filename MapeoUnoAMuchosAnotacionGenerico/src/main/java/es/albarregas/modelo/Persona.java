package es.albarregas.modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "personaAnotacion")
public class Persona implements Serializable{

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private int idPerso;
    private String nombre;
    
    @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinTable(name = "personaLibro")
    private List<Libro> libros;

    public Persona(){
        
    }
    
    public Persona(String nombre, List<Libro> libros) {
        this.nombre = nombre;
        this.libros = libros;
    }

    public int getIdPerso() {
        return idPerso;
    }

    private void setIdPerso(int idPerso) {
        this.idPerso = idPerso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }
    
}
