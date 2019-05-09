package cn.daxalfred.demo.Contraller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

@Controller
public class CompilerContraller {

    private static   String savefile = "E:/test.py";

    @RequestMapping("/editorcode")
    public void editorcode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("GBK");
        String code = request.getParameter("code");
        FileWriter fwriter = null;
        try {
            fwriter = new FileWriter(savefile);
            fwriter.write(code.replace("\n", "\r\n"));
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                fwriter.flush();
                fwriter.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        Process proc;
        String line = null;
        String msg="";
        try {
            proc = Runtime.getRuntime().exec("D:/Python36/python.exe "+savefile);// 执行py文件
            //用输入输出流来截取结果
            BufferedReader in = new BufferedReader(new InputStreamReader(proc.getInputStream(),Charset.forName("GBK")));
            while ((line = in.readLine()) != null) {
                msg+=line;
            }
            in.close();
            proc.waitFor();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        msg =new String(msg.getBytes(),"UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(msg);
    }

}
