package cn.daxalfred.demo.Contraller;

import cn.daxalfred.demo.Entity.Classinfo;
import cn.daxalfred.demo.Entity.PageInfo;
import cn.daxalfred.demo.Servlce.ClassInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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
    @PostMapping("/classinfos")
    @ResponseBody
    public PageInfo classinfos(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String pcode = request.getParameter("pcode");
        String pageNumber = request.getParameter("pageNumber");
        PageInfo pageInfo = null;
        int Number;
        if(pageNumber==null){
            Number = 1;
        }else {
            Number = Integer.parseInt(pageNumber);
        }

        if(pcode.equals("all")){
            pageInfo = classInfoService.selAlltwoByPage(
                            2, 5, Number);
        }else {
            pageInfo = classInfoService.showPage(pcode,5,Number);
        }
        return pageInfo;
    }
}
