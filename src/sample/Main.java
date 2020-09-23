package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
    FrontPage front = new FrontPage();
    primaryStage.setScene(new Scene(front, 1200,1000));
    primaryStage.show();
    }

    public static void main(String[] args) {

        launch(args);
    }
}
