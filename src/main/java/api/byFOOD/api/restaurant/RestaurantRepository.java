package api.byFOOD.api.restaurant;

import org.springframework.data.jpa.repository.JpaRepository;
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
}
