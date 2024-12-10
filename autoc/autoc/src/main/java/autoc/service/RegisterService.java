package autoc.service;

public class RegisterService {
    private String username;
    private String password;
    private String telephone;

    public void register() {
        System.out.println("register success!this is you account profile");
        System.out.println("username:" + username);
        System.out.println("password:" + password);
        System.out.println("telephone:" + telephone);
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

    public String getTelephone() {
        return this.telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

}
