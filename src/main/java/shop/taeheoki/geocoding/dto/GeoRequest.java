package shop.taeheoki.geocoding.dto;

import lombok.Getter;

public class GeoRequest {

    @Getter
    public static class GeoInDto {
        private String name;
        private String location;
    }
}
