package dam.ad.ad05_tareaevaluativa01.controller;

import dam.ad.ad05_tareaevaluativa01.domain.Book;
import dam.ad.ad05_tareaevaluativa01.repository.BookRepository;
import dam.ad.ad05_tareaevaluativa01.repository.CategoryRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador encargado de gestionar las acciones relacionadas con los libros en la aplicación
 * Define las rutas y las acciones del CRUD para los libros
 */
@Controller
@RequestMapping("/books")
public class BooksController {
    
    // Repositorios inyectados para interactuar con la base de datos
    @Autowired
    BookRepository bookRepository;
    
    @Autowired
    CategoryRepository categoryRepository;
    
    /**
     * Muestra la lista de libros filtrados por su estado
     * Recibe el estado como parámetro de la URL y muestra los libros que tienen ese estado
     *
     * @param status El estado de los libros para mostrar (TOREAD, READ, CURRENTLY)
     * @param model El modelo para pasar los datos a la vista
     * @param request La solicitud HTTP para obtener la URI actual
     * @return El nombre de la vista que se mostrará
     */
    @GetMapping("/{status}")
    public String listBooksByStatus(@PathVariable("status") String status, Model model, HttpServletRequest request) {
        // Convierte el estado a mayúsculas y obtiene los libros filtrados
        Book.BookStatus bookStatus = Book.BookStatus.valueOf(status.toUpperCase());
        List<Book> books = bookRepository.findAllByStatus(bookStatus);
        
        // Agrega los libros a la URI actual al modelo
        model.addAttribute("books", books);
        model.addAttribute("requestURI", request.getRequestURI());
        return "book/books";
    }
    
    /**
     * Muestra el formulario para crear un libro nuevo
     * Inicializa un objeto Book vacío y pasa la lista de categorías disponibles
     *
     * @param model El modelo para pasar los datos de la vista
     * @param request La solicitud HTTP para obtener la URI actual
     * @return El nombre de la vista para el formulario de creación de libro
     */
    @GetMapping("/new")
    public String creationBook(Model model, HttpServletRequest request) {
        // Crea un nuevo libro con rating inicializado a 0
        Book book = new Book();
        book.setRating(0);
        
        // Pasa el libro y la lista de categorías a la vista
        model.addAttribute("book", book);
        model.addAttribute("categories", categoryRepository.findAll());
        model.addAttribute("requestURI", request.getRequestURI());
        return "book/bookForm";
    }
    
    /**
     * Procesa la creación de un nuevo libro y lo guarda en la base de datos
     * Redirige a la lista de libros después de guardar el libro
     *
     * @param book El libro a guardar, que se obtiene del formulario
     * @return La redirección a la lista de libros
     */
    @PostMapping("/new/submit")
    public String submitBook(@ModelAttribute Book book) {
        // Guarda el nuevo libro en la base de datos
        bookRepository.save(book);
        return "redirect:/books";
    }
    
    /**
     * Elimina un libor de la base de datos mediante su ID
     * Redirige a la lista de libros después de la eliminación
     * @param id El ID del libro a eliminar
     * @return La redirección a la lista de libros
     */
    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable("id") Long id) {
        // Elimina el libor por su ID
        bookRepository.deleteById(id);
        return "redirect:/books";
    }
    
    /**
     *  Muestra el formulario de edición para un libro existente
     *  Pasa el libro seleccionado por su ID y la lista de categorías a la vista
     *
     * @param id El ID del libro a editar
     * @param model El modelo para pasar los datos a la vista
     * @param request La solicitud HTTP para obtener la URI actual
     * @return El nombre d el vista para el formulario de edición de libro
     */
    
    @GetMapping("/edit/{id}")
    public String editBook(@PathVariable("id") Long id, Model model, HttpServletRequest request) {
        try {
            // Obtiene el libro por su ID y pasa la lista de categorías
            model.addAttribute("book", bookRepository.findById(id)
                    .orElseThrow(IllegalArgumentException::new));
            model.addAttribute("categories", categoryRepository.findAll());
            model.addAttribute("requestURI", request.getRequestURI());
            return "book/bookForm";
            
        } catch (IllegalArgumentException e) {
            return "redirect:/books";
        }
    }
}
