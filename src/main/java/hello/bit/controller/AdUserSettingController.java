package hello.bit.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping( "/admin" )
public class AdUserSettingController{

    private final Logger logger = Logger.getLogger( AdUserSettingController.class );


    @GetMapping("/")
}
