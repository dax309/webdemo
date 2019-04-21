package cn.daxalfred.demo.Contraller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RedirectContraller {

    @RequestMapping("/adminlogin")
    public String adminlogin(){
        return "adminindex";
    }

    @RequestMapping("/index")
    public String index(){

        return "index";
    }

    @RequestMapping("/play")
    public String play(){

        return "play";
    }
}
