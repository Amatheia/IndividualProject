package com.producttracker.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.producttracker.util.LocalDateAttributeConverter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

/**
 * A class to represent a product.
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
@Entity (name = "products")
public class Product {

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name = "product_id")
    private int productId;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="add_date", insertable=false, updatable=false)
    private Date addDate;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false, insertable = true, updatable = true)
    private Category category;

    @ManyToOne
    @JoinColumn(name = "vendor_id", nullable = false, insertable = true, updatable = true)
    private Vendor vendor;

    @Column(name="product_name", unique = true)
    private String productName;

    @Column(name = "quantity_ordered")
    private int quantityOrdered;

    @Column(name = "weight")
    private BigDecimal weight;

    @Column(name = "per_unit_cost")
    private BigDecimal perUnitCost;

    @Column(name = "total_cost")
    private BigDecimal totalCost;

    @Column(name="order_date")
    @Convert(converter = LocalDateAttributeConverter.class)
    private LocalDate orderDate;

    @Column(name = "date_received")
    @Convert(converter = LocalDateAttributeConverter.class)
    private LocalDate dateReceived;

    @Column(name = "quantity_received")
    private Integer quantityReceived;

    @Column(name = "paid_not_received")
    private Integer paidNotReceived;

    @Column(name = "current_quantity")
    private Integer currentQuantity;

    @Column(name = "current_value")
    private BigDecimal currentValue;

    @Column(name="expiration")
    private String expiration;

    @Column(name="notes")
    private String notes;

    @JsonIgnore
    @Column(name="active")
    private boolean active;

    /**
     * Instantiates a new Product.
     */
    public Product() {
    }

    /**
     * Instantiates a new Product.
     *
     * @param productId     the product id
     * @param addDate   the add date
     * @param category   the category id
     * @param vendor    the vendor id
     * @param productName    the product name
     * @param quantityOrdered    the quantity ordered
     * @param weight    the weight
     * @param perUnitCost    the per unit cost
     * @param totalCost    the total cost
     * @param orderDate    the order date
     * @param dateReceived   the date received
     * @param quantityReceived   the quantity received
     * @param paidNotReceived   the quantity of paid for but not received
     * @param currentQuantity  the current quantity
     * @param currentValue  the current value
     * @param expiration  the expiration
     * @param notes  the notes
     * @param active    active boolean
     */
    public Product(int productId, Date addDate, Category category,
                   Vendor vendor, String productName, int quantityOrdered,
                   BigDecimal weight, BigDecimal perUnitCost, BigDecimal totalCost,
                   LocalDate orderDate, LocalDate dateReceived,
                   Integer quantityReceived, Integer paidNotReceived,
                   Integer currentQuantity, BigDecimal currentValue, String expiration,
                   String notes, boolean active) {
        this.productId = productId;
        this.addDate = addDate;
        this.category = category;
        this.vendor = vendor;
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
        this.expiration = expiration;
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
    public Date getAddDate() {
        return addDate;
    }

    /**
     * Gets category.
     *
     * @return the category
     */
    public Category getCategory() {
        return this.category;
    }

    /**
     * Sets category.
     *
     * @param category the category
     */
    public void setCategory(Category category) {
        this.category = category;
    }

    /**
     * Gets vendor.
     *
     * @return the vendor
     */
    public Vendor getVendor() {
        return this.vendor;
    }

    /**
     * Sets vendor.
     *
     * @param vendor the vendor
     */
    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
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
    public BigDecimal getWeight() {
        return weight;
    }

    /**
     * Sets weight.
     *
     * @param weight the weight
     */
    public void setWeight(BigDecimal weight) {
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
    public LocalDate getOrderDate() {
        return orderDate;
    }

    /**
     * Sets orderDate.
     *
     * @param orderDate the orderDate
     */
    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    /**
     * Gets dateReceived.
     *
     * @return the dateReceived
     */
    public LocalDate getDateReceived() {
        return dateReceived;
    }

    /**
     * Sets dateReceived.
     *
     * @param dateReceived the dateReceived
     */
    public void setDateReceived(LocalDate dateReceived) {
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
     * Gets expiration.
     *
     * @return the expiration
     */
    public String getExpiration() {
        return expiration;
    }

    /**
     * Sets expiration.
     *
     * @param expiration the expiration
     */
    public void setExpiration(String expiration) {
        this.expiration = expiration;
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
     * @return the active boolean
     */
    @JsonIgnore
    public boolean getActive() {
        return active;
    }

    /**
     * Sets active.
     *
     *@param active the active boolean
     */
    @JsonIgnore
    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "{" +
                "productId=" + productId +
                ", addDate=" + addDate +
                ", category=" + category +
                ", vendor=" + vendor +
                ", productName=" + productName +
                ", quantityOrdered=" + quantityOrdered +
                ", weight=" + weight +
                ", perUnitCost=" + perUnitCost +
                ", totalCost=" + totalCost +
                ", orderDate=" + orderDate +
                ", dateReceived=" + dateReceived +
                ", quantityReceived=" + quantityReceived +
                ", paidNotReceived=" + paidNotReceived +
                ", currentQuantity=" + currentQuantity +
                ", currentValue=" + currentValue +
                ", expiration=" + expiration +
                ", notes=" + notes +
                '}';
    }
}
