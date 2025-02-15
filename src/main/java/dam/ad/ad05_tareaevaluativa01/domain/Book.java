/**************************************************
 * Autor: Axel Álvarez Santos
 * Fecha: 15/02/2024
 * Tarea: AD05 Tarea Evaluativa 01
 **************************************************/

package dam.ad.ad05_tareaevaluativa01.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

/**
 * Entidad que representa un libro en la base de datos
 * Contiene la información del libro, como el título, autor, fecha de lectura, valoración,
 * estado y categoría
 */
@Entity
@Table(name = "book")
public class Book {
    
    // Definición de la clave primaria con secuenciador
    @Id
    @SequenceGenerator(name = "book_gen", sequenceName = "book_sqe", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_gen")
    private Long id;
    
    // Atributo para almacenar el título del libro
    @Column
    private String title;
    
    // Atributo para almacenar el autor del libro
    @Column
    private String author;
    
    // Atributo para almacenar la fecha en se leyó el libro
    @Column
    private LocalDate readDate; // Fecha de lectura
    
    // Atributo para almacenar la valoración del libro
    @Column
    private Integer rating;
    
    // Atributo para almacenar el estado del libro
    @Enumerated(EnumType.STRING)
    @NotNull
    private BookStatus status;
    
    // Enumeración que define los posibles estados de un libro
    public enum BookStatus {
        TOREAD, CURRENTLY, READ;
    }
    
    // Relación ManyToOne con la entidad Category
    // Un libro puede tener una sola categoría
    @ManyToOne
    private Category category;
    
    
    // CONSTRUCTORES
    // Constructor por defecto
    public Book() {}
    
    // Constructor para inicializar todos los atributos del libro
    public Book(
            String title, String author, LocalDate readDate, Integer rating, BookStatus status, Category category) {
        this.title = title;
        this.author = author;
        this.readDate = readDate;
        this.rating = rating;
        this.status = status;
        this.category = category;
    }
    
    
    // GETTERS / SETTERS
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getAuthor() {
        return author;
    }
    
    public void setAuthor(String author) {
        this.author = author;
    }
    
    public LocalDate getReadDate() {
        return readDate;
    }
    
    public void setReadDate(LocalDate readDate) {
        this.readDate = readDate;
    }
    
    public Integer getRating() {
        return rating;
    }
    
    public void setRating(Integer rating) {
        this.rating = rating;
    }
    
    public Category getCategory() {
        return category;
    }
    
    public void setCategory(Category category) {
        this.category = category;
    }
    
    public BookStatus getStatus() {
        return status;
    }
    
    public void setStatus(BookStatus status) {
        this.status = status;
    }
}
