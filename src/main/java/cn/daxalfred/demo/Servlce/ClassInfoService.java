package cn.daxalfred.demo.Servlce;

import cn.daxalfred.demo.Entity.PageInfo;
import cn.daxalfred.demo.Entity.Classinfo;

import java.util.List;

public interface ClassInfoService {
     List<Classinfo> selAllp();
     List<Classinfo> selAll(String pcode);
     List<Classinfo> selAlltwo();
     PageInfo showPage(String pcode,int pageSize,int pageNumber);
}
