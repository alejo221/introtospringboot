package com.springlearning.intro.controller;

import com.springlearning.intro.dto.CategoryDTO;
import com.springlearning.intro.entity.Category;
import com.springlearning.intro.service.category.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para las categorías.
 */
@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    /**
     * 1. Listar todas las categorías.
     */
    @GetMapping
    public List<CategoryDTO> getAllCategories() {
        return categoryService.findAll();
    }

    /**
     * 2. Obtener una categoría por ID.
     */
    @GetMapping("/{id}")
    public ResponseEntity<CategoryDTO> getCategoryById(@PathVariable Long id) {
        return categoryService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * 3. Crear una nueva categoría.
     */
    @PostMapping
    public CategoryDTO createCategory(@RequestBody CategoryDTO category) {
        return categoryService.save(category);
    }

    /**
     * 4. Actualizar una categoría.
     */
    @PutMapping("/{id}")
    public ResponseEntity<CategoryDTO> updateCategory(@PathVariable Long id,
                                                   @RequestBody CategoryDTO categoryDetails) {
        return categoryService.update(id, categoryDetails)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * 5. Eliminar una categoría.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        boolean deleted = categoryService.delete(id);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
