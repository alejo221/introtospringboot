package com.springlearning.intro.entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
/**
 * Representa una categoría de productos.
 */
@Entity
@Table(name = "categories") // Nombre de la tabla en la base de datos
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(name = "name", length = 100, nullable = false)
    private String name;

    /**
     * Una categoría puede tener varios productos.
     * "mappedBy" hace referencia al atributo "category" en la entidad Product.
     * CascadeType.ALL implica que, si se elimina o actualiza la categoría,
     * los cambios se aplican también a los productos.
     * orphanRemoval = true elimina de la base de datos cualquier
     * producto que sea eliminado de la lista 'products'.
     */
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Product> products = new ArrayList<>();

    // Constructores
    public Category() {
    }

    public Category(String name) {
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

    public List<Product> getProducts() {
        return products;
    }

    /**
     * Método de conveniencia para agregar un producto a la categoría.
     */
    public void addProduct(Product product) {
        products.add(product);
        product.setCategory(this);
    }

    /**
     * Método de conveniencia para remover un producto de la categoría.
     */
    public void removeProduct(Product product) {
        products.remove(product);
        product.setCategory(null);
    }
}
