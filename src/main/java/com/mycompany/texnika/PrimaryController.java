package com.mycompany.texnika;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class PrimaryController {

    @FXML
    private void switchToSecondary() throws IOException {
       Node user = App.getRoot().lookup("#username");
       TextField username = (TextField) user;
       
       Node pass = App.getRoot().lookup("#password");
       TextField password = (TextField) pass;
       
       Label err = (Label) App.getRoot().lookup("#error");
       
       if((username.getText().equals("Sany")) && (password.getText().equals("123"))){
        err.setText("");
        App.setRoot("secondary");
       }else{
        err.setText("Неверный логин или пароль!");
       }
    }
}
