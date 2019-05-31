package cn.daxalfred.demo.Entity;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Scope("prototype")
public class Replywords {
    private int ID;
    private int SID;
    private String Sname;
    private Date date;
    private String content;
    private int replyID;
    private int classID;
    private int replyType;

    public Replywords() {
    }

    public Replywords(int ID, int SID, String sname, Date date, String content, int replyID, int classID, int replyType) {
        this.ID = ID;
        this.SID = SID;
        Sname = sname;
        this.date = date;
        this.content = content;
        this.replyID = replyID;
        this.classID = classID;
        this.replyType = replyType;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getSID() {
        return SID;
    }

    public void setSID(int SID) {
        this.SID = SID;
    }

    public String getSname() {
        return Sname;
    }

    public void setSname(String sname) {
        Sname = sname;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getReplyID() {
        return replyID;
    }

    public void setReplyID(int replyID) {
        this.replyID = replyID;
    }

    public int getClassID() {
        return classID;
    }

    public void setClassID(int classID) {
        this.classID = classID;
    }

    public int getReplyType() {
        return replyType;
    }

    public void setReplyType(int replyType) {
        this.replyType = replyType;
    }

    @Override
    public String toString() {
        return "Replyworods{" +
                "ID=" + ID +
                ", SID=" + SID +
                ", Sname='" + Sname + '\'' +
                ", date=" + date +
                ", content='" + content + '\'' +
                ", replyID=" + replyID +
                ", classID=" + classID +
                ", replyType=" + replyType +
                '}';
    }
}
