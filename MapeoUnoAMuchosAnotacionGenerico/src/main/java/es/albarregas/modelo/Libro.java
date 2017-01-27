package es.albarregas.modelo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "libroAnotacion")
public class Libro implements Serializable{

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private int idLibro;
    private String titulo;

    public Libro(){
        
    }
    
    public Libro(String titulo) {
        this.titulo = titulo;
    }

    public int getIdLibro() {
        return idLibro;
    }

    private void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    
    
}
