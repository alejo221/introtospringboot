package com.springlearning.intro.repository;

import com.springlearning.intro.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio para la entidad Category.
 */
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    // Métodos de consulta personalizados si se requieren
}
