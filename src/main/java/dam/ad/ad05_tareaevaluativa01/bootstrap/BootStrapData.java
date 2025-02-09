/*
package dam.ad.ad05_tareaevaluativa01.bootstrap;

import dam.ad.ad05_tareaevaluativa01.domain.Book;
import dam.ad.ad05_tareaevaluativa01.domain.Category;
import dam.ad.ad05_tareaevaluativa01.repository.BookRepository;
import dam.ad.ad05_tareaevaluativa01.repository.CategoryRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@Transactional // Asegura que las operaciones de la base de datos sean transaccionales
public class BootStrapData implements CommandLineRunner {
    
    // Repositorios inyectados para interactuar con la base de datos
    @Autowired
    BookRepository bookRepository;
    
    @Autowired
    CategoryRepository categoryRepository;
    
    @Override
    public void run(String... arg0) throws Exception {
        // Creación de nuevas categorías
        Category newCategory1 = new Category("Ciencia Ficción");
        Category newCategory2 = new Category("Thriller");
        
        // Guardado de las categorías en la base de datos
        categoryRepository.save(newCategory1);
        categoryRepository.save(newCategory2);
        
        // Creación de nuevos libros, asignando propiedades
        Book newBook1 = new Book(
                "Un lugar para Mungo",
                "Douglas Stuart",
                LocalDate.of(2024, 2, 17),
                5,
                Book.BookStatus.READ,
                newCategory2
        );
        
        Book newBook2 = new Book(
                "Nuestra parte de noche",
                "Mariana Enríquez",
                LocalDate.of(2024, 4, 14),
                4,
                Book.BookStatus.READ,
                newCategory2
        );
        
        Book newBook3 = new Book(
                "Un rey de invierno",
                "Juan Arcones",
                null,
                0,
                Book.BookStatus.CURRENTLY,
                newCategory1
        );
        
        Book newBook4 = new Book(
                "La verdad sobre el caso Harry Quebert",
                "Joël Dicker",
                null,
                0,
                Book.BookStatus.TOREAD,
                newCategory2
        );
        
        // Guardado de los libros en la base de datos
        bookRepository.save(newBook1);
        bookRepository.save(newBook2);
        bookRepository.save(newBook3);
        bookRepository.save(newBook4);
        
        // Impresión en consola del número de categorías y libros guardados
        System.out.println(("Number of categories: " + categoryRepository.count()));
        System.out.println("Number of books: " + bookRepository.count());
    }
}
 */
