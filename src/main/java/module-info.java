module com.mycompany.texnika {
    requires javafx.controls;
    requires javafx.fxml;
    requires javax.persistence;

    opens com.mycompany.texnika to javafx.fxml;
    exports com.mycompany.texnika;
}
