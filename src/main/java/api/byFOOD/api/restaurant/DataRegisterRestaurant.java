package api.byFOOD.api.restaurant;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
@Valid
public record DataRegisterRestaurant(
        @NotBlank
        String name,
        @NotNull
        int customer_rating,
        @NotNull
        int distance,
        @NotNull
        int price,
        @NotNull
        int cuisine_id ) {
}

