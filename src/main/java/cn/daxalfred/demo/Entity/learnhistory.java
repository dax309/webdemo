package cn.daxalfred.demo.Entity;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class learnhistory {
    private int ID;
    private int UserID;
    private int ClassID;

    public learnhistory(int ID, int userID, int classID) {
        this.ID = ID;
        UserID = userID;
        ClassID = classID;
    }

    public learnhistory() {
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int userID) {
        UserID = userID;
    }

    public int getClassID() {
        return ClassID;
    }

    public void setClassID(int classID) {
        ClassID = classID;
    }

    @Override
    public String toString() {
        return "learnhistory{" +
                "ID=" + ID +
                ", UserID=" + UserID +
                ", ClassID=" + ClassID +
                '}';
    }
}
