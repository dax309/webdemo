package cn.daxalfred.demo.Servlce;

import cn.daxalfred.demo.Entity.SubjectInfo;

import java.util.List;

public interface SubjectInfoService {

    List<SubjectInfo> getSubjects(int startIndex,int pageShow);
    int getSubjectTotal();
    int isDelSubject(int ID);

    int isAddSubject(SubjectInfo subjectInfo);

    SubjectInfo getSubjectWithId(int ID);
}
