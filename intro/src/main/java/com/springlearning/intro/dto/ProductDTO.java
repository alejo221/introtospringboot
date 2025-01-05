package com.springlearning.intro.dto;

/**
 * DTO para representar la información de Product
 * que se envía/recibe a través de la API.
 */
public class ProductDTO {

    private Long id;
    private String name;
    private Double price;

    // Para evitar recursividad infinita,
    // aquí podríamos solo exponer el ID de la categoría
    private Long categoryId;

    public ProductDTO() {
    }

    public ProductDTO(Long id, String name, Double price, Long categoryId) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.categoryId = categoryId;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public void setId(Long id) {
        this.id = id;
    }
}