package cn.daxalfred.demo.Entity;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;

@Component
@Scope("prototype")
public class Words implements Serializable {
    private int ID;
    private int UID;
    private String Uname;
    private Date date;
    private String content;
    private int ClassID;
    private int wordsType;

    public Words() {
    }

    public Words(int ID, int UID, String uname, Date date, String content, int classID, int wordsType) {
        this.ID = ID;
        this.UID = UID;
        Uname = uname;
        this.date = date;
        this.content = content;
        ClassID = classID;
        this.wordsType = wordsType;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getUID() {
        return UID;
    }

    public void setUID(int UID) {
        this.UID = UID;
    }

    public String getUname() {
        return Uname;
    }

    public void setUname(String uname) {
        Uname = uname;
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

    public int getClassID() {
        return ClassID;
    }

    public void setClassID(int classID) {
        ClassID = classID;
    }

    public int getWordsType() {
        return wordsType;
    }

    public void setWordsType(int wordsType) {
        this.wordsType = wordsType;
    }

    @Override
    public String toString() {
        return "Words{" +
                "ID=" + ID +
                ", UID=" + UID +
                ", Uname='" + Uname + '\'' +
                ", date=" + date +
                ", content='" + content + '\'' +
                ", ClassID=" + ClassID +
                ", wordsType=" + wordsType +
                '}';
    }
}
