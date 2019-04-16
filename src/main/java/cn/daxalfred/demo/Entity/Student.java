package cn.daxalfred.demo.Entity;

import java.io.Serializable;
import java.util.Date;

public class Student implements Serializable {
    private int ID;
    private String username;
    private String password;
    private String gender;
    private Date birthday;
    private String email;
    private String realname;

    public Student() {

    }

    public Student(int ID, String username, String password, String gender, Date birthday, String email, String realname) {
        this.ID = ID;
        this.username = username;
        this.password = password;
        this.gender = gender;
        this.birthday = birthday;
        this.email = email;
        this.realname = realname;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    @Override
    public String toString() {
        return "Student{" +
                "ID=" + ID +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", gender='" + gender + '\'' +
                ", birthday=" + birthday +
                ", email='" + email + '\'' +
                ", realname='" + realname + '\'' +
                '}';
    }
}
