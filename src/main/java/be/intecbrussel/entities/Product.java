package be.intecbrussel.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Product {

    @Id
    private String productCode;
    private String productName;
    private String productLines;
    private String productScale;
    private String productVendor;
    private String productDescription;
    private int quantityInStock;
    private double buyPrice;
    private double MSRP;

    public Product() {
    }

    public Product(String productCode, String productName, String productLines, String productScale, String productVendor, String productDescription, int quantityInStock, double buyPrice, double MSRP) {
        this.productCode = productCode;
        this.productName = productName;
        this.productLines = productLines;
        this.productScale = productScale;
        this.productVendor = productVendor;
        this.productDescription = productDescription;
        this.quantityInStock = quantityInStock;
        this.buyPrice = buyPrice;
        this.MSRP = MSRP;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductLines(String productLines) {
        this.productLines = productLines;
    }

    public void setProductScale(String productScale) {
        this.productScale = productScale;
    }

    public void setProductVendor(String productVendor) {
        this.productVendor = productVendor;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public void setBuyPrice(double buyPrice) {
        this.buyPrice = buyPrice;
    }

    public void setMSRP(double MSRP) {
        this.MSRP = MSRP;
    }

    @Id
    public String getProductCode() {
        return productCode;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductLines() {
        return productLines;
    }

    public String getProductScale() {
        return productScale;
    }

    public String getProductVendor() {
        return productVendor;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public long getQuantityInStock() {
        return quantityInStock;
    }

    public double getBuyPrice() {
        return buyPrice;
    }

    public double getMSRP() {
        return MSRP;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product products = (Product) o;
        return quantityInStock == products.quantityInStock &&
                Double.compare(products.buyPrice, buyPrice) == 0 &&
                Double.compare(products.MSRP, MSRP) == 0 &&
                Objects.equals(productCode, products.productCode) &&
                Objects.equals(productName, products.productName) &&
                Objects.equals(productLines, products.productLines) &&
                Objects.equals(productScale, products.productScale) &&
                Objects.equals(productVendor, products.productVendor) &&
                Objects.equals(productDescription, products.productDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productCode, productName, productLines, productScale, productVendor, productDescription, quantityInStock, buyPrice, MSRP);
    }

    @Override
    public String toString() {
        return "products{" +
                "productCode='" + productCode + '\'' +
                ", productName='" + productName + '\'' +
                ", productLines=" + productLines +
                ", productScale='" + productScale + '\'' +
                ", productVendor='" + productVendor + '\'' +
                ", productDescription='" + productDescription + '\'' +
                ", quantityInStock=" + quantityInStock +
                ", buyPrice=" + buyPrice +
                ", MSRP=" + MSRP +
                '}';
    }
}
