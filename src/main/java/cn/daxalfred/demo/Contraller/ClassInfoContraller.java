package cn.daxalfred.demo.Contraller;


import cn.daxalfred.demo.Entity.classinfo;
import cn.daxalfred.demo.Servlce.ClassInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class ClassInfoContraller {

    @Autowired
    private ClassInfoService classInfoService;

    @RequestMapping("/classdir")
    public String classdir(HttpServletRequest request){
        List<classinfo> list = classInfoService.selAllp();
        request.setAttribute("list",list);
        return "/class/classdir";
    }


    /*获取子目录*/
    @RequestMapping("/classinfos")
    @ResponseBody
    public List<classinfo> classinfos(HttpServletRequest request){
        return classInfoService.selAll(request.getParameter("pcode"));
    }
}
