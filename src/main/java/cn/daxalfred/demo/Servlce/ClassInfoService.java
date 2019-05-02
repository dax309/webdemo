package cn.daxalfred.demo.Servlce;

import cn.daxalfred.demo.Entity.PageInfo;
import cn.daxalfred.demo.Entity.Classinfo;

import java.util.List;

public interface ClassInfoService {
     List<Classinfo> selAllp();
     List<Classinfo> selAll(String pcode);
     PageInfo showPage(String pcode,int pageSize,int pageNumber);
     PageInfo selAlltwoByPage(int flower,int pageSize,int pageNumber);
     Classinfo selcode(String code);

}
