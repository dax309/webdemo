package cn.daxalfred.demo.Entity;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class ExamSubjectMiddle {
    private Integer esmId;
    private int examPaperid;
    private int subjectid;

    public ExamSubjectMiddle() {
    }

    public ExamSubjectMiddle(Integer esmId, int examPaperid, int subjectid) {
        this.esmId = esmId;
        this.examPaperid = examPaperid;
        this.subjectid = subjectid;
    }

    public Integer getEsmId() {
        return esmId;
    }

    public void setEsmId(Integer esmId) {
        this.esmId = esmId;
    }

    public int getExamPaperid() {
        return examPaperid;
    }

    public void setExamPaperid(int examPaperid) {
        this.examPaperid = examPaperid;
    }

    public int getSubjectid() {
        return subjectid;
    }

    public void setSubjectid(int subjectid) {
        this.subjectid = subjectid;
    }

    @Override
    public String toString() {
        return "ExamSubjectMiddle{" +
                "esmId=" + esmId +
                ", examPaperid=" + examPaperid +
                ", subjectid=" + subjectid +
                '}';
    }
}
