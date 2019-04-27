package cn.daxalfred.demo.Dao;


import cn.daxalfred.demo.Entity.classinfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ClassMapper {
    public List<classinfo> selAllp();
    public List<classinfo> selAll(String pcode);
    public List<classinfo> selAl();
}
