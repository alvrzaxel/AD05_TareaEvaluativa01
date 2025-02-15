/**************************************************
 * Autor: Axel Álvarez Santos
 * Fecha: 15/02/2024
 * Tarea: AD05 Tarea Evaluativa 01
 **************************************************/

package dam.ad.ad05_tareaevaluativa01.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import dam.ad.ad05_tareaevaluativa01.domain.Book;

import java.util.List;

/**
 * Interfaz que extiende de JpaRepository para realizar operaciones CRUD sobre la entidad Book
 * Proporciona métodos personalizados para consultar libros por su estado
 */
public interface BookRepository extends JpaRepository<Book, Long> {
    // Proporciona métodos como save(), fidAll(), findById(), deleteById(), etc
    
    /**
     * Obtiene todos los libros con un estado específico
     *
     * @param status El estado de los libros (TOREAD, CURRENTLY, READ)
     * @return Una lista de libros que coinciden con el estado dado
     */
    List<Book> findAllByStatus(Book.BookStatus status);
    
}
