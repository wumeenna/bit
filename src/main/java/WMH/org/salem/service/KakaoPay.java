package WMH.org.salem.service;

import java.net.URI;
import java.net.URISyntaxException;

import WMH.org.salem.domain.KakaoPayApprovalVO;
import WMH.org.salem.domain.KakaoPayReadyVO;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import lombok.extern.java.Log;

@Service
@Log
public class KakaoPay{

    private static final String HOST = "https://kapi.kakao.com";

    private KakaoPayReadyVO kakaoPayReadyVO;
    private KakaoPayApprovalVO kakaoPayApprovalVO;

    public String kakaoPayReady(){

        RestTemplate restTemplate = new RestTemplate();

        // 서버로 요청할 Header
        HttpHeaders headers = new HttpHeaders();
        headers.add( "Authorization" , "KakaoAK " + "7e123a34d66dbbc30d79c3c4a60ea3ed" );
        headers.add( "Accept" , MediaType.APPLICATION_JSON_UTF8_VALUE );
        headers.add( "Content-Type" , MediaType.APPLICATION_FORM_URLENCODED_VALUE + ";charset=UTF-8" );

        // 서버로 요청할 Body
        MultiValueMap< String, String > params = new LinkedMultiValueMap< String, String >();
        // 가맹점 코드
        params.add( "cid" , "TC0ONETIME" );
        // 가맹점 주문번호
        params.add( "partner_order_id" , "1001" );
        // 가맹점 회원아이디
        params.add( "partner_user_id" , "gorany" );
        // 상품명
        params.add( "item_name" , "갤럭시S9" );
        // 수량
        params.add( "quantity" , "1" );
        // 상품 총액
        params.add( "total_amount" , "2100" );
        // 상품 비과세 금액
        params.add( "tax_free_amount" , "100" );
        // 결제 성공시 URL
        params.add( "approval_url" , "http://localhost:8080/kakaoPaySuccess" );
        // 결제 취소시 URL
        params.add( "cancel_url" , "http://localhost:8080/kakaoPayCancel" );
        // 결제 실패시 URL
        params.add( "fail_url" , "http://localhost:8080/kakaoPaySuccessFail" );

        HttpEntity< MultiValueMap< String, String > > body = new HttpEntity< MultiValueMap< String, String > >( params , headers );

        try {
            kakaoPayReadyVO = restTemplate.postForObject( new URI( HOST + "/v1/payment/ready" ) , body , KakaoPayReadyVO.class );

            log.info( "" + kakaoPayReadyVO );

            return kakaoPayReadyVO.getNext_redirect_pc_url();

        } catch ( RestClientException e ) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch ( URISyntaxException e ) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return "/pay";

    }

    public KakaoPayApprovalVO kakaoPayInfo( String pg_token ){

        log.info( "KakaoPayInfoVO............................................" );
        log.info( "-----------------------------" );

        RestTemplate restTemplate = new RestTemplate();

        // 서버로 요청할 Header
        HttpHeaders headers = new HttpHeaders();
        headers.add( "Authorization" , "KakaoAK " + "admin key를 넣어주세요~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~!" );
        headers.add( "Accept" , MediaType.APPLICATION_JSON_UTF8_VALUE );
        headers.add( "Content-Type" , MediaType.APPLICATION_FORM_URLENCODED_VALUE + ";charset=UTF-8" );

        // 서버로 요청할 Body
        MultiValueMap< String, String > params = new LinkedMultiValueMap< String, String >();
        params.add( "cid" , "TC0ONETIME" );
        params.add( "tid" , kakaoPayReadyVO.getTid() );
        params.add( "partner_order_id" , "1001" );
        params.add( "partner_user_id" , "gorany" );
        params.add( "pg_token" , pg_token );
        params.add( "total_amount" , "2100" );

        HttpEntity< MultiValueMap< String, String > > body = new HttpEntity< MultiValueMap< String, String > >( params , headers );

        try {
            kakaoPayApprovalVO = restTemplate.postForObject( new URI( HOST + "/v1/payment/approve" ) , body , KakaoPayApprovalVO.class );
            log.info( "" + kakaoPayApprovalVO );

            return kakaoPayApprovalVO;

        } catch ( RestClientException e ) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch ( URISyntaxException e ) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return null;
    }

}