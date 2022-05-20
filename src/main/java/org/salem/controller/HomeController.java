package org.salem.controller;

import com.siot.IamportRestClient.IamportClient;
import com.siot.IamportRestClient.exception.IamportResponseException;
import com.siot.IamportRestClient.response.IamportResponse;
import com.siot.IamportRestClient.response.Payment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Locale;

@Controller
public class HomeController{

    private final IamportClient api;

    public HomeController(){
        // REST API 키와 REST API secret 를 아래처럼 순서대로 입력한다.
        this.api = new IamportClient( "7039868567336915" ,
                                     "4c6dc76cb4a4d9ab99894cae059100e7a992e14a4e1d8ed164c3f5599af91804e1e33d64e310dc67" );
    }

    @ResponseBody
    @RequestMapping( value = "/verifyIamport/{imp_uid}" )
    public IamportResponse< Payment > paymentByImpUid( Model model ,
                                                       Locale locale ,
                                                       HttpSession session ,
                                                       @PathVariable( value = "imp_uid" ) String imp_uid
                                                     ) throws IamportResponseException, IOException{
        return api.paymentByImpUid( imp_uid );
    }

}
