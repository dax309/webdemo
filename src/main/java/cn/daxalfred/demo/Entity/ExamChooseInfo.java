package cn.daxalfred.demo.Entity;


import org.springframework.stereotype.Component;

@Component
public class ExamChooseInfo {


        private Integer chooseId;
        private Student student;
        private ExamPaper examPaper;
        private SubjectInfo subject;
        private String chooseResult;

    public Integer getChooseId() {
        return chooseId;
    }

    public void setChooseId(Integer chooseId) {
        this.chooseId = chooseId;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
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

    public String getChooseResult() {
        return chooseResult;
    }

    public void setChooseResult(String chooseResult) {
        this.chooseResult = chooseResult;
    }

    @Override
        public String toString() {
            return "ExamChooseInfo [chooseId=" + chooseId + ", student=" + student
                    + ", examPaper=" + examPaper + ", subject=" + subject
                    + ", chooseResult=" + chooseResult + "]";
        }
}
