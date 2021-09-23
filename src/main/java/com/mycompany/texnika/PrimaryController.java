package com.mycompany.texnika;

import com.mycompany.texnika.db.Users;
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

       Query q = em.createNamedQuery("Users.findUser");
        q.setParameter("login", username.getText()); // присваиваем логин
        q.setParameter("password", password.getText()); // присваиваем пароль
        Users user = (Users) q.getSingleResult(); // проверяем на наличие пользователя в таблице
        App.setRoot("secondary");
        System.out.println("user: " + user);

        
       /*if((username.getText().equals("Sany")) && (password.getText().equals("123"))){
        err.setText("");
        App.setRoot("secondary");
       }else{
        err.setText("Неверный логин или пароль!");
       }
    }*/
}
}
