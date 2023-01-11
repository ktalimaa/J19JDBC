package entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity(name = "sales")
@Data
@NoArgsConstructor
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    @JoinColumn (name = "customer_id")
    private Customer customer;

    @Column(name = "date_purchased")
    private Timestamp datePurchased;

    @Column(name = "total")
    private float total;

    public Sale(int id, int customerId, Timestamp datePurchased, float total) {
        this.id = id;
        this.customer.setId(customerId);
        this.datePurchased = datePurchased;
        this.total = total;
    }

}
