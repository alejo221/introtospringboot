package com.springlearning.intro.service.category;

import com.springlearning.intro.dto.CategoryDTO;
import com.springlearning.intro.entity.Category;

import java.util.List;
import java.util.Optional;

/**
 * Define los métodos relacionados con la entidad Category.
 */
public interface CategoryService {
    List<CategoryDTO> findAll();
    Optional<CategoryDTO> findById(Long id);
    CategoryDTO save(CategoryDTO categoryDTO);
    Optional<CategoryDTO> update(Long id, CategoryDTO categoryDetails);
    boolean delete(Long id);
}
