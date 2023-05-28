package shop.taeheoki.geocoding.core.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import shop.taeheoki.geocoding.dto.KakaoAddress;
import shop.taeheoki.geocoding.exception.AddressTransformException;

import java.net.URI;

@Slf4j
@Component
public class CommonUtil {

    private static final String REST_API_KEY = "e571f745e1576acd207477273e7a8595";

    public static KakaoAddress kakaoSearchAddress(String url, HttpMethod method, String location) {
        RestTemplate rt = new RestTemplate();


        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "KakaoAK " + REST_API_KEY);

        URI endUri = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("query", location).build().encode().toUri();

        HttpEntity<?> httpEntity = new HttpEntity<>(headers);
        ResponseEntity<String> addressEntity = rt.exchange(endUri, method, httpEntity, String.class);

        KakaoAddress kakaoAddress;
        try {
            ObjectMapper om = new ObjectMapper();
            log.info("addressEntity={}", addressEntity.getBody());
            kakaoAddress = om.readValue(addressEntity.getBody(), KakaoAddress.class);
        } catch (JsonProcessingException e) {
            throw new AddressTransformException(e);
        }
        return kakaoAddress;
    }

}
