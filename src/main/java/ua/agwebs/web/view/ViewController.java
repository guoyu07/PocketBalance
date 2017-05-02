package ua.agwebs.web.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {

    @RequestMapping(value = {"/"})
    public String getLoginPage(){
        return "login";
    }

    @RequestMapping(value = {"/home"})
    public String getHome() {
        return "dashboard";
    }

    @RequestMapping(value = "/setting/account")
    public String getSettingAccountView(){
        return "accounts";
    }
}
