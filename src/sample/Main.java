package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    public static final int TILE_SIZE = 100;


    private static Scene sceneLogin, sceneRegistration, sceneGame;

    public static Stage window;

    public static Scene getSceneGame() {
        return sceneGame;
    }

    public static Scene getSceneLogin() {
        return sceneLogin;
    }

    public static Scene getSceneRegistration() {
        return sceneRegistration;
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        sceneRegistration = new Scene(new Registration().getRegistration());
        sceneGame = new Scene(new Game().getGame());
        sceneLogin = new Scene(new Login().getLogin());
        sceneLogin.getStylesheets().add(getClass().getClassLoader().getResource("login.css").toExternalForm());
        sceneRegistration.getStylesheets().add(getClass().getClassLoader().getResource("login.css").toExternalForm());
        primaryStage.setScene(sceneLogin);
        primaryStage.show();
    }
}
