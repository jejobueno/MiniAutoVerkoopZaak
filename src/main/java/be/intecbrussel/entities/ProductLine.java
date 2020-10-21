package be.intecbrussel.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "productlines")
public class ProductLine {

    @Id
    private String productLine;
    private String textDescription;
    private String htmlDescription;
    private byte[] image;

    public ProductLine() {
    }

    public ProductLine(String productLine, String textDescription, String htmlDescription, byte[] image) {
        this.productLine = productLine;
        this.textDescription = textDescription;
        this.htmlDescription = htmlDescription;
        this.image = image;
    }

    public void setProductLine(String productLine) {
        this.productLine = productLine;
    }

    public void setTextDescription(String textDescription) {
        this.textDescription = textDescription;
    }

    public void setHtmlDescription(String htmlDescription) {
        this.htmlDescription = htmlDescription;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    @Id
    public String getProductLine() {
        return productLine;
    }

    public String getTextDescription() {
        return textDescription;
    }

    public String getHtmlDescription() {
        return htmlDescription;
    }

    public byte[] getImage() {
        return image;
    }

    @Override
    public String toString() {
        return "ProductLines{" +
                "productLine='" + productLine + '\'' +
                ", textDescription='" + textDescription + '\'' +
                ", htmlDescription=" + htmlDescription +
                ", image=" + image +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductLine that = (ProductLine) o;
        return Objects.equals(productLine, that.productLine) &&
                Objects.equals(textDescription, that.textDescription) &&
                Objects.equals(htmlDescription, that.htmlDescription) &&
                Objects.equals(image, that.image);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productLine, textDescription, htmlDescription, image);
    }
}
