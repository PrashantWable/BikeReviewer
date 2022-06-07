module com.example.bikereviewer {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;

    opens com.example.bikereviewer to javafx.fxml;
    exports com.example.bikereviewer;
    exports com.example.bikereviewer.Controllers;
    opens com.example.bikereviewer.Controllers to javafx.fxml;
}