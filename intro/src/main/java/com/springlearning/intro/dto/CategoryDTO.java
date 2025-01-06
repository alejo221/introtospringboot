package com.springlearning.intro.dto;

import jakarta.validation.constraints.NotBlank;

import java.util.ArrayList;
import java.util.List;


/**
 * DTO para representar la información de Category
 * que se envía/recibe a través de la API.
 */
public class CategoryDTO {

    private Long id;

    @NotBlank(message = "El nombre de la categoría no puede estar vacío")
    private String name;

    // Para simplificar, podríamos mostrar la lista de productos
    // como DTOs o simplemente listar sus IDs. Aquí mostramos los productos como DTO.
    private List<ProductDTO> products = new ArrayList<>();

    public CategoryDTO() {
    }

    public CategoryDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getters & Setters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ProductDTO> getProducts() {
        return products;
    }

    public void setProducts(List<ProductDTO> products) {
        this.products = products;
    }
}
