/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.texnika;
import com.mycompany.texnika.db.Tovar;
import java.io.IOException;
import java.util.List;
import javafx.fxml.FXML;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;


public class UserController {
    
    public static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany_texnika_jar_1.0-SNAPSHOTPU");
    public static EntityManager em = emf.createEntityManager();
    
    @FXML
    private TableView<Tovar> tovarUser;  
    @FXML
    private TableColumn<Tovar, String> UsernameColumn;
    @FXML
    private TableColumn<Tovar, String> UsertypeColumn;
    @FXML
    private TableColumn<Tovar, String> UsercostColumn;
    
    
    @FXML
    public void initializeUser(){
        Query q = em.createNamedQuery("Tovar.findAll");
        List<Tovar> tovarList = q.getResultList();
        

        UsernameColumn.setCellValueFactory((TableColumn.CellDataFeatures<Tovar, String> cd) -> {
            return new SimpleStringProperty(cd.getValue().getName());
        });
        
        UsertypeColumn.setCellValueFactory((TableColumn.CellDataFeatures<Tovar, String> cd) -> {
            return new SimpleStringProperty(cd.getValue().getType());
        });
        
        UsercostColumn.setCellValueFactory((TableColumn.CellDataFeatures<Tovar, String> cd) -> {
            return new SimpleStringProperty(cd.getValue().getCost());
        });
        
        ObservableList<Tovar> tovars = FXCollections.observableList(tovarList);
        tovarUser.setItems(tovars);
   }
    
    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }
}
