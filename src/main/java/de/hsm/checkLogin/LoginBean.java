package de.hsm.checkLogin;

import java.io.IOException;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component(value = "checkloginloginBean")
@SessionScope
public class LoginBean implements Serializable{

    public LoginBean() {
    }

    private String username;
    private boolean loggedin = false;

    public boolean isLoggedin() {
        return loggedin;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String login() {
        if (username.equals("admin")) {
            loggedin = true;
        }
        if (loggedin) {
            return "page1.xhtml";
        }
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid Login", "Invalid Login");
        FacesContext.getCurrentInstance().addMessage("form", msg);
        return "/checkLogin/login.xhtml";
    }
    
    public String logout() {
        loggedin = false;
        username = null;
        return "/checkLogin/login.xhtml";
    }

    public void checkLogin() {
        ExternalContext context2 = FacesContext.getCurrentInstance().getExternalContext();
        if (!loggedin) {
            try {
                context2.redirect("/checkLogin/login.xhtml");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
