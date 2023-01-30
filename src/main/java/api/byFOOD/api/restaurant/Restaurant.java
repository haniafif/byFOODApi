package api.byFOOD.api.restaurant;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name="restaurant")
@Entity(name="Restaurant")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Restaurant {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private int customer_rating;
    private int distance;
    private int price;
    private int cuisine_id;

    public Restaurant(DataRegisterRestaurant dados) {
        this.name = dados.name();
        this.customer_rating = dados.customer_rating();
        this.distance = dados.distance();
        this.cuisine_id = dados.cuisine_id();
    }
}
