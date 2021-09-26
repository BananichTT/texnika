package com.mycompany.texnika;

import com.mycompany.texnika.db.Role;
import com.mycompany.texnika.db.User;
import java.io.IOException;
import javafx.fxml.FXML;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javafx.scene.Node;
import javafx.scene.control.TextField;

public class RegisterController {
    public static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany_texnika_jar_1.0-SNAPSHOTPU");
    public static EntityManager em = emf.createEntityManager();

    @FXML
    private void switchBack() throws IOException {
        App.setRoot("primary");
    }
    
    @FXML
    private void registerUser () throws IOException {
       Node u = App.getRoot().lookup("#username");
       TextField usern = (TextField) u;
       
       Node l = App.getRoot().lookup("#userlogin");
       TextField userl = (TextField) l; 
       
       Node p = App.getRoot().lookup("#password");
       TextField userp = (TextField) p; 
       
       
       
       String username = usern.getText();
       String userlogin = userl.getText();
       String userpassword = userp.getText();        
       
       System.out.println("user name: "+ username);
       System.out.println("user login: "+ userlogin);
       System.out.println("user pass: "+ userpassword);
       
       /* неработающая регистрация
       
       String name = "sanf";

        User user = new User();
        user.setIdUser(1);
        user.setLogin(userlogin);
        user.setPassword(userpassword);
        user.setName(name);
        
        
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();*/
       
    }
}
