package entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Id;

@Entity (name = "items")
@Data
@NoArgsConstructor
public class Items {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column (name = "name")
    private String name;

    @Column (name = "description")
    private String description;

    @Column (name = "gty_in_stock")
    private int qty;

    @Column (name = "price")
    private float price;

    public Items(int id, String name, String description, int qty, float price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.qty = qty;
        this.price = price;
    }
}
