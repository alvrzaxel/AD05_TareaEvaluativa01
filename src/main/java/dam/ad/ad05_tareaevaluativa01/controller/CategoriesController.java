package dam.ad.ad05_tareaevaluativa01.controller;

import dam.ad.ad05_tareaevaluativa01.domain.Category;
import dam.ad.ad05_tareaevaluativa01.repository.BookRepository;
import dam.ad.ad05_tareaevaluativa01.repository.CategoryRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador encargado de gestionar las acciones relacionadas con las categorías en la aplicación
 * Define las rutas y acciones CRUD para las categorías
 */
@Controller
@RequestMapping("/categories")
public class CategoriesController {
    
    // Inyección del repositorio para interactuar con la base de datos de categorías
    @Autowired
    CategoryRepository categoryRepository;
    
    @Autowired
    BookRepository bookRepository;
    
    /**
     * Muestra el formulario para crear una nueva categoría
     * Inicializa un objeto Category vacío y lo paso al modelo
     *
     * @param model El modelo para pasar los datos a la vista
     * @param request La solicitud HTTP para obtener la URI actual
     * @return El nombre de la vista para el formulario de creación de categoría
     */
    @GetMapping("/new")
    public String creationCategory(Model model, HttpServletRequest request) {
        // Crea un nuevo objeto Category
        Category newCategory = new Category();
        
        // Pasa el objeto Category y la URI al modelo
        model.addAttribute("category", newCategory);
        model.addAttribute("requestURI", request.getRequestURI());
        return "category/categoryForm";
    }
    
    /**
     * Procesa la creación de una nueva categoría y la guarda en la base de datos
     * Redirige a la lista de categorías después de guardar la nueva categoría
     *
     * @param category La categoría a guardar, que se obtiene del formulario
     * @return La redirección a la lista de categorías
     */
    @PostMapping("/new/submit")
    public String submitCategory(@ModelAttribute Category category) {
        // Guarda la nueva categoría en la base de datos
        categoryRepository.save(category);
        return "redirect:/categories";
    }
    
    /**
     * Muestra el formulario de edición para una categoría existente
     * Pasa la categoría seleccionada por su ID al modelo
     *
     * @param id El ID de la categoría a editar
     * @param model El modelo para pasar los datos a la vista
     * @param request La solicitud HTTP para obtener la URI actual
     * @return El nombre de la vista para el formulario de edición de la categoría
     */
    @GetMapping("/edit/{id}")
    public String editCategory(@PathVariable("id") Long id, Model model, HttpServletRequest request) {
        try {
            // Agrega la categoría selecionnada por si ID y la URI actual al modelo
            model.addAttribute("category", categoryRepository.findById(id)
                    .orElseThrow(IllegalArgumentException::new));
            model.addAttribute("requestURI", request.getRequestURI());
            return "category/categoryForm";
            
        } catch (IllegalArgumentException e) {
            return "redirect:/categories";
        }
    }
    
    /**
     * Elimina una categoría de la base de datos mediante su ID
     * Redirige a la lista de categorías después de la eliminación
     *
     * @param id El ID de la categoría a eliminar
     * @param model El modelo para pasar los datos a la vista
     * @param request La solicitud HTTP para obtener la URI actual
     * @return La redirección a la lista de categorías
     */
    @GetMapping("/delete/{id}")
    public String deleteCategory(@PathVariable("id") Long id, Model model, HttpServletRequest request) {
        // Elimina la categoría por su ID
        categoryRepository.deleteById(id);
        return "redirect:/categories";
    }
    
    /**
     * Elimina un libro de la base de datos mediante su ID
     * Redirige a la lista de categorías después de su eliminación
     *
     * @param id El ID del libro a eliminar
     * @param model El modelo para pasar los datos a la vista
     * @param request La solicitud HTTP para obtener la URI actual
     * @return La redirección a la lista de categorías
     */
    @GetMapping("/delete/book/{id}")
    public String deleteBookFromCategory(@PathVariable("id") Long id, Model model, HttpServletRequest request) {
        // Elimina el libro por su ID
        bookRepository.deleteById(id);
        return "redirect:/categories";
    }
}
