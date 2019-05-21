package cn.daxalfred.demo.Entity;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class ExamChoose {
    private Integer chooseId;
    private Integer studentId;
    private Integer examPaperId;
    private Integer subjectId;
    private String chooseResult;

    public ExamChoose() {
    }

    public ExamChoose(Integer chooseId, Integer studentId, Integer examPaperId, Integer subjectId, String chooseResult) {
        this.chooseId = chooseId;
        this.studentId = studentId;
        this.examPaperId = examPaperId;
        this.subjectId = subjectId;
        this.chooseResult = chooseResult;
    }

    public Integer getChooseId() {
        return chooseId;
    }

    public void setChooseId(Integer chooseId) {
        this.chooseId = chooseId;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getExamPaperId() {
        return examPaperId;
    }

    public void setExamPaperId(Integer examPaperId) {
        this.examPaperId = examPaperId;
    }

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    public String getChooseResult() {
        return chooseResult;
    }

    public void setChooseResult(String chooseResult) {
        this.chooseResult = chooseResult;
    }

    @Override
    public String toString() {
        return "ExamChoose{" +
                "chooseId=" + chooseId +
                ", studentId=" + studentId +
                ", examPaperId=" + examPaperId +
                ", subjectId=" + subjectId +
                ", chooseResult='" + chooseResult + '\'' +
                '}';
    }
}
