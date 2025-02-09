package dam.ad.ad05_tareaevaluativa01.controller;

import dam.ad.ad05_tareaevaluativa01.domain.Book;
import dam.ad.ad05_tareaevaluativa01.repository.BookRepository;
import dam.ad.ad05_tareaevaluativa01.repository.CategoryRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * Controlador principal que gestiona las vistas principales de la aplicación,
 * como la página de inicio, la lista de libros y la lista de categorías
 */
@Controller
public class MainController {
    
    // Repositorios inyectados para interactuar con la base de datos de libros y categorías
    @Autowired
    private BookRepository bookRepository;
    
    @Autowired
    private CategoryRepository categoryRepository;
    
    /**
     * Muestra la página de inicio
     * Se agrega la UIR de la solicitud al modelo para referencias en la vista
     *
     * @param model El modelo para pasar datos a la vista
     * @param request La solicitud HTTP para obtener la URI actual
     * @return El nombre de la vista de inicio
     */
    @GetMapping({"", "/"})
    public String home(Model model, HttpServletRequest request) {
        // Agrega la URI al modelo
        model.addAttribute("requestURI", request.getRequestURI());
        return "index";
    }
    
    /**
     * Muestra la lista completa de libros
     * Pasa todos los libros obtenidos del repositorio a la vista
     *
     * @param model El modelo para pasar los datos a la vista
     * @param request La solicitud HTTP para obtener la URI actual
     * @return El nombre de la vista de libros
     */
    @GetMapping("/books")
    public String books(Model model, HttpServletRequest request) {
        // Agrega la URI al modelo y la lista de todos los libros al modelo
        model.addAttribute("requestURI", request.getRequestURI());
        model.addAttribute("books", bookRepository.findAll());
        return "book/books";
    }
    
    /**
     * Muestra la lista completa de categorías
     * Pasa todas las categorías obtenidas del repositorio a la vista
     *
     * @param model El modelo para pasar los datos a la vista
     * @param request La solicitud HTTP para obtener la URI actual
     * @return El nombre de la vista de categorías
     */
    @GetMapping("/categories")
    public String categories(Model model, HttpServletRequest request) {
        // Agrega la URI y la lista de todas las categorías al modelo
        model.addAttribute("requestURI", request.getRequestURI());
        model.addAttribute("categories", categoryRepository.findAll());
        return "category/categories";
    }
}
