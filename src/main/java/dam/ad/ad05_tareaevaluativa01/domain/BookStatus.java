package dam.ad.ad05_tareaevaluativa01.domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class BookStatus {
    
    @Id
    @SequenceGenerator(name = "book_status_gen", sequenceName = "book_status_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_status_gen")
    private Long id;
    
    @Enumerated(EnumType.STRING)
    private Status status; // Estado del libro
    
    @OneToMany(mappedBy = "status")
    private List<Book> books = new ArrayList<>();
    
    // Enum para los estados de los libros
    public enum Status {
        READ("Read"),
        TO_READ("To Read"),
        READING("Reading");
        
        private final String statusName;
        
        Status(String statusName) {
            this.statusName = statusName;
        }
        
        public String getStatusName() {
            return statusName;
        }
    }
    
    // Constructores
    public BookStatus() {}
    
    public BookStatus(Status status, List<Book> books) {
        this.status = status;
        this.books = books;
    }
    
    // Getters / Setters
    public Status getStatus() {
        return status;
    }
    
    public void setStatus(Status status) {
        this.status = status;
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public List<Book> getBooks() {
        return books;
    }
    
    public void setBooks(List<Book> books) {
        this.books = books;
    }
    
    public void addBook(Book book) {
        this.books.add(book);
    }
}

