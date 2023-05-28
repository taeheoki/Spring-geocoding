package shop.taeheoki.geocoding.dto;

import lombok.Getter;
import shop.taeheoki.geocoding.model.Member;

public class GeoResponse {

    @Getter
    public static class GeoOutDto {
        private Long id;
        private String name;
        private String location;

        private String lat;
        private String lng;

        public GeoOutDto(Member member) {
            this.id = member.getId();
            this.name = member.getName();
            this.location = member.getLocation();
            this.lat = member.getLat();
            this.lng = member.getLng();
        }
    }
}
