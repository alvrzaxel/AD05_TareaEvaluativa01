package dam.ad.ad05_tareaevaluativa01.domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Entidad que representa una categoría de libros en la base datos
 * Contiene el nombre de la categoría y una lista de los libros que pertenecen a la categoría
 */
@Entity
@Table(name = "category")
public class Category {
    
    // Definición de la clave primaria con secuenciador
    @Id
    @SequenceGenerator(name = "category_gen", sequenceName = "category_sqe", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "category_gen")
    private Long id;
    
    // Atributo para almacenar el nombre de la categoría
    @Column
    private String name;
    
    // Relación OneToMany con la entidad Book
    // Una categoría puede tener muchos libros
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<Book> books = new ArrayList<>();
    
    
    // CONSTRUCTORES
    // Constructor por defecto
    public Category() {}
    
    // Constructor para inicializar con el atributo name
    public Category(String name) {
        this.name = name;
    }
    
    // Constructor con parámetros para inicializar todos los atributos
    public Category(List<Book> books) {
        super();
        this.books = books;
    }
    
    
    // GETTERS / SETTERS
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
