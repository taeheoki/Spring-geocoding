package shop.taeheoki.geocoding.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shop.taeheoki.geocoding.core.util.CommonUtil;
import shop.taeheoki.geocoding.dto.GeoRequest;
import shop.taeheoki.geocoding.dto.GeoResponse;
import shop.taeheoki.geocoding.dto.KakaoAddress;
import shop.taeheoki.geocoding.model.Member;
import shop.taeheoki.geocoding.model.MemberRepository;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class GeocodingService {

    private final String URL = "https://dapi.kakao.com/v2/local/search/address.json";

    private final MemberRepository memberRepository;

    @Transactional
    public GeoResponse.GeoOutDto findGeoPoint(GeoRequest.GeoInDto geoInDto) {
        Member member = new Member();
        member.setName(geoInDto.getName());
        member.setLocation(geoInDto.getLocation());
        KakaoAddress kakaoAddress = CommonUtil.kakaoSearchAddress(URL, HttpMethod.GET, geoInDto.getLocation());
        member.setLat(kakaoAddress.getDocuments().get(0).getX());
        member.setLng(kakaoAddress.getDocuments().get(0).getY());
        memberRepository.save(member);
        return new GeoResponse.GeoOutDto(member);
    }
}
