module com.masanz.mylogin {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.masanz.rr5.controladores to javafx.fxml;
    exports com.masanz.rr5;
}