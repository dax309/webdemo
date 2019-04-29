package cn.daxalfred.demo.Contraller;

import cn.daxalfred.demo.Entity.Classinfo;
import cn.daxalfred.demo.Entity.PageInfo;
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
        List<Classinfo> list = classInfoService.selAllp();
        request.setAttribute("list",list);
        return "/class/classdir";
    }

    /*获取子目录*/
    @RequestMapping("/classinfos")
    @ResponseBody
    public PageInfo classinfos(HttpServletRequest request){
        String pcode = request.getParameter("pcode");
        PageInfo pageInfo = null;
        if(pcode.equals("all")){
          pageInfo = classInfoService.selAlltwoByPage(1,5,1);
        }
        return pageInfo;
    }
}
