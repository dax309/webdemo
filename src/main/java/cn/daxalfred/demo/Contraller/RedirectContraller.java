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


    /*学生*/

    //个人中心
    @RequestMapping("/studentinfo")
    public String studentinfo(){
        return "/student/infoindex";
    }




    /*管理员*/

    //管理员主页
    @RequestMapping("/admin")
    public String admin(){
        return "/admin/index";
    }




    /*课程*/

    @RequestMapping("/classinfofrower")
    public String classinfofrower(){
        return "/class/classInfo";
    }



    @RequestMapping("/Compiler")
    public String Compiler(){
        return "/Compiler/CompilerIndex";
    }

}
