module com.login.login {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens com.login.login to javafx.fxml;
    exports com.login.login;
}