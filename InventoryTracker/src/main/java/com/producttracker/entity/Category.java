package com.producttracker.entity;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * A class to represent a category.
 *
 * @author amatheia
 */

@Entity (name = "categories")
public class Category {

    private int categoryId;

    private String categoryName;

    private String description;

    private Set<Product> products = new HashSet<Product>(0);

    /**
     * Instantiates a new Category.
     */
    public Category() {
    }

    /**
     * Instantiates a new Product.
     *
     * @param categoryId    the category id
     * @param categoryName   the category name
     * @param description    the description
     */
    public Category(int categoryId, String categoryName, String description) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.description = description;
    }

    /**
     * Gets categoryId.
     *
     * @return the categoryId
     */
    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name="category_id")
    public int getCategoryId() {
        return categoryId;
    }

    /**
     * Sets categoryId.
     *
     * @param categoryId the categoryId
     */
    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * Gets categoryName.
     *
     * @return the categoryName
     */
    @Column(name = "category_name", unique = true)
    public String getCategoryName() {
        return categoryName;
    }

    /**
     * Sets categoryName.
     *
     * @param categoryName the last name
     */
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    /**
     * Gets description.
     *
     * @return the description
     */
    @Column(name="description")
    public String getDescription() {
        return description;
    }

    /**
     * Sets description.
     *
     * @param description the description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
    @Cascade(value= {org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.DELETE})
    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "{" +
                "categoryId=" + categoryId +
                ", categoryName=" + categoryName +
                ", description=" + description +
                '}';
    }

}



