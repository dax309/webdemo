package cn.daxalfred.demo.Dao;


import cn.daxalfred.demo.Entity.SubjectInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SubjectInfoMapper {

    List<SubjectInfo> getSubjects(@Param("startIndex") int startIndex,@Param("pageShow") int pageShow);

    int getSubjectTotal();
    int isDelSubject(int ID);
    int isAddSubject(SubjectInfo subjectInfo);
    SubjectInfo getSubjectWithId(int ID);








}
