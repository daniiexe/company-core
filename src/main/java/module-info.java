module com.companycore.companycore {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires com.zaxxer.hikari;


    opens com.companycore to javafx.fxml;
    exports com.companycore;
}