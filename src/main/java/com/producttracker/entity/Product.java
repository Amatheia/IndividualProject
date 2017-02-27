package com.producttracker.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * A class to represent a product.
 *
 * @author amatheia
 */

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name = "product_id")
    private int productId;

    @Column(name="add_date")
    private java.sql.Date addDate;

    @Column(name = "category_name")
    private String categoryName;

    @Column(name="vendor_name")
    private String vendorName;

    @Column(name="product_name")
    private String productName;

    @Column(name = "quantity_ordered")
    private int quantityOrdered;

    @Column(name = "weight")
    private int weight;

    @Column(name = "per_unit_cost")
    private BigDecimal perUnitCost;

    @Column(name = "total_cost")
    private BigDecimal totalCost;

    @Column(name="order_date")
    private java.sql.Date orderDate;

    @Column(name="date_received")
    private java.sql.Date dateReceived;

    @Column(name = "quantity_received")
    private Integer quantityReceived;

    @Column(name = "paid_not_received")
    private Integer paidNotReceived;

    @Column(name = "current_quantity")
    private Integer currentQuantity;

    @Column(name = "current_value")
    private BigDecimal currentValue;

    @Column(name="expiration_date")
    private java.sql.Date expirationDate;

    @Column(name="notes")
    private String notes;

    @Column(name="active")
    private byte active;

    /**
     * Instantiates a new Product.
     */
    public Product() {
    }

    /**
     * Instantiates a new Product.
     *
     * @param productId     the productId
     * @param addDate   the addDate
     * @param categoryName   the category name
     * @param vendorName    the vendor name
     * @param productName    the product name
     * @param quantityOrdered    the quantityOrdered
     * @param weight    the weight
     * @param perUnitCost    the perUnitCost
     * @param totalCost    the totalCost
     * @param orderDate    the orderDate
     * @param dateReceived   the dateReceived
     * @param quantityReceived   the quantityReceived
     * @param paidNotReceived   the paidNotReceived
     * @param currentQuantity  the currentQuantity
     * @param currentValue  the currentValue
     * @param expirationDate  the expirationDate
     * @param notes  the notes
     * @param active  the active
     */
    public Product(int productId, java.sql.Date addDate, String categoryName,
                String vendorName, String productName, int quantityOrdered,
                int weight, BigDecimal perUnitCost, BigDecimal totalCost,
                java.sql.Date orderDate, java.sql.Date dateReceived,
                   Integer quantityReceived, Integer paidNotReceived, Integer currentQuantity,
                BigDecimal currentValue, java.sql.Date expirationDate,
                String notes, byte active) {
        this.productId = productId;
        this.addDate = addDate;
        this.categoryName = categoryName;
        this.vendorName = vendorName;
        this.productName = productName;
        this.quantityOrdered = quantityOrdered;
        this.weight = weight;
        this.perUnitCost = perUnitCost;
        this.totalCost = totalCost;
        this.orderDate = orderDate;
        this.dateReceived = dateReceived;
        this.quantityReceived = quantityReceived;
        this.paidNotReceived = paidNotReceived;
        this.currentQuantity = currentQuantity;
        this.currentValue = currentValue;
        this.expirationDate = expirationDate;
        this.notes = notes;
        this.active = active;
    }

    /**
     * Gets productId.
     *
     * @return the productId
     */
    public int getProductId() {
        return productId;
    }

    /**
     * Sets productId.
     *
     * @param productId the productId
     */
    public void setProductId(int productId) {
        this.productId = productId;
    }

    /**
     * Gets addDate.
     *
     * @return the addDate
     */
    public java.sql.Date getAddDate() {
        return addDate;
    }

    /**
     * Sets addDate.
     *
     * @param addDate the dateAdded
     */
    public void setAddDate(java.sql.Date addDate) {
        this.addDate = addDate;
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
     * Gets vendorName.
     *
     * @return the vendorName
     */
    public String getVendorName() {
        return vendorName;
    }

    /**
     * Sets vendorName.
     *
     * @param vendorName the vendorName
     */
    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    /**
     * Gets productName.
     *
     * @return the productName
     */
    public String getProductName() {
        return productName;
    }

    /**
     * Sets productName.
     *
     * @param productName the productName
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * Gets quantityOrdered.
     *
     * @return the quantityOrdered
     */
    public int getQuantityOrdered() {
        return quantityOrdered;
    }

    /**
     * Sets quantityOrdered.
     *
     * @param quantityOrdered the quantityOrdered
     */
    public void setQuantityOrdered(int quantityOrdered) {
        this.quantityOrdered = quantityOrdered;
    }

    /**
     * Gets weight.
     *
     * @return the weight
     */
    public int getWeight() {
        return weight;
    }

    /**
     * Sets weight.
     *
     * @param weight the weight
     */
    public void setWeight(int weight) {
        this.weight = weight;
    }

    /**
     * Gets perUnitCost.
     *
     * @return the perUnitCost
     */
    public BigDecimal getPerUnitCost() {
        return perUnitCost;
    }

    /**
     * Sets perUnitCost.
     *
     * @param perUnitCost the perUnitCost
     */
    public void setPerUnitCost(BigDecimal perUnitCost) {
        this.perUnitCost = perUnitCost;
    }

    /**
     * Gets totalCost.
     *
     * @return the totalCost
     */
    public BigDecimal getTotalCost() {
        return totalCost;
    }

    /**
     * Sets totalCost.
     *
     * @param totalCost the totalCost
     */
    public void setTotalCost(BigDecimal totalCost) {
        this.totalCost = totalCost;
    }

    /**
     * Gets orderDate.
     *
     * @return the orderDate
     */
    public java.sql.Date getOrderDate() {
        return orderDate;
    }

    /**
     * Sets orderDate.
     *
     * @param orderDate the orderDate
     */
    public void setOrderDate(java.sql.Date orderDate) {
        this.orderDate = orderDate;
    }

    /**
     * Gets dateReceived.
     *
     * @return the dateReceived
     */
    public java.sql.Date getDateReceived() {
        return dateReceived;
    }

    /**
     * Sets dateReceived.
     *
     * @param dateReceived the dateReceived
     */
    public void setDateReceived(java.sql.Date dateReceived) {
        this.dateReceived = dateReceived;
    }

    /**
     * Gets quantityReceived.
     *
     * @return the quantityReceived
     */
    public Integer getQuantityReceived() {
        return quantityReceived;
    }

    /**
     * Sets quantityReceived.
     *
     * @param quantityReceived the quantityReceived
     */
    public void setQuantityReceived(Integer quantityReceived) {
        this.quantityReceived = quantityReceived;
    }

    /**
     * Gets paidNotReceived.
     *
     * @return the paidNotReceived
     */
    public Integer getPaidNotReceived() {
        return paidNotReceived;
    }

    /**
     * Sets paidNotReceived.
     *
     * @param paidNotReceived the paidNotReceived
     */
    public void setPaidNotReceived(Integer paidNotReceived) {
        this.paidNotReceived = paidNotReceived;
    }

    /**
     * Gets currentQuantity.
     *
     * @return the currentQuantity
     */
    public Integer getCurrentQuantity() {
        return currentQuantity;
    }

    /**
     * Sets currentQuantity.
     *
     * @param currentQuantity the currentQuantity
     */
    public void setCurrentQuantity(Integer currentQuantity) {
        this.currentQuantity = currentQuantity;
    }

    /**
     * Gets currentValue.
     *
     * @return the currentValue
     */
    public BigDecimal getCurrentValue() {
        return currentValue;
    }

    /**
     * Sets currentValue.
     *
     * @param currentValue the currentValue
     */
    public void setCurrentValue(BigDecimal currentValue) {
        this.currentValue = currentValue;
    }

    /**
     * Gets expirationDate.
     *
     * @return the expirationDate
     */
    public java.sql.Date getExpirationDate() {
        return expirationDate;
    }

    /**
     * Sets expirationDate.
     *
     * @param expirationDate the expirationDate
     */
    public void setExpirationDate(java.sql.Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    /**
     * Gets notes.
     *
     * @return the notes
     */
    public String getNotes() {
        return notes;
    }

    /**
     * Sets notes.
     *
     * @param notes the notes
     */
    public void setNotes(String notes) {
        this.notes = notes;
    }

    /**
     * Gets active.
     *
     * @return the active
     */
    public byte getActive() {
        return active;
    }

    /**
     * Sets active.
     *
     * @param active the active
     */
    public void setActive(byte active) {
        this.active = active;
    }

}
