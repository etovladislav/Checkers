package sample;

import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import static sample.Main.window;


/**
 * Created by etovladislav on 30.05.16.
 */
public class Registration {

    String user = "admin";
    String pw = "1234";
    String checkUser, checkPw;

    public BorderPane getRegistration() {

        Main.window.setTitle("Registration");
        Main.window.setResizable(false);

        BorderPane bp = new BorderPane();
        bp.setPadding(new Insets(10, 50, 50, 50));

        HBox hb = new HBox();
        hb.setPadding(new Insets(20, 20, 20, 30));

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(20, 20, 20, 20));
        gridPane.setHgap(5);
        gridPane.setVgap(5);

        Label lblUserName = new Label("Username");
        final TextField txtUserName = new TextField();
        Label lblPassword = new Label("Password");
        final PasswordField pf = new PasswordField();
        Label lblCPassword = new Label("Confirm password");
        final PasswordField cpf = new PasswordField();
        Button btnLogin = new Button("Login");
        Button btnRegistration = new Button("Registration");

        final Label lblMessage = new Label();

        gridPane.add(lblUserName, 0, 0);
        gridPane.add(txtUserName, 1, 0);
        gridPane.add(lblPassword, 0, 1);
        gridPane.add(pf, 1, 1);
        gridPane.add(lblCPassword, 0, 2);
        gridPane.add(cpf, 1, 2);
        gridPane.add(btnRegistration, 1, 4);
        gridPane.add(btnLogin, 1, 5);
        gridPane.add(lblMessage, 1, 6);


        Reflection r = new Reflection();
        r.setFraction(0.7f);
        gridPane.setEffect(r);

        DropShadow dropShadow = new DropShadow();
        dropShadow.setOffsetX(5);
        dropShadow.setOffsetY(5);

        Text text = new Text("Registration");
        text.setFont(Font.font("Courier New", FontWeight.BOLD, 38));
        text.setEffect(dropShadow);
        hb.getChildren().add(text);

        bp.setId("bp");
        gridPane.setId("root");
        btnLogin.setId("btnLogin");
        btnRegistration.setId("btnLogin");
        text.setId("text");

        btnRegistration.setOnAction(event -> {
            checkUser = txtUserName.getText().toString();
            checkPw = pf.getText().toString();
            if (checkUser.equals(user) && checkPw.equals(pw)) {
                lblMessage.setText("Огонь!");
                lblMessage.setTextFill(Color.GREEN);

            } else {
                lblMessage.setText("Ошибка");
                lblMessage.setTextFill(Color.RED);
            }
            txtUserName.setText("");
            pf.setText("");
        });
        btnLogin.setOnAction(event -> {
            window.setScene(Main.getSceneLogin());
        });
        //Add HBox and GridPane layout to BorderPane Layout
        bp.setTop(hb);
        bp.setCenter(gridPane);
        return bp;
    }
}
