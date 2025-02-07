package dam.ad.ad05_tareaevaluativa01.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

import java.time.LocalDate;

@Entity
public class Book {
    
    @Id
    @SequenceGenerator(name = "book_gen", sequenceName = "book_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_gen")
    private int id;
    
    @Column
    private String title; // Título del libro
    
    @Column
    private String author; // Author del libro
    
    @Column
    private LocalDate readDate; // Fecha de lectura
    
    @Column
    @Min(1)
    @Max(5)
    private Integer rating; // Valoración
    
    @ManyToOne
    private Category category; // Categoría del libro
    
    @ManyToOne
    private BookStatus status; // Estado del libro
    
    // Constructores
    public Book() {}
    
    public Book(String title, String author, LocalDate readDate, Integer rating, Category category, BookStatus status) {
        this.title = title;
        this.author = author;
        this.readDate = readDate;
        this.rating = rating;
        this.category = category;
        this.status = status;
    }
    
    // Getters / Setters
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
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
