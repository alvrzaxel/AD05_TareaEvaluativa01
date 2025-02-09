package dam.ad.ad05_tareaevaluativa01.repository;

import dam.ad.ad05_tareaevaluativa01.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interfaz que extiende de JpaRepository para realizar operaciones CRUD sobre la entidad Category
 * Proporciona las operaciones estándar de acceso a datos
 */
public interface CategoryRepository extends JpaRepository<Category, Long> {
    // Proporciona métodos como save(), fidAll(), findById(), deleteById(), etc
}
