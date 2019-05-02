package cn.daxalfred.demo.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class Classinfo implements Serializable {
    private int ID;
    private String name;
    private String code;
    private String pcode;
    private int flower;
    private int sort;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createtime;
    private int createuser;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date updatetime;
    private int updateuser;
    private String videoaddress;
    private int del;

    public Classinfo() {
    }

    public Classinfo(int ID, String name, String code, String pcode, int flower, int sort, Date createtime, int createuser, Date updatetime, int updateuser, String videoaddress, int del) {
        this.ID = ID;
        this.name = name;
        this.code = code;
        this.pcode = pcode;
        this.flower = flower;
        this.sort = sort;
        this.createtime = createtime;
        this.createuser = createuser;
        this.updatetime = updatetime;
        this.updateuser = updateuser;
        this.videoaddress = videoaddress;
        this.del = del;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPcode() {
        return pcode;
    }

    public void setPcode(String pcode) {
        this.pcode = pcode;
    }

    public int getFlower() {
        return flower;
    }

    public void setFlower(int flower) {
        this.flower = flower;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public int getCreateuser() {
        return createuser;
    }

    public void setCreateuser(int createuser) {
        this.createuser = createuser;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public int getUpdateuser() {
        return updateuser;
    }

    public void setUpdateuser(int updateuser) {
        this.updateuser = updateuser;
    }

    public String getVideoaddress() {
        return videoaddress;
    }

    public void setVideoaddress(String videoaddress) {
        this.videoaddress = videoaddress;
    }

    public int getDel() {
        return del;
    }

    public void setDel(int del) {
        this.del = del;
    }


    @Override
    public String toString() {
        return "Classinfo{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", pcode='" + pcode + '\'' +
                ", flower=" + flower +
                ", sort=" + sort +
                ", createtime=" + createtime +
                ", createuser=" + createuser +
                ", updatetime=" + updatetime +
                ", updateuser=" + updateuser +
                ", videoaddress='" + videoaddress + '\'' +
                ", del=" + del +
                '}';
    }
}
