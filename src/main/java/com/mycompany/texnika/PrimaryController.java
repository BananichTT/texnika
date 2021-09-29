package com.mycompany.texnika;


import com.mycompany.texnika.db.User;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class PrimaryController {
    public static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany_texnika_jar_1.0-SNAPSHOTPU");
    public static EntityManager em = emf.createEntityManager();
    
    @FXML
    private void switchToSecondary() throws IOException {
       Node u = App.getRoot().lookup("#username");
       TextField username = (TextField) u;
       
       Node p = App.getRoot().lookup("#password");
       TextField password = (TextField) p;
       
       Label err = (Label) App.getRoot().lookup("#error");

       Query q = em.createNamedQuery("User.findByLogin");
       String userlogin = username.getText();
       String userpassword = password.getText();
       
        q.setParameter("login", userlogin); // присваиваем логин
        User user = (User) q.getSingleResult(); 

        if(user == null){
            err.setText("Неверный логин или пароль!");
        }else{
            if(userpassword == null){
                err.setText("Неверный логин или пароль!");
            }else{
                if(user.getPassword().equals(userpassword)){
                err.setText("");
                App.setRoot("secondary");
            }
            err.setText("Неверный логин или пароль!");
            
            }
        }
    }
    
       @FXML
    private void switchToRegist() throws IOException {
        App.setRoot("register");
    }
}
