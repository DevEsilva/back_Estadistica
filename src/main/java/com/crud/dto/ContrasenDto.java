package com.crud.dto;

/**
 * @author silvae
 */
public class ContrasenDto {

    private String user;

    private String password;

    private String newpassword;

    private String repeatnewpassword;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNewpassword() {
        return newpassword;
    }

    public void setNewpassword(String newpassword) {
        this.newpassword = newpassword;
    }

    public String getRepeatnewpassword() {
        return repeatnewpassword;
    }

    public void setRepeatnewpassword(String repeatnewpassword) {
        this.repeatnewpassword = repeatnewpassword;
    }

}
