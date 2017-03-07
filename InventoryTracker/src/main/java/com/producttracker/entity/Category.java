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
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name="category_id")
    private int categoryId;

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



