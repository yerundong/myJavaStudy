package JDBC.lib;

import java.util.Date;

public class LoginInfo {
    private int id;
    private String name;
    private String password;
    private int age;
    private Date birthday;

    public LoginInfo() {
    }

    public LoginInfo(int id, String name, String password, int age, Date birthday) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.age = age;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "LoginInfo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
