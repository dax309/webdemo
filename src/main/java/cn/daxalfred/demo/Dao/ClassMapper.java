package cn.daxalfred.demo.Dao;


import cn.daxalfred.demo.Entity.Classinfo;
import cn.daxalfred.demo.Entity.learnhistory;
import cn.daxalfred.demo.Entity.notice;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ClassMapper {
     List<Classinfo> selAllp();
     List<Classinfo> selAll(String pcode);
     List<Classinfo> selByPage(@Param("pcode") String pcode,@Param("pageStart") int pageStart, @Param("pageSize") int pageSize);
     long selCount(@Param("pcode") String pcode);
     List<Classinfo> selAlltwoByPage(@Param("flower") int flower, @Param("pageStart") int pageStart, @Param("pageSize") int pageSize);
     long seltwoCount();
     Classinfo selcode(String code);
     Classinfo selone(String pcode);
     List<Classinfo> sellflower(int flower);
     List<Classinfo> selallname();
     String getclassinfobyid(int a);
    List<notice> selallnotices();
    List<Classinfo> selAllpbycode(String code);
    int learnhistory(@Param("ClassID") int id,@Param("UserID") int studentid);
    int sellearinhistory(int studentid);
    int updatelearnhistory(@Param("ClassID")int id,@Param("UserID") int studentid);
    learnhistory  sellearnhistory(int parseInt);

    String getdownfile(int parseInt);
}
