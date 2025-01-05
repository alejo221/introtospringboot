package com.springlearning.intro.entity;

import jakarta.persistence.*;

/**
 * Representa un producto que pertenece a una categoría.
 */
@Entity
@Table(name = "products") // Nombre de la tabla en la base de datos
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    /**
     * Uso de @Column para definir propiedades de la columna,
     * como el nombre, longitud y si permite nulos.
     */
    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @Column(name = "price", nullable = false)
    private Double price;

    /**
     * Muchos productos pueden pertenecer a una sola categoría.
     * "category_id" será la llave foránea en la tabla "products".
     */
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    // Constructores
    public Product() {
    }

    public Product(String name, Double price, Category category) {
        this.name = name;
        this.price = price;
        this.category = category;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
