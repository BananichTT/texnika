package com.mycompany.texnika;

import static com.mycompany.texnika.RegisterController.em;
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
import javafx.scene.control.TextField;



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
    private TextField tovarNameTextField;
    @FXML
    private TextField tovarTypeTextField;
    @FXML
    private TextField tovarCostTextField;
    
    @FXML
    public void initialize(){
        Query q = em.createNamedQuery("Tovar.findAll");
        List<Tovar> tovarList = q.getResultList();
        
//        for (Tovar t : tovarList) {
//            System.out.println(t.getName());
//        }

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
    private void addTovar() throws IOException{
        String tovarName = tovarNameTextField.getText();
        String tovarType = tovarTypeTextField.getText();
        String tovarCost = tovarCostTextField.getText();
        
        Tovar tovarIns = new Tovar();
        tovarIns.setName(tovarName);
        tovarIns.setType(tovarType);
        tovarIns.setCost(tovarCost);
        
        em.getTransaction().begin();
        em.persist(tovarIns);
        em.getTransaction().commit();
        
       tovarNameTextField.setText("");
       tovarTypeTextField.setText("");
       tovarCostTextField.setText("");
        
        initialize();
        
    }
    
    @FXML
    private void deleteTovar() throws IOException{
        
        Tovar t = tovar.getSelectionModel().getSelectedItem();
        System.out.println(t);
        em.getTransaction().begin();
        em.remove(t);
        em.getTransaction().commit();
        
        initialize(); 
    }
    
    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }
}