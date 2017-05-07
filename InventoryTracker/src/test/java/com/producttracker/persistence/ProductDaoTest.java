package com.producttracker.persistence;

import com.producttracker.entity.Category;
import com.producttracker.entity.Product;
import com.producttracker.entity.Vendor;
import org.junit.*;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by amatheia.
 */
public class ProductDaoTest {

    ProductDao dao;
    Product product;
    int newProduct = 0;

    private static CategoryDao categoryDao;
    private static Category category;
    private static int newCategory = 0;

    private static VendorDao vendorDao;
    private static Vendor vendor;
    private static int newVendor = 0;

    @BeforeClass
    public static void setUpClass() throws Exception {
        // sets up category and vendor

        categoryDao = new CategoryDao();
        category = new Category();
        category.setCategoryName("protein");
        category.setDescription("eggs");

        vendorDao = new VendorDao();
        vendor = new Vendor();
        vendor.setVendorName("Bryant Family Farms LLC");
        vendor.setContactName("Nico Bryant");
        vendor.setAddress("3102 Cty Road Y");
        vendor.setCity("Dodgeville");
        vendor.setStateProvince("WI");
        vendor.setPostalCode("53533");
        vendor.setPhone("847-293-9988");
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        // cleans up test category and vendor
        categoryDao.deleteCategory(newCategory);
        vendorDao.deleteVendor(newVendor);
    }

    @Before
    public void setUp() throws Exception {
        // sets up product
        dao = new ProductDao();
        product = new Product();
        product.setCategory(category);
        product.setVendor(vendor);
        product.setProductName("large brown eggs");
        product.setQuantityOrdered(20);
        product.setWeight(BigDecimal.valueOf(12.0001));
        product.setPerUnitCost(BigDecimal.valueOf(1.25));
    }

    @After
    public void tearDown() throws Exception {
        // cleans up test product
        if (newProduct != 0) {
            dao.deleteProduct(newProduct);
        }

    }

    @Test
    public void getAllProducts() throws Exception {
        newCategory = categoryDao.addCategory(category);
        newVendor = vendorDao.addVendor(vendor);
        newProduct = dao.addProduct(product);
        List<Product> products = dao.getAllProducts();
        assertTrue(products.size() > 0);
    }

    @Test
    public void getProduct() throws Exception {
        newCategory = categoryDao.addCategory(category);
        newVendor = vendorDao.addVendor(vendor);
        newProduct = dao.addProduct(product);
        assertNotNull("product not returned", dao.getProduct(newProduct));
        assertEquals("product ID not returned", product.getProductId(), dao.getProduct(newProduct).getProductId());
        assertEquals("category not returned", product.getCategory().getCategoryId(), dao.getProduct(newProduct).getCategory().getCategoryId());
        assertEquals("vendor not returned", product.getVendor().getVendorId(), dao.getProduct(newProduct).getVendor().getVendorId());
        assertEquals("product name not returned", product.getProductName(), dao.getProduct(newProduct).getProductName());
        assertEquals("quantity ordered not returned", product.getQuantityOrdered(), dao.getProduct(newProduct).getQuantityOrdered());
        assertEquals("weight not returned", product.getWeight(), dao.getProduct(newProduct).getWeight());
        assertEquals("per unit cost not returned", product.getPerUnitCost(), dao.getProduct(newProduct).getPerUnitCost());
    }

    @Test
    public void addProduct() throws Exception {
        newCategory = categoryDao.addCategory(category);
        newVendor = vendorDao.addVendor(vendor);
        newProduct = dao.addProduct(product);
        assertNotEquals("no category added", 0, newCategory);
        assertNotEquals("no vendor added", 0, newVendor);
        assertNotEquals("no product added", 0, newProduct);
        assertEquals("product ID not added", product.getProductId(), dao.getProduct(newProduct).getProductId());
        assertEquals("category not added", product.getCategory().getCategoryId(), dao.getProduct(newProduct).getCategory().getCategoryId());
        assertEquals("vendor not added", product.getVendor().getVendorId(), dao.getProduct(newProduct).getVendor().getVendorId());
        assertEquals("product name not added", product.getProductName(), dao.getProduct(newProduct).getProductName());
        assertEquals("quantity ordered not added", product.getQuantityOrdered(), dao.getProduct(newProduct).getQuantityOrdered());
        assertEquals("weight not added", product.getWeight(), dao.getProduct(newProduct).getWeight());
        assertEquals("per unit cost not added", product.getPerUnitCost(), dao.getProduct(newProduct).getPerUnitCost());
    }

    @Test
    public void deleteProduct() throws Exception {
        categoryDao.addCategory(category);
        vendorDao.addVendor(vendor);
        dao.addProduct(product);
        dao.deleteProduct(product.getProductId());
        assertNull("Failed to delete product", dao.getProduct(product.getProductId()));
    }

    @Test
    public void updateProduct() throws Exception {
        newCategory = categoryDao.addCategory(category);
        category.setCategoryName("meat");
        category.setDescription("pork products");

        newVendor = vendorDao.addVendor(vendor);
        vendor.setVendorName("Sugar River Farm");
        vendor.setContactName("Sugar River Farm");
        vendor.setAddress("W2726 Doyle Rd");
        vendor.setCity("Belleville");
        vendor.setStateProvince("WI");
        vendor.setPostalCode("53508");
        vendor.setPhone("608-469-0903");

        newProduct = dao.addProduct(product);
        product.setCategory(category);
        product.setVendor(vendor);
        product.setProductName("bacon");
        product.setQuantityOrdered(10);
        product.setWeight(BigDecimal.valueOf(5.0023));
        product.setPerUnitCost(BigDecimal.valueOf(1.83));

        dao.updateProduct(product);
        assertEquals("category change not made", product.getCategory().getCategoryId(), dao.getProduct(newProduct).getCategory().getCategoryId());
        assertEquals("vendor change not made", product.getVendor().getVendorId(), dao.getProduct(newProduct).getVendor().getVendorId());
        assertEquals("product name change not made", product.getProductName(), dao.getProduct(newProduct).getProductName());
        assertEquals("quantity ordered change not made", product.getQuantityOrdered(), dao.getProduct(newProduct).getQuantityOrdered());
        assertEquals("weight change not made", product.getWeight(), dao.getProduct(newProduct).getWeight());
        assertEquals("per unit cost change not made", product.getPerUnitCost(), dao.getProduct(newProduct).getPerUnitCost());
    }

}