package shop.taeheoki.geocoding.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import shop.taeheoki.geocoding.dto.GeoRequest;
import shop.taeheoki.geocoding.dto.GeoResponse;
import shop.taeheoki.geocoding.service.GeocodingService;

@Slf4j
@RestController
@RequiredArgsConstructor
public class GeocodingController {

    private final GeocodingService geocodingService;

    @PostMapping("/")
    public ResponseEntity<GeoResponse.GeoOutDto> transform(@RequestBody GeoRequest.GeoInDto geoInDTO) {
        GeoResponse.GeoOutDto geoOutDto = geocodingService.findGeoPoint(geoInDTO);
        log.info("id={}", geoOutDto.getId());
        log.info("name={}", geoOutDto.getName());
        log.info("location={}", geoOutDto.getLocation());
        log.info("lat={}", geoOutDto.getLat());
        log.info("lng={}", geoOutDto.getLng());
        return ResponseEntity.ok(geoOutDto);
    }
}
