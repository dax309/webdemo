package cn.daxalfred.demo.Dao;


import cn.daxalfred.demo.Entity.Classinfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ClassMapper {
     List<Classinfo> selAllp();
     List<Classinfo> selAll(String pcode);
     List<Classinfo> selAlltwo();
     List<Classinfo> selByPage(@Param("pcode") String pcode,@Param("pageStart") int pageStart, @Param("pageSize") int pageSize);
     long selCount();
}
