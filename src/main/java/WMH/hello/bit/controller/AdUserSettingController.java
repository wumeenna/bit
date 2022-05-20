package WMH.hello.bit.controller;

import WMH.hello.bit.domain.AdPolicyVO;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping( "/admin" )
public class AdUserSettingController{

    private final Logger logger = Logger.getLogger( AdUserSettingController.class );


    @GetMapping( "/userauth/adPolicyList.do" )
    public ModelAndView adPolicyList( Model model , HttpSession session , HttpServletRequest req , HttpServletRequest res ) throws Exception{

        logger.debug( "###### /admin/userauth/adPolicyList.do start ######" );
        ModelAndView mv = new ModelAndView( "userauthset/adPolicyList" );


        logger.debug( "###### /admin/userauth/adPolicyList.do end ######" );
        return mv;
    }

    @GetMapping( "/userauth/adPolicy.data" )
    public @ResponseBody List< AdPolicyVO > adPolicyListData( Model model,
                                                              HttpSession session,
                                                              HttpServletRequest requset,
                                                              HttpServletResponse response) throws Exception{
        logger.debug( "###### /admin/userauth/adPolicyList.do start ######" );
        List< AdPolicyVO > AdPolicyList;
        AdPolicyVO adPolicyVO = new AdPolicyVO();

        logger.debug( "###### /admin/userauth/adPolicyList.do end ######" );
        return null;
    }

}
