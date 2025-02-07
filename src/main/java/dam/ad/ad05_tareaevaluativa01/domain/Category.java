package dam.ad.ad05_tareaevaluativa01.domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Category {
    
    @Id
    @SequenceGenerator(name = "category_gen", sequenceName = "category_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "category_gen")
    private Long id;
    
    @Column
    private String name; // Nombre de la categoría
    
    @OneToMany(mappedBy = "category")
    private List<Book> books = new ArrayList<>(); // Libros de la categoría
    
    // Constructores
    public Category() {}
    
    public Category(String name, List<Book> books) {
        this.name = name;
        this.books = books;
    }
    
    // Getters / Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public List<Book> getBooks() {
        return books;
    }
    
    public void setBooks(List<Book> books) {
        this.books = books;
    }
    
    public void addBook(Book book) {
        if (this.books != null) {
            this.books.add(book);
        }
    }
}
