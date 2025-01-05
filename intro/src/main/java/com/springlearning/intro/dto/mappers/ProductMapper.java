package com.springlearning.intro.dto.mappers;


import com.springlearning.intro.dto.ProductDTO;
import com.springlearning.intro.entity.Category;
import com.springlearning.intro.entity.Product;

/**
 * Clase de utilidad para mapear objetos Product ↔ ProductDTO.
 */
public class ProductMapper {

    public static ProductDTO toDTO(Product product) {
        if (product == null) {
            return null;
        }
        ProductDTO dto = new ProductDTO();
        dto.setId(product.getId());
        dto.setName(product.getName());
        dto.setPrice(product.getPrice());
        // Obtenemos el ID de la categoría asociada
        dto.setCategoryId(
                product.getCategory() != null
                        ? product.getCategory().getId()
                        : null
        );
        return dto;
    }

    public static Product toEntity(ProductDTO dto, Category category) {
        if (dto == null) {
            return null;
        }
        Product product = new Product();
        // Para actualizaciones:
        if (dto.getId() != null) {
            // Asumiríamos que la capa de servicio busca la entidad existente
            // y luego la actualiza, o se maneja de otra forma
        }
        product.setName(dto.getName());
        product.setPrice(dto.getPrice());
        product.setCategory(category); // ya existente en BD
        return product;
    }
}