package com.mycompany.texnika;

import java.io.IOException;
import javafx.fxml.FXML;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class SecondaryController {
    
    public static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany_texnika_jar_1.0-SNAPSHOTPU");
    public static EntityManager em = emf.createEntityManager();

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }
}