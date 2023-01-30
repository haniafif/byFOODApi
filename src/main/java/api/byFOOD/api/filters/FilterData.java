package api.byFOOD.api.filters;




public record FilterData(
        String nameToMatch,

        int customer_rating_wanted,

        int distance_wanted,

        int price_wanted,

        int cuisine_id_wanted ) {
}
