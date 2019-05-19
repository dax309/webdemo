package cn.daxalfred.demo.Entity;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class ExamSubjectMiddleInfo {
    private Integer esmId;
    private ExamPaper examPaper;
    private SubjectInfo subject;

    public Integer getEsmId() {
        return esmId;
    }

    public void setEsmId(Integer esmId) {
        this.esmId = esmId;
    }

    public ExamPaper getExamPaper() {
        return examPaper;
    }

    public void setExamPaper(ExamPaper examPaper) {
        this.examPaper = examPaper;
    }

    public SubjectInfo getSubject() {
        return subject;
    }

    public void setSubject(SubjectInfo subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "ExamSubjectMiddleInfo{" +
                "esmId=" + esmId +
                ", examPaper=" + examPaper +
                ", subject=" + subject +
                '}';
    }
}
