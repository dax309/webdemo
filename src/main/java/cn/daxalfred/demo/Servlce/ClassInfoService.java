package cn.daxalfred.demo.Servlce;

import cn.daxalfred.demo.Entity.PageInfo;
import cn.daxalfred.demo.Entity.Classinfo;
import cn.daxalfred.demo.Entity.notice;

import java.util.List;

public interface ClassInfoService {
     List<Classinfo> selAllp();
     List<Classinfo> selAll(String pcode);
     PageInfo showPage(String pcode,int pageSize,int pageNumber);
     PageInfo selAlltwoByPage(int flower,int pageSize,int pageNumber);
     Classinfo selcode(String code);
    List<Classinfo> selflowerone(String pcode);
     List<Classinfo> sellflower();
     String getclassinfobyid(int a);

    List<Classinfo> presellflower();

    List<notice> selallnotices();

    List<Classinfo> selallpbycode(String code);

    int learnhistory(int id,int studentid);

    int sellearnhistory(int parseInt);

    String getdownfile(int parseInt);
}
