package com.producttracker.entity;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;

/**
 * A class to represent a category.
 *
 * The Food Inventory Tracker program outputs an inventory management web application
 * for internal use by a restaurant. It implements a food expiration web service to get
 * a food expiration duration. User roles are in place. Registered users are able to add tasks,
 * update the current quantity of a product, and view products, categories, and vendors.
 * Only admin are allowed to completely update a product; add/delete products, categories,
 * and vendors. Only admin may view/update/delete the users list. A registered user may request
 * admin privileges by filling out the contact form.
 *
 * @author amatheia
 * @version 1.0
 * @since 2017-05-10
 */
@Entity (name = "categories")
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

    @Override
    public String toString() {
        return "{" +
                "categoryId=" + categoryId +
                ", categoryName=" + categoryName +
                ", description=" + description +
                '}';
    }

}



