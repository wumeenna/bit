package WMH.hello.bit.controller;

import WMH.hello.bit.domain.TestVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class LeafController{


    //@GetMapping
    public String home(){

        log.info( "Test" );
        return "/";
    }

    @GetMapping( "/thymeleaf/thymeleafTest" )
    public String thymeleafTest( Model model ){

        log.info( "thymeleafTest" );

        TestVO tModel = new TestVO( "12345" , "1234512345" );
        model.addAttribute( "tModel" , tModel );

        log.info( "tModel" + tModel );

        return "thymeleaf/thymeleafTest";

    }

}
