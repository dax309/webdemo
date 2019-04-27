package cn.daxalfred.demo.Servlce;

import cn.daxalfred.demo.Entity.classinfo;

import java.util.List;

public interface ClassInfoService {
    public List<classinfo> selAllp();
    public List<classinfo> selAll( String pcode);
    public List<classinfo> selAl();
}
