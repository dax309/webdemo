package cn.daxalfred.demo.Contraller;


import cn.daxalfred.demo.Servlce.Impl.WordsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@Controller
public class WordsContraller {

    @Autowired
    private WordsServiceImpl wordsService;

    @PostMapping("/saveWords")
    public void saveWords(
            @RequestParam("classID") int classId,
            @RequestParam("UID")  int UID,
            @RequestParam("wordstype")  int wordstype,
            @RequestParam("contentwords")  String contentwords,
            HttpServletResponse response
            ) throws IOException {
        response.setCharacterEncoding("UTF-8");
        Date date = new Date();
        int i = wordsService.wordsadd(UID, date, contentwords, classId, wordstype);
        boolean flag = false;
        if (i>=1){
            flag = true;
        }
        String json = "{\"flag\":" + flag + "}";
        response.getWriter().write(json);
    }

    @PostMapping("/atreplyWords")
    public void replyWords(
            @RequestParam("rclassID") int classId,
            @RequestParam("rUID")  int UID,
            @RequestParam("rwordstype")  int wordstype,
            @RequestParam("rcontentwords")  String content,
            @RequestParam("replyID")  int replyID,
            HttpServletResponse response
    ) throws IOException {
        response.setCharacterEncoding("UTF-8");
        Date date = new Date();
        int i = wordsService.replywords(UID,date,content,classId,wordstype,replyID);
        boolean flag = false;
        if (i>=1)
            flag = true;
        String json = "{\"flag\":" + flag + "}";
        response.getWriter().write(json);
    }

}
