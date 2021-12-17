package JDBC.lib;

public class LoginInfo_statement {
    private String user;
    private String password;

    public void setUser(String user) {
        this.user = user;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "LoginInfo_statement{" +
                "user='" + user + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
