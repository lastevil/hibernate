package app.javaspring.com.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "products")
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "title")
    private String title;
    @Column(name = "price")
    private Integer price;

    public Product(String title, Integer price){
        this.title=title;
        this.price=price;
    }

    public Product() {
    }
}
