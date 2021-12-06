package com.mycompany.texnika;

import com.mycompany.texnika.db.User;
import com.mycompany.texnika.db.UserRole;
import java.io.IOException;
import javafx.fxml.FXML;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javax.persistence.Query;

public class RegisterController {

    @FXML
    private TextField userLoginTextField;

    @FXML
    private TextField userNameTextField;

    @FXML
    private PasswordField userPasswordField;

    @FXML
    private Label error;

    public static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany_texnika_jar_1.0-SNAPSHOTPU");
    public static EntityManager em = emf.createEntityManager();

    @FXML
    private void switchBack() throws IOException {
        App.setRoot("primary");
    }

    @FXML
    private void registerUser() throws IOException {

        String username = userNameTextField.getText();
        String userlogin = userLoginTextField.getText();
        String userpassword = userPasswordField.getText();

        Query q = em.createNamedQuery("Userrole.findByRoleName");
        q.setParameter("roleName", "user");
        UserRole rol = (UserRole) q.getSingleResult();
        
        if (username.isEmpty() || userlogin.isEmpty() || userpassword.isEmpty()) {
            System.out.println("Пустые поля");
        } else {
            em.getTransaction().begin();

            User user = new User();
            user.setLogin(userlogin);
            user.setPassword(userpassword);
            user.setName(username);
            user.setRoleId(rol);

            em.persist(user);
            em.getTransaction().commit();

            System.out.println("user name: " + username);
            System.out.println("user login: " + userlogin);
            System.out.println("user pass: " + userpassword);

            App.setRoot("primary");
        }
    }
}
