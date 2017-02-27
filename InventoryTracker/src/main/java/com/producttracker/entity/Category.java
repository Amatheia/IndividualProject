package com.producttracker.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * A class to represent a category.
 *
 * @author amatheia
 */

@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "category_name", unique = true)
    private String categoryName;

    @Column(name="description")
    private String description;

    /**
     * Instantiates a new Category.
     */
    public Category() {
    }

    /**
     * Instantiates a new Product.
     *
     * @param categoryName   the category name
     * @param description    the description
     */
    public Category(String categoryName, String description) {
        this.categoryName = categoryName;
        this.description = description;
    }

    /**
     * Gets categoryName.
     *
     * @return the categoryName
     */
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
}



