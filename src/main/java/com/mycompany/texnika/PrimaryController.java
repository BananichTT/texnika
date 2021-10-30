package com.mycompany.texnika;

import com.mycompany.texnika.db.User;
import com.mycompany.texnika.db.Userrole;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class PrimaryController {
    
    @FXML
    private TextField userLoginTextField;
    
    @FXML
    private PasswordField userPasswordField;
    
    @FXML
    private Label error;

    public static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany_texnika_jar_1.0-SNAPSHOTPU");
    public static EntityManager em = emf.createEntityManager();

    @FXML
    private void switchToSecondary() throws IOException {

        Query q = em.createNamedQuery("User.findByLogin");
        String userlogin = userLoginTextField.getText();
        String userpassword = userPasswordField.getText();

        q.setParameter("login", userlogin); // присваиваем логин

        try {
            User user = (User) q.getSingleResult();

            if (user.getPassword().equals(userpassword)) {
                error.setText("");
                Userrole role = user.getRoleId();
                if(role.getRoleName().equals("user")){
                    App.setRoot("secondary");
                }
            } else {
                error.setText("Неверный логин или пароль!");
            }
        } catch (NoResultException e) {
            error.setText("Неверный логин или пароль!");
        }

    }

    @FXML
    private void switchToRegist() throws IOException {
        App.setRoot("register");
    }
}
