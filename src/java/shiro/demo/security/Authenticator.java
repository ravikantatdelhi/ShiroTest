/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package shiro.demo.security;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;




@Named
@SessionScoped
public class Authenticator implements  Serializable{

    private String name;
    private String password;

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


    public void login(){

        if(!SecurityUtils.getSubject().isAuthenticated()){
            try{
                SecurityUtils.getSubject().login(new UsernamePasswordToken(name, password));
            }
            catch(AuthenticationException ae){
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Login Failed!", "User Name or Password Worng!"));
              
            }
            catch(Exception ex){
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Login Failed!", "Error !!!"));
               
            }
     
        }
        
    }
    public String logout(){
        if(SecurityUtils.getSubject().isAuthenticated()){
            SecurityUtils.getSubject().logout();
        }
        return "homePage";
    }

    public boolean isLoggedIn(){
        return SecurityUtils.getSubject().isAuthenticated();
    }


}
