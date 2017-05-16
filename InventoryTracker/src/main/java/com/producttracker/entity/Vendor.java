package com.producttracker.entity;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;

/**
 * A class to represent a vendor.
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
@Entity (name = "vendors")
public class Vendor {

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name="vendor_id")
    private int vendorId;

    @Column(name = "vendor_name")
    private String vendorName;

    @Column(name="contact_name")
    private String contactName;

    @Column(name="address")
    private String address;

    @Column(name="city")
    private String city;

    @Column(name="state_province")
    private String stateProvince;

    @Column(name="postal_code")
    private String postalCode;

    @Column(name="phone")
    private String phone;

    /**
     * Instantiates a new Vendor.
     */
    public Vendor() {
    }

    /**
     * Instantiates a new Vendor.
     *
     * @param vendorId  the vendor id
     * @param vendorName    the vendor name
     * @param contactName    the contact name
     * @param address    the address
     * @param city    the city
     * @param stateProvince    the state or province
     * @param postalCode    the postal code
     * @param phone    the phone number
     */
    public Vendor(int vendorId, String vendorName, String contactName, String address,
                    String city, String stateProvince, String postalCode,
                    String phone) {
        this.vendorId = vendorId;
        this.vendorName = vendorName;
        this.contactName = contactName;
        this.address = address;
        this.city = city;
        this.stateProvince = stateProvince;
        this.postalCode = postalCode;
        this.phone = phone;
    }

    /**
     * Gets vendorId.
     *
     * @return the vendorId
     */
    public int getVendorId() {
        return vendorId;
    }

    /**
     * Sets vendorId.
     *
     * @param vendorId the vendorId
     */
    public void setVendorId(int vendorId) {
        this.vendorId = vendorId;
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
     * Gets contactName.
     *
     * @return the contactName
     */
    public String getContactName() {
        return contactName;
    }

    /**
     * Sets contactName.
     *
     * @param contactName the contactName
     */
    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    /**
     * Gets address.
     *
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets contactName.
     *
     * @param address the address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Gets city.
     *
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets city.
     *
     * @param city the city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Gets stateProvince.
     *
     * @return the stateProvince
     */
    public String getStateProvince() {
        return stateProvince;
    }

    /**
     * Sets stateProvince.
     *
     * @param stateProvince the stateProvince
     */
    public void setStateProvince(String stateProvince) {
        this.stateProvince = stateProvince;
    }

    /**
     * Gets postalCode.
     *
     * @return the postalCode
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * Sets postalCode.
     *
     * @param postalCode the postalCode
     */
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    /**
     * Gets phone.
     *
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Sets phone.
     *
     * @param phone the phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "{" +
                "vendorId=" + vendorId +
                ", vendorName=" + vendorName +
                ", contactName=" + contactName +
                ", address=" + address +
                ", city=" + city +
                ", stateProvince=" + stateProvince +
                ", postalCode=" + postalCode +
                ", phone=" + phone +
                '}';
    }

}
