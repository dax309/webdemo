package cn.daxalfred.demo.Entity;

public class Admin {
    private Integer ID;
    private String username;
    private String realname;
    private String password;
    private int adminPower;

    public Admin() {

    }

    public Admin(Integer ID, String username, String realname, String password, int adminPower) {
        this.ID = ID;
        this.username = username;
        this.realname = realname;
        this.password = password;
        this.adminPower = adminPower;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAdminPower() {
        return adminPower;
    }

    public void setAdminPower(int adminPower) {
        this.adminPower = adminPower;
    }


    @Override
    public String toString() {
        return "Admin{" +
                "ID=" + ID +
                ", username='" + username + '\'' +
                ", realname='" + realname + '\'' +
                ", password='" + password + '\'' +
                ", adminPower=" + adminPower +
                '}';
    }
}
