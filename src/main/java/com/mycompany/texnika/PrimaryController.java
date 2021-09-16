package com.mycompany.texnika;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;

public class PrimaryController {

    @FXML
    private void switchToSecondary() throws IOException {
       Node user = App.getRoot().lookup("#username");
       TextField username = (TextField) user;
       
       Node pass = App.getRoot().lookup("#password");
       TextField password = (TextField) pass;

       
       if((username.getText().equals("Sany")) && (password.getText().equals("123"))){
        App.setRoot("secondary");
        System.out.println("SUCCESSFUL");
       }else{
        System.out.println("EROOR: PASSWORD OR USERNAME");
       }
    }
}
