package entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "sale_id")
    private Sale saleId;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Items itemsId;

    @Column(name = "qty_purchased")
    private int qty;

    @Column(name = "item_total")
    private int total;

}
