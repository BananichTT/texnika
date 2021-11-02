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



public class SecondaryController {
    
    public static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany_texnika_jar_1.0-SNAPSHOTPU");
    public static EntityManager em = emf.createEntityManager();
    
    
    @FXML
    private TableView<Tovar> tovar;  
    @FXML
    private TableColumn<Tovar, String> nameColumn;
    @FXML
    private TableColumn<Tovar, String> typeColumn;
    @FXML
    private TableColumn<Tovar, String> costColumn;
    
    @FXML
    public void initialize(){
        Query q = em.createNamedQuery("Tovar.findAll");
        List<Tovar> tovarList = q.getResultList();
        
        for (Tovar t : tovarList) {
            System.out.println(t.getName());
        }

        nameColumn.setCellValueFactory((TableColumn.CellDataFeatures<Tovar, String> cd) -> {
            return new SimpleStringProperty(cd.getValue().getName());
        });
        
        typeColumn.setCellValueFactory((TableColumn.CellDataFeatures<Tovar, String> cd) -> {
            return new SimpleStringProperty(cd.getValue().getType());
        });
        
        costColumn.setCellValueFactory((TableColumn.CellDataFeatures<Tovar, String> cd) -> {
            return new SimpleStringProperty(cd.getValue().getCost());
        });
        
        ObservableList<Tovar> tovars = FXCollections.observableList(tovarList);
        tovar.setItems(tovars);
   }

            
    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }
}