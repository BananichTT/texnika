package com.mycompany.texnika;

import java.io.IOException;
import javafx.fxml.FXML;

public class RegisterController {

    @FXML
    private void switchBack() throws IOException {
        App.setRoot("primary");
    }
}
