package com.mycompany.texnika;

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
       TextField username = (TextField) u;
       
       Node p = App.getRoot().lookup("#password");
       TextField password = (TextField) p; 
    }
}
