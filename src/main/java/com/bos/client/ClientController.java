package com.bos.client;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ClientController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/login-redirect")
    public String loginRedirect() {
        return "login_redirect";
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/check-token")
    public AccessToken tokenExpire(AccessToken accessToken) {
        return accessToken;
    }

  /*  @GetMapping("/")
    public ModelAndView authCode(
            ModelAndView mav,
            @RequestParam(required = true) String code,
            @RequestParam(required = false) String state
    ) {
        System.out.println("code: " + code);
        System.out.println("state: " + state);
        mav.addObject("authInfo", code);
        mav.setViewName("authcode");
        return mav;
    }
*/
}
