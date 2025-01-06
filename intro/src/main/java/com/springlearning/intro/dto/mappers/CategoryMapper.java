package com.springlearning.intro.dto.mappers;

import com.springlearning.intro.dto.CategoryDTO;
import com.springlearning.intro.entity.Category;

import java.util.stream.Collectors;

/**
 * Clase de utilidad para mapear objetos Category ↔ CategoryDTO.
 */
public class CategoryMapper {

    // De Entidad a DTO
    public static CategoryDTO toDTO(Category category) {
        if (category == null) {
            return null;
        }
        CategoryDTO dto = new CategoryDTO(category.getId(), category.getName());

        // Convertir cada producto de la categoría a ProductDTO
        dto.setProducts(
                category.getProducts().stream()
                        .map(ProductMapper::toDTO)  // usamos el mapper de Product
                        .collect(Collectors.toList())
        );
        return dto;
    }

    // De DTO a Entidad
    public static Category toEntity(CategoryDTO dto) {
        if (dto == null) {
            return null;
        }
        Category category = new Category(dto.getName());
        // Asignamos el ID para casos de update
        if (dto.getId() != null) {
            // OJO: esto asume un constructor vacío en Category
            // y que setId sea visible (o usar Reflection/Builder)
            // o podríamos usar un constructor con id
        }
        return category;
    }
}
