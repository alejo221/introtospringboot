package com.springlearning.intro.service.category;

import com.springlearning.intro.dto.CategoryDTO;
import com.springlearning.intro.dto.mappers.CategoryMapper;
import com.springlearning.intro.entity.Category;
import com.springlearning.intro.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Implementación de la lógica para Category.
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<CategoryDTO> findAll() {
        return categoryRepository.findAll().stream()
                .map(CategoryMapper::toDTO)
                .collect(Collectors.toList());
    }


    @Override
    public Optional<CategoryDTO> findById(Long id) {
        return categoryRepository.findById(id)
                .map(CategoryMapper::toDTO);
    }

    @Override
    public CategoryDTO save(CategoryDTO categoryDTO) {
        Category category = CategoryMapper.toEntity(categoryDTO);
        Category saved = categoryRepository.save(category);
        return CategoryMapper.toDTO(saved);
    }



    @Override
    public Optional<CategoryDTO> update(Long id, CategoryDTO categoryDetails) {
        return categoryRepository.findById(id).map(category -> {
            category.setName(categoryDetails.getName());
            Category updated = categoryRepository.save(category);
            return CategoryMapper.toDTO(updated);
        });
    }

    @Override
    public boolean delete(Long id) {
        return categoryRepository.findById(id).map(category -> {
            categoryRepository.delete(category);
            return true;
        }).orElse(false);
    }
}
