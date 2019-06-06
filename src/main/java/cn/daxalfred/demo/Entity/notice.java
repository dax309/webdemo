package cn.daxalfred.demo.Entity;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;

@Component
public class notice implements Serializable {
    private int ID;
    private String title;
    private String address;
    private Date createtime;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public notice(int ID, String title, String address, Date createtime) {
        this.ID = ID;
        this.title = title;
        this.address = address;
        this.createtime = createtime;
    }

    public notice() {
    }

    @Override
    public String toString() {
        return "notice{" +
                "ID=" + ID +
                ", title='" + title + '\'' +
                ", address='" + address + '\'' +
                ", createtime=" + createtime +
                '}';
    }
}
