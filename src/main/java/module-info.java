module com.companycore.companycore {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.companycore.companycore to javafx.fxml;
    exports com.companycore.companycore;
}