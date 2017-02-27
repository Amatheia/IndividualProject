package com.producttracker.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * A class to represent a user.
 *
 * @author amatheia
 */

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name = "user_id")
    private int userid;

    @Column(name = "role_name")
    private String role;

    @Column(name = "first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="username")
    private String username;

    @Column(name="password")
    private String password;

    @Column(name="view_inventory")
    private byte viewInventory;

    @Column(name="add_product")
    private byte addProduct;

    @Column(name="update_product")
    private byte updateProduct;

    @Column(name="delete_product")
    private byte deleteProduct;

    @Column(name="add_user")
    private byte addUser;

    @Column(name="date_added")
    private java.sql.Date dateAdded;

    /**
     * Instantiates a new User.
     */
    public User() {
    }

    /**
     * Instantiates a new User.
     *
     * @param userid      the userid
     * @param role   the role or title
     * @param firstName   the first name
     * @param lastName    the last name
     * @param username    the username
     * @param password    the password
     * @param viewInventory    the viewInventory
     * @param addProduct    the addProduct
     * @param updateProduct    the updateProduct
     * @param deleteProduct    the deleteProduct
     * @param addUser    the addUser
     * @param dateAdded    the dateAdded
     */
    public User(int userid, String role, String firstName, String lastName,
                String username, String password, byte viewInventory, byte addProduct,
                byte updateProduct, byte deleteProduct, byte addUser, java.sql.Date dateAdded) {
        this.userid = userid;
        this.role = role;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.viewInventory = viewInventory;
        this.addProduct = addProduct;
        this.updateProduct = updateProduct;
        this.deleteProduct = deleteProduct;
        this.addUser = addUser;
        this.dateAdded = dateAdded;
    }

    /**
     * Gets userid.
     *
     * @return the userid
     */
    public int getUserid() {
        return userid;
    }

    /**
     * Sets userid.
     *
     * @param userid the userid
     */
    public void setUserid(int userid) {
        this.userid = userid;
    }

    /**
     * Gets role.
     *
     * @return the role
     */
    public String getRole() {
        return role;
    }

    /**
     * Sets role.
     *
     * @param role the role
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * Gets first name.
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets first name.
     *
     * @param firstName the first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets last name.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets last name.
     *
     * @param lastName the last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets username.
     *
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets username.
     *
     * @param username the username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets password.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets password.
     *
     * @param password the password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets viewInventory.
     *
     * @return the viewInventory
     */
    public byte getViewInventory() {
        return viewInventory;
    }

    /**
     * Sets viewInventory.
     *
     * @param viewInventory the viewInventory
     */
    public void setViewInventory(byte viewInventory) {
        this.viewInventory = viewInventory;
    }

    /**
     * Gets addProduct.
     *
     * @return the addProduct
     */
    public byte getAddProduct() {
        return addProduct;
    }

    /**
     * Sets addProduct.
     *
     * @param addProduct the addProduct
     */
    public void setAddProduct(byte addProduct) {
        this.addProduct = addProduct;
    }

    /**
     * Gets updateProduct.
     *
     * @return the updateProduct
     */
    public byte getUpdateProduct() {
        return updateProduct;
    }

    /**
     * Sets updateProduct.
     *
     * @param updateProduct the updateProduct
     */
    public void setUpdateProduct(byte updateProduct) {
        this.updateProduct = updateProduct;
    }

    /**
     * Gets deleteProduct.
     *
     * @return the deleteProduct
     */
    public byte getDeleteProduct() {
        return deleteProduct;
    }

    /**
     * Sets deleteProduct.
     *
     * @param deleteProduct the deleteProduct
     */
    public void setDeleteProduct(byte deleteProduct) {
        this.deleteProduct = deleteProduct;
    }

    /**
     * Gets addUser.
     *
     * @return the addUser
     */
    public byte getAddUser() {
        return addUser;
    }

    /**
     * Sets addUser.
     *
     * @param addUser the addUser
     */
    public void setAddUser(byte addUser) {
        this.addUser = addUser;
    }

    /**
     * Gets dateAdded.
     *
     * @return the dateAdded
     */
    public java.sql.Date getDateAdded() {
        return dateAdded;
    }

    /**
     * Sets dateAdded.
     *
     * @param dateAdded the dateAdded
     */
    public void setDateAdded(java.sql.Date dateAdded) {
        this.dateAdded = dateAdded;
    }

}