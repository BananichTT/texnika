module com.mycompany.texnika {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.persistence;
    requires java.sql;
    requires org.hibernate.orm.core;



    opens com.mycompany.texnika to javafx.fxml;
    opens com.mycompany.texnika.db;
    exports com.mycompany.texnika;
}
